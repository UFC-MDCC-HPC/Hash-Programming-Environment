using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using data.IntegralCase;
using skeleton.Farm.Distribute.DistributeInterval;
using MPI;

namespace skeleton.impl.Farm.Distribute.DistributeInterval { 

public class IDistributeIntervalReceiveImpl<F, Dt> : BaseIDistributeIntervalReceiveImpl<F, Dt>, IDistributeIntervalReceive<F, Dt>
where F:IFunction
where Dt:IIntegralCase<F>
{

public IDistributeIntervalReceiveImpl() { 

} 

public override void synchronize() { 

	Intracommunicator localComm = mpi.localComm(this);
	int root = mpi.ranksOf(this, "distribute")[0];

    double[,] a_local = localComm.Scatter<double[,]>(0);
    double[,] b_local = localComm.Scatter<double[,]>(0);

    
//    data.a = limits[0];
  //  data.b = limits[1];

} // end activate method 

}

}
