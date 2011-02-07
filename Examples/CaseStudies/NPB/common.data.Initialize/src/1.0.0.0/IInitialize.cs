using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.data.Initialize { 

public interface IInitialize<I, C> : BaseIInitialize<I, C>
where I:IInstance<C>
where C:IClass
{

} // end main interface 

} // end namespace 
