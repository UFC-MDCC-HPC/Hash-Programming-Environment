using hpe.kinds;
using linearsystems.qualifier.PETSc;
using linearsystems.library.facet.Setup;

namespace linearsystems.library.facet.PETSc.Setup { 

public interface IPETScSetup<L> : BaseIPETScSetup<L>, ISetup<L>
where L:IPETSc
{


} // end main interface 

} // end namespace 
