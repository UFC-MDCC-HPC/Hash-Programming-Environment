using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_S;

namespace impl.sp.problem_size.Instance_SP_S { 

public class IInstance_SP_S_Impl<C> : BaseIInstance_SP_S_Impl<C>, IInstance_SP<C>
		where C:IClass_S
{

public IInstance_SP_S_Impl() { 

} 

private int _problem_size = 12;
private int _niter_default = 100;
private	double _dt_default = .015d;		
private char _CLASS_ = 'S';
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public char CLASS { get { return _CLASS_; } }		

}

}
