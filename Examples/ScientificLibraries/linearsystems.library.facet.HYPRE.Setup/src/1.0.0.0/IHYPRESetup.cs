using hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.Setup;

namespace linearsystems.library.facet.HYPRE.Setup { 

public interface IHYPRESetup<L> : BaseIHYPRESetup<L>, ISetup<L>
where L:IHYPRE
{


} // end main interface 

} // end namespace 
