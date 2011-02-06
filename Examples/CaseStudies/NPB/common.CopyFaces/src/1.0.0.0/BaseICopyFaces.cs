/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.Buffer;
using common.data.ProblemDefinition;
using environment.MPIDirect;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace common.CopyFaces { 

public interface BaseICopyFaces<I,C> : ISynchronizerKind 
		where I:IInstance<C>
		where C:IClass
{

	ICell Y {get;}
	ICell X {get;}
	ICell Z {get;}
	IBlocks Blocks {get;}
	IProblemDefinition<I,C> Problem {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
