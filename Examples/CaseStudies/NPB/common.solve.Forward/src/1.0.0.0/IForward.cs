using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;
using common.orientation.Axis;

namespace common.solve.Forward { 

public interface IForward<I, C, MTH, DIR> : BaseIForward<I, C, MTH, DIR>
where I:IInstance<C>
where C:IClass
where MTH:IMethod
where DIR:IAxis
{
	void enterStage(int stage);

} // end main interface 

} // end namespace 
