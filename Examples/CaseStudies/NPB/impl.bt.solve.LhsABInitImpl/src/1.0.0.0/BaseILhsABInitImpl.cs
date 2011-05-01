/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.LhsABInit;

namespace impl.bt.solve.LhsABInitImpl { 
	public abstract class BaseILhsABInitImpl: Computation, BaseILhsABInit
	{
/*		private IBlocks blocks = null;
		protected IBlocks Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocks) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		private IProblemDefinition<I, C> problem = null;
		protected IProblemDefinition<I, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
				return this.problem;
			}
		}*/
		abstract public int go(); 
	}
}
