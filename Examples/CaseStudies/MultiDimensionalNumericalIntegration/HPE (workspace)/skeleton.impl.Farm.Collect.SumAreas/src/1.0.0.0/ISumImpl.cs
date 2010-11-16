using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
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

	int[] ranks_of_collector = mpi.ranksOf(this, "sum");
	int root_collect = this.RanksInv[ranks_of_collector[0]];
    	
    double result = localComm.Reduce<double>(0.0D,Operation<double>.Add, root_collect);
    
    data.Value = result;	

} // end activate method 

}

}
