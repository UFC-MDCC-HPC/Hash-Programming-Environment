/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using environment.MPIDirect;
using jefferson.data.Double;
using skeleton.Farm.Collect;

namespace skeleton.impl.Farm.Collect.AQSumAreas { 

public abstract class BaseISumAreasCollect<Dt>: Synchronizer, ICollect<Dt>
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


public BaseISumAreasCollect() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000238a56c0dbed39ad26a819077a662d5921085ea17ca9a4dc6141477ede60d0e52362b0de49a40b2c36a28973b3164b70652c799ef1b136791b83cbd1b64bcaa4659573d4d057264fe19cc9bd9dc86889cee8af5f37079f9511bdee069c8d445cb7a9d3d5330cb30c33d2ed4f7facfd53b20dc3b8b4f42ddb24f1698a32b552b0";

override public void createSlices() {
	base.createSlices();
} 

abstract public void synchronize(); 


}

}
