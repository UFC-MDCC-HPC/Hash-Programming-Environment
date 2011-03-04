/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using bt.solve.Method;
using common.orientation.Axis;

namespace bt.solve.PackUnpack { 

public interface BaseIPackUnpack<I, C, MTH, DIR> : IComputationKind 
where I:IInstance<C>
where C:IClass
where MTH:IMethod
where DIR:IAxis
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
