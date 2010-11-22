using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.facet.HYPRESetup;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using linearsystems.library.HYPRE.facet.HYPREPreConditioner;
using linearsystems.library.HYPRE.facet.HYPRESolver;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.HYPRE.domain.impl.LSSDomainHYPRE { 

public class LSSDomainHYPRE<V, S, M, P, R> : BaseLSSDomainHYPRE<V, S, M, P, R>, ILSSDomain<V, S, M, P, R>
where V:IHYPREVector
where S:IHYPRESetup
where M:IHYPREMatrix
where P:IHYPREPreConditioner
where R:IHYPRESolver
{

public LSSDomainHYPRE() { 

} 


}

}
