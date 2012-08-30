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
         
         Console.WriteLine("Execucao iniciada!");
         
         if(!_action.IsNative) {
            new StateControl(_action.Protocol).Go();
         }
         else {
            //Object unitEntity = _action.Father.Entity;
            //TODO chamar o método _action.name sobre o objeto unitEntity.
         }

         //TODO corrigir essa referencia ao doneEvent.
         //Verificar como esperar por apenas um evento.
         WaitHandle.WaitAll(new ManualResetEvent[] {_action.Protocol.doneEvent});
         
         Console.WriteLine("Execucao finalizada!");
         
         //A finalização execução será realizada pelo StateControl.
      }
   }
}
