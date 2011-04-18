/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using common.Buffer;
using lu.datapartition.BlocksInfo;
using lu.interactionpattern.Shift;
using common.direction.EastToWest;
using common.direction.SouthToNorth;
using lu.topology.Neighbors;
using lu.Exchange;

namespace impl.lu.ExchangeImpl { 
	public abstract class BaseIExchangeImpl<I, C>: Computation, BaseIExchange<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
		#region data
			protected int nx,ny,nz;
			override public void initialize(){
				nx = Blocks.nx;
				ny = Blocks.ny;
				nz = Blocks.nz;
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
		
		private IBuffer input_buffer = null;
		
		protected IBuffer Input_buffer {
			get {
				if (this.input_buffer == null)
					this.input_buffer = (IBuffer) Services.getPort("input_buffer");
				return this.input_buffer;
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
		abstract public int go(); 
	}
}
