/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.Buffer;
using environment.MPIDirect;
using common.orientation.Axis;
using common.solve.Method;

namespace bt.solve.Solve { 

public interface BaseISolve<DIR, I, C, MTH> : IComputationKind 
where DIR:IAxis
where I:IInstance<C>
where C:IClass
where MTH:IMethod
{

	IBlocks Blocks {get;}
	ICell Cell {get;}
	IProblemDefinition<I, C> Problem {get;}
	IBuffer Input_buffer {get;}
	IBuffer Output_buffer {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
