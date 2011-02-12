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
using common.interactionpattern.Interact;
using common.CopyFaces;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace impl.common.CopyFacesImpl { 

public abstract class BaseICopyFacesImpl<I,C>: Synchronizer, BaseICopyFaces<I,C>
		where I:IInstance<C>
		where C:IClass
{
		
#region data
		
protected int ncells;

protected int[,] cell_size;
protected int[,] cell_coord;

protected double[,,,,] u;
			
override public void initialize()
{
	cell_size = Blocks.cell_size;
	cell_coord = Blocks.cell_coord;		
	ncells = Problem.NCells;
	u = Problem.Field_u;
}
		
#endregion		
		
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
		{					
			this.blocks = (IBlocks) Services.getPort("blocks_info");
		}
		return this.blocks;
	}
}

private IBuffer output_buffer_x_east = null;

protected IBuffer Output_buffer_x_east  {
	get {
		if (this.output_buffer_x_east  == null)
			this.output_buffer_x_east  = (IBuffer) Services.getPort("output_buffer_x_east ");
		return this.output_buffer_x_east ;
	}
}
		
private IBuffer output_buffer_x_west = null;

protected IBuffer Output_buffer_x_west {
	get {
		if (this.output_buffer_x_west == null)
			this.output_buffer_x_west = (IBuffer) Services.getPort("output_buffer_x_west");
		return this.output_buffer_x_west;
	}
}
		
		
private IBuffer input_buffer_x_east = null;

protected IBuffer Input_buffer_x_east  {
	get {
		if (this.input_buffer_x_east  == null)
			this.input_buffer_x_east  = (IBuffer) Services.getPort("input_buffer_x_east ");
		return this.input_buffer_x_east ;
	}
}

private IBuffer input_buffer_x_west = null;

protected IBuffer Input_buffer_x_west {
	get {
		if (this.input_buffer_x_west == null)
			this.input_buffer_x_west = (IBuffer) Services.getPort("input_buffer_x_west");
		return this.input_buffer_x_west;
	}
}
		
		
private IBuffer output_buffer_y_south = null;

protected IBuffer Output_buffer_y_south {
	get {
		if (this.output_buffer_y_south == null)
			this.output_buffer_y_south = (IBuffer) Services.getPort("output_buffer_y_south");
		return this.output_buffer_y_south;
	}
}

private IBuffer output_buffer_y_north = null;

protected IBuffer Output_buffer_y_north {
	get {
		if (this.output_buffer_y_north == null)
			this.output_buffer_y_north = (IBuffer) Services.getPort("output_buffer_y_north");
		return this.output_buffer_y_north;
	}
}

private IBuffer input_buffer_y_south = null;

protected IBuffer Input_buffer_y_south {
	get {
		if (this.input_buffer_y_south == null)
			this.input_buffer_y_south = (IBuffer) Services.getPort("input_buffer_y_south");
		return this.input_buffer_y_south;
	}
}

private IBuffer input_buffer_y_north = null;

protected IBuffer Input_buffer_y_north {
	get {
		if (this.input_buffer_y_north == null)
			this.input_buffer_y_north = (IBuffer) Services.getPort("input_buffer_y_north");
		return this.input_buffer_y_north;
	}
}

private IBuffer output_buffer_z_top = null;

protected IBuffer Output_buffer_z_top {
	get {
		if (this.output_buffer_z_top == null)
			this.output_buffer_z_top = (IBuffer) Services.getPort("output_buffer_z_top");
		return this.output_buffer_z_top;
	}
}
		
private IBuffer output_buffer_z_bottom = null;

protected IBuffer Output_buffer_z_bottom {
	get {
		if (this.output_buffer_z_bottom == null)
			this.output_buffer_z_bottom = (IBuffer) Services.getPort("output_buffer_z_bottom");
		return this.output_buffer_z_bottom;
	}
}
		
		
private IBuffer input_buffer_z_top = null;

protected IBuffer Input_buffer_z_top {
	get {
		if (this.input_buffer_z_top == null)
			this.input_buffer_z_top = (IBuffer) Services.getPort("input_buffer_z_top");
		return this.input_buffer_z_top;
	}
}
		
private IBuffer input_buffer_z_bottom = null;

protected IBuffer Input_buffer_z_bottom {
	get {
		if (this.input_buffer_z_bottom == null)
			this.input_buffer_z_bottom = (IBuffer) Services.getPort("input_buffer_z_bottom");
		return this.input_buffer_z_bottom;
	}
}


private IProblemDefinition<I,C> problem = null;

public IProblemDefinition<I,C> Problem {
	get {
		if (this.problem == null)
		{
			this.problem = (IProblemDefinition<I,C>) Services.getPort("problem_data");
		}
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

private IInteract interact = null;

protected IInteract Interact {
	get {
		if (this.interact == null)
			this.interact = (IInteract) Services.getPort("interact");
		return this.interact;
	}
}

		
public BaseICopyFacesImpl() { 

} 

abstract public void synchronize(); 

	

}

	
}
