using br.ufc.pargo.hpe.kinds;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;

namespace linearsystems.user.qualifier.SolutionMethod { 

public interface ISolutionMethod<PRC, MPT, LIB> : BaseISolutionMethod<PRC, MPT, LIB>
where PRC:IPreConditioner<LIB, IMatrixProperty<LIB>>
where MPT:IMatrixProperty<LIB>
where LIB:ILibrary
{


} // end main interface 

} // end namespace 
