/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using common.Discretization;
using common.topology.Ring;
using environment.MPIDirect;
using lu.Exchange1;
using lu.triangular.Upper;
using lu.ssor.BlockTriangularSolution;

namespace impl.lu.ssor.BlockTriangularSolutionButs { 
	public abstract class BaseIBlockTriangularSolutionButs<I, C, DIS>: Computation, BaseIBlockTriangularSolution<I, C, DIS>
	where I:IInstance_LU<C>
	where C:IClass
	where DIS:IUpper{
		
		#region data
			protected int ist,jst,iend,jend;
			protected int isiz2, isiz1;
			protected double [,,,] rsd,d;
			override public void initialize(){
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
                isiz2 = Problem.isiz2;
                isiz1 = Problem.isiz1;
                
                rsd  = Problem.Field_rsd;
                d = Problem.Field_d;
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
		
		private DIS discretization = default(DIS);
		
		protected DIS Discretization {
			get {
				if (this.discretization == null)
					this.discretization = (DIS) Services.getPort("discretization");
				return this.discretization;
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
