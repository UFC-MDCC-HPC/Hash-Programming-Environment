using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetSetup;
using linearsystems.library.HYPRE;

namespace linearsystems.library.HYPRE.facet.HYPRESetup { 

public interface IFacetHYPRESetup<L> : BaseIFacetHYPRESetup<L>, IFacetSetup<L>
where L:IHYPRE
{

} // end main interface 

} // end namespace 
