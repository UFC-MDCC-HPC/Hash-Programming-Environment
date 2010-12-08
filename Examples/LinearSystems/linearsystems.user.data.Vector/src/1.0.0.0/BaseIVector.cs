/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.library.basic.domain.LSSDomain;
using environment.messagepassing.Communicator;

namespace linearsystems.user.data.Vector { 

public interface BaseIVector<LIB, NUM, COM, DOM> : IDataStructureKind 
where LIB:ILibrary
where NUM:IElementDataType
where COM:ICommunicator
where DOM:ILSSDomain<LIB, COM>

{



} // end main interface 

} // end namespace 
