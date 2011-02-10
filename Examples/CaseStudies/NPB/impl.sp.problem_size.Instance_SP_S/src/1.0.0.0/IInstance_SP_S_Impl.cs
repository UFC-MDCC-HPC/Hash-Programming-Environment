using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_S;
using common.problem_size.Instance;

namespace impl.sp.problem_size.Instance_SP_S { 

public class IInstance_SP_S_Impl<C> : BaseIInstance_SP_S_Impl<C>, IInstance_SP<C>
		where C:IClass_S
{

public IInstance_SP_S_Impl() 
{ 
			
} 

private int _problem_size = 12;
private int _niter_default = 100;
private	double _dt_default = .015d;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.S;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		

		
private	double[] _xcrref_ = {2.7470315451339479E-2d, 1.0360746705285417E-2d, 1.6235745065095532E-2d, 1.5840557224455615E-2d, 3.4849040609362460E-2d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {2.7289258557377227E-5d, 1.0364446640837285E-5d, 1.6154798287166471E-5d, 1.5750704994480102E-5d, 3.4177666183390531E-5d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .015d;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }
		

}

}
