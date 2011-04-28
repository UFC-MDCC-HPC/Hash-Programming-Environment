using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.fft.Cfftz { 

public interface ICfftz<I, C> : BaseICfftz<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(int dir, int m, int n, double[, , ,] y);

} // end main interface 

} // end namespace 
