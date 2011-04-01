using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.datapartition.ProcGrid;

namespace impl.lu.datapartition.ProcGridImpl { 
	public class IProcGridImpl : BaseIProcGridImpl, IProcGrid {
	   
		public IProcGridImpl() { 
		
		} 
		override public void initialize(){
            int _num    = this.Ranks.Length;
            int _node   = this.GlobalRank;         
            int _ndim   = nodedim(_num);
            
            _xdim   = (int)Math.Pow(2, (_ndim/2));
            if(mod(_ndim, 2)==1)
                _xdim = _xdim + _xdim;
            _ydim   = _num/_xdim;
            _row    = (int)mod(_node, _xdim) + 1;
            _col    = _node/_xdim + 1; 
		}
		public static double mod(double a, double b) { return (a % b); }
		public static int nodedim(double n) { return (int)(Math.Log(n) / Math.Log(2.0d) + 0.00001); }			
		
		protected int _xdim, _ydim, _row, _col;
		public int xdim      { get { return _xdim;   } }
		public int ydim      { get { return _ydim;   } }
		public int row       { get { return _row;    } }
		public int col       { get { return _col;    } }
	}
}
