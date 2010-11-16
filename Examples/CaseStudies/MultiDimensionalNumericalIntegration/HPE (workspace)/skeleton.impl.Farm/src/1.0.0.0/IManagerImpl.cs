using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;
using skeleton.Farm.Distribute;
using skeleton.Farm.Collect;

namespace skeleton.impl.Farm { 

public class IManagerImpl<I, S, O, G> : BaseIManagerImpl<I, S, O, G>
where I:IData
where S:IDistribute<I>
where O:IData
where G:ICollect<O>
{

public IManagerImpl() { 

} 

public override void compute() { 
	distribute.synchronize();
	collect.synchronize();

} // end activate method 

}

}
