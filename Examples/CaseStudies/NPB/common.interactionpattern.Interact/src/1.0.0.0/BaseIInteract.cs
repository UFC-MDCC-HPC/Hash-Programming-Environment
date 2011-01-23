/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.Buffer;
using environment.MPIDirect;

namespace common.interactionpattern.Interact { 

public interface BaseIInteract : ISynchronizerKind 
{

	ICell Cell_y {get;}
	ICell Cell_x {get;}
	ICell Cell_z {get;}
	IBuffer Output_buffer {get;}
	IBuffer Input_buffer {get;}
	IMPIDirect Mpi {get;}


} // end main interface 

} // end namespace 
