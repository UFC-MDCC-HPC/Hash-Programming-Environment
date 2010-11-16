/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work;

namespace skeleton.Farm.Work.ApproximateIntegral { 

public interface BaseIApproximateIntetral<F, I, O> : BaseIWork<I, O>, IComputationKind 
where F:IFunction
where I:IList<IIntegralCase<F>>
where O:IDouble
{



} // end main interface 

} // end namespace 
