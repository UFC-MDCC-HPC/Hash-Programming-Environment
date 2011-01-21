/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.BlockDiagonalMatVecProduct;

namespace impl.sp.solve.TXINVR { 

public abstract class BaseITXINVR: Computation, BaseIBlockDiagonalMatVecProduct
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


public BaseITXINVR() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000ddc6a8247211751d7820c59f40f60abfe1f88087018c274a2b2cbd294086e87e93a5db2c7ee68d047aa7e454cf4f04991a77fe331d9525ba05b6f1f6df82498bde125fece3b95a4a96b2d25550af5674fca413becf2d121be69ee2bb77a87a8f1fa04b8665694e0292507d5c9f3dc8f43c434e087e0651482064ae3d4576768e";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
