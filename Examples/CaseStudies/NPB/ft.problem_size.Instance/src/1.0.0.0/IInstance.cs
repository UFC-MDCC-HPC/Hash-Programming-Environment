using br.ufc.pargo.hpe.kinds;

using common.problem_size.Class;

namespace ft.problem_size.Instance { 

public enum PROBLEM_CLASS {U, S, W, A, B, C};

public interface IInstance<C> : BaseIInstance<C>
    where C:IClass
{
	int nx { get; }
	int ny { get; }
	int nz { get; }
	int niter_default { get; }
	int maxdim { get; }
	PROBLEM_CLASS CLASS { get; }

	double[] csum_ref { get; }
} // end main interface 

} // end namespace 
