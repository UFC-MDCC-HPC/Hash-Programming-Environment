using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_B;
using ft.problem_size.Instance_FT;
using ft.problem_size.Instance;

namespace impl.ft.problem_size.Instance_FT_B { 
	public class IInstance_FT_B_Impl<C> : BaseIInstance_FT_B_Impl<C>, IInstance_FT<C>
	where C:IClass_B {
		public IInstance_FT_B_Impl() { 
		
		} 
		private int _nx =512;
		private int _ny =256;
		private int _nz =256;
		private int _niter_default =20;
		private int _maxdim =512;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.B;
		private	double[] _csum_ref_ = {517.7643571579, 507.7803458597, 515.4521291263, 508.8249431599, 514.6409228649, 509.6208912659, 514.2378756213, 510.1023387619, 513.9626667737, 510.3976610617, 513.7423460082, 510.5948019802, 513.5547056878, 510.7404165783, 513.3910925466, 510.8576573661, 513.2470705390, 510.9577278523, 513.1197729984, 511.0460304483, 513.0070319283, 511.1252433800, 512.9070537032, 511.1968077718, 512.8182883502, 511.2616233064, 512.7393733383, 511.3203605551, 512.6691062020, 511.3735928093, 512.6064276004, 511.4218460548, 512.5504076570, 511.4656139760, 512.5002331720, 511.5053595966, 512.4551951846, 511.5415130407, 512.4146770029, 511.5744692211};
		
		public int nx { get { return _nx; } }
		public int ny { get { return _ny; } }
		public int nz { get { return _nz; } }
		public int niter_default { get { return _niter_default; } }
		public int maxdim { get { return _maxdim; } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }
		public double[] csum_ref { get { return _csum_ref_; } }
	}
}
