using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Data;
using skeleton.Farm.Collect;
using skeleton.Farm.Distribute;
using skeleton.Farm.Work;

namespace skeleton.impl.Farm { 

public class IWorkerImpl<R, G, J, S, W> : BaseIWorkerImpl<R, G, J, S, W>
where R:IData
where G:ISend<R>
where J:IData
where S:IReceive<J>
where W:IWork<J, R>
{

public IWorkerImpl() { 

} 

public override void compute() { 
	receive.synchronize();
	work.compute();
	send.synchronize();

} // end activate method 

}

}
