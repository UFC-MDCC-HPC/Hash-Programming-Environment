/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;
using common.direction.LeftToRight;
using common.interactionpattern.Shift;
using MPI;

namespace impl.common.interactionpattern.ShiftToRightImpl { 

public abstract class BaseIShiftToRightImpl<DIR>: Synchronizer, BaseIShift<DIR>
		where DIR:ILeftToRight
{
		
protected Intracommunicator comm;			
		
override public void initialize()
{
   comm = this.WorldComm; //Mpi.localComm(this);
}		
		
private ICell cell = null;

public ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("topology");
		return this.cell;
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

private IBuffer output_buffer = null;

public IBuffer Output_buffer {
	get {
		if (this.output_buffer == null)
			this.output_buffer = (IBuffer) Services.getPort("output_buffer");
		return this.output_buffer;
	}
}

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null) 
		{					
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


abstract public int go(); 


}

}
