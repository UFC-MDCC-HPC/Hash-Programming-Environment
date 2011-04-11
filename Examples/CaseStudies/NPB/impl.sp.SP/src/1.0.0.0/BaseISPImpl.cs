/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.datapartition.Blocks3D;
using environment.MPIDirect;
using common.Verify;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.data.Initialize;
using common.data.ExactRHS;
using common.data.LHSInit;
using common.benchmarking.Timer;
using sp.ADI;
using sp.SP;
using common.problem_size.Instance;

namespace impl.sp.SP { 

public abstract class BaseISPImpl<CLASS>: Application, BaseISP<CLASS>
where CLASS:IClass
{
					
#region MyRegion
		
public PROBLEM_CLASS problem_class;
		
protected int ncells;
protected int[,] cell_size;
protected int[] grid_points;		
protected int problem_size;
protected int niter;
protected double dt;
		
override public void initialize()
{	
	cell_size = Blocks.cell_size;		
	ncells = Blocks.ncells;			
	
	problem_size = Instance.problem_size;			
	problem_class = Instance.CLASS;	
	niter = Instance.niter_default;
    dt = Instance.dt_default;
	
	grid_points = Problem.grid_points;			
}
		
#endregion
		
		
private ITimer timer = null;

protected ITimer Timer {
	get {
		if (this.timer == null)
			this.timer = (ITimer) Services.getPort("timer");
		return this.timer;
	}
}

private IInitialize<IInstance_SP<CLASS>, CLASS> initialize_ = null;

protected IInitialize<IInstance_SP<CLASS>, CLASS> Initialize {
	get {
		if (this.initialize_ == null)
			this.initialize_ = (IInitialize<IInstance_SP<CLASS>, CLASS>) Services.getPort("initialize");
		return this.initialize_;
	}
}

private IExactRHS<IInstance_SP<CLASS>, CLASS> exact_rhs = null;

protected IExactRHS<IInstance_SP<CLASS>, CLASS> Exact_rhs {
	get {
		if (this.exact_rhs == null)
			this.exact_rhs = (IExactRHS<IInstance_SP<CLASS>, CLASS>) Services.getPort("exact_rhs");
		return this.exact_rhs;
	}
}

private ILHSInit<IInstance_SP<CLASS>, CLASS> lhsinit = null;

protected ILHSInit<IInstance_SP<CLASS>, CLASS> Lhsinit {
	get {
		if (this.lhsinit == null)
			this.lhsinit = (ILHSInit<IInstance_SP<CLASS>, CLASS>) Services.getPort("lhsinit");
		return this.lhsinit;
	}
}
		
		
private IBlocks blocks = null;

protected IBlocks Blocks {
	get {
		if (this.blocks == null) 
		{
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		}
		return this.blocks;
	}
}

private ICell x = null;

protected ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort("x");
		return this.x;
	}
}

private ICell y = null;

protected ICell Y {
	get {
		if (this.y == null)
			this.y = (ICell) Services.getPort("y");
		return this.y;
	}
}

private ICell z = null;

protected ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort("z");
		return this.z;
	}
}
		
		
private IInstance_SP<CLASS> instance = default(IInstance_SP<CLASS>);

protected IInstance_SP<CLASS> Instance {
	get {
		if (instance==null) 
		{
			this.instance = (IInstance_SP<CLASS>) Services.getPort("instance");
		}
		return instance;
	}
}		
		

private IProblemDefinition<IInstance_SP<CLASS>, CLASS> problem = null;

protected IProblemDefinition<IInstance_SP<CLASS>, CLASS> Problem {
	get {
		if (this.problem == null) 
		{
			this.problem = (IProblemDefinition<IInstance_SP<CLASS>, CLASS>) Services.getPort("problem_data");
		}
		return this.problem;
	}
}

private IBlocks3D<IInstance_SP<CLASS>, CLASS> process = null;

protected IBlocks3D<IInstance_SP<CLASS>, CLASS> Process {
	get {
		if (this.process == null)
			this.process = (IBlocks3D<IInstance_SP<CLASS>, CLASS>) Services.getPort("data_partition");
		return this.process;
	}
}

private IMPIDirect mpi = null;

protected IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		return this.mpi;
	}
}

private IVerify<IInstance_SP<CLASS>, CLASS> verify = null;

protected IVerify<IInstance_SP<CLASS>, CLASS> Verify {
	get {
		if (this.verify == null)
			this.verify = (IVerify<IInstance_SP<CLASS>, CLASS>) Services.getPort("verify");
		return this.verify;
	}
}

private IADI<CLASS> adi = null;

protected IADI<CLASS> Adi {
	get {
		if (this.adi == null)
			this.adi = (IADI<CLASS>) Services.getPort("adi");
		return this.adi;
	}
}


abstract public int go(); 


}

}
