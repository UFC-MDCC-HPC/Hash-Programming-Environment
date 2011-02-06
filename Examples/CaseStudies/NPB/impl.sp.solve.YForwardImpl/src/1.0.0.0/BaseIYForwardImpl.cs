/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;
using common.solve.BeamWarmingMethod;
using common.orientation.Y;
using common.solve.Forward;

namespace impl.sp.solve.YForwardImpl { 

public abstract class BaseIYForwardImpl<I, C, MTH, DIR>: Computation, BaseIForward<I, C, MTH, DIR>
where I:IInstance_SP<C>
where C:IClass
where MTH:IBeamWarmingMethod
where DIR:IY
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

private DIR axis = default(DIR);

protected DIR Axis {
	get {
		if (this.axis == null)
			this.axis = (DIR) Services.getPort("orientation");
		return this.axis;
	}
}

private MTH method = default(MTH);

protected MTH Method {
	get {
		if (this.method == null)
			this.method = (MTH) Services.getPort("method");
		return this.method;
	}
}


abstract public void compute(); 


}

}
