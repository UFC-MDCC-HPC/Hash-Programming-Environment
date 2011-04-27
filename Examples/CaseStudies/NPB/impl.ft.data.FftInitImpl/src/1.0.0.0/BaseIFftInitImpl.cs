/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.data.FftInit;

namespace impl.ft.data.FftInitImpl { 
	public abstract class BaseIFftInitImpl<I, C>: Computation, BaseIFftInit<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
		#region data
			protected double[,] u;
			protected int REAL, IMAG;
			override public void initialize(){
				u = Problem.u;
				REAL = Constants.REAL;
				IMAG = Constants.IMAG;
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
		abstract public int go(); 
	}
}
