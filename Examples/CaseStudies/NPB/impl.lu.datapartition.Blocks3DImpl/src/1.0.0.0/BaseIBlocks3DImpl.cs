/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.datapartition.BlocksInfo;
using common.topology.Ring;
using lu.problem_size.Instance;
using common.problem_size.Class;
using common.topology.Mesh2D;
using common.topology.Ring;
using lu.problem_size.Instance_LU;
using lu.datapartition.Blocks3D;

namespace impl.lu.datapartition.Blocks3DImpl { 

public abstract class BaseIBlocks3DImpl<I, C>: br.ufc.pargo.hpe.kinds.Environment, BaseIBlocks3D<I, C>
where I:IInstance_LU<C>
where C:IClass
{

private IBlocksInfo blocks = null;

public IBlocksInfo Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocksInfo) Services.getPort("blocks_info");
		return this.blocks;
	}
}


private I instance = default(I);

protected I Instance {
	get {
		if (this.instance == null)
			this.instance = (I) Services.getPort("instance_type");
		return this.instance;
	}
}

private ICell2D cell = null;

protected ICell2D Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell2D) Services.getPort("topology");
		return this.cell;
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


}

}
