/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System.Collections.Generic;
using System;

namespace br.ufc.pargo.hpe.connector.meta
{

	//Classe que representa os metadados de um componente hash.
	public class MetaHashComponent : MetaHashEntity
	{

		protected string package;

		public string Package {
			get { return package;}
			set { package = value;}
		}

		protected List<string> usingList;

		public List<string> UsingList {
			get { return usingList;}
			set { usingList = value;}
		}

		//TODO kind deve ser um enum.
		protected string kind;

		public string Kind {
			get { return kind;}
			set { kind = value;}
		}
		//Lista dos metadados dos parâmentros de contexto que o componente possúi.
		protected List<MetaParameter> parameters;

		public List<MetaParameter> Parameters {
			get { return parameters;}
			set { parameters = value;}
		}
	
		//Lista dos metadados dos componentes aninhados que o componente possúi.
		protected List<MetaInnerComponent> innerComponents;

		public List<MetaInnerComponent> InnerComponents {
			get { return innerComponents;}
			set { innerComponents = value;}
		}

		protected MetaHashComponent superComponent;

		public MetaHashComponent SuperComponent {
			get { return superComponent;}
			set { superComponent = value;}
		}

		//Lista dos metadados das unidades que o componente possúi.
		protected Dictionary<string, MetaUnit> units;

		public Dictionary<string, MetaUnit> Units {
			get { return units;}
			set {
				units = value;
				if (value != null) {
					foreach (MetaUnit u in value.Values) {
						u.Father = this;
					}
				}
			}
		}

		protected int lastIdCode;

		public int LastIdCode {
			get { return lastIdCode;}
			set { lastIdCode = value;}
		}

		public void AddInnerComponent (MetaInnerComponent hc)
		{
			if (innerComponents == null) {
				innerComponents = new List<MetaInnerComponent> ();
			}

			innerComponents.Add (hc);
		}
	   
		public void AddUnit (string unitName, MetaUnit u)
		{
			if (units == null) {
				units = new Dictionary<string, MetaUnit> ();
			}

			u.Father = this;
			units.Add (unitName, u);
		}

		public MetaHashComponent Clone ()
		{
			MetaHashComponent c = new MetaHashComponent ();
			this.Clone (c);

			return c;
		}

		protected void Clone (MetaHashComponent c)
		{

			//Trace.WriteLine ("[MetaHashComponent.Clone] Base MetaHashComponent...");
			base.Clone ((MetaHashEntity) c);
			
			c.Package = package;
			c.Kind = kind;
			
			if (usingList != null) {
				c.UsingList = new List<string> ();
				
				foreach (string u in usingList) {
					c.UsingList.Add (u);
				}
			}
			
			if (parameters != null) {
				c.Parameters = new List<MetaParameter> ();
				
				//Para os nossos propósitos, não se deve clonar os parameters.
				foreach (MetaParameter p in parameters) {
					c.Parameters.Add (p);
				}
			}
			
			if (innerComponents != null) {
				c.InnerComponents = new List<MetaInnerComponent> ();
				
				MetaInnerComponent clone;
				foreach (MetaInnerComponent mic in innerComponents) {
					clone = mic.Clone ();
					clone.Father = c;
					c.InnerComponents.Add (clone);
				}
			}
			
			if (superComponent != null) {
				c.SuperComponent = superComponent.Clone ();
				c.SuperComponent.Father = c;
			}

			if (units != null) {
				MetaUnit clone;
				c.Units = new Dictionary<string, MetaUnit>();
				foreach(string key in units.Keys) {
					clone = units[key].Clone();
					clone.Father = c;
					c.Units.Add (key, clone);
				}
			}

			c.LastIdCode = lastIdCode;

		}
	}
}
