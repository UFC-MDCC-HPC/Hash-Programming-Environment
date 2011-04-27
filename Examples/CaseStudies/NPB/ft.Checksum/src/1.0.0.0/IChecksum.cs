using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.Checksum { 

public interface IChecksum<I, C> : BaseIChecksum<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(int iter, double[] sums, double[, , ,] u2, int d1, int d2, int d3);

} // end main interface 

} // end namespace 
