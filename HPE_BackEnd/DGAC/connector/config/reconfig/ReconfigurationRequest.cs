/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.reconfig {

   //Classe que encapsula uma requisão de reconfiguração sobre uma configuração.
   public class ReconfigurationRequest {

      //identificador do componente alvo a sofrer a reconfiguração.
      protected string targetComponent;
      public string TargetComponent {
         get{return targetComponent;}
         set{targetComponent = value;}
      }

      //Mudança estrutural que deve ser aplicada.
      protected StructuralReconfigurationRequest structuralRequest;
      public StructuralReconfigurationRequest StructuralRequest {
         get {return structuralRequest;}
         set {structuralRequest = value;}
      }

      //Lista das requisições de reconfiguração comportamental.
      protected List<BehavioralReconfigurationRequest> behavioralRequests;
      public List<BehavioralReconfigurationRequest> BehavioralRequests {
         get{return behavioralRequests;}
         set{behavioralRequests = value;}
      }
   }
}
