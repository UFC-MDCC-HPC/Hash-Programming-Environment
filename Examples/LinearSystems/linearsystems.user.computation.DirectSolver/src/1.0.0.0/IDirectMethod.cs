using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.SolutionMethod;

namespace linearsystems.user.qualifier.DirectMethod { 

public interface IDirectMethod<LIB, MPT, PRC> : BaseIDirectMethod<LIB, MPT, PRC>, ISolutionMethod<PRC, MPT, LIB>
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where PRC:IPreConditioner<LIB, MPT>
{


} // end main interface 

} // end namespace 
