using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.Solve;

namespace impl.bt.solve.ZSolve { 

public class IZSolveImpl<I, C, DIR, MTH> : BaseIZSolveImpl<I, C, DIR, MTH>, ISolve<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IZ
where MTH:IBeamWarmingMethod
{

public IZSolveImpl() { 

} 

public override void compute() { 

} // end activate method 

}

}
