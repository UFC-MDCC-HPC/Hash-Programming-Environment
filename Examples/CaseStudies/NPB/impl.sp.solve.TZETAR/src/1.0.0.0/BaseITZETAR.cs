/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.BlockDiagonalMatVecProduct;
using common.orientation.Axis;
using common.solve.Method;

namespace impl.sp.solve.TZETAR { 

public abstract class BaseITZETAR<I,C,DIR,MTH>: Computation, BaseIBlockDiagonalMatVecProduct<I,C,DIR,MTH>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod
{
		
#region data		
		
protected int[,] start, end, cell_size, slice;
protected double[,,,,] rhs, rho_i, us, vs, ws, qs, speed, ainv, u ;
protected double bt, c2iv;
protected int ncells;
		
override public void initialize()
{
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	cell_size = Blocks.cell_size;
	slice = Blocks.cell_slice;
	
	rhs = Problem.Field_rhs;
	rho_i = Problem.Field_rho;
	us = Problem.Field_us;
	vs = Problem.Field_vs;
	ws = Problem.Field_ws;
	qs = Problem.Field_qs;
	speed = Problem.Field_speed;
	ainv = Problem.Field_ainv;
    u = Problem.Field_u;
			
			
	bt = Constants.bt;
	c2iv = Constants.c2iv;
			
	ncells = Problem.NCells;
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
