/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.Buffer;
using common.solve.Forward;
using common.solve.BeamWarmingMethod;
using common.orientation.X;
using common.solve.BlockDiagonalMatVecProduct;
using common.interactionpattern.Shift;
using common.direction.LeftToRight;
using common.solve.LHS;
using environment.MPIDirect;
using common.problem_size.Instance;
using common.solve.Backward;
using common.solve.Solve;

namespace impl.sp.solve.XSolve { 

public abstract class BaseIXSolveImpl<I, C, MTH, DIR>: Computation, BaseISolve<I, C, MTH, DIR>
where I:IInstance_SP<C>
where C:IClass
where MTH:IBeamWarmingMethod
where DIR:IX
{

private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
	}
}

private ICell cell = null;

public ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("topology");
		return this.cell;
	}
}

private IProblemDefinition<I, C> problem = null;

public IProblemDefinition<I, C> Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
		return this.problem;
	}
}

private IBuffer output_buffer = null;

protected IBuffer Output_buffer {
	get {
		if (this.output_buffer == null)
			this.output_buffer = (IBuffer) Services.getPort("output_buffer");
		return this.output_buffer;
	}
}

private IBuffer input_buffer = null;

protected IBuffer Input_buffer {
	get {
		if (this.input_buffer == null)
			this.input_buffer = (IBuffer) Services.getPort("input_buffer");
		return this.input_buffer;
	}
}

private IForward<I, C, MTH, DIR> forward = null;

protected IForward<I, C, MTH, DIR> Forward {
	get {
		if (this.forward == null)
			this.forward = (IForward<I, C, MTH, DIR>) Services.getPort("forward");
		return this.forward;
	}
}

private IBlockDiagonalMatVecProduct<I, C, DIR, MTH> matvecproduct = null;

protected IBlockDiagonalMatVecProduct<I, C, DIR, MTH> Matvecproduct {
	get {
		if (this.matvecproduct == null)
			this.matvecproduct = (IBlockDiagonalMatVecProduct<I, C, DIR, MTH>) Services.getPort("matvecproduct");
		return this.matvecproduct;
	}
}

private IShift<ILeftToRight> shift = null;

protected IShift<ILeftToRight> Shift {
	get {
		if (this.shift == null)
			this.shift = (IShift<ILeftToRight>) Services.getPort("shift");
		return this.shift;
	}
}

private ILHS<I, C, DIR, MTH> lhs = null;

protected ILHS<I, C, DIR, MTH> Lhs {
	get {
		if (this.lhs == null)
			this.lhs = (ILHS<I, C, DIR, MTH>) Services.getPort("lhs");
		return this.lhs;
	}
}

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		return this.mpi;
	}
}


private IBackward<I, C, DIR, MTH> backward = null;

protected IBackward<I, C, DIR, MTH> Backward {
	get {
		if (this.backward == null)
			this.backward = (IBackward<I, C, DIR, MTH>) Services.getPort("backward");
		return this.backward;
	}
}


abstract public void compute(); 


}

}
