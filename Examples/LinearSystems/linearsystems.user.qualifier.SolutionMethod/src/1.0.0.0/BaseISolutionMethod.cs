/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;

namespace linearsystems.user.qualifier.SolutionMethod { 

public interface BaseISolutionMethod<PRC, MPT, LIB> : IQualifierKind 
where PRC:IPreConditioner<LIB, MPT>
where MPT:IMatrixProperty<LIB>
where LIB:ILibrary
{



} // end main interface 

} // end namespace 
