using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;
using common.Discretization;

namespace lu.BlockTriangularSolution { 
	public interface IBlockTriangularSolution<I, C, DIS> : BaseIBlockTriangularSolution<I, C, DIS>
	where I:IInstance<C>
	where C:IClass
	where DIS:IDiscretization{
	   void setParameters(int k, double omega, double[,,,] dx, double[,,,] dy, double[,,,] dz);
	}
}
