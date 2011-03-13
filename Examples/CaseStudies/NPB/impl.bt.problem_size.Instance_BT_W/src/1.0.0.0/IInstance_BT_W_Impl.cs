using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class_W;
using common.problem_size.Instance;

namespace impl.bt.problem_size.Instance_BT_W { 

public class IInstance_BT_W_Impl<C> : BaseIInstance_BT_W_Impl<C>, IInstance_BT<C>
        where C:IClass_W
{

public IInstance_BT_W_Impl() { 

}

private int _problem_size = 24;
private int _niter_default = 200;
private	double _dt_default = 0.0008;		
private PROBLEM_CLASS _CLASS_ = PROBLEM_CLASS.W ;
		
public int problem_size { get { return _problem_size; } }
public int niter_default { get { return _niter_default; } }
public double dt_default { get { return _dt_default; } }		
public PROBLEM_CLASS CLASS { get { return _CLASS_; } }		
		
private	double[] _xcrref_ = {0.1125590409344E+03, 0.1180007595731E+02, 0.2710329767846E+02, 0.2469174937669E+02, 0.2638427874317E+03}; //    Reference values of RMS-norms of residual.
private double[] _xceref_ = {0.4419655736008E+01, 0.4638531260002, 0.1011551749967E+01, 0.9235878729944, 0.1018045837718E+02}; //    Reference values of RMS-norms of solution error.
private	double _dtref_ = 0.0008;

public double[] xcrref { get { return _xcrref_; } } 
public double[] xceref { get { return _xceref_; } }
public double dtref { get { return _dtref_; } }

}

}
