using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;

namespace bt.solve.Solve { 

public interface ISolve<I, C, DIR, MTH> : BaseISolve<I, C, DIR, MTH>
where I:IInstance<C>
where C:IClass
where DIR:IAxis
where MTH:IMethod
{


} // end main interface 

} // end namespace 
