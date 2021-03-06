using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function;
using data.IntegralCase;
using jefferson.data.Double;
using skeleton.Farm.Work.ApproximateIntegral;

namespace skeleton.impl.Farm.Work.ApproximateIntegral { 

public class IApproximateIntegralImpl<F, I, O> : BaseIApproximateIntegralImpl<F, I, O>, IApproximateIntegral<F, I, O>
where F:IFunction
where I:IIntegralCase<F>
where O:IDouble
{

public IApproximateIntegralImpl() { 

} 

public override void compute() { 
	
	double a = input_data.a;
	double b = input_data.b;	
	double fa = input_data.f(a);
	double fb = input_data.f(b);
		
    output_data.Value = approximateIntegral(a, b, fa, fb, (fa + fb)*(b-a)/2);
  
} // end activate method 

private static double abs(double x) {
   return x < 0 ? -x : x;
}

private double approximateIntegral(double a, double b, double fa, double fb, double area) 
{
	double  mid, fmid, larea, rarea, epsilon = 0.0001;
	
	mid = (a + b)/2;
	fmid = input_data.f(mid);
	larea = (fa + fmid) * (mid - a) / 2;
	rarea = (fmid + fb) * (b - mid) / 2;	
	
	if (abs((larea+rarea) - area) > epsilon) {
	   larea = approximateIntegral(a, mid, fa, fmid, larea);
	   rarea = approximateIntegral(mid, b, fmid, fb, rarea);
	}   
	
    return larea + rarea;
}

}

}
