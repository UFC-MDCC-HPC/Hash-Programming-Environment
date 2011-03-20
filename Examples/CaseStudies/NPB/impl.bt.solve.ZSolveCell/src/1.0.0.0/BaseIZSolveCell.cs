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
using common.orientation.Z;
using bt.solve.SolveCell;

namespace impl.bt.solve.ZSolveCell { 
	public abstract class BaseIZSolveCell<I, C, DIR, MTH>: Computation, BaseISolveCell<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IZ
	where MTH:IBeamWarmingMethod {
	
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
		
		abstract public void compute(); 
	}
}
