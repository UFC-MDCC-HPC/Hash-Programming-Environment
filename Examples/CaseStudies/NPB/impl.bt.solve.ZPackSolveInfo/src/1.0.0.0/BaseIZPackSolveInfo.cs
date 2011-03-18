/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackSolveInfo;

namespace impl.bt.solve.ZPackSolveInfo { 

public abstract class BaseIZPackSolveInfo<I, C, DIR, MTH>: Computation, BaseIPackSolveInfo<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IZ
where MTH:IBeamWarmingMethod
{
#region data
	protected double[,,,,] rhs;
	protected int JMAX;
	protected int IMAX;
	protected int[,] cell_size;
	
	override public void initialize(){
		rhs = Problem.Field_rhs;
		cell_size = Blocks.cell_size;
		JMAX = Problem.JMAX;
		IMAX = Problem.IMAX;
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
