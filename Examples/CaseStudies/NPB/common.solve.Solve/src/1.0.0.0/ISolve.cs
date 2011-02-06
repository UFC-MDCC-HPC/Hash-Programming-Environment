using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;
using common.orientation.Axis;

namespace common.solve.Solve { 

public interface ISolve<I, C, MTH, DIR> : BaseISolve<I, C, MTH, DIR>
where I:IInstance<C>
where C:IClass
where MTH:IMethod
where DIR:IAxis
{


} // end main interface 

} // end namespace 
