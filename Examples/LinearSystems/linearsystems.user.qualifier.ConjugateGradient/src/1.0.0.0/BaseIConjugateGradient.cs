/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.SolutionMethod;

namespace linearsystems.user.qualifier.ConjugateGradient { 

public interface BaseIConjugateGradient<LIB, MPT, PRC> : BaseISolutionMethod<LIB, MPT, PRC>, IQualifierKind 
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where PRC:IPreConditioner<LIB, MPT>
{



} // end main interface 

} // end namespace 
