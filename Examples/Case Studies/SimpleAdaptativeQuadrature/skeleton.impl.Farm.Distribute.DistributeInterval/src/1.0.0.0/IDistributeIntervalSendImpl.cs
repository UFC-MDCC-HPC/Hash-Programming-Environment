using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using data.IntegralCase;
using skeleton.Farm.Distribute.DistributeInterval;
using MPI;

namespace skeleton.impl.Farm.Distribute.DistributeInterval { 

public class IDistributeIntervalSendImpl<F, Ds> : BaseIDistributeIntervalSendImpl<F, Ds>, IDistributeIntervalSend<F, Ds>
where F:IFunction
where Ds:IIntegralCase<F>
{

public IDistributeIntervalSendImpl() { 

} 

public override void synchronize() { 

	Intracommunicator localComm = mpi.localComm(this);
	int[] peers = mpi.ranksOf(this, "receive");

    double a = data.a;
    double b = data.b;
    int N = peers.Length;

    double interval = (b - a)/N;

    double x = a;
    foreach (int r in peers) {
	    localComm.Send<double>(new double[2]{x, x + interval}, r, 0);
	    x += interval;
    }
    

} // end activate method 

}

}
