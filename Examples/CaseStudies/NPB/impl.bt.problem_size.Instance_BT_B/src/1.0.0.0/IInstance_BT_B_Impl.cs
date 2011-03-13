using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class_B;
using common.problem_size.Instance;

namespace impl.bt.problem_size.Instance_BT_B { 

public class IInstance_BT_B_Impl<C> : BaseIInstance_BT_B_Impl<C>, IInstance_BT<C>
        where C:IClass_B
{

public IInstance_BT_B_Impl() { 

}

private int _problem_size = 102;
private int _niter_default = 200;
private	double _dt_default = 0.0003;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.B;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		

private	double[] _xcrref_ = {1.4233597229287254E+03d, 9.9330522590150238E+01d, 3.5646025644535285E+02d, 3.2485447959084092E+02d, 3.2707541254659363E+03d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {5.2969847140936856E+01d, 4.4632896115670668E+00d, 1.3122573342210174E+01d, 1.2006925323559144E+01d, 1.2459576151035986E+02d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = .0003;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }

}

}
