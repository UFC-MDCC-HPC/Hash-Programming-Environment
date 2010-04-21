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

} 
    const int UNDEFINED = 0;

    private int dim_num_ = UNDEFINED;
    private int dim_partition_size_ = UNDEFINED;
    private int number_of_partitions_ = UNDEFINED;
    private int ind_ = UNDEFINED;
    private double tol_ = UNDEFINED;
    private int it_max_ = UNDEFINED;
    private int size_ = UNDEFINED;
   
    public int dim_num {get { return dim_num_; } set { dim_num_ = value; }}
    public int dim_partition_size {get { return dim_partition_size_; } set {dim_partition_size_ = value; }}
    public int number_of_partitions {get { return number_of_partitions_; } set {number_of_partitions_ = value; }}
    public int ind {get { return ind_; } set {ind_ = value; }}
    public double tol {get { return tol_; } set { tol_ = value; }}
    public int it_max {get { return it_max_; } set { it_max_ = value; }}
    public int size { get { return size_; } set { size_ = value; } }

    public int num_jobs { get { return (int) Math.Pow(dim_partition_size, dim_num); }}	    
    public int num_local_jobs { get {return num_jobs / size;}}


public override void synchronize() { 

	Intracommunicator localComm = mpi.localComm(this);
	int[] peers = mpi.ranksOf(this, "receive");

    double[] a_input = data.a;
    double[] b_input = data.b;
    
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
    
    DateTime startTime = DateTime.Now;

    localComm.Scatter<double[,]>(a);
    localComm.Scatter<double[,]>(b);
    
    

} // end activate method 

}

}
