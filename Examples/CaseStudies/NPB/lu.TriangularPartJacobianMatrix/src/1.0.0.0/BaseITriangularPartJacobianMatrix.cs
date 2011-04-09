/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using common.Discretization;

namespace lu.TriangularPartJacobianMatrix { 
	public interface BaseITriangularPartJacobianMatrix<I, C, DIS> : IComputationKind 
	where I:IInstance<C>
	where C:IClass
	where DIS:IDiscretization{
		IProblemDefinition<I, C> Problem {get;}
		IBlocksInfo Blocks {get;}
	}
}
