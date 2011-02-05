using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.data.ExactRHS { 

public interface IExactRHS<I, C> : BaseIExactRHS<I, C>
where I:IInstance<C>
where C:IClass
{

   void initialize();

} // end main interface 

} // end namespace 
