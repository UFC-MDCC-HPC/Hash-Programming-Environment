using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.data.ComputeIndexMap { 

public interface IComputeIndexMap<I, C> : BaseIComputeIndexMap<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(double[] twiddle, int d1, int d2, int d3);

} // end main interface 

} // end namespace 
