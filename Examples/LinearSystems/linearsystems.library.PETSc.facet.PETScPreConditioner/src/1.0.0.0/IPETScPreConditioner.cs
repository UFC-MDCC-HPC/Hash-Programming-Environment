using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetPreConditioner;
using linearsystems.library.PETSc;

namespace linearsystems.library.PETSc.facet.PETScPreConditioner { 

public interface IPETScPreConditioner : BaseIPETScPreConditioner, IFacetPreConditioner<PETSc>
{


} // end main interface 

} // end namespace 
