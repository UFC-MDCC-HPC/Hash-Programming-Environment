using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace bt.solve.LhsABInit { 
	public interface ILhsABInit<I, C> : BaseILhsABInit<I, C>
	where I:IInstance<C>
	where C:IClass {
	   void setParameters(double[,,] lhsa, double[,,] lhsb, int size);
	} // end main interface 
} // end namespace 
