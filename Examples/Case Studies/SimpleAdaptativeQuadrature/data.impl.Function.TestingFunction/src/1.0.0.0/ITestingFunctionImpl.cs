using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Function.TestingFunction;

namespace data.impl.Function.TestingFunction { 

public class ITestingFunctionImpl : BaseITestingFunctionImpl, ITestingFunction
{

public ITestingFunctionImpl() { 

} 

public double f(double[] x) {
   return x[0];
}

}

}
