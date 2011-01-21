/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.Buffer;
using common.data.ProblemDefinition;
using environment.MPIDirect;

namespace common.CopyFaces { 

public interface BaseICopyFaces : ISynchronizerKind 
{

	ICell Y {get;}
	ICell X {get;}
	ICell Z {get;}
	IBlocks Blocks {get;}
	IProblemDefinition Problem {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
