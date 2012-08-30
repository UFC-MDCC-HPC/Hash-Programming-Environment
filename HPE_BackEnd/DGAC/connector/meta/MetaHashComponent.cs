/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.meta {

   //Classe que representa os metadados de um componente hash.
   public class MetaHashComponent : MetaHashEntity {

       protected string package;
       public string Package {
          get {return package;}
          set {package = value;}
       }

       protected List<string> usingList;
       public List<string> UsingList {
          get {return usingList;}
          set {usingList = value;}
       }

       //TODO kind deve ser um enum.
       protected string kind;
       public string Kind {
          get {return kind;}
          set {kind = value;}
       }
       //Lista dos metadados dos parâmentros de contexto que o componente possúi.
	   protected List<MetaParameter> parameters;
	   public List<MetaParameter> Parameters {
	      get {return parameters;}
	      set {parameters = value;}
	   }
	
	   //Lista dos metadados dos componentes aninhados que o componente possúi.
	   protected List<MetaInnerComponent> innerComponents;
       public List<MetaInnerComponent> InnerComponents {
          get {return innerComponents;}
          set {innerComponents = value;}
       }

       protected MetaHashComponent superComponent;
       public MetaHashComponent SuperComponent {
          get {return superComponent;}
          set {superComponent = value;}
       }

	   //Lista dos metadados das unidades que o componente possúi.
	   protected List<MetaUnit> units;
	   public List<MetaUnit> Units {
	      get {return units;}
	      set {units = value;}
	   }

       protected int lastIdCode;
       public int LastIdCode {
          get {return lastIdCode;}
          set {lastIdCode = value;}
       }

	   public void AddInnerComponent(MetaInnerComponent hc) {
	      if(innerComponents == null) {
	         innerComponents = new List<MetaInnerComponent>();
	      }

	      innerComponents.Add(hc);
	   }
	   
	   public void AddUnit(MetaUnit u) {
	      if(units == null) {
	         units = new List<MetaUnit>();
	      }

          u.Father = this;
	      units.Add(u);
	   }

      public MetaUnit getUnit(string unitName) {
         foreach(MetaUnit u in units) {
            if(u.Name.Equals(unitName)) {
               return u;
            }
         }

         return null;
      }
   }
}
