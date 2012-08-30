/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;

using br.ufc.pargo.hpe.connector.meta;

namespace br.ufc.pargo.hpe.connector.config {

   public class ExecutionAction : MarshalByRefObject {

      protected int id;
      public int Id {
         get {return id;}
         set {id = value;}
      }

      protected MetaAction metaAction;
      public MetaAction MetaAction {
         get{return metaAction;}
         set{metaAction = value;}
      }

      //Representação do método em linguagem nativa que realiza uma validação de condição.
      //O tipo DRunnable está descrito em MetaHashEntity. O método aqui associado (através de delegate)
      //deverá não receber parâmetros e retornar um booleano.
      protected Condition condition;
      public Condition Condition {
         get{return condition;}
         set{condition = value;}
      }

      public ExecutionAction(MetaAction mAction, Condition cond) {
         this.metaAction = mAction;
         this.Condition = cond;
      }
   }
   
   
}
