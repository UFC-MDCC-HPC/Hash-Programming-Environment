using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_S;
using ft.problem_size.Instance_FT;
using ft.problem_size.Instance;

namespace impl.ft.problem_size.Instance_FT_S { 
	public class IInstance_FT_S_Impl<C> : BaseIInstance_FT_S_Impl<C>, IInstance_FT<C>
	where C:IClass_S {
		public IInstance_FT_S_Impl() { 
		
		}
		private int _nx =64;
		private int _ny =64;
		private int _nz =64;
		private int _niter_default =6;
		private int _maxdim =64;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.S;
		private	double[] _csum_ref_ = {554.6087004964, 484.5363331978, 554.6385409189, 486.5304269511, 554.6148406171, 488.3910722336, 554.5423607415, 490.1273169046, 554.4255039624, 491.7475857993, 554.2683411902, 493.2597244941};
		
		public int nx { get { return _nx; } }
		public int ny { get { return _ny; } }
		public int nz { get { return _nz; } }
		public int niter_default { get { return _niter_default; } }
		public int maxdim { get { return _maxdim; } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }
		public double[] csum_ref { get { return _csum_ref_; } }
	}
}
