/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using bt.solve.Method;

namespace bt.solve.SolveCell { 

public interface BaseISolveCell<DIR, MTH, I, C> : IComputationKind 
where DIR:IAxis
where MTH:IMethod
where I:IInstance<C>
where I:IInstance<C>
where C:IClass
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
