/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;
using common.interactionpattern.Shift;

namespace impl.common.interactionpattern.ShiftToLeftImpl { 

public abstract class BaseIShiftToLeftImpl: Synchronizer, BaseIShift
{

protected ICell cell = null;

public ICell Cell {
	set {
		this.cell = value;
	}
}

protected IBuffer input_buffer = null;

public IBuffer Input_buffer {
	set {
		this.input_buffer = value;
	}
}

protected IBuffer output_buffer = null;

public IBuffer Output_buffer {
	set {
		this.output_buffer = value;
	}
}

protected IMPIDirect mpi = null;

protected IMPIDirect Mpi {
	set {
		this.mpi = value;
	}
}


public BaseIShiftToLeftImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000d7f5ba42a4d2210fe521140fcdebcf86ada2b7d45f2aa9e4054f8a582d91a0d8ad7b9076fe096a7afe942f90822f2cd34d5133f076994d9affe78a3f64a41de336eb1525766d06118ae8ffefe7a3fa5f1d87a80c95d76ad7093cf6aded17fda8c39ab83254fd1f155d3c425f28edd875d2b24b597d9d9a2ba66fd9cba64f23b0";

override public void createSlices() {
	base.createSlices();
	this.Mpi = (IMPIDirect) BackEnd.createSlice(this, UID,"mpi","mpi);
} 

abstract public void synchronize(); 


}

}
