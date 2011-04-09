using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;
using common.Discretization;

namespace lu.ssor.TriangularPartJacobianMatrix { 
	public interface ITriangularPartJacobianMatrix<I, C, DIS> : BaseITriangularPartJacobianMatrix<I, C, DIS>
	where I:IInstance<C>
	where C:IClass
	where DIS:IDiscretization{
	   void setParameters(int k);
	}
}
