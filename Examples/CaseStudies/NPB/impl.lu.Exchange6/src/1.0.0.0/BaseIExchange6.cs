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
using common.interactionpattern.Shift;
using common.topology.Ring;
using common.direction.RightToLeft;
using environment.MPIDirect;
using lu.Exchange;
using lu.exchange.ExchangePattern6;
using common.Discretization;

namespace impl.lu.Exchange6 
{ 
	public abstract class BaseIExchange6<I, C, E, DIS>: Computation, BaseIExchange<I, C, E, DIS>
	where I:IInstance_LU<C>
	where C:IClass 
	where E:IExchangePattern6
	where DIS:IDiscretization
{
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
		
		private IShift<IRightToLeft> shift_to_west = null;
		
		protected IShift<IRightToLeft> Shift_to_west {
			get {
				if (this.shift_to_west == null)
					this.shift_to_west = (IShift<IRightToLeft>) Services.getPort("shift_to_west");
				return this.shift_to_west;
			}
		}
		
		private IShift<IRightToLeft> shift_to_north = null;
		
		protected IShift<IRightToLeft> Shift_to_north {
			get {
				if (this.shift_to_north == null)
					this.shift_to_north = (IShift<IRightToLeft>) Services.getPort("shift_to_north");
				return this.shift_to_north;
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
		
		private ICell x = null;
		
		public ICell X {
			get {
				if (this.x == null)
					this.x = (ICell) Services.getPort("x");
				return this.x;
			}
		}
		
		private IMPIDirect mpi = null;
		
		public IMPIDirect Mpi {
			get {
				if (this.mpi == null) 
				{
					this.mpi = (IMPIDirect) Services.getPort("mpi");
				}
				return this.mpi;
			}
		}
		
		
		abstract public int go(); 
	}
}
