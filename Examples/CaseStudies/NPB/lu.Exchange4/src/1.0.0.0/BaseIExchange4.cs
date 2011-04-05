/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using common.Buffer;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;

namespace lu.Exchange4 { 
	public interface BaseIExchange4<I, C> : IComputationKind 
	where I:IInstance<C>
	where C:IClass {
		IProblemDefinition<I, C> Problem {get;}
		IBlocksInfo Blocks {get;}
		INeighbors Neighbors {get;}
	}
}
