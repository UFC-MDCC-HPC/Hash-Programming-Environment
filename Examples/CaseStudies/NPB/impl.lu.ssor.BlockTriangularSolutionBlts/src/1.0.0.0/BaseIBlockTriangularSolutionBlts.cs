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
using lu.topology.Neighbors;
using lu.Exchange1;
using lu.triangular.Lower;
using lu.ssor.BlockTriangularSolution;

namespace impl.lu.ssor.BlockTriangularSolutionBlts { 
	public abstract class BaseIBlockTriangularSolutionBlts<I, C, DIS>: Computation, BaseIBlockTriangularSolution<I, C, DIS>
	where I:IInstance_LU<C>
	where C:IClass
	where DIS:ILower{

		#region data
			protected int ist,jst,iend,jend;
			protected double [,,,] rsd,d;
			override public void initialize(){
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
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
