/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using System.Runtime.Serialization;

namespace br.ufc.pargo.hpe.connector.meta {

   //Classe abstrata básica que simboliza as meta informações das entidades do HPE.
   //A partir desta as outras classes serão herdadas.
   //[Serializable()]
   public abstract class MetaHashEntity : MarshalByRefObject {

      //Chave de identificação única da entidade em tempo de execução.
      //Deverá ser provida pelo Back-End no momento da carga do componente. 
      protected int id;

      public int Id {
	     get {return id;}
	     set {id = value;}
	  }

      //Nome da entidade. Atualmente está sendo usado pelo processo para identificar unicamente uma instância.
	  protected string name;

	  public string Name {
	     get {return name;}
	     set {name = value;}
	  }

      //A entidade HPE que está sendo simbolizada por este metadado. Por exemplo, um componente hash, ou uma unidade.
      protected Object entity;

      public virtual Object Entity {
         get {return entity;}
         set {entity = value;}
      }

      //A Entidade pai da instância. Nos casos de de MetaAction o pai será um MetaUnit. As MetaUnits terão MetaHashComponent.
      // MetaHashComponent tem pai null.
      protected MetaHashEntity father;

      public MetaHashEntity Father {
         get {return father;}
         set {father = value;}
      }
   }
}
