/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.topology.Neighbors;
using lu.topology.Mesh3D;

namespace impl.lu.topology.Mesh3DImpl { 

public abstract class BaseIMesh3DImpl: br.ufc.pargo.hpe.kinds.Environment, BaseIMesh3D
{

private INeighbors neighbors = null;

public INeighbors Neighbors {
	get {
		if (this.neighbors == null)
			this.neighbors = (INeighbors) Services.getPort("neighbors");
		return this.neighbors;
	}
}



}

}
