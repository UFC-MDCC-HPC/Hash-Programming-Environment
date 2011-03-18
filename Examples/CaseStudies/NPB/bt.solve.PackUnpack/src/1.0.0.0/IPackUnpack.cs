using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.solve.Method;
using common.orientation.Axis;

namespace bt.solve.PackUnpack { 
	public interface IPackUnpack<I, C, DIR, MTH> : BaseIPackUnpack<I, C, DIR, MTH>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod {
	   void setParameters(double[] buffer, int c);
	   void infoLhsc(double[,,,,,] lhsc);
	   void infoBackSub(double[,,,] backsub_info);
	} // end main interface 
} // end namespace 
