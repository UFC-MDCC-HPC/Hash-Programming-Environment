using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;
using common.solve.Method;

namespace bt.solve.SolveCell { 
	public interface ISolveCell<I, C, DIR, MTH> : BaseISolveCell<I, C, DIR, MTH>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis
	where MTH:IMethod {
	   void setParameters(double[,,,,,] lhsc, int first, int last, int c);
	}
}
