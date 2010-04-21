using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using data.IntegralCase;

namespace data.impl.IntegralCase { 

public class IIntegralCaseImpl<F> : BaseIIntegralCaseImpl<F>, IIntegralCase<F>
where F:IFunction
{       
       private double[] a_ = null;
       private double[] b_ = null;

       const int UNDEFINED = 0;
       
       private int dim_num_ = UNDEFINED;
       public int dim_num { get { return dim_num_; } set { dim_num_ = value; } }

       public double[] a { 
          get {
             if (dim_num > UNDEFINED) {
	             if (a_ == null) {
	                a_ = new double[dim_num];
	             }          
             } else {
                throw new Exception("dim_num undefined.");
             }
             return a_; 
          } 
       }
       public double[] b { 
          get { 
             if (dim_num > UNDEFINED) {
	             if (b_ == null) {
	                b_ = new double[dim_num];
	             }
             } else {
                throw new Exception("dim_num undefined.");
             }
             return b_; 
          } 
       }
       

        public double f(double[] x)
        {
            return function.f(x);
        }

        public IIntegralCaseImpl()
        {

        }


}

}
