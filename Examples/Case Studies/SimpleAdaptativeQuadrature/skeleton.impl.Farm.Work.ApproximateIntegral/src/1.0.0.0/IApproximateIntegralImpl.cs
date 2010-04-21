using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work.ApproximateIntegral;
using NINTLIB;

namespace skeleton.impl.Farm.Work.ApproximateIntegral { 

public class IApproximateIntegralImpl<F, I, O> : BaseIApproximateIntegralImpl<F, I, O>, IApproximateIntegral<F, I, O>
where F:IFunction
where I:IIntegralCase<F>
where O:IDouble
{

public IApproximateIntegralImpl() { 

} 

        private const int UNDEFINED = 0;
 
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

		public override void compute() { 
			
            // Set the integrating function.
            f = NINTLIB.IntegratingFunctions.p01_f;

			double[] a = input_data.a;
			double[] b = input_data.b;	
            double[] result = new double[num_local_jobs];
			
            int[] sub_num = new int[dim_num];
            for (int i = 0; i < dim_num; i++)                
                sub_num[i] = number_of_partitions/dim_partition_size;
                  
            int eval_num = 0;
            result[0] = NINTLIB.NINTLIB.romberg_nd(function, a, b, dim_num, sub_num, it_max, tol, ref ind_, out eval_num);
						  
		} // end activate method 

        private static NINTLIB.MultiPointsIntegratingFunction f;

        private static double function(double[] x)
        {
            double[,] x_ = new double[1, x.Length];

            int i = 0;
            foreach (double e in x)
                x_[0, i++] = e;


            return f(x_)[0];
        }
		
}

}
