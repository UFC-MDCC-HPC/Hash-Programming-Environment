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

namespace impl.sp.solve.ZLHS { 

public abstract class BaseIZLHSImpl<I,C,DIR,MTH>: Computation, BaseILHS<I,C,DIR,MTH>
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


public BaseIZLHSImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000f5078e675ebd08eb0d810a4170906ed61a848050952f3f7db632edc557cd8930802661ed234878e776e1fea77cb6c1fd2f9d7722a98a46f3c8e014b20f63929597c81a2ea5299b147fa2936a40fe78c47b5a9b96560ee469d5776aaa95ed22f8ff419c7a66802f4a5355b44b318ed325262abd9df26640faac078d945fb02292";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
