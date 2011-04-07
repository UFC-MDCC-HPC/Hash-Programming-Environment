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
using environment.MPIDirect;
using lu.Error;
using MPI;

namespace impl.lu.ErrorImpl { 
	public abstract class BaseIErrorImpl<I, C>: Computation, BaseIError<I, C>
	where I:IInstance_LU<C>
	where C:IClass {

		#region data
			protected Intracommunicator worldcomm;//Mpi
			protected int nz,nx0,ny0,nz0,ipt,jpt,ist,jst,iend,jend;//Blocks
			protected double [,,,] u;
			override public void initialize(){
			    nz   = Blocks.nz;
			    nx0  = Blocks.nx0;
			    ny0  = Blocks.ny0;
			    nz0  = Blocks.nz0;
                ipt  = Blocks.ipt;
                jpt  = Blocks.jpt;
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;                                
                u    = Problem.Field_u;
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
		
		private IExact<I, C> exact = null;
		
		protected IExact<I, C> Exact {
			get {
				if (this.exact == null)
					this.exact = (IExact<I, C>) Services.getPort("exact");
				return this.exact;
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
		abstract public void compute(); 
	}
}
