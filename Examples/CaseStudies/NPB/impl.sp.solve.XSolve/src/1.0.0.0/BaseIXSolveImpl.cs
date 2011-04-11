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
using common.direction.RightToLeft;
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
		
#region data
		
protected int[,] start, end, slice, cell_size;
protected double[,,,,] lhs, rhs;
protected int ncells;
		
override public void initialize()
{
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	slice = Blocks.cell_slice;
	cell_size = Blocks.cell_size;
	
	ncells = Problem.NCells;
	lhs = Problem.Field_lhs;
	rhs = Problem.Field_rhs;
}		
		
#endregion
		
private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
		{
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		}
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
		{
			this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
		}
		return this.problem;
	}
}

private IBuffer output_buffer_forward = null;

protected IBuffer Output_buffer_forward {
	get {
		if (this.output_buffer_forward == null)
			this.output_buffer_forward = (IBuffer) Services.getPort("output_buffer_forward");
		return this.output_buffer_forward;
	}
}

private IBuffer input_buffer_forward = null;

protected IBuffer Input_buffer_forward {
	get {
		if (this.input_buffer_forward == null)
			this.input_buffer_forward = (IBuffer) Services.getPort("input_buffer_forward");
		return this.input_buffer_forward;
	}
}

private IBuffer output_buffer_backward = null;

protected IBuffer Output_buffer_backward {
	get {
		if (this.output_buffer_backward == null)
			this.output_buffer_backward = (IBuffer) Services.getPort("output_buffer_backward");
		return this.output_buffer_backward;
	}
}

private IBuffer input_buffer_backward = null;

protected IBuffer Input_buffer_backward {
	get {
		if (this.input_buffer_backward == null)
			this.input_buffer_backward = (IBuffer) Services.getPort("input_buffer_backward");
		return this.input_buffer_backward;
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

private IShift<ILeftToRight> shift_forward = null;

protected IShift<ILeftToRight> Shift_forward {
	get {
		if (this.shift_forward == null)
			this.shift_forward = (IShift<ILeftToRight>) Services.getPort("shift_forward");
		return this.shift_forward;
	}
}

private IShift<IRightToLeft> shift_backward = null;

protected IShift<IRightToLeft> Shift_backward {
	get {
		if (this.shift_backward == null)
			this.shift_backward = (IShift<IRightToLeft>) Services.getPort("shift_backward");
		return this.shift_backward;
	}
}

private ILHS<I, C, DIR, MTH> lhs_ = null;

protected ILHS<I, C, DIR, MTH> Lhs {
	get {
		if (this.lhs_ == null)
			this.lhs_ = (ILHS<I, C, DIR, MTH>) Services.getPort("lhs");
		return this.lhs_;
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


abstract public int go(); 


}

}
