/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/
using System;
using System.Threading;
using System.Runtime.CompilerServices;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;

namespace br.ufc.pargo.hpe.connector.run
{
   
	//Classe controladora de estado do autômato. Tem a responsabilidade de iniciar os executores de ramo (BranchInterpreter)
	//e de receber os resultados de suas execuções.
	//Esta classe trata ainda de identificar quando a condição de "else" é atingida.
	public class StateControl
	{

		//Estado a ser controlado pela instância.
		protected int stateId;

		//Número de transações que falta reportar o seu resultado.
		protected int count;

		//Condição de else. Indica se a transação "else" deverá ser disparada.
		protected bool elseResult;

		//Número de iterações.
		protected int iterations;

		//Configuration que está sendo executado.
		protected Configuration protocol;

		public Configuration Protocol {
			get{ return protocol;}
		}

		public StateControl (Configuration protocol) : this (protocol, Configuration.INITIAL_STATE)
		{
		}

		public StateControl (Configuration protocol, int stateId)
		{
			this.protocol = protocol;
			this.stateId = stateId;
			protocol.RestartArriving(stateId);
		}

		//Dispara a execução do estado.
		public void Go ()
		{

			//artifício para suspender a execução do estado nos casos de reconfiguração.
			ManualResetEvent resetEvent = protocol.getResetEvent (stateId);
			if(ConfigurationManager.N)
				//System.Diagnostics.Trace.WriteLine ("[StateControl.Go] STATE: " + stateId);

			if (resetEvent != null) {
				System.Diagnostics.Trace.WriteLine("[StateControl.Go] DORMIU: estado " + stateId);
				WaitHandle.WaitAll (new ManualResetEvent[] {resetEvent});
				System.Diagnostics.Trace.WriteLine("[StateControl.Go] ACORDOU: estado " + stateId);
			}

			Dictionary<int, int> transitions = protocol.Matrix [stateId];
			BranchInterpreter branch;
			//a última transição será considerada o "else".
			this.count = (transitions.Count / Configuration.BASE) - 1;
			this.elseResult = false;
         
			if (transitions [Configuration.RUNNABLE] != Configuration.END) {
            
				count = (count == 0 ? 1 : count);
				iterations = count - 1;
            
				for (int i=0; i <= iterations; i++) {
					branch = new BranchInterpreter (stateId, i, this);
					ThreadPool.QueueUserWorkItem (branch.Go, null);
				}
			} else {
				//System.Diagnostics.Trace.WriteLine("[StateControl.Go] Sinaliza Final!");
				protocol.doneEvent.Set ();
				//StateControl: Execução finalizada!
			}
		}

		//Método que notifica ao estado que a execução de uma transação vinculada ao estado foi concluída.
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void Notify (bool result)
		{
			//System.Diagnostics.Trace.WriteLine("[StateControl.Notify] Finalização notificada- state:{0}]", stateId);
			BranchInterpreter branch;
         
			elseResult = elseResult || result;
			count--;
			int rid = protocol.Matrix [stateId] [((iterations+1) * Configuration.BASE) + Configuration.RUNNABLE];
			
			if (count == 0 && !elseResult && rid != Configuration.NOTHING) {
				//Esse objeto morre. count = iterations + 1; //reinicio a contagem, caso haja uma nova exeucao do estado.
				//System.Diagnostics.Trace.WriteLine("[StateControl.Notify] Criado BranchInterpreter- state:{0} | iteracao(-1):{1}", stateId, iterations);
				branch = new BranchInterpreter (stateId, iterations + 1, this);
				ThreadPool.QueueUserWorkItem (branch.Go, null);
			}
		}
	}
}
