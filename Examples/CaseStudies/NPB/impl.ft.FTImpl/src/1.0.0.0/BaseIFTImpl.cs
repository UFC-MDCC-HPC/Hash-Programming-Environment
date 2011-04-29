/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ComputeIndexMap;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.data.ProblemDefinition;
using ft.Checksum;
using ft.data.FftInit;
using ft.data.ComputeInitialConditions;
using environment.MPIDirect;
using common.benchmarking.Timer;
using ft.Evolve;
using ft.Verify;
using ft.fft.Fft;
using ft.FT;
using ft.problem_size.Instance;

namespace impl.ft.FTImpl { 
	public abstract class BaseIFTImpl<C>: Application, BaseIFT<C>
	where C:IClass{
	   
		#region data
			protected int nx, ny, nz, niter_default, layout_0D, layout_1D, layout_2D;
			protected int T_max, T_total, T_checksum;
		    public PROBLEM_CLASS problem_class;
			override public void initialize(){
				nx = Instance.nx;
				ny = Instance.ny;
				nz = Instance.nz;
				niter_default = Instance.niter_default;
				problem_class = Instance.CLASS;
				T_max = Constants.T_max;
				T_total = Constants.T_total;
				T_checksum = Constants.T_checksum;
				
				layout_0D = Constants.layout_0D;
				layout_1D = Constants.layout_1D;
				layout_2D = Constants.layout_2D;
			}
		#endregion
	
		private IBlocks blocks = null;
		
		protected IBlocks Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocks) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		
		private IComputeIndexMap<IInstance_FT<C>, C> compute_index_map = null;
		
		protected IComputeIndexMap<IInstance_FT<C>, C> Compute_index_map {
			get {
				if (this.compute_index_map == null)
					this.compute_index_map = (IComputeIndexMap<IInstance_FT<C>, C>) Services.getPort("compute_indexmap");
				return this.compute_index_map;
			}
		}
		
		private IProblemDefinition<IInstance_FT<C>, C> problem = null;
		
		protected IProblemDefinition<IInstance_FT<C>, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<IInstance_FT<C>, C>) Services.getPort("problem_data");
				return this.problem;
			}
		}
		
		private IChecksum<IInstance_FT<C>, C> checksum = null;
		
		protected IChecksum<IInstance_FT<C>, C> Checksum {
			get {
				if (this.checksum == null)
					this.checksum = (IChecksum<IInstance_FT<C>, C>) Services.getPort("checksum");
				return this.checksum;
			}
		}
		
		private IInstance_FT<C> instance = null;
		
		protected IInstance_FT<C> Instance {
			get {
				if (this.instance == null)
					this.instance = (IInstance_FT<C>) Services.getPort("instance_type");
				return this.instance;
			}
		}
		
		private IFftInit<IInstance_FT<C>, C> fftinit = null;
		
		protected IFftInit<IInstance_FT<C>, C> Fftinit {
			get {
				if (this.fftinit == null)
					this.fftinit = (IFftInit<IInstance_FT<C>, C>) Services.getPort("fft_init");
				return this.fftinit;
			}
		}
		
		private IComputeInitialConditions<IInstance_FT<C>, C> compute_initial_conditions = null;
		
		protected IComputeInitialConditions<IInstance_FT<C>, C> Compute_initial_conditions {
			get {
				if (this.compute_initial_conditions == null)
					this.compute_initial_conditions = (IComputeInitialConditions<IInstance_FT<C>, C>) Services.getPort("compute_initial_conditions");
				return this.compute_initial_conditions;
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
		
		private ITimer timer = null;
		
		protected ITimer Timer {
			get {
				if (this.timer == null)
					this.timer = (ITimer) Services.getPort("timer");
				return this.timer;
			}
		}
		
		private IEvolve<IInstance_FT<C>, C> evolve = null;
		
		protected IEvolve<IInstance_FT<C>, C> Evolve {
			get {
				if (this.evolve == null)
					this.evolve = (IEvolve<IInstance_FT<C>, C>) Services.getPort("evolve");
				return this.evolve;
			}
		}
		
		private IVerify<IInstance_FT<C>, C> verify = null;
		
		protected IVerify<IInstance_FT<C>, C> Verify {
			get {
				if (this.verify == null)
					this.verify = (IVerify<IInstance_FT<C>, C>) Services.getPort("verify");
				return this.verify;
			}
		}
		
		private IFft<IInstance_FT<C>, C> fft = null;
		
		protected IFft<IInstance_FT<C>, C> Fft {
			get {
				if (this.fft == null)
					this.fft = (IFft<IInstance_FT<C>, C>) Services.getPort("fft");
				return this.fft;
			}
		}
		abstract public int go(); 
	}
}
