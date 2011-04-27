using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.Evolve { 
	public interface IEvolve<I, C> : BaseIEvolve<I, C>
	where I:IInstance<C>
	where C:IClass{
	   void setParameters(double[, , ,] u0, double[, , ,] u1, double[] twiddle, int d1, int d2, int d3);
	}
}
