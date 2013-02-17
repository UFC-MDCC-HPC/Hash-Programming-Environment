/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System;
using System.Runtime.Serialization;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.meta;

namespace br.ufc.pargo.hpe.connector.config
{
	public class Transition : MarshalByRefObject
	{

		//Transitions simples correspondem a ações de componentes.
		//Transitions complexas são combinadores de ações. (seq, par).
		public enum TransitionType
		{
			SIMPLE,
			COMPLEX
		}

		//internal transtions nao aparecem na lista de açoes que podem ser reconfiguradas.
		public const int INTERNAL_TRANSITION = -1;

		protected TransitionType type;

		public TransitionType Type {
			get { return type;}
			set { type = value;}
		}

		protected List<string> ids;

		public List<string> Ids {
			get{ return ids;}
		}

		protected int initialState;

		public int InitialState {
			get { return initialState;}
			set { initialState = value;}
		}

		protected int finalState;

		public int FinalState {
			get { return finalState;}
			set { finalState = value;}
		}

		protected object action;

		public object Action {
			get { return action;}
			set { action = value;}
		}

		protected bool isElse;

		public bool IsElse {
			get { return isElse;}
			set { isElse = value;}
		}

		public Transition (int initial, int final, object action, int id)
		{
			this.initialState = initial;
			this.finalState = final;
			this.action = action;
			this.isElse = false;

			if (action is ExecutionAction) {
				this.type = TransitionType.SIMPLE;
			} else {
				this.type = TransitionType.COMPLEX;
			}

			this.ids = new List<string> ();
			ids.Add (id + "");
		}

		public void AddId (string id)
		{
			ids.Add (id);
		}

		public ExecutionAction getExecutionAction ()
		{
			if (type == TransitionType.SIMPLE) {
				return (ExecutionAction) action;
			}

			return null;
		}

		public override string ToString ()
		{
			
			string cname = "";
			
			string s = "";
			s += "type: " + type;
			s += " | initialState: " + initialState;
			s += " | finalState: " + finalState;
			s += " | isElse: " + isElse;
			if (type == TransitionType.SIMPLE && getExecutionAction ()!= null && getExecutionAction ().MetaAction != null) {
			 	MetaAction maction = getExecutionAction ().MetaAction;
				s += " | action: " + maction.Name;
				if (maction.Name != null)
					if(maction.Father.Father.GetType().Name.Equals("MetaInnerComponent")) {
						cname = ((MetaInnerComponent) maction.Father.Father).Identifier;
					} else {
						cname = maction.Father.Father.Name;
					}
					
					s += " | slice: " + cname + "." + maction.Father.Name;
					s += "(" + maction.Father.GetType().Name + ")";
			}

			if (type == TransitionType.SIMPLE && getExecutionAction ().Condition != null) {
				s += " | condition: " + getExecutionAction ().Condition;
				
			}      
			return s;
		}
	}
}
