/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.BlockDiagonalMatVecProduct;

namespace impl.sp.solve.NINVR { 

public abstract class BaseININVR: Computation, BaseIBlockDiagonalMatVecProduct
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


public BaseININVR() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000007d90a5160982ec6fe1e136fdc541867a8e8a5b3f68311bba5265af3f61bdf79d01bd8b757a17afcd5360050a7a15856ddaf49d4af66fb1388554402c951c264ef6fae3d033a929ece38aeeceb104d1e1546068fd18b59d712d6d1c1de1ab9695cef49197d705a6888cf5347a56e3106311d5a51b64797b2377d714f387f1ea87";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
