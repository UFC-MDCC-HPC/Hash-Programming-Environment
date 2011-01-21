/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.BlockDiagonalMatVecProduct;

namespace impl.sp.solve.TZETAR { 

public abstract class BaseITZETAR: Computation, BaseIBlockDiagonalMatVecProduct
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


public BaseITZETAR() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000051df9e33dd05d03a61afe4e3765837fc1f33a4e7d7b3a9b6bb2e42801b6acf57f45195f9b165cbaacd3735b7a66f419fbf65169088edf170760b42755c222bf9152126cb0c417119f71c7e93dd4e3078140c24088d8a0dcc7110fb5f183cc07e278c019cb43bc44eff3c47bcccd2409343328cf59a1e27e52b8991a0de81fc8d";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
