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
				
			Console.WriteLine("MANAGER - STARTING ADAPTATIVE QUADRATURE");
			TimeSpan timeW = TimeSpan.FromSeconds(0);
			DateTime startTimeW = DateTime.Now;
			
			int dim_num = 2;
			int dim_partition_size = 2;
			int number_of_partitions = 10;
			getargs(System.Environment.GetCommandLineArgs(), ref dim_num, ref dim_partition_size, ref number_of_partitions);
								
			input_data.dim_num = dim_num;
			   						
			manager.compute();
			
			DateTime stopTimeW = DateTime.Now;
			timeW = stopTimeW - startTimeW;
						
			Console.WriteLine("WORKER - FINISH ADAPTATIVE QUADRATURE - RESULT = " + output_data.Value + " - ELAPSED TIME = " + timeW.TotalMilliseconds + "ms");
		
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
