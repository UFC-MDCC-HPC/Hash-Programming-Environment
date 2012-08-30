/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using System.Runtime.Serialization;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.config {

   public class Transition : MarshalByRefObject {

      //Transitions simples correspondem a ações de componentes.
      //Transitions complexas são combinadores de ações. (seq, par, alt, if...).
      public enum TransitionType {
         SIMPLE, COMPLEX
      }

      protected TransitionType type;
      public TransitionType Type {
         get {return type;}
         set {type = value;}
      }

      protected List<string> ids;
      public List<string> Ids {
         get{return ids;}
      }

      protected int initialState;
      public int InitialState {
         get {return initialState;}
         set {initialState = value;}
      }

      protected int finalState;
      public int FinalState {
         get {return finalState;}
         set {finalState = value;}
      }

      protected object action;
      public object Action {
         get {return action;}
         set {action = value;}
      }

      protected bool isElse;
      public bool IsElse {
         get {return isElse;}
         set {isElse = value;}
      }

      public Transition(int initial, int final, object action, int id) {
         this.initialState = initial;
         this.finalState = final;
         this.action = action;
         this.isElse = false;

         if(action is ExecutionAction) {
            this.type = TransitionType.SIMPLE;
         } else {
            this.type = TransitionType.COMPLEX;
         }

         this.ids = new List<string>();
         ids.Add(id + "");
      }

      public void AddId(string id) {
         ids.Add(id);
      }

      public ExecutionAction getExecutionAction() {
         return (ExecutionAction) action;
      }

      public override string ToString() {
         string s = "";
         s += "type: " + type;
         s += " | initialState: " + initialState;
         s += " | finalState: " + finalState;
         s += " | isElse: " + isElse;
         if (type == TransitionType.SIMPLE) {
            s += " | action: " + getExecutionAction().MetaAction.Name;
         }
         
         return s;
      }
   }
}
