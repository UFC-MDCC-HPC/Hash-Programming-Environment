using hpe.kinds;
using jefferson.data.Number;

namespace jefferson.data.Double { 

public interface IDouble : BaseIDouble, INumber
{
	double Value{
			set;
		    get;
		}

    // Optimized operations ...
    void plus(IDouble b);
    void times(IDouble b);
    void minus(IDouble b);


} // end main interface 

} // end namespace 
