using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_W;
using ft.problem_size.Instance_FT;
using ft.problem_size.Instance;

namespace impl.ft.problem_size.Instance_FT_W { 
	public class IInstance_FT_W_Impl<C> : BaseIInstance_FT_W_Impl<C>, IInstance_FT<C>
	where C:IClass_W{
		public IInstance_FT_W_Impl() { 
		
		}
		private int _nx =128;
		private int _ny =128;
		private int _nz =32;
		private int _niter_default =6;
		private int _maxdim =128;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.W;
		private	double[] _csum_ref_ = {567.3612178944, 529.3246849175, 563.1436885271, 528.2149986629, 559.4024089970, 527.0996558037, 556.0698047020, 526.0027904925, 553.0898991250, 524.9400845633, 550.4159734538, 523.9212247086};
		
		public int nx { get { return _nx; } }
		public int ny { get { return _ny; } }
		public int nz { get { return _nz; } }
		public int niter_default { get { return _niter_default; } }
		public int maxdim { get { return _maxdim; } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }
		public double[] csum_ref { get { return _csum_ref_; } }
	}
}
