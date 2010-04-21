using hpe.kinds;
using data.Function;
using jefferson.data.Data;

namespace data.IntegralCase { 

public interface IIntegralCase<F> : BaseIIntegralCase<F>, IData
where F:IFunction
{

	double[] a {get;}
	double[] b {get;}
	double f (double[] x); 
	
	int dim_num {get; set;}
	
} // end main interface 

} // end namespace 
