using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.data.ComputeInitialConditions { 
	public interface IComputeInitialConditions<I, C> : BaseIComputeInitialConditions<I, C>
	where I:IInstance<C>
	where C:IClass{
	   void setParameters(double[, , ,] u1);
	}
}
