/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;
using environment.MPIDirect;
using skeleton.Farm.Collect;
using skeleton.Farm.Distribute;
using skeleton.Farm.Work;

namespace skeleton.Farm { 

public interface BaseIWorker<R, G, J, S, W> : IComputationKind 
where R:IData
where G:ISend<R>
where J:IData
where S:IReceive<J>
where W:IWork<J, R>
{

	IMPIDirect Mpi {set;}


} // end main interface 

} // end namespace 
