/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/
using br.ufc.pargo.hpe.connector.meta;

namespace br.ufc.pargo.hpe.connector.reconfig
{

	//Indicação das unidades presentes em uma mudança estutural.
	public class StructuralChange
	{

		public StructuralChange (MetaUnit old, MetaUnit _new)
		{
			this.old = old;
			this._new = _new;
		}
		
		//Unit a ser removido.
		protected MetaUnit old;

		public MetaUnit Old {
			get{ return old;}
			set{ old = value;}
		}

		//Unit que irá substituir a old.
		protected MetaUnit _new;
      
		public MetaUnit New {
			get{ return _new;}
			set{ _new = value;}
		}

	}
}
