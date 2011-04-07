using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Error { 
	public interface IError<I, C> : BaseIError<I, C>
	where I:IInstance<C>
	where C:IClass {
	   double[] Errnm { get; }
	}
	
}
