/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.user.data.Vector;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.user.data.Matrix;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.SolutionMethod;

namespace linearsystems.user.computation.Solver { 

public interface BaseISolver<MAT, VEC, PRC, MPT, MTH, NUM, LIB> : IComputationKind 
where MAT:IMatrix<LIB, MPT, NUM>
where VEC:IVector<LIB, NUM>
where PRC:IPreConditioner<LIB, MPT>
where MPT:IMatrixProperty<LIB>
where MTH:ISolutionMethod<PRC, MPT, LIB>
where NUM:IElementDataType
where LIB:ILibrary
{

	VEC V {set;}
	VEC X {set;}
	MAT A {set;}


} // end main interface 

} // end namespace 
