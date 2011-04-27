using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.fft.Fftz2 { 

public interface IFftz2<I, C> : BaseIFftz2<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(int dir, int l, int m, int n, int ny, int ny1, double[,] u, double[, , ,] y, int iread, int iwrite);
} // end main interface 

} // end namespace 
