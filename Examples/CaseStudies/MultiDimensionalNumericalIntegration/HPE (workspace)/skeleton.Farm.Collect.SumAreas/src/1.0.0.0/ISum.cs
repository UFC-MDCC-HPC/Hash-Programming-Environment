using hpe.kinds;
using jefferson.data.Double;
using skeleton.Farm.Collect;
using MPI;

namespace skeleton.Farm.Collect.SumAreas { 

public interface ISum<Dt> : BaseISum<Dt>, ICollect<Dt>
where Dt:IDouble
{

} // end main interface 

} // end namespace 
