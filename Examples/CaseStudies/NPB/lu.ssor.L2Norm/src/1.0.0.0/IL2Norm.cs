using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.ssor.L2Norm { 

public interface IL2Norm<I, C> : BaseIL2Norm<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(double[] sum);

} // end main interface 

} // end namespace 
