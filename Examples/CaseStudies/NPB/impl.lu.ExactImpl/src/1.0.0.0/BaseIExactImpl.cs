/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using lu.Exact;

namespace impl.lu.ExactImpl { 
	public abstract class BaseIExactImpl<I, C>: Computation, BaseIExact<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	
		#region data
			protected int nx0,ny0,nz;
			protected double[,] ce;
			
			override public void initialize(){
				nx0 = Blocks.nx0;
				ny0 = Blocks.ny0;
				nz = Blocks.nz;				
				ce = Constants.ce;              
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
		abstract public void compute(); 
	}
}
