using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;

namespace bt.solve.PackSolveInfo { 
	public interface IPackSolveInfo<I, C, DIR, MTH> : BaseIPackSolveInfo<I, C, DIR, MTH>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod {
		   void setParameters(double[,,,,,] lhsc, double[] buffer, int c);
	} // end main interface 
} // end namespace 
