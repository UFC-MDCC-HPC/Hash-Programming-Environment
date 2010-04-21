using hpe.kinds;
using data.Function;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work;

namespace skeleton.Farm.Work.ApproximateIntegral { 

public interface IApproximateIntegral<F, I, O> : BaseIApproximateIntegral<F, I, O>, IWork<I, O>
where F:IFunction
where I:IIntegralCase<F>
where O:IDouble
{


} // end main interface 

} // end namespace 
