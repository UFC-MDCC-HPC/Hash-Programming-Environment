/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.ComputeRHS;

namespace impl.common.ComputeRHSImpl { 

public abstract class BaseIComputeRHSImpl: Computation, BaseIComputeRHS
{

protected IBlocks blocks = null;

public IBlocks Blocks {
	get {
        if (this.blocks == null)				
		   this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
	}
			
}

protected IProblemDefinition problem = null;

public IProblemDefinition Problem {
	get {
		if (this.problem == null)
		   this.problem = (IProblemDefinition) Services.getPort("problem_data");
		return this.problem;
	}
}


public BaseIComputeRHSImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000c529e36a6fc6d06d4b6def2307c75249ae24c826ccc5e2c99668fa2d837b0f76b7e937ecfd3fb0aa678f1f4646c82e39d8e40a99fd0f014259fb265eb9bdaaf6bc8d9fe1c1d9d123a8b205be929329d947f8e3673d527df1d72736c5d275e47a19795a4a8d92aa785cb860f43c0e0106a33ef6e10f5240219b9b934a48bd7086";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
