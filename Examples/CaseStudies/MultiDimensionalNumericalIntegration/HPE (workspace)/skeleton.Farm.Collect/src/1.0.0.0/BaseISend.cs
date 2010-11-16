/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;
using environment.MPIDirect;

namespace skeleton.Farm.Collect { 

public interface BaseISend<Ds> : ISynchronizerKind 
where Ds:IData
{

	Ds Data {set;}
	IMPIDirect Mpi {set;}


} // end main interface 

} // end namespace 
