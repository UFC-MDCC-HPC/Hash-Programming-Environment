/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Mesh3D;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.datapartition.Blocks3D;
using common.problem_size.Class;
using common.problem_size.Instance;


namespace impl.common.datapartition.Blocks3DImpl { 

public abstract class BaseIBlocks3DImpl<I, C>: br.ufc.pargo.hpe.kinds.Environment, BaseIBlocks3D<I, C>
where I:IInstance<C>
where C:IClass
{
		
		
private I instance = default(I);

protected I Instance {
	get {
		if (instance==null) 
			instance = (I) Services.getPort("instance");
		return instance;
	}
}		
		
private ICell3D cell = null;

protected ICell3D Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell3D) Services.getPort("topology");
		return this.cell;
	}
}

private ICell z = null;

public ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort("z");
		return this.z;
	}
}

private ICell x = null;

public ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort("x");
		return this.x;
	}
}

private ICell y = null;

public ICell Y {
	get {
		if (this.y == null)
			this.y = (ICell) Services.getPort("y");
		return this.y;
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


}

}
