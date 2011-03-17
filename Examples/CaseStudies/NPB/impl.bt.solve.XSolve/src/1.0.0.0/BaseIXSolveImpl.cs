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
using environment.MPIDirect;
using common.interactionpattern.Shift;
using common.direction.Direction;
using bt.solve.SolveCell;
using bt.solve.Solve;

namespace impl.bt.solve.XSolve { 

public abstract class BaseIXSolveImpl<DIR, I, C, MTH>: Computation, BaseISolve<DIR, I, C, MTH>
where DIR:IX
where I:IInstance_BT<C>
where C:IClass
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

private IPackUnpack<I, C, DIR, MTH> packunpack = null;

protected IPackUnpack<I, C, DIR, MTH> Packunpack {
	get {
		if (this.packunpack == null)
			this.packunpack = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("pack_back_sub_info");
		return this.packunpack;
	}
}

private IPackUnpack<I, C, DIR, MTH> packunpack = null;

protected IPackUnpack<I, C, DIR, MTH> Packunpack {
	get {
		if (this.packunpack == null)
			this.packunpack = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("unpack_back_sub_info");
		return this.packunpack;
	}
}

private IPackUnpack<I, C, DIR, MTH> packunpack = null;

protected IPackUnpack<I, C, DIR, MTH> Packunpack {
	get {
		if (this.packunpack == null)
			this.packunpack = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("unpack_solve_info");
		return this.packunpack;
	}
}

private IPackUnpack<I, C, DIR, MTH> packunpack = null;

protected IPackUnpack<I, C, DIR, MTH> Packunpack {
	get {
		if (this.packunpack == null)
			this.packunpack = (IPackUnpack<I, C, DIR, MTH>) Services.getPort("pack_solve_info");
		return this.packunpack;
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

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		return this.mpi;
	}
}

private IShift<DIR> shift = null;

protected IShift<DIR> Shift {
	get {
		if (this.shift == null)
			this.shift = (IShift<DIR>) Services.getPort("shift");
		return this.shift;
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
