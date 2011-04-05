using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Exchange { 
	public interface IExchange<I, C> : BaseIExchange<I, C>
	where I:IInstance<C>
	where C:IClass {
	   void setParameters(double[,] g, int beg, int fin1, int _from);
	}
}
