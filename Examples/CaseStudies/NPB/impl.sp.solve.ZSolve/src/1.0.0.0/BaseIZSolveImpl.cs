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

namespace impl.sp.solve.ZSolve { 

public abstract class BaseIZSolveImpl: Computation, BaseISolve
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


public BaseIZSolveImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000000b2db39ba0df4f7a80eb75a346a1032d29a39cd2bcf193d75d05de907e88e719156032131bb07f34239b6c82c347c694db89cd70aaf35f1208fbf1f7af298737243218d3fb110a46d0133e7c1a97aebae66da41e315808fd1b0f234994e9bb1314062115cee898f2a6f299f110e29c869deb37885dadbd95a1ce65a4feb30481";

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
