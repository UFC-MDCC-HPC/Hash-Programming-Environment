using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;
using skeleton.Farm.Collect.SumAreas;
using MPI;

namespace skeleton.impl.Farm.Collect.SumAreas { 

public class ISendResultImpl<Ds> : BaseISendResultImpl<Ds>, ISendResults<Ds>
where Ds:IDouble
{

public ISendResultImpl() { 

} 

public override void synchronize() {
   
	Intracommunicator localComm = mpi.localComm(this);
	
	int[] ranks_of_collector = mpi.ranksOf(this, "sum");
	int root_collect = this.RanksInv[ranks_of_collector[0]];

    double result = data.Value; // mudará para "double[] result". 
   
    localComm.Reduce<double>(result, Operation<double>.Add, root_collect);
    
} // end activate method 

}

}
