/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.data.LHSInit;

namespace impl.common.data.LHSInitImpl { 

public abstract class BaseILHSInitImpl<I, C>: Computation, BaseILHSInit<I, C>
where I:IInstance<C>
where C:IClass
{
		
#region data		
		
protected int[,] cell_size, cell_low, cell_high, start, end, slice, cell_coord;		
protected int ncells, IMAX, JMAX, KMAX, maxcells;		
protected double[,,,,] lhs;

override public void initialize()
{	
	cell_size = Blocks.cell_size;
	cell_low = Blocks.cell_low;
	cell_high = Blocks.cell_high;
	cell_coord = Blocks.cell_coord;
	start = Blocks.cell_start;
	end = Blocks.cell_end;
	slice = Blocks.cell_slice;
	
	ncells = Problem.NCells;
	lhs = Problem.Field_lhs;			
				
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


abstract public int go(); 


}

}
