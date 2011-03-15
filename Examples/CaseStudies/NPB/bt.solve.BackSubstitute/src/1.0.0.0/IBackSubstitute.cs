using br.ufc.pargo.hpe.kinds;
using common.solve.Method;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;

namespace bt.solve.BackSubstitute { 

public interface IBackSubstitute<I, C, DIR, MTH> : BaseIBackSubstitute<I, C, DIR, MTH>
where I:IInstance<C>
where C:IClass
where DIR:IAxis
where MTH:IMethod
{


} // end main interface 

} // end namespace 
