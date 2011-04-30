using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_C;
using lu.problem_size.Instance_LU;
using lu.problem_size.Instance;

namespace impl.lu.problem_size.Instance_LU_C { 
	public class IInstance_LU_C_Impl<C> : BaseIInstance_LU_C_Impl<C>, IInstance_LU<C>
	where C:IClass_C {
		public IInstance_LU_C_Impl() { 		
		}

		private	double _dt     = 2.0d;
		private	int    _itmax  = 250;
		private	int    _inorm  = 250;
		private	int    _isiz01 = 162;
		private	int    _isiz02 = 162;
		private	int    _isiz03 = 162;
		private	int    _isiz3  = 162;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.C;

		public double dt  { get { return _dt;     } }
		public int itmax  { get { return _itmax;  } }
		public int inorm  { get { return _inorm;  } }
		public int isiz01 { get { return _isiz01; } }
		public int isiz02 { get { return _isiz02; } }
		public int isiz03 { get { return _isiz03; } }
		public int isiz3  { get { return _isiz3;  } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }

		private	double[] _xcrref_ = {1.03766980323537846E+04, 8.92212458801008552E+02, 2.56238814582660871E+03, 2.19194343857831427E+03, 1.78078057261061185E+04}; //    Reference values of RMS-norms of residual.
		private double[] _xceref_ = {2.15986399716949279E+02, 1.55789559239863600E+01, 5.41318863077207766E+01, 4.82262643154045421E+01, 4.55902910043250358E+02}; //    Reference values of RMS-norms of solution error.
		private	double _dtref_ = 2.0E+0;
		private	double _xciref_ = 6.66404553572181300E+01;

		public double[] xcrref { get { return _xcrref_; } }
		public double[] xceref { get { return _xceref_; } }
		public double dtref { get { return _dtref_; } }
		public double xciref { get { return _xciref_; } }			
	}
}
