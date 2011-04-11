/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.data.ExactSolution;
using common.data.Initialize;

namespace impl.sp.data.InitializeImpl { 

public abstract class BaseIInitializeImpl<I, C>: Computation, BaseIInitialize<I, C>
where I:IInstance_SP<C>
where C:IClass
{
		
#region data		
		
protected int[,] cell_size, cell_low, cell_high, start, end, slice;		
protected int ncells, IMAX, JMAX, KMAX, maxcells;		
protected double[,,,,] u;		
protected double dnzm1, dnym1, dnxm1; 

		
override public void initialize()
{
	cell_size = Blocks.cell_size;
	cell_low = Blocks.cell_low;
	cell_high = Blocks.cell_high;
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	slice = Blocks.cell_slice;
	ncells = Problem.NCells;
	
	u = Problem.Field_u;
				
	dnzm1 = Constants.dnzm1;
	dnym1 = Constants.dnym1;
	dnxm1 = Constants.dnxm1;
	
	IMAX = Problem.IMAX;
	JMAX = Problem.JMAX;
	KMAX = Problem.KMAX;
	maxcells = Problem.maxcells;
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

private IProblemDefinition<I, C> problem = null;

public IProblemDefinition<I, C> Problem {
	get {
		if (this.problem == null)
		{
			this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
		}	
		return this.problem;
	}
}

private IExactSolution exact_solution = null;

protected IExactSolution Exact_solution {
	get {
		if (this.exact_solution == null)
			this.exact_solution = (IExactSolution) Services.getPort("exact_solution");
		return this.exact_solution;
	}
}


abstract public int go(); 


}

}
