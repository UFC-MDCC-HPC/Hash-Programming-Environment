/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.Buffer;
using common.data.ProblemDefinition;
using environment.MPIDirect;
using common.interactionpattern.Shift;
using common.CopyFaces;

namespace impl.common.CopyFacesImpl { 

public abstract class BaseICopyFacesImpl: Synchronizer, BaseICopyFaces
{

private ICell y = null;

public ICell Y {
	get {
		if (this.y == null)
			this.y = (ICell) Services.getPort("y");
		return this.y;
	}
}

private ICell x = null;

public ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort("x");
		return this.x;
	}
}

private ICell z = null;

public ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort("z");
		return this.z;
	}
}

private IBlocks blocks = null;

public IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		return this.blocks;
	}
}

private IBuffer output_buffer_x = null;

protected IBuffer Output_buffer_x {
	get {
		if (this.output_buffer_x == null)
			this.output_buffer_x = (IBuffer) Services.getPort("output_buffer_x");
		return this.output_buffer_x;
	}
}

private IBuffer input_buffer_x = null;

protected IBuffer Input_buffer_x {
	get {
		if (this.input_buffer_x == null)
			this.input_buffer_x = (IBuffer) Services.getPort("input_buffer_x");
		return this.input_buffer_x;
	}
}

private IBuffer output_buffer_y = null;

protected IBuffer Output_buffer_y {
	get {
		if (this.output_buffer_y == null)
			this.output_buffer_y = (IBuffer) Services.getPort("output_buffer_y");
		return this.output_buffer_y;
	}
}

private IBuffer input_buffer_y = null;

protected IBuffer Input_buffer_y {
	get {
		if (this.input_buffer_y == null)
			this.input_buffer_y = (IBuffer) Services.getPort("input_buffer_y");
		return this.input_buffer_y;
	}
}

private IBuffer output_buffer_z = null;

protected IBuffer Output_buffer_z {
	get {
		if (this.output_buffer_z == null)
			this.output_buffer_z = (IBuffer) Services.getPort("output_buffer_z");
		return this.output_buffer_z;
	}
}

private IBuffer input_buffer_z = null;

protected IBuffer Input_buffer_z {
	get {
		if (this.input_buffer_z == null)
			this.input_buffer_z = (IBuffer) Services.getPort("input_buffer_z");
		return this.input_buffer_z;
	}
}

private IProblemDefinition problem = null;

public IProblemDefinition Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition) Services.getPort("problem_data");
		return this.problem;
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

private IShift shift_y = null;

protected IShift Shift_y {
	get {
		if (this.shift_y == null)
			this.shift_y = (IShift) Services.getPort("shift_y");
		return this.shift_y;
	}
}

private IShift shift_x = null;

protected IShift Shift_x {
	get {
		if (this.shift_x == null)
			this.shift_x = (IShift) Services.getPort("shift_x");
		return this.shift_x;
	}
}

private IShift shift_z = null;

protected IShift Shift_z {
	get {
		if (this.shift_z == null)
			this.shift_z = (IShift) Services.getPort("shift_z");
		return this.shift_z;
	}
}


public BaseICopyFacesImpl() { 

} 

abstract public void synchronize(); 


}

}
