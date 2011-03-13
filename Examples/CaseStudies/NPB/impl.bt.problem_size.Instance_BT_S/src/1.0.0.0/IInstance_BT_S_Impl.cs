using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class_S;
using common.problem_size.Instance;

namespace impl.bt.problem_size.Instance_BT_S { 

public class IInstance_BT_S_Impl<C> : BaseIInstance_BT_S_Impl<C>, IInstance_BT<C>
        where C:IClass_S
{

public IInstance_BT_S_Impl() { 

} 

private int _problem_size = 12;
private int _niter_default = 60;
private	double _dt_default = 0.010;
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.S;

public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }

private	double[] _xcrref_ = {1.7034283709541311E-01d, 1.2975252070034097E-02d, 3.2527926989486055E-02d, 2.6436421275166801E-02d, 1.9211784131744430E-01d}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {4.9976913345811579E-04d, 4.5195666782961927E-05d, 7.3973765172921357E-05d, 7.3821238632439731E-05d, 8.9269630987491446E-04d}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = 0.01;

public double[] xcrref { get { return _xcrref_; } }
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }

}

}
