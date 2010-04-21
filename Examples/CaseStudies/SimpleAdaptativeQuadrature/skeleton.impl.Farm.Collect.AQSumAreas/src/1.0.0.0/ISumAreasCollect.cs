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
	
	data.Value = localComm.Reduce<double>(0.0, Operation<double>.Add, localComm.Rank);
	
	

} // end activate method 

}

}
