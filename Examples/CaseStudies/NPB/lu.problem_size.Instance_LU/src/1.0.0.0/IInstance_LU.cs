using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using lu.problem_size.Instance;

namespace lu.problem_size.Instance_LU { 
	public interface IInstance_LU<C> : BaseIInstance_LU<C>, IInstance<C>
	where C:IClass {
		double[] xcrref { get; }
		double[] xceref { get; }
		double dtref { get; }
		double xciref { get; }
	}
}
