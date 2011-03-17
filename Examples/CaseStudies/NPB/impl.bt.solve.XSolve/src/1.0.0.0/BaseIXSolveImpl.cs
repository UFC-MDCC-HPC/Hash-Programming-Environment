/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.Buffer;
using bt.solve.PackUnpack;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.BackSubstitute;
using common.interactionpattern.Shift;
using common.direction.LeftToRight;
using environment.MPIDirect;
using bt.solve.SolveCell;
using bt.solve.Solve;

namespace impl.bt.solve.XSolve { 

public abstract class BaseIXSolveImpl<DIR, I, C, MTH>: Computation, BaseISolve<DIR, I, C, MTH>
where DIR:IX
where I:IInstance_BT<C>
where C:IClass
where MTH:IBeamWarmingMethod
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

private ICell cell = null;

public ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("topology");
		return this.cell;
	}
}

private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
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

private IBuffer input_buffer = null;

protected IBuffer Input_buffer {
	get {
		if (this.input_buffer == null)
			this.input_buffer = (IBuffer) Services.getPort("input_buffer");
		return this.input_buffer;
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

private IPackUnpack<I, C, DIR, MTH> pack_back_sub_info = null;

protected IPackUnpack<I, C, DIR, MTH> PackBackSubInfo {
	get {
		if (this.pack_back_sub_info == null)
			this.pack_back_sub_info = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("pack_back_sub_info");
		return this.pack_back_sub_info;
	}
}

private IPackUnpack<I, C, DIR, MTH> unpack_back_sub_info = null;

protected IPackUnpack<I, C, DIR, MTH> UnpackBackSubInfo {
	get {
		if (this.unpack_back_sub_info == null)
			this.unpack_back_sub_info = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("unpack_back_sub_info");
		return this.unpack_back_sub_info;
	}
}

private IPackUnpack<I, C, DIR, MTH> unpack_solve_info = null;

protected IPackUnpack<I, C, DIR, MTH> UnpackSolveInfo {
	get {
		if (this.unpack_solve_info == null)
			this.unpack_solve_info = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("unpack_solve_info");
		return this.unpack_solve_info;
	}
}

private IPackUnpack<I, C, DIR, MTH> pack_solve_info = null;

protected IPackUnpack<I, C, DIR, MTH> PackSolveInfo {
	get {
		if (this.pack_solve_info == null)
			this.pack_solve_info = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("pack_solve_info");
		return this.pack_solve_info;
	}
}

private IBackSubstitute<I, C, DIR, MTH> back_substitute = null;

protected IBackSubstitute<I, C, DIR, MTH> Back_substitute {
	get {
		if (this.back_substitute == null)
			this.back_substitute = (IBackSubstitute<I, C, DIR, MTH>) Services.getPort("back_substitute");
		return this.back_substitute;
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

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		return this.mpi;
	}
}

private ISolveCell<DIR, I, C, MTH> solve_cell = null;

protected ISolveCell<DIR, I, C, MTH> Solve_cell {
	get {
		if (this.solve_cell == null)
			this.solve_cell = (ISolveCell<DIR, I, C, MTH>) Services.getPort("solve_cell");
		return this.solve_cell;
	}
}


abstract public void compute(); 


}

}
