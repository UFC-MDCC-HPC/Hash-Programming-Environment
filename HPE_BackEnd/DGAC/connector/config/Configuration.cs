/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using System.Runtime.CompilerServices;
using System.Collections.Generic;
using System.Runtime.Serialization;

using  br.ufc.pargo.hpe.connector.monitoring;

//PARAMETROS DE CONTEXTO.
//CONTER TODAS AS INFORMAÇOES QUE ESTAO NA HCL. Por exemplo, up.
//LEMBRAR DAS RETRICOES DOS COMPONENTES COM ESTADO.

namespace br.ufc.pargo.hpe.connector.config {
   
   //Representação do autômato de execução de uma ação descrita em HCL.
   
   /*
   A função de execução é representada pela matriz bi-dimensional de nome "matrix".
   Cada linha da matrix simboliza um estado. Cada estado possúi um grupo de transições, cada qual ocupando
   duas posições no vetor. A primeira é o RUNNABLE, que contém o índice da ação a ser executada. Este índice
   aponta para o array de MetaAction "_actions". Já a segunda posição é TARGET_STATE, indicado a qual estado
   esta transição leva.
   
   Um estado pode ter várias transições, sempre em pares.
   */
   
   public class Configuration : MarshalByRefObject, IMonitorable {
      
      //por convenção o estado 0 será sempre o estado inicial.
      public static readonly int INITIAL_STATE = 0;
      
      //por convenção o estado 1 será sempre o estado final.
      public static readonly int FINAL_STATE = 1;
      
      //Quantidade de informações de cada transição.
      //Atualmente cada transição tem 2 informações inteiras.
      public static readonly int BASE = 2;
      
      //Posição no array de estados que indica o índice de uma ação.
      public static readonly int RUNNABLE = 0;
      
      //Posição no array de estados que indica o índice do estado destino.
      public static readonly int TARGET_STATE = 1;
      
      //Define um estado final do autômato. Esta constante deverá ser indicada na posição RUNNABLE
      //da primeira transição do estado final.
      public static readonly int END = -1;
      
      //Define uma informação vazia. Usado para criar transições de valor null.
      public static readonly int NOTHING = END;
      
      public static readonly ExecutionAction LAMBDA_TRANSITION = new ExecutionAction(null, null);
      
      //Matriz que guarda no primeira dimensão os estados do autômato e na segunda as transicões destes.
      protected int[][] _matrix;
      public int[][] matrix {
         get {return _matrix;}
         set {_matrix = value;}
      }
      
      //Array contendo os metadados das ações a ser orquestradas na configuração. Através dessa classe, o Interpretador
      //conseguirá executar os métodos das ações ou sua configuração.
      protected ExecutionAction[] _actions;
      public ExecutionAction[] actions {
         get {return _actions;}
         set {_actions = value;}
      }
      
      //Indica, para cada estado, a quantidade de transições que o tem como destino. É utilizado para as operações de join.
      protected int[] _arriving;
      //TODO condição de corrida. tratar concorrência de escrita e de leitura nas reconfigurações comportamentais.
      public int[] arriving {
         get {return _arriving;}
         set {_arriving = value;}
      }
      
      //Semáforo utilizado pelo ConfigurationManager para suspender a execução individualmente de cada estado.
      protected System.Threading.ManualResetEvent[] _resetEvents;
      
      //Objeto para controlar a condição de corrida das funções que podem sofrer efeitos colaterais durante
      //o processo de reconfiguração.
      private Object thisLock = new Object();
      
      //Lista de objetos que monitoram a execução desta configuração.
      protected List<IMonitor> monitors;
      public IMonitor ReconfigMonitor {
         get {
            if(monitors != null) {
               return monitors[0];
            } else {
               return null;
            }
         }
      }
      
      //Lista das transições realizadas por esta configuração.
      protected List<Transition> transitions;
      public List<Transition> Transitions {
         get {return transitions;}
         set {transitions = value;}
      }
      
      //Numero de estados do autômato.
      protected int numStates;
      
      [MethodImpl(MethodImplOptions.Synchronized)]
      public int DecArriving(int i) {
         //tirar isso
         System.Console.WriteLine("estado decrementado: " + i);
         return --_arriving[i];
      }
      
      public System.Threading.ManualResetEvent doneEvent {
         get {return _resetEvents[_resetEvents.Length-1];}
      }
      
      //Construtor da configuração, o qual deverá indicar o número de estados.
      public Configuration(int numStates, List<Transition> transitions) {
         this.numStates = numStates;
         this.transitions = transitions;
         
         initialize();
         generateAutomaton();
      }
      
      protected void initialize() {
         this._matrix = new int[numStates][];
         this._arriving = new int[numStates];
         
         this._resetEvents = new System.Threading.ManualResetEvent[numStates+1];
         this._resetEvents[numStates] = new System.Threading.ManualResetEvent(false);
      }
      
