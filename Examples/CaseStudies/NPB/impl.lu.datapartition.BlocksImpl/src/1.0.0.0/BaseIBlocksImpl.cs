/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.topology.Mesh;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.problem_size.Instance_LU;
using lu.datapartition.Blocks;

namespace impl.lu.datapartition.BlocksImpl { 

public abstract class BaseIBlocksImpl<I, C>: br.ufc.pargo.hpe.kinds.Environment, BaseIBlocks<I, C>
where I:IInstance_LU<C>
where C:IClass
{

private ICell cell = null;

public ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("topology");
		return this.cell;
	}
}

private IBlocksInfo blocks = null;

public IBlocksInfo Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocksInfo) Services.getPort("blocks_info");
		return this.blocks;
	}
}

private INeighbors neighbors = null;

protected INeighbors Neighbors {
	get {
		if (this.neighbors == null)
			this.neighbors = (INeighbors) Services.getPort("neighbors");
		return this.neighbors;
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



}

}