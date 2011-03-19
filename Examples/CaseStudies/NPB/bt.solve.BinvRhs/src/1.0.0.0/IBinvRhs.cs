using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;

namespace bt.solve.BinvRhs { 
	public interface IBinvRhs<I, C, MTH> : BaseIBinvRhs<I, C, MTH>
	where I:IInstance<C>
	where C:IClass
	where MTH:IMethod {
	   void setParameters(double[,,] lhs, 
	                      double[,,,,] r, 
	                      int l1, 
	                      int r1, int r2, int r3, int r4);
	}
}
