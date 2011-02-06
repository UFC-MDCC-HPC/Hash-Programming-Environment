/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;
using common.direction.RightToLeft;
using common.interactionpattern.Shift;

namespace impl.common.interactionpattern.ShiftToLeftImpl { 

public abstract class BaseIShiftToLeftImpl<DIR>: Synchronizer, BaseIShift<DIR>
		where DIR:IRightToLeft
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


public BaseIShiftToLeftImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000edc7b05e0bb9da2bd993cc6deb534c575306f8c96142656271c343e24a1b55eb2a358eff5568646dff1cc33e86eb80ca0ce0402626f531a8f785bb04b5afcee7a8b5314bd04b5112f04d915c2b6947e66abf5e2640ae34d736ce0cd7c46fc9839e66eda8baaee1d3e95beadebfe6831864d972a66c59bc776b3ac44aefda0885";

override public void createSlices() {
	base.createSlices();
} 

abstract public void synchronize(); 


}

}
