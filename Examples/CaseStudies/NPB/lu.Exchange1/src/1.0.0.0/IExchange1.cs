using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.Exchange1 { 
	public interface IExchange1<I, C> : BaseIExchange1<I, C>
	where I:IInstance<C>
	where C:IClass {
	   void setParameters(double[,,,] g, int iex);
	   void setParameters(double[,,,] g, int iex, int k);	   
	}
}
