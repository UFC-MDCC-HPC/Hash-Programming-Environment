using hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.PreConditioning;

namespace linearsystems.library.facet.HYPRE.PreConditioning { 

public interface IHYPREPreConditioning<L> : BaseIHYPREPreConditioning<L>, IPreConditioningFacet<L>
where L:IHYPRE
{


} // end main interface 

} // end namespace 
