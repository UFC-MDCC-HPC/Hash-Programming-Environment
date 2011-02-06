/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;
using common.orientation.Axis;

namespace common.solve.Forward { 

public interface BaseIForward<I, C, MTH, DIR> : IComputationKind 
where I:IInstance<C>
where C:IClass
where MTH:IMethod
where DIR:IAxis
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
