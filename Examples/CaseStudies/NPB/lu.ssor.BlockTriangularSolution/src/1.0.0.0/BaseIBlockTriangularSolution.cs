/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using common.topology.Ring;
using common.Discretization;
using environment.MPIDirect;

namespace lu.ssor.BlockTriangularSolution { 
	public interface BaseIBlockTriangularSolution<I, C, DIS> : IComputationKind 
	where I:IInstance<C>
	where C:IClass
	where DIS:IDiscretization{
		IProblemDefinition<I, C> Problem {get;}
		IBlocksInfo Blocks {get;}
		ICell X {get;}
		ICell Y {get;}
		IMPIDirect Mpi {get;}
	}
}
