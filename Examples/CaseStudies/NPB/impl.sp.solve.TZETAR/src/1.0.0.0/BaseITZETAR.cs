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

private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
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

abstract public void compute(); 


}

}
