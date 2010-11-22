using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.MatrixCSR;

namespace linearsystems.user.HYPRE.data.impl.HYPRE_Matrix { 

public class IHYPREMatrix<LIB, MPT, NUM> : BaseIHYPREMatrix<LIB, MPT, NUM>, IMatrixCSR<LIB, MPT, NUM>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
{

public IHYPREMatrix() { 

} 


}

}
