using hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.Solving;

namespace linearsystems.library.facet.HYPRE.Solving { 

public interface IHYPRESolving<L> : BaseIHYPRESolving<L>, ISolvingFacet<L>
where L:IHYPRE
{


} // end main interface 

} // end namespace 
