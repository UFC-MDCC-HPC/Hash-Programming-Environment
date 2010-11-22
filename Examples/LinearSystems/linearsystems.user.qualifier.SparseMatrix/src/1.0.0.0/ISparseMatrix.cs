using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;

namespace linearsystems.user.qualifier.SparseMatrix { 

public interface ISparseMatrix<LIB> : BaseISparseMatrix<LIB>, IMatrixProperty<LIB>
where LIB:ILibrary
{


} // end main interface 

} // end namespace 
