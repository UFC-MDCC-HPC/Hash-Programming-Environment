/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.Add;

namespace impl.common.AddImpl { 

public abstract class BaseIAddImpl: Computation, BaseIAdd
{

private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
		   this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
	}
}

private IProblemDefinition problem = null;

public IProblemDefinition Problem {
	get {
		if (this.problem == null)
		   this.problem = (IProblemDefinition) Services.getPort("problem_data");
		return this.problem;
	}
}


public BaseIAddImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000000b451a2bcd50ab8fc6269d3b37d6080ea9857b499ff3e1fcff4e4e7cef260032f4dfe8fec4a8bc513bbf481c13bc8e1ecb32c06d6e6ada7fc216f54cbcaee3f6ab216b657367eefef844062653c70cf4e723d7fad24be7944255e0c2ad290c92a9d7ab7fe3c9bf2ba3038f405a86e6a90cb9b8e969943153f0d632549a07d983";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
