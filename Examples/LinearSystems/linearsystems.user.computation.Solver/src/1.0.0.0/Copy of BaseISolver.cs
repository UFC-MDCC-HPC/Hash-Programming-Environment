/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.user.data.Vector;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.library.basic.facet.LSSFacetVector;
using linearsystems.library.basic.facet.LSSFacetPreConditioner;
using linearsystems.user.data.Matrix;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.library.basic.facet.LSSFacetSetup;
using linearsystems.library.basic.facet.LSSFacetSolver;
using linearsystems.library.basic.facet.LSSFacetMatrix;
using environment.messagepassing.Communicator;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.SolutionMethod;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.user.computation.Solver { 

public interface BaseISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, V, S, M, P, R, COM, DOM> : IComputationKind 
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where NUM:IElementDataType
where MAT:IMatrix<LIB, MPT, NUM>
where VEC:IVector<LIB, NUM>
where PRC:IPreConditioner<LIB, MPT>
where MTH:ISolutionMethod<PRC, MPT, LIB>
where V:IFacetVector<LIB>
where S:IFacetSetup<LIB>
where M:IFacetMatrix<LIB>
where P:IFacetPreConditioner<LIB>
where R:IFacetSolver<LIB>
where COM:ICommunicator
where DOM:ILSSDomain<LIB, V, S, M, P, R, COM>
{

	MAT Matrix {set;}
	VEC Rhs {set;}
	VEC Solution {set;}

	M Matrix_facet {set;}
	V Vector_facet {set;}
	P Preconditioner_facet {set;}
	S Setup_facet {set;}
	R Solver_facet {set;}

	COM Comm {set;}
	LIB Library {set;}


} // end main interface 

} // end namespace 
