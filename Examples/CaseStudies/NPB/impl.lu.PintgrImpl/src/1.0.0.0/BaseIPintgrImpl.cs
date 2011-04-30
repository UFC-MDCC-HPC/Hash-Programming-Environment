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
using lu.Exchange;
using common.topology.Ring;
using lu.problem_size.Instance;
using lu.Pintgr;
using lu.exchange.ExchangePattern4;
using lu.exchange.ExchangePattern5;
using lu.exchange.ExchangePattern6;
using MPI;
using common.Discretization;

namespace impl.lu.PintgrImpl 
{ 
	public abstract class BaseIPintgrImpl<I, C>: Computation, BaseIPintgr<I, C>
		where I:IInstance_LU<C>
		where C:IClass 
	{
		#region data
			protected Intracommunicator worldcomm;//Mpi
			protected int nx,ny,ipt,jpt;//Blocks
			protected int isiz3;//Instance
			protected int isiz1, isiz2, ii1, ii2, ji1, ji2, ki1, ki2;//Problem Constants
			protected double c2, dxi, deta, dzeta;
			protected double [,,,] u;
			override public void initialize()
			{
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

				worldcomm = this.WorldComm; // Mpi.worldComm();
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
		
				
		private IExchange<I, C, IExchangePattern4, IDiscretization> exchange4 = null;
		protected IExchange<I, C, IExchangePattern4, IDiscretization> Exchange4 {
			get {
				if (this.exchange4 == null)
					this.exchange4 = (IExchange<I, C, IExchangePattern4, IDiscretization>) Services.getPort("exchange4");
				return this.exchange4;
			}
		}
		
		private IExchange<I, C, IExchangePattern5, IDiscretization> exchange5 = null;
		protected IExchange<I, C, IExchangePattern5, IDiscretization> Exchange5 {
			get {
				if (this.exchange5 == null)
					this.exchange5 = (IExchange<I, C, IExchangePattern5, IDiscretization>) Services.getPort("exchange5");
				return this.exchange5;
			}
		}

		private IExchange<I, C, IExchangePattern6, IDiscretization> exchange6 = null;
		protected IExchange<I, C, IExchangePattern6, IDiscretization> Exchange6 {
			get {
				if (this.exchange6 == null)
					this.exchange6 = (IExchange<I, C, IExchangePattern6, IDiscretization>) Services.getPort("exchange6");
				return this.exchange6;
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
