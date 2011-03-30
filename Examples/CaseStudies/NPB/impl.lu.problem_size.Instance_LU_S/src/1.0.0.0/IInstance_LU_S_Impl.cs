using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_S;
using lu.problem_size.Instance_LU;
using lu.problem_size.Instance;

namespace impl.lu.problem_size.Instance_LU_S { 
	public class IInstance_LU_S_Impl<C> : BaseIInstance_LU_S_Impl<C>, IInstance_LU<C>
	where C:IClass_S {
		public IInstance_LU_S_Impl() { 
		}	
		
		private	double _dt     = 0.5d;
		private	int    _itmax  = 50;
		private	int    _inorm  = 50;
		private	int    _isiz01 = 12;
		private	int    _isiz02 = 12;
		private	int    _isiz03 = 12;
		private	int    _isiz3  = 12;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.A;

		public double dt  { get { return _dt;     } }
		public int itmax  { get { return _itmax;  } }
		public int inorm  { get { return _inorm;  } }
		public int isiz01 { get { return _isiz01; } }
		public int isiz02 { get { return _isiz02; } }
		public int isiz03 { get { return _isiz03; } }
		public int isiz3  { get { return _isiz3;  } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }

		private	double[] _xcrref_ = {1.6196343210976702E-02, 2.1976745164821318E-03, 1.5179927653399185E-03, 1.5029584435994323E-03, 3.4264073155896461E-02}; //    Reference values of RMS-norms of residual.
		private double[] _xceref_ = {6.4223319957960924E-04, 8.4144342047347926E-05, 5.8588269616485186E-05, 5.8474222595157350E-05, 1.3103347914111294E-03}; //    Reference values of RMS-norms of solution error.
		private	double _dtref_ = 5.0E-1;
		private	double _xciref_ = 7.8418928865937083E+00;

		public double[] xcrref { get { return _xcrref_; } }
		public double[] xceref { get { return _xceref_; } }
		public double dtref { get { return _dtref_; } }
		public double xciref { get { return _xciref_; } }
	}
}
