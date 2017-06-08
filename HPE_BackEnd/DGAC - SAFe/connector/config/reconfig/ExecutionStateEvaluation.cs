/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.reconfig {

   //Classe que representa uma avaliação de segurança de uma reconfiguração.
   public class ExecutionStateEvaluation {

      protected string actionName;
      public string ActionName {
         get{return actionName;}
         set{actionName = value;}
      }

      //Lista de ações (nomes) que são críticas, ou seja, que não podem estar em execução durante a reconfiguração.
      //TODO trocar a lista de nomes por id. 
      protected List<int> criticalActions;

      public List<int> CriticalActions {
         get {return criticalActions;}
         set {criticalActions = value;}
      }

      //Lista de estados de que devem ser suspensos para que possa ser realizada a reconfiguração. 
      protected List<int> statesToStop;

      public List<int> StatesToStop {
         get {return statesToStop;}
         set {statesToStop = value;}
      }

      protected List<Interval> criticalIntervals;
      public List<Interval> CriticalIntervals {
         get {return criticalIntervals;}
         set {criticalIntervals = value;}
      }

      //Construtor.
      public ExecutionStateEvaluation(string actionName, List<int> criticalActions, List<int> statesToStop, List<Interval> criticalIntervals) {
         this.actionName = actionName;
         this.criticalActions = criticalActions;
         this.statesToStop = statesToStop;
         this.criticalIntervals = criticalIntervals;
      }

      public override string ToString() {
         string s;

         s = "CRITICAL ACTIONS: ";
         
         foreach(int action in criticalActions) {
            s += action + ", ";
         }
         
         s += '\n' + "STATES TO STOP: ";
         
         foreach(int state in statesToStop) {
            s += state + ", ";
         }
         
         s += '\n';
         
         return s;
      }
   }
}
