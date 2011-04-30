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
using lu.Exchange;
using lu.triangular.Upper;
using lu.ssor.BlockTriangularSolution;
using lu.exchange.ExchangePattern10;
using lu.exchange.ExchangePattern11;

namespace impl.lu.ssor.BlockTriangularSolutionButs 
{ 
	public abstract class BaseIBlockTriangularSolutionButs<DIS, I, C>: Computation, BaseIBlockTriangularSolution<DIS, I, C>
		where I:IInstance_LU<C>
		where C:IClass
		where DIS:IUpper
	{
		
		#region data
		
			protected int ist,jst,iend,jend;
			protected int isiz2, isiz1;
			protected double [,,,] rsd,d;
		
		    protected double[,,,] udx;
		    protected double[,,,] udy;
		    protected double[,,,] udz;
			
			override public void initialize()
			{
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
                isiz2 = Problem.isiz2;
                isiz1 = Problem.isiz1;
                
                rsd  = Problem.Field_rsd;
                d = Problem.Field_d;
			
			    udx = Problem.Field_a;
				udy = Problem.Field_b;
				udz = Problem.Field_c;
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
		
		private IExchange<I, C, IExchangePattern10, DIS> exchange_102 = null;
		
		protected IExchange<I, C, IExchangePattern10, DIS> Exchange_102 {
			get {
				if (this.exchange_102 == null)
					this.exchange_102 = (IExchange<I, C, IExchangePattern10, DIS>) Services.getPort("exchange_102");
				return this.exchange_102;
			}
		}
		
		private IExchange<I, C, IExchangePattern11, DIS> exchange_113 = null;
		
		protected IExchange<I, C, IExchangePattern11, DIS> Exchange_113 {
			get {
				if (this.exchange_113 == null)
					this.exchange_113 = (IExchange<I, C, IExchangePattern11, DIS>) Services.getPort("exchange_113");
				return this.exchange_113;
			}
		}
		
		abstract public int go(); 
	}
}
