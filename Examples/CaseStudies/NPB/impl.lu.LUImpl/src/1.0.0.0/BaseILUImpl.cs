/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.InitialValues;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using lu.datapartition.Blocks3D;
using lu.Error;
using lu.Verify;
using environment.MPIDirect;
using lu.data.BoundaryValues;
using lu.ERhs;
using lu.ssor.SSOR;
using lu.data.ProblemDefinition;
using lu.topology.Neighbors;
using lu.Pintgr;
using lu.LU;

namespace impl.lu.LUImpl { 
	public abstract class BaseILUImpl<C>: Application, BaseILU<C>
	where C:IClass{
	
		private IInitialValues<IInstance<C>, C> setiv = null;
		
		protected IInitialValues<IInstance<C>, C> Setiv {
			get {
				if (this.setiv == null)
					this.setiv = (IInitialValues<IInstance<C>, C>) Services.getPort("setiv");
				return this.setiv;
			}
		}
		
		private IBlocksInfo blocks = null;
		
		protected IBlocksInfo Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocksInfo) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		
		private IBlocks3D<IInstance<C>, C> process = null;
		
		protected IBlocks3D<IInstance<C>, C> Process {
			get {
				if (this.process == null)
					this.process = (IBlocks3D<IInstance<C>, C>) Services.getPort("data_partition");
				return this.process;
			}
		}
		
		private IError<IInstance<C>, C> error = null;
		
		protected IError<IInstance<C>, C> Error {
			get {
				if (this.error == null)
					this.error = (IError<IInstance<C>, C>) Services.getPort("error");
				return this.error;
			}
		}
		
		private IVerify<IInstance<C>, C> verify = null;
		
		protected IVerify<IInstance<C>, C> Verify {
			get {
				if (this.verify == null)
					this.verify = (IVerify<IInstance<C>, C>) Services.getPort("verify");
				return this.verify;
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
		
		private IBoundaryValues<IInstance<C>, C> setbv = null;
		
		protected IBoundaryValues<IInstance<C>, C> Setbv {
			get {
				if (this.setbv == null)
					this.setbv = (IBoundaryValues<IInstance<C>, C>) Services.getPort("setbv");
				return this.setbv;
			}
		}
		
		private IInstance<C> instance = null;
		
		protected IInstance<C> Instance {
			get {
				if (this.instance == null)
					this.instance = (IInstance<C>) Services.getPort("instance_type");
				return this.instance;
			}
		}
		
		private IERhs<IInstance<C>, C> erhs = null;
		
		protected IERhs<IInstance<C>, C> Erhs {
			get {
				if (this.erhs == null)
					this.erhs = (IERhs<IInstance<C>, C>) Services.getPort("erhs");
				return this.erhs;
			}
		}
		
		private ISSOR<IInstance<C>, C> ssor = null;
		
		protected ISSOR<IInstance<C>, C> Ssor {
			get {
				if (this.ssor == null)
					this.ssor = (ISSOR<IInstance<C>, C>) Services.getPort("ssor");
				return this.ssor;
			}
		}
		
		private IProblemDefinition<IInstance<C>, C> problem = null;
		
		protected IProblemDefinition<IInstance<C>, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<IInstance<C>, C>) Services.getPort("problem_data");
				return this.problem;
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
		
		private IPintgr<IInstance<C>, C> pintgr = null;
		
		protected IPintgr<IInstance<C>, C> Pintgr {
			get {
				if (this.pintgr == null)
					this.pintgr = (IPintgr<IInstance<C>, C>) Services.getPort("pintgr");
				return this.pintgr;
			}
		}
		abstract public void compute(); 
	}
}
