using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;

namespace bt.solve.MatMulSub { 
	public interface IMatMulSub<I, C, MTH> : BaseIMatMulSub<I, C, MTH>
	where I:IInstance<C>
	where C:IClass
	where MTH:IMethod {
	   void setParameters(double[,,] ablock, 
	                      double[,,,,,] bblock, 
	                      double[,,] cblock, 
	                      int a1, 
	                      int b1, int b2, int b3, int b4, 
	                      int c1);
	}
}
