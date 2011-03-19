/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.CopyFaces;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.ComputeRHS;
using bt.solve.Solve;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using common.direction.Direction;
using environment.MPIDirect;
using common.orientation.X;
using common.orientation.Y;
using common.Add;
using common.data.ProblemDefinition;
using bt.ADI;

namespace impl.bt.ADI { 

public abstract class BaseIADIImpl<C>: Computation, BaseIADI<C>
where C:IClass
{

private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
	}
}

private ICell cell = null;

public ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("topology");
		return this.cell;
	}
}

private ICell x = null;

public ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort("x");
		return this.x;
	}
}

private ICell z = null;

public ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort("z");
		return this.z;
	}
}

private ICell y = null;

public ICell Y {
	get {
		if (this.y == null)
			this.y = (ICell) Services.getPort("y");
		return this.y;
	}
}

private ICopyFaces<IInstance_BT<C>, C> copy_faces = null;

protected ICopyFaces<IInstance_BT<C>, C> Copy_faces {
	get {
		if (this.copy_faces == null)
			this.copy_faces = (ICopyFaces<IInstance_BT<C>, C>) Services.getPort("copy_faces");
		return this.copy_faces;
	}
}

private IComputeRHS<IInstance_BT<C>, C> compute_rhs = null;

protected IComputeRHS<IInstance_BT<C>, C> Compute_rhs {
	get {
		if (this.compute_rhs == null)
			this.compute_rhs = (IComputeRHS<IInstance_BT<C>, C>) Services.getPort("compute_rhs");
		return this.compute_rhs;
	}
}

private ISolve<IInstance_BT<C>, C, IZ, IBeamWarmingMethod> z_solve = null;

protected ISolve<IInstance_BT<C>, C, IZ, IBeamWarmingMethod> Z_solve {
	get {
		if (this.z_solve == null)
			this.z_solve = (ISolve<IInstance_BT<C>, C, IZ, IBeamWarmingMethod>) Services.getPort("z_solve");
		return this.z_solve;
	}
}

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		return this.mpi;
	}
}

private ISolve<IInstance_BT<C>, C, IX, IBeamWarmingMethod> x_solve = null;

protected ISolve<IInstance_BT<C>, C, IX, IBeamWarmingMethod> X_solve {
	get {
		if (this.x_solve == null)
			this.x_solve = (ISolve<IInstance_BT<C>, C, IX, IBeamWarmingMethod>) Services.getPort("x_solve");
		return this.x_solve;
	}
}

private ISolve<IInstance_BT<C>, C, IY, IBeamWarmingMethod> y_solve = null;

protected ISolve<IInstance_BT<C>, C, IY, IBeamWarmingMethod> Y_solve {
	get {
		if (this.y_solve == null)
			this.y_solve = (ISolve<IInstance_BT<C>, C, IY, IBeamWarmingMethod>) Services.getPort("y_solve");
		return this.y_solve;
	}
}

private IAdd<IInstance_BT<C>, C> add = null;

protected IAdd<IInstance_BT<C>, C> Add {
	get {
		if (this.add == null)
			this.add = (IAdd<IInstance_BT<C>, C>) Services.getPort("add");
		return this.add;
	}
}

private IProblemDefinition<IInstance_BT<C>, C> problem = null;

public IProblemDefinition<IInstance_BT<C>, C> Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition<IInstance_BT<C>, C>) Services.getPort("problem_data");
		return this.problem;
	}
}


abstract public void compute(); 


}

}
