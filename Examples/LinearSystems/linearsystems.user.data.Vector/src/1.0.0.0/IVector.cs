using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.library.basic.domain.LSSDomain;
using environment.messagepassing.Communicator;

namespace linearsystems.user.data.Vector { 

public interface IVector<LIB, NUM, COM, DOM> : BaseIVector<LIB, NUM, COM, DOM>
where LIB:ILibrary
where NUM:IElementDataType
where COM:ICommunicator
where DOM:ILSSDomain<LIB, COM>
{
	void initialize();
	void setIndexes(int ilower, int iupper);
	void setValues(int size, object[] values);
	void setValues(int size, int[] rows, object[] values);
	void assemble();
	object Primitive { get;}

} // end main interface 

} // end namespace 
