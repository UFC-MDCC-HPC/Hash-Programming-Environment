/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using br.ufc.pargo.hpe.connector.meta;

using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.reconfig {
   
   public class BehavioralReconfigurationRequest {

      protected List<MetaInnerComponent> newInnerComponents;
      public List<MetaInnerComponent> NewInnerComponents {
         get {return newInnerComponents;}
         set {newInnerComponents = value;}
      }

      protected List<BehavioralChange> changes;
      public List<BehavioralChange> Changes {
         get {return changes;}
         set {changes = value;}
      }

      public void AddChange(BehavioralChange bc) {
         if(changes == null) {
            changes = new List<BehavioralChange>();
         }

         changes.Add(bc);
      }
   }
}
