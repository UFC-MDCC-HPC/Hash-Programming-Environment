/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.BlockDiagonalMatVecProduct;

namespace impl.sp.solve.PINVR { 

public abstract class BaseIPNVR: Computation, BaseIBlockDiagonalMatVecProduct
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


public BaseIPNVR() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000ef688b527ba4d99375693e95a828b595702bf5e8b74c6c5e7aa459be39541d1a698f17806588efa1f118609d96aaf700056f025410648901b954868bda037ee5ddee13ed90b474913c5364c5173ad95709017e7a6d72adb6e4e4024c9407f4c8bb79d2687f40fab7c3db22d1ee9cd21f41170ce5a673c12c283e23d85856b192";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
