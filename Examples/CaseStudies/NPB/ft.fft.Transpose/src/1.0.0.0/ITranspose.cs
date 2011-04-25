using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;

namespace ft.fft.Transpose { 
	public interface ITranspose<I, C, DIR> : BaseITranspose<I, C, DIR>
	where I:IInstance<C>
	where C:IClass
	where DIR:IAxis{
	   void setParameters(int l1, int l2, double[, , ,] xin, double[, , ,] xout);
	}
}
