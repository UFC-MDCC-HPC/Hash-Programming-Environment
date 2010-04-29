using hpe.kinds;
using data.Function;
using jefferson.data.Data;
using NINTLIB;

namespace data.IntegralCase { 

public interface IIntegralCase<F> : BaseIIntegralCase<F>, IData
where F:IFunction
{

	double[] a {get;}
	double[] b {get;}
	double f (double[] x); 
	NINTLIB.IntegratingFunction Function { get; }
	int dim_num {get; set;}
	
} // end main interface 

} // end namespace 
