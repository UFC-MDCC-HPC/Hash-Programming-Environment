﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MPI;
using NINTLIB;

namespace ParallelNumericalIntegration
{
    class Program
    {
        const int TAG_A = 1000;
        const int TAG_B = 2000;
        const int TAG_RESULT = 3000;

        private static NINTLIB.MultiPointsIntegratingFunction f;

        static void Main(string[] args)
        {
            MPI.Environment mpi;
            mpi = new MPI.Environment(ref args);

            int size = Communicator.world.Size - 1; // NUMBER OF WORKERS
            int rank = Communicator.world.Rank;

            // Set the integrating function.
            f = NINTLIB.IntegratingFunctions.p01_f;
                        
            // Set the number of dimensions

            int dim_num = 6;
            int dim_partition_size = 2;
            int num_jobs = (int) Math.Pow(dim_partition_size, dim_num);
            int num_local_jobs = num_jobs / size;


            if (rank == 0) // MANAGER (the manager only distribute jobs and collect results)
            {
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
                
                DateTime startTime = DateTime.Now;

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
                const int it_max = 2;   
                int ind = 0;                             
                double tol = 1e-5D;

                int[] sub_num = new int[dim_num];
                for (int i = 0; i < dim_num; i++)                
                    sub_num[i] = 8/dim_partition_size;                

                double[] a = new double[dim_num];
                double[] b = new double[dim_num];
                double[] result = new double[num_local_jobs];
                
                TimeSpan timeW = TimeSpan.FromSeconds(0);
                int eval_num_total = 0;
                for (int j = 0; j < num_local_jobs; j++)
                {
                    for (int i = 0; i < dim_num; i++)
                    {
                        a[i] = a_local[j, i];
                        b[i] = b_local[j, i];
                    }

                    DateTime startTimeW = DateTime.Now;
                    int eval_num = 0;
                    result[j] = NINTLIB.NINTLIB.romberg_nd(function, a, b, dim_num, sub_num, it_max, tol, ref ind, out eval_num);
                    DateTime stopTimeW = DateTime.Now;
                    timeW += stopTimeW - startTimeW;

                    eval_num_total += eval_num;                    
                }

                Communicator.world.Reduce<double>(result,Operation<double>.Add,0);

                Console.WriteLine("ABSOLUTE WORKER TIME = " + timeW.TotalMilliseconds + "ms - eval_num = " + eval_num_total);
            }

            mpi.Dispose();
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
