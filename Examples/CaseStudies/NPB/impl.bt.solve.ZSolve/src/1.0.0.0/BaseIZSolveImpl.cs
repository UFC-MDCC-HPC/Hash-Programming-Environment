/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using bt.solve.PackBackSubInfo;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using common.data.ProblemDefinition;
using common.Buffer;
using bt.solve.BackSubstitute;
using bt.solve.UnpackSolveInfo;
using bt.solve.PackSolveInfo;
using common.interactionpattern.Shift;
using common.direction.LeftToRight;
using bt.solve.SolveCell;
using environment.MPIDirect;
using bt.solve.UnpackBackSubInfo;
using bt.solve.Solve;

namespace impl.bt.solve.ZSolve { 

public abstract class BaseIZSolveImpl<I, C, DIR, MTH>: Computation, BaseISolve<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IZ
where MTH:IBeamWarmingMethod
{

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

private IPackBackSubInfo<I, C, DIR, MTH> pack_back_sub_info = null;

protected IPackBackSubInfo<I, C, DIR, MTH> Pack_back_sub_info {
	get {
		if (this.pack_back_sub_info == null)
			this.pack_back_sub_info = (IPackBackSubInfo<I, C, DIR, MTH>) Services.getPort("pack_back_sub_info");
		return this.pack_back_sub_info;
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

private IBackSubstitute<I, C, DIR, MTH> back_substitute = null;

protected IBackSubstitute<I, C, DIR, MTH> Back_substitute {
	get {
		if (this.back_substitute == null)
			this.back_substitute = (IBackSubstitute<I, C, DIR, MTH>) Services.getPort("back_substitute");
		return this.back_substitute;
	}
}

private IUnpackSolveInfo<I, C, DIR, MTH> unpack_solve_info = null;

protected IUnpackSolveInfo<I, C, DIR, MTH> Unpack_solve_info {
	get {
		if (this.unpack_solve_info == null)
			this.unpack_solve_info = (IUnpackSolveInfo<I, C, DIR, MTH>) Services.getPort("unpack_solve_info");
		return this.unpack_solve_info;
	}
}

private IPackSolveInfo<I, C, DIR, MTH> pack_solve_info = null;

protected IPackSolveInfo<I, C, DIR, MTH> Pack_solve_info {
	get {
		if (this.pack_solve_info == null)
			this.pack_solve_info = (IPackSolveInfo<I, C, DIR, MTH>) Services.getPort("pack_solve_info");
		return this.pack_solve_info;
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

private ISolveCell<I, C, DIR, MTH> solve_cell = null;

protected ISolveCell<I, C, DIR, MTH> Solve_cell {
	get {
		if (this.solve_cell == null)
			this.solve_cell = (ISolveCell<I, C, DIR, MTH>) Services.getPort("solve_cell");
		return this.solve_cell;
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

private IUnpackBackSubInfo<I, C, DIR, MTH> unpack_back_sub_info = null;

protected IUnpackBackSubInfo<I, C, DIR, MTH> Unpack_back_sub_info {
	get {
		if (this.unpack_back_sub_info == null)
			this.unpack_back_sub_info = (IUnpackBackSubInfo<I, C, DIR, MTH>) Services.getPort("unpack_back_sub_info");
		return this.unpack_back_sub_info;
	}
}


abstract public void compute(); 


}

}
