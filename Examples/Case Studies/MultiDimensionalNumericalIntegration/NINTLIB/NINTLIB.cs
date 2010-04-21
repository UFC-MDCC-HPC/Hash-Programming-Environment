using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NINTLIB
{
    public delegate double IntegratingFunction(double[] x);
    public delegate double[] MultiPointsIntegratingFunction(double[,] x);   

    public class NINTLIB
    {
        /* Integration Methods */

        public static double box_nd(IntegratingFunction func, int dim_num, int order, double[] xtab, double[] weight, out int eval_num)
        /*
         * 
         * BOX_ND estimates a multidimensional integral using a product rule.
         * 
         * Discussion:
         * 
         *  The routine creates a DIM_NUM-dimensional product rule from a 1D rule
         *  supplied by the user.  The routine is fairly inflexible.  If
         *  you supply a rule for integration from -1 to 1, then your product
         *  box must be a product of DIM_NUM copies of the interval [-1,1].
         *  
         * Licensing:
         * 
         * This code is distributed under the GNU LGPL license. 
         * 
         * Modified:
         * 
         * 11 September 2006 (translated version in Fortran 90)
         * 05 Abril 2010 (C#)
         * 
         * Author (Fortran 90 original version):
         * 
         * John Burkardt
         * 
         * Translated to C# by:
         * 
         * Francisco Heron de Carvalho Junior (MDCC/UFC)
         * http://www.lia.ufc.br/~heron
         * 
         * Reference:
         * 
         *  Philip Davis, Philip Rabinowitz,
         *  Methods of Numerical Integration,
         *  Second Edition,
         *  Dover, 2007,
         *  ISBN: 0486453391,
         *  LC: QA299.3.D28.
         *  
         * Parameters:
         * 
         * Input, delegate IntegratingFunction, a routine which evaluates
         * the function to be integrated, of the form:
         * 
         * double func (double[] x) {
         *   ...      
         * }
         * 
         * Input, int dim_num, the spatial dimension.
         * 
         * Input, int order, the number of points used in the 1D rule.
         * 
         * Input, double[] xtab, the abscissas of the 1D rule (xtab.Length == order). 
         * 
         * Input, double[] weight, the weights of the 1D rule (weigth.Length == order).
         * 
         * Output, int eval_num, the number of function evaluations.
         * 
         * Returns:
         * 
         *    double, the approximate value of the integral.
         * 
         */
        {
            int[] indx = new int[dim_num];
            int k;

            double w;
            double[] x = new double[dim_num];

            eval_num = 0;

            if (dim_num < 1)
            {
                Console.WriteLine("BOX_ND - Fatal error!");
                Console.WriteLine("DIM_NUM < 1");
                Console.WriteLine("  DIM_NUM = " + dim_num);
                return -1;
            }

            if (order < 1)
            {
                Console.WriteLine("BOX_ND - Fatal error!");
                Console.WriteLine("  ORDER < 1");
                Console.WriteLine("  ORDER = " + order);
                return -1;
            }

            k = 0;
            double result = 0.0D;

            while (true)
            {
                tuple_next(0, order - 1, dim_num, ref k, ref indx);

                if (k == 0) break;

                // w = product (weight(indx(1:dim_num)))
                // "product" is a Fortran 90 procedure that mutliplies the elements of a vector.
                w = 1;
                foreach (int ix in indx) w *= weight[ix];

                // x(1:dim_num) = xtab(indx(1:dim_num))
                // This Fortran 90 statement is an abbreviation for a iteration over a vector. 
                for (int i = 0; i < dim_num; i++) x[i] = xtab[indx[i]];

                result = result + w * func(x);
                eval_num = eval_num + 1;
            }
            return result;
        }

        public static double monte_carlo_nd(IntegratingFunction func, int dim_num, double[] a, double[] b, int eval_num, int seed)
        /*****************************************************************************
         *
         * MONTE_CARLO_ND estimates a multidimensional integral using Monte Carlo.
        *
        *  Discussion:
        *
        *    Unlike the other routines, this routine requires the user to specify
        *    the number of function evaluations as an INPUT quantity.
        *
        *    No attempt at error estimation is made.
        *
        *  Licensing:
        *
        *    This code is distributed under the GNU LGPL license. 
        *
        *  Modified:
        *
        *    25 February 2007(translated version)
        *    05 April 2010 (C# version)   
        *
        *  Author (Fortran 90 original version):
        * 
        *    John Burkardt
        * 
        *  Translated to C# by:
        * 
        *    Francisco Heron de Carvalho Junior (MDCC/UFC)
        *    http://www.lia.ufc.br/~heron
        * 
        *  Reference:
        *
        *    Philip Davis, Philip Rabinowitz,
        *    Methods of Numerical Integration,
        *    Second Edition,
        *    Dover, 2007,
        *    ISBN: 0486453391,
        *    LC: QA299.3.D28.
        *
        *  Parameters:
        *
        *    Input, delegate IntegratingFunction, a routine which evaluates
        *           the function to be integrated, of the form:
        * 
        *              double func (double[] x) {
        *                  // x.Length == dim_num
        *                  ...      
        *              }
        *
        *    Input, int dim_num, the spatial dimension.
        *
        *    Input, double[] a, b, the integration limits (a.Length == b.Length == dim_num).
        *
        *    Input, int eval_num, the number of function evaluations.
        *
        *    Input/output, int seed, a seed for the random number generator.
        *
        * Returns:
        * 
        *    double, the approximate value of the integral.
        * 
        */
        {
            double volume = 1.0D;
            double[] x = new double[dim_num];

            double result = 0.0D;

            for (int i = 0; i < eval_num; i++)
            {
                x = r8vec_uniform_01(dim_num, ref seed);
                result += func(x);
            }


            // volume = product ( b(1:dim_num) - a(1:dim_num));            
            for (int i = 0; i < dim_num; i++) 
                volume *= b[i] - a[i];

            result *= volume / eval_num;

            return result;

        }

        public static double p5_nd(IntegratingFunction func, int dim_num, double[] a, double[] b, out int eval_num)
        /*!*****************************************************************************80
        !
        !! P5_ND estimates a multidimensional integral with a formula of exactness 5.
        !
        !  Discussion:
        !
        !    The routine uses a method which is exact for polynomials of total 
        !    degree 5 or less.
        !
        !  Licensing:
        !
        !    This code is distributed under the GNU LGPL license. 
        !
        !  Modified:
        !
        !    11 September 2006
        !
        !  Author:
        !
        !    Original FORTRAN77 version by Philip Davis, Philip Rabinowitz.
        !    FORTRAN90 version by John Burkardt
        !    C# version by Rafael Sales and Francisco Heron de Carvalho Junior (MDCC/UFC)
        ! 
        !  Reference:
        !
        !    Philip Davis, Philip Rabinowitz,
        !    Methods of Numerical Integration,
        !    Second Edition,
        !    Dover, 2007,
        !    ISBN: 0486453391,
        !    LC: QA299.3.D28.
        !
        !  Parameters:
        !
        !    Input, delegate IntegratingFunction, a routine which evaluates
        !           the function to be integrated, of the form:
        ! 
        !              double func (double[] x) {
        !                  // x.Length == dim_num
        !                  ...      
        !              }
        !
        !    Input, int dim_num, the spatial dimension.
        !
        !    Input, double[] a, b, the integration limits (a.Length = b.Length = dim_num).
        !
        !    Output, int eval_num, the number of function evaluations.
        !
        !  Returns:
        !
        !    double, the approximate value of the integral.

     */
        {
            double a0, a1, a2, a3, a4, a5;
            double en;
            double sum1, sum2, sum3;
            double volume;
            double[] work = new double[dim_num];
            double result;

            eval_num = 0;

            if (dim_num < 1)
            {
                Console.Write("P5_ND - Fatal error!");
                Console.Write("  DIM_NUM < 1, DIM_NUM = {0}", dim_num);
                return -1.0D;
            }

            a2 = 25.0D / 324.0D;
            a3 = Math.Sqrt(0.6D);
            en = dim_num;
            a0 = (25.0D * en * en - 115.0D * en + 162.0D) / 162.0D;
            a1 = (70.0D - 25.0D * en) / 162.0D;

            //volume = product ( b(1:dim_num) - a(1:dim_num) )
            //work(1:dim_num) = 0.5D+00 * ( a(1:dim_num) + b(1:dim_num) )
            volume = 1;
            for (int i = 0; i < dim_num; i++)
            {
                volume *= (b[i] - a[i]);
                work[i] = 0.5D * (a[i] + b[i]);
            }

            result = 0.0D;
            if (volume == 0.0D)
            {
                Console.Write("P5_ND - Warning!");
                Console.Write("  Volume = 0, integral = 0.");
                return 0.0D;
            }

            sum1 = a0 * func(work);
            eval_num = eval_num + 1;

            sum2 = 0.0D;
            sum3 = 0.0D;

            for (int i = 0; i < dim_num; i++)
            {
                work[i] = 0.5D * ((a[i] + b[i]) + a3 * (b[i] - a[i]));
                sum2 = sum2 + func(work);
                eval_num = eval_num + 1;

                work[i] = 0.5D * ((a[i] + b[i]) - a3 * (b[i] - a[i]));
                sum2 = sum2 + func(work);
                eval_num = eval_num + 1;

                work[i] = 0.5D * (a[i] + b[i]);
            }

            if (1 < dim_num)
            {
                a4 = a3;
                while (true)
                {
                    for (int i = 0; i < dim_num - 1; i++)
                    {
                        work[i] = 0.5D * ((a[i] + b[i]) + a4 * (b[i] - a[i]));
                        a5 = a3;

                        while (true)
                        {
                            for (int j = i + 1; j < dim_num; j++)
                            {
                                work[j] = 0.5D * ((a[j] + b[j]) + a5 * (b[j] - a[j]));
                                sum3 = sum3 + func(work);
                                eval_num = eval_num + 1;
                                work[j] = 0.5D * (a[j] + b[j]);
                            }

                            a5 = -a5;

                            if (0.0D <= a5)
                            {
                                break;
                            }
                        }

                        work[i] = 0.5D * (a[i] + b[i]);
                    }

                    a4 = -a4;

                    if (0.0D <= a4)
                    {
                        break;
                    }
                }
            }
            result = volume * (sum1 + a1 * sum2 + a2 * sum3);
            return result;
        }

        public static double romberg_nd(IntegratingFunction func,
                                      double[] a,
                                      double[] b,
                                      int dim_num,
                                      int[] sub_num,
                                      int it_max,
                                      double tol,
                                      ref int ind,
                                      out int eval_num)
/*
!*****************************************************************************80
!
!! ROMBERG_ND estimates a multidimensional integral using Romberg integration.
!
!  Discussion:
!
!    The routine uses a Romberg method based on the midpoint rule.
!
!    In the reference, this routine is called "NDIMRI".
!
!    Thanks to Barak Bringoltz for pointing out problems in a previous
!    FORTRAN90 implementation of this routine.
!
!  Licensing:
!
!    This code is distributed under the GNU LGPL license. 
!
!  Modified:
!
!    11 September 2006
!
!  Author:
!
!    Original FORTRAN77 version by Philip Davis, Philip Rabinowitz.
!    FORTRAN90 version by John Burkardt
!    C# version by Francisco Heron de Carvalho Junior (MDCC/UFC)
!
!  Reference:
!
!    Philip Davis, Philip Rabinowitz,
!    Methods of Numerical Integration,
!    Second Edition,
!    Dover, 2007,
!    ISBN: 0486453391,
!    LC: QA299.3.D28.
!
!  Parameters:
!
!    Input, delegate IntegratingFunction, a routine which evaluates
!           the function to be integrated, of the form:
! 
!              double func (double[] x) {
!                  // x.Length == dim_num
!                  ...      
!              }
!
!    Input, int dim_num, the spatial dimension.
!
!    Input, double[] a, b, the integration limits (a.Length = b.Length = dim_num). 
!
!    Input, int[] sub_num, the number of subintervals into
!    which the i-th integration interval (a(i), b(i)) is
!    initially subdivided.  sub_num(i) must be greater than 0 (sub_num.Length = dim_num).
!
!    Input, int it_max, the maximum number of iterations to
!    be performed.  The number of function evaluations on
!    iteration j is at least Math.Pow(j,dim_num), which grows very rapidly.
!    it_max should be small!
!
!    Input, double tol, an error tolerance for the approximation
!    of the integral.
!
!    Output, int ind, error return flag.
!    ind = -1 if the error tolerance could not be achieved.
!    ind = 1 if the error tolerance was achieved.
!
!    Output, int eval_num, the number of function evaluations.
!
!  Local Parameters:
!
!    Local, int[] iwork, a pointer used to generate all the
!    points X in the product region (iwork.Length = dim_num).
!
!    Local, int[] iwork2, a counter of the number of points
!    used at each step of the Romberg iteration (iwork2.Length = it_max).
!
!    Local, int[] sub_num2, the number of subintervals used
!    in each direction, a refinement of the user's input sub_num (sub_num2.Length = dim_num).
!
!    Local, double[] table, the difference table (table.Length = it_max).
!
!    Local, double[] x, an evaluation point (x.Length = dim_num).
!
!  Returns:
!
!    double, the approximate value of the integral.
!
*/
		{
            double factor;
            int i;
            int it;
            int[] iwork = new int[dim_num];
            int[] iwork2 = new int[it_max + 1];
            int kdim;
            int ll;
            int[] sub_num2 = new int[dim_num];
            double result, result_old = 0, rnderr =0.0D, sum1, weight = 0;
            double[] table = new double[it_max + 1];
            double[] x = new double[dim_num];

            eval_num = 0;

            if (dim_num < 1)
            {
                Console.WriteLine("ROMBERG_ND - Fatal error!");
                Console.WriteLine(" DIM_NUM is less than 1.  DIM_NUM = " + dim_num);
                return -1;
            }

            if (it_max < 0)
            {
                Console.WriteLine("ROMBERG_ND - Fatal error!");
                Console.WriteLine("  IT_MAX is less than 0.  IT_MAX = " + it_max);
                return -1;
            }

            for (i = 0; i < dim_num; i++)
            {
                if (sub_num[i] <= 0)
                {
                    Console.WriteLine("ROMBERG_ND - Fatal error!");
                    Console.WriteLine("  SUB_NUM(I) is less than 1.");
                    Console.WriteLine("  for I = " + i);
                    Console.WriteLine(" SUB_NUM(I) = " + sub_num[i]);
                    return -1;
                }
            }

            ind = 0;
            //rnderr = epsilon (1.0D);
            rnderr = Math.Pow(2,-95);
            iwork2[0] = 1;

            // sub_num2(1:dim_num) = sub_num(1:dim_num)
            for (int k = 0; k < dim_num; k++)            
                sub_num2[k] = sub_num[k];
            
            
            if (0 < it_max)
                iwork2[1] = 2;
            
            it = 0;

            while (true)
            {
                sum1 = 0.0D;

                // weight = product ( ( b(1:dim_num) - a(1:dim_num) ) / real ( sub_num2(1:dim_num), kind = 8 ) )
                weight = 1.0D;;
                for (int k = 0; k < dim_num; k++)                
                    weight *= (b[k] - a[k]) / sub_num2[k];                

                //
                //  Generate every point X in the product region, and evaluate F(X).
                //
                for (int k = 0; k < dim_num; k++)
                    iwork[k] = 1;

                while (true)
                {
                    // x(1:dim_num) = ( real ( 2 * sub_num2(1:dim_num) - 2 * iwork(1:dim_num) + 1, kind = 8 ) * a(1:dim_num)  + real (+ 2 * iwork(1:dim_num) - 1, kind = 8 ) * b(1:dim_num) ) / real ( 2 * sub_num2(1:dim_num), kind = 8 )  
                    for (int k = 0; k < dim_num; k++)
                        x[k] = ((2 * sub_num2[k] - 2 * iwork[k] + 1) * a[k]  + (2 * iwork[k] - 1) * b[k]) / (2 * sub_num2[k]);  

                    sum1 += func(x);
                    eval_num += 1;

                    kdim = dim_num - 1;

                    while (0 <= kdim)
                    {
                        if (iwork[kdim] < sub_num2[kdim])
                        {
                            iwork[kdim]++;
                            break;
                        }

                        iwork[kdim] = 1;
                        kdim --;
                    }

                    if (kdim < 0) 
                        break;

                }

                //
                //  Done with summing.
                //

                table[it] = weight * sum1;

                if (it <= 0)
                {
                    result = table[0];
                    result_old = result;

                    if (it_max <= it)
                    {
                        ind = 0;
                        break;
                    }

                    it = it + 1;

                    // sub_num2(1:dim_num) = iwork2(it) * sub_num2(1:dim_num)
                    for (int k = 0; k < dim_num; k++)                    
                        sub_num2[k] *= iwork2[it];

                    continue;
                }

                //
                //  Compute the difference table for Richardson extrapolation.
                //

                for (ll = 1; ll <= it; ll++)
                {
                    i = it - ll;
                    factor = Math.Pow(iwork2[i], 2) / (Math.Pow(iwork2[it], 2) - Math.Pow(iwork2[i], 2));
                    table[i] = table[i + 1] + (table[i + 1] - table[i]) * factor;
                }

                result = table[0];

                //
                //  Terminate successfully if the estimated error is acceptable.
                //

                if (Math.Abs(result - result_old) <= Math.Abs(result * (tol + rnderr)))
                {
                    ind = 1;
                    break;
                }
                //
                //  Terminate unsuccessfully if the iteration limit has been reached.
                //
                if (it_max <= it)
                {
                    ind = -1;
                    break;
                }
                //
                //  Prepare for another step.
                //
                result_old = result;

                it++;

                iwork2[it] = (int)(1.5D * iwork2[it - 1]);

                for (int k = 0; k < dim_num; k++)
                    sub_num2[k] = (int) (1.5D * sub_num2[k]);

            }

            return result;

        }

        public static void sample_nd(IntegratingFunction func, int k1, int k2, int dim_num, ref double[] est1, ref double[] err1, ref double[] dev1, ref double[] est2, ref double[] err2, ref double[] dev2, out int eval_num)
        /*
        !*****************************************************************************80
        !
        !! SAMPLE_ND estimates a multidimensional integral using sampling.
        !
        !  Discussion:
        !
        !    This routine computes two sequences of integral estimates, EST1 
        !    and EST2, for indices K going from K1 to K2.  These estimates are 
        !    produced by the generation of 'random' abscissas in the region.  
        !    The process can become very expensive if high accuracy is needed.
        !
        !    The total number of function evaluations is
        !    4*(K1**DIM_NUM+(K1+1)**DIM_NUM+...+(K2-1)**DIM_NUM+K2**DIM_NUM), and K2
        !    should be chosen so as to make this quantity reasonable.
        !    In most situations, EST2(K) are much better estimates than EST1(K).
        !
        !  Licensing:
        !
        !    This code is distributed under the GNU LGPL license. 
        !
        !  Modified:
        !
        !    01 March 2007
        !
        !  Author:
        !
        !    Original FORTRAN77 version by Philip Davis, Philip Rabinowitz.
        !    FORTRAN90 version by John Burkardt
        !    C# version by Rafael Sales
        !
        !  Reference:
        !
        !    Philip Davis, Philip Rabinowitz,
        !    Methods of Numerical Integration,
        !    Second Edition,
        !    Dover, 2007,
        !    ISBN: 0486453391,
        !    LC: QA299.3.D28.
        !
        !  Parameters:
        !
		!    Input, delegate IntegratingFunction, a routine which evaluates
		!           the function to be integrated, of the form:
		! 
		!              double func (double[] x) {
		!                  // x.Length == dim_num
		!                  ...      
		!              }
        !
        !    Input, int k1, the beginning index for the iteration.
        !    1 <= k1 <= k2.
        !
        !    Input, int k2, the final index for the iteration.  k1 <= k2.
        !    Increasing k2 increases the accuracy of the calculation,
        !    but vastly increases the work and running time of the code.
        !
        !    Input, int dim_num, the spatial dimension.  1 <= dim_num <= 10.
        !
        !    Output, double[] est1. Entries k1 through k2 contain
        !    successively better estimates of the integral (est1.Length = k2).
        !
        !    Output, double[] err1. Entries k1 through k2 contain
        !    the corresponding estimates of the integration errors (err1.Length = k2).
        !
        !    Output, double[] dev1. Entries k1 through k2 contain
        !    estimates of the reliability of the the integration.
        !    If consecutive values dev1(k) and dev1(k+1) do not differ
        !    by more than 10 percent, then err1(k) can be taken as
        !    a reliable upper bound on the difference between est1(k)
        !    and the true value of the integral (dev1.Length = k2).
        !
        !    Output, double[] est2. Entries k2 through k2 contain
        !    successively better estimates of the integral (est2.Length = k2).
        !
        !    Output, double[] err2. Entries k2 through k2 contain
        !    the corresponding estimates of the integration errors (err2.Length = k2).
        !
        !    Output, double[] dev2.  Entries k2 through k2 contain
        !    estimates of the reliability of the the integration.
        !    If consecutive values dev2(k) and dev2(k+2) do not differ
        !    by more than 10 percent, then err2(k) can be taken as
        !    a reliable upper bound on the difference between est2(k)
        !    and the true value of the integral (dev2.Length = k2).
        !
        !    Output, int eval_num, the number of function evaluations.
        !*/
        {
            int dim_max = 10; //integer ( kind = 4 ), parameter :: dim_max = 10
            double ak;
            double ak1;
            double akn;
            double[] al = new double[] {
                   0.4142135623730950D+00,
                   0.7320508075688773D+00,
                   0.2360679774997897D+00,
                   0.6457513110645906D+00,
                   0.3166247903553998D+00,
                   0.6055512754639893D+00,
                   0.1231056256176605D+00,
                   0.3589989435406736D+00,
                   0.7958315233127195D+00,
                   0.3851648071345040D+00
            };
            double b;
            double[] be = new double[dim_num];
            double bk;
            double d1;
            double d2;
            double[] dex = new double[dim_num];
            double g;
            double[] ga = new double[dim_num];
            int key;
            bool more;
            double[] p1 = new double[dim_num];
            double[] p2 = new double[dim_num];
            double[] p3 = new double[dim_num];
            double[] p4 = new double[dim_num];
            double s1;
            double s2;
            double t;
            double y1;
            double y2;
            double y3;
            double y4;
            eval_num = 0;

            //Check input
            if (dim_num < 1)
            {
                Console.Write("SAMPLE_ND - Fatal error!");
                Console.Write("DIM_NUM must be at least 1,");
                Console.Write("but DIM_NUM = {0}", dim_num);
                return;
            }

            if (dim_max < dim_num)
            {
                Console.Write("SAMPLE_ND - Fatal error!");
                Console.Write("  DIM_NUM must be no more than DIM_MAX = {0}", dim_max);
                Console.Write("  but DIM_NUM = {0}", dim_num);
                return;
            }

            if (k1 < 0)
            {
                Console.Write("SAMPLE_ND - Fatal error!");
                Console.Write("  K1 must be at least 1, but K1 = {0}", k1);
                return;
            }

            if (k2 < k1)
            {
                Console.Write("SAMPLE_ND - Fatal error!");
                Console.Write("  K1 may not be greater than K2, but '");
                Console.Write("  K1 = {0}", k1);
                Console.Write("  K2 = {0}", k2);
                return;
            }

            Array.Copy(al, be, dim_num); //be(1:dim_num) = al(1:dim_num)
            Array.Copy(al, ga, dim_num); //ga(1:dim_num) = al(1:dim_num)
            for (int i = 0; i < dim_num; i++)
            {
                dex[i] = 0.0D; //dex(1:dim_num) = 0.0D+00
            }

            for (int k = k1; k <= k2; k++)
            {
                ak = k;
                key = 0;
                ak1 = ak - 1.1D;
                s1 = 0.0D;
                d1 = 0.0D;
                s2 = 0.0D;
                d2 = 0.0D;
                akn = Math.Pow(ak, dim_num); //akn = ak**dim_num
                t = Math.Sqrt(Math.Pow(ak, dim_num)) * ak; //t = sqrt ( ak**dim_num ) * ak
                bk = 1.0D / ak;

                while (true)
                {
                    key = key + 1;

                    if (key != 1)
                    {
                        key = key - 1;
                        more = false;

                        for (int j = 0; j < dim_num; j++)
                        {
                            if (dex[j] <= ak1)
                            {
                                dex[j] = dex[j] + 1.0D;
                                more = true;
                                break;
                            }

                            dex[j] = 0.0D;
                        }

                        if (!more)
                        {
                            break;
                        }
                    }

                    for (int i = 0; i < dim_num; i++)
                    {

                        b = be[i] + al[i];
                        if (1.0D< b)
                        {
                            b = b - 1.0D;
                        }

                        g = ga[i] + b;
                        if (1.0D < g)
                        {
                            g = g - 1.0D;
                        }

                        be[i] = b + al[i];
                        if (1.0D < be[i])
                        {
                            be[i] = be[i] - 1.0D;
                        }

                        ga[i] = be[i] + g;
                        if (1.0D < ga[i])
                        {
                            ga[i] = ga[i] - 1.0D;
                        }

                        p1[i] = (dex[i] + g) * bk;
                        p2[i] = (dex[i] + 1.0D - g) * bk;
                        p3[i] = (dex[i] + ga[i]) * bk;
                        p4[i] = (dex[i] + 1.0D - ga[i]) * bk;
                    }

                    y1 = func(p1);
                    eval_num = eval_num + 1;

                    /*  There may be an error in the next two lines, 
                     * but oddly enough, that is how the original reads
                     */
                    y3 = func(p2);
                    eval_num = eval_num + 1;
                    y2 = func(p3);
                    eval_num = eval_num + 1;
                    y4 = func(p4);
                    eval_num = eval_num + 1;
                    s1 = s1 + y1 + y2;
                    d1 = d1 + Math.Pow(y1 - y2, 2); //d1 = d1 + ( y1 - y2 )**2;
                    s2 = s2 + y3 + y4;
                    d2 = d2 + Math.Pow(y1 + y3 - y2 - y4, 2); //d2 = d2 + ( y1 + y3 - y2 - y4 )**2;
                }

                int kk = k - 1;
                est1[kk] = 0.5D * s1 / akn;
                err1[kk] = 1.5D * Math.Sqrt(d1) / akn;
                dev1[kk] = err1[kk] * t;
                est2[kk] = 0.25D * (s1 + s2) / akn;
                err2[kk] = 0.75D * Math.Sqrt(d2) / akn;
                dev2[kk] = err2[kk] * t * ak;
            }
        }
        
        public static double sum2_nd(IntegratingFunction func, double[,] xtab, double[,] weight, int[] order, int dim_num, out int eval_num)
        /*
        ! SUM2_ND estimates a multidimensional integral using a product rule.
        !
        ! Discussion:
        !
        !    The routine uses a product rule supplied by the user.
        !
        !    The region may be a product of any combination of finite,
        !    semi-infinite, or infinite intervals.
        !
        !    For each factor in the region, it is assumed that an integration
        !    rule is given, and hence, the region is defined implicitly by
        !    the integration rule chosen.
        !
        !  Licensing:
        !
        !    This code is distributed under the GNU LGPL license. 
        !
        !  Modified:
        !
        !    25 February 2007
        !
        !  Author:
        !
        !    Original FORTRAN77 version by Philip Davis, Philip Rabinowitz.
        !    FORTRAN90 version by John Burkardt
        !    C# version by Rafael Sales and Francisco Heron de Carvalho Junior (MDCC/UFC)
        !
        !  Reference:
        !
        !    Philip Davis, Philip Rabinowitz,
        !    Methods of Numerical Integration,
        !    Second Edition,
        !    Dover, 2007,
        !    ISBN: 0486453391,
        !    LC: QA299.3.D28.
        !
        !  Parameters:
        !
		!    Input, delegate IntegratingFunction, a routine which evaluates
		!           the function to be integrated, of the form:
		! 
		!              double func (double[] x) {
		!                  // x.Length == dim_num
		!                  ...      
		!              }
        !
        !    Input, double[,] xtab(dim_num,order_max). xtab(i,j) is the 
        !    i-th abscissa of the j-th rule (xtab.Length = dim_num X order_max). 
        !
        !    Input, double[,] weigth. weigth(i,j) is the 
        !    i-th weight for the j-th rule (weigth.Length = dim_num X order_max).
        !
        !    Input, int[] order.  order(i) is the number of
        !    abscissas to be used in the j-th rule. order(i) must be
        !    greater than 0 and less than or equal to order_max (order.Length = dim_num).
        !
        !    Input, int dim_num, the spatial dimension.
        !
        !    Output, int eval_num, the number of function evaluations.
        !
        !  Returns:
        ! 
        !     double, the approximate value of the integral.
        !*/
        {
            double result;
            int i;
            int[] iwork = new int[dim_num];
            int k;
            int m1;
            double w1;
            double[] work = new double[dim_num];

            //Default values:
            result = 0.0D;
            eval_num = 0;

            if (dim_num < 1)
            {
                Console.Write("SUM2_ND - Fatal error!!");
                Console.Write("  DIM_NUM < 1");
                Console.Write("  DIM_NUM = {0}", dim_num);
                return -1;
            }

            for (i = 0; i < dim_num; i++)
            {
                if (order[i] < 1)
                {
                    Console.Write("SUM2_ND - Fatal error!");
                    Console.Write("  ORDER[I] < 1.");
                    Console.Write("  For I = {0}", i);
                    Console.Write("  ORDER[I] = {0}", order[i]);
                    return -1;
                }
            }

            for (k = 0; i < dim_num; i++)
            {
                iwork[k] = 0;
            }
            while (true)
            {
                k = 0;

                w1 = 1.0D;
                for (i = 0; i < dim_num; i++)
                {
                    m1 = iwork[i];
                    work[i] = xtab[i, m1];
                    w1 = w1 * weight[i, m1];
                }

                result = result + w1 * func(work);
                eval_num = eval_num + 1;

                while (iwork[k] == order[k])
                {
                    iwork[k] = 0;
                    k = k + 1;
                    if (dim_num <= k)
                    {
                        return result;
                    };
                }
                iwork[k] = iwork[k] + 1;
            }
        }

        /* Auxiliar Methods */

        private static double[] r8vec_uniform_01(int n, ref int seed)
        /*
         ******************************************************************************
         *
         * R8VEC_UNIFORM_01 returns a unit pseudorandom R8VEC.
         *
         *  Discussion:
         *
         *    An R8VEC is a vector of real ( kind = 8 ) values.
         *
         *    For now, the input quantity SEED is an integer ( kind = 4 ) variable.
         *
         *  Licensing:
         *
         *    This code is distributed under the GNU LGPL license. 
         *
         *  Modified:
         *
         *    05 July 2006 (translated version)
         *    05 April 2010 (C# version)   
         *
         *  Author (original Fortran 90 version):
         *
         *    John Burkardt
         *
         *  Translated to C# by:
         *
         *    Francisco Heron de Carvalho Junior (MDCC/UFC)
         *    http://www.lia.ufc.br/~heron
         * 
         *  Reference:
         *
         *    Paul Bratley, Bennett Fox, Linus Schrage,
         *    A Guide to Simulation,
         *    Springer Verlag, pages 201-202, 1983.
         *
         *    Bennett Fox,
         *    Algorithm 647:
         *    Implementation and Relative Efficiency of Quasirandom
         *    Sequence Generators,
         *    ACM Transactions on Mathematical Software,
         *    Volume 12, Number 4, pages 362-376, 1986.
         *
         *    Peter Lewis, Allen Goodman, James Miller
         *    A Pseudo-Random Number Generator for the System/360,
         *    IBM Systems Journal,
         *    Volume 8, pages 136-143, 1969.
         *
         *  Parameters:
         *
         *    Input, int n, the number of entries in the vector.
         *
         *    Input/output, int seed, the "seed" value, which
         *    should NOT be 0.  On output, seed has been updated.
         *
         *  Returns:
         * 
         *    double[], the vector of pseudorandom values (length = n).
         */
        {
            int k;
            double[] r = new double[n];

            if (seed == 0)
            {
                Console.WriteLine("R8VEC_UNIFORM_01 - Fatal error!");
                Console.WriteLine("  Input value of SEED = 0.");
                return null;
            }

            for (int i = 0; i < n; i++)
            {
                k = seed / 127773;
                seed = 16807 * (seed - k * 127773) - k * 2836;
                if (seed < 0)
                    //seed = seed + huge(seed);
                    seed += int.MaxValue;

                r[i] = ((double)seed) * 4.656612875e-10D;
            }

            return r;
        }

        private static void tuple_next(int m1, int m2, int n, ref int rank, ref int[] x)
        /*
         ******************************************************************************80
         *
         ** TUPLE_NEXT computes the next element of a tuple space.
         *
         *  Discussion:
         *
         *    The elements are n vectors.  Each entry is constrained to lie
         *    between m1 and m2.  The elements are produced one at a time.
         *    The first element is
         *      (m1,m1,...,m1),
         *    the second element is
         *      (m1,m1,...,m1+1),
         *    and the last element is
         *      (m2,m2,...,m2)
         *    Intermediate elements are produced in lexicographic order.
         *
         *  Example:
         *
         *    n = 2, m1 = 1, m2 = 3
         *
         *    INPUT        OUTPUT
         *    -------      -------
         *    rank  x      rank   x
         *    ----  ---    -----  --- 
         *    0     * *    1      1 1
         *    1     1 1    2      1 2
         *    2     1 2    3      1 3
         *    3     1 3    4      2 1
         *    4     2 1    5      2 2
         *    5     2 2    6      2 3
         *    6     2 3    7      3 1
         *    7     3 1    8      3 2
         *    8     3 2    9      3 3
         *    9     3 3    0      0 0
         *
         *  Licensing:
         *
         *    This code is distributed under the GNU LGPL license. 
         *
         *  Modified:
         *
         *    18 April 2003 (translated version)
         *    05 April 2010 (C# version)   
         *
         *  Author (original Fortran 90 version):
         *
         *    John Burkardt
         *
         *  Translated to C# by:
         *
         *    Francisco Heron de Carvalho Junior (MDCC/UFC)
         *    http://www.lia.ufc.br/~heron
         *
         *  Parameters:
         *
         *    Input, int m1, m2, the minimum and maximum entries.
         *
         *    Input, int n, the number of components.
         *
         *    Input/output, int rank, counts the elements.
         *    On first call, set rank to 0. Thereafter, the output value of rank
         *    will indicate the order of the element returned.  When there are no 
         *    more elements, rank will be returned as 0.
         *
         *    Input/output, int x, on input the previous tuple. (x.Length == n)
         *    On output, the next tuple.
         *
         */
        {
            int i;

            if (m2 < m1)
            {
                rank = 0;
                return;
            }

            if (rank <= 0)
            {
                for (int k = 0; k < n; k++) x[k] = m1;
                rank = 1;
            }
            else
            {
                rank = rank + 1;

                i = n - 1;

                while (true)
                {
                    if (x[i] < m2)
                    {
                        x[i] = x[i] + 1;
                        break;
                    }

                    x[i] = m1;

                    if (i == 0)
                    {
                        rank = 0;
                        for (int k = 0; k < n; k++) x[k] = m1;
                        break;
                    }

                    i = i - 1;
                }
            }
        }
    }
}