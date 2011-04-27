using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.data.FftInit { 
	public interface IFftInit<I, C> : BaseIFftInit<I, C>
	where I:IInstance<C>
	where C:IClass{
	   void setParameters(int n);
	}
}
