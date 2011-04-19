using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class_C;
using ft.problem_size.Instance_FT;
using ft.problem_size.Instance;

namespace impl.ft.problem_size.Instance_FT_C { 
	public class IInstance_FT_C_Impl<C> : BaseIInstance_FT_C_Impl<C>, IInstance_FT<C>
	where C:IClass_C {
		public IInstance_FT_C_Impl() { 
		
		}
		private int _nx =512;
		private int _ny =512;
		private int _nz =512;
		private int _niter_default =20;
		private int _maxdim =512;
		private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.C;
		private	double[] _csum_ref_ = {519.5078707457, 514.9019699238, 515.5422171134, 512.7578201997, 514.4678022222, 512.2251847514, 514.0150594328, 512.1090289018, 513.7550426810, 512.1143685824, 513.5811056728, 512.1496764568, 513.4569343165, 512.1870921893, 513.3651975661, 512.2193250322, 513.2955192805, 512.2454735794, 513.2410471738, 512.2663649603, 513.1971141679, 512.2830879827, 513.1605205716, 512.2965869718, 513.1290734194, 512.3075927445, 513.1012720314, 512.3166486553, 513.0760908195, 512.3241541685, 513.0528295923, 512.3304037599, 513.0310107773, 512.3356167976, 513.0103090133, 512.3399592211, 512.9905029333, 512.3435588985, 512.9714421109, 512.3465164008};
		
		public int nx { get { return _nx; } }
		public int ny { get { return _ny; } }
		public int nz { get { return _nz; } }
		public int niter_default { get { return _niter_default; } }
		public int maxdim { get { return _maxdim; } }
		public PROBLEM_CLASS CLASS { get { return _CLASS_; } }
		public double[] csum_ref { get { return _csum_ref_; } }
	}
}
