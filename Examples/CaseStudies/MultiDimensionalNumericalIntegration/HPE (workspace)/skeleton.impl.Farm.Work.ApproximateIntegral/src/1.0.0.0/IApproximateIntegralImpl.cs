using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work.ApproximateIntegral;
using NINTLIB;

namespace skeleton.impl.Farm.Work.ApproximateIntegral { 

public class IApproximateIntegralImpl<F, I, O> : BaseIApproximateIntegralImpl<F, I, O>, IApproximateIntetral<F, I, O>
where F:IFunction
where I:IList<IIntegralCase<F>>
where O:IDouble
{

		public IApproximateIntegralImpl() {
		
				getargs(System.Environment.GetCommandLineArgs(), ref dim_partition_size, ref number_of_partitions);
		} 
		
        private int ind = 0;
        private double tol = 1e-15;
        private int it_max = 2;
       
        private int dim_partition_size = 2;
        private int number_of_partitions = 10;

  /*      private static NINTLIB.MultiPointsIntegratingFunction f = NINTLIB.IntegratingFunctions.p33_f;

        private static double function(double[] x)
        {
            double[,] x_ = new double[1, x.Length];

            int i = 0;
            foreach (double e in x)
                x_[0, i++] = e;


            return f(x_)[0];
        }  */
        
        public override void compute() { 
  			
			System.Collections.Generic.IList<IIntegralCase<F>> jobList = input_data.getList();
			
			int dim_num = jobList[0].a.Length;
			
            int[] sub_num = new int[dim_num];
            for (int i = 0; i < dim_num; i++)                
                sub_num[i] = number_of_partitions/dim_partition_size;
	                  
            TimeSpan timeW = TimeSpan.FromSeconds(0);
            double result = 0.0D;
            int eval_num_total = 0;
            foreach (IIntegralCase<F> job in jobList) {
				double[] a = job.a;
				double[] b = job.b;	
				// int dim_num = a.Length;
								
	            int eval_num = 0;
	            DateTime startTimeW = DateTime.Now;
	            result += NINTLIB.NINTLIB.romberg_nd(job.f /*function */, a, b, dim_num, sub_num, it_max, tol, ref ind, out eval_num);
                DateTime stopTimeW = DateTime.Now;
                timeW += stopTimeW - startTimeW;            
                
                eval_num_total += eval_num; 
            }
            
            output_data.Value = result;
						  
            Console.WriteLine("ABSOLUTE WORKER TIME = " + timeW.TotalMilliseconds + "ms - eval_num = " + eval_num_total);						  
						  
		} // end activate method 

        private static void getargs(string[] args, ref int dim_partition_size, ref int number_of_partitions)
        {   if (args != null) 
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

}
