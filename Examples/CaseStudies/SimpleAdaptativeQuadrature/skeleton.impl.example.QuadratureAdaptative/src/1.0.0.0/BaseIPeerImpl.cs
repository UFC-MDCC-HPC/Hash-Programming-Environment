/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using environment.MPIDirect;
using skeleton.Farm;
using jefferson.data.Double;
using skeleton.Farm.Collect;
using data.IntegralCase;
using data.Function.TestingFunction;
using skeleton.Farm.Distribute.DistributeInterval;
using skeleton.Farm.Work.ApproximateIntegral;
using skeleton.example.QuadratureAdaptative;

namespace skeleton.impl.example.QuadratureAdaptative { 

public abstract class BaseIPeerImpl<F>: Application, IPeer<F>
where F:ITestingFunction
{

protected IMPIDirect mpi = null;

protected IMPIDirect Mpi {
	set {
		this.mpi = value;
		worker.Mpi = value;
	}
}

protected IWorker<IDouble, ISend<IDouble>, IIntegralCase<F>, IDistributeIntervalReceive<F, IIntegralCase<F>>, IApproximateIntegral<F, IIntegralCase<F>, IDouble>> worker = null;

protected IWorker<IDouble, ISend<IDouble>, IIntegralCase<F>, IDistributeIntervalReceive<F, IIntegralCase<F>>, IApproximateIntegral<F, IIntegralCase<F>, IDouble>> Worker {
	set {
		this.worker = value;
	}
}


public BaseIPeerImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000006d05c82bff26ad72150a252c8c9742c86f6c62e6fe0cb696e223e19c0441a20a249526c60ee5553b2eddc609f73c569a23cfd334b51d25d1bd36d608dc901932e635a71bce017f93a1aabc8a129f65b9a7d3d384b42ae038d9d1006b984abdf11cc686520195bdac3acc399a24871f11885f37168f0ac04580fbce53d438e394";

override public void createSlices() {
	base.createSlices();
	this.Worker = (IWorker<IDouble, ISend<IDouble>, IIntegralCase<F>, IDistributeIntervalReceive<F, IIntegralCase<F>>, IApproximateIntegral<F, IIntegralCase<F>, IDouble>>) BackEnd.createSlice(this, UID,"farm","worker",new Type[] {typeof(IDouble),typeof(ISend<IDouble>),typeof( IIntegralCase<F>),typeof( IDistributeIntervalReceive<F, IIntegralCase<F>>),typeof(IApproximateIntegral<F, IIntegralCase<F>, IDouble>)});
	this.Mpi = (IMPIDirect) BackEnd.createSlice(this, UID,"mpi","mpi",new Type[] {});
} 

abstract public void compute(); 


}

}
