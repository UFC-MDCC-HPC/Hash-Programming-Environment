using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function.TestingFunction;
using NINTLIB;

namespace data.impl.Function.TestingFunction { 

public class ITestingFunctionImpl : BaseITestingFunctionImpl, ITestingFunction
{

	public ITestingFunctionImpl() { 
	
	} 
	
	public Object createNew() {
	   return new ITestingFunctionImpl();
	}
	
    private static NINTLIB.MultiPointsIntegratingFunction f_ = NINTLIB.IntegratingFunctions.p33_f;

	public double f(double[] x)
	{
	     double[,] x_ = new double[1, x.Length];
	
	     int i = 0;
	     foreach (double e in x)
	           x_[0, i++] = e;
	
	
	     return f_(x_)[0];
	}

}

}
