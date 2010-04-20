using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
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
	int[] a = mpi.ranksOf(this, "send");

	int root = a[0];

	localComm.Reduce<double>(data.Value, Operation<double>.Add, root);

} // end activate method 

}

}
