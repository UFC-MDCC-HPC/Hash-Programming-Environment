using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;
using MPI;

namespace skeleton.impl.Farm.Collect.AQSumAreas { 

public class ISumAreasCollect<Dt> : BaseISumAreasCollect<Dt>
where Dt:IDouble
{

public ISumAreasCollect() { 

} 

public override void synchronize() { 

	Intracommunicator localComm = mpi.localComm(this);

	int[] ranks_of_collector = mpi.ranksOf(this, "collect");
	int root_collect = ranks_of_collector[0];
	int[] ranks_of_sender = mpi.ranksOf(this, "send");
	int number_of_senders = ranks_of_sender.Length;

    // RECEIVE THE SIZE FROM ONE OF THE SENDERS. No overhead ...
    int size = localComm.Receive<int>(Intracommunicator.anySource,0);
    	
    double[] dummy_result = new double[size];
    double[] local_result = localComm.Reduce<double>(dummy_result,Operation<double>.Add, root_collect);
    
    double result = 0.0D;
    foreach (double r in local_result) result += r;                    

    data.Value = result;	

} // end activate method 

}

}
