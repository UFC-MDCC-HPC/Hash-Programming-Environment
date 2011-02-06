using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;

namespace common.solve.LHS { 

public interface ILHS<I,C,DIR,MTH> : BaseILHS<I,C,DIR,MTH>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod
{
	void initialize();
	void enterStage(int stage);

} // end main interface 

} // end namespace 
