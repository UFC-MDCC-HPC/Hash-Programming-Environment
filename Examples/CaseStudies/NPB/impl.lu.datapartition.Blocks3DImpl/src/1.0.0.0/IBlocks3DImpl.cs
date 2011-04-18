using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.Blocks3D;

namespace impl.lu.datapartition.Blocks3DImpl { 
	public class IBlocks3DImpl<I, C> : BaseIBlocks3DImpl<I, C>, IBlocks3D<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
		public IBlocks3DImpl() { 
		
		} 
		
		public static double mod(double a, double b) { return (a % b); }
		public static int nodedim(double n) { return (int)(Math.Log(n) / Math.Log(2.0d) + 0.00001); }
		protected int _north, _south, _east, _west, _node, _xdim, _ydim, _row, _col;
		
		override public void initialize(){
            int _num    = this.Ranks.Length;
            _node   = this.GlobalRank;         
            int _ndim   = nodedim(_num);
            
            //proc_grid
            _xdim   = (int)Math.Pow(2, (_ndim/2));
            if(mod(_ndim, 2)==1) _xdim = _xdim + _xdim;
            _ydim   = _num/_xdim;
            _row    = (int)mod(_node, _xdim) + 1;
            _col    = _node/_xdim + 1;
            //
			
            _south = -1; _east  = -1; _north = -1; _west  = -1;
            if(_row>1) _north = _node -1;
            else _north = -1;
            if(_row < _xdim) _south = _node + 1;
            else _south = -1;
            
            if(_col > 1) _west = _node - _xdim;
            else _west = -1;
            if(_col < _ydim) _east = _node + _xdim;
            else _east = -1;

			Blocks.west = X.predecessor = _west;   /* west */
			Blocks.east = X.successor = _east;     /* east */
			Blocks.north = Y.predecessor = _north;   /* north */
			Blocks.south = Y.successor = _south;     /* south */
			
		    Blocks.col /*= Cell.col */= _col;
		    Blocks.row /*= Cell.row */= _row;
		    Blocks.xdim /*= Cell.xdim */= _xdim;
		    Blocks.ydim /*= Cell.ydim*/ = _ydim;		   

			Blocks.nx0   = Instance.isiz01;
		    Blocks.ny0   = Instance.isiz02;
		    Blocks.nz0   = Instance.isiz03;
		    Blocks.isiz3 = Instance.isiz3;
		}
		
		public void configBlock(){
		   Blocks.subDomain();
		}	
	}
}