/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using environment.MPIDirect;
using jefferson.data.Double;
using skeleton.Farm.Collect.SumAreas;

namespace skeleton.impl.Farm.Collect.SumAreas { 

public abstract class BaseISumImpl<Dt>: Synchronizer, BaseISum<Dt>
where Dt:IDouble
{

protected IMPIDirect mpi = null;

public IMPIDirect Mpi {
	set {
		this.mpi = value;
	}
}

protected Dt data = default(Dt);

public Dt Data {
	set {
		this.data = value;
	}
}


public BaseISumImpl() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000043e9f0368bcbb1441d34297b773f3f6f54a56cae3f470b5033ecf2a0de65c0fe22be1e5c995d2039a133b9b47bef56617e208f7c4a0ba77c9b4282bce0f3c87dd8a617a455bb926eb9254793de5d53edcd79af4b5acafedd95c3480fd26d894e70882a3b83f56dc15a06522ca4eedc8d3d95c2a4c833889a5cc85749ba151aa4";

override public void createSlices() {
	base.createSlices();
} 

abstract public void synchronize(); 


}

}
