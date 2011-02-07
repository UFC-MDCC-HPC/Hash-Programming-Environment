using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.error.ErrorNorm { 

public interface IErrorNorm<I, C> : BaseIErrorNorm<I, C>
where I:IInstance<C>
where C:IClass
{
		
	double[] xce { get; }

} // end main interface 

} // end namespace 
