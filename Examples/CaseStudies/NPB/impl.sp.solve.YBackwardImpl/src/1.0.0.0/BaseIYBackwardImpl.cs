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
using common.orientation.Y;
using common.solve.BeamWarmingMethod;
using common.solve.Backward;

namespace impl.sp.solve.YBackwardImpl { 

public abstract class BaseIYBackwardImpl<I, C, DIR, MTH>: Computation, BaseIBackward<I, C, DIR, MTH>
where I:IInstance_SP<C>
where C:IClass
where DIR:IY
where MTH:IBeamWarmingMethod
{
		
protected int[,] start, end, slice, cell_size;
protected double[,,,,] lhs, rhs;
		
private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null) 
		{
			this.blocks = (IBlocks) Services.getPort("blocks_info");
					
			start = Blocks.cell_start;
			end = Blocks.cell_end;
			slice = Blocks.cell_slice;
			cell_size = Blocks.cell_size;
		}
		return this.blocks;
	}
}

private IProblemDefinition<I, C> problem = null;

public IProblemDefinition<I, C> Problem {
	get {
		if (this.problem == null)
		{
			this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
					
			lhs = Problem.Field_lhs;
			rhs = Problem.Field_rhs;
		}
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
