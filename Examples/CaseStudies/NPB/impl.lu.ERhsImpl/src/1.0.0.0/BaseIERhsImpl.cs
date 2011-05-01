/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using common.topology.Ring;
using lu.Exchange;
using lu.ERhs;
using environment.MPIDirect;
using lu.exchange.ExchangePattern31;
using lu.exchange.ExchangePattern30;
using common.Discretization;

namespace impl.lu.ERhsImpl { 
	public abstract class BaseIERhsImpl<I, C>: Computation, BaseIERhs<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
		#region data
			protected int nx,ny,nz,nx0,ny0,ipt,jpt,ist,jst,iend,jend;//Blocks
			protected int north, south, east, west;
			//protected int isiz3;//Instance
			//protected int isiz1, isiz2, ii1, ii2, ji1, ji2, ki1, ki2;//Problem Constants
			//protected double c2, dxi, deta, dzeta;
			protected double c1, c2, c3, c4, c5, tx1, tx2, tx3, 
			                 dx1, dx2, dx3, dx4, dx5, dy1, dy2, dy3, dy4, dy5, dz1, dz2, dz3, dz4, dz5,
			                 dssp, ty1, ty2, ty3, tz1, tz2, tz3;
			protected double [,,,] u,rsd,frct,flux;
			protected double[,] ce;
			
			override public void initialize()
			{
			    nx  = Blocks.nx;
			    ny  = Blocks.ny;
			    nz  = Blocks.nz;
			    nx0  = Blocks.nx0;
			    ny0  = Blocks.ny0;
			    
                ipt  = Blocks.ipt;
                jpt  = Blocks.jpt;
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
/*                Console.WriteLine("nx=" + nx + " ny=" + ny + " nz=" + nz + " nx0=" + nx0 + " ny0=" + ny0 +
                                  " ipt=" + ipt + " jpt=" + jpt + " ist=" + ist + " jst=" + jst + 
                                  " iend=" + iend + " jend=" + jend);
  */              
                north = Blocks.north;
                south = Blocks.south;
                east  = Blocks.east;
                west  = Blocks.west;
                
                u    = Problem.Field_u;
                rsd  = Problem.Field_rsd;
                frct = Problem.Field_frct;
                flux = Problem.Field_flux;
                
                c1 = Constants.c1;
                c2 = Constants.c2;
                c3 = Constants.c3;
                c4 = Constants.c4;
                c5 = Constants.c5;
                tx1 = Constants.tx1;
                tx2 = Constants.tx2;
                tx3 = Constants.tx3;
                dx1 = Constants.dx1;
                dx2 = Constants.dx2;
                dx3 = Constants.dx3;
                dx4 = Constants.dx4;
                dx5 = Constants.dx5;
                ty1 = Constants.ty1;
                ty2 = Constants.ty2;
                ty3 = Constants.ty3;                
                tz1 = Constants.tz1;
                tz2 = Constants.tz2;
                tz3 = Constants.tz3;                
                dy1 = Constants.dy1;
                dy2 = Constants.dy2;
                dy3 = Constants.dy3;
                dy4 = Constants.dy4;
                dy5 = Constants.dy5;
                dz1 = Constants.dz1;
                dz2 = Constants.dz2;
                dz3 = Constants.dz3;
                dz4 = Constants.dz4;
                dz5 = Constants.dz5;                
                dssp = Constants.dssp;
                
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
		
		private IExchange<I, C, IExchangePattern30, IDiscretization> exchange30 = null;
		protected IExchange<I, C, IExchangePattern30, IDiscretization> Exchange30 {
			get {
				if (this.exchange30 == null)
					this.exchange30 = (IExchange<I, C, IExchangePattern30, IDiscretization>) Services.getPort("exchange30");
				return this.exchange30;
			}
		}

		private IExchange<I, C, IExchangePattern31, IDiscretization> exchange31 = null;
		protected IExchange<I, C, IExchangePattern31, IDiscretization> Exchange31 {
			get {
				if (this.exchange31 == null)
					this.exchange31 = (IExchange<I, C, IExchangePattern31, IDiscretization>) Services.getPort("exchange31");
				return this.exchange31;
			}
		}
		
		
		abstract public int go(); 
	}
}
