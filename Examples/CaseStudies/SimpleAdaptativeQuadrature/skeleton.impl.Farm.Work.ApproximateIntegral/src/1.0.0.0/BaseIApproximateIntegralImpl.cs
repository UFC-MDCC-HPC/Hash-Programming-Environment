/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using jefferson.data.Double;
using data.IntegralCase;
using skeleton.Farm.Work.ApproximateIntegral;

namespace skeleton.impl.Farm.Work.ApproximateIntegral { 

public abstract class BaseIApproximateIntegralImpl<F, I, O>: Computation, BaseIApproximateIntegral<F, I, O>
where F:IFunction
where I:IIntegralCase<F>
where O:IDouble
{

protected O output_data = default(O);

public O Output_data {
	set {
		this.output_data = value;
	}
}

protected I input_data = default(I);

public I Input_data {
	set {
		this.input_data = value;
	}
}


public BaseIApproximateIntegralImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000001000100d944628f8c3c3ffb35f1a41e67dae983c74dea4a08aa438c286f754c956c8ae4b66a47cd5e4610e5584b37fec69aecbed9fbf7231fe748822f9f96cdebd74272c8b7f58d8d9e536d2f60544cec606a19de3c1a43c2aded6d4d43c6a8bbd83143a342fda08afae5b20d17957e82790260dad70241f9c775d95fe3f6841283d292";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
