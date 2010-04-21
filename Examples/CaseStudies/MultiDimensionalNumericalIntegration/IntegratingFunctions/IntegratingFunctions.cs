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
                value[point] = 0.0D;
                for (int i = 0; i < dim_num; i++)
                {
                    value[point] += Math.Pow(x[point,i], 2);
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
            int dim_num = x.GetUpperBound(1) + 1;
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

    }
}
