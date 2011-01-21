/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.topology.Mesh3D;

namespace impl.common.topology.Mesh3DImpl { 

public abstract class BaseICellImpl: Environment, BaseICell
{

protected ICell x = null;

public ICell X {
	set {
		this.x = value;
	}
}

protected ICell y = null;

public ICell Y {
	set {
		this.y = value;
	}
}

protected ICell z = null;

public ICell Z {
	set {
		this.z = value;
	}
}


public BaseICellImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000008584adccb1e9b176bb3b5aa3e4f4989c9923b70cfce0855c68c7c1025e59d0c41ae3bd30bfc1104ce88f0da674e6143aae8615dfa9b53efe7507b443a247e2ea5ec3f5cf6f19710d921f8caa6e2dea8399c6fe28ca772bc853f9d610c25832e86ab6a0595788e78dafe9cc0635dd853f788ece170ff8e5176943c30bc42730b3";

override public void createSlices() {
	base.createSlices();
} 


}

}
