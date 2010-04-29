using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work.ApproximateIntegral;

namespace skeleton.impl.Farm.Work.ApproximateIntegral { 

public class IApproximateIntegralImpl<F, I, O> : BaseIApproximateIntegralImpl<F, I, O>, IApproximateIntetral<F, I, O>
where F:IFunction
where I:IList<IIntegralCase<F>>
where O:IDouble
{

public IApproximateIntegralImpl() { 

} 

public override void compute() { 
	;

} // end activate method 

}

}
