/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;
using common.interactionpattern.Shift;
using common.direction.Direction;
using common.interactionpattern.Interact;

namespace impl.common.interactionpattern.InteractImpl { 

public abstract class BaseIInteractImpl: Synchronizer, BaseIInteract
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

private IBuffer output_buffer_y_south = null;

public IBuffer Output_buffer_y_south {
	get {
		if (this.output_buffer_y_south == null)
			this.output_buffer_y_south = (IBuffer) Services.getPort("output_buffer_y_south");
		return this.output_buffer_y_south;
	}
}

private IBuffer input_buffer_y_south = null;

public IBuffer Input_buffer_y_south {
	get {
		if (this.input_buffer_y_south == null)
			this.input_buffer_y_south = (IBuffer) Services.getPort("input_buffer_y_south");
		return this.input_buffer_y_south;
	}
}

private IBuffer output_buffer_y_north = null;

public IBuffer Output_buffer_y_north {
	get {
		if (this.output_buffer_y_north == null)
			this.output_buffer_y_north = (IBuffer) Services.getPort("output_buffer_y_north");
		return this.output_buffer_y_north;
	}
}

private IBuffer input_buffer_y_north = null;

public IBuffer Input_buffer_y_north {
	get {
		if (this.input_buffer_y_north == null)
			this.input_buffer_y_north = (IBuffer) Services.getPort("input_buffer_y_north");
		return this.input_buffer_y_north;
	}
}

private IBuffer input_buffer_x_west = null;

public IBuffer Input_buffer_x_west {
	get {
		if (this.input_buffer_x_west == null)
			this.input_buffer_x_west = (IBuffer) Services.getPort("input_buffer_x_west");
		return this.input_buffer_x_west;
	}
}

private IBuffer output_buffer_x_west = null;

public IBuffer Output_buffer_x_west {
	get {
		if (this.output_buffer_x_west == null)
			this.output_buffer_x_west = (IBuffer) Services.getPort("output_buffer_x_west");
		return this.output_buffer_x_west;
	}
}

private IBuffer output_buffer_x_east = null;

public IBuffer Output_buffer_x_east {
	get {
		if (this.output_buffer_x_east == null)
			this.output_buffer_x_east = (IBuffer) Services.getPort("output_buffer_x_east");
		return this.output_buffer_x_east;
	}
}

private IBuffer input_buffer_x_east = null;

public IBuffer Input_buffer_x_east {
	get {
		if (this.input_buffer_x_east == null)
			this.input_buffer_x_east = (IBuffer) Services.getPort("input_buffer_x_east");
		return this.input_buffer_x_east;
	}
}

private IBuffer input_buffer_z_top = null;

public IBuffer Input_buffer_z_top {
	get {
		if (this.input_buffer_z_top == null)
			this.input_buffer_z_top = (IBuffer) Services.getPort("input_buffer_z_top");
		return this.input_buffer_z_top;
	}
}

private IBuffer output_buffer_z_top = null;

public IBuffer Output_buffer_z_top {
	get {
		if (this.output_buffer_z_top == null)
			this.output_buffer_z_top = (IBuffer) Services.getPort("output_buffer_z_top");
		return this.output_buffer_z_top;
	}
}

private IBuffer output_buffer_z_bottom = null;

public IBuffer Output_buffer_z_bottom {
	get {
		if (this.output_buffer_z_bottom == null)
			this.output_buffer_z_bottom = (IBuffer) Services.getPort("output_buffer_z_bottom");
		return this.output_buffer_z_bottom;
	}
}

private IBuffer input_buffer_z_bottom = null;

public IBuffer Input_buffer_z_bottom {
	get {
		if (this.input_buffer_z_bottom == null)
			this.input_buffer_z_bottom = (IBuffer) Services.getPort("input_buffer_z_bottom");
		return this.input_buffer_z_bottom;
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

private IShift<IDirection> shift_y_south = null;

protected IShift<IDirection> Shift_y_south {
	get {
		if (this.shift_y_south == null)
			this.shift_y_south = (IShift<IDirection>) Services.getPort("shift_y_south");
		return this.shift_y_south;
	}
}

private IShift<IDirection> shift_y_north = null;

protected IShift<IDirection> Shift_y_north {
	get {
		if (this.shift_y_north == null)
			this.shift_y_north = (IShift<IDirection>) Services.getPort("shift_y_north");
		return this.shift_y_north;
	}
}

private IShift<IDirection> shift_x_west = null;

protected IShift<IDirection> Shift_x_west {
	get {
		if (this.shift_x_west == null)
			this.shift_x_west = (IShift<IDirection>) Services.getPort("shift_x_west");
		return this.shift_x_west;
	}
}

private IShift<IDirection> shift_x_east = null;

protected IShift<IDirection> Shift_x_east {
	get {
		if (this.shift_x_east == null)
			this.shift_x_east = (IShift<IDirection>) Services.getPort("shift_x_east");
		return this.shift_x_east;
	}
}

private IShift<IDirection> shift_z_top = null;

protected IShift<IDirection> Shift_z_top {
	get {
		if (this.shift_z_top == null)
			this.shift_z_top = (IShift<IDirection>) Services.getPort("shift_z_top");
		return this.shift_z_top;
	}
}

private IShift<IDirection> shift_z_bottom = null;

protected IShift<IDirection> Shift_z_bottom {
	get {
		if (this.shift_z_bottom == null)
			this.shift_z_bottom = (IShift<IDirection>) Services.getPort("shift_z_bottom");
		return this.shift_z_bottom;
	}
}

abstract public void synchronize(); 


}

}
