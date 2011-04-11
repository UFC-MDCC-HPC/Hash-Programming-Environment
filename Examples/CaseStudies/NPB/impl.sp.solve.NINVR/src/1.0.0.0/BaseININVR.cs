/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.solve.BlockDiagonalMatVecProduct;
using common.problem_size.Class;
using sp.problem_size.Instance_SP;
using common.orientation.Axis;
using common.solve.Method;

namespace impl.sp.solve.NINVR { 

public abstract class BaseININVR<I,C,DIR,MTH>: Computation, BaseIBlockDiagonalMatVecProduct<I,C, DIR,MTH>
	where I:IInstance_SP<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod
{
		
#region	data	
		
protected int[,] start, end, cell_size, slice;
protected double[,,,,] rhs;
protected double bt;

override public void initialize()
{
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	cell_size = Blocks.cell_size;
	slice = Blocks.cell_slice;
	
	bt = Constants.bt;					
	rhs = Problem.Field_rhs;
}
		
#endregion
		
private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null) 
		{
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		}
		return this.blocks;
	}
}

private IProblemDefinition<I,C> problem = null;

public IProblemDefinition<I,C> Problem {
	get {
		if (this.problem == null)
		{
			this.problem = (IProblemDefinition<I,C>) Services.getPort("problem_data");
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

abstract public int go(); 


}

}
