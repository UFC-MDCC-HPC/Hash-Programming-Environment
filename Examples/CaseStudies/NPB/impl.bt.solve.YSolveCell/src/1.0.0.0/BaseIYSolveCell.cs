/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.BinvRhs;
using bt.solve.BeamWarmingMethod;
using bt.solve.MatMulSub;
using common.orientation.Axis;
using bt.solve.LhsABInit;
using bt.solve.BinvcRhs;
using common.solve.Method;
using bt.solve.MatVecSub;
using common.orientation.Y;
using bt.solve.SolveCell;

namespace impl.bt.solve.YSolveCell { 
	public abstract class BaseIYSolveCell<I, C, DIR, MTH>: Computation, BaseISolveCell<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IY
	where MTH:IBeamWarmingMethod {
		#region data
		
			protected int MAX_CELL_DIM;
			protected int[,] start, end, cell_size;
			protected double[,,,,] rho_i, u, qs, rhs; //u, rhs, forcing, us, vs, ws, , square, qs, speed, ainv;	
			
			protected double tx2, ty2, tz2, dssp, dt, c1, c2, c1c2,
			      c3c4, c1345, tx1, dx1, dx2, dx3, dx4, dx5, con43;
			      /*xxcon2, xxcon3, xxcon4, xxcon5, dx1tx1, dx2tx1, dx3tx1,
				  dx4tx1, dx5tx1, yycon2, yycon3, yycon4, yycon5, dy1ty1, dy2ty1, dy3ty1, dy4ty1, dy5ty1,
				  zzcon2, zzcon3, zzcon4, zzcon5, dz1tz1, dz2tz1, dz3tz1, dz4tz1, dz5tz1, 
				  */

			override public void initialize(){
	            start = Blocks.cell_start;
				end = Blocks.cell_end;
				cell_size = Blocks.cell_size;
				MAX_CELL_DIM = Problem.MAX_CELL_DIM;				
	            rho_i = Problem.Field_rho;
				qs = Problem.Field_qs;	            
				u = Problem.Field_u;
				rhs = Problem.Field_rhs;
				
				tx2 = Constants.tx2; 
				ty2 = Constants.ty2;
				tz2 = Constants.tz2;
				dssp = Constants.dssp;
				dt = Constants.dt;
				c1 = Constants.c1;
				c2 = Constants.c2;
				c1c2 = Constants.c1c2;
				con43 = Constants.con43;
				c3c4 = Constants.c3c4;	
				c1345 = Constants.c1345;
				tx1 = Constants.tx1; 
				
				dx1 = Constants.dx1;
				dx2 = Constants.dx2;
				dx3 = Constants.dx3;
				dx4 = Constants.dx4;
				dx5 = Constants.dx5;
				/*
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
				*/

									
				//forcing = Problem.Field_forcing;
				//us = Problem.Field_us;
				//vs = Problem.Field_vs;
				//ws = Problem.Field_ws; 
				//square = Problem.Field_square;
				//cell_coord = Blocks.cell_coord;
				//slice = Blocks.cell_slice;
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
		
		private IBinvRhs<I, C, MTH> binvrhs = null;
		
		protected IBinvRhs<I, C, MTH> Binvrhs {
			get {
				if (this.binvrhs == null)
					this.binvrhs = (IBinvRhs<I, C, MTH>) Services.getPort("binvrhs");
				return this.binvrhs;
			}
		}
		
		private IMatMulSub<I, C, MTH> matmul_sub = null;
		
		protected IMatMulSub<I, C, MTH> Matmul_sub {
			get {
				if (this.matmul_sub == null)
					this.matmul_sub = (IMatMulSub<I, C, MTH>) Services.getPort("matmulsub");
				return this.matmul_sub;
			}
		}
		
		private DIR axis = default(DIR);
		
		protected DIR Axis {
			get {
				if (this.axis == null)
					this.axis = (DIR) Services.getPort("orientation");
				return this.axis;
			}
		}
		
		private ILhsABInit<I, C> lhsabinit = null;
		
		protected ILhsABInit<I, C> Lhsabinit {
			get {
				if (this.lhsabinit == null)
					this.lhsabinit = (ILhsABInit<I, C>) Services.getPort("lhsabinit");
				return this.lhsabinit;
			}
		}
		
		private IBinvcRhs<I, C, MTH> binvcrhs = null;
		
		protected IBinvcRhs<I, C, MTH> Binvcrhs {
			get {
				if (this.binvcrhs == null)
					this.binvcrhs = (IBinvcRhs<I, C, MTH>) Services.getPort("binvcrhs");
				return this.binvcrhs;
			}
		}
		
		private MTH method = default(MTH);
		
		protected MTH Method {
			get {
				if (this.method == null)
					this.method = (MTH) Services.getPort("method");
				return this.method;
			}
		}
		
		private IMatVecSub<I, C, MTH> matvec_sub = null;
		
		protected IMatVecSub<I, C, MTH> Matvec_sub {
			get {
				if (this.matvec_sub == null)
					this.matvec_sub = (IMatVecSub<I, C, MTH>) Services.getPort("matvecsub");
				return this.matvec_sub;
			}
		}
		
		public static double pow2(double p) { return p * p; }
		
		abstract public void compute(); 
	}
}
