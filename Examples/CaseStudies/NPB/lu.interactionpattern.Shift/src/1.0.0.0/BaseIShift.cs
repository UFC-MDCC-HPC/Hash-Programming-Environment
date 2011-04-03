/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.Buffer;
using lu.topology.Neighbors;
using common.direction.Direction;

namespace lu.interactionpattern.Shift { 

public interface BaseIShift<DIR> : ISynchronizerKind 
where DIR:IDirection
{

	IBuffer Output_buffer {set;}
	IBuffer Input_buffer {set;}
	INeighbors Neighbors {get;}


} // end main interface 

} // end namespace 
