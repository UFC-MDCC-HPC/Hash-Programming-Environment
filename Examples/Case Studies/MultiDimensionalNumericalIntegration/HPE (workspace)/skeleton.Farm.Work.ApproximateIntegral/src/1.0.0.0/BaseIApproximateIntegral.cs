/* AUTOMATICALLY GENERATE CODE */

using hpe.kinds;
using data.Function;
using jefferson.data.Double;
using data.IntegralCase;
using skeleton.Farm.Work;

namespace skeleton.Farm.Work.ApproximateIntegral { 

public interface BaseIApproximateIntegral<F, I, O> : BaseIWork<I, O>, IComputationKind 
where F:IFunction
where I:IIntegralCase<F>
where O:IDouble
{

} // end main interface 

} // end namespace 
