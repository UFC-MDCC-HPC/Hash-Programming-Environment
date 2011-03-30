using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_B;
using lu.problem_size.Instance_LU;
using lu.problem_size.Instance;

namespace impl.lu.problem_size.Instance_LU_B { 
	public class IInstance_LU_B_Impl<C> : BaseIInstance_LU_B_Impl<C>, IInstance_LU<C>
	where C:IClass_B {	
		public IInstance_LU_B_Impl() { 		
		}

		private	double _dt     = 2.0d;
		private	int    _itmax  = 250;
		private	int    _inorm  = 250;
		private	int    _isiz01 = 102;
		private	int    _isiz02 = 102;
		private	int    _isiz03 = 102;
		private	int    _isiz3  = 102;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.A;

		public double dt  { get { return _dt;     } }
		public int itmax  { get { return _itmax;  } }
		public int inorm  { get { return _inorm;  } }
		public int isiz01 { get { return _isiz01; } }
		public int isiz02 { get { return _isiz02; } }
		public int isiz03 { get { return _isiz03; } }
		public int isiz3  { get { return _isiz3;  } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }

		private	double[] _xcrref_ = {3.5532672969982736E+03, 2.6214750795310692E+02, 8.8333721850952190E+02, 7.7812774739425265E+02, 7.3087969592545314E+03}; //    Reference values of RMS-norms of residual.
		private double[] _xceref_ = {1.1401176380212709E+02, 8.1098963655421574E+00, 2.8480597317698308E+01, 2.5905394567832939E+01, 2.6054907504857413E+02}; //    Reference values of RMS-norms of solution error.
		private	double _dtref_ = 2.0E+0;
		private	double _xciref_ = 4.7887162703308227E+01;

		public double[] xcrref { get { return _xcrref_; } }
		public double[] xceref { get { return _xceref_; } }
		public double dtref { get { return _dtref_; } }
		public double xciref { get { return _xciref_; } }		
	}
}
