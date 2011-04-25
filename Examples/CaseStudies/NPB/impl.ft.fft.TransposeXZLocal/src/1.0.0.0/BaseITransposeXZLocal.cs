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
using ft.problem_size.Instance;
using common.orientation.XZ;
using ft.fft.TransposeLocal;

namespace impl.ft.fft.TransposeXZLocal { 
	public abstract class BaseITransposeXZLocal<I, C, DIR>: Computation, BaseITransposeLocal<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXZ{
	   
		#region data
			protected int size1,size2, transblock, transblockpad, maxdim;
			protected int REAL;
			protected int IMAG;
			override public void initialize(){
				size1 = Blocks.size1;
				size2 = Blocks.size2;
				transblock = Constants.transblock;
				transblockpad = Constants.transblockpad;
				REAL = Constants.REAL;
				IMAG = Constants.IMAG;
				
				maxdim = Instance.maxdim;
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
