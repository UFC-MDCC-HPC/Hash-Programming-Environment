using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using jefferson.data.Double;
using MPI;

namespace skeleton.impl.Farm.Collect.AQSumAreas { 

public class ISumAreasSendImpl<Ds> : BaseISumAreasSendImpl<Ds>
where Ds:IDouble
{

public ISumAreasSendImpl() { 

} 

public override void synchronize() { 

	Intracommunicator localComm = mpi.localComm(this);
	
	int[] ranks_of_collector = mpi.ranksOf(this, "collect");
	int root_collect = ranks_of_collector[0];

    double result = data.Value; // mudará para "double[] result". 
   
    int size = 0; // result.Length; 
    Request req = localComm.ImmediateSend<int>(size, root_collect, 0);

    localComm.Reduce<double>(result, Operation<double>.Add, root_collect);

    if (/*!req.Test()*/ true) {
       req.Cancel();
    }

} // end activate method 

}

}
