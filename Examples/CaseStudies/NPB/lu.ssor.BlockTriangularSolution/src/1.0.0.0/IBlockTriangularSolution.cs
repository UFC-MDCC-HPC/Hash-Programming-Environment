using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;
using common.Discretization;

namespace lu.ssor.BlockTriangularSolution { 
	public interface IBlockTriangularSolution<DIS, I, C> : BaseIBlockTriangularSolution<DIS, I, C>
	where I:IInstance<C>
	where C:IClass
	where DIS:IDiscretization{
	   void setParameters(int k, double omega /*, double[,,,] dx, double[,,,] dy, double[,,,] dz*/);
	}
}
