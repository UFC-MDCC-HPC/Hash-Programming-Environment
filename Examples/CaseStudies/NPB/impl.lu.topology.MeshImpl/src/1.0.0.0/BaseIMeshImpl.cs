/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.topology.Neighbors;
using lu.topology.Mesh;

namespace impl.lu.topology.MeshImpl { 

public abstract class BaseIMeshImpl: br.ufc.pargo.hpe.kinds.Environment, BaseICell
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
