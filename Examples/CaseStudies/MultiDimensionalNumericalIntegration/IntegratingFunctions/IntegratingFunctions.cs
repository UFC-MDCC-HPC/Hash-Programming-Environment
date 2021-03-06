﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace NINTLIB
{
    public class IntegratingFunctions
    {
        // http://people.sc.fsu.edu/~burkardt/f_src/test_nint/test_nint.html

        public static double[] p01_f(double[,] x)
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
        !    17 April 2010
        !
        !  Author:
        !
        !    John Burkardt (original Fortran 90)
        !    Francisco Heron de Carvalho Junior (translation to C#)
        !
        !  Parameters:
        !
        !    Input, double[,] x (x.Length = DIM_NUM * POINT_NUM), the evaluation points.
        !
        !  Returns:
        !
        !    Output, double[] value (value.Length == point_num), the function values.
        !
             */


            int dim_num = x.GetUpperBound(1) + 1; ;
            int point_num = x.GetUpperBound(0) + 1;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = ( sum ( x(1:dim_num,point) ) )**2
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += x[point,i];
                }
                value[point] = Math.Pow(value[point], 2);
            }
            return value;
        }
		
		public static double[] p02_f(double[,] x)
		{
			/*!*****************************************************************************80
			!
			!! P02_F evaluates the integrand for problem 02.
			!
			!  Discussion:
			!
			!    The spatial dimension DIM_NUM arbitrary.
			!
			!  Region:
			!
			!    0 <= X(1:DIM_NUM) <= 1
			!
			!  Integrand:
			!
			!    ( sum ( 2 * x(1:dim_num) - 1 ) )**4
			!
			!  Exact Integral:
			!
			!    DIM_NUM * (5*DIM_NUM-2) / 15
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
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
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
			
			int point_num = x.GetUpperBound(0) + 1;
			int dim_num = x.GetUpperBound(1) + 1;
			
			double[] value = new double[point_num];
			
			for (int point = 0; point < point_num; point++)
			{
				//value(point) = ( sum ( 2.0D+00 * x(1:dim_num,point) - 1.0D+00 ) )**4
				double sum = 0.0D;
				for (int i = 0; i < dim_num; i++)
				{
				    sum += 2.0D * x[i, point] - 1.0D;
				}
				value[point] = Math.Pow(sum, 4);
			}
			
			return value;
		}
		
		public static double[] p03_f(double[,] x)
		{
			/*
			!*****************************************************************************80
			!
			!! P03_F evaluates the integrand for problem 03.
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
			!    ( sum ( 2 * x(1:dim_num) - 1 ) )**5
			!
			!  Exact Integral:
			!
			!    0
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
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
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
			int dim_num = x.GetUpperBound(1) + 1;
			int point_num = x.GetUpperBound(0) + 1;
			double[] value = new double[point_num];

			for (int point = 0; point < point_num; point++)
			{
				//value(point) = ( sum ( 2.0D+00 * x(1:dim_num,point) - 1.0D+00 ) )**5
				double sum = 0.0D;
				for (int i = 0; i < dim_num; i++)
				{
                    sum += 2.0D * x[point,i] - 1.0D;
				}
				value[point] = Math.Pow(sum, 5);
            }
			return value;
		}

        public static double[] p04_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P04_F evaluates the integrand for problem 04.
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
			!    ( sum ( 2 * x(1:dim_num) - 1 ) )**6
			!
			!  Exact Integral:
			!
			!    DIM_NUM * ( 7 * (DIM_NUM-1) * (5*DIM_NUM-1) + 9 ) / 63
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
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
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = ( sum ( 2.0D+00 * x(1:dim_num,point) - 1.0D+00 ) )**6
                double sum = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    sum += 2.0D * x[point, i] - 1.0D;
                }
                value[point] = Math.Pow(sum, 6);
            }
            return value;
        }

        public static double[] p05_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P05_F evaluates the integrand for problem 05.
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
			!    2**DIM_NUM / ( 1 + sum ( 2 * x(1:dim_num) ) )
			!
			!  Exact Integral:
			!
			!    For DIM_NUM = 1:
			!
			!      ln ( 3 )
			!
			!    For DIM_NUM = 2:
			!
			!      ln ( 3125 / 729 )
			!
			!    For DIM_NUM = 3:
			!
			!      0.5 * ( 49 * ln ( 7 ) - 75 * ln ( 5 ) + 27 * ln ( 3 ) )
			! 
			!    For DIM_NUM = 4:
			!
			!      225 * ln ( 3 ) + 125 * ln ( 5 ) - 686 * ln ( 7 ) / 3
			!
			!    For DIM_NUM = 5:
			!
			!      ( -65205 * ln ( 3 ) - 6250 * ln ( 5 ) + 24010 * ln ( 7 ) 
			!      + 14641 * ln ( 11 ) ) / 24
			!
			!  Approximate Integral:
			!
			!    DIM_NUM  VALUE
			!
			!       1  1.098612289
			!       2  1.455514830
			!       3  2.152142833
			!       4  3.402716587
			!       5  5.620255523
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Arthur Stroud,
			!    Approximate Calculation of Multiple Integrals,
			!    Prentice Hall, 1971,
			!    ISBN: 0130438936,
			!    LC: QA311.S85.
			!
			!    Arthur Stroud, Don Secrest,
			!    Gaussian Quadrature Formulas,
			!    Prentice Hall, 1966,
			!    LC: QA299.4G3S7.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = 2.0D+00**dim_num / ( 1.0D+00 + sum ( 2.0D+00 * x(1:dim_num,point) ) )
                double sum = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    sum += x[point, i];
                }
                value[point] = Math.Pow(2.0D, dim_num) / (1.0D + 2.0D * sum);
            }
            return value;
        }

        public static double[] p06_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P06_F evaluates the integrand for problem 06.
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
			!    product ( 2 * abs ( 2 * x(1:dim_num) - 1 ) )
			!
			!  Exact Integral:
			!
			!    1
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Paul Bratley, Bennett Fox, Harald Niederreiter,
			!    Implementation and Tests of Low-Discrepancy Sequences,
			!    ACM Transactions on Modeling and Computer Simulation,
			!    Volume 2, Number 3, pages 195-213, 1992.
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
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = product ( 2.0D+00 * abs ( 2.0D+00 * x(1:dim_num,point) - 1.0D+00 ) )
                value[point] = 1.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] *= 2.0D * Math.Abs(2.0D * x[point, i] - 1.0D);
                }
            }
            return value;
        }

        public static double[] p07_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P07_F evaluates the integrand for problem 07.
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
			!    product ( pi / 2 ) * sin ( pi * x(1:dim_num) )
			!
			!  Exact Integral:
			!
			!    1
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
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
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = product ( 0.5D+00 * pi * sin ( pi * x(1:dim_num,point) ) )
                value[point] = 1.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] *= 0.5D * Math.PI * Math.Sin(Math.PI * x[point, i]);
                }
            }
            return value;
        }

        public static double[] p08_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P08_F evaluates the integrand for problem 08.
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
			!    ( sin ( (pi/4) * sum ( x(1:dim_num) ) ) )**2
			!
			!  Exact Integral:
			!
			!    1/2 - sqrt ( 2**(3*DIM_NUM) ) * cos ( DIM_NUM * pi / 4 ) ) 
			!      / ( 2 * pi**DIM_NUM )
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Richard Crandall,
			!    Projects in Scientific Computing,
			!    Springer, 2000,
			!    ISBN: 0387950095,
			!    LC: Q183.9.C733.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = ( sin ( pi * sum ( x(1:dim_num,point) ) / 4.0D+00 ) )**2
                double sum = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    sum += x[point, i];
                }
                value[point] = Math.Pow(Math.Sin(Math.PI * sum / 4.0D), 2);
            }
            return value;
        }

        public static double[] p09_f(double[,] x, double[] c)
		/*!*****************************************************************************80
		!
		!! P09_F evaluates the integrand for problem 09.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integral depends on a parameter vector C(1:N).
		!
		!    The reference suggests choosing C at random in [0,1]
		!    and then multiplying by the normalizing factor (60/N).
		!
		!    To get or set C, call P09_R8VEC.
		!
		!    The default value of C(1:N) is 1/N.
		!
		!  Integrand:
		!
		!    exp ( sum ( c(1:dim_num) * x(1:dim_num) ) )
		!
		!  Exact Integral:
		!
		!    product ( ( exp ( c(1:n) - 1 ) / c(1:n) )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Thomas Patterson,
		!    [Integral #7]
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
        {
			int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}

            for (int point = 0; point < point_num; point++)
            {
				//value(point) = exp ( dot_product ( c(1:dim_num), x(1:dim_num,point) ) )
				double dot_product = 0.0D;
	            for (int dim = 0; dim < dim_num; dim++)
	            {
					dot_product += c[dim] * x[point, dim];
				}
				value[point] = Math.Exp(dot_product);
            }
            return value;
        }

        public static double[] p10_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P10_F evaluates the integrand for problem 10.
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
			!    sum ( abs ( x(1:dim_num) - 0.5 ) )
			!
			!  Exact Integral:
			!
			!    DIM_NUM / 4
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
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
			!    Thomas Patterson,
			!    [Integral #4],
			!    On the Construction of a Practical Ermakov-Zolotukhin 
			!    Multiple Integrator,
			!    in Numerical Integration: Recent Developments, Software
			!    and Applications,
			!    edited by Patrick Keast, Graeme Fairweather,
			!    D. Reidel, 1987, pages 269-290,
			!    LC: QA299.3.N38.
			!
			!    Arthur Stroud,
			!    Approximate Calculation of Multiple Integrals,
			!    Prentice Hall, 1971,
			!    ISBN: 0130438936,
			!    LC: QA311.S85.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = sum ( abs ( x(1:dim_num,point) - 0.5D+00 ) )
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += Math.Abs(x[point, i] - 0.5D);
                }
            }
            return value;
        }

        public static double[] p11_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P11_F evaluates the integrand for problem 11.
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
			!    exp ( sum ( abs ( 2 * X(1:DIM_NUM) - 1 ) ) )
			!
			!  Exact Integral:
			!
			!    ( E - 1.0 )**DIM_NUM
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Thomas Patterson,
			!    [Integral #2],
			!    On the Construction of a Practical Ermakov-Zolotukhin 
			!    Multiple Integrator,
			!    in Numerical Integration: Recent Developments, Software
			!    and Applications,
			!    edited by Patrick Keast and Graeme Fairweather,
			!    D. Reidel, 1987, pages 269-290,
			!    LC: QA299.3.N38.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!
			*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = exp (sum ( abs ( 2.0D+00 * x(1:dim_num,point) - 1.0D+00 ) ) )
                double sum = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    sum += Math.Abs(2.0D * x[point, i] - 1.0D);
                }
                value[point] = Math.Exp(sum); ;
            }
            return value;
        }

        public static double[] p12_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P12_F evaluates the integrand for problem 12.
			!
			!  Discussion:
			!
			!    The highly oscillatory nature of the integrand makes this
			!    a difficult and perhaps even dubious test.
			!
			!    The spatial dimension DIM_NUM is arbitrary.
			!
			!  Region:
			!
			!    0 <= X(1:DIM_NUM) <= 1
			!
			!  Integrand:
			!
			!    product ( 1 <= i <= dim_num ) ( i * cos ( i * x(i) ) )
			!
			!  Exact Integral:
			!
			!    product ( 1 <= I <= DIM_NUM ) sin ( i )
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Paul Bratley, Bennett Fox, Harald Niederreiter,
			!    Implementation and Tests of Low-Discrepancy Sequences,
			!    ACM Transactions on Modeling and Computer Simulation,
			!    Volume 2, Number 3, July 1992, pages 195-213.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                //value(point) = value(point) * real ( dim, kind = 8 ) * cos ( real ( dim, kind = 8 ) * x(dim,point) )
                value[point] = 1.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
                    value[point] = value[point] * dim * Math.Cos(dim * x[point, dim]);
                }
            }
            return value;
        }

        public static double[] p13_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P13_F evaluates the integrand for problem 13.
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
			!    product ( 1 <= i <= dim_num ) t(n(i))(2*x(i)-1)
			!
			!    where T(N)(X) is the Chebyshev polynomial of order N,
			!    and N(I) = mod ( i, 4 ) + 1.
			!
			!  Exact Integral:
			!
			!    0
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Paul Bratley, Bennett Fox, Harald Niederreiter,
			!    Implementation and Tests of Low-Discrepancy Sequences,
			!    ACM Transactions on Modeling and Computer Simulation,
			!    Volume 2, Number 3, July 1992, pages 195-213.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                value[point] = 1.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
                    int k = dim % 4;
                    double t = 2.0D * x[point, dim] - 1.0D;
                    double factor = 0.0D; //TODO Não há inicialização
                    if (k == 1) {
                        factor = t;
                    } else if (k == 2) {
                        factor = 2.0D * t - 1.0D;
                    } else if (k == 3) {
                        factor = (4.0D * t - 3.0D) * t;
                    } else if (k == 4) { //TODO k poderá ser 4?
                        //TODO Sempre resulta em 1.0?
                        factor = (8.0D * t - 8.0D * t + 1.0D);
                    }
                    value[point] = value[point] * factor;
                }
            }
            return value;
        }

        public static double[] p14_f(double[,] x)
			/*!*****************************************************************************80
			!
			!! P14_F evaluates the integrand for problem 14.
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
			!    sum ( 1 <= i <= dim_num ) (-1)**i * product ( 1 <= j <= i ) x(j)
			!
			!  Exact Integral:
			!
			!    -1/3 ( 1 - (-1/2)**DIM_NUM )
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Reference:
			!
			!    Paul Bratley, Bennett Fox, Harald Niederreiter,
			!    Implementation and Tests of Low-Discrepancy Sequences,
			!    ACM Transactions on Modeling and Computer Simulation,
			!    Volume 2, Number 3, July 1992, pages 195-213.
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                double factor = 1.0D;
                value[point] = 0.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
                    factor = -factor * x[point, dim];
                    value[point] += factor;
                }
            }
            return value;
        } 
		
		public static double[] p15_f(double[,] x, int? pN)
			/*!*****************************************************************************80
			!
			!! P15_F evaluates the integrand for problem 15.
			!
			!  Discussion:
			!
			!    The spatial dimension DIM_NUM is arbitrary.
			!
			!  Region:
			!
			!    0 <= X(1:DIM_NUM) <= 1
			!
			!  Integral Parameters:
			!
			!    N determines the order of the product.  It defaults to 1.
			!    You can modify N by calling P15_I4.
			!
			!  Integrand:
			!
			!    f(x) = product ( 1 <= I <= N ) X(MOD(I-1,DIM_NUM)+1)
			!
			!  Exact integral:
			!
			!    product ( 1 / exponent(1:DIM_NUM) )
			!
			!    where, if I <= N - DIM_NUM * ( N/DIM_NUM),
			!    
			!      exponent ( I ) = ( N / dim_num ) + 2 
			!
			!    else
			!
			!      exponent ( I ) = ( N / dim_num ) + 1
			!
			!  Licensing:
			!
			!    This code is distributed under the GNU LGPL license. 
			!
			!  Modified:
			!
			!    25 April 2010
			!
			!  Author:
			!
			!    John Burkardt
			!    Rafael de Castro Dantas Sales (translation to C#)
			!
			!  Parameters:
			!
			!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
			!
			!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
			!
			!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
			!
			!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
			!*/
        {
			//call p15_i4 ( 'G', 'N', n )
			//Default value of n is 1:
			int n = (pN == null) ? 1 : (int)pN;
			
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			int fraction = n / dim_num;
			int remainder = n - fraction * dim_num;

            for (int point = 0; point < point_num; point++)
            {					
                value[point] = 1.0D;
				bool anyZero = false;

				for (int j = 0; j < dim_num; j++)
				{
					if (x[point,j] == 0.0D)
					{
						anyZero = true;
						break;
					}
				}
				
				if (anyZero)
				{
					value[point] = 0.0D;
				}
				else
				{
					for (int dim = 0; dim < dim_num; dim++)
	                {
						if (dim + 1 <= remainder)
						{
							value[point] = value[point] * Math.Pow(x[point, dim], (fraction + 1));
						}
						else if (fraction != 0)
						{
							value[point] = value[point] * Math.Pow(x[point, dim], fraction);
						}
	                }
				}
                
            }
            return value;
        }
		
		public static double[] p16_f(double[,] x, double[] z)
		/*!*****************************************************************************80
		!
		!! P16_F evaluates the integrand for problem 16.
		!
		!  Discussion:
		!
		!    The integrand can be regarded as the L1 norm of X - Z.
		!
		!    It would be nice to allow the use to specify several
		!    base points Z, to make the function more jagged more places!
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integrand can be regarded as the L1 norm of X - Z.
		!
		!    There is a basis point Z associated with the integrand.
		!    Z(1:DIM_NUM) defaults to ( 0.5, 0.5, ..., 0.5 ).
		!    The user can set, get, or randomize this value by calling
		!    P16_R8VEC.
		!
		!  Integrand:
		!
		!    sum ( abs ( x(1:dim_num) - z(1:dim_num) ) )
		!
		!  Exact Integral:
		!
		!    The integral is separable into
		!
		!       Int ( A(1) <= X(1) <= B(1) ) abs ( X(1) - Z(1) ) 
		!     * Product ( B(1:N)-A(1:N), skip index 1 )
		!     + Int ( A(2) <= X(2) <= B(2) ) abs ( X(2) - Z(2) )
		!     * Product ( B(1:N)-A(1:N), skip index 2 )
		!     ...
		!     + Int ( A(N) <= X(N) <= B(N) ) abs ( X(N) - Z(N) )
		!     * Product ( B(1:N)-A(1:N), skip index N )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (z == null) {
				z = new double[dim_num];
				double defaultZ = 0.5D;
				for (int i = 0; i < dim_num; i++) {
					z[i] = defaultZ;
				}
			}

            for (int point = 0; point < point_num; point++)
            {
				//value(point) = sum ( abs ( x(1:dim_num,point) - z(1:dim_num) ) )
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += Math.Abs(x[point, i] - z[i]);
                }
            }
            return value;
        }
		
		public static double[] p17_f(double[,] x, double[] z)
		/*!*****************************************************************************80
		!
		!! P17_F evaluates the integrand for problem 17.
		!
		!  Discussion:
		!
		!    This integrand can be regarded as the square of the L2
		!    norm of X - Z.
		!
		!    This integrand has the advantage of symmetry under rotation
		!    about Z.  Thus, it is possible to test whether a particular
		!    quadrature rule has an occasional advantage because it
		!    "lines up" with the X and Y coordinate axes and hence can
		!    integrate some separable integrals very well.
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    There is a basis point Z associated with the integrand.
		!    Z(1:DIM_NUM) defaults to ( 0.5, 0.5, ..., 0.5 ).
		!    The user can set, get, or randomize this value by calling
		!    P17_R8VEC.
		!
		!  Integrand:
		!
		!    sum ( ( x(1:dim_num) - z(1:dim_num) )**2 )
		!
		!  Exact Integral:
		!
		!    The integral may be broken into the sum of weighted 
		!    one dimensional integrals.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (z == null) {
				z = new double[dim_num];
				double defaultZ = 0.5D;
				for (int i = 0; i < dim_num; i++) {
					z[i] = defaultZ;
				}
			}

            for (int point = 0; point < point_num; point++)
            {
				//value(point) = sum ( ( x(1:dim_num,point) - z(1:dim_num) )**2 )
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += Math.Pow(x[point, i] - z[i], 2);
                }
            }
            return value;
        }
		
		public static double[] p18_f(double[,] x, double[] z, double? r)
		/*!*****************************************************************************80
		!
		!! P18_F evaluates the integrand for problem 18.
		!
		!  Discussion:
		!
		!    This is the characteristic function of the interior of the 
		!    N sphere of radius R and center Z, to be integrated within the
		!    unit hypercube [0,1]^N.  If the user picks a combination of R
		!    and Z that causes the volume of the sphere to lie at least
		!    partially outside the unit hypercube, the formula for the
		!    exact integral will no longer be correct.
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    R defaults to 0.50.  
		!    You can change R by calling P18_R8.
		!
		!    Z(1:DIM_NUM) defaults to (0.5,0.5,...0.5).  
		!    You can change Z by calling P18_R8VEC.
		!
		!  Integrand:
		!
		!    f(x) = 1 if X(1:DIM_NUM) is less than R from Z(1:DIM_NUM),
		!           0 otherwise.
		!
		!  Exact Integral:
		!
		!    The volume of the DIM_NUM sphere of radius R.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueR = (r == null) ? 0.5D : (double) r;
			
			if (z == null) {
				z = new double[dim_num];
				double defaultZ = 0.5D;
				for (int i = 0; i < dim_num; i++) {
					z[i] = defaultZ;
				}
			}

            for (int point = 0; point < point_num; point++)
            {
				//d = sqrt ( sum ( ( x(1:dim_num,point) - z(1:dim_num) )**2 ) )
				double d = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    d += Math.Pow(x[point, i] - z[i], 2);
                }
				d = Math.Sqrt(d);

			    if ( d <= valueR ) {
			      value[point] = 1.0D;
			    } else {
			      value[point] = 0.0D;
				}
            }
            return value;
        }
		
		public static double[] p19_f(double[,] x, double[] z)
		/*!*****************************************************************************80
		!
		!! P19_F evaluates the integrand for problem 19.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    Z defaults to (1/3,1/3,...,1/3).  
		!    You can reset Z by calling P19_R8VEC.
		!
		!  Integrand:
		!
		!    f(x) = product ( sqrt ( abs ( x(1:dim_num) - z(1:dim_num) ) ) )
		!
		!  Exact Integral:
		!
		!    With Z as given, 
		!
		!      (2/3)**DIM_NUM * ( (2/3)**(3/2) + (1/3)**(3/2) )**DIM_NUM
		!
		!    or approximately 0.49**DIM_NUM.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Arnold Krommer, Christoph Ueberhuber,
		!    Numerical Integration on Advanced Systems,
		!    Springer, 1994,
		!    ISBN: 3540584102,
		!    LC: QA299.3.K76.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (z == null) {
				z = new double[dim_num];
				double defaultZ = 0.5D;
				for (int i = 0; i < dim_num; i++) {
					z[i] = defaultZ;
				}
			}

            for (int point = 0; point < point_num; point++)
            {
				//value(point) = product ( sqrt ( abs ( x(1:dim_num,point) - z(1:dim_num) ) ) )
                value[point] = 1.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] *= Math.Sqrt(Math.Abs(x[point, i] - z[i]));
                }
            }
            return value;
        }
		
		public static double[] p20_f(double[,] x, double? p)
		/*!*****************************************************************************80
		!
		!! P20_F evaluates the integrand for problem 20.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    A <= X(1:DIM_NUM) <= B
		!
		!  Integrand:
		!
		!    f(x) = ( sum ( x(1:dim_num) ) )**p
		!
		!    P is greater than -dim_num, and is not a negative integer.
		!
		!  Exact Integral:
		!
		!    sum ( 0 <= i <= dim_num ) (-1)**i * choose(dim_num,i) 
		!      * ((dim_num-i)*b+i*a)**(dim_num+p)
		!      / ( (t+1) * (t+2) * ... * (t+dim_num) )
		!
		!  Parameters:
		!
		!    A defaults to 0.0.  You can change A by calling P20_R8.
		!
		!    B defaults to 1.0.  You can change B by calling P20_R8.
		!
		!    P defaults to 2.0.  You can change P by calling P20_R8.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
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
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueP = (p == null) ? 2.0D : (double)p;

            for (int point = 0; point < point_num; point++)
            {
				//value(point) = ( sum ( x(1:dim_num,point) ) )**p
                double sum = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    sum += x[point, i];
                }
				value[point] = Math.Pow(sum, valueP);
            }
            return value;
        }
		
		public static double[] p21_f(double[,] x, double? c, double[] e)
		/*!*****************************************************************************80
		!
		!! P21_F evaluates the integrand for problem 21.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    The (surface of the) unit sphere
		!
		!  Integral Parameters:
		!
		!    C defaults to 1.  
		!    Call P21_R8 to get or set this value.
		!
		!    E(1:DIM_NUM) defaults to (/ 2, 2, ..., 2 /).  
		!    Call P21_I4VEC to get or set this value.
		!
		!  Integrand:
		!
		!    F(X) = C * X1^E1 * X2^E2 * ... * Xn^En
		!
		!    C is real, all exponents E are nonnegative integers.
		!
		!  Exact Integral:
		!
		!    0, if any exponent is odd.
		!    2 * C * Gamma((E1+1)/2) * Gamma((E2+1)/2) * ... * Gamma((En+1)/2) 
		!      / Gamma( (E1+E2+...+En+N)/2 ), otherwise.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
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
		!    Gerald Folland,
		!    How to Integrate a Polynomial Over a Sphere,
		!    American Mathematical Monthly, 
		!    May 2001, pages 446-448.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueC = (c == null) ? 1.0D : (double)c;

			if (e == null) {
				e = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					e[i] = 2.0D;
				}
			}
			for (int i = 0; i < point_num; i++) {
				value[i] = valueC;
			}
			
            for (int dim = 0; dim < dim_num; dim++)
            {
				//value(1:point_num) = value(1:point_num) * x(dim,1:point_num)**e(dim)
                for (int point = 0; point < point_num; point++)
                {
					value[point] = value[point] * Math.Pow(x[point, dim], e[dim]);
				}
            }
            return value;
        }
		
		public static double[] p22_f(double[,] x, double? c, double[] e)
		/*!*****************************************************************************80
		!
		!! P22_F evaluates the integrand for problem 22.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    The interior of a sphere of radius R centered at the origin.
		!
		!  Integral Parameters:
		!
		!    C defaults to 1.0.  
		!    Call P22_R8 to get or set this value.
		!
		!    R defaults to 1.0.  
		!    Call P22_R8 to get or set this value.
		!
		!    E(1:DIM_NUM) defaults to (/ 2, 2, ..., 2 /).  
		!    Call P22_I4VEC to get or set this value.
		!
		!  Integrand:
		!
		!    F(X) = C * X1^E1 * X2^E2 * ... * Xn^En
		!
		!    C is real, all exponents E are nonnegative integers.
		!
		!  Exact Integral:
		!
		!    0, if any exponent is odd.
		!    2 * C * R^(E1+E2+...+EN+N) 
		!      * Gamma((E1+1)/2) * Gamma((E2+1)/2) * ... * Gamma((En+1)/2) 
		!      / ( Gamma( (E1+E2+...+En+N)/2 ) * ( E1+E2+...+EN+N) ), otherwise.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
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
		!    Gerald Folland,
		!    How to Integrate a Polynomial Over a Sphere,
		!    American Mathematical Monthly, 
		!    May 2001, pages 446-448.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueC = (c == null) ? 1.0D : (double)c;

			if (e == null) {
				e = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					e[i] = 2.0D;
				}
			}
			for (int i = 0; i < point_num; i++) {
				value[i] = valueC;
			}
			
            for (int point = 0; point < point_num; point++)
            {
                for (int dim = 0; dim < dim_num; dim++)
                {
					//value(point) = value(point) * x(dim,point)**e(dim)
					value[point] = value[point] * Math.Pow(x[point, dim], e[dim]);
				}
            }
            return value;
        }
		
		public static double[] p23_f(double[,] x, double? c, double[] e)
		/*!*****************************************************************************80
		!
		!! P23_F evaluates the integrand for problem 23.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    The interior of the unit simplex, for which all X's are nonnegative,
		!    and sum ( X(1:N) ) <= 1.
		!
		!  Integral Parameters:
		!
		!    C defaults to 1.0.  
		!    Call P23_R8 to get or set this value.
		!
		!    E(1:DIM_NUM) defaults to (/ 2, 2, ..., 2 /).  
		!    Call P23_I4VEC to get or set this value.
		!
		!  Integrand:
		!
		!    F(X) = C * X1^E1 * X2^E2 * ... * Xn^En
		!
		!    C is real, all exponents E are nonnegative integers.
		!
		!  Exact Integral:
		!
		!    C * Gamma(E1+1) * Gamma(E2+1) * ... * Gamma(En+1) / Gamma(E1+E2+...+En+1)
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
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
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueC = (c == null) ? 1.0D : (double)c;

			if (e == null) {
				e = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					e[i] = 2.0D;
				}
			}
			for (int i = 0; i < point_num; i++) {
				value[i] = valueC;
			}
			
            for (int point = 0; point < point_num; point++)
            {
                for (int dim = 0; dim < dim_num; dim++)
                {
					//value(point) = value(point) * x(dim,point)**e(dim)
					value[point] = value[point] * Math.Pow(x[point, dim], e[dim]);
				}
            }
            return value;
        }
		
		public static double[] p24_f(double[,] x, double[] c)
		/*!*****************************************************************************80
		!
		!! P24_F evaluates the integrand for problem 24.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    C(1:DIM_NUM) defaults to 0.0.
		!
		!    A typical, more difficult problem, has
		!      C(I) = I**(1/3)
		! 
		!    Call P24_R8VEC to get or set C.
		!
		!  Integrand:
		!
		!    F(X) = product (   ( abs ( 4 * X(1:DIM_NUM) - 2 ) + C(1:DIM_NUM) ) 
		!                     / ( 1 + C(1:DIM_NUM) ) 
		!                   )
		!
		!  Exact Integral:
		!
		!    1
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Stephen Joe, Frances Kuo,
		!    Remark on Algorithm 659:
		!    Implementing Sobol's Quasirandom Seqence Generator,
		!    ACM Transactions on Mathematical Software,
		!    Volume 29, Number 1, March 2003, pages 49-57.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];

			if (c == null) {
				c = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					c[i] = 0.0D;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = product ( ( abs ( 4.0D+00 * x(1:dim_num,point) - 2.0D+00 ) + c(1:dim_num) ) / ( 1.0D+00 + c(1:dim_num) ) )
				value[point] = 1.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					value[point] *= (Math.Abs(4.0D * x[point, dim] - 2.0D) + c[dim]) / (1.0D + c[dim]);
				}
            }
            return value;
        }
		
		public static double[] p25_f(double[,] x, double? c)
		/*!*****************************************************************************80
		!
		!! P25_F evaluates the integrand for problem 25.
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
		!    exp ( C * product ( X(1:N) ) )
		!
		!  Parameters:
		!
		!    C defaults to 0.3, and can be changed by calling P25_R8.
		!
		!  Exact Integral:
		!
		!    sum ( 1 <= i <= Infinity ) C**i / ( ( i + 1 )**N * i! )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Thomas Patterson,
		!    [Integral #3],
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueC = (c == null) ? 0.3D : (double)c;
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = exp ( c * product ( x(1:dim_num,point) ) )
				
				double product = 1.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					product *= x[point, dim];
				}
				value[point] = Math.Exp(valueC * product);
            }
            return value;
        }
		
		public static double[] p26_f(double[,] x, double[] c)
		/*!*****************************************************************************80
		!
		!! P26_F evaluates the integrand for problem 26.
		!
		!  Discussion:
		!
		!    The integrand is similar to that for the Patterson integral #7,
		!    except for a normalization of the constants, and a (random) constant
		!    factor in the integrand.
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integral depends on a parameter vector C(1:N).
		!
		!    The reference suggests choosing C at random in [0,1].
		!    C(1:N) defaults to 1/N.
		!
		!    To get or set C, call P26_R8VEC.
		!
		!  Integrand:
		!
		!    product ( c(1:dim_num) * ( exp ( - c(1:dim_num) * x(1:dim_num) ) ) )
		!    = product ( c(1:dim_num) ) * exp ( - sum ( c(1:dim_num) * x(1:dim_num) ) )
		!
		!  Exact Integral:
		!
		!    product ( 1 - exp ( c(1:n) ) )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Thomas Patterson,
		!    [Integral #1],
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = product ( c(1:dim_num) ) * exp ( - dot_product ( c(1:dim_num), x(1:dim_num,point) ) )
				double product = 1.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					product *= c[dim];
				}
				
				double dot_product = 0.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					dot_product += c[dim] * x[point, dim];
				}
				value[point] = product * Math.Exp(-dot_product);
            }
            return value;
        }
		
		public static double[] p27_f(double[,] x, double? r, double[] c)
		/*!*****************************************************************************80
		!
		!! P27_F evaluates the integrand for problem 27.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integral depends on a parameter R and vector C(1:N).
		!
		!    R defaults to 0.3.
		!
		!    The reference suggests choosing C at random in [0,1]
		!    and then multiplying by the normalizing factor (25/N).
		!    C(1:N) defaults to 1/N.
		!
		!    To get or set R, call P27_R8.
		!    To get or set C, call P27_R8VEC.
		!
		!  Integrand:
		!
		!    cos ( 2 * pi * R + sum ( c(1:n) * x(1:n) ) )
		!
		!  Exact Integral:
		!
		!    2**N * cos ( 2 * pi * R + 0.5 * sum ( c(1:n) ) )
		!      * product ( sin ( 0.5 * c(1:n) ) / c(1:n) )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Alan Genz,
		!    [Integral #1]
		!    A Package for Testing Multiple Integration Subroutines,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D Reidel, 1987, pages 337-340,
		!    LC: QA299.3.N38.
		!
		!    Thomas Patterson,
		!    [Integral #5],
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
			int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueR = (r == null) ? 0.3 : (double)r;
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//arg = 2.0D+00 * pi * r + dot_product ( c(1:dim_num), x(1:dim_num,point) )
    			//value(point) = cos ( arg )
				double dot_product = 0.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					dot_product += c[dim] * x[point, dim];
				}
				double arg = 2.0D * Math.PI * valueR + dot_product;
				value[point] = Math.Cos(arg);
            }
            return value;
		}
		
		public static double[] p28_f(double[,] x, double[] c, double[] z)
		/*!*****************************************************************************80
		!
		!! P28_F evaluates the integrand for problem 28.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integral depends on vectors C(1:N) and Z(1:N).
		!    To get or set C or Z, call P28_R8VEC.
		!
		!    The reference suggests choosing C by initializing
		!    it to random values in [0,1], and then normalizing so that
		!
		!      sum ( 1/C(1:N)**2 ) = 170 / N**(7/2)
		!
		!    C(1:N) used to default to N**(9/4) / sqrt(170)
		!    but this is INSUPPORTABLE for large dimension N.
		!
		!    So now we're setting C(1:N) to default to 1.0
		!
		!    The reference suggests choosing Z at random in [0,1].
		!
		!    Z(1:N) defaults to 0.5.
		!
		!  Integrand:
		!
		!    1 / product ( C(1:DIM_NUM)**2 + ( X(1:DIM_NUM) - Z(1:DIM_NUM) )**2 )
		!
		!  Exact Integral:
		!
		!    product ( (   arctan ( ( 1 - Z(1:DIM_NUM) ) / C(1:DIM_NUM) )
		!                + arctan (       Z(1:DIM_NUM)   / C(1:DIM_NUM) ) 
		!              ) / C(1:DIM_NUM)
		!            )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Alan Genz,
		!    [Integral #2]
		!    A Package for Testing Multiple Integration Subroutines,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D Reidel, 1987, pages 337-340,
		!    LC: QA299.3.N38.
		!
		!    Thomas Patterson,
		!    [Integral #6],
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}
			if (z == null) {
				z = new double[dim_num];
				double defaultZ = 0.5D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					z[i] = defaultZ;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = 1.0D+00 / product ( c(1:dim_num)**2 + ( x(1:dim_num,point) - z(1:dim_num) )**2 )
				double product = 1.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					product *= Math.Pow(c[dim], 2) + Math.Pow(x[point, dim] - z[dim], 2);
				}
				value[point] = 1.0D / product;
            }
            return value;
        }
		
		public static double[] p29_f(double[,] x, double? r, double[] c)
		/*!*****************************************************************************80
		!
		!! P29_F evaluates the integrand for problem 29.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral parameters:
		!
		!    The integral depends on a parameter R,
		!    and a vector C(1:N).
		!
		!    The Genz reference uses R = 1.  The Patterson reference
		!    suggests using R = 0.3.  Note that R should NOT equal
		!    any integer value between 1-DIM_NUM and 0, otherwise the
		!    formula breaks down.  R should normally be strictly positive.
		!
		!    The Patterson reference suggests choosing C at random in [0,1]
		!    and then multiplying by the normalizing factor (80/N**2).
		!    This is what you will get if you "RANDOMIZE" C.
		!
		!    C defaults to 1/DIM_NUM.
		!
		!    To get or set R, call P29_R8.
		!    To get or set C, call P29_R8VEC.
		!
		!  Integrand:
		!
		!    1 / ( 1 + sum ( c(1:dim_num) * x(1:dim_num) ) )**(r+dim_num)
		!
		!  Exact Integral:
		!
		!    (1/A) * ( 1 / product ( c(1:dim_num) ) ) *
		!    sum(0<=I(1)<=1) sum (0<=I(2)<=1) ... sum(0<=I(dim_num)<=1)
		!    (-1)**sum(I(1:dim_num)) / ( 1 + sum ( i(1:dim_num)*c(1:dim_num) ) )**r
		!
		!    with A = r * ( r + 1 ) * ... * ( r + dim_num - 1 )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Alan Genz,
		!    [Integral #3]
		!    A Package for Testing Multiple Integration Subroutines,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D Reidel, 1987, pages 337-340,
		!    LC: QA299.3.N38.
		!
		!    Thomas Patterson,
		!    [Integral #8],
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
			int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			double valueR = (r == null) ? 0.3 : (double)r;
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = 1.0D+00 / ( 1.0D+00 + dot_product ( c(1:dim_num), x(1:dim_num,point) ) )**( r + dim_num )
				double dot_product = 0.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					dot_product += c[dim] * x[point, dim];
				}
				value[point] = 1.0D / Math.Pow(1.0D + dot_product, valueR + dim_num);
            }
            return value;
		}
		
		public static double[] p30_f(double[,] x, double[] c, double[] z)
		/*!*****************************************************************************80
		!
		!! P30_F evaluates the integrand for problem 30.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integral depends on vectors C(1:N) and Z(1:N).
		!
		!    The reference suggests choosing C at random in [0,1]
		!    and then multiplying by the normalizing factor sqrt(140/N**(3/2)).
		!
		!    C(1:N) defaults to 1/N.
		!    Z(1:N) defaults to 0.5.
		!
		!    To get or set C or Z, call P30_R8VEC.
		!
		!  Integrand:
		!
		!    exp ( - sum ( c(1:n)**2 * ( x(1:n) - z(1:n) )**2 )
		!
		!  Exact Integral:
		!
		!    product
		!    ( sqrt ( pi )
		!      * (   erf ( c(1:n) * ( 1 - z(1:n) ) ) 
		!          + erf ( c(1:n) *       z(1:n)   ) ) 
		!      / ( 2 * c(1:n) )
		!    )
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Alan Genz,
		!    [Integral #4]
		!    A Package for Testing Multiple Integration Subroutines,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D Reidel, 1987, pages 337-340,
		!    LC: QA299.3.N38.
		!
		!    Thomas Patterson,
		!    [Integral #9],
		!    On the Construction of a Practical Ermakov-Zolotukhin 
		!    Multiple Integrator,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 269-290,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
			int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}
			if (z == null) {
				z = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					z[i] = 0.5D;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = exp ( - sum ( c(1:dim_num)**2 * ( x(1:dim_num,point) - z(1:dim_num) )**2 ) )
				double sum = 0.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					sum += Math.Pow(c[dim], 2) * Math.Pow(x[point, dim] - z[dim], 2);
				}
				value[point] = - Math.Exp(-sum);
            }
            return value;
		}
		
		public static double[] p31_f(double[,] x, double[] c, double[] z)
		/*!*****************************************************************************80
		!
		!! P31_F evaluates the integrand for problem 31.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    There is a basis point Z associated with the integrand.
		!    Z(1:DIM_NUM) defaults to ( 0.5, 0.5, ..., 0.5 ).
		!    The user can set, get, or randomize this value by calling
		!    P31_R8VEC.
		!
		!    The coefficient vector C (whose entries are usually positive)
		!    controls the steepness and circularity of the pseudo-Gaussian.
		!    C(1:DIM_NUM) defaults to 2.0.
		!    The user can set, get, or randomize this value by calling
		!    P31_R8VEC.
		!
		!  Integrand:
		!
		!    exp ( - sum ( c(1:dim_num) * abs ( x(1:dim_num) - z(1:dim_num) ) ) )
		!
		!  Exact Integral:
		!
		!    The integral is separable into
		!
		!      Int ( A(1) <= X(1) <= B(1) ) exp ( - C(1) * abs ( X(1) - Z(1) ) ) 
		!        * Int ( A(2) <= X(2) <= B(2) ) exp ( - C(2) * abs ( X(2) - Z(2) ) )
		!          * ...
		!
		!    Hence, the exact integral is computed as the product of
		!    one dimensional integrals.  Each of these is easily computed
		!    once the location of Z(I) with respect to A(I) and B(I) is
		!    determined.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Alan Genz,
		!    [Integral #5]
		!    A Package for Testing Multiple Integration Subroutines,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D. Reidel, 1987, pages 337-340,
		!    LC: QA299.3.N38.
		!
		!    Kenneth Hanson,
		!    Quasi-Monte Carlo: halftoning in high dimensions?
		!    in Computatinal Imaging,
		!    Edited by CA Bouman and RL Stevenson,
		!    Proceedings SPIE,
		!    Volume 5016, 2003, pages 161-172.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
			int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (z == null) {
				z = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					z[i] = 0.5D;
				}
			}
			if (c == null) {
				c = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					c[i] = 2.0D;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
				//value(point) = exp ( - sum ( c(1:dim_num) * abs ( x(1:dim_num,point) - z(1:dim_num) ) ) )
				double sum = 0.0D;
                for (int dim = 0; dim < dim_num; dim++)
                {
					sum += c[dim] * Math.Abs(x[point, dim] - z[dim]);
				}
				value[point] = - Math.Exp(-sum);
            }
            return value;
		}
		
		public static double[] p32_f(double[,] x, double[] c, double[] z)
		/*!*****************************************************************************80
		!
		!! P32_F evaluates the integrand for problem 32.
		!
		!  Discussion:
		!
		!    The spatial dimension DIM_NUM is arbitrary.
		!
		!  Region:
		!
		!    0 <= X(1:DIM_NUM) <= 1
		!
		!  Integral Parameters:
		!
		!    The integral depends on vectors C(1:N) and Z(1:N).
		!
		!    The reference suggests choosing C at random in [0,1]
		!    and then multiplying by the normalizing factor sqrt(140/N**(3/2)).
		!
		!    The default value of C(1:N) is (1/2)^(1/N).
		!
		!    The default value of Z(1:N) is (1/2)^(1/N).
		!
		!  Integrand:
		!
		!    exp ( c(1:n)*x(1:n) ) if all x(1:n) <= z(1:n)
		!    0                        otherwise
		!
		!  Exact Integral:
		!
		!    product ( g(1:n)(x,z,a,b,c) )
		!
		!    where g(i)(x,z,a,b,c) =
		!
		!      0                                         if z(i) <= a(i)
		!      ( e^(c(i)*z(i) ) - e^(c(i)*a(i)) ) / c(i) if a(i) <= z(i) <= b(i)
		!      ( e^(c(i)*b(i) ) - e^(c(i)*a(i)) ) / c(i) if b(i) <= z(i)
		!      
		!    with obvious modifications when c(i) = 0.
		!
		!  Licensing:
		!
		!    This code is distributed under the GNU LGPL license. 
		!
		!  Modified:
		!
		!    25 April 2010
		!
		!  Author:
		!
		!    John Burkardt
		!    Rafael de Castro Dantas Sales (translation to C#)
		!
		!  Reference:
		!
		!    Alan Genz,
		!    [Integral #6]
		!    A Package for Testing Multiple Integration Subroutines,
		!    in Numerical Integration: Recent Developments, Software
		!    and Applications,
		!    edited by Patrick Keast and Graeme Fairweather,
		!    D Reidel, 1987, pages 337-340,
		!    LC: QA299.3.N38.
		!
		!  Parameters:
		!
		!    Input, integer ( kind = 4 ) DIM_NUM, the dimension of the argument.
		!
		!    Input, integer ( kind = 4 ) POINT_NUM, the number of points.
		!
		!    Input, real ( kind = 8 ) X(DIM_NUM,POINT_NUM), the evaluation points.
		!
		!    Output, real ( kind = 8 ) VALUE(POINT_NUM), the function values.
		!*/
		{
			int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			
			if (c == null) {
				c = new double[dim_num];
				double defaultC = 1.0D / dim_num;
				for (int i = 0; i < dim_num; i++) {
					c[i] = defaultC;
				}
			}
			if (z == null) {
				z = new double[dim_num];
				for (int i = 0; i < dim_num; i++) {
					z[i] = 0.5D;
				}
			}
			
            for (int point = 0; point < point_num; point++)
            {
//				if ( all ( x(1:dim_num,point) <= z(1:dim_num) ) ) then
//			      value(point) = exp ( dot_product ( c(1:dim_num), x(1:dim_num,point) ) )
//			    else
//			      value(point) = 0.0D+00
//			    end if
				
				bool allXLessOrEqualAllZ = true;
				for (int dim = 0; dim <= dim_num; dim++)
				{
					if (x[point,dim] <= z[dim])
					{
						allXLessOrEqualAllZ = false;
						break;
					}
				}
				
				if (allXLessOrEqualAllZ)
				{
					double dot_product = 0.0D;
	                for (int dim = 0; dim < dim_num; dim++)
	                {
						dot_product += c[dim] * x[point, dim];
					}
					value[point] = Math.Exp(dot_product);
				}
				else
				{
					value[point] = 0.0D;
				}
            }
            return value;
		}
		
        public static double[] p33_f(double[,] x)
     /* !*****************************************************************************80
        !
        !! P33_F evaluates the integrand for problem 33.
        !
        !  Discussion:
        !
        !    The spatial dimension DIM_NUM is arbitrary.
        !
        !  Region:
        !
        !    The interior of a sphere of radius 1 centered at the origin.
        !
        !  Integrand:
        !
        !    F(X) = sum ( 1 <= I <= N ) ( X(I)^2 )
        !
        !  Exact Integral:
        !
        !    N/2 * Pi^(N/2) / Gamma ( ( N + 4 ) / 2 )
        !
        !  Licensing:
        !
        !    This code is distributed under the GNU LGPL license. 
        !
        !  Modified:
        !
        !    17 April 2010
        !
        !  Author:
        !
        !    John Burkardt (original Fortran 90)
        !    Francisco Heron de Carvalho Junior (translation to C#)
        !
        !  Parameters:
        !
        !    Input, double[,] x (x.Length = DIM_NUM * POINT_NUM), the evaluation points.
        !
        !  Returns:
        !
        !    Output, double[] value (value.Length == point_num), the function values.
        !
*/
        {
            int point_num = x.GetUpperBound(0) + 1;
			int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
            for (int point = 0; point < point_num; point++)
            {
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                    value[point] += Math.Pow(x[point,i], 2);
            }
            return value;
        }
    }
}