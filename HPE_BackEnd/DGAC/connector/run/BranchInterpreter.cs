/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/

using System;
using System.Threading;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;
using br.ufc.pargo.hpe.connector.monitoring;

namespace br.ufc.pargo.hpe.connector.run {

   //Classe responsável pela execução de uma ação individual da configuração. Assume a execução de cada ramo do autômato.
   public class BranchInterpreter {

      //Estado a partir de onde o ramo será executado.
      protected int _state;

      //Transição do ramo a ser executado.
      protected int _transition;

      //Controlador de estado que disparou este executor.
      protected StateControl _sControl;
      
      //Construtor     
      public BranchInterpreter(int state, int transition, StateControl sControl) {
         this._state = state;
         this._transition = transition;
         this._sControl = sControl;
      }
      
      //Método para executar o ramo.
      public void Go(Object nothing) {
         int rid = _sControl.Protocol.matrix[_state][_transition*Configuration.BASE];
         br.ufc.pargo.hpe.connector.config.ExecutionAction action = _sControl.Protocol.actions[rid];

         if (action.Condition == null || action.Condition.Evaluate()) {
            //ThreadPool.QueueUserWorkItem(NotifyMonitors, null);
            _sControl.Protocol.NotifyStarted(_state, _transition, action.MetaAction.Id);
            
            //o MetaAction pode ser nulo quando for uma trasição lambda (nos casos de alt ou if).
            if(action.MetaAction != null) {
               action.MetaAction.Run();
            }

            _sControl.Notify(true);

            //ThreadPool.QueueUserWorkItem(NotifyMonitors, null);
            _sControl.Protocol.NotifyFinalized(_state, _transition, action.MetaAction.Id);
         } else {
            _sControl.Notify(false);
         }
         
         int targetState = _sControl.Protocol.matrix[_state][(_transition*Configuration.BASE)+Configuration.TARGET_STATE];
         int counter = _sControl.Protocol.DecArriving(targetState);
         
         if(counter == 0) {
            new StateControl(_sControl.Protocol, targetState).Go();
         }
      }
   }
}
