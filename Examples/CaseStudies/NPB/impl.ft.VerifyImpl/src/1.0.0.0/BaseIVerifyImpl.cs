/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.problem_size.Instance;
using ft.Verify;

namespace impl.ft.VerifyImpl { 
	public abstract class BaseIVerifyImpl<I, C>: Computation, BaseIVerify<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
		#region data
			protected int REAL;
			protected int IMAG;
			protected double[] csum_ref;
			override public void initialize(){
				csum_ref = Instance.csum_ref;
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
