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
		private double[,,,,,] lhsc;
		private int first;
		private int last;
		private int c;
		public void setParameters(double[,,,,,] lhsc, int first, int last, int c){
			this.lhsc = lhsc;
			this.first = first;
			this.last = last;
			this.c = c;
		}
		public IZSolveCell() { 
		
		} 
		
		public override void compute() { 

		}
	}
}
