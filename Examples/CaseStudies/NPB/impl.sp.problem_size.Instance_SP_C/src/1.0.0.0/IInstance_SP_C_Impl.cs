using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_C;
using common.problem_size.Instance;


namespace impl.sp.problem_size.Instance_SP_C { 

public class IInstance_SP_C_Impl<C> : BaseIInstance_SP_C_Impl<C>, IInstance_SP<C>
		where C:IClass_C
{
public IInstance_SP_C_Impl() { 

} 
		
private int _problem_size = 162;
private int _niter_default = 400;
private	double _dt_default = .00067d;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.C;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		
		
private	double[] _xcrref_ = {0.5881691581829E+03d, 0.2454417603569E+03d, 0.3293829191851E+03d, 0.3081924971891E+03d, 0.4597223799176E+03d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {0.2598120500183d, 0.2590888922315E-01d, 0.5132886416320E-01d, 0.4806073419454E-01d, 0.5483377491301d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .00067d;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }

}

}
