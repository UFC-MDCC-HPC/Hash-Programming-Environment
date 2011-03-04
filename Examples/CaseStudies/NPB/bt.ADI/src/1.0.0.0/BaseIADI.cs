/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using environment.MPIDirect;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace bt.ADI { 

public interface BaseIADI<C> : IComputationKind 
where C:IClass
{

	ICell Y {get;}
	ICell Z {get;}
	ICell X {get;}
	IBlocks Blocks {get;}
	IBlocks Blocks {get;}
	IBlocks Blocks {get;}
	IMPIDirect Mpi {get;}
	IProblemDefinition<IInstance<C>, C> Problem {get;}
	IProblemDefinition<IInstance<C>, C> Problem {get;}
	IProblemDefinition<IInstance<C>, C> Problem {get;}


} // end main interface 

} // end namespace 
