using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.data.ProblemDefinition;

namespace impl.ft.data.ProblemDefinitionImpl { 
	public class IProblemDefinitionImpl<I, C> : BaseIProblemDefinitionImpl<I, C>, IProblemDefinition<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
		public IProblemDefinitionImpl() { 
		   
		}
        override public void initialize(){
           
        }
        public void problemConfig(int _np1, int _np2, int _layout_type){
            setProblemClass();
            _np = this.Ranks.Length;
			this._np1 = _np1;
			this._np2 = _np2;
			_ntdivnp = ((nx*ny)/_np)*nz;
			this._layout_type = _layout_type;
			int layout_0D = Constants.layout_0D;
			int layout_1D = Constants.layout_1D;
			int layout_2D = Constants.layout_2D;

//            if(_np1 == 1 && _np2 == 1) {
//                _layout_type = layout_0D;
//            }
//            else if(_np1 == 1) {
//                _layout_type = layout_1D;
//            }
//            else {
//                _layout_type = layout_2D;
//            }

            if(_layout_type == layout_0D) {
                for(int i = 0; i < 3; i++) {
                    _dims[0, i] = nx;
                    _dims[1, i] = ny;
                    _dims[2, i] = nz;
                }
            }
            else if(_layout_type == layout_1D) {
                _dims[0, 0] = nx;
                _dims[1, 0] = ny;
                _dims[2, 0] = nz;

                _dims[0, 1] = nx;
                _dims[1, 1] = ny;
                _dims[2, 1] = nz;

                _dims[0, 2] = nz;
                _dims[1, 2] = nx;
                _dims[2, 2] = ny;
            }
            else if(_layout_type == layout_2D) {
                _dims[0, 0] = nx;
                _dims[1, 0] = ny;
                _dims[2, 0] = nz;

                _dims[0, 1] = ny;
                _dims[1, 1] = nx;
                _dims[2, 1] = nz;

                _dims[0, 2] = nz;
                _dims[1, 2] = nx;
                _dims[2, 2] = ny;

            }
            _dims[1, 0] = _dims[1, 0] / _np1;
            _dims[2, 0] = _dims[2, 0] / _np2;
            _dims[1, 1] = _dims[1, 1] / _np1;
            _dims[2, 1] = _dims[2, 1] / _np2;
            _dims[1, 2] = _dims[1, 2] / _np1;
            _dims[2, 2] = _dims[2, 2] / _np2;

            U0.initialize_field("u0", _dims[1, 0], _dims[2, 0], _dims[0, 0], 2);
            U1.initialize_field("u1", _dims[2, 0], _dims[1, 0], _dims[0, 0], 2);
            U2.initialize_field("u2", _dims[1, 0], _dims[2, 0], _dims[0, 0], 2);

            _u = new double[nx, 2];
            _twiddle = new double[_ntdivnp];
        }     
		private void setProblemClass() {
		    nx = Instance.nx;
			ny = Instance.ny;
			nz = Instance.nz;
		}
		public double [,,,] Field_u0     { get { return U0.Field; } }
		public double [,,,] Field_u1     { get { return U1.Field; } }
		public double [,,,] Field_u2     { get { return U2.Field; } }
		public double[] twiddle          { get { return _twiddle; } }
		public double[,] u               { get { return _u;       } }
		public int[,] dims            { get { return _dims;    } }
		
		public int np          { get { return _np;          } set { _np = value;          } }
		public int np1         { get { return _np1;         } set { _np1 = value;         } }
		public int np2         { get { return _np2;         } set { _np2 = value;         } }
		public int layout_type { get { return _layout_type; } set { _layout_type = value; } }
		public int ntdivnp     { get { return _ntdivnp;     } set { _ntdivnp = value;     } }
		
      	protected double[]  _twiddle;
		protected double[,] _u;
		protected int[,] _dims;
		protected int _np,_np1,_np2,_layout_type,_ntdivnp, nx, ny, nz;
	}
}
