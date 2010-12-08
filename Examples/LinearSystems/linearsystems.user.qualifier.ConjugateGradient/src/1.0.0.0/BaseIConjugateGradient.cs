/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.IterativeMethod;

namespace linearsystems.user.qualifier.ConjugateGradient { 

public interface BaseIConjugateGradient<LIB, MPT, PRC> : BaseIIterativeMethod<LIB, MPT, PRC>, IQualifierKind 
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where PRC:IPreConditioner<LIB, MPT>
{



} // end main interface 

} // end namespace 
