using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.BackSubstitute;

namespace impl.bt.solve.XBackSubstitute { 

public class IXBackSubstituteImpl<I, C, DIR, MTH> : BaseIXBackSubstituteImpl<I, C, DIR, MTH>, IBackSubstitute<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IX
where MTH:IBeamWarmingMethod
{

public IXBackSubstituteImpl() { 

} 

public override void compute() { 
	;

} // end activate method 

}

}
