using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work;

namespace skeleton.Farm.Work.ApproximateIntegral { 

public interface IApproximateIntetral<F, I, O> : BaseIApproximateIntetral<F, I, O>, IWork<I, O>
where F:IFunction
where I:IList<IIntegralCase<F>>
where O:IDouble
{

} // end main interface 

} // end namespace 
