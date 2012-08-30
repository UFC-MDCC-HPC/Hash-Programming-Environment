/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

namespace br.ufc.pargo.hpe.connector.meta {

   //Representa os metadados dos parâmetros de contexto de um componente hash.
   public class MetaParameter : MetaHashEntity {

      //Parâmetros que suas variáveis tem valores NULL são similares a parâmetros livres.
      public readonly string NULL = "null";

      //Nome identificador do parâmetro.
      public string Identifier {
         get {return name;}
         set {name = value;}
      }

      //Nome da variável do parâmetro.
      protected string variable;
      public string Variable {
         get {return variable;}
         set {variable = value;}
      }

      //Metadado do componente hash que determina o limite superior do parâmetro.
      protected MetaHashComponent limit;
      public MetaHashComponent Limit {
         get {return limit;}
         set {limit = value;}
      }

   }
}
