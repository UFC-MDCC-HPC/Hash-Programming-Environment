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
using lu.Exchange4;
using lu.Exchange;
using lu.topology.Neighbors;
using lu.problem_size.Instance;
using lu.Pintgr;
using MPI;

namespace impl.lu.PintgrImpl { 
	public abstract class BaseIPintgrImpl<I, C>: Computation, BaseIPintgr<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
		#region data
			protected Intracommunicator worldcomm;//Mpi
			protected int nx,ny,ipt,jpt;//Blocks
			protected int isiz3;//Instance
			protected int isiz1, isiz2, ii1, ii2, ji1, ji2, ki1, ki2;//Problem Constants
			protected double c2, dxi, deta, dzeta;
			protected double [,,,] u;
			override public void initialize(){
			    nx  = Blocks.nx;
			    ny  = Blocks.ny;
                ipt = Blocks.ipt;
                jpt = Blocks.jpt;
                
                isiz3 = Instance.isiz3;
                
                isiz1 = Problem.isiz1;
                isiz2 = Problem.isiz2; 
                u     = Problem.Field_u;
                
                ii1   = Constants.ii1;
                ii2   = Constants.ii2;
                ji1   = Constants.ji1;
                ji2   = Constants.ji2;
                ki1   = Constants.ki1;
                ki2   = Constants.ki2;
                c2    = Constants.c2;
                dxi   = Constants.dxi;
                deta  = Constants.deta;
                dzeta = Constants.dzeta;

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
		
		private IExchange4<I, C> exchange4 = null;
		
		protected IExchange4<I, C> Exchange4 {
			get {
				if (this.exchange4 == null)
					this.exchange4 = (IExchange4<I, C>) Services.getPort("exchange4");
				return this.exchange4;
			}
		}
		
		private IExchange<I, C> exchange = null;
		
		protected IExchange<I, C> Exchange {
			get {
				if (this.exchange == null)
					this.exchange = (IExchange<I, C>) Services.getPort("exchange");
				return this.exchange;
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
