/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.Forward;

namespace impl.sp.solve.XForwardImpl { 

public abstract class BaseIXForwardImpl: Computation, BaseIForward
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


public BaseIXForwardImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000003b9a123ce9c40207e7d19e5e18cd3f94357433a419eee738e2d0461329c5e44c3e45620055b73b3cc27fca2cffa65cff9527a308d1a0baf55c2a9cc58c8468bb81aabc66ac6ff2143ec298b12446d2eece98bda46f827f1ab22f3a5fed8f8509e64f8c850f56eb5ae4c9c32f71b422051c77345dde28434fe9a50549c188a68f";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
