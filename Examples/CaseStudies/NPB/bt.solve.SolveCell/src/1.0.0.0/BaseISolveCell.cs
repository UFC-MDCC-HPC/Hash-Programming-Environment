/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;

namespace bt.solve.SolveCell { 

public interface BaseISolveCell<DIR, I, C, MTH> : IComputationKind 
where DIR:IAxis
where I:IInstance<C>
where C:IClass
where MTH:IMethod
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
