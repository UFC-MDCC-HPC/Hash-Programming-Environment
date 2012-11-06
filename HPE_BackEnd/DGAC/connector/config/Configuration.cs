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

namespace br.ufc.pargo.hpe.connector.config
{
   
	//Representação do autômato de execução de uma ação descrita em HCL.
   
	/*
   A função de execução é representada pela matriz bi-dimensional de nome "matrix".
   Cada linha da matrix simboliza um estado. Cada estado possúi um grupo de transições, cada qual ocupando
   duas posições no vetor. A primeira é o RUNNABLE, que contém o índice da ação a ser executada. Este índice
   aponta para o array de MetaAction "_actions". Já a segunda posição é TARGET_STATE, indicado a qual estado
   esta transição leva.
   
   Um estado pode ter várias transições, sempre em pares.
   */
	public class Configuration : MarshalByRefObject, IMonitorable
	{
      
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
		public static readonly int NOTHING = -2;
		public static readonly ExecutionAction LAMBDA_TRANSITION = new ExecutionAction (null, null);

		//Matriz que guarda no primeira dimensão os estados do autômato e na segunda as transicões destes.
		protected Dictionary<int, Dictionary<int, int>> matrix;
		public Dictionary<int, Dictionary<int, int>> Matrix {
			get { return matrix;}
			set { matrix = value;}
		}
      
		//Array contendo os metadados das ações a ser orquestradas na configuração. Através dessa classe, o Interpretador
		//conseguirá executar os métodos das ações ou sua configuração.
		protected List<ExecutionAction> actions;
		public List<ExecutionAction> Actions {
			get { return actions;}
			set { actions = value;}
		}
      
		//Indica, para cada estado, a quantidade de transições que o tem como destino. É utilizado para as operações de join.
		protected Dictionary<int, int> arriving;
		protected Dictionary<int, int> arrivingCount;
		//TODO condição de corrida. tratar concorrência de escrita e de leitura nas reconfigurações comportamentais.
		public Dictionary<int, int> ArrivingCount {
			get { return arrivingCount;}
			set { arrivingCount = value;}
		}
      
		protected int lastTransationId;
		public int LastTransationId {
			get { return lastTransationId;}
			set { lastTransationId = value;}
		}

		//Semáforo utilizado pelo ConfigurationManager para suspender a execução individualmente de cada estado.
		protected Dictionary<int, System.Threading.ManualResetEvent> _resetEvents;
      
		//Objeto para controlar a condição de corrida das funções que podem sofrer efeitos colaterais durante
		//o processo de reconfiguração.
		private Object thisLock = new Object ();
      
		//Lista de objetos que monitoram a execução desta configuração.
		protected List<IMonitor> monitors;
		public IMonitor ReconfigMonitor {
			get {
				if (monitors != null) {
					return monitors [0];
				} else {
					return null;
				}
			}
		}
      
		//Lista das transições realizadas por esta configuração.
		protected List<Transition> transitions;
		public List<Transition> Transitions {
			get { return transitions;}
			set { transitions = value;}
		}
      
		//Numero de estados do autômato.
		protected int numStates;
		public int NumStates {
			get {return numStates;}
			set {numStates = value;}
		}

		public System.Threading.ManualResetEvent doneEvent {
			get { return _resetEvents [numStates];}
		}
      
		//Construtor da configuração, o qual deverá indicar o número de estados.
		public Configuration (int numStates, List<Transition> transitions, int lastTransationId)
		{
			this.numStates = numStates;
			this.lastTransationId = lastTransationId;
         
			initialize ();
			generateAutomaton (transitions);
		}
      
		protected void initialize ()
		{
			this.matrix = new Dictionary<int, Dictionary<int, int>>();
			this.arriving = new Dictionary<int, int>();
			this.arrivingCount = new Dictionary<int, int>();
			this.actions = new List<ExecutionAction>();
			this.transitions = new List<Transition>();

			this._resetEvents = new Dictionary<int, System.Threading.ManualResetEvent>();
			this._resetEvents[numStates] = new System.Threading.ManualResetEvent (false);
		}
      
