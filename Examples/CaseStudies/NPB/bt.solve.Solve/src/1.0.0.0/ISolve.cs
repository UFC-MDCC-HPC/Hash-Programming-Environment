using br.ufc.pargo.hpe.kinds;
using common.orientation.Axis;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;

namespace bt.solve.Solve { 

public interface ISolve<DIR, I, C, MTH> : BaseISolve<DIR, I, C, MTH>
where DIR:IAxis
where I:IInstance<C>
where C:IClass
where MTH:IMethod
{


} // end main interface 

} // end namespace 
