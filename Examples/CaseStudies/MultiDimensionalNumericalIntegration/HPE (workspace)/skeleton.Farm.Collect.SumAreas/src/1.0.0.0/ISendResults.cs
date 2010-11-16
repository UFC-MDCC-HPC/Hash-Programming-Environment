using br.ufc.pargo.hpe.kinds;
using jefferson.data.Double;
using skeleton.Farm.Collect;
using MPI;

namespace skeleton.Farm.Collect.SumAreas { 

public interface ISendResults<Ds> : BaseISendResults<Ds>, ISend<Ds>
where Ds:IDouble
{


} // end main interface 

} // end namespace 
