using br.ufc.pargo.hpe.kinds;

using common.problem_size.Class;

namespace common.problem_size.Instance { 

public interface IInstance<C> : BaseIInstance<C>
	where C:IClass
{
	int problem_size { get; }
	int niter_default { get; }
	double dt_default { get; }
	char CLASS { get; }


} // end main interface 

} // end namespace 
