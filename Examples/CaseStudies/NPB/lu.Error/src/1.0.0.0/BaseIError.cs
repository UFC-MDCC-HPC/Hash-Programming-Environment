/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using environment.MPIDirect;

namespace lu.Error { 
	public interface BaseIError<I, C> : IComputationKind 
	where I:IInstance<C>
	where C:IClass {
		IProblemDefinition<I, C> Problem {get;}
		IBlocksInfo Blocks {get;}
		IMPIDirect Mpi {get;}
	}
	
}
