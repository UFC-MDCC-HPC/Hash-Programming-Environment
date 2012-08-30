/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/

using System;
using System.Threading;
using System.Runtime.CompilerServices;

using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;

namespace br.ufc.pargo.hpe.connector.run {
   
   //Classe controladora de estado do autômato. Tem a responsabilidade de iniciar os executores de ramo (BranchInterpreter)
   //e de receber os resultados de suas execuções.
   //Esta classe trata ainda de identificar quando a condição de "else" é atingida.
   public class StateControl {

      //Estado a ser controlado pela instância.
      protected int _stateId;

      //Número de transações que falta reportar o seu resultado.
      protected int _transationsCount;

      //Condição de else. Indica se a transação "else" deverá ser disparada.
      protected bool _elseResult;

      //Número de iterações.
      protected int _iterations;

      //Configuration que está sendo executado.
      protected Configuration _protocol;

      public Configuration Protocol {
         get{return _protocol;}
      }

      public StateControl(Configuration protocol) {
         this._protocol = protocol;
         this._stateId = Configuration.INITIAL_STATE;
      }

      public StateControl(Configuration protocol, int stateId) {
         this._protocol = protocol;
         this._stateId = stateId;
      }

      //Dispara a execução do estado.
      public void Go() {

         //artifício para suspender a execução do estado nos casos de reconfiguração.
         ManualResetEvent resetEvent = _protocol.getResetEvent(_stateId);
         System.Console.WriteLine("STATE: " + _stateId);

         if(resetEvent != null) {
            WaitHandle.WaitAll(new ManualResetEvent[] {resetEvent});
         }

         int[] transitions = _protocol.matrix[_stateId];
         BranchInterpreter branch;
         //a última transição será considerada o "else".
         this._transationsCount = (transitions.Length/Configuration.BASE)-1;
         this._elseResult = false;
         
         if(transitions[Configuration.RUNNABLE] != Configuration.END) {
            
            _transationsCount = (_transationsCount == 0? 1: _transationsCount);
            _iterations = _transationsCount-1;
            
            for (int i=0; i <= _iterations; i++) {
               branch = new BranchInterpreter(_stateId, i, this);
               ThreadPool.QueueUserWorkItem(branch.Go, null);
            }
         } else {
            _protocol.doneEvent.Set();
            //StateControl: Execução finalizada!
         }
      }

      //Método que notifica ao estado que a execução de uma transação vinculada ao estado foi concluída.
      [MethodImpl(MethodImplOptions.Synchronized)]
      public void Notify(bool result) {
         BranchInterpreter branch;
         
         _elseResult = _elseResult || result;
         _transationsCount--;
         
         if(_transationsCount == 0 && !_elseResult) {
            branch = new BranchInterpreter(_stateId, _iterations+1, this);
            ThreadPool.QueueUserWorkItem(branch.Go, null);
         }
      }
   }
}
