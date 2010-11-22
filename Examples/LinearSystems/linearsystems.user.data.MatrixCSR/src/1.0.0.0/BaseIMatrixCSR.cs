/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.Matrix;

namespace linearsystems.user.data.MatrixCSR { 

public interface BaseIMatrixCSR<LIB, MPT, NUM> : BaseIMatrix<LIB, MPT, NUM>, IDataStructureKind 
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
{



} // end main interface 

} // end namespace 
