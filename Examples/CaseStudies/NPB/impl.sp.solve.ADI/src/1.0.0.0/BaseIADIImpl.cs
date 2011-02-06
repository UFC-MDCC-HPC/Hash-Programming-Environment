/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.topology.Ring;
using common.CopyFaces;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.Solve;
using common.solve.BeamWarmingMethod;
using common.orientation.Y;
using common.orientation.Z;
using common.solve.BlockDiagonalMatVecProduct;
using common.orientation.XYZ;
using environment.MPIDirect;
using common.Add;
using common.datapartition.Blocks3D;
using common.data.ProblemDefinition;
using common.ComputeRHS;
using common.orientation.X;
using sp.ADI;

namespace impl.sp.solve.ADI { 

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

private ICell x = null;

public ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort("x");
		return this.x;
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

private ICell z = null;

public ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort("z");
		return this.z;
	}
}

private ICopyFaces<IInstance_SP<C>, C> copy_faces = null;

protected ICopyFaces<IInstance_SP<C>, C> Copy_faces {
	get {
		if (this.copy_faces == null)
			this.copy_faces = (ICopyFaces<IInstance_SP<C>, C>) Services.getPort("copy_faces");
		return this.copy_faces;
	}
}

private ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IY> y_solve = null;

protected ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IY> Y_solve {
	get {
		if (this.y_solve == null)
			this.y_solve = (ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IY>) Services.getPort("y_solve");
		return this.y_solve;
	}
}

private ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IZ> z_solve = null;

protected ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IZ> Z_solve {
	get {
		if (this.z_solve == null)
			this.z_solve = (ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IZ>) Services.getPort("z_solve");
		return this.z_solve;
	}
}

private IBlockDiagonalMatVecProduct<IInstance_SP<C>, C, IXYZ, IBeamWarmingMethod> txinvr = null;

protected IBlockDiagonalMatVecProduct<IInstance_SP<C>, C, IXYZ, IBeamWarmingMethod> Txinvr {
	get {
		if (this.txinvr == null)
			this.txinvr = (IBlockDiagonalMatVecProduct<IInstance_SP<C>, C, IXYZ, IBeamWarmingMethod>) Services.getPort("txinvr");
		return this.txinvr;
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

private IAdd<IInstance_SP<C>, C> add = null;

protected IAdd<IInstance_SP<C>, C> Add {
	get {
		if (this.add == null)
			this.add = (IAdd<IInstance_SP<C>, C>) Services.getPort("add");
		return this.add;
	}
}

private IProblemDefinition<IInstance_SP<C>, C> problem = null;

public IProblemDefinition<IInstance_SP<C>, C> Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition<IInstance_SP<C>, C>) Services.getPort("problem_data");
		return this.problem;
	}
}

private IComputeRHS<IInstance_SP<C>, C> compute_rhs = null;

protected IComputeRHS<IInstance_SP<C>, C> Compute_rhs {
	get {
		if (this.compute_rhs == null)
			this.compute_rhs = (IComputeRHS<IInstance_SP<C>, C>) Services.getPort("compute_rhs");
		return this.compute_rhs;
	}
}

private ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IX> x_solve = null;

protected ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IX> X_solve {
	get {
		if (this.x_solve == null)
			this.x_solve = (ISolve<IInstance_SP<C>, C, IBeamWarmingMethod, IX>) Services.getPort("x_solve");
		return this.x_solve;
	}
}


abstract public void compute(); 


}

}