		public void generateAutomaton (List<Transition> transToAdd)
		{
			Dictionary<int, bool> hasElse = new Dictionary<int, bool> ();
			Dictionary<int, int> numTransations = new Dictionary<int, int> ();
			List<int> iniStates, finStates;
			iniStates = new List<int> ();
			finStates = new List<int> ();
         
			foreach (Transition t in transToAdd) {

				transitions.Add (t);
				if (!finStates.Contains (t.FinalState)) {
					this.arriving[t.FinalState] = 0;
					this.arrivingCount[t.FinalState] = 0;

					finStates.Add (t.FinalState);
				}

				if (!iniStates.Contains (t.InitialState)) {
					numTransations[t.InitialState] = 0;
					hasElse[t.InitialState] = false;
					matrix [t.InitialState] = new Dictionary<int, int> ();

					iniStates.Add (t.InitialState);
				}
			}
         
			if (!actions.Contains (LAMBDA_TRANSITION)) {
				actions.Add (LAMBDA_TRANSITION);
			}

			foreach (Transition t in transToAdd) {
            
				if (t.Type == Transition.TransitionType.SIMPLE) {
					System.Console.WriteLine (t);
					if(t.getExecutionAction () != LAMBDA_TRANSITION) {
						actions.Add (t.getExecutionAction ());
					}
					numTransations [t.InitialState]++; //usado temporariamente para determinar o número de transições.
					if (t.IsElse) {
						hasElse [t.InitialState] = true;
					}
				}
			}

			System.Console.WriteLine ("");
         
			int index;
			//formando a matrix e o arriving
			foreach (Transition tran in transToAdd) {
            
				if (tran.Type == Transition.TransitionType.SIMPLE) {
               
					System.Console.Write ("tran.InitialState: " + tran.InitialState + " | ");
					System.Console.Write ("tran.FinalState: " + tran.FinalState + " | ");
               
               
					if (tran.IsElse) {
						//Caso seja uma transição ELSE, deverá ocupar a última posição.
						index = (numTransations [tran.InitialState] - 1);
						System.Console.WriteLine ("numTransitions: " + numTransations [tran.InitialState] + " | ");
                  
					} else {
						index = (matrix [tran.InitialState].Values.Count/Configuration.BASE);
					}

					arriving [tran.FinalState]++;
					arrivingCount [tran.FinalState]++;
					matrix [tran.InitialState] [(index * BASE) + RUNNABLE] = actions.IndexOf (tran.getExecutionAction ());
					matrix [tran.InitialState] [(index * BASE) + TARGET_STATE] = tran.FinalState;

				}
			}
         

			foreach (int i in iniStates) {

				if (!hasElse [i]) {
					matrix [i] [(numTransations [i]*BASE) + RUNNABLE] = NOTHING;
					matrix [i] [(numTransations [i]*BASE) + TARGET_STATE] = NOTHING;
				}
			}
			//definindo a matrix do estado final.
			matrix[FINAL_STATE] = new Dictionary<int, int>();
			matrix [FINAL_STATE] [RUNNABLE] = END;

			//TODO remover! exibir a matrix
			System.Console.WriteLine ();
			System.Console.WriteLine ("Exibindo a matrix");
			string content;
			for (int b = 0; b < matrix.Count; b++) {
				content = "linha null";
				if(matrix.ContainsKey(b)) {
					for (int l = 0; l < matrix[b].Count; l++) {
						content = "null";
						if(matrix [b].ContainsKey(l)) {
							content = "" + matrix [b] [l];
						}
						System.Console.Write (content + ", ");
					}
				}
				System.Console.WriteLine ("");
			}
			
			System.Console.WriteLine ("Arriving");
			foreach(int rj in arriving.Keys) {
				System.Console.WriteLine("arriving[{0}]={1}", rj, arriving[rj]);
			}
		}

		[MethodImpl(MethodImplOptions.Synchronized)]
		public int DecArriving (int i)
		{
			return --arrivingCount[i];
		}

		[MethodImpl(MethodImplOptions.Synchronized)]
		public void RestartArriving(int i)
		{
			//foreach (int j in arriving.Keys)
			//{
			//	Console.WriteLine("j={0}, i={1}", j, i);	
			//}
			
			if (i!=INITIAL_STATE)
				arrivingCount[i] = arriving[i];
		}

		//Método usado na reconfiguração para para a execução dos estados listados.
		//Deve ser passado o índice dos estados a ter sua execução suspensa.
		public void stopStates (List<int> states)
		{
         
			lock (thisLock) {      
				foreach (int s in states) {
					if (!_resetEvents.ContainsKey(s)) {
						_resetEvents [s] = new System.Threading.ManualResetEvent (false);
					}
				}
			}
		}
      
		//Retorna o semáforo correspondente ao estado indicado no parâmetro.
		public System.Threading.ManualResetEvent getResetEvent (int stateId)
		{
			System.Threading.ManualResetEvent result = null;

			lock (thisLock) {
				_resetEvents.TryGetValue(stateId, out result);

				return result;
			}
		}
      
		//Reinicia o funcionamento dos estados listados no parâmetro.
		public void runStates (List<int> states)
		{
         
			lock (thisLock) {            
				foreach (int s in states) {
					if (_resetEvents.ContainsKey(s)) {
						_resetEvents [s].Set ();
						_resetEvents.Remove(s);
					}
				}
			}
		}
      
		//Método para notificar o início de uma transição sobre a configuração.
		public void NotifyStarted (int state, int transition, int actionId)
		{
         
			if (monitors != null) {
				foreach (IMonitor m in monitors) {
					m.Started (state, transition, actionId);
				}
			}
		}
      
		//Método para notificar o fim de uma transição sobre a configuração.
		public void NotifyFinalized (int state, int transition, int actionId)
		{
         
			if (monitors != null) {
				foreach (IMonitor m in monitors) {
					m.Finalized (state, transition, actionId);
				}
			}
		}
      
		//adição de monitores a configuração.
		public void AddMonitor (IMonitor monitor)
		{
         
			if (monitors == null) {
				monitors = new List<IMonitor> ();
			}
			monitors.Add (monitor);
		}
      

		public Transition getTransition (string point)
		{
			foreach (Transition t in transitions) {
				if(t.Ids.Contains(point)) {
					return t;
				}
			}

			return null;
		}

		public string toString ()
		{
			string s = "";
         
			foreach (Dictionary<int, int> i in matrix.Values) {
				s += "linha: ";
				if (i != null) {
					foreach (int j in i.Values) {
						s += j + "| ";
					}
					s += '\n';
				}
			}
         
			return s;
		}
	}
}
