/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Mesh3D;
using common.datapartition.BlocksInfo;
using common.datapartition.Blocks3D;

namespace impl.common.datapartition.Blocks3DImpl { 

public abstract class BaseIProcessImpl: Environment, BaseIBlocks3D
{

protected ICell cell = null;

protected ICell Cell {
	set {
		this.cell = value;
	}
}

protected ICell x = null;

public ICell X {
	set {
		this.x = value;
		cell.X = value;
	}
}

protected ICell z = null;

public ICell Z {
	set {
		this.z = value;
		cell.Z = value;
	}
}

protected ICell y = null;

public ICell Y {
	set {
		this.y = value;
		cell.Y = value;
	}
}

protected IBlocks blocks = null;

public IBlocks Blocks {
	set {
		this.blocks = value;
	}
}


public BaseIProcessImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000b72fd3158502ef4632454597f3da92b46982f3f00cf0765582e5c7d83235572c4824dd838676063b7d3a0e5b096709c3835211bad9eed0378e6f4b3ee031be0d61dd2717055006a5908f79a2e121eb382f099d01028c3b0e84d987279fc52c76843bc451c9a6d32f31179fb884fee0b317de1267e5eb07f7952455a9a2e0988e";

override public void createSlices() {
	base.createSlices();
	this.Cell = (ICell) BackEnd.createSlice(this, UID,"topology","cell);
} 


}

}
