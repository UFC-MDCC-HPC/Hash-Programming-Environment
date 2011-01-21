/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.Backward;

namespace impl.sp.solve.YBackwardImpl { 

public abstract class BaseIYBackwardImpl: Computation, BaseIBackward
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


public BaseIYBackwardImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000008f39c0ca5ea69d42a10e0b76f61e4f5d24d6d2dfe8595fda3c90764f9a995b51ac5092a64bbfa19c7a07f5f0033f1afa9752e90aebbea9d8d3072c4760b12a172d5caae4b15188c870e4a5740764a8d25439679503e76cce652629c582ecad893028b5bb9c606a0cd9855db45615cf3ba1ee02138af862f40a3213b48e61a8d7";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
