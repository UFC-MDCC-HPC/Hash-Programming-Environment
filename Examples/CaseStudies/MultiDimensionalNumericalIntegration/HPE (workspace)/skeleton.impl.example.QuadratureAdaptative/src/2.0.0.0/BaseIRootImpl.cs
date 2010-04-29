/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;
using skeleton.Farm;
using data.IntegralCase;
using data.Function.TestingFunction;
using skeleton.Farm.Distribute.DistributeInterval;
using skeleton.Farm.Collect.SumAreas;
using environment.MPIDirect;
using skeleton.example.QuadratureAdaptative;

namespace skeleton.impl.example.QuadratureAdaptative { 

public abstract class BaseIRootImpl<F>: Application, BaseIRoot<F>
where F:ITestingFunction
{

protected IDouble output_data = null;

protected IDouble Output_data {
	set {
		this.output_data = value;
		manager.Output_data = value;
	}
}

protected IManager<IIntegralCase<F>, IDistributeIntervalSend<F, IIntegralCase<F>>, IDouble, ISum<IDouble>> manager = null;

protected IManager<IIntegralCase<F>, IDistributeIntervalSend<F, IIntegralCase<F>>, IDouble, ISum<IDouble>> Manager {
	set {
		this.manager = value;
	}
}

protected IIntegralCase<F> input_data = null;

protected IIntegralCase<F> Input_data {
	set {
		this.input_data = value;
		manager.Input_data = value;
	}
}

protected IMPIDirect mpi = null;

protected IMPIDirect Mpi {
	set {
		this.mpi = value;
		manager.Mpi = value;
	}
}


public BaseIRootImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000006d05c82bff26ad72150a252c8c9742c86f6c62e6fe0cb696e223e19c0441a20a249526c60ee5553b2eddc609f73c569a23cfd334b51d25d1bd36d608dc901932e635a71bce017f93a1aabc8a129f65b9a7d3d384b42ae038d9d1006b984abdf11cc686520195bdac3acc399a24871f11885f37168f0ac04580fbce53d438e394";

override public void createSlices() {
	base.createSlices();
	this.Manager = (IManager<IIntegralCase<F>, IDistributeIntervalSend<F, IIntegralCase<F>>, IDouble, ISum<IDouble>>) BackEnd.createSlice(this, UID,"farm","manager",new Type[] {typeof(IIntegralCase<F>),typeof( IDistributeIntervalSend<F, IIntegralCase<F>>),typeof( IDouble),typeof(ISum<IDouble>)});
	this.Mpi = (IMPIDirect) BackEnd.createSlice(this, UID,"mpi","mpi",new Type[] {});
	this.Input_data = (IIntegralCase<F>) BackEnd.createSlice(this, UID,"input","integral_case",new Type[] {typeof(F)});
	this.Output_data = (IDouble) BackEnd.createSlice(this, UID,"output","double",new Type[] {});
} 

abstract public void compute(); 


}

}
