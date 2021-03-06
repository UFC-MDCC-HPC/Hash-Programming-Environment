/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.Buffer;
using environment.MPIDirect;
using common.solve.Method;
using common.orientation.Axis;

namespace common.solve.Solve { 

public interface BaseISolve<I, C, MTH, DIR> : IComputationKind 
where I:IInstance<C>
where C:IClass
where MTH:IMethod
where DIR:IAxis
{

	IBlocks Blocks {get;}
	ICell Cell {get;}
	IProblemDefinition<I, C> Problem {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
