using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;

namespace linearsystems.user.qualifier.PreConditioner { 

public interface IPreConditioner<LIB, MPT> : BaseIPreConditioner<LIB, MPT>
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
{


} // end main interface 

} // end namespace 
