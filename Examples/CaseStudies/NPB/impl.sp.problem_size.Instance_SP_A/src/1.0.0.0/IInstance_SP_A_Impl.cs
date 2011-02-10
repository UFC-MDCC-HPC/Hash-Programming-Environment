using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_A;
using common.problem_size.Instance;

namespace impl.sp.problem_size.Instance_SP_A { 

public class IInstance_SP_A_Impl<C> : BaseIInstance_SP_A_Impl<C>, IInstance_SP<C>
		where C:IClass_A
{

public IInstance_SP_A_Impl() { 

} 
		
private int _problem_size = 64;
private int _niter_default = 400;
private	double _dt_default = .0015d;	
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.A;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		

private	double[] _xcrref_ = {2.4799822399300195d, 1.1276337964368832d, 1.5028977888770491d, 1.4217816211695179d, 2.1292113035138280d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {1.0900140297820550E-4d, 3.7343951769282091E-5d, 5.0092785406541633E-5d, 4.7671093939528255E-5d, 1.3621613399213001E-4d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .0015d;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }

}

}
