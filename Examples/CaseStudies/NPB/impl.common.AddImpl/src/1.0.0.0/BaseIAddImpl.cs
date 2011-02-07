/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.Add;
using common.problem_size.Class;
using common.problem_size.Instance;


namespace impl.common.AddImpl { 

public abstract class BaseIAddImpl<I,C>: Computation, BaseIAdd<I,C>
		where I:IInstance<C>
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

private IProblemDefinition<I,C> problem = null;

public IProblemDefinition<I,C> Problem {
	get {
		if (this.problem == null)
		   this.problem = (IProblemDefinition<I,C>) Services.getPort("problem_data");
		return this.problem;
	}
}


abstract public void compute(); 


}

}
