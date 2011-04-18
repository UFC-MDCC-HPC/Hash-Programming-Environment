/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.datapartition.BlocksInfo;
using lu.datapartition.Blocks3D;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.ERhs;
using environment.MPIDirect;
using lu.Error;
using lu.Pintgr;
using lu.Verify;
using lu.data.InitialValues;
using lu.data.BoundaryValues;
using lu.ssor.SSOR;
using lu.data.ProblemDefinition;
using lu.topology.Neighbors;
using lu.LU;
using lu.problem_size.Instance;
using MPI;

namespace impl.lu.LUImpl { 

public abstract class BaseILUImpl<C>: Application, BaseILU<C>
where C:IClass{
   
		#region data
			protected Intracommunicator worldcomm;
			protected PROBLEM_CLASS problem_class;
			protected int nx0,ny0,nz0;
			protected int isiz01, isiz02, isiz03;
			protected int itmax;
			override public void initialize(){
			    itmax         = Instance.itmax;
			    problem_class = Instance.CLASS;
			    isiz01        = Instance.isiz01;
			    isiz02        = Instance.isiz02;
			    isiz03        = Instance.isiz03;
			    
			    nx0   = Blocks.nx0;
			    ny0   = Blocks.ny0;
			    nz0   = Blocks.nz0;

				worldcomm = Mpi.worldComm();
			}
		#endregion

		private IBlocksInfo blocks = null;
		
		protected IBlocksInfo Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocksInfo) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		
		private IBlocks3D<IInstance_LU<C>, C> process = null;
		
		protected IBlocks3D<IInstance_LU<C>, C> Process {
			get {
				if (this.process == null)
					this.process = (IBlocks3D<IInstance_LU<C>, C>) Services.getPort("data_partition");
				return this.process;
			}
		}
		
		private IERhs<IInstance_LU<C>, C> erhs = null;
		
		protected IERhs<IInstance_LU<C>, C> Erhs {
			get {
				if (this.erhs == null)
					this.erhs = (IERhs<IInstance_LU<C>, C>) Services.getPort("erhs");
				return this.erhs;
			}
		}
		
		private IMPIDirect mpi = null;
		
		protected IMPIDirect Mpi {
			get {
				if (this.mpi == null)
					this.mpi = (IMPIDirect) Services.getPort("mpi");
				return this.mpi;
			}
		}
		
		private IError<IInstance_LU<C>, C> error = null;
		
		protected IError<IInstance_LU<C>, C> Error {
			get {
				if (this.error == null)
					this.error = (IError<IInstance_LU<C>, C>) Services.getPort("error");
				return this.error;
			}
		}
		
		private IPintgr<IInstance_LU<C>, C> pintgr = null;
		
		protected IPintgr<IInstance_LU<C>, C> Pintgr {
			get {
				if (this.pintgr == null)
					this.pintgr = (IPintgr<IInstance_LU<C>, C>) Services.getPort("pintgr");
				return this.pintgr;
			}
		}
		
		private IVerify<IInstance_LU<C>, C> verify = null;
		
		protected IVerify<IInstance_LU<C>, C> Verify {
			get {
				if (this.verify == null)
					this.verify = (IVerify<IInstance_LU<C>, C>) Services.getPort("verify");
				return this.verify;
			}
		}
		
		private IInitialValues<IInstance_LU<C>, C> setiv = null;
		
		protected IInitialValues<IInstance_LU<C>, C> Setiv {
			get {
				if (this.setiv == null)
					this.setiv = (IInitialValues<IInstance_LU<C>, C>) Services.getPort("setiv");
				return this.setiv;
			}
		}
		
		private IBoundaryValues<IInstance_LU<C>, C> setbv = null;
		
		protected IBoundaryValues<IInstance_LU<C>, C> Setbv {
			get {
				if (this.setbv == null)
					this.setbv = (IBoundaryValues<IInstance_LU<C>, C>) Services.getPort("setbv");
				return this.setbv;
			}
		}
		
		private ISSOR<IInstance_LU<C>, C> ssor = null;
		
		protected ISSOR<IInstance_LU<C>, C> Ssor {
			get {
				if (this.ssor == null)
					this.ssor = (ISSOR<IInstance_LU<C>, C>) Services.getPort("ssor");
				return this.ssor;
			}
		}
		
		private IProblemDefinition<IInstance_LU<C>, C> problem = null;
		
		protected IProblemDefinition<IInstance_LU<C>, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<IInstance_LU<C>, C>) Services.getPort("problem_data");
				return this.problem;
			}
		}
		
		private IInstance_LU<C> instance = null;
		
		protected IInstance_LU<C> Instance {
			get {
				if (this.instance == null)
					this.instance = (IInstance_LU<C>) Services.getPort("instance_type");
				return this.instance;
			}
		}
		
		private INeighbors neighbors = null;
		
		protected INeighbors Neighbors {
			get {
				if (this.neighbors == null)
					this.neighbors = (INeighbors) Services.getPort("neighbors");
				return this.neighbors;
			}
		}
		abstract public int go(); 
	}
}
