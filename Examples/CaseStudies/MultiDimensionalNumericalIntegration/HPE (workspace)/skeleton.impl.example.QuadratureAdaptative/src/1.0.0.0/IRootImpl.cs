using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function.TestingFunction;

namespace skeleton.impl.example.QuadratureAdaptative { 

public class IRootImpl<F> : BaseIRootImpl<F>
where F:ITestingFunction
{

		public IRootImpl() { 
		
		} 
		
		public override void compute() { 
				
			int dim_num = 2;
			int dim_partition_size = 2;
			int number_of_partitions = 10;
			getargs(System.Environment.GetCommandLineArgs(), ref dim_num, ref dim_partition_size, ref number_of_partitions);
				
			for (int i = 0; i < dim_num; i++) {
			   input_data.a[i] = 0.0; 
			   input_data.b[i] = 1.0;
			}
			
			Console.WriteLine("MANAGER - STARTING ADAPTATIVE QUADRATURE");
			
			manager.compute();
			
			Console.WriteLine("RESULT = " + output_data.Value);
			
			Console.WriteLine("WORKER - FINISH ADAPTATIVE QUADRATURE");
		
		} // end activate method 

        private static void getargs(string[] args, ref int dim_num, ref int dim_partition_size, ref int number_of_partitions)
        {
            for (int i = 0; i < args.Length; i++)
            {
                if (i + 1 < args.Length)
                {
                    if (args[i].Equals("--dim_num"))
                    {
                        dim_num = int.Parse(args[i + 1]);
                    }
                    else if (args[i].Equals("--dim_partition_size") && i + 1 < args.Length)
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
