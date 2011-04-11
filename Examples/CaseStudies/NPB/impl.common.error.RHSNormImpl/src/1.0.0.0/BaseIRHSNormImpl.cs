/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;
using common.error.RHSNorm;
using common.problem_size.Class;
using common.problem_size.Instance;
using common.datapartition.BlocksInfo;
using environment.MPIDirect;
using MPI;

namespace impl.common.error.RHSNormImpl { 

public abstract class BaseIRHSNormImpl<I,C>: Computation, BaseIRHSNorm<I,C>
		where I:IInstance<C>
		where C:IClass
{

#region data		
				
protected int[,] cell_size, start, end;		
protected int ncells;
protected double[,,,,] rhs;
protected int[] grid_points;
protected Intracommunicator comm_setup;
		
override public void initialize()
{
	cell_size = Blocks.cell_size;
    start = Blocks.cell_start;
	end = Blocks.cell_end;
	
	ncells = Problem.NCells;
	rhs = Problem.Field_rhs;
	grid_points = Problem.grid_points;
	
	comm_setup = this.WorldComm; // Mpi.localComm(this);			
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

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null)
		{
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		}
		return this.mpi;
	}
}
		

abstract public int go(); 


}

}
