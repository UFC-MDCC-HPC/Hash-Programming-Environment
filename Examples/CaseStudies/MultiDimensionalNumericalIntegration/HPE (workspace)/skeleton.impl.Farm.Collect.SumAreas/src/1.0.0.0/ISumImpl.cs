using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;
using skeleton.Farm.Collect.SumAreas;
using MPI;

namespace skeleton.impl.Farm.Collect.SumAreas { 

public class ISumImpl<Dt> : BaseISumImpl<Dt>, ISum<Dt>
where Dt:IDouble
{

public ISumImpl() { 

} 

public override void synchronize() { 
   
	Intracommunicator localComm = mpi.localComm(this);

	int[] ranks_of_collector = mpi.ranksOf(this, "collect");
	int root_collect = ranks_of_collector[0];
    	
    double result = localComm.Reduce<double>(0.0,Operation<double>.Add, root_collect);
    
    data.Value = result;	

} // end activate method 

}

}
