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

namespace impl.sp.solve.XSolve { 

public abstract class BaseIXSolveImpl: Computation, BaseISolve
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


public BaseIXSolveImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000018a31e7929e1865431ebe80d73fbfcfe93794638016b7c620f3c54362cedf1aafbde87711305f31701909eb1af86fbf72f835e127f76724e21f11aed239f37aa1fde7d30e5786582ccab57975eb3333851532e706d479716b915d005ae5432c9f2b2ab8feafd8b060cc0182e6d590d3649e74f7aa45aac9a053c9e31eb40ed5";

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
