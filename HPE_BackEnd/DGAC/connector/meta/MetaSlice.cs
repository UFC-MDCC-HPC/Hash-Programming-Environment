/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using System;

namespace br.ufc.pargo.hpe.connector.meta
{
	public class MetaSlice : MarshalByRefObject
	{

		protected string inner;

		public string Inner {
			get { return inner;}
			set { inner = value;}
		}

		protected MetaUnit unit;

		public MetaUnit Unit {
			get { return unit;}
			set { unit = value;}
		}

		public MetaSlice (MetaUnit unit)
		{
			this.unit = unit;
		}
		
		public MetaSlice Clone() {
			
			//Trace.WriteLine ("[MetaSlice.Clone] clonando slice {0}...", inner);
			MetaSlice slice = new MetaSlice(unit.Clone());
			slice.inner = inner;

			return slice;
		}

	}
}
