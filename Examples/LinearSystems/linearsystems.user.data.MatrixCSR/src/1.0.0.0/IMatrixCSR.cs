using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.Matrix;

namespace linearsystems.user.data.MatrixCSR { 

public interface IMatrixCSR<LIB, MPT, NUM> : BaseIMatrixCSR<LIB, MPT, NUM>, IMatrix<LIB, MPT, NUM>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
{


} // end main interface 

} // end namespace 
