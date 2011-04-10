/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;

namespace lu.BoundaryValues { 

public interface BaseIBoundaryValues<I, C> : IComputationKind 
where I:IInstance<C>
where C:IClass
{

	IProblemDefinition<I, C> Problem {get;}
	IBlocksInfo Blocks {get;}


} // end main interface 

} // end namespace 
