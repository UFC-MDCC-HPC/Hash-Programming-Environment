using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_A;
using lu.problem_size.Instance_LU;
using lu.problem_size.Instance;

namespace impl.lu.problem_size.Instance_LU_A { 
	public class IInstance_LU_A_Impl<C> : BaseIInstance_LU_A_Impl<C>, IInstance_LU<C>
	where C:IClass_A {
		public IInstance_LU_A_Impl() {
		}

		private	double _dt     = 2.0d;
		private	int    _itmax  = 250;
		private	int    _inorm  = 250;
		private	int    _isiz01 = 64;
		private	int    _isiz02 = 64;
		private	int    _isiz03 = 64;
		private	int    _isiz3  = 64;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.A;

		public double dt  { get { return _dt;     } }
		public int itmax  { get { return _itmax;  } }
		public int inorm  { get { return _inorm;  } }
		public int isiz01 { get { return _isiz01; } }
		public int isiz02 { get { return _isiz02; } }
		public int isiz03 { get { return _isiz03; } }
		public int isiz3  { get { return _isiz3;  } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }

		private	double[] _xcrref_ = {7.7902107606689367E+02, 6.3402765259692870E+01, 1.9499249727292479E+02, 1.7845301160418537E+02, 1.8384760349464247E+03}; //    Reference values of RMS-norms of residual.
		private double[] _xceref_ = {2.9964085685471943E+01, 2.8194576365003349E+00, 7.3473412698774742E+00, 6.7139225687777051E+00, 7.0715315688392578E+01}; //    Reference values of RMS-norms of solution error.
		private	double _dtref_ = 2.0E+0;
		private	double _xciref_ = 2.6030925604886277E+01;

		public double[] xcrref { get { return _xcrref_; } }
		public double[] xceref { get { return _xceref_; } }
		public double dtref { get { return _dtref_; } }
		public double xciref { get { return _xciref_; } }
	}
}
