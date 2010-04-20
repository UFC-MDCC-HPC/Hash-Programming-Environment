using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NINTLIB;

namespace Teste
{
    class Program
    {
        static void Main(string[] args)
        {
            const int test_num = 3;

            double a;
            double b;
            int dim_num;
            int[] dim_num_test = new int[test_num] { 2, 3, 4 };      //  integer ( kind = 4 ), dimension ( test_num ) :: dim_num_test = (/ 2, 3, 4 /)
            int test;

            //  call timestamp ( )

            Console.WriteLine("NINTLIB_PRB");
            Console.WriteLine("  FORTRAN90 version");
            Console.WriteLine(" ");
            Console.WriteLine("  Test routines in the NINTLIB library.");

            a = 0.0D;
            b = 1.0D;

            Console.WriteLine(" ");
            Console.WriteLine("TESTND");
            Console.WriteLine("  Test routines for estimating the integral of");
            Console.WriteLine("  of F(X) in the hypercube [A,B]**DIM_NUM.");
            Console.WriteLine(" ");

            for (test = 0; test < test_num; test++)
            {

                dim_num = dim_num_test[test];

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  DIM_NUM = " + dim_num);
                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  A(1:DIM_NUM) = " + a);
                Console.WriteLine("  B(1:DIM_NUM) = " + b);

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  F(X(1:DIM_NUM)) = 1");
                Console.WriteLine(" ");

                testnd(dim_num, f1dn);

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  F(X(1:DIM_NUM)) = sum ( X(1:DIM_NUM) )");
                Console.WriteLine(" ");

                testnd(dim_num, fxdn);

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  F(X(1:DIM_NUM)) = sum( X(1:DIM_NUM)^2 )");
                Console.WriteLine(" ");

                testnd(dim_num, fx2dn);

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  F(X(1:DIM_NUM)) = sum ( X(1:DIM_NUM)^3 )");
                Console.WriteLine(" ");

                testnd(dim_num, fx3dn);

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  F(X(1:DIM_NUM)) = exp(sum(X(1:DIM_NUM)))");
                Console.WriteLine(" ");

                testnd(dim_num, fedn);

                Console.WriteLine(" ");
                Console.WriteLine(" ");
                Console.WriteLine("  F(X(1:DIM_NUM)) = 1/(1+sum(X(1:DIM_NUM)^2))");
                Console.WriteLine(" ");

                testnd(dim_num, fbdn);
            }

            Console.WriteLine(" ");
            Console.WriteLine("NINTLIB_PRB");
            Console.WriteLine("  Normal end of execution.");

            Console.WriteLine(" ");

            //call timestamp ( )

            return;
        }



        static void testnd(int dim_num, IntegratingFunction func)
        {
            test01(dim_num, func);
            test02(dim_num, func);
            test03(dim_num, func);
            test04(dim_num, func);
            //
            //  TEST05 is only set up for DIM_NUM = 2.
            //
            if (dim_num == 2)
            {
                test05(dim_num, func);
            }

            test06(dim_num, func);
        }

        static double test01(int dim_num, IntegratingFunction func)
        {
            const int order = 5;

            int eval_num;

            double[] wtab = new double[order]  {0.236926885056189087514264040720D, 
                                                0.478628670499366468041291514836D, 
                                                0.568888888888888888888888888889D, 
                                                0.478628670499366468041291514836D, 
                                                0.236926885056189087514264040720D};



            double[] wtab2 = new double[order];

            double[] xtab = new double[order] { -0.906179845938663992797626878299D, 
                                                -0.538469310105683091036314420700D, 
                                                 0.0D, 
                                                 0.538469310105683091036314420700D, 
                                                 0.906179845938663992797626878299D };

            double[] xtab2 = new double[order];

            //  
            //  Adjust the quadrature rule from [-1,1] to [0,1]:
            //
            // xtab2(1:order) = ( xtab(1:order) + 1.0D+00 ) / 2.0D+00
            // wtab2(1:order) = 0.5D+00 * wtab(1:order)
            for (int i = 0; i < order; i++)
            {
                xtab2[i] = (xtab[i] + 1.0D) / 2.0D;
                wtab2[i] = 0.5D * wtab[i];
            }


            double result = NINTLIB.NINTLIB.box_nd(func, dim_num, order, xtab2, wtab2, out eval_num);

            Console.WriteLine("  BOX_ND:         " + result + ", " + eval_num);

            return result;
        }

