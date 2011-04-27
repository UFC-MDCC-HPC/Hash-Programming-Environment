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
using ft.Checksum;

namespace impl.ft.ChecksumImpl { 
	public abstract class BaseIChecksumImpl<I, C>: Computation, BaseIChecksum<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
		#region data
			protected int nx, ny, nz, size1, size2, REAL, IMAG, root;
			protected int[] xstart, ystart, zstart, xend, yend, zend;
			override public void initialize(){
				nx = Instance.nx;
				ny = Instance.ny;
				nz = Instance.nz;
				size1 = Blocks.size1;
				size2 = Blocks.size2;
				xstart = Blocks.xstart;
				ystart = Blocks.ystart;
				zstart = Blocks.zstart;
				xend   = Blocks.xend;
				yend   = Blocks.yend;
				zend   = Blocks.zend;
				REAL = Constants.REAL;
				IMAG = Constants.IMAG;
				root = Constants.root;
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
