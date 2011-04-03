using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.Blocks3D;

namespace impl.lu.datapartition.Blocks3DImpl { 
	public class IBlocks3DImpl<I, C> : BaseIBlocks3DImpl<I, C>, IBlocks3D<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
		public IBlocks3DImpl() { 
		
		} 
		override public void initialize(){
		   Blocks.north = Mesh3d.north;
		   Blocks.south = Mesh3d.south;
		   Blocks.east = Mesh3d.east;
		   Blocks.west = Mesh3d.west;
		   Blocks.nx0   = Instance.isiz01;
		   Blocks.ny0   = Instance.isiz02;
		   Blocks.nz0   = Instance.isiz03;
		   Blocks.isiz3 = Instance.isiz3;
		   Blocks.col = Mesh3d.col;
		   Blocks.row = Mesh3d.row;
		   Blocks.xdim = Mesh3d.xdim;
		   Blocks.ydim = Mesh3d.ydim;
		   Blocks.subDomain();
		}
	
	
	}
}
