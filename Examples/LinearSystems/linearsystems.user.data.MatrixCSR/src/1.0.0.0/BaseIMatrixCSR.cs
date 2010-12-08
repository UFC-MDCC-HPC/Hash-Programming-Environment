/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.user.data.Matrix;
using linearsystems.library.basic.Library;
using linearsystems.library.basic.domain.LSSDomain;
using environment.messagepassing.Communicator;
	
namespace linearsystems.user.data.MatrixCSR { 

public interface BaseIMatrixCSR<LIB, MPT, NUM, COM, DOM> : BaseIMatrix<LIB, MPT, NUM, COM, DOM>, IDataStructureKind 
where LIB:ILibrary
where MPT:ISparseMatrix<LIB>
where NUM:IElementDataType
where COM:ICommunicator
where DOM:ILSSDomain<LIB, COM>

{



} // end main interface 

} // end namespace 
