/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector.meta {

   public class MetaInnerComponent : MetaHashComponent {

      protected string identifier;

      public string Identifier {
         get {return identifier;}
         set {identifier = value;}
      }

      protected string access;

      public string Access {
         get {return access;}
         set {access = value;}
      }

      protected bool exportActions;
      
      public bool ExportActions {
         get {return exportActions;}
         set {exportActions = value;}
      }
   }
}
