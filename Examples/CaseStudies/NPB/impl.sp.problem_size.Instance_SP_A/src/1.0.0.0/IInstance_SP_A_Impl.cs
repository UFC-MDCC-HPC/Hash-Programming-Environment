using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class_A;

namespace impl.sp.problem_size.Instance_SP_A { 

public class IInstance_SP_A_Impl<C> : BaseIInstance_SP_A_Impl<C>, IInstance_SP<C>
		where C:IClass_A
{

public IInstance_SP_A_Impl() { 

} 
		
private int _problem_size = 64;
private int _niter_default = 400;
private	double _dt_default = .0015d;	
private char _CLASS_ = 'A';
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public char CLASS { get { return _CLASS_; } }		


}

}
