/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.config;

using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.connector.meta
{
   
	//Classe que representa os metadados das unidades de um componente hash.
	public class MetaUnit : MetaHashEntity
	{
      
		protected int index;

		public int Index {
			get { return index;}
			set { index = value;}
		}
      
		protected int split;

		public int Split {
			get { return split;}
			set { split = value;}
		}
      
		protected bool parallel;

		public bool Parallel {
			get{ return parallel;}
			set{ parallel = value;}
		}
      
		public override Object Entity {
			get { return entity;}
			set {
				entity = value;
				linkEntities ();
			}         
		}
      
		//Lista de metadados das ações vinculadas à unidade.
		protected Dictionary<string, MetaAction> actions;

		public Dictionary<string, MetaAction> Actions {
			get { return actions;}
			set { actions = value;
				if (value != null) {
					foreach (MetaAction a in value.Values) {
						a.Father = this;
					}
				}
			}
		}
      
		protected Dictionary<string, Condition> conditions;

		public Dictionary<string, Condition> Conditions {
			get { return conditions;}
			set { conditions = value;}
		}
      
		//Lista da fatias dos componente aninhados que participam desta unidade.
		protected Dictionary<string, MetaSlice> slices;

		public Dictionary<string, MetaSlice> Slices {
			get { return slices;}
			set { slices = value;}
		}
      
		protected IConfigurationManager configManager;

		public IConfigurationManager ConfigManager {
			get { return configManager;}
			set { configManager = value;}
		}
      
		//protocolo de valição da unidade.
		//TODO ALTO definir representação e forma de execução da validação.
		protected string validationProtocol;

		public MetaUnit ()
		{
			this.conditions = new Dictionary<string, Condition> ();
			this.parallel = true;
			this.split = 1;
		}

		public void AddAction (string name, MetaAction a)
		{
			if (actions == null) {
				actions = new Dictionary<string, MetaAction>();
			}
         
			a.Father = this;
			actions.Add (name, a);
		}
      
		public void AddSlice (string name, MetaSlice slice)
		{
			if (slices == null) {
				slices = new Dictionary<string, MetaSlice> ();
			}
         
			slices.Add (name, slice);
		}
      
		public void linkEntities ()
		{
         
			System.Console.WriteLine (Name);
			System.Console.WriteLine (Entity.ToString ());
         
			if (slices != null) {
				IUnit unit = (IUnit)entity;
            
				foreach (MetaSlice slice in slices.Values) {
					slice.Unit.Entity = unit.Slice [slice.Inner];
				}
			}
         
			GenerateDelegates ();
		}
      
		/*
      Gera os delegates das ações e fatias.
      */
		public void GenerateDelegates ()
		{
         
			if (actions != null) {
				foreach (MetaAction a in actions.Values) {
					if (a.IsNative) {
						a.Entity = (MetaAction.DAction)Delegate.CreateDelegate (typeof(MetaAction.DAction), Entity, a.Name);
					}
				}
			}
         
			if (conditions != null) {
				foreach (Condition c in conditions.Values) {
					if (c.Cond != null && !c.Cond.Equals ("")) {
						c.Guard = (Condition.DCondition)Delegate.CreateDelegate (typeof(Condition.DCondition), Entity, c.Cond);
					}
				}
			}
         
			if (slices != null && slices.Count > 0) {
				foreach (MetaSlice s in slices.Values) {
					s.Unit.linkEntities ();
				}
			}
		}

	}
}