        static double test02(int dim_num, IntegratingFunction func)
        {

            double[] a = new double[dim_num];
            double[] b = new double[dim_num];
            int eval_num;
            double result;

            //
            //  Set the integration limits.
            //

            //  a(1:dim_num) = 0.0D+00
            //  b(1:dim_num) = 1.0D+00
            for (int i = 0; i < dim_num; i++)
            {
                a[i] = 0.0D;
                b[i] = 1.0D;
            }

            result = NINTLIB.NINTLIB.p5_nd(func, dim_num, a, b, out eval_num);

            Console.WriteLine("  P5_ND:          " + result + "," + eval_num);

            return result;
        }

        static double test03(int dim_num, IntegratingFunction func)
        {

            double[] a = new double[dim_num];
            double[] b = new double[dim_num];
            int eval_num;
            int ind = 0;
            const int it_max = 2;
            double result;
            int[] sub_num = new int[dim_num];
            double tol;
            //
            //  Set the integration limits.
            //
            //  a(1:dim_num) = 0.0D+00
            //  b(1:dim_num) = 1.0D+00
            for (int i = 0; i < dim_num; i++)
            {
                a[i] = 0.0D;
                b[i] = 1.0D;
            }

            tol = 0.001D;

            // sub_num(1:dim_num) = 10
            for (int i = 0; i < dim_num; i++)
            {
                sub_num[i] = 10;
            }

            result = NINTLIB.NINTLIB.romberg_nd(func, a, b, dim_num, sub_num, it_max, tol, ref ind, out eval_num);

            Console.WriteLine("  ROMBERG_ND:     " + result + "," + eval_num);

            return result;
        }

        static void test04(int dim_num, IntegratingFunction func)
        {
            const int k2 = 4;

            double[] dev1 = new double[k2];
            double[] dev2 = new double[k2];
            double[] err1 = new double[k2];
            double[] est1 = new double[k2];
            double[] est2 = new double[k2];
            double[] err2 = new double[k2];
            int eval_num;
            int k1;

            k1 = 1;

            NINTLIB.NINTLIB.sample_nd(func, k1, k2, dim_num, ref est1, ref err1, ref dev1, ref est2, ref err2, ref dev2, out eval_num);

            Console.WriteLine("  SAMPLE_ND:      " + est2[k2 - 1] + "," + eval_num);

        }

        static double test05(int dim_num, IntegratingFunction func)
        {
            double[] a = new double[dim_num];
            double[] b = new double[dim_num];
            int eval_num;
            int eval_total;
            int i;
            int igrid;
            int j;
            int ngrid;
            double result;
            double result_total = 0.0D;
            double[] xlo = new double[dim_num];
            double[] xhi = new double[dim_num];

            //  xlo(1:dim_num) = 0.0D+00
            //  xhi(1:dim_num) = 1.0D+00
            for (int k = 0; k < dim_num; k++)
            {
                xlo[k] = 0.0D;
                xhi[k] = 1.0D;
            }

            for (igrid = 1; igrid <= 6; igrid++)
            {

                ngrid = (int)Math.Pow(2, igrid - 1);

                result_total = 0.0D;
                eval_total = 0;

                for (i = 1; i <= ngrid; i++)
                {

                    a[0] = ((ngrid - i + 1) * xlo[0] + (i - 1) * xhi[0]) / ngrid;
                    b[0] = ((ngrid - i) * xlo[0] + i * xhi[0]) / (ngrid);

                    for (j = 1; j <= ngrid; j++)
                    {

                        a[1] = ((ngrid - j + 1) * xlo[1] + (j - 1) * xhi[1]) / (ngrid);

                        b[1] = ((ngrid - j) * xlo[1] + j * xhi[1]) / ngrid;

                        result = NINTLIB.NINTLIB.p5_nd(func, dim_num, a, b, out eval_num);

                        result_total = result_total + result;
                        eval_total = eval_total + eval_num;

                    }

                }

                Console.WriteLine("  P5_ND+:         " + result_total + "," + eval_total);

            }
            return result_total;
        }

