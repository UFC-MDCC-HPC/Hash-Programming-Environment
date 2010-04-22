using hpe.kinds;
using jefferson.data.Double;
using data.Vector;

namespace data.Vector.VectorOfDouble { 

public interface IVectorOfDouble<T> : BaseIVectorOfDouble<T>, IVector<T>
where T:IDouble
{

} // end main interface 

} // end namespace 
