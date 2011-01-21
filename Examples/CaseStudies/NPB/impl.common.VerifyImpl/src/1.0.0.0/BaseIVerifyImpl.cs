/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.error.RHSNorm;
using common.error.ErrorNorm;
using common.data.ProblemDefinition;
using common.datapartition.Blocks3D;
using common.Verify;

namespace impl.common.VerifyImpl { 

public abstract class BaseIVerifyImpl: Computation, BaseIVerify
{

protected IBlocks blocks = null;

protected IBlocks Blocks {
	set {
		this.blocks = value;
		error_norm.Blocks = value;
	}
}

protected ICell x = null;

protected ICell X {
	set {
		this.x = value;
	}
}

protected ICell y = null;

protected ICell Y {
	set {
		this.y = value;
	}
}

protected ICell z = null;

protected ICell Z {
	set {
		this.z = value;
	}
}

protected IRHSNorm rhs_norm = null;

protected IRHSNorm Rhs_norm {
	set {
		this.rhs_norm = value;
	}
}

protected IErrorNorm error_norm = null;

protected IErrorNorm Error_norm {
	set {
		this.error_norm = value;
	}
}

protected IProblemDefinition problem = null;

public IProblemDefinition Problem {
	set {
		this.problem = value;
		error_norm.Problem = value;
		rhs_norm.Problem = value;
	}
}

protected IBlocks3D process = null;

public IBlocks3D Process {
	set {
		this.process = value;
	}
}


public BaseIVerifyImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000001fdf1c333e7a360a79b933f434b7bff10ff34eb5f3c0dc8388fb27d56022f3cd84044a75f3c2423262d0b2021ea32d52fecb4950e16a1c6a8ab596d49cc2fac421dcfe345e2caffdc928cbad900d555ddf330cb0dba2fac75e9c7acf38e8cc3a3ca9c3d3435f29f212b8fc9f5bc50991184e61608f578dd8ddf1e75094b0c19a";

override public void createSlices() {
	base.createSlices();
	this.Error_norm = (IErrorNorm) BackEnd.createSlice(this, UID,"error_norm","error_norm);
	this.Rhs_norm = (IRHSNorm) BackEnd.createSlice(this, UID,"rhs_norm","rhs_norm);
	this.Z = (ICell) BackEnd.createSlice(this, UID,"z","cell);
	this.Y = (ICell) BackEnd.createSlice(this, UID,"y","cell);
	this.X = (ICell) BackEnd.createSlice(this, UID,"x","cell);
	this.Blocks = (IBlocks) BackEnd.createSlice(this, UID,"blocks_info","blocks);
} 

abstract public void compute(); 


}

}
