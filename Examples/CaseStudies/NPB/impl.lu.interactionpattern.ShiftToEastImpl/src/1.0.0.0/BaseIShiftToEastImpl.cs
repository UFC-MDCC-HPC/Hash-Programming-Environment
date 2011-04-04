/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Buffer;
using environment.MPIDirect;
using common.direction.Direction;
using lu.topology.Neighbors;
using common.direction.WestToEast;
using lu.interactionpattern.Shift;
using MPI;

namespace impl.lu.interactionpattern.ShiftToEastImpl { 

public abstract class BaseIShiftToEastImpl<DIR>: Synchronizer, BaseIShift<DIR>
where DIR:IWestToEast
{

protected Intracommunicator comm;

private IBuffer output_buffer = null;

public IBuffer Output_buffer {
	get {
		if (this.output_buffer == null)
			this.output_buffer = (IBuffer) Services.getPort("output_buffer");
		return this.output_buffer;
	}
}

private IBuffer input_buffer = null;

public IBuffer Input_buffer {
	get {
		if (this.input_buffer == null)
			this.input_buffer = (IBuffer) Services.getPort("input_buffer");
		return this.input_buffer;
	}
}

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null){
			this.mpi = (IMPIDirect) Services.getPort("mpi");
			comm = Mpi.localComm(this);
		}
		return this.mpi;
	}
}

private DIR direction = default(DIR);

protected DIR Direction {
	get {
		if (this.direction == null)
			this.direction = (DIR) Services.getPort("direction");
		return this.direction;
	}
}

private INeighbors neighbors = null;

public INeighbors Neighbors {
	get {
		if (this.neighbors == null)
			this.neighbors = (INeighbors) Services.getPort("neighbors");
		return this.neighbors;
	}
}


abstract public void synchronize(); 


}

}
