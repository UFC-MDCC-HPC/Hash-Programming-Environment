using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function.TestingFunction;

namespace skeleton.impl.example.QuadratureAdaptative { 

public class IRootImpl<F> : BaseIRootImpl<F>
where F:ITestingFunction
{

public IRootImpl() { 

} 

public override void compute() { 
		
	input_data.a = 0.0; 
	input_data.b = 1.0;
	
	Console.WriteLine("MANAGER - STARTING ADAPTATIVE QUADRATURE");
	
	manager.compute();
	
	Console.WriteLine("RESULT = " + output_data.Value);
	
	Console.WriteLine("WORKER - FINISH ADAPTATIVE QUADRATURE");

} // end activate method 

}

}
