using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.topology.Neighbors;

namespace impl.lu.topology.NeighborsImpl { 
	public class INeighborsImpl : BaseINeighborsImpl, INeighbors {
		public INeighborsImpl() { 
		
		} 
		override public void initialize(){
            int _num    = this.Ranks.Length;
            _node   = this.GlobalRank;         
            int _ndim   = nodedim(_num);
            
            //proc_grid
            _xdim   = (int)Math.Pow(2, (_ndim/2));
            if(mod(_ndim, 2)==1)
                _xdim = _xdim + _xdim;
            _ydim   = _num/_xdim;
            _row    = (int)mod(_node, _xdim) + 1;
            _col    = _node/_xdim + 1;
            //
            
            _south = -1;
            _east  = -1;
            _north = -1;
            _west  = -1;
            if(_row>1) {
                _north = _node -1;
            }
            else {
                _north = -1;
            }
            if(_row < _xdim) {
                _south = _node + 1;
            }
            else {
                _south = -1;
            }

            if(_col > 1) {
                _west = _node - _xdim;
            }
            else {
                _west = -1;
            }
            if(_col < _ydim) {
                _east = _node + _xdim;
            }
            else {
                _east = -1;
            }             
		}
		public static double mod(double a, double b) { return (a % b); }
		public static int nodedim(double n) { return (int)(Math.Log(n) / Math.Log(2.0d) + 0.00001); }
		
		protected int _north, _south, _east, _west, _node, _xdim, _ydim, _row, _col;
		public int north      { get { return _north;   } }
		public int south      { get { return _south;   } }
		public int east      { get { return _east;   } }
		public int west      { get { return _west;   } }
		
		public int node { get { return _node;   } }
        public int xdim { get { return _xdim;   } }        
        public int ydim { get { return _ydim;   } }
        public int row { get { return _row;   } }
        public int col { get { return _col;   } }		
   }
}
