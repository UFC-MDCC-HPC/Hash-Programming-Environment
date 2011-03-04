using br.ufc.pargo.hpe.kinds;
using common.orientation.Axis;
using bt.solve.Method;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace bt.solve.Solve { 

public interface ISolve<DIR, MTH, I, C> : BaseISolve<DIR, MTH, I, C>
where DIR:IAxis
where MTH:IMethod
where I:IInstance<C>
where C:IClass
{


} // end main interface 

} // end namespace 
