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
        //protected int _nx0 = 0, _ny0 = 0, _nz0 = 0;
		protected int _isiz01 = 0, _isiz3 = 0;//_isiz02 = 0, _isiz03 = 0,_itmax = 0, _inorm = 0, 
		protected double _dt = 0.0;		
		protected int _isiz1, _isiz2;	//_xdim, _ydim, _row, _col, _node, _ndim, _num,
				
		protected bool[] _icommn, _icomms, _icomme, _icommw;

		public IProblemDefinitionImpl() {
		}
		
		override public void initialize(){
		    setProblemClass();

            int _num    = this.Ranks.Length;
//            _node   = this.GlobalRank;         
//            _ndim   = Constants.nodedim(_num);
            
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

//			_icommn = new bool[_nx0+_ny0+1];
//			_icomms = new bool[_nx0+_ny0+1];
//			_icomme = new bool[_nx0+_ny0+1];
//			_icommw = new bool[_nx0+_ny0+1];
                
            A.initialize_field ("a", _isiz2, _isiz1, 5, 5);
            B.initialize_field ("b", _isiz2, _isiz1, 5, 5);
            _C.initialize_field("c", _isiz2, _isiz1, 5, 5);
            D.initialize_field ("d", _isiz2, _isiz1, 5, 5);
            
            U.initialize_field   ("u"   , _isiz3, _isiz2+4, _isiz1+4, 5);
            Rsd.initialize_field ("rsd" , _isiz3, _isiz2+4, _isiz1+4, 5);
            Frct.initialize_field("frct", _isiz3, _isiz2+4, _isiz1+4, 5);
            Flux.initialize_field("flux", _isiz3, _isiz2+2, _isiz1+2, 5);
            
            //proc_grid()
//	            _xdim   = (int)Math.Pow(2, (_ndim/2));
//	            if(Constants.mod(_ndim, 2)==1)
//	                _xdim = _xdim + _xdim;
//	            _ydim   = _num/_xdim;
//	            _row    = (int)Constants.mod(_node, _xdim) + 1;
//	            _col    = _node/_xdim + 1; 
            //           

            Constants.setConstants(Instance.isiz01,Instance.isiz02,Instance.isiz03);
		}
		
		private void setProblemClass(){
//			_itmax  = Instance.itmax;
//			_inorm  = Instance.inorm;
			_isiz01 = Instance.isiz01;
//			_isiz02 = Instance.isiz02;
//			_isiz03 = Instance.isiz03;
//			_isiz3  = Instance.isiz3;
//            _dt     = Instance.dt;
		}
		
		public double [,,,] Field_a { get { return A.Field; } }
		public double [,,,] Field_b { get { return B.Field; } }
		public double [,,,] Field_c { get { return _C.Field; } }
		public double [,,,] Field_d { get { return D.Field; } }

		public double [,,,] Field_rsd  { get { return Rsd.Field;  } }
		public double [,,,] Field_frct { get { return Frct.Field; } }
		public double [,,,] Field_flux { get { return Flux.Field; } }
		public double [,,,] Field_u    { get { return U.Field;    } }
		
//		public int node      { get { return _node;   } }
//		public int ndim      { get { return _ndim;   } }
//		public int num       { get { return _num;    } }
//		public int xdim      { get { return _xdim;   } }
//		public int ydim      { get { return _ydim;   } }
//		public int row       { get { return _row;    } }
//		public int col       { get { return _col;    } }
		
//		public int nx0       { get { return _nx0;    } }
//		public int ny0       { get { return _ny0;    } }
//		public int nz0       { get { return _nz0;    } }
		
//        public int itmax  { get { return _itmax;    } }
//        public int inorm  { get { return _inorm;    } }
//        public int isiz01 { get { return _isiz01;   } }
//        public int isiz02 { get { return _isiz02;   } }
//        public int isiz03 { get { return _isiz03;   } }
//        public int isiz3  { get { return _isiz3;    } }
//		public double dt  { get { return _dt;       } }
				
//		public bool[] icommn { get { return _icommn; } }
//		public bool[] icomms { get { return _icomms; } }
//		public bool[] icomme { get { return _icomme; } }
//		public bool[] icommw { get { return _icommw; } }
		public int isiz1     { get { return _isiz1;  } }
		public int isiz2     { get { return _isiz2;  } } 		
	}
}
