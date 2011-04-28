/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.fft.Fftz2;
using ft.fft.Cfftz;

namespace impl.ft.fft.CfftzImpl { 
	public abstract class BaseICfftzImpl<I, C>: Computation, BaseICfftz<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
		#region data
			protected int REAL;
			protected int IMAG;
			protected int fftblock, fftblockpad;
			protected double[,] u;
			override public void initialize(){
				fftblock    = Blocks.fftblock;
				fftblockpad = Blocks.fftblockpad;
				REAL        = Constants.REAL;
				IMAG        = Constants.IMAG;
				u           = Problem.u;
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
		
		private IFftz2<I, C> fftz2 = null;
		
		protected IFftz2<I, C> Fftz2 {
			get {
				if (this.fftz2 == null)
					this.fftz2 = (IFftz2<I, C>) Services.getPort("fftz2");
				return this.fftz2;
			}
		}
		abstract public int go(); 
	}
}
