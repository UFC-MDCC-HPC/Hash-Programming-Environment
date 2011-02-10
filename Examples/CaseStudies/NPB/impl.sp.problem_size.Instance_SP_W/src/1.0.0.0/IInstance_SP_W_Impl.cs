using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_W;
using common.problem_size.Instance;


namespace impl.sp.problem_size.Instance_SP_W { 

public class IInstance_SP_W_Impl<C> : BaseIInstance_SP_W_Impl<C>, IInstance_SP<C>
		where C:IClass_W
{

public IInstance_SP_W_Impl() 
{ 

} 

private int _problem_size = 36;
private int _niter_default = 400;
private	double _dt_default = .0015d;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.W ;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		
		
private	double[] _xcrref_ = {0.1893253733584E-2d, 0.1717075447775E-3d, 0.2778153350936E-3d, 0.2887475409984E-3d, 0.3143611161242E-2d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {0.7542088599534E-4d, 0.6512852253086E-5d, 0.1049092285688E-4d, 0.1128838671535E-4d, 0.1212845639773E-3d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .0015;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }
		
}

}
