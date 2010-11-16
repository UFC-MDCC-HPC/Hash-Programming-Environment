using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using data.Function.TestingFunction;

namespace skeleton.impl.example.QuadratureAdaptative { 

public class Instantiator {
   
   public static IApplicationKind getInstance() { return new IPeerImpl<ITestingFunction>(); }

}

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
