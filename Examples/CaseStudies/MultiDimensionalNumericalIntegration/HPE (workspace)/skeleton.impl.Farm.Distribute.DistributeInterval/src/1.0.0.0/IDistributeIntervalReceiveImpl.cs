using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using skeleton.Farm.Distribute.DistributeInterval;
using MPI;

namespace skeleton.impl.Farm.Distribute.DistributeInterval { 

public class IDistributeIntervalReceiveImpl<F, Dt> : BaseIDistributeIntervalReceiveImpl<F, Dt>, IDistributeIntervalReceive<F, Dt>
where F:IFunction
where Dt:IList<IIntegralCase<F>>
{

public IDistributeIntervalReceiveImpl() { 

} 

public override void synchronize() { 

	Intracommunicator localComm = mpi.localComm(this);
	int root = mpi.ranksOf(this, "distribute")[0];

    double[,] a_local = localComm.Scatter<double[,]>(root);
    double[,] b_local = localComm.Scatter<double[,]>(root);
    
    int number_of_jobs = a_local.GetLength(0);
    int dim_num = a_local.GetLength(1);
    
    for (int i = 0; i < number_of_jobs; i++) {
        IIntegralCase<F> ic = (IIntegralCase<F>) data.createElement();
        ic.dim_num = dim_num;
        for (int j = 0; j < dim_num; j++) {
	        ic.a[j] = a_local[i,j];
	        ic.b[j] = b_local[i,j];
        }
    }
    
    
//    data.a = limits[0];
  //  data.b = limits[1];

} // end activate method 

}

}
