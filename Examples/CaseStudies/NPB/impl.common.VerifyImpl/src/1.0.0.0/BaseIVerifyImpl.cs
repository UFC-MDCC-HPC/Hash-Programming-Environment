/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.error.RHSNorm;
using environment.MPIDirect;
using common.error.ErrorNorm;
using common.Verify;
using common.problem_size.Class;
using common.CopyFaces;
using common.ComputeRHS;

namespace impl.common.VerifyImpl { 

public abstract class BaseIVerifyImpl<I,C>: Computation, BaseIVerify<I,C>
		where I:IInstance<C>
		where C:IClass
{

private I instance = default(I);

protected I Instance {
	get {
		if (this.instance == null)
			this.instance = (I) Services.getPort("instance");
		return this.instance;
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

private IBlocks blocks_info = null;

public IBlocks Blocks_info {
	get {
		if (this.blocks_info == null)
			this.blocks_info = (IBlocks) Services.getPort("blocks_info");
		return this.blocks_info;
	}
}

private IProblemDefinition<I,C> problem = null;

public IProblemDefinition<I,C> Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition<I,C>) Services.getPort("problem_data");
		return this.problem;
	}
}

private ICopyFaces<I,C> copy_faces = null;

protected ICopyFaces<I,C> Copy_faces {
	get {
		if (this.copy_faces == null)
			this.copy_faces = (ICopyFaces<I,C>) Services.getPort("copy_faces");
		return this.copy_faces;
	}
}

private IComputeRHS<I,C> compute_rhs = null;

protected IComputeRHS<I,C> Compute_rhs {
	get {
		if (this.compute_rhs == null)
			this.compute_rhs = (IComputeRHS<I,C>) Services.getPort("compute_rhs");
		return this.compute_rhs;
	}
}

private IRHSNorm<I,C> rhs_norm = null;

protected IRHSNorm<I,C> Rhs_norm {
	get {
		if (this.rhs_norm == null)
			this.rhs_norm = (IRHSNorm<I,C>) Services.getPort("rhs_norm");
		return this.rhs_norm;
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

private IErrorNorm<I,C> error_norm = null;

protected IErrorNorm<I,C> Error_norm {
	get {
		if (this.error_norm == null)
			this.error_norm = (IErrorNorm<I,C>) Services.getPort("error_norm");
		return this.error_norm;
	}
}


abstract public int go(); 


}

}
