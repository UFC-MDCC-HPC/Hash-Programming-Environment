using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.library.basic.facet.LSSFacetVector;
using linearsystems.library.basic.facet.LSSFacetSetup;
using linearsystems.library.basic.facet.LSSFacetMatrix;
using linearsystems.library.basic.facet.LSSFacetPreConditioner;
using linearsystems.library.basic.facet.LSSFacetSolver;

namespace linearsystems.library.basic.domain.LSSDomain { 

public interface ILSSDomain<L>/*<L, V, S, M, P, R>*/ : BaseILSSDomain<L>
where L:ILibrary
//where V:IFacetVector<L>
//where S:IFacetSetup<L>
//where M:IFacetMatrix<L>
//where P:IFacetPreConditioner<L>
//where R:IFacetSolver<L>
{


} // end main interface 

} // end namespace 
