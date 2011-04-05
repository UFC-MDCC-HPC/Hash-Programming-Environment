using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Exchange4 { 
	public interface IExchange4<I, C> : BaseIExchange4<I, C>
	where I:IInstance<C>
	where C:IClass {
	   void setParameters(double[,] g, double[,] h, int ibeg, int ifin1, int jbeg, int jfin1);
	}
}
