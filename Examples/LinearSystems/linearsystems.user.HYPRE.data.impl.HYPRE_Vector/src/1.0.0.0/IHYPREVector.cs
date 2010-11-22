using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.Vector;

namespace linearsystems.user.HYPRE.data.impl.HYPRE_Vector { 

public class IHYPREVector<LIB, NUM> : BaseIHYPREVector<LIB, NUM>, IVector<LIB, NUM>
where LIB:IHYPRE
where NUM:IDoublePrecisionFPNumber
{

public IHYPREVector() { 

} 


}

}
