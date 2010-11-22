using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.ElementDataType;

namespace linearsystems.user.data.Matrix { 

public interface IMatrix<LIB, MPT, NUM> : BaseIMatrix<LIB, MPT, NUM>
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where NUM:IElementDataType
{


} // end main interface 

} // end namespace 
