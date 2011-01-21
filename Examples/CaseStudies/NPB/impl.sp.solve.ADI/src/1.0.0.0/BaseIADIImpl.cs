/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.CopyFaces;
using common.solve.Solve;
using common.Add;
using common.ComputeRHS;
using common.solve.BlockDiagonalMatVecProduct;
using common.datapartition.Blocks3D;
using sp.ADI;

namespace impl.sp.solve.ADI { 

public abstract class BaseIADIImpl: Computation, BaseIADI
{

protected ICell x = null;

protected ICell X {
	set {
		this.x = value;
		x_solve.Cell = value;
		copy_faces.X = value;
	}
}

protected ICell z = null;

protected ICell Z {
	set {
		this.z = value;
		z_solve.Cell = value;
		copy_faces.Z = value;
	}
}

protected ICell y = null;

protected ICell Y {
	set {
		this.y = value;
		y_solve.Cell = value;
		copy_faces.Y = value;
	}
}

protected IBlocks blocks = null;

protected IBlocks Blocks {
	set {
		this.blocks = value;
		txinvr.Blocks = value;
		compute_rhs.Blocks = value;
		x_solve.Blocks = value;
		y_solve.Blocks = value;
		z_solve.Blocks = value;
		copy_faces.Blocks = value;
	}
}

protected IProblemDefinition problem = null;

public IProblemDefinition Problem {
	set {
		this.problem = value;
		txinvr.Problem = value;
		compute_rhs.Problem = value;
		add.Problem = value;
		x_solve.Problem = value;
		y_solve.Problem = value;
		z_solve.Problem = value;
		copy_faces.Problem = value;
	}
}

protected ICopyFaces copy_faces = null;

protected ICopyFaces Copy_faces {
	set {
		this.copy_faces = value;
	}
}

protected ISolve z_solve = null;

protected ISolve Z_solve {
	set {
		this.z_solve = value;
	}
}

protected ISolve y_solve = null;

protected ISolve Y_solve {
	set {
		this.y_solve = value;
	}
}

protected ISolve x_solve = null;

protected ISolve X_solve {
	set {
		this.x_solve = value;
	}
}

protected IAdd add = null;

protected IAdd Add {
	set {
		this.add = value;
	}
}

protected IComputeRHS compute_rhs = null;

protected IComputeRHS Compute_rhs {
	set {
		this.compute_rhs = value;
	}
}

protected IBlockDiagonalMatVecProduct txinvr = null;

protected IBlockDiagonalMatVecProduct Txinvr {
	set {
		this.txinvr = value;
	}
}

protected IBlocks3D data_partition = null;

public IBlocks3D Data_partition {
	set {
		this.data_partition = value;
	}
}


public BaseIADIImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000fb316b55696c9138e64dd37ecb271f82554b922bf3eb1af387e06526ae8e242fd8ca9570f417c3da43dc6bfbc7104507350a04f6f7781922091bc8471ffa11d08e952b1d00abe0ed557dab1f4c6be65a94027395505d0b601293e412aa77b0fe740d903658a74de8c6c011ae30948689a4abef436a12daf2ecbf8dfe616fb9c4";

override public void createSlices() {
	base.createSlices();
	this.Txinvr = (IBlockDiagonalMatVecProduct) BackEnd.createSlice(this, UID,"txinvr","matvecproduct);
	this.Compute_rhs = (IComputeRHS) BackEnd.createSlice(this, UID,"compute_rhs","compute_rhs);
	this.Add = (IAdd) BackEnd.createSlice(this, UID,"add","add);
	this.X_solve = (ISolve) BackEnd.createSlice(this, UID,"x_solve","solve);
	this.Y_solve = (ISolve) BackEnd.createSlice(this, UID,"y_solve","solve);
	this.Z_solve = (ISolve) BackEnd.createSlice(this, UID,"z_solve","solve);
	this.Copy_faces = (ICopyFaces) BackEnd.createSlice(this, UID,"copy_faces","copy_faces);
	this.Blocks = (IBlocks) BackEnd.createSlice(this, UID,"blocks_info","blocks);
	this.Y = (ICell) BackEnd.createSlice(this, UID,"y","cell);
	this.Z = (ICell) BackEnd.createSlice(this, UID,"z","cell);
	this.X = (ICell) BackEnd.createSlice(this, UID,"x","cell);
} 

abstract public void compute(); 


}

}
