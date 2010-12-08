using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetPreConditioner;
using linearsystems.library.HYPRE;

namespace linearsystems.library.HYPRE.facet.HYPREPreConditioner { 

public interface IFacetHYPREPreConditioner<L> : BaseIFacetHYPREPreConditioner<L>, IFacetPreConditioner<L>
where L:IHYPRE
{


} // end main interface 

} // end namespace 
