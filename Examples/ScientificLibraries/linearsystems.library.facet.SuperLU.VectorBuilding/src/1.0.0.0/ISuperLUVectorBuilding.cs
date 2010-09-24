using br.ufc.hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.VectorBuilding;

namespace linearsystems.library.facet.SuperLU.VectorBuilding { 

public interface ISuperLUVectorBuilding<L> : BaseISuperLUVectorBuilding<L>, IVectorBuildingFacet<L>
where L:ISuperLU
{
   //there is no method

} // end main interface 

} // end namespace 
