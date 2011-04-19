using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_A;
using ft.problem_size.Instance_FT;
using ft.problem_size.Instance;

namespace impl.ft.problem_size.Instance_FT_A { 
	public class IInstance_FT_A_Impl<C> : BaseIInstance_FT_A_Impl<C>, IInstance_FT<C>
	where C:IClass_A {
		public IInstance_FT_A_Impl() { 
		
		} 
		private int _nx =256;
		private int _ny =256;
		private int _nz =128;
		private int _niter_default =6;
		private int _maxdim =256;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.A;
		private	double[] _csum_ref_ = {504.6735008193, 511.4047905510, 505.9412319734, 509.8809666433, 506.9376896287, 509.8144042213, 507.7892868474, 510.1336130759, 508.5233095391, 510.4914655194, 509.1487099959, 510.7917842803};
		
		public int nx { get { return _nx; } }
		public int ny { get { return _ny; } }
		public int nz { get { return _nz; } }
		public int niter_default { get { return _niter_default; } }
		public int maxdim { get { return _maxdim; } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }
		public double[] csum_ref { get { return _csum_ref_; } }
	}
}
