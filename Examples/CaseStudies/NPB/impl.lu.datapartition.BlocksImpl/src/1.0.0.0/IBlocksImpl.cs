using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.Blocks;

namespace impl.lu.datapartition.BlocksImpl { 
	public class IBlocksImpl<I, C> : BaseIBlocksImpl<I, C>, IBlocks<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
		public IBlocksImpl() { 
		   
		} 
		override public void initialize(){
		   Blocks.north = Cell.north;
		   Blocks.south = Cell.south;
		   Blocks.east = Cell.east;
		   Blocks.west = Cell.west;
		   Blocks.nx0 = Instance.isiz01;
		   Blocks.ny0 = Instance.isiz02;
		   Blocks.nz0 = Instance.isiz03;
		   Blocks.col = Cell.col;
		   Blocks.row = Cell.row;
		   Blocks.xdim = Cell.xdim;
		   Blocks.ydim = Cell.ydim;
		   Blocks.setBlock();
		}
	}
}
