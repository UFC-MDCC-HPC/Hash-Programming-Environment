/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;
using System.Runtime.Serialization;
using System;

namespace br.ufc.pargo.hpe.connector.meta {

   //Representação pósfixada.
   public class Condition : MarshalByRefObject {

      public enum Operator {AND, OR};

      //Declaração de um delegate que simboliza as avalições de condições das actions dos componentes nativos (escritos em c#).
      //As configurações terão referencias à esses métodos a partir de uma instância de DCondition.
      public delegate bool DCondition();

      protected Queue<Operator> operators;
      public Queue<Operator> Operators {
         get{return operators;}
         set{operators = value;}
      }

      protected Queue<bool> not;
      public Queue<bool> Not {
         get{return not;}
         set{not = value;}
      }

      protected Queue<DCondition> delegates;
      public Queue<DCondition> Delegates {
         get{return delegates;}
         set{delegates = value;}
      }

      public Condition() {
         operators = new Queue<Operator>();
         not = new Queue<bool>();
         delegates = new Queue<DCondition>();
      }

      public void AddOperator(Operator o) {
         operators.Enqueue(o);
      }

      public void AddDelegate(bool b, DCondition deleg) {
         delegates.Enqueue(deleg);
         not.Enqueue(b);
      }

      public void AddDelegate(DCondition deleg) {
         AddDelegate(false, deleg);
      }

      public bool Evaluate() {
         bool result;
         DCondition runnable;
         
         runnable = delegates.Dequeue();
         result = runnable() ^ not.Dequeue();
         
         foreach(Operator o in operators) {
            runnable = delegates.Dequeue();

            if(o == Operator.AND) {
               result = result && (runnable() ^ not.Dequeue());
            } else {
               result = result || (runnable() ^ not.Dequeue());
            }
         }

         return result;
      }
   }
}
