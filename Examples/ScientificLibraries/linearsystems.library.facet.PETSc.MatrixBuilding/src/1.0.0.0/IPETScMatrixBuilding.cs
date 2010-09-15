using hpe.kinds;
using linearsystems.qualifier.PETSc;
using linearsystems.library.facet.MatrixBuilding;

namespace linearsystems.library.facet.PETSc.MatrixBuilding { 

public interface IPETScMatrixBuilding<L> : BaseIPETScMatrixBuilding<L>, IMatrixBuildingFacet<L>
where L:IPETSc
{


} // end main interface 

} // end namespace 
