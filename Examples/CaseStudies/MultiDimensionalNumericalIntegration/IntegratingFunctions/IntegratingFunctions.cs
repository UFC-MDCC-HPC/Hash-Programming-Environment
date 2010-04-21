using System;
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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

        public static double[] p09_f(double[,] x)
        {
            //TODO
            return null;
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
			!    03 June 2007
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
		
		public static double[] p15_f(double[,] x, int n)
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
			!    03 June 2007
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
			//int n = 1;
			//call p15_i4 ( 'G', 'N', n )
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1;
            double[] value = new double[point_num];
			int fraction = n / dim_num;
			int remainder = n - fraction * dim_num;

            for (int point = 0; point < point_num; point++)
            {					
                value[point] = 1.0D;
				bool anyZero = false;

				for (int j = 0; j <= x.GetUpperBound(1); j++)
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

        public static double[] pxx_f(double[,] x)
        {
            int point_num = x.GetUpperBound(0) + 1;
            int dim_num = x.GetUpperBound(1) + 1; ;
            double[] value = new double[point_num];

            for (int point = 0; point < point_num; point++)
            {
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += x[point, i];
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