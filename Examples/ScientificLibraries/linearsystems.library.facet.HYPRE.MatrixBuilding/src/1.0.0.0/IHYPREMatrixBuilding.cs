using hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.MatrixBuilding;

namespace linearsystems.library.facet.HYPRE.MatrixBuilding { 

public interface IHYPREMatrixBuilding<L> : BaseIHYPREMatrixBuilding<L>, IMatrixBuildingFacet<L>
where L:IHYPRE
{


} // end main interface 

} // end namespace 
