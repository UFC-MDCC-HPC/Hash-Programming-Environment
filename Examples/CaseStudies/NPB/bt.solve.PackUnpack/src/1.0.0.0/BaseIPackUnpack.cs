/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;
using common.orientation.Axis;

namespace bt.solve.PackUnpack { 

public interface BaseIPackUnpack<I, C, DIR, MTH> : IComputationKind 
where I:IInstance<C>
where C:IClass
where DIR:IAxis
where MTH:IMethod
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
