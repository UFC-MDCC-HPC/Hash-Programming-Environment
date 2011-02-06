using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.Verify { 

public interface IVerify<I,C> : BaseIVerify<I,C>
where I:IInstance<C>
where C:IClass
{
		
	int Verified { get; }

} // end main interface 

} // end namespace 