        static double test06(int dim_num, IntegratingFunction func)
        {

            const int test_num = 3;

            double[] a = new double[dim_num];
            double[] b = new double[dim_num];
            int eval_num;

            double result = 0.0D;
            int seed;
            int test;

            seed = 123456789;
            //
            //  Set the integration limits.
            //
            for (int i = 0; i < dim_num; i++)
            {
                a[i] = 0.0D;
                b[i] = 1.0D;
            }

            for (test = 1; test <= test_num; test++)
            {

                eval_num = (int)Math.Pow(8, test) * 10000;

                result = NINTLIB.NINTLIB.monte_carlo_nd(func, dim_num, a, b, eval_num, seed);

                Console.WriteLine("  MONTE_CARLO_ND: " + result + "," + eval_num);

            }
            return result;
        }


        // FUNCTIONS TO BE INTEGRATED.

        static double f1dn(double[] xs)
        {
            return 1.0D;
        }

        static double fbdn(double[] xs)
        {
            // fbdn = 1.0D+00 / ( 1.0D+00 + sum ( x(1:dim_num)**2 ) )
            double sum = 0;
            foreach (double x in xs)
                sum += Math.Pow(x, 2.0D);
            return 1.0D / (1.0D + sum);

        }

        static double fedn(double[] xs)
        {
            double sum = 0;
            foreach (double x in xs)
                sum += x;
            return Math.Exp(sum);
        }

        static double fxdn(double[] xs)
        {
            double sum = 0;
            foreach (double x in xs)
                sum += x;
            return sum;
        }

        static double fx2dn(double[] xs)
        {
            double sum = 0;
            foreach (double x in xs)
                sum += Math.Pow(x, 2.0D);
            return sum;
        }

        static double fx3dn(double[] xs)
        {
            double sum = 0;
            foreach (double x in xs)
                sum += Math.Pow(x, 3.0D);
            return sum;
        }

        // ADDED

        static double[] p33_f(double[,] x)
        {
            int dim_num = x.Rank - 1;
            int point_num = x.GetUpperBound(0) + 1;
            double[] value = new double[point_num];
            for (int point = 0; point < point_num; point++)
            {
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                    value[point] += (Math.Pow(x[point,i], 2));
            }
            return value;
        }

        static double[] p01_f(double[,] x)
        {

            /*
        !*****************************************************************************80
        !
        !! P01_F evaluates the integrand for problem 01.
        !
        !  Discussion:
        !
        !    The spatial dimension DIM_NUM is arbitrary.
        !
        !  Region:
        !
        !    0 <= X(1:DIM_NUM) <= 1
        !
        !  Integrand:
        !
        !    f(x) = ( sum ( x(1:dim_num) ) )**2
        !
        !  Exact Integral:
        !
        !    dim_num * ( 3 * dim_num + 1 ) / 12
        !
        !  Licensing:
        !
        !    This code is distributed under the GNU LGPL license. 
        !
        !  Modified:
        !
        !    03 June 2007
        !
        !  Author:
        !
        !    John Burkardt (original Fortran 90)
        !    Francisco Heron de Carvalho Junior (translation to C#)
        !
        !  Parameters:
        !
        !    Input, int ( kind = 4 ) dim_num, the dimension of the argument.
        !
        !    Input, int ( kind = 4 ) point_num, the number of points.
        !
        !    Input, double[,] x (x.Length = DIM_NUM * POINT_NUM), the evaluation points.
        !
        !  Returns:
        !
        !    Output, double[] value (value.Length == point_num), the function values.
        !
             */


            int dim_num = x.Rank - 1;
            int point_num = x.GetUpperBound(0) + 1;
            double[] value = new double[point_num];
            
            for (int point = 0; point < point_num; point++)
            {
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += Math.Pow(x[point,i], 2);
                }
            }
            return value;
        }
    }
}