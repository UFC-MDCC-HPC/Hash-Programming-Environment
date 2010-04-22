using hpe.kinds;
using scientific.linearsolver.facet.Setup;
using scientific.linearsolver.facet.Solver;
using scientific.linearsolver.facet.Matrix;
using scientific.linearsolver.Library;

namespace scientific.linearsolver.Solver { 

public interface ISolve<M, E, S, L> : IComputationKind 
where M:IFacetMatrix
where E:IFacetSetup
where S:IFacetSolver
where L:ILSSLibrary<M, E, S>
{

	S Facet_solver {set;}


} // end main interface 

} // end namespace 
