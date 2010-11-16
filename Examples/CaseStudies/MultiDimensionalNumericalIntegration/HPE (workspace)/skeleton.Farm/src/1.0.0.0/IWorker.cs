using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;
using skeleton.Farm.Collect;
using skeleton.Farm.Distribute;
using skeleton.Farm.Work;

namespace skeleton.Farm { 

public interface IWorker<R, G, J, S, W> : BaseIWorker<R, G, J, S, W>
where R:IData
where G:ISend<R>
where J:IData
where S:IReceive<J>
where W:IWork<J, R>
{


} // end main interface 

} // end namespace 
