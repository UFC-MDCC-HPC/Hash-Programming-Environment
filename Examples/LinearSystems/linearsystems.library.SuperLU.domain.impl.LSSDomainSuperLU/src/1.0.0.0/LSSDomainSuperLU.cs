using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.SuperLU.facet.SuperLUVector;
using linearsystems.library.SuperLU.facet.SuperLUSetup;
using linearsystems.library.SuperLU.facet.SuperLUMatrix;
using linearsystems.library.SuperLU.facet.SuperLUPreConditioner;
using linearsystems.library.SuperLU.facet.SuperLUSolver;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.SuperLU.domain.impl.LSSDomainSuperLU { 

public class LSSDomainSuperLU<V, S, M, P, R> : BaseLSSDomainSuperLU<V, S, M, P, R>, ILSSDomain<V, S, M, P, R>
where V:ISuperLUVector
where S:ISuperLUSetup
where M:ISuperLUMatrix
where P:ISuperLUPreConditioner
where R:ISuperLUSolver
{

public LSSDomainSuperLU() { 

} 


}

}
