/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.topology.Mesh3D;
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

private INeighbors neighbors = null;

public INeighbors Neighbors {
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

private IMesh3D mesh3d = null;

protected IMesh3D Mesh3d {
	get {
		if (this.mesh3d == null)
			this.mesh3d = (IMesh3D) Services.getPort("topology");
		return this.mesh3d;
	}
}



}

}
