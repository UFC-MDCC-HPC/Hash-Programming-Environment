using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.data.BoundaryValues { 

public interface IBoundaryValues<I, C> : BaseIBoundaryValues<I, C>
where I:IInstance<C>
where C:IClass
{


} // end main interface 

} // end namespace 
