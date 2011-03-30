using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_W;
using lu.problem_size.Instance_LU;
using lu.problem_size.Instance;

namespace impl.lu.problem_size.Instance_LU_W { 
	public class IInstance_LU_W_Impl<C> : BaseIInstance_LU_W_Impl<C>, IInstance_LU<C>
	where C:IClass_W {
		public IInstance_LU_W_Impl() { 
		}

		private	double _dt     = 1.5E-3;
		private	int    _itmax  = 300;
		private	int    _inorm  = 300;
		private	int    _isiz01 = 33;
		private	int    _isiz02 = 33;
		private	int    _isiz03 = 33;
		private	int    _isiz3  = 33;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.A;

		public double dt  { get { return _dt;     } }
		public int itmax  { get { return _itmax;  } }
		public int inorm  { get { return _inorm;  } }
		public int isiz01 { get { return _isiz01; } }
		public int isiz02 { get { return _isiz02; } }
		public int isiz03 { get { return _isiz03; } }
		public int isiz3  { get { return _isiz3;  } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }

		private	double[] _xcrref_ = {0.1236511638192E+02, 0.1317228477799E+01, 0.2550120713095E+01, 0.2326187750252E+01, 0.2826799444189E+02}; //    Reference values of RMS-norms of residual.
		private double[] _xceref_ = {0.4867877144216E+00, 0.5064652880982E-01, 0.9281818101960E-01, 0.8570126542733E-01, 0.1084277417792E+01}; //    Reference values of RMS-norms of solution error.
		private	double _dtref_ = 1.5E-3;
		private	double _xciref_ = 0.1161399311023E+02;

		public double[] xcrref { get { return _xcrref_; } }
		public double[] xceref { get { return _xceref_; } }
		public double dtref { get { return _dtref_; } }
		public double xciref { get { return _xciref_; } }
	}
}
