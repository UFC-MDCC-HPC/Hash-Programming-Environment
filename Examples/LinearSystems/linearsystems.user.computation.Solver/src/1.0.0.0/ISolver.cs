using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.user.data.Matrix;
using linearsystems.user.data.Vector;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.SolutionMethod;
using linearsystems.library.basic.facet.LSSFacetVector;
using linearsystems.library.basic.facet.LSSFacetSetup;
using linearsystems.library.basic.facet.LSSFacetMatrix;
using linearsystems.library.basic.facet.LSSFacetPreConditioner;
using linearsystems.library.basic.facet.LSSFacetSolver;
using environment.messagepassing.Communicator;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.user.computation.Solver { 

public interface ISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM, DOM> : BaseISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM, DOM>
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
		void initialize();

} // end main interface 

} // end namespace 
