/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;
using common.Discretization;

namespace lu.BlockTriangularSolution { 
	public interface BaseIBlockTriangularSolution<I, C, DIS> : IComputationKind 
	where I:IInstance<C>
	where C:IClass
	where DIS:IDiscretization{
		IProblemDefinition<I, C> Problem {get;}
		IBlocksInfo Blocks {get;}
		INeighbors Neighbors {get;}
	}
}
