using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function.TestingFunction;
using skeleton.example.QuadratureAdaptative;

namespace skeleton.impl.example.QuadratureAdaptative { 

public class IRootImpl<F> : BaseIRootImpl<F>, IRoot<F>
where F:ITestingFunction
{

public IRootImpl() { 

} 

public override void compute() { 
	manager.compute();

} // end activate method 

}

}
