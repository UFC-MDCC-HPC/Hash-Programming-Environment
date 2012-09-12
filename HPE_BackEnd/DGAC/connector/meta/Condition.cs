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
	public class Condition : MarshalByRefObject
	{

		public enum Operator
		{
			AND,
			OR}
		;

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

		protected List<Condition> conditions;

		protected DCondition guard;
		protected DCondition Guard {
			set { guard = value;}
		}

		public List<Condition> Conditions {
			get{ return conditions;}
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
			this.guard = null;
			oper = null;
		}

		//TODO criar uma soluçao interativa.
		public bool Evaluate ()
		{
			bool result;

			if (guard == null && oper == null) {
				result = fixedValue;

			} else if (guard != null) {
				result = guard ();

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
	}
}
