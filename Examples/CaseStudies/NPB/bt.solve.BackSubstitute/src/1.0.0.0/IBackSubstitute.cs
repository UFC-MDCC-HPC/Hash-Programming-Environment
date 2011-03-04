using br.ufc.pargo.hpe.kinds;
using bt.solve.Method;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;

namespace bt.solve.BackSubstitute { 

public interface IBackSubstitute<MTH, I, C, DIR> : BaseIBackSubstitute<MTH, I, C, DIR>
where MTH:IMethod
where I:IInstance<C>
where C:IClass
where DIR:IAxis
{


} // end main interface 

} // end namespace 
