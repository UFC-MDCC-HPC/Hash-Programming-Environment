using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;

namespace bt.solve.UnpackBackSubInfo { 
	public interface IUnpackBackSubInfo<I, C, DIR, MTH> : BaseIUnpackBackSubInfo<I, C, DIR, MTH>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod {
		   void setParameters(double[,,,] backsub_info, double[] buffer, int c);
	} // end main interface 
} // end namespace 
