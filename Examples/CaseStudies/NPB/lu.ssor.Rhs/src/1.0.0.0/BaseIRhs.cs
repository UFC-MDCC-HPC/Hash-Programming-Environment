/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using common.topology.Ring;
using environment.MPIDirect;

namespace lu.ssor.Rhs { 

public interface BaseIRhs<I, C> : IComputationKind 
where I:IInstance<C>
where C:IClass
{

	IProblemDefinition<I, C> Problem {get;}
	IBlocksInfo Blocks {get;}
	ICell X {get;}
	ICell Y {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
