using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using bt.solve.Method;
using common.orientation.Axis;

namespace bt.solve.PackUnpack { 

public interface IPackUnpack<I, C, MTH, DIR> : BaseIPackUnpack<I, C, MTH, DIR>
where I:IInstance<C>
where C:IClass
where MTH:IMethod
where DIR:IAxis
{


} // end main interface 

} // end namespace 
