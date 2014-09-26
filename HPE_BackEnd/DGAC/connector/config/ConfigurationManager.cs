/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.load;
using br.ufc.pargo.hpe.connector.run;
using br.ufc.pargo.hpe.connector.reconfig;
using br.ufc.pargo.hpe.connector.monitoring;

using System;
using System.Threading;
using System.Runtime.CompilerServices;
using System.Collections.Generic;
using System.Runtime.Serialization;

using br.ufc.pargo.hpe.connector;
using br.ufc.pargo.hpe.basic;

using gov.cca;
using gov.cca.ports;

using br.ufc.pargo.hpe.backend.DGAC;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.connector.config
{
   
	/*Gerenciador de configuração. É responsável pelo acompanhamento da execução (Papel do Monitor)
   e aplicação de reconfigurações dinâmicas.
   
   Tem o seu funcinamento vinculado a um WorkObject.*/
	public class ConfigurationManager : MarshalByRefObject, IConfigurationManager, IObserver
	{
      
		protected XmlLoader loader;
		//protected int index;
		protected string unitName;
		protected MetaHashComponent application;

		//Unit principal a ser executada no nó.
		protected MetaUnit unit = null;
		
		//teste reconfiguration
		protected bool ready = false;
		public bool Ready {
			get {return ready;}
		}

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
		
		public readonly static float DEFAULT_TIME_OUT = 5000;
		
		public static bool N; 
		public ConfigurationManager(IUnit the_unit)
		{
			this.the_unit = the_unit;
         
			this.waiting = this.reconfiguring = false;
			resetEvent = new System.Threading.ManualResetEvent (false);
         
			//TODO depois de finalizar a execução, tirar dessa lista.
			interpreters = new List<IInterpreter> ();
			
			ThreadPool.SetMinThreads(6, 6);
         
		}
      
		public void LoadComponent (string xml)
		{
			this.loader = new XmlLoader (the_unit);
			
			this.application = loader.loadComponent (xml);
         
			this.unitName = the_unit.Id_unit;
			//this.index = the_unit.PartitionIndex;
			
			foreach (MetaUnit u in application.Units.Values) 
			{
				//Trace.WriteLine("[ConfigurationManager.LoadComponent] Unit {0}", the_unit.CID.getInstanceName);
				if (u.Name.Equals (this.unitName)) {
					this.unit = u;
					//u.Index = this.index;
					break;
				}
			}
         
			if (this.unit == null) {
				throw new Exception ("Unit not found. Name: " + unitName);
			}
			
			ready = true;
			Trace.WriteLine("[ConfigurationManager.LoadComponent] Unidade {0} carregada e apta para execução.", the_unit.CID.getInstanceName());
			N = the_unit.CID.getInstanceName().Equals ("app.adi_solver3D-adi");
			
		}
      
		public void Run ()
		{
			Run ("main");
		}
      
		//Inicia a execução da configuração.
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void Run (string actionName)
		{
			//System.Diagnostics.Trace.WriteLine("[ConfigurationManager.Run] iniciando a ação " + actionName);
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
         	if(action.Protocol.Monitors == null || action.Protocol.Monitors.Count == 0) {
				br.ufc.pargo.hpe.connector.monitoring.Monitor monitor = new br.ufc.pargo.hpe.connector.monitoring.Monitor ();
				monitor.Add(this);
				
				action.Protocol.AddMonitor (monitor);
			}
			
			Interpreter interpreter = new Interpreter (action);
			interpreters.Add (interpreter);
			
			interpreter.Go ();
		}

		public bool EvaluateReconfiguration (string xmlRequest)
		{
			Trace.WriteLine("[ConfigurationManager.EvaluateReconfiguration] Iniciando avaliação da reconfiguração...");
			ReconfigurationRequest r = loader.loadRequest (xmlRequest, application);
			
			if(r.StructuralRequest != null) {
				Trace.WriteLine("[ConfigurationManager.EvaluateReconfiguration] Identificando os componentes impactos...");	
				r.StructuralRequest.GenerateChanges(application);
			}

			//Trace.WriteLine("[ConfigurationManager.EvaluateReconfiguration] Requisição construída a partir do arquivo: " + xmlRequest);
			bool result = EvaluateReconfiguration(r); 
			
			Trace.WriteLine("[ConfigurationManager.EvaluateReconfiguration] Avaliação Concluída!");
			Trace.WriteLine("");
			return result;
		}

		public bool EvaluateReconfiguration (ReconfigurationRequest request)
		{
			//Trace.WriteLine("[ConfigurationManager.EvaluateReconfiguration] Avaliando a reconfiguração");
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
			//Trace.WriteLine("[ConfigurationManager.EvaluateReconfiguration] Avaliação Finalizada");
		}
		
		/*public bool CommitReconfiguration ()
		{
			Thread commit = new Thread(new ThreadStart(Commit));
			commit.Priority = ThreadPriority.Highest;
			commit.Start();
			
			return true;
		}*/
	
		public bool CommitReconfiguration ()
		{
			Configuration protocol;
         
			Trace.WriteLine("[ConfigurationManager.Commit] Aplicando a reconfiguração...");
			lock (thisLock) {
				if (reconfiguring) {
               
					foreach (ExecutionStateEvaluation es in evaluations) {

						protocol = unit.Actions [es.ActionName].Protocol;
						protocol.stopStates (es.StatesToStop);
						WaitForSafeState (protocol.ReconfigMonitor, es);
						Trace.WriteLine("[ConfigurationManager.Commit] Estado seguro para reconfiguração!");
						
						if (request.StructuralRequest != null && request.StructuralRequest.Changes != null) {
							Trace.WriteLine("[ConfigurationManager.Commit] Aplicando reconfigurações estruturais...");
							foreach (StructuralChange sc in request.StructuralRequest.Changes) {
								if(SecurityAnalyzer.isChangeConcrete(sc)) {
									Trace.WriteLine("[ConfigurationManager.Commit] Reconfigurando a unidade {0}", sc.Old.Name);
									createConcreteUnit(sc.New, ((IUnit)sc.Old.Entity).CID.getInstanceName() /*+ "(new)"*/);
									SubstituteUnit(sc.Old, sc.New);
								}
							}
						}
						BehavioralReconfigurationRequest behavioralRequest = request.BehavioralRequest;

						if (behavioralRequest != null) {

							foreach (BehavioralChange bc in behavioralRequest.Changes) {
											
								if (bc.NewSlices != null) {
									//Trace.WriteLine("[ConfigurationManager.Commit] Adicionando novas fatias");
									foreach (MetaSlice slice in bc.NewSlices.Values) {
										if (!unit.Slices.ContainsKey(slice.Inner)) {
											Trace.WriteLine("[ConfigurationManager.Commit] Adicionando fatia '{0}'...", slice.Inner);
											createConcreteUnit(slice.Unit, slice.Inner /*+ "(new)"*/);
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
					
					Trace.WriteLine("[ConfigurationManager.Commit] Reconfiguração aplicada!");
					
					return true;
				}
			}
			return false;
		}
      
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
         
			//System.System.Diagnostics.Trace.WriteLine(es.ToString());
			if (es.CriticalActions != null) {
				Trace.WriteLine("[ConfigurationManager.WaitForSafeState] Aguardando estado seguro...");
				waiting = monitor.isRunning (es.CriticalActions);
				while (waiting) {
               
					Trace.WriteLine("[ConfigurationManager.WaitForSafeState] esperando...");
					System.Threading.WaitHandle.WaitAll (new System.Threading.ManualResetEvent[] {resetEvent});
					waiting = monitor.isRunning (es.CriticalActions); 
				}
			}
			Trace.WriteLine("[ConfigurationManager.WaitForSafeState] Estados críticos OK...");
			
			if (es.CriticalIntervals != null) {
				//Trace.WriteLine("[ConfigurationManager.WaitForSafeState] Esperando intervalos críticos...");
				foreach (Interval interval in es.CriticalIntervals) {
               
					waiting = monitor.isRunning (interval.InitialState, interval.FinalState);
					while (waiting) {
						Trace.WriteLine("[ConfigurationManager.WaitForSafeState] Esperando intervalos " + interval.InitialState + " - " + interval.FinalState);
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
				System.Threading.ManualResetEvent temp = resetEvent;
				resetEvent = new System.Threading.ManualResetEvent (false);
				
				temp.Set ();
			}
		}

		public void PersistConfiguration ()
		{
         
		}
		
		protected void SubstituteUnit(MetaUnit uOld, MetaUnit uNew)
		{

		}

		protected void createConcreteUnit(MetaUnit metaUnit, string instanceName)
		{

		}
	}
}
