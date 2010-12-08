/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.MatrixProperty;
using linearsystems.user.qualifier.ElementDataType;
using environment.messagepassing.Communicator;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.user.data.Matrix { 

public interface BaseIMatrix<LIB, MPT, NUM, COM, DOM> : IDataStructureKind 
where LIB:ILibrary
where MPT:IMatrixProperty<LIB>
where NUM:IElementDataType
where COM:ICommunicator
where DOM:ILSSDomain<LIB, COM>

{



} // end main interface 

} // end namespace 
