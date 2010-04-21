using hpe.kinds;
using data.Function;
using jefferson.data.Data;

namespace data.IntegralCase { 

public interface IIntegralCase<F> : BaseIIntegralCase<F>, IData
where F:IFunction
{

	double a {set;get;}
	double b {set;get;}
	double f (double x); 
	
} // end main interface 

} // end namespace 
