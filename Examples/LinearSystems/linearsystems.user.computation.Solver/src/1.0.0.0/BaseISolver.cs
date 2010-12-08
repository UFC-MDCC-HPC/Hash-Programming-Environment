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

public interface BaseISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM, DOM> : IComputationKind 
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where NUM:IElementDataType
where MAT:IMatrix<LIB, MPT, NUM, COM, DOM>
where VEC:IVector<LIB, NUM, COM, DOM>
where PRC:IPreConditioner<LIB, MPT>
where MTH:ISolutionMethod<PRC, MPT, LIB>
where COM:ICommunicator
where DOM:ILSSDomain<LIB, COM>
{

	MAT Matrix {set;}
	VEC Rhs {set;}
	VEC Solution {set;}
		
	COM Comm {set;}


} // end main interface 

} // end namespace 
