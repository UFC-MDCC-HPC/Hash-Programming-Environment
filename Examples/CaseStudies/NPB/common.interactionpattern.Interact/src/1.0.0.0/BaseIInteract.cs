/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;

namespace common.interactionpattern.Interact { 

public interface BaseIInteract : ISynchronizerKind 
{

	ICell Y {get;}
	ICell X {get;}
	ICell Z {get;}
	IBuffer Output_buffer_y_south {get;}
	IBuffer Input_buffer_y_south {get;}
	IBuffer Output_buffer_y_north {get;}
	IBuffer Input_buffer_y_north {get;}
	IBuffer Input_buffer_x_west {get;}
	IBuffer Output_buffer_x_west {get;}
	IBuffer Input_buffer_x_east {get;}
	IBuffer Output_buffer_x_east {get;}
	IBuffer Input_buffer_z_top {get;}
	IBuffer Output_buffer_z_top {get;}
	IBuffer Input_buffer_z_bottom {get;}
	IBuffer Output_buffer_z_bottom {get;}
	//IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
