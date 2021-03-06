/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System.Collections.Generic;
using System.Runtime.Serialization;
using System;

namespace br.ufc.pargo.hpe.connector.meta
{

	//Representação pósfixada.
	public class Condition : MetaHashEntity
	{

		public enum Operator
		{
			NULL,
			FIXED,
			AND,
			OR
		};

		//Declaração de um delegate que simboliza as avalições de condições das actions dos componentes nativos (escritos em c#).
		//As configurações terão referencias à esses métodos a partir de uma instância de DCondition.
		public delegate bool DCondition ();

		protected string slice;
		public string Slice {
			get { return slice;}
		}
		
		protected string cond;
		public string Cond {
			get { return cond;}
		}

		protected Operator oper;

		protected bool not;

		protected bool fixedValue;

		protected List<Condition> conditions = new List<Condition>();

		public DCondition Guard {
			set { entity = value;}
		}

		public List<Condition> Conditions {
			get{ return conditions;}
		}
		
		protected Condition() {
		
		}
		
		public Condition (string slice, string cond, bool not)
		{
			this.slice = slice;
			this.cond = cond;
			this.not = not;
		}

		public Condition (Operator o, bool not)
		{
			this.oper = o;
			this.not = not;
		}

		public Condition (bool fixedValue, bool not)
		{
			this.fixedValue = fixedValue;
			this.slice = null;
			this.entity = null;
			oper = Operator.FIXED;
		}

		//TODO criar uma soluçao interativa.
		public bool Evaluate ()
		{
			bool result;

			if (entity == null && oper == Operator.FIXED) {
				result = fixedValue;

			} else if (entity != null) {
				DCondition guard = (DCondition) entity;
				result = guard();
				
			} else if (oper == Operator.NULL) {
				
				Console.WriteLine("conditions.Count = " + conditions.Count);
				if (conditions.Count > 0) 
				{
					Condition c = conditions[0];
					Console.WriteLine("Condition is "+ c.Slice + "/" + c.Name);
				}
				result = conditions[0].Evaluate();

			} else {
				result = (oper == Operator.AND);

				foreach (Condition c in conditions) {
					
					if (oper == Operator.AND) {
						result = result && c.Evaluate();
					} else {
						result = result || c.Evaluate();
					}
				}
			}
			
			return (result ^ not);
		}
		
		public override string ToString ()
		{
			string s= "[" + slice + "." + cond + "] | ";
			if(conditions != null && conditions.Count > 0) {
				foreach(Condition c in conditions) {
					s += c;
				}
			}
			
			return s;
		}
		
		public Condition Clone() {
			//Console.WriteLine ("[Condition.Clone] clonando o condition {0}...", cond);
			Condition clone = new Condition();
			
			Clone (clone);
			
			return clone;
		}
		
		public void Clone(Condition clone) {
			
			//Console.WriteLine ("[Condition.Clone] Base Condition...");
			clone.slice = slice;
			clone.cond = cond;
			clone.oper = oper;
			clone.not = not;
			clone.fixedValue = fixedValue;
			
			if(conditions != null) {
				clone.conditions = new List<Condition>();	
				foreach(Condition c in conditions) {
					clone.conditions.Add (c.Clone());
				}
			}
		}
	}
}
