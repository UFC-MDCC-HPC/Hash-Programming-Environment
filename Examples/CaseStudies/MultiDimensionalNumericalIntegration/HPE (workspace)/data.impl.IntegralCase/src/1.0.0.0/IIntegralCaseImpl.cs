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
		public Object createNew() {
		    IIntegralCaseImpl<F> ic = new IIntegralCaseImpl<F>();
		    ic.a_ = a_;
		    ic.b_ = b_;
		    ic.function = function;		    
		    return ic;
		}
		
	   private double[] a_ = null;
       private double[] b_ = null;

       const int UNDEFINED = 0;
       
       private int dim_num_ = UNDEFINED;
       public int dim_num { 
          get { return dim_num_; }
          set { 
             dim_num_ = value;
             a_ = new double[dim_num_];
             b_ = new double[dim_num_];
             for (int i=0; i < dim_num_; i ++) {
                a_[i] = 0.0D;
                b_[i] = 1.0D;
             }              
          } 
       }
       
       public double[] a {
          get { return a_; }       
       }
       
       public double[] b {
          get { return b_; }
       }

/*       public double[] a { 
          get {
             if (a_ == null) {          
                if (dim_num > UNDEFINED) {	             
	               a_ = new double[dim_num];
	            } else 
	            {
                   throw new Exception("dim_num undefined.");
                }          
             } 
             return a_; 
          } 
       }
       public double[] b { 
          get { 
             if (b_ == null) {
                 if (dim_num > UNDEFINED) {
	                b_ = new double[dim_num];
	             } else {
                    throw new Exception("dim_num undefined.");
                 }
             }
             return b_; 
          } 
       } */
       

        public double f(double[] x)
        {        
            return function.f(x);
        }

        public IIntegralCaseImpl()
        {
           
        }


}

}
