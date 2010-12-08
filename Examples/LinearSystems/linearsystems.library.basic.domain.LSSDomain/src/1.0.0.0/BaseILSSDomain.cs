/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetVector;
using linearsystems.library.basic.Library;
using linearsystems.library.basic.facet.LSSFacetPreConditioner;
using linearsystems.library.basic.facet.LSSFacetSetup;
using linearsystems.library.basic.facet.LSSFacetSolver;
using environment.messagepassing.Communicator;
using linearsystems.library.basic.facet.LSSFacetMatrix;

namespace linearsystems.library.basic.domain.LSSDomain { 

public interface BaseILSSDomain<L, COM> : IDomainKind, BaseIFacetVector<L>,
                                                                      BaseIFacetSetup<L>,
																	  BaseIFacetMatrix<L>,
																	  BaseIFacetPreConditioner<L>,
																	  BaseIFacetSolver<L>
where L:ILibrary
/* where V:IFacetVector<L>
where S:IFacetSetup<L>
where M:IFacetMatrix<L>
where P:IFacetPreConditioner<L>
where R:IFacetSolver<L> */
where COM:ICommunicator 
{

	COM Comm {set;}

} // end main interface 

} // end namespace 
