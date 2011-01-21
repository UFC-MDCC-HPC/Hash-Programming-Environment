/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.Forward;

namespace impl.sp.solve.YForwardImpl { 

public abstract class BaseIYForwardImpl: Computation, BaseIForward
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


public BaseIYForwardImpl() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000027df87e922bbe114bd0efcec142ac6ad0ba821b1cb64bf38f07510180c1b91e0970fc5fb49071bab5debeb8b8f0fb7fe002c7f1a3c4092bbb00e61f62ff73f1ee847081658fe197db7dd28def134b33a801bc8a6c013d3e16c026d0fbfa36346db5446be855b623d2f931874997f83df1766e897d5fc5978b1a8143f120ac3b3";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
