/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.ComputeRHS;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace impl.common.ComputeRHSImpl { 

	public abstract class BaseIComputeRHSImpl<I,C>: Computation, BaseIComputeRHS<I,C>
			where I:IInstance<C>
			where C:IClass
	{
	
		#region data		
				
		protected int ncells;
		
		protected int[,] start;
		protected int[,] end;
		protected int[,] cell_size;
				
		protected double[,,,,] u, rhs, forcing, us, vs, ws, rho_i, square, qs, speed, ainv;		
			
		protected double tx2, ty2, tz2, dssp, dt, xxcon2, xxcon3, xxcon4, xxcon5, dx1tx1, dx2tx1, dx3tx1,
			  dx4tx1, dx5tx1, yycon2, yycon3, yycon4, yycon5, dy1ty1, dy2ty1, dy3ty1, dy4ty1, dy5ty1,
			  zzcon2, zzcon3, zzcon4, zzcon5, dz1tz1, dz2tz1, dz3tz1, dz4tz1, dz5tz1, c1, c2, c1c2, con43;
		
		override public void initialize() 
		{
			start = Blocks.cell_start;
			end = Blocks.cell_end;
			cell_size = Blocks.cell_size;
					
			ncells = Problem.NCells;
					
			u = Problem.Field_u;
			rhs = Problem.Field_rhs;
			forcing = Problem.Field_forcing;
			us = Problem.Field_us;
			vs = Problem.Field_vs;
			ws = Problem.Field_ws; 
			rho_i = Problem.Field_rho;
			square = Problem.Field_square;
			qs = Problem.Field_qs;
			speed = Problem.Field_speed;
			ainv = Problem.Field_ainv;
					
			tx2 = Constants.tx2; 
			ty2 = Constants.ty2;
			tz2 = Constants.tz2;
			dssp = Constants.dssp;
			dt = Constants.dt;
			xxcon2 = Constants.xxcon2;
			xxcon3 = Constants.xxcon3;
			xxcon4 = Constants.xxcon4;
			xxcon5 = Constants.xxcon5;
			dx1tx1 = Constants.dx1tx1;
			dx2tx1 = Constants.dx2tx1;
			dx3tx1 = Constants.dx3tx1;
		    dx4tx1 = Constants.dx4tx1; 
			dx5tx1 = Constants.dx5tx1;
			yycon2 = Constants.yycon2;
			yycon3 = Constants.yycon3;
			yycon4 = Constants.yycon4;
			yycon5 = Constants.yycon5;
			dy1ty1 = Constants.dy1ty1;
			dy2ty1 = Constants.dy2ty1;
			dy3ty1 = Constants.dy3ty1;
			dy4ty1 = Constants.dy4ty1;
			dy5ty1 = Constants.dy5ty1;
		    zzcon2 = Constants.zzcon2;
			zzcon3 = Constants.zzcon3;
			zzcon4 = Constants.zzcon4;
			zzcon5 = Constants.zzcon5;
			dz1tz1 = Constants.dz1tz1;
			dz2tz1 = Constants.dz2tz1;
			dz3tz1 = Constants.dz3tz1;
			dz4tz1 = Constants.dz4tz1;
			dz5tz1 = Constants.dz5tz1;
			c1 = Constants.c1;
			c2 = Constants.c2;
			c1c2 = Constants.c1c2;
			con43 = Constants.con43;				
		}		
		
		#endregion		
				
		protected IBlocks blocks = null;
				
		public IBlocks Blocks {
			get {
		        if (this.blocks == null)				
				{
				    this.blocks = (IBlocks) Services.getPort("blocks_info");
				}
				return this.blocks;
			}
					
		}
		
		protected IProblemDefinition<I,C> problem = null;
		
		public IProblemDefinition<I,C> Problem {
			get {
				if (this.problem == null)
				{
				    this.problem = (IProblemDefinition<I,C>) Services.getPort("problem_data");
				}
				return this.problem;
			}
		}
		
		
		abstract public int go(); 
		
	
	}

}
