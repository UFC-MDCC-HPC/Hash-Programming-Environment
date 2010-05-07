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
	
  	    getargs(System.Environment.GetCommandLineArgs(), ref dim_partition_size, ref number_of_partitions);

	} 

    private int dim_partition_size = 2;
    private int number_of_partitions = 10;   

	public override void synchronize() { 
	
	
		Intracommunicator localComm = mpi.localComm(this);
		int[] peers = mpi.ranksOf(this, "receive");
		
	    double[] a_input = data.a;
	    double[] b_input = data.b;
	
		int size = peers.Length;
	    int dim_num = a_input.Length;
		int num_jobs = (int) Math.Pow(dim_partition_size, dim_num);
		int num_local_jobs = num_jobs / size;    
	    
	    // Set/Divide the interval
	    double[][,] a = new double[size + 1][,];
	    double[][,] b = new double[size + 1][,];
	
	    a[0] = new double[0, 0];
	    b[0] = new double[0, 0];
	    for (int r = 1; r < size + 1; r++)
	    {
	        a[r] = new double[num_local_jobs, dim_num];
	        b[r] = new double[num_local_jobs, dim_num];
	    }
	
	    int[] dims = new int[dim_num];
	
	    for (int job = 0; job < num_jobs; job++)
	    {
	        int r = job % size + 1;
	        int j = job / size;
	        for (int i = 0; i < dim_num; i++)
	        {
	            a[r][j,i] = a_input[i] + dims[i] * ((b_input[i] - a_input[i]) / dim_partition_size);
	            b[r][j,i] = a_input[i] + (dims[i] + 1) * ((b_input[i] - a_input[i]) / dim_partition_size);
	        }
	
	        // NEXT JOB
	        int ii = 0;
	        while (ii < dim_num)
	        {
	            dims[ii] = (dims[ii] + 1) % dim_partition_size;
	            if (dims[ii] == 0)
	                ii++;
	            else
	                break;
	        }
	    }
	    
	    // Distribute jobs.
	    
	    localComm.Scatter<double[,]>(a);
	    localComm.Scatter<double[,]>(b);
	    
	} // end activate method 

        private static void getargs(string[] args, ref int dim_partition_size, ref int number_of_partitions)
        {
            for (int i = 0; i < args.Length; i++)
            {
                if (i + 1 < args.Length)
                {
                    if (args[i].Equals("--dim_partition_size") && i + 1 < args.Length)
                    {
                        dim_partition_size = int.Parse(args[i + 1]);
                    }
                    else if (args[i].Equals("--number_of_partitions") && i + 1 < args.Length)
                    {
                        number_of_partitions = int.Parse(args[i + 1]);
                    }
                }
            }
        }


}

}
