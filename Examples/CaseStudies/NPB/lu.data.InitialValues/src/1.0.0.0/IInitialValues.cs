using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.data.InitialValues { 

public interface IInitialValues<I, C> : BaseIInitialValues<I, C>
where I:IInstance<C>
where C:IClass
{


} // end main interface 

} // end namespace 
