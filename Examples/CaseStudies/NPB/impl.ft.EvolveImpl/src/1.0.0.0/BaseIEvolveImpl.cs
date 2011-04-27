/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.Evolve;

namespace impl.ft.EvolveImpl { 
	public abstract class BaseIEvolveImpl<I, C>: Computation, BaseIEvolve<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	
		#region data
			protected int REAL;
			protected int IMAG;
			protected int size1, size2;
			override public void initialize(){
				size1=Blocks.size1;
				size2=Blocks.size2;
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
