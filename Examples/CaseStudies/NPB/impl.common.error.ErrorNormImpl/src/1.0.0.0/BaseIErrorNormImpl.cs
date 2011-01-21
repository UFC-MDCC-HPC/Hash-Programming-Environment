/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.error.ErrorNorm;

namespace impl.common.error.ErrorNormImpl { 

public abstract class BaseIErrorNormImpl: Computation, BaseIErrorNorm
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


public BaseIErrorNormImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000d11962cf5f605b848b55c0d3ebc6ac85b89abc3158adad4386af3ddbcb087b1013eb204851615da609f77d303e8ed106e5e22357a19cdfb7d99f6b01aef0d8393019c81a2feb62a25dffe0502953fe0ba9478b0da420f624c15d0fcc710468e8aa43d9f6f9fa058666d14a53fb8cfa2d8958ecec5acc72e7a2425b9e34482f99";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
