using hpe.kinds;
using scientific.linearsolver.facet.Matrix;
using scientific.linearsolver.facet.Setup;
using scientific.linearsolver.facet.Solver;
using scientific.Library;

namespace scientific.linearsolver.Library { 

public interface ILSSLibrary<M, E, S> : ILibrary<M, E, S>, IQualifierKind 
where M:IFacetMatrix
where E:IFacetSetup
where S:IFacetSolver
{



} // end main interface 

} // end namespace 
