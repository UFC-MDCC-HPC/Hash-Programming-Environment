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

namespace br.ufc.pargo.hpe.connector.run
{

	//Classe responsável pela execução de uma ação individual da configuração. Assume a execução de cada ramo do autômato.
	public class BranchInterpreter
	{

		//Estado a partir de onde o ramo será executado.
		protected int state;

		//Transição do ramo a ser executado.
		protected int transition;

		//Controlador de estado que disparou este executor.
		protected StateControl sControl;
      
		//Construtor     
		public BranchInterpreter (int state, int transition, StateControl sControl)
		{
			this.state = state;
			this.transition = transition;
			this.sControl = sControl;
		}
      
		//Método para executar o ramo.
		public void Go (Object nothing)
		{
			Console.WriteLine("[BranchInterpreter.Go] state:{0} | transition:{1}", state, transition);
			int rid = sControl.Protocol.Matrix [state] [(transition * Configuration.BASE) + Configuration.RUNNABLE];
			br.ufc.pargo.hpe.connector.config.ExecutionAction action = sControl.Protocol.Actions [rid];
			
			bool result = false;

			if (action.Condition != null) {
				result = action.Condition.Evaluate ();
				System.Console.WriteLine("[BranchInterpreter.Go] Avaliando Condição " + action.Condition.Cond + ": " + result);
			}

			if (action.Condition == null || result) {
				//ThreadPool.QueueUserWorkItem(NotifyMonitors, null);
				sControl.Protocol.NotifyStarted (state, transition, (action.MetaAction == null ? -1 : action.MetaAction.Id));
            
				//o MetaAction pode ser nulo quando for uma trasição lambda. Controle de fluxo.
				if (action.MetaAction != null) {
					action.MetaAction.Run ();
				}
				
				sControl.Notify (true);
				
				//ThreadPool.QueueUserWorkItem(NotifyMonitors, null);
				sControl.Protocol.NotifyFinalized (state, transition, (action.MetaAction == null ? -1 : action.MetaAction.Id));

			} else {

				sControl.Notify (false);
			}
         
			int targetState = sControl.Protocol.Matrix [state] [(transition * Configuration.BASE) + Configuration.TARGET_STATE];
         
			//essa condiçao quer dizer que essa transicao é de controle de fluxo.
			if (action.MetaAction == null) {
				if (result || action.Condition == null) {
					new StateControl (sControl.Protocol, targetState).Go ();
				}
			} else { //Se a transicao nao é de controle de fluxo, entao eu devo iniciar o proximo estado.
				int counter = sControl.Protocol.DecArriving (targetState);

				if (counter == 0) {
					new StateControl (sControl.Protocol, targetState).Go ();
				}
			}
		}
	}
}
