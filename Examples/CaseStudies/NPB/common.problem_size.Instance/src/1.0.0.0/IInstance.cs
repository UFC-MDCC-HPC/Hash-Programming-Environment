using br.ufc.pargo.hpe.kinds;

using common.problem_size.Class;

namespace common.problem_size.Instance { 

public enum PROBLEM_CLASS {U, S, W, A, B, C};

public interface IInstance<C> : BaseIInstance<C>
	where C:IClass
{
	int problem_size { get; }
	int niter_default { get; }
	double dt_default { get; }
	PROBLEM_CLASS CLASS { get; }

	double[] xcrref { get; }
	double[] xceref { get; }
	double dtref { get; }	
} // end main interface 

} // end namespace 
