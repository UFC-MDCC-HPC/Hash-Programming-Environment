using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.ElementDataType;

namespace linearsystems.user.data.Vector { 

public interface IVector<LIB, NUM> : BaseIVector<LIB, NUM>
where LIB:ILibrary
where NUM:IElementDataType
{


} // end main interface 

} // end namespace 
