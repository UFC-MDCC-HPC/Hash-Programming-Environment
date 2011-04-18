/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using common.Buffer;
using lu.interactionpattern.Shift;
using common.direction.WestToEast;
using lu.datapartition.BlocksInfo;
using common.direction.EastToWest;
using common.direction.SouthToNorth;
using lu.topology.Neighbors;
using common.direction.NorthToSouth;
using lu.Exchange1;

namespace impl.lu.Exchange1Impl { 
	public abstract class BaseIExchange1Impl<I, C>: Computation, BaseIExchange1<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
		#region data
			protected int nx,ny,nz;
			protected int north, south, east, west;
			protected int jst, jend, ist, iend;
			
			override public void initialize(){
				nx = Blocks.nx;
				ny = Blocks.ny;
				nz = Blocks.nz;
				
				north = Blocks.north;
				south = Blocks.south;
				east  = Blocks.east;
				west  = Blocks.west;
				
				jst  = Blocks.jst;
                jend = Blocks.jend;                
				ist  = Blocks.ist;
                iend = Blocks.iend;                
			}
		#endregion
	
		private IProblemDefinition<I, C> problem = null;
		
		public IProblemDefinition<I, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
				return this.problem;
			}
		}
		
		private IBuffer output_buffer = null;
		
		protected IBuffer Output_buffer {
			get {
				if (this.output_buffer == null)
					this.output_buffer = (IBuffer) Services.getPort("output_buffer");
				return this.output_buffer;
			}
		}
		
		private IBuffer input_buffer = null;
		
		protected IBuffer Input_buffer {
			get {
				if (this.input_buffer == null)
					this.input_buffer = (IBuffer) Services.getPort("input_buffer");
				return this.input_buffer;
			}
		}
		
		private IShift<IWestToEast> shift_to_east = null;
		
		protected IShift<IWestToEast> ShiftToEast {
			get {
				if (this.shift_to_east == null)
					this.shift_to_east = (IShift<IWestToEast>) Services.getPort("shift_to_east");
				return this.shift_to_east;
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
		
		private IShift<IEastToWest> shift_to_west = null;
		
		protected IShift<IEastToWest> ShiftToWest {
			get {
				if (this.shift_to_west == null)
					this.shift_to_west = (IShift<IEastToWest>) Services.getPort("shift_to_west");
				return this.shift_to_west;
			}
		}
		
		private IShift<ISouthToNorth> shift_to_north = null;
		
		protected IShift<ISouthToNorth> ShiftToNorth {
			get {
				if (this.shift_to_north == null)
					this.shift_to_north = (IShift<ISouthToNorth>) Services.getPort("shift_to_north");
				return this.shift_to_north;
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
		
		private IShift<INorthToSouth> shift_to_south = null;
		
		protected IShift<INorthToSouth> ShiftToSouth {
			get {
				if (this.shift_to_south == null)
					this.shift_to_south = (IShift<INorthToSouth>) Services.getPort("shift_to_south");
				return this.shift_to_south;
			}
		}
	
		abstract public int go(); 
	}
}
