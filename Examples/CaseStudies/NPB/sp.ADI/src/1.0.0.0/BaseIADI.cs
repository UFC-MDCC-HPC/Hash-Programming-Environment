/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using environment.MPIDirect;

namespace sp.ADI { 

public interface BaseIADI<C> : IComputationKind 
where C:IClass
{

	IProblemDefinition<IInstance_SP<C>, C> Problem {get;}
	IMPIDirect Mpi {get;}
	ICell X {get;}
	ICell Y {get;}
	ICell Z {get;}
	IBlocks Blocks {get;}


} // end main interface 

} // end namespace 
