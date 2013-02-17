/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using System.Threading;

using br.ufc.pargo.hpe.connector.meta;

namespace br.ufc.pargo.hpe.connector.run {

   //Classe que inicia o processo de interpretação de uma configuração (Configuration).
   public class Interpreter : IInterpreter {

      //MetaAction a ser executada pelo Interpreter
      protected br.ufc.pargo.hpe.connector.meta.MetaAction _action = null;
      public br.ufc.pargo.hpe.connector.meta.MetaAction Action {
         get {return _action;}
      }

      public Interpreter(br.ufc.pargo.hpe.connector.meta.MetaAction action) {
         this._action = action;
      }
      
      //Dispara o início da execução da configuração indicada no construtor.
      public void Go() {
         
         //Diagnostics.Debug.WriteLine("[Interpreter.Go] Execução iniciada! {0}", GetHashCode());
         
         if(!_action.IsNative) {
			_action.Protocol.setResetEvent();
            new StateControl(_action.Protocol).Go();
         }
         else {
			//Console.WriteLine("Execucao NATIVA! {0}", GetHashCode());
            //Object unitEntity = _action.Father.Entity;
            //TODO chamar o método _action.name sobre o objeto unitEntity.
         }

		WaitHandle.WaitAll(new ManualResetEvent[] {_action.Protocol.doneEvent});
         
         //Console.WriteLine("[Interpreter.Go] Execução finalizada! {0}", GetHashCode());
         
         //A finalização execução será realizada pelo StateControl.
      }
   }
}
