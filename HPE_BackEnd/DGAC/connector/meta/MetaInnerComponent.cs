/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System.Collections.Generic;
using System;

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

		public MetaInnerComponent Clone ()
		{
			//Trace.WriteLine ("[MetaInnerComponent.Clone] clonando o InnerComponent {0}...", identifier);
			MetaInnerComponent c = new MetaInnerComponent();
			Clone (c);

			return c;
		}

		protected void Clone (MetaInnerComponent c)
		{
			base.Clone ((MetaHashComponent) c);

			c.Identifier = identifier;
			c.Access = access;
			c.ExportActions = exportActions;
		}
	}
}
