/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.LHS;

namespace impl.sp.solve.XLHS { 

public abstract class BaseIXLHSImpl: Computation, BaseILHS
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


public BaseIXLHSImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000009903d81cd6da91469c563fc609fc79af7a7fc18f05bf924379d0da1ecd2b9650e23437514db2db4a30cb97a5cebd337e1d5dc55e593b68b8dc75a6de92af2ca3eaf86149618d92712ada8a0a724f36e14743df1091422fd28997dd4fe3e4224f7f28b14d3df53f3cb8b4b8dccf2f27643ca507184528aaf671be65efb64f6c86";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
