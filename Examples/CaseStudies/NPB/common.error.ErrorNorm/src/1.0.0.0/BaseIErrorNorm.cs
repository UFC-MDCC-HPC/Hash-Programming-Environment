/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using environment.MPIDirect;

namespace common.error.ErrorNorm { 

public interface BaseIErrorNorm<I, C> : IComputationKind 
where I:IInstance<C>
where C:IClass		
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
