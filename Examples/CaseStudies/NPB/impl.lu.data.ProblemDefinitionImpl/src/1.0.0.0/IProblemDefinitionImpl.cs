using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.data.ProblemDefinition;

namespace impl.lu.data.ProblemDefinitionImpl { 
	public class IProblemDefinitionImpl<I, C> : BaseIProblemDefinitionImpl<I, C>, IProblemDefinition<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
        protected int _nx0 = 0, _ny0 = 0, _nz0 = 0;
		protected int _itmax = 0, _inorm = 0, _isiz01 = 0, _isiz02 = 0, _isiz03 = 0, _isiz3 = 0;
		protected double _dt = 0.0;		
		protected int _node, _ndim, _num, _xdim, _ydim, _row, _col, _isiz1, _isiz2;	
				
		protected bool[] _icommn, _icomms, _icomme, _icommw;

		public IProblemDefinitionImpl() {
		}
		
		override public void initialize(){
		    setProblemClass();
			_icommn = new bool[_nx0+_ny0+1];
			_icomms = new bool[_nx0+_ny0+1];
			_icomme = new bool[_nx0+_ny0+1];
			_icommw = new bool[_nx0+_ny0+1];
			
            _num    = this.Ranks.Length;
            _node   = this.GlobalRank;         
            _ndim   = Constants.nodedim(_num);
            
            int ydiv = Constants.ilog2(_num)/2;
            int xdiv = ydiv;
            if(xdiv + ydiv != Constants.ilog2(_num))
                xdiv += 1;
            xdiv = Constants.ipow2(xdiv);
            ydiv = Constants.ipow2(ydiv);
            _isiz1 = _isiz01 / xdiv;
            if(_isiz1 * xdiv < _isiz01)
                _isiz1++;
            _isiz2 = _isiz01 / ydiv;
            if(_isiz2 * ydiv < _isiz01)
                _isiz2++;
                
            
                
            
            setConstants(0);
		}
		
		private void setProblemClass(){
	        _nx0 = Instance.isiz01;
			_ny0 = Instance.isiz02;
			_nz0 = Instance.isiz03;
			
			_itmax  = Instance.itmax;
			_inorm  = Instance.inorm;
			_isiz01 = Instance.isiz01;
			_isiz02 = Instance.isiz02;
			_isiz03 = Instance.isiz03;
			_isiz3  = Instance.isiz3;
            _dt     = Instance.dt;
		}
		
		private void setConstants(int ij){
		   Constants.setConstants(ij);
		}
		
		public double [,,,] Field_a { get { return A.Field; } }
		public double [,,,] Field_b { get { return B.Field; } }
		public double [,,,] Field_c { get { return _C.Field; } }
		public double [,,,] Field_d { get { return D.Field; } }

		public double [,,,] Field_rsd  { get { return Rsd.Field;  } }
		public double [,,,] Field_frct { get { return Frct.Field; } }
		public double [,,,] Field_flux { get { return Flux.Field; } }
		public double [,,,] Field_u    { get { return U.Field;    } }
		
		public int node      { get { return _node;   } }
		public int ndim      { get { return _ndim;   } }
		public int num       { get { return _num;    } }
		public int xdim      { get { return _xdim;   } }
		public int ydim      { get { return _ydim;   } }
		public int row       { get { return _row;    } }
		public int col       { get { return _col;    } }
		
		public int nx0       { get { return _nx0;    } }
		public int ny0       { get { return _ny0;    } }
		public int nz0       { get { return _nz0;    } }
		
        public int itmax  { get { return _itmax;    } }
        public int inorm  { get { return _inorm;    } }
        public int isiz01 { get { return _isiz01;   } }
        public int isiz02 { get { return _isiz02;   } }
        public int isiz03 { get { return _isiz03;   } }
        public int isiz3  { get { return _isiz3;    } }
		public double dt  { get { return _dt;       } }
				
		public bool[] icommn { get { return _icommn; } }
		public bool[] icomms { get { return _icomms; } }
		public bool[] icomme { get { return _icomme; } }
		public bool[] icommw { get { return _icommw; } }
		public int isiz1     { get { return _isiz1;  } }
		public int isiz2     { get { return _isiz2;  } } 		
	}
}
