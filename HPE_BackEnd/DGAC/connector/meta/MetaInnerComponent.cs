/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.meta
{
	public class MetaInnerComponent : MetaHashComponent
	{

		protected string identifier;

		public string Identifier {
			get { return identifier;}
			set { identifier = value;}
		}

		protected string access;

		public string Access {
			get { return access;}
			set { access = value;}
		}

		protected bool exportActions;
      
		public bool ExportActions {
			get { return exportActions;}
			set { exportActions = value;}
		}

		//TODO Concluir a implementaçao.
		public MetaInnerComponent Clone ()
		{
			MetaInnerComponent c = new MetaInnerComponent ();
			c.Id = id;
			c.Name = name;
			c.Entity = entity;
			c.Father = father;

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

				foreach(MetaParameter p in parameters) {
					c.Parameters.Add (p.Clone());
				}
			}
		}
	}
}
