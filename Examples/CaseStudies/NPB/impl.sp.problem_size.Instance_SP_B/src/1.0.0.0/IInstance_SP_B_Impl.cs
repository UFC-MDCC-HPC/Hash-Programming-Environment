using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_B;
using common.problem_size.Instance;
	
namespace impl.sp.problem_size.Instance_SP_B { 

public class IInstance_SP_B_Impl<C> : BaseIInstance_SP_B_Impl<C>, IInstance_SP<C>
		where C:IClass_B
{

public IInstance_SP_B_Impl() { 

} 
		
private int _problem_size = 102;
private int _niter_default = 400;
private	double _dt_default = .001d;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.B;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		

private	double[] _xcrref_ = {0.6903293579998E+02d, 0.3095134488084E+02d, 0.4103336647017E+02d, 0.3864769009604E+02d, 0.5643482272596E+02d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {0.9810006190188E-02d, 0.1022827905670E-02d, 0.1720597911692E-02d, 0.1694479428231E-02d, 0.1847456263981E-01d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .001d;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }
		

}

}
