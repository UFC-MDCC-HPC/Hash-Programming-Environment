using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;

namespace ft.fft.Cffts { 

public interface ICffts<I, C, DIR> : BaseICffts<I, C, DIR>
where I:IInstance<C>
where C:IClass
where DIR:IAxis
{
   void setParameters(int dir, int d1, int d2, int d3, double[, , ,] x, double[, , ,] xout);

} // end main interface 

} // end namespace 
