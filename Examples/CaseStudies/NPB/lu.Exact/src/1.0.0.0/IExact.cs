using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Exact { 
	public interface IExact<I, C> : BaseIExact<I, C>
	where I:IInstance<C>
	where C:IClass {
	   void setParameters(int i, int j, int k, double[,,,] u000ijk, int i1, int i2, int i3);
	}
}
