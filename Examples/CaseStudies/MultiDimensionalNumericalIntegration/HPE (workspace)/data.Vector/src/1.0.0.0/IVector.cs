using hpe.kinds;
using jefferson.data.Data;

namespace data.Vector { 

public interface IVector<T> : BaseIVector<T>, IData
where T:IData
{
   int Size{ set; get; }

} // end main interface 

} // end namespace 
