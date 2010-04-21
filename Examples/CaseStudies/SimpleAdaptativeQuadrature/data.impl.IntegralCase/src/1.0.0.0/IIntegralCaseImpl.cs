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

       public double a { set { xinf.Value = value; } get { return xinf.Value; } }
        public double b { set { xsup.Value = value; } get { return xsup.Value; } }

        public double f(double x)
        {
            return function.f(x);
        }

        public IIntegralCaseImpl()
        {

        }


}

}
