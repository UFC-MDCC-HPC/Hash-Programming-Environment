/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

//using HPE.Port;
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.load;
using br.ufc.pargo.hpe.connector.run;
using br.ufc.pargo.hpe.connector.reconfig;
using br.ufc.pargo.hpe.connector.monitoring;

using System;
using System.Threading;
using System.Runtime.CompilerServices;
using System.Collections.Generic;
using br.ufc.pargo.hpe.connector;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.connector.config
{
   
	/*Gerenciador de configuração. É responsável pelo acompanhamento da execução (Papel do Monitor)
   e aplicação de reconfigurações dinâmicas.
   
   Tem o seu funcinamento vinculado a um WorkObject.*/
	public class ConfigurationManager : IConfigurationManager, IObserver
	{
      
		protected XmlLoader loader;
		protected int index;
		protected string unitName;
		protected MetaHashComponent application;

		//Unit principal a ser executada no nó.
		protected MetaUnit unit = null;

		public MetaUnit Unit {
			get { return unit;}
		}
      
		//Interpretador a conduzir a execução.
		protected List<IInterpreter> interpreters = null;
      
		//Indica se o manager está aguardando por um estado para aplicar uma reconfiguração. 
		protected bool waiting;
      
		//Semaforo para realizar a espera de um estado viável para a reconfiguração.
		protected System.Threading.ManualResetEvent resetEvent;
		private Object thisLock = new Object ();
		protected bool reconfiguring;

		public bool IsReconfiguring {
			get { return reconfiguring;}
		}
      
		protected List<ExecutionStateEvaluation> evaluations = null;
		protected ReconfigurationRequest request = null;

		private IUnit the_unit = null;
		
		public ConfigurationManager(IUnit the_unit)
		{
			this.the_unit = the_unit;
         
			this.waiting = this.reconfiguring = false;
			resetEvent = new System.Threading.ManualResetEvent (false);
         
			//TODO depois de finalizar a execução, tirar dessa lista.
			interpreters = new List<IInterpreter> ();
         
		}
      
		public void LoadComponent (string xml)
		{
			this.loader = new XmlLoader (the_unit);
							
			this.application = loader.loadComponent (xml);
         
			this.unitName = the_unit.Id_unit;
			this.index = the_unit.PartitionIndex;
			
			foreach (MetaUnit u in application.Units.Values) 
			{
				Console.WriteLine("u.Name={0}, this.unitName={1}",u.Name, this.unitName);
				if (u.Name.Equals (this.unitName)) {
					this.unit = u;
					u.Index = this.index;
					break;
				}
			}
         
			if (this.unit == null) {
				throw new Exception ("Unit not found. Name: " + unitName + " | Index: " + index);
			}
		}
      
		public void Run ()
		{
			Run ("main");
		}
      
		//Inicia a execução da configuração.
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void Run (string actionName)
		{
			MetaAction action = null;
         
			if (unit != null && unit.Entity != null) {

				action = unit.Actions [actionName];
				if (action != null) {
               
					Run (action);
               
				} else {
					throw new Exception ("Invalid action name.");
				}
			} else {
            
				throw new Exception ("Null entity.");
			}
		}

		public void Run (MetaAction action)
		{
			action.Protocol.AddMonitor (new br.ufc.pargo.hpe.connector.monitoring.Monitor ());
         
			Interpreter interpreter = new Interpreter (action);
			interpreters.Add (interpreter);
			interpreter.Go ();
		}

		public bool EvaluateReconfiguration (string xmlRequest)
		{
			ReconfigurationRequest r = loader.loadRequest (xmlRequest, application);

			return EvaluateReconfiguration (r);
		}

		public bool EvaluateReconfiguration (ReconfigurationRequest request)
		{
			lock (thisLock) {
				if (!reconfiguring) {
               
					this.reconfiguring = true;            
					this.evaluations = SecurityAnalyzer.Evaluate (request, unit);
               
					if (SecurityAnalyzer.isDeadlockFree (evaluations, unit)) {
						this.request = request;
						return true;
                  
					} else {
						this.evaluations = null;
						this.reconfiguring = false;
						return false;
					}
               
				} else {
					throw new Exception ("Já existe uma reconfiguração em andamento. " +
						" Esta deverá ser confirmada ou cancelada antes de nova submissão.");
				}
			}
		}
      
		//TODO MEDIO indexar as actions pelo nome;
		public bool CommitReconfiguration ()
		{
			Configuration protocol;
         
			lock (thisLock) {
				if (reconfiguring) {
               
					foreach (ExecutionStateEvaluation es in evaluations) {

						protocol = unit.Actions [es.ActionName].Protocol;
						protocol.stopStates (es.StatesToStop);
						WaitForSafeState (protocol.ReconfigMonitor, es);

						if (request.StructuralRequest != null && request.StructuralRequest.Changes != null) {
							foreach (StructuralChange sc in request.StructuralRequest.Changes) {
								//TODO reconManager.SubstituteUnit(sc.Old, sc.New);
							}
						}
						BehavioralReconfigurationRequest behavioralRequest = request.BehavioralRequest;

						if (behavioralRequest != null) {

							foreach (BehavioralChange bc in behavioralRequest.Changes) {
											
								if (bc.NewSlices != null) {
									foreach (MetaSlice slice in bc.NewSlices.Values) {
										if (unit.Slices [slice.Inner] == null) {
											unit.AddSlice (slice.Inner, slice);
										}
									}
								}

								unit.Actions [bc.Action].Protocol.generateAutomaton (bc.Transitions);
							}
						}
                     
					}            
               
					foreach (ExecutionStateEvaluation es in evaluations) {
						foreach (MetaAction action in unit.Actions.Values) {
                     
							if (!action.IsNative && action.Name.Equals (es.ActionName)) {
								action.Protocol.runStates (es.StatesToStop);
							}
						}
					}
               
					this.reconfiguring = false;
					this.evaluations = null;
					this.request = null;
					return true;
				}
			}
			return false;
		}
      
		//TODO usar um locker para os três métodos. Cancel, Commit, Evaluate.
		public void CancelReconfiguration ()
		{
			lock (thisLock) {         
				this.reconfiguring = false;
				this.evaluations = null;
				this.request = null;
			}
		}
		//Aguarda um estado seguro onde seja possível realizar a reconfiguração.
		//Os estados seguros são identificados pelo es.
		protected void WaitForSafeState (IMonitor monitor, ExecutionStateEvaluation es)
		{
         
			//System.Console.WriteLine(es.ToString());
			if (es.CriticalActions != null) {
				waiting = monitor.isRunning (es.CriticalActions);
				while (waiting) {
               
					//TODO BAIXO: resolver essa marmota de ter que criar um array.
					System.Threading.WaitHandle.WaitAll (new System.Threading.ManualResetEvent[] {resetEvent});
					waiting = monitor.isRunning (es.CriticalActions); 
				}
			}
         
			if (es.CriticalIntervals != null) {
				foreach (Interval interval in es.CriticalIntervals) {
               
					waiting = monitor.isRunning (interval.InitialState, interval.FinalState);
					while (waiting) {
                  
						System.Threading.WaitHandle.WaitAll (new System.Threading.ManualResetEvent[] {resetEvent});
						waiting = monitor.isRunning (interval.InitialState, interval.FinalState);
					}
				}
			}
		}
      
		//Método para que o monitor possa indicar que algum estado se concluio. É chamado apenas durante
		//o tempo de espera por um estado seguro.
		public void Notify ()
		{
			if (waiting) {
				resetEvent.Set ();
			}
		}

		public void PersistConfiguration ()
		{
         
		}
	}
}
