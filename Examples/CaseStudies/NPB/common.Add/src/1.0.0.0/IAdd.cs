using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace common.Add { 

public interface IAdd<I,C> : BaseIAdd<I,C>
		where I:IInstance<C>
		where C:IClass
{

    void initialize(); 

} // end main interface 

} // end namespace 
