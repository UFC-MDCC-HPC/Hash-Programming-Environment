using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;

namespace ft.fft.TransposeLocal { 
	public interface ITransposeLocal<I, C, DIR> : BaseITransposeLocal<I, C, DIR>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis{
	   void setParameters(int d1, int d2, int d3, double[, , ,] xin, double[, , ,] xout);
	}
}
