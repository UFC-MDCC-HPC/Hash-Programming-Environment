using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.BackSubstitute;

namespace impl.bt.solve.YBackSubstitute { 

public class IYBackSubstituteImpl<I, C, DIR, MTH> : BaseIYBackSubstituteImpl<I, C, DIR, MTH>, IBackSubstitute<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IY
where MTH:IBeamWarmingMethod
{

public IYBackSubstituteImpl() { 

} 

public override void compute() { 
	;

} // end activate method 

}

}
