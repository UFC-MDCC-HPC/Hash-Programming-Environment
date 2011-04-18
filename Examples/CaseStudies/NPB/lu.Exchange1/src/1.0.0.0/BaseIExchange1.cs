/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;
using lu.datapartition.BlocksInfo;

namespace lu.Exchange1 
{ 
	public interface BaseIExchange1<I, C> : IComputationKind 
		where I:IInstance<C>
		where C:IClass 
	{
	   IProblemDefinition<I, C> Problem {get;}
	   IBlocksInfo Blocks {get;}
	   ICell Y {get;}
	   ICell X {get;}
	   IMPIDirect Mpi {get;}
	}
}
