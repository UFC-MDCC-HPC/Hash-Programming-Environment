/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using environment.MPIDirect;
using jefferson.data.Data;

namespace skeleton.Farm.Collect { 

public interface BaseICollect<Dt> : ISynchronizerKind 
where Dt:IData
{

	IMPIDirect Mpi {set;}
	Dt Data {set;}


} // end main interface 

} // end namespace 
