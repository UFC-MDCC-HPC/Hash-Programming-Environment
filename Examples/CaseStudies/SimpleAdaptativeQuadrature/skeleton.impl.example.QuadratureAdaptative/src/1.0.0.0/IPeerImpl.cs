using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function.TestingFunction;

namespace skeleton.impl.example.QuadratureAdaptative { 

public class IPeerImpl<F> : BaseIPeerImpl<F>
where F:ITestingFunction
{

public IPeerImpl() { 

} 

public override void compute() { 
	worker.compute();

} // end activate method 

}

}