      public void generateAutomaton() {
         List<ExecutionAction> listea = new List<ExecutionAction>();
         int[] auxiliar = new int[numStates];
         bool[] hasElse = new bool[numStates];
         
         for(int i=0; i<numStates; i++) {
            this._arriving[i] = 0;
            auxiliar[i] = 0;
            hasElse[i] = false;
         }
         
         listea.Add(LAMBDA_TRANSITION);
         foreach(Transition t in transitions) {
            
            if(t.Type == Transition.TransitionType.SIMPLE) {
               System.Console.WriteLine(t);
               listea.Add(t.getExecutionAction());
               auxiliar[t.InitialState]++; //usado temporariamente para determinar o número de transições.
               if(t.IsElse) {
                  hasElse[t.InitialState] = true;
               }
            }
         }
         
         actions = listea.ToArray();
         
         for(int i = 0; i<numStates; i++) {
            System.Console.Write("auxiliar[" + i + "] = " + auxiliar[i] + " | ");

            if(!hasElse[i]) {
               auxiliar[i]++;
            }

            _matrix[i] = new int[auxiliar[i]*BASE];
            auxiliar[i] = 0;
         }
         
         System.Console.WriteLine("");
         //definindo a matrix do estado final.
         _matrix[FINAL_STATE] = new int[BASE];
         _matrix[FINAL_STATE][RUNNABLE] = END;
         
         Transition tran = null;
         int numTransitions, index;
         
         //formando a matrix e o arriving
         for (int i = 0; i < transitions.Count; i++) {
            tran = transitions[i];
            
            if(tran.Type == Transition.TransitionType.SIMPLE) {
               
               numTransitions = _matrix[tran.InitialState].Length;
               System.Console.WriteLine("tran.InitialState: " + tran.InitialState);
               System.Console.WriteLine("tran.FinalState: " + tran.FinalState);
               
               
               if(tran.IsElse) {
                  //Caso seja uma transição ELSE, deverá ocupar a última posição.
                  index = ((numTransitions-1)*BASE);
                  System.Console.WriteLine("numTransitions: " +numTransitions);
                  
               } else {
                  index = (auxiliar[tran.InitialState]*BASE);
                  arriving[tran.FinalState]++;
                  auxiliar[tran.InitialState]++;
                  
                  System.Console.WriteLine("aux" + auxiliar[tran.InitialState]);
               }
               
               
               System.Console.WriteLine("Lenght: " + _matrix[tran.InitialState].Length);
               System.Console.WriteLine("index: " + index);
               System.Console.WriteLine("RUNNABLE: " + RUNNABLE);
               _matrix[tran.InitialState][index+RUNNABLE] = listea.IndexOf(tran.getExecutionAction());
               _matrix[tran.InitialState][index+TARGET_STATE] = tran.FinalState;
            }
         }
         
         
         //exibir a matrix
         for(int b=0; b< _matrix.Length; b++) {
            for(int l=0; l< _matrix[b].Length; l++) {
               System.Console.Write( _matrix[b][l] + ", ");
            }
            System.Console.WriteLine("");
         }
      }
      
      //Método usado na reconfiguração para para a execução dos estados listados.
      //Deve ser passado o índice dos estados a ter sua execução suspensa.
      public void stopStates(List<int> states) {
         
         lock(thisLock) {      
            foreach(int s in states) {
               if(_resetEvents[s] == null) {
                  _resetEvents[s] = new System.Threading.ManualResetEvent(false);
               }
            }
         }
      }
      
      //Retorna o semáforo correspondente ao estado indicado no parâmetro.
      public System.Threading.ManualResetEvent getResetEvent(int stateId) {
         lock(thisLock) {
            return _resetEvents[stateId];
         }
      }
      
      //Reinicia o funcionamento dos estados listados no parâmetro.
      public void runStates(List<int> states) {
         
         lock(thisLock) {            
            foreach(int s in states) {
               if(_resetEvents[s] != null) {
                  _resetEvents[s].Set();
                  _resetEvents[s] = null;
               }
            }
         }
      }
      
      //Método para notificar o início de uma transição sobre a configuração.
      public void NotifyStarted(int state, int transition, int actionId) {
         
         if(monitors != null) {
            foreach(IMonitor m in monitors) {
               m.Started(state, transition, actionId);
            }
         }
      }
      
      //Método para notificar o fim de uma transição sobre a configuração.
      public void NotifyFinalized(int state, int transition, int actionId) {
         
         if(monitors != null) {
            foreach(IMonitor m in monitors) {
               m.Finalized(state, transition, actionId);
            }
         }
      }
      
      //adição de monitores a configuração.
      public void AddMonitor(IMonitor monitor) {
         
         if(monitors == null) {
            monitors = new List<IMonitor>();
         }
         monitors.Add(monitor);
      }
      
      public string toString() {
         string s = "";
         
         foreach(int[] i in _matrix) {
            s += "linha: ";
            if(i != null) {
               foreach(int j in i) {
                  s += j + "| ";
               }
               s += '\n';
            }
         }
         
         return s;
      }
   }
}
