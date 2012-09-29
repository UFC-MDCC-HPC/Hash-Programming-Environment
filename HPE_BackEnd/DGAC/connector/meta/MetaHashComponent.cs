/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System.Collections.Generic;

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

		/*public MetaHashComponent Clone ()
		{
			MetaHashComponent c = new MetaHashComponent ();
			this.Clone (out c);

			return c;
		}

		protected void Clone (out MetaHashComponent c)
		{

			base.Clone (out c);
			
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
				
				foreach (MetaParameter p in parameters) {
					//c.Parameters.Add (p.Clone ());
				}
			}
			
			if (innerComponents != null) {
				c.InnerComponents = new List<MetaInnerComponent> ();
				
				foreach (MetaInnerComponent mic in innerComponents) {
					c.InnerComponents.Add (mic.Clone ());
				}
			}
			
			if (superComponent != null) {
				c.SuperComponent = superComponent.Clone ();
			}

			if (units != null) {
				c.Units = new Dictionary<string, MetaUnit>();
				foreach(string key in units.Keys) {
					//c.Units.Add (key, units[key].Clone());
				}
			}

			c.LastIdCode = lastIdCode;

		}*/
	}
}
