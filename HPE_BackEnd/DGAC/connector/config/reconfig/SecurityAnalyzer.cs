/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;

using System.Collections.Generic;
using System;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.connector.reconfig
{
   
	//Analisador de segurança. Utiliza das informações da configuração e da requisição de reconfiguração.
	//para dar um parecer sobre a reconfiguração. O seu objetivo é retornar um ExecutionStateEvaluation.
	public class SecurityAnalyzer
	{
      
		/*
      Realiza a avaliação de segurança conforme os parâmetros.
      Para a reconfiguração estrutural são avaliados dois critérios.
      Quais os estados que antecedem ações ligadas a unidades que:
      1- compõe componentes que serão removidos;
      2- possuem fatias de unidades de componentes que serão removidos.
      
      */

		public static List<ExecutionStateEvaluation> Evaluate (ReconfigurationRequest request, MetaUnit unit)
		{
			List<ExecutionStateEvaluation> result = new List<ExecutionStateEvaluation> ();
			Queue<MetaUnit> usingSlices = new Queue<MetaUnit> ();
         
			List<int> criticalActions;
			List<int> statesToStop;
			List<Interval> intervals;
			MetaUnit oldUnit, usingUnit;
			MetaAction usingAction;
			Configuration protocol;
         
			bool find;
         
			foreach (MetaAction action in unit.Actions.Values) {
				Trace.WriteLine ("[SecurityAnalyzer.Evaluate] Avaliando a ação: " + action.Father.Name + "." + action.Name);
				criticalActions = new List<int> ();
				statesToStop = new List<int> ();
            
				protocol = action.Protocol;
				if (protocol == null) {
				    Trace.WriteLine ("[SecurityAnalyzer.Evaluate] Protocolo nulo");
					continue;
				}
				find = false;
            
				if (request.StructuralRequest != null) {
					foreach (StructuralChange change in request.StructuralRequest.Changes) {
						
						oldUnit = change.Old;
						//Trace.WriteLine ("[SecurityAnalyzer.Evaluate] Mudança estrutural: " + oldUnit.Name);
						if (isChangeConcrete (change)) {
						
							/*Verifica:
                	1- se a ação faz parte da unidade a ser removida;
               		2- se a ação faz parte da unidade que possúi uma fatia (em qualquer nível) a ser removida;
               		*/
							for (int i=0; i< protocol.Actions.Count; i++) {
								usingAction = protocol.Actions [i].MetaAction;
								//Trace.WriteLine ("[SecurityAnalyzer.Evaluate] Avaliando a ação de indice {0}", i);
								
								if (usingAction != null && usingAction.Father != null) {
									usingSlices.Enqueue ((MetaUnit)usingAction.Father);
                  
									while (!find && usingSlices.Count > 0) {
										usingUnit = usingSlices.Dequeue ();
                     
										if (usingUnit.Id == oldUnit.Id) {
											find = true;
										} else {
											if (usingUnit.Slices != null && usingUnit.Slices.Count > 0) {
												foreach (MetaSlice ms in usingUnit.Slices.Values) {
													//Trace.WriteLine ("Using Slice {0}", ms.Unit.Name);
													usingSlices.Enqueue (ms.Unit);
												}
											}
										}
									}
								}
								usingSlices.Clear ();
                  				
								//Se esta ação pertence ou tem com fatia a unidade a ser removida, lista quais as transições onde ela está presente.
								if (find) {

									criticalActions.Add (usingAction.Id);
                     				
									for (int j = 0; j < protocol.Matrix.Count; j++) {
										for (int k = 0; k < protocol.Matrix[j].Count/Configuration.BASE; k++) {
											if (protocol.Matrix [j] [k * Configuration.BASE] == i) {
												statesToStop.Add (j);
											}
										}
									}
								}
								
								find = false;
							}
						}
						
					}
				}

				intervals = new List<Interval> ();
            
				BehavioralReconfigurationRequest behavioralRequest = request.BehavioralRequest;
				
				if (behavioralRequest != null && behavioralRequest.Changes != null) {
					Trace.WriteLine ("[SecurityAnalyzer.Evaluate] Avaliando as reconfigurações comportamentais...");
					foreach (BehavioralChange change in behavioralRequest.Changes) {
                  
						if (unit.Name.Equals (change.Unit) && action.Name.Equals (change.Action)) {
							foreach (Transition transition in protocol.Transitions) {
								if (transition.Ids.Contains (change.Point)) {
									statesToStop.Add (transition.InitialState);
									//Rever as paradas de intervalos. Ações simples não funciona.
									//intervals.Add (new Interval (transition.InitialState, transition.FinalState));
                           
									break;
								}
							}
						}
					}
				}
            
				Trace.WriteLine ("[SecurityAnalyzer.Evaluate] Definindo os estados críticos...");
				if (statesToStop.Count > 0) {
					result.Add (new ExecutionStateEvaluation (action.Name, criticalActions, statesToStop, intervals));
				}
			}
         
			if (result.Count == 0) {
				result = null;
			}
         
			return result;
		}
      
		public static bool isDeadlockFree (List<ExecutionStateEvaluation> evaluations, MetaUnit unit)
		{
			//TODO escrever o método.
			if (evaluations != null) {
            
			} else {
				return true;
			}
         
			return true;
		}
		
		public static void condenseEvaluation() {
			//List<ExecutionStateEvaluation> evaluations, MetaUnit unit
		}

		public static bool isChangeConcrete (StructuralChange change)
		{
			if (change.Old.Name.Equals ("solve")) {
				return true;
			} else {
				Trace.WriteLine ("[SecurityAnalyzer.IsChangeConcrete] Parametros" +
				                          " não definem novo componente concreto para '{0}'!",
				                          ((MetaInnerComponent)change.Old.Father).Identifier);
				return false;
			}
		}
	}
}
