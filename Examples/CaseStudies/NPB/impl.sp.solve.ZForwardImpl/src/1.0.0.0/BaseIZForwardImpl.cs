/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.Forward;

namespace impl.sp.solve.ZForwardImpl { 

public abstract class BaseIZForwardImpl: Computation, BaseIForward
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


public BaseIZForwardImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000eff9047215bb7ccaef2e59a1b299cf871ae7066d7fd5ab67abc4d820499d2077aece50bb4fb9a42d904efdef42eedc6538147ddea94bbfaf8b23ecf37e48af0bd5e08721f6355b02310d3bcf6971ba4ade5d807295462c215f1f06dcf1f144b61ba49b6b2f57e9d569260f58230a791499aeacd75d30192f7a6453e290cf489e";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
