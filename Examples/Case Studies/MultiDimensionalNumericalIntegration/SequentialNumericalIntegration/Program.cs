using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NINTLIB;

namespace SequentialNumericalIntegration
{
    class Program
    {

        private static NINTLIB.MultiPointsIntegratingFunction f;

        static void Main(string[] args)
        {

            // Set the integrating function.

            f = NINTLIB.IntegratingFunctions.p01_f;

            // Set the number of dimensions

            int dim_num = 2;
            int number_of_partitions = 10;
            getargs(args, ref dim_num, ref number_of_partitions);
            Console.WriteLine("dim_num = " + dim_num);
            Console.WriteLine("number_of_partitions = " + number_of_partitions);

            // Set the interval

            double[] a = new double[dim_num];
            double[] b = new double[dim_num];
            for (int i = 0; i < dim_num; i++)
            {
                a[i] = 0.0D;
                b[i] = 1.0D;
            }

            int ind = 0;
            const int it_max = 2;
            int[] sub_num = new int[dim_num];
            double tol = 1e-5D;

            // sub_num(1:dim_num) = 10
            for (int i = 0; i < dim_num; i++)
            {
                sub_num[i] = number_of_partitions;
            }

            // Perform work

            int eval_num;
            double result;

            DateTime startTime = DateTime.Now;
            result = NINTLIB.NINTLIB.romberg_nd(function, a, b, dim_num, sub_num, it_max, tol, ref ind, out eval_num);
            DateTime stopTime = DateTime.Now;
            TimeSpan time = stopTime - startTime;

            // Present result

            Console.WriteLine("  ROMBERG_ND:     " + result + "," + eval_num + " in " + time.TotalMilliseconds + " milliseconds !");

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

        private static void getargs(string[] args, ref int dim_num, ref int dim_partition_size)
        {
            for (int i = 0; i < args.Length; i++)
            {
                if (i + 1 < args.Length)
                {
                    if (args[i].Equals("--dim_num"))
                    {
                        dim_num = int.Parse(args[i + 1]);
                    }
                    else if (args[i].Equals("--number_of_partitions") && i + 1 < args.Length)
                    {
                        dim_partition_size = int.Parse(args[i + 1]);
                    }
                }
            }
        }
    }


}
