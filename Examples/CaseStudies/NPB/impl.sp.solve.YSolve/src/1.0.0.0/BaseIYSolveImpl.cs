/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.Buffer;
using common.solve.LHS;
using common.data.ProblemDefinition;
using common.solve.Backward;
using common.solve.BlockDiagonalMatVecProduct;
using common.solve.Forward;
using common.interactionpattern.Shift;
using common.solve.Solve;

namespace impl.sp.solve.YSolve { 

public abstract class BaseIYSolveImpl: Computation, BaseISolve
{

protected IBlocks blocks = null;

public IBlocks Blocks {
	set {
		this.blocks = value;
		forward.Blocks = value;
		matvecproduct.Blocks = value;
		backward.Blocks = value;
		lhs.Blocks = value;
	}
}

protected ICell cell = null;

public ICell Cell {
	set {
		this.cell = value;
		shift.Cell = value;
	}
}

protected IBuffer output_buffer = null;

protected IBuffer Output_buffer {
	set {
		this.output_buffer = value;
		shift.Output_buffer = value;
	}
}

protected IBuffer input_buffer = null;

protected IBuffer Input_buffer {
	set {
		this.input_buffer = value;
		shift.Input_buffer = value;
	}
}

protected ILHS lhs = null;

protected ILHS Lhs {
	set {
		this.lhs = value;
	}
}

protected IProblemDefinition problem = null;

public IProblemDefinition Problem {
	set {
		this.problem = value;
		forward.Problem = value;
		matvecproduct.Problem = value;
		backward.Problem = value;
		lhs.Problem = value;
	}
}

protected IBackward backward = null;

protected IBackward Backward {
	set {
		this.backward = value;
	}
}

protected IBlockDiagonalMatVecProduct matvecproduct = null;

protected IBlockDiagonalMatVecProduct Matvecproduct {
	set {
		this.matvecproduct = value;
	}
}

protected IForward forward = null;

protected IForward Forward {
	set {
		this.forward = value;
	}
}

protected IShift shift = null;

protected IShift Shift {
	set {
		this.shift = value;
	}
}


public BaseIYSolveImpl() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000095c94f1865342526b29221555f336d3917001c5f09b4efb35f0d84c9e35d0ebedbcd05c840960ed4e301684b0e8a7a79a4e6588945354d65c6e1d75466da11575829a108949ab951de0e1bb648362bac431ed80d28d65b621e0ea911dd0fbf92a96931d066256bf8e198328a70bb1e797d6407edadd4a6c296eeb6d8428cfd8d";

override public void createSlices() {
	base.createSlices();
	this.Shift = (IShift) BackEnd.createSlice(this, UID,"shift","shift);
	this.Forward = (IForward) BackEnd.createSlice(this, UID,"forward","forward);
	this.Matvecproduct = (IBlockDiagonalMatVecProduct) BackEnd.createSlice(this, UID,"matvecproduct","matvecproduct);
	this.Backward = (IBackward) BackEnd.createSlice(this, UID,"backward","backward);
	this.Lhs = (ILHS) BackEnd.createSlice(this, UID,"lhs","lhs);
	this.Input_buffer = (IBuffer) BackEnd.createSlice(this, UID,"input_buffer","buffer);
	this.Output_buffer = (IBuffer) BackEnd.createSlice(this, UID,"output_buffer","buffer);
} 

abstract public void compute(); 


}

}
