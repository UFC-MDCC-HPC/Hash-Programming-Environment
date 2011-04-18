/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;
using lu.Exchange1;
using lu.ssor.Rhs;

namespace impl.lu.ssor.RhsImpl {
	public abstract class BaseIRhsImpl<I, C>: Computation, BaseIRhs<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	
		#region data
			protected int nx,ny,nz,ipt,jpt,ist,jst,iend,jend;//Blocks
			protected int north, south, east, west;
			//protected int isiz3;//Instance
			//protected int isiz1, isiz2, ii1, ii2, ji1, ji2, ki1, ki2;//Problem Constants
			//protected double c2, dxi, deta, dzeta;
			protected double c1, c2, c3, c4, c5, tx1, tx2, tx3, 
			                 dx1, dx2, dx3, dx4, dx5, dy1, dy2, dy3, dy4, dy5, dz1, dz2, dz3, dz4, dz5,
			                 dssp, ty1, ty2, ty3, tz1, tz2, tz3;
			protected double [,,,] u,rsd,frct,flux;
			override public void initialize(){
			    nx  = Blocks.nx;
			    ny  = Blocks.ny;
			    nz  = Blocks.nz;
			    
                ipt  = Blocks.ipt;
                jpt  = Blocks.jpt;
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
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
		
		private INeighbors neighbors = null;
		
		public INeighbors Neighbors {
			get {
				if (this.neighbors == null)
					this.neighbors = (INeighbors) Services.getPort("neighbors");
				return this.neighbors;
			}
		}
		
		private IExchange1<I, C> exchange1 = null;
		
		protected IExchange1<I, C> Exchange1 {
			get {
				if (this.exchange1 == null)
					this.exchange1 = (IExchange1<I, C>) Services.getPort("exchange1");
				return this.exchange1;
			}
		}
		abstract public int go(); 
	}
}
