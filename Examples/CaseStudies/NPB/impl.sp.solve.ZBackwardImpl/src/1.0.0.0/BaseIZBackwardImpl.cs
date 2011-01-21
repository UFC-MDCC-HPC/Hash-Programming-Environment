/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.Backward;

namespace impl.sp.solve.ZBackwardImpl { 

public abstract class BaseIZBackwardImpl: Computation, BaseIBackward
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


public BaseIZBackwardImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000ab961be9107b7c2cea9946daf77c0bf540e7c5c148728ba23eb44be488a1f2658179127950333eac79062c3555de721150b1b189f5b60b330b5b6058da0e7ccec50d8030ff6ced4d62986412cc4ff463570511ffd6b30fda992da7a0e2a9970e39e70030da15114e0ce5b02b0a80b0d7bc6f27d0de0880dc476e78457e1a3597";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
