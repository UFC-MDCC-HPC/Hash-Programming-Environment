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
using common.orientation.XY_Z;
using ft.fft.TransposeGlobal;

namespace impl.ft.fft.TransposeXY_ZGlobal { 
	public abstract class BaseITransposeXY_ZGlobal<I, C, DIR>: Computation, BaseITransposeGlobal<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXY_Z{
	   
		#region data
			protected int me1,me2;
			override public void initialize(){
				me1 = Blocks.me1;
				me2 = Blocks.me2;
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
