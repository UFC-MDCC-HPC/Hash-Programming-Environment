/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.LHS;

namespace impl.sp.solve.ZLHS { 

public abstract class BaseIZLHSImpl: Computation, BaseILHS
{

protected IBlocks blocks = null;

public IBlocks Blocks {
	set {
		this.blocks = value;
	}
}

protected IProblemDefinition problem = null;

public IProblemDefinition Problem {
	set {
		this.problem = value;
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
