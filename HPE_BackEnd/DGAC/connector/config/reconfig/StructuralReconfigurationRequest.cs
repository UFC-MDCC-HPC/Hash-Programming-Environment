/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.meta;

namespace br.ufc.pargo.hpe.connector.reconfig {

   //Requisição de alteração estritamente estrutural.
   public class StructuralReconfigurationRequest {

      //Parâmetros de contexto que a alteração resultou na requisição da reconfiguração.
      protected List<MetaParameter> changedParameters;

      //Lista de par (componente velho/novo) a ser alterado.
      protected List<StructuralChange> changes;

      public List<StructuralChange> Changes {
         get{return changes;}
      }

      public StructuralReconfigurationRequest(List<MetaParameter> changedParameters) {
         this.changedParameters = changedParameters;
      }

      public void AddChange(StructuralChange change) {
         if(changes == null) {
            changes = new List<StructuralChange>();
         }
         
         changes.Add(change);
      }
   }
}
