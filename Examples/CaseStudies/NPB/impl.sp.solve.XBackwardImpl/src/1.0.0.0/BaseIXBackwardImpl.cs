/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.Backward;

namespace impl.sp.solve.XBackwardImpl { 

public abstract class BaseIXBackwardImpl: Computation, BaseIBackward
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


public BaseIXBackwardImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000d1c7077a36210daa94de0fecb0ec884e5196d8fb9e74a2b840cda7513416a08931fdc67248680ca83415d3b8b4e3e209b4803d79559a5dc62ecea6aec3011937a6b16794f42ca7fa1e44def6fa7ce1fc6b0c0760ddcd8b0dbdcf0837c7c384f8e4a76883bcd7fa615bcc2b6638d2175c1d9e4d8f63d9b6ace92ed547e47a83c6";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
