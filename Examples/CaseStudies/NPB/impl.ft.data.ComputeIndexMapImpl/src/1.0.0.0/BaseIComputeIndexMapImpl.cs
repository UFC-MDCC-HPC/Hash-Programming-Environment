/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.problem_size.Instance;
using ft.data.ComputeIndexMap;

namespace impl.ft.data.ComputeIndexMapImpl { 
	public abstract class BaseIComputeIndexMapImpl<I, C>: Computation, BaseIComputeIndexMap<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
		#region data
			protected int nx, ny, nz;
			protected int[] xstart, ystart, zstart;
			protected int layout_0D, layout_1D, layout_2D, layout_type;
			override public void initialize(){
				nx = Instance.nx;
				ny = Instance.ny;
				nz = Instance.nz;

				xstart = Blocks.xstart;
				ystart = Blocks.ystart;
				zstart = Blocks.zstart;
				
				layout_0D = Constants.layout_0D;
				layout_1D = Constants.layout_1D;
				layout_2D = Constants.layout_2D;
				layout_type = Problem.layout_type;
			}
		#endregion
	
		private IBlocks blocks = null;
		
		public IBlocks Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocks) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		
		private IProblemDefinition<I, C> problem = null;
		
		public IProblemDefinition<I, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
				return this.problem;
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
		abstract public int go(); 
	}
}
