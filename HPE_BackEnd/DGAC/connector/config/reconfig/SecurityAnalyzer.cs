/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;

using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.reconfig {
   
   //Analisador de segurança. Utiliza das informações da configuração e da requisição de reconfiguração.
   //para dar um parecer sobre a reconfiguração. O seu objetivo é retornar um ExecutionStateEvaluation.
   public class SecurityAnalyzer {
      
      /*
      Realiza a avaliação de segurança conforme os parâmetros.
      Para a reconfiguração estrutural são avaliados dois critérios.
      Quais os estados que antecedem ações ligadas a unidades que:
      1- compõe componentes que serão removidos;
      2- possuem fatias de unidades de componentes que serão removidos.
      
      */

      //TODO restringir a avaliação das unidades que NÃO são nativas. 
      public static List<ExecutionStateEvaluation> Evaluate(ReconfigurationRequest request, MetaUnit unit) {
         List<ExecutionStateEvaluation> result = new List<ExecutionStateEvaluation>();
         Queue<MetaUnit> usingSlices = new Queue<MetaUnit>();
         
         List<int> criticalActions;
         List<int> statesToStop;
         List<Interval> intervals;
         MetaUnit oldUnit, usingUnit;
         MetaAction usingAction;
         Configuration protocol;
         
         bool find;
         
         foreach(MetaAction action in unit.Actions) {
            criticalActions = new List<int>();
            statesToStop = new List<int>();
            
            protocol = action.Protocol;
            find = false;
            
            foreach(StructuralChange change in request.StructuralRequest.Changes) {
               oldUnit = change.Old;
               
               /*Verifica:
                1- se a ação faz parte da unidade a ser removida;
               2- se a ação faz parte da unidade que possúi uma fatia (em qualquer nível) a ser removida;
               */
               for(int i=0; i< protocol.actions.Length; i++) {
                  usingAction = protocol.actions[i].MetaAction;
                  usingSlices.Enqueue((MetaUnit) usingAction.Father);
                  
                  while(!find && usingSlices.Count > 0) {
                     usingUnit = usingSlices.Dequeue();
                     
                     if(usingUnit.Id == oldUnit.Id) {
                        find = true;
                     } else {
                        if(usingUnit.Slices != null && usingUnit.Slices.Count > 0) {
                           foreach(MetaSlice ms in usingUnit.Slices) {
                              usingSlices.Enqueue(ms.Unit);
                           }
                        }
                     }
                  }
                  usingSlices.Clear();
                  
                  //Se esta ação pertence ou tem com fatia a unidade a ser removida, lista quais as transições onde ela está presente.
                  if(find) {
                     
                     criticalActions.Add(usingAction.Id);
                     
                     for(int j = 0; j < protocol.matrix.Length; j++) {
                        for(int k = 0; k < protocol.matrix[j].Length/2; k++) {
                           if(protocol.matrix[j][k*2] == i) {
                              statesToStop.Add(j);
                           }
                        }
                     }
                  }
               }
            }

            intervals = new List<Interval>();
            
            foreach(BehavioralReconfigurationRequest behavioralRequest in request.BehavioralRequests) {
               foreach(BehavioralChange change in behavioralRequest.Changes) {
                  
                  if(unit.Name.Equals(change.Unit) && action.Name.Equals(change.Action)) {
                     foreach(Transition transition in protocol.Transitions) {
                        if(transition.Ids.Contains(change.Point)) {
                           statesToStop.Add(transition.InitialState);
                           intervals.Add(new Interval(transition.InitialState, transition.FinalState));
                           
                           break;
                        }
                     }
                  }
                  
               }
            }
            
            if(statesToStop.Count > 0) {
               result.Add(new ExecutionStateEvaluation(action.Name, criticalActions, statesToStop, intervals));
            }
         }
         
         if(result.Count == 0) {
            result = null;
         }
         
         return result;
      }
      
      public static bool isDeadlockFree(List<ExecutionStateEvaluation> evaluations, MetaUnit unit) {
         //TODO escrever o método.
         if(evaluations != null) {
            
         } else {
            return true;
         }
         
         return true;
      }
   }
}
