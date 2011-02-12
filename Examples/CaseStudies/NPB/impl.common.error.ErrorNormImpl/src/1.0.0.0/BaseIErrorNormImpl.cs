/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.error.ErrorNorm;
using environment.MPIDirect;
using common.data.ExactSolution;
using MPI;

namespace impl.common.error.ErrorNormImpl { 

public abstract class BaseIErrorNormImpl<I,C>: Computation, BaseIErrorNorm<I,C>
		where I:IInstance<C>
		where C:IClass
{

#region data		
		
protected int[,] cell_low, cell_high;
protected int ncells;
protected double dnzm1, dnym1, dnxm1;
protected double[,,,,] u;
protected int[] grid_points;
protected Intracommunicator comm_setup;
		
protected double[] rms; 
		
public double[] xce { get { return rms; } }
				
override public void initialize()
{
	cell_low = Blocks.cell_low;
	cell_high = Blocks.cell_high;
	
	ncells = Problem.NCells;
	u = Problem.Field_u;
	grid_points = Problem.grid_points;
	dnzm1 = Constants.dnxm1;
	dnym1 = Constants.dnym1;
	dnxm1 = Constants.dnzm1;				
	
	comm_setup = Mpi.localComm(this);	
			
	rms = new double[5];
}

#endregion		
		
private IExactSolution exact_solution = null;
		
protected IExactSolution Exact_solution {
	get {
		if (this.exact_solution == null)
			this.exact_solution = (IExactSolution) Services.getPort("exact_solution");
		return this.exact_solution;
	}
}

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

		
abstract public void compute(); 


}

}
