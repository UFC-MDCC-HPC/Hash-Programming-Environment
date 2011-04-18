/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using environment.MPIDirect;
using lu.ssor.L2Norm;
using MPI;

namespace impl.lu.ssor.L2NormImpl { 
	public abstract class BaseIL2NormImpl<I, C>: Computation, BaseIL2Norm<I, C>
	where I:IInstance_LU<C>
	where C:IClass{
	   
		#region data
			protected Intracommunicator worldcomm;//Mpi
			protected int nx0,ny0,nz0,ist,jst,iend,jend;//Blocks
			override public void initialize(){
			    nx0  = Blocks.nx0;
			    ny0  = Blocks.ny0;
			    nz0  = Blocks.nz0;
			    
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
				worldcomm = Mpi.worldComm();
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
		
		private IMPIDirect mpi = null;
		
		public IMPIDirect Mpi {
			get {
				if (this.mpi == null)
					this.mpi = (IMPIDirect) Services.getPort("mpi");
				return this.mpi;
			}
		}	
		abstract public int go(); 
	}
}
