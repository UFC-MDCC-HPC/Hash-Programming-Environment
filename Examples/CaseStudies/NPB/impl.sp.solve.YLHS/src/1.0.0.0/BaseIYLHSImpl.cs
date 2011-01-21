/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.solve.LHS;

namespace impl.sp.solve.YLHS { 

public abstract class BaseIYLHSImpl: Computation, BaseILHS
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


public BaseIYLHSImpl() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000015c46542f2907f5e45ff5d82fb3d2a01ab3eaa1d0e2b6d1740b0b5ac79689e804193f9d5e1bc3a022214c0849e3968e4a917b0c7491b008111cd43fd027b6220299dbcb8354dddc6e8d13f50746e59716364d2ded799ed0e142a486526e91d7ab6e58fc0127dadf1544eeec8dc52acf5a9772a551cf573b07141914712f2eada";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
