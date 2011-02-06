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

}

}
