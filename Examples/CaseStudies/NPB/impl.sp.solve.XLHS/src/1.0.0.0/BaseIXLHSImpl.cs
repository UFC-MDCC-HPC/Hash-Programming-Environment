/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Class;
using common.solve.LHS;
using sp.problem_size.Instance_SP;
using common.orientation.X;
using common.solve.BeamWarmingMethod;

namespace impl.sp.solve.XLHS { 

public abstract class BaseIXLHSImpl<I,C,DIR,MTH>: Computation, BaseILHS<I,C,DIR,MTH>
	where I:IInstance_SP<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod
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


public BaseIXLHSImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000009903d81cd6da91469c563fc609fc79af7a7fc18f05bf924379d0da1ecd2b9650e23437514db2db4a30cb97a5cebd337e1d5dc55e593b68b8dc75a6de92af2ca3eaf86149618d92712ada8a0a724f36e14743df1091422fd28997dd4fe3e4224f7f28b14d3df53f3cb8b4b8dccf2f27643ca507184528aaf671be65efb64f6c86";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
