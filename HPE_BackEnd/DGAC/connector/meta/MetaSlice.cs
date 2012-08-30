/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;

namespace br.ufc.pargo.hpe.connector.meta {

   public class MetaSlice : MarshalByRefObject {

      protected string alias;
      public string Alias {
         get {return alias;}
         set {alias = value;}
      }

      protected MetaUnit unit;
	  public MetaUnit Unit {
	     get {return unit;}
	     set {unit = value;}
      }

      public MetaSlice(MetaUnit unit) {
         this.unit = unit;
      }
   }
}
