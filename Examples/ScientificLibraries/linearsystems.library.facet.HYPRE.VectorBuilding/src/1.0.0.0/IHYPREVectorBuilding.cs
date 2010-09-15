using hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.VectorBuilding;

namespace linearsystems.library.facet.HYPRE.VectorBuilding { 

public interface IHYPREVectorBuilding<L> : BaseIHYPREVectorBuilding<L>, IVectorBuildingFacet<L>
where L:IHYPRE
{


} // end main interface 

} // end namespace 
