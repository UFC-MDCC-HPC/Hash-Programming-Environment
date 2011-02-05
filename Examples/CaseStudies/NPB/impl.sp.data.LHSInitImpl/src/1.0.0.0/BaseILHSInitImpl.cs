/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.data.LHSInit;

namespace impl.sp.data.LHSInitImpl { 

public abstract class BaseILHSInitImpl<I, C>: Computation, BaseILHSInit<I, C>
where I:IInstance_SP<C>
where C:IClass
{

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


abstract public void compute(); 


}

}
