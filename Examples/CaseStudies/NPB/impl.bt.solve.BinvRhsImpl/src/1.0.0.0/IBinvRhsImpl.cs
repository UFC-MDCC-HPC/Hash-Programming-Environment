using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.BeamWarmingMethod;
using bt.solve.BinvRhs;

namespace impl.bt.solve.BinvRhsImpl 
{ 
	public class IBinvRhsImpl<I, C, MTH> : BaseIBinvRhsImpl<I, C, MTH>, IBinvRhs<I, C, MTH>
		where I:IInstance_BT<C>
		where C:IClass
		where MTH:IBeamWarmingMethod 
	{
		private double[,,] lhs;
		private double[,,,,] r;
		private int l1, r1, r2, r3, r4;
		
		public void setParameters(double[,,] lhs, double[,,,,] r, int l1, int r1, int r2, int r3, int r4) 
		{
			this.lhs = lhs;
			this.r = r;
			this.l1 = l1;
			this.r1 = r1;
			this.r2 = r2;
			this.r3 = r3;
			this.r4 = r4;
		}

		public override int go()   
		{ 
			double pivot, coeff;
			
			pivot = 1.00d / lhs[l1, 0, 0];
			lhs[l1, 1, 0] = lhs[l1, 1, 0] * pivot;
			lhs[l1, 2, 0] = lhs[l1, 2, 0] * pivot;
			lhs[l1, 3, 0] = lhs[l1, 3, 0] * pivot;
			lhs[l1, 4, 0] = lhs[l1, 4, 0] * pivot;
			r[r1, r2, r3, r4, 0] = r[r1, r2, r3, r4, 0] * pivot;
			
			coeff =         lhs[l1, 0, 1];
			lhs[l1, 1, 1] = lhs[l1, 1, 1] - coeff * lhs[l1, 1, 0];
			lhs[l1, 2, 1] = lhs[l1, 2, 1] - coeff * lhs[l1, 2, 0];
			lhs[l1, 3, 1] = lhs[l1, 3, 1] - coeff * lhs[l1, 3, 0];
			lhs[l1, 4, 1] = lhs[l1, 4, 1] - coeff * lhs[l1, 4, 0];
			r[r1, r2, r3, r4, 1] = r[r1, r2, r3, r4, 1] - coeff * r[r1, r2, r3, r4, 0];
			
			coeff =         lhs[l1, 0, 2];
			lhs[l1, 1, 2] = lhs[l1, 1, 2] - coeff * lhs[l1, 1, 0];
			lhs[l1, 2, 2] = lhs[l1, 2, 2] - coeff * lhs[l1, 2, 0];
			lhs[l1, 3, 2] = lhs[l1, 3, 2] - coeff * lhs[l1, 3, 0];
			lhs[l1, 4, 2] = lhs[l1, 4, 2] - coeff * lhs[l1, 4, 0];
			r[r1, r2, r3, r4, 2] = r[r1, r2, r3, r4, 2] - coeff * r[r1, r2, r3, r4, 0];
			
			coeff =         lhs[l1, 0, 3];
			lhs[l1, 1, 3] = lhs[l1, 1, 3] - coeff * lhs[l1, 1, 0];
			lhs[l1, 2, 3] = lhs[l1, 2, 3] - coeff * lhs[l1, 2, 0];
			lhs[l1, 3, 3] = lhs[l1, 3, 3] - coeff * lhs[l1, 3, 0];
			lhs[l1, 4, 3] = lhs[l1, 4, 3] - coeff * lhs[l1, 4, 0];
			r[r1, r2, r3, r4, 3] = r[r1, r2, r3, r4, 3] - coeff * r[r1, r2, r3, r4, 0];
			
			coeff =         lhs[l1, 0, 4];
			lhs[l1, 1, 4] = lhs[l1, 1, 4] - coeff * lhs[l1, 1, 0];
			lhs[l1, 2, 4] = lhs[l1, 2, 4] - coeff * lhs[l1, 2, 0];
			lhs[l1, 3, 4] = lhs[l1, 3, 4] - coeff * lhs[l1, 3, 0];
			lhs[l1, 4, 4] = lhs[l1, 4, 4] - coeff * lhs[l1, 4, 0];
			r[r1, r2, r3, r4, 4] = r[r1, r2, r3, r4, 4] - coeff * r[r1, r2, r3, r4, 0];
			
			pivot = 1.00d / lhs[l1, 1, 1];
			lhs[l1, 2, 1] = lhs[l1, 2, 1] * pivot;
			lhs[l1, 3, 1] = lhs[l1, 3, 1] * pivot;
			lhs[l1, 4, 1] = lhs[l1, 4, 1] * pivot;
			r[r1, r2, r3, r4, 1] = r[r1, r2, r3, r4, 1] * pivot;
			
			coeff =         lhs[l1, 1, 0];
			lhs[l1, 2, 0] = lhs[l1, 2, 0] - coeff * lhs[l1, 2, 1];
			lhs[l1, 3, 0] = lhs[l1, 3, 0] - coeff * lhs[l1, 3, 1];
			lhs[l1, 4, 0] = lhs[l1, 4, 0] - coeff * lhs[l1, 4, 1];
			r[r1, r2, r3, r4, 0] = r[r1, r2, r3, r4, 0] - coeff * r[r1, r2, r3, r4, 1];
			
			coeff =         lhs[l1, 1, 2];
			lhs[l1, 2, 2] = lhs[l1, 2, 2] - coeff * lhs[l1, 2, 1];
			lhs[l1, 3, 2] = lhs[l1, 3, 2] - coeff * lhs[l1, 3, 1];
			lhs[l1, 4, 2] = lhs[l1, 4, 2] - coeff * lhs[l1, 4, 1];
			r[r1, r2, r3, r4, 2] = r[r1, r2, r3, r4, 2] - coeff * r[r1, r2, r3, r4, 1];
			
			coeff =         lhs[l1, 1, 3];
			lhs[l1, 2, 3] = lhs[l1, 2, 3] - coeff * lhs[l1, 2, 1];
			lhs[l1, 3, 3] = lhs[l1, 3, 3] - coeff * lhs[l1, 3, 1];
			lhs[l1, 4, 3] = lhs[l1, 4, 3] - coeff * lhs[l1, 4, 1];
			r[r1, r2, r3, r4, 3] = r[r1, r2, r3, r4, 3] - coeff * r[r1, r2, r3, r4, 1];
			
			coeff =         lhs[l1, 1, 4];
			lhs[l1, 2, 4] = lhs[l1, 2, 4] - coeff * lhs[l1, 2, 1];
			lhs[l1, 3, 4] = lhs[l1, 3, 4] - coeff * lhs[l1, 3, 1];
			lhs[l1, 4, 4] = lhs[l1, 4, 4] - coeff * lhs[l1, 4, 1];
			r[r1, r2, r3, r4, 4] = r[r1, r2, r3, r4, 4] - coeff * r[r1, r2, r3, r4, 1];
			
			pivot = 1.00d / lhs[l1, 2, 2];
			lhs[l1, 3, 2] = lhs[l1, 3, 2] * pivot;
			lhs[l1, 4, 2] = lhs[l1, 4, 2] * pivot;
			r[r1, r2, r3, r4, 2] = r[r1, r2, r3, r4, 2] * pivot;
			
			coeff =         lhs[l1, 2, 0];
			lhs[l1, 3, 0] = lhs[l1, 3, 0] - coeff * lhs[l1, 3, 2];
			lhs[l1, 4, 0] = lhs[l1, 4, 0] - coeff * lhs[l1, 4, 2];
			r[r1, r2, r3, r4, 0] = r[r1, r2, r3, r4, 0] - coeff * r[r1, r2, r3, r4, 2];
			
			coeff =         lhs[l1, 2, 1];
			lhs[l1, 3, 1] = lhs[l1, 3, 1] - coeff * lhs[l1, 3, 2];
			lhs[l1, 4, 1] = lhs[l1, 4, 1] - coeff * lhs[l1, 4, 2];
			r[r1, r2, r3, r4, 1] = r[r1, r2, r3, r4, 1] - coeff * r[r1, r2, r3, r4, 2];
			
			coeff =         lhs[l1, 2, 3];
			lhs[l1, 3, 3] = lhs[l1, 3, 3] - coeff * lhs[l1, 3, 2];
			lhs[l1, 4, 3] = lhs[l1, 4, 3] - coeff * lhs[l1, 4, 2];
			r[r1, r2, r3, r4, 3] = r[r1, r2, r3, r4, 3] - coeff * r[r1, r2, r3, r4, 2];
			
			coeff =         lhs[l1, 2, 4];
			lhs[l1, 3, 4] = lhs[l1, 3, 4] - coeff * lhs[l1, 3, 2];
			lhs[l1, 4, 4] = lhs[l1, 4, 4] - coeff * lhs[l1, 4, 2];
			r[r1, r2, r3, r4, 4] = r[r1, r2, r3, r4, 4] - coeff * r[r1, r2, r3, r4, 2];
			
			pivot = 1.00d / lhs[l1, 3, 3];
			lhs[l1, 4, 3] = lhs[l1, 4, 3] * pivot;
			r[r1, r2, r3, r4, 3] = r[r1, r2, r3, r4, 3] * pivot;
			
			coeff = lhs[l1, 3, 0];
			lhs[l1, 4, 0] = lhs[l1, 4, 0] - coeff * lhs[l1, 4, 3];
			r[r1, r2, r3, r4, 0] = r[r1, r2, r3, r4, 0] - coeff * r[r1, r2, r3, r4, 3];
			
			coeff = lhs[l1, 3, 1];
			lhs[l1, 4, 1] = lhs[l1, 4, 1] - coeff * lhs[l1, 4, 3];
			r[r1, r2, r3, r4, 1] = r[r1, r2, r3, r4, 1] - coeff * r[r1, r2, r3, r4, 3];
			
			coeff = lhs[l1, 3, 2];
			lhs[l1, 4, 2] = lhs[l1, 4, 2] - coeff * lhs[l1, 4, 3];
			r[r1, r2, r3, r4, 2] = r[r1, r2, r3, r4, 2] - coeff * r[r1, r2, r3, r4, 3];
			
			coeff = lhs[l1, 3, 4];
			lhs[l1, 4, 4] = lhs[l1, 4, 4] - coeff * lhs[l1, 4, 3];
			r[r1, r2, r3, r4, 4] = r[r1, r2, r3, r4, 4] - coeff * r[r1, r2, r3, r4, 3];
			
			pivot = 1.00d / lhs[l1, 4, 4];
			r[r1, r2, r3, r4, 4] = r[r1, r2, r3, r4, 4] * pivot;
			
			coeff = lhs[l1, 4, 0];
			r[r1, r2, r3, r4, 0] = r[r1, r2, r3, r4, 0] - coeff * r[r1, r2, r3, r4, 4];
			
			coeff = lhs[l1, 4, 1];
			r[r1, r2, r3, r4, 1] = r[r1, r2, r3, r4, 1] - coeff * r[r1, r2, r3, r4, 4];
			
			coeff = lhs[l1, 4, 2];
			r[r1, r2, r3, r4, 2] = r[r1, r2, r3, r4, 2] - coeff * r[r1, r2, r3, r4, 4];
			
			coeff = lhs[l1, 4, 3];
			r[r1, r2, r3, r4, 3] = r[r1, r2, r3, r4, 3] - coeff * r[r1, r2, r3, r4, 4];
			
			return 0;
		} // end activate method 
	}
}
