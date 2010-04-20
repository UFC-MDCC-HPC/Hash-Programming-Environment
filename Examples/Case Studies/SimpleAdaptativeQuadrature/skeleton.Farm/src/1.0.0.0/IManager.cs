using hpe.kinds;
using jefferson.data.Data;
using skeleton.Farm.Distribute;
using skeleton.Farm.Collect;

namespace skeleton.Farm { 

public interface IManager<I, S, O, G> : BaseIManager<I, S, O, G>
where I:IData
where S:IDistribute<I>
where O:IData
where G:ICollect<O>
{


} // end main interface 

} // end namespace 
