/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.datapartition.BlocksInfo;
using environment.MPIDirect;

namespace common.error.RHSNorm { 

public interface BaseIRHSNorm<I,C> : IComputationKind 
where I:IInstance<C>
where C:IClass
{
		
	IBlocks Blocks {get;}
	IProblemDefinition<I,C> Problem {get;}
	IMPIDirect Mpi {get;}



} // end main interface 

} // end namespace 
