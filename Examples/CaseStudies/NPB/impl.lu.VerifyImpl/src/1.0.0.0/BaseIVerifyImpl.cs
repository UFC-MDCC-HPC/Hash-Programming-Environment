/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using lu.problem_size.Instance;
using lu.Verify;

namespace impl.lu.VerifyImpl {
	public abstract class BaseIVerifyImpl<I, C>: Computation, BaseIVerify<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	
		#region data			
			protected int nx0,ny0,nz0,itmax;
		    protected double[] xcrref, xceref;
		    protected double dtref, xciref, dt;		    
			override public void initialize(){
				nx0    = Blocks.nx0;
				ny0    = Blocks.ny0;
				nz0    = Blocks.nz0;
				itmax  = Instance.itmax;
				xcrref = Instance.xcrref;
				xceref = Instance.xceref;
				dtref  = Instance.dtref;
				xciref = Instance.xciref;
				dt     = Instance.dt;
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
		abstract public int go(); 
	}
}
