using br.ufc.hpe.kinds;
using linearsystems.qualifier.PETSc;
using linearsystems.library.facet.VectorBuilding;

namespace linearsystems.library.facet.PETSc.VectorBuilding {
   
 

public interface IPETScVectorBuilding<L> : BaseIPETScVectorBuilding<L>, IVectorBuildingFacet<L>
where L:IPETSc
{


} // end main interface 

} // end namespace 
