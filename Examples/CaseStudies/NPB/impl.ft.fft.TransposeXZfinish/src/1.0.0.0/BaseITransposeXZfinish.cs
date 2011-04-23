/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.Axis;
using common.orientation.XZ;
using ft.fft.TransposeFinish;

namespace impl.ft.fft.TransposeXZfinish { 
	public abstract class BaseITransposeXZfinish<I, C, DIR>: Computation, BaseITransposeFinish<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXZ{
	   
		#region data
			protected int np2, size1, size2;
			protected const int REAL = 0;
			protected const int IMAG = 1;
			
			override public void initialize(){
				np2 = Problem.np2;
				size1 = Blocks.size1;
				size2 = Blocks.size2;
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
		
		private DIR axis = default(DIR);
		
		protected DIR Axis {
			get {
				if (this.axis == null)
					this.axis = (DIR) Services.getPort("orientation");
				return this.axis;
			}
		}
		abstract public int go(); 
	}
}
