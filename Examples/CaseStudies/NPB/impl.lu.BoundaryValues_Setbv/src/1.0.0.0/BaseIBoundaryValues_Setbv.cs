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
using lu.BoundaryValues;

namespace impl.lu.BoundaryValues_Setbv { 
	public abstract class BaseIBoundaryValues_Setbv<I, C>: Computation, BaseIBoundaryValues<I, C>
	where I:IInstance_LU<C>
	where C:IClass{
	
		#region data
			protected int nx,ny,nz,nx0,ny0,ipt,jpt;
			protected int north, south, east, west;
			protected double [,,,] u;
			override public void initialize(){
			    nx0  = Blocks.nx0;
			    ny0  = Blocks.ny0;
			    
			    nx  = Blocks.nx;
			    ny  = Blocks.ny;
			    nz  = Blocks.nz;
			    
                ipt  = Blocks.ipt;
                jpt  = Blocks.jpt;
                
                north = Blocks.north;
                south = Blocks.south;
                east  = Blocks.east;
                west  = Blocks.west;
                
                u    = Problem.Field_u;
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
		abstract public void compute(); 
	}
}
