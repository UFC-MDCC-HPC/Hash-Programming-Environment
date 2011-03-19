using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;

namespace bt.solve.MatVecSub { 
	public interface IMatVecSub<I, C, MTH> : BaseIMatVecSub<I, C, MTH>
	where I:IInstance<C>
	where C:IClass
	where MTH:IMethod {
	   void setParameters(double[, ,] ablock, 
	                      double[, , , ,] avec, 
	                      double[, , , ,] bvec, 
	                      int ab1, 
	                      int av1, int av2, int av3, int av4, 
	                      int bv1, int bv2, int bv3, int bv4);
	}
}
