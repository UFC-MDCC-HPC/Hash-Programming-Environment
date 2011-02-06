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

namespace impl.common.interactionpattern.ShiftToRightImpl { 

public abstract class BaseIShiftToRightImpl<DIR>: Synchronizer, BaseIShift<DIR>
		where DIR:ILeftToRight
{

private ICell cell = null;

public ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort("cell");
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
			this.mpi = (IMPIDirect) Services.getPort("mpi");
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


public BaseIShiftToRightImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000009b65f504a9dd3c958ff5a75af79877d11703a5957ebfd317dc2d982b6858be26e9fc40b54d22fd92d2f18e01e29ceb6e1967abd4adfab8769d1373aa21ccba6773b70ddaf4c48fadd64a10cacf453f71fee1eb58febe34154d0d2553e1d60abf649d0a0188cfd096ca65c0c99ade00205a4bf85a89c16910b6090a380a16ab97";

override public void createSlices() {
	base.createSlices();
} 

abstract public void synchronize(); 


}

}
