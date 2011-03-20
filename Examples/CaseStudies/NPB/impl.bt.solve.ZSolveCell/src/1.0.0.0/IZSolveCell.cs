using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.SolveCell;

namespace impl.bt.solve.ZSolveCell { 
	public class IZSolveCell<I, C, DIR, MTH> : BaseIZSolveCell<I, C, DIR, MTH>, ISolveCell<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IZ
	where MTH:IBeamWarmingMethod {
	
		public IZSolveCell() { 
		
		} 
		
		public override void compute() { 

		}
	}
}
