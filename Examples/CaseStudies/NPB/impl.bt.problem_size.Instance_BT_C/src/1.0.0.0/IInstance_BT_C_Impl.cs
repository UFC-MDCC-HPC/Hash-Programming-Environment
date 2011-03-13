using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class_C;
using common.problem_size.Instance;


namespace impl.bt.problem_size.Instance_BT_C { 

public class IInstance_BT_C_Impl<C> : BaseIInstance_BT_C_Impl<C>, IInstance_BT<C>
        where C:IClass_C
{
public IInstance_BT_C_Impl() { 

}

private int _problem_size = 162;
private int _niter_default = 200;
private	double _dt_default = 0.0001;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.C;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		
		
private	double[] _xcrref_ = {0.62398116551764615E+04d, 0.50793239190423964E+03d, 0.15423530093013596E+04d, 0.13302387929291190E+04d, 0.11604087428436455E+05d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {0.16462008369091265E+03d, 0.11497107903824313E+02d, 0.41207446207461508E+02d, 0.37087651059694167E+02d, 0.36211053051841265E+03d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .0001;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }


}

}
