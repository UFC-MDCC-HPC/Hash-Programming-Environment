/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.ssor.Rhs;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.data.ProblemDefinition;
using lu.datapartition.BlocksInfo;
using lu.ssor.L2Norm;
using lu.ssor.BlockTriangularSolution;
using lu.triangular.Lower;
using lu.triangular.Upper;
using environment.MPIDirect;
using common.benchmarking.Timer;
using lu.ssor.TriangularPartJacobianMatrix;
using common.topology.Ring;
using lu.problem_size.Instance;
using lu.ssor.SSOR;
using MPI;

namespace impl.lu.ssor.SSORImpl { 
	public abstract class BaseISSORImpl<I, C>: Computation, BaseISSOR<I, C>
	where I:IInstance_LU<C>
	where C:IClass{
	   
		#region data
			protected Intracommunicator worldcomm;
			protected int nz,ist,jst,iend,jend;
			protected int isiz1, isiz2;
			protected int itmax,inorm;
			protected double dt;
			protected double [,,,] u,a,b,c,d,rsd;
			override public void initialize(){
			    itmax = Instance.itmax;
			    inorm = Instance.inorm;
			    dt    = Instance.dt;
			    
			    nz   = Blocks.nz;
                ist  = Blocks.ist;
                jst  = Blocks.jst;
                iend = Blocks.iend;
                jend = Blocks.jend;
                
                isiz1 = Problem.isiz1;
                isiz2 = Problem.isiz2; 
                u     = Problem.Field_u;                
                a     = Problem.Field_a;
                b     = Problem.Field_b;
                c     = Problem.Field_c;
                d     = Problem.Field_d;
                rsd   = Problem.Field_rsd;
                
				worldcomm = Mpi.worldComm();
			}
		#endregion
	
		private IRhs<I, C> rhs = null;
		
		protected IRhs<I, C> Rhs {
			get {
				if (this.rhs == null)
					this.rhs = (IRhs<I, C>) Services.getPort("rhs");
				return this.rhs;
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
		
		private IBlocksInfo blocks = null;
		
		public IBlocksInfo Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocksInfo) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		
		private IL2Norm<I, C> l2norm = null;
		
		protected IL2Norm<I, C> L2norm {
			get {
				if (this.l2norm == null)
					this.l2norm = (IL2Norm<I, C>) Services.getPort("l2norm");
				return this.l2norm;
			}
		}
		
		private IBlockTriangularSolution<I, C, ILower> blts = null;
		
		protected IBlockTriangularSolution<I, C, ILower> Blts {
			get {
				if (this.blts == null)
					this.blts = (IBlockTriangularSolution<I, C, ILower>) Services.getPort("blts");
				return this.blts;
			}
		}
		
		private IBlockTriangularSolution<I, C, IUpper> buts = null;
		
		protected IBlockTriangularSolution<I, C, IUpper> Buts {
			get {
				if (this.buts == null)
					this.buts = (IBlockTriangularSolution<I, C, IUpper>) Services.getPort("buts");
				return this.buts;
			}
		}
		
		private IMPIDirect mpi = null;
		
		public IMPIDirect Mpi {
			get {
				if (this.mpi == null)
					this.mpi = (IMPIDirect) Services.getPort("mpi");
				return this.mpi;
			}
		}
		
		private ITimer timer = null;
		
		protected ITimer Timer {
			get {
				if (this.timer == null)
					this.timer = (ITimer) Services.getPort("timer");
				return this.timer;
			}
		}
		
		private ITriangularPartJacobianMatrix<I, C, ILower> jacld = null;
		
		protected ITriangularPartJacobianMatrix<I, C, ILower> Jacld {
			get {
				if (this.jacld == null)
					this.jacld = (ITriangularPartJacobianMatrix<I, C, ILower>) Services.getPort("jacld");
				return this.jacld;
			}
		}
		
		private ITriangularPartJacobianMatrix<I, C, IUpper> jacu = null;
		
		protected ITriangularPartJacobianMatrix<I, C, IUpper> Jacu {
			get {
				if (this.jacu == null)
					this.jacu = (ITriangularPartJacobianMatrix<I, C, IUpper>) Services.getPort("jacu");
				return this.jacu;
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
