using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.Verify { 

public interface IVerify<I, C> : BaseIVerify<I, C>
where I:IInstance<C>
where C:IClass
{
   void setParameters(int nt, double[] sums);

} // end main interface 

} // end namespace 
