/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
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

	ICell Cell {get;}
	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
