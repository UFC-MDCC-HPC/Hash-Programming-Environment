using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.fft.Swarztrauber { 
	public interface ISwarztrauber<I, C> : BaseISwarztrauber<I, C>
	where I:IInstance<C>
	where C:IClass{
	   void setParameters(int dir, int m, int n, double[, , ,] y);
	}
}
