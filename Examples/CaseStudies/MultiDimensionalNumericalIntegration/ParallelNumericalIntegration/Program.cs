using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MPI;
using NINTLIB;
using System.Collections;
using System.Threading;

namespace ParallelNumericalIntegration
{
    class Program
    {
        const int TAG_A = 1000;
        const int TAG_B = 2000;
        const int TAG_RESULT = 3000;

        private static NINTLIB.MultiPointsIntegratingFunction f;

        private static int it_max = 2;
        private static int ind = 0;
        private static double tol = 1e-5D;

        private static int dim_num = 1;
        private static int dim_partition_size = 1;
        private static int number_of_partitions = 1;

        private static double[] result;
        private static int[] sub_num;
        private static TimeSpan timeW;
        private static int eval_num_total;

        static void Main(string[] args)
        {
            MPI.Environment mpi;
            mpi = new MPI.Environment(ref args);

            int size = Communicator.world.Size - 1; // NUMBER OF WORKERS
            int rank = Communicator.world.Rank;

            // Set the integrating function.
            f = NINTLIB.IntegratingFunctions.p33_f;
                        
            // Set the number of dimensions

            getargs(args, ref dim_num, ref dim_partition_size, ref number_of_partitions);
            int num_jobs = (int)Math.Pow(dim_partition_size, dim_num);
            int num_local_jobs = num_jobs / size;

            if (rank == 0) // MANAGER (the manager only distribute jobs and collect results)
            {
                Console.WriteLine("dim_num = " + dim_num);
                Console.WriteLine("dim_partition_size = " + dim_partition_size);
                Console.WriteLine("number_of_partitions = " + number_of_partitions);
                Console.WriteLine("num_jobs = " + num_jobs);
                Console.WriteLine("num_local_jobs = " + num_local_jobs);
               
                DateTime startTime = DateTime.Now;

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
                        a[r][j,i] = dims[i] * (1.0D / dim_partition_size);
                        b[r][j, i] = (dims[i] + 1) * (1.0D / dim_partition_size);
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
                
                Communicator.world.Scatter<double[,]>(a);
                Communicator.world.Scatter<double[,]>(b);

                // Collect/Combine results

                double result = 0.0D;
                double[] dummy_result = new double[num_local_jobs];
                double[] local_result = Communicator.world.Reduce<double>(dummy_result,Operation<double>.Add,0);
                foreach (double r in local_result) result += r;                    

                DateTime stopTime = DateTime.Now;
                TimeSpan time = stopTime - startTime;

                // Present result
                Console.WriteLine("  ROMBERG_ND:     " + result + " in " + time.TotalMilliseconds + " milliseconds !");

            }
            else // WORKER !
            {
                // Receive jobs.

                double[,] a_local = Communicator.world.Scatter<double[,]>(0);
                double[,] b_local = Communicator.world.Scatter<double[,]>(0);

                // Perform work.

                sub_num = new int[dim_num];
                for (int i = 0; i < dim_num; i++)                
                    sub_num[i] = number_of_partitions/dim_partition_size;                

                double[] a = new double[dim_num];
                double[] b = new double[dim_num];
                result = new double[num_local_jobs];

                System.Collections.Generic.IList<Thread> work_threads = new System.Collections.Generic.List<Thread>();

                timeW = TimeSpan.FromSeconds(0);
                eval_num_total = 0;
                for (int j = 0; j < num_local_jobs; j++)
                {
                    for (int i = 0; i < dim_num; i++)
                    {
                        a[i] = a_local[j, i];
                        b[i] = b_local[j, i];
                    }

                    DoWork worker = new DoWork(j, a, b);
                    Thread workThread = new Thread(worker.perform);
                    work_threads.Add(workThread);
                    workThread.Start();								

                }

                foreach (Thread wt in work_threads)
                    wt.Join();

                Communicator.world.Reduce<double>(result, Operation<double>.Add, 0);

                Console.WriteLine("ABSOLUTE WORKER TIME = " + timeW.TotalMilliseconds + "ms - eval_num = " + eval_num_total);
            }

            mpi.Dispose();
        }

        private class DoWork
        {
            private int j;
            private double[] a;
            private double[] b;

            public DoWork(int j_, double[] a_, double[] b_)
            {
                this.a = a_;
                this.b = b_;
                this.j = j_;
            }

            public void perform()
            {
                int eval_num = 0;
                DateTime startTimeW = DateTime.Now;
                result[j] = NINTLIB.NINTLIB.romberg_nd(function, a, b, dim_num, sub_num, it_max, tol, ref ind, out eval_num);
                DateTime stopTimeW = DateTime.Now;
                timeW += stopTimeW - startTimeW;

                eval_num_total += eval_num;
            }
        }

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


        private static double[,] xs = new double[0, 0];

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
