using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.fft.Fft { 

public interface IFft<I, C> : BaseIFft<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(int dir, double[, , ,] u1, double[, , ,] u02);

} // end main interface 

} // end namespace 
