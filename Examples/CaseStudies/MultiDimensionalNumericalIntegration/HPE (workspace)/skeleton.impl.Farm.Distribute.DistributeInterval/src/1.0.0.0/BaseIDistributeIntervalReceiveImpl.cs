/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.List;
using data.IntegralCase;
using data.Function;
using environment.MPIDirect;
using skeleton.Farm.Distribute.DistributeInterval;

namespace skeleton.impl.Farm.Distribute.DistributeInterval { 

public abstract class BaseIDistributeIntervalReceiveImpl<F, Dt>: Synchronizer, BaseIDistributeIntervalReceive<F, Dt>
where F:IFunction
where Dt:IList<IIntegralCase<F>>
{

protected Dt data = default(Dt);

public Dt Data {
	set {
		this.data = value;
	}
}

protected IMPIDirect mpi = null;

public IMPIDirect Mpi {
	set {
		this.mpi = value;
	}
}


public BaseIDistributeIntervalReceiveImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000003d592cd4591bfb7068fa3ed048fc6112292ae9f911e0e3db77bf5e6b815707f90b919ac9c481b699c25d1b9342fa1850cdeb8eccec15b95c5fdf078229b2ed29fb90e9387511ff816b5aa08067cdb437c7b1c6ee0bdc8d0864c60828f7e7fd525c7cbcd6465f223a7151bf3f598b05f9438862643a8ad1321bfcf7e13ce333ab";

override public void createSlices() {
	base.createSlices();
} 

abstract public void synchronize(); 


}

}
