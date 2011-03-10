/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.data.ExactRHS;
using environment.MPIDirect;
using common.Verify;
using common.benchmarking.Timer;
using common.data.Initialize;
using common.datapartition.Blocks3D;
using common.data.LHSInit;
using bt.ADI;
using common.data.ProblemDefinition;
using bt.BT;

namespace impl.bt.BT { 

public abstract class BaseIBTImpl<CLASS>: Application, BaseIBT<CLASS>
where CLASS:IClass
{

#region MyRegion
		
public PROBLEM_CLASS problem_class;
		
protected int ncells;
protected int[,] cell_size;
protected int[] grid_points;		
protected int problem_size;
		
override public void initialize()
{	
	cell_size = Blocks.cell_size;	
	
	problem_size = Instance.problem_size;			
	problem_class = Instance.CLASS;								
	
	ncells = Problem.NCells;			
	grid_points = Problem.grid_points;			
}
		
#endregion

private ICell z = null;

protected ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort("z");
		return this.z;
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

private ICell cell = null;

protected ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("topology");
		return this.cell;
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

private IBlocks blocks = null;

protected IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
	}
}

private IInstance_BT<IClass> instance = null;

protected IInstance_BT<IClass> Instance {
	get {
		if (this.instance == null)
			this.instance = (IInstance_BT<IClass>) Services.getPort("instance");
		return this.instance;
	}
}

private IExactRHS<IClass> exact_rhs = null;

protected IExactRHS<IClass> Exact_rhs {
	get {
		if (this.exact_rhs == null)
			this.exact_rhs = (IExactRHS<IClass>) Services.getPort("exact_rhs");
		return this.exact_rhs;
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

private IVerify<IClass, IInstance_BT<IClass>> verify = null;

protected IVerify<IClass, IInstance_BT<IClass>> Verify {
	get {
		if (this.verify == null)
			this.verify = (IVerify<IClass, IInstance_BT<IClass>>) Services.getPort("verify");
		return this.verify;
	}
}

private ITimer timer = null;

protected ITimer Timer {
	get {
		if (this.timer == null)
			this.timer = (ITimer) Services.getPort("timer");
		return this.timer;
	}
}

private IInitialize<IClass> initialize = null;

protected IInitialize<IClass> Initialize {
	get {
		if (this.initialize == null)
			this.initialize = (IInitialize<IClass>) Services.getPort("initialize");
		return this.initialize;
	}
}

private IBlocks3D<IInstance_BT<IClass>, IClass> process = null;

protected IBlocks3D<IInstance_BT<IClass>, IClass> Process {
	get {
		if (this.process == null)
			this.process = (IBlocks3D<IInstance_BT<IClass>, IClass>) Services.getPort("data_partition");
		return this.process;
	}
}

private ILHSInit<IClass> lhsinit = null;

protected ILHSInit<IClass> Lhsinit {
	get {
		if (this.lhsinit == null)
			this.lhsinit = (ILHSInit<IClass>) Services.getPort("lhsinit");
		return this.lhsinit;
	}
}

private IADI<IClass> adi = null;

protected IADI<IClass> Adi {
	get {
		if (this.adi == null)
			this.adi = (IADI<IClass>) Services.getPort("adi");
		return this.adi;
	}
}

private IProblemDefinition<IInstance_BT<IClass>, IClass> problem = null;

protected IProblemDefinition<IInstance_BT<IClass>, IClass> Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition<IInstance_BT<IClass>, IClass>) Services.getPort("problem_data");
		return this.problem;
	}
}


abstract public void compute(); 


}

}
