using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.BeamWarmingMethod;
using bt.solve.MatMulSub;

namespace impl.bt.solve.MatMulSubImpl 
{ 
	public class IMatMulSubImpl<I, C, MTH> : BaseIMatMulSubImpl<I, C, MTH>, IMatMulSub<I, C, MTH>
		where I:IInstance_BT<C>
		where C:IClass
		where MTH:IBeamWarmingMethod 
	{
		private double[,,] ablock;
		private double[,,,,,] bblock;
		private double[,,] cblock;
		private int a1, b1, b2, b3, b4, c1;
		
		public void setParameters(double[,,] ablock, double[,,,,,] bblock, double[,,] cblock, int a1, int b1, int b2, int b3, int b4, int c1) 
		{
			this.ablock = ablock;
			this.bblock = bblock;
			this.cblock = cblock;
			this.a1 = a1;
			this.b1 = b1;
			this.b2 = b2;
			this.b3 = b3;
			this.b4 = b4;
			this.c1 = c1;
		}
		
		public override int go()   
		{ 
			cblock[c1, 0, 0] = cblock[c1, 0, 0] - ablock[a1, 0, 0] * bblock[b1, b2, b3, b4, 0, 0]
			                         - ablock[a1, 1, 0] * bblock[b1, b2, b3, b4, 0, 1]
			                         - ablock[a1, 2, 0] * bblock[b1, b2, b3, b4, 0, 2]
			                         - ablock[a1, 3, 0] * bblock[b1, b2, b3, b4, 0, 3]
			                         - ablock[a1, 4, 0] * bblock[b1, b2, b3, b4, 0, 4];
			
			cblock[c1, 0, 1] = cblock[c1, 0, 1] - ablock[a1, 0, 1] * bblock[b1, b2, b3, b4, 0, 0]
			                         - ablock[a1, 1, 1] * bblock[b1, b2, b3, b4, 0, 1]
			                         - ablock[a1, 2, 1] * bblock[b1, b2, b3, b4, 0, 2]
			                         - ablock[a1, 3, 1] * bblock[b1, b2, b3, b4, 0, 3]
			                         - ablock[a1, 4, 1] * bblock[b1, b2, b3, b4, 0, 4];
			
			cblock[c1, 0, 2] = cblock[c1, 0, 2] - ablock[a1, 0, 2] * bblock[b1, b2, b3, b4, 0, 0]
			                         - ablock[a1, 1, 2] * bblock[b1, b2, b3, b4, 0, 1]
			                         - ablock[a1, 2, 2] * bblock[b1, b2, b3, b4, 0, 2]
			                         - ablock[a1, 3, 2] * bblock[b1, b2, b3, b4, 0, 3]
			                         - ablock[a1, 4, 2] * bblock[b1, b2, b3, b4, 0, 4];
			
			cblock[c1, 0, 3] = cblock[c1, 0, 3] - ablock[a1, 0, 3] * bblock[b1, b2, b3, b4, 0, 0]
			                         - ablock[a1, 1, 3] * bblock[b1, b2, b3, b4, 0, 1]
			                         - ablock[a1, 2, 3] * bblock[b1, b2, b3, b4, 0, 2]
			                         - ablock[a1, 3, 3] * bblock[b1, b2, b3, b4, 0, 3]
			                         - ablock[a1, 4, 3] * bblock[b1, b2, b3, b4, 0, 4];
			
			cblock[c1, 0, 4] = cblock[c1, 0, 4] - ablock[a1, 0, 4] * bblock[b1, b2, b3, b4, 0, 0]
			                         - ablock[a1, 1, 4] * bblock[b1, b2, b3, b4, 0, 1]
			                         - ablock[a1, 2, 4] * bblock[b1, b2, b3, b4, 0, 2]
			                         - ablock[a1, 3, 4] * bblock[b1, b2, b3, b4, 0, 3]
			                         - ablock[a1, 4, 4] * bblock[b1, b2, b3, b4, 0, 4];
			
			cblock[c1, 1, 0] = cblock[c1, 1, 0] - ablock[a1, 0, 0] * bblock[b1, b2, b3, b4, 1, 0]
			                         - ablock[a1, 1, 0] * bblock[b1, b2, b3, b4, 1, 1]
			                         - ablock[a1, 2, 0] * bblock[b1, b2, b3, b4, 1, 2]
			                         - ablock[a1, 3, 0] * bblock[b1, b2, b3, b4, 1, 3]
			                         - ablock[a1, 4, 0] * bblock[b1, b2, b3, b4, 1, 4];
			
			cblock[c1, 1, 1] = cblock[c1, 1, 1] - ablock[a1, 0, 1] * bblock[b1, b2, b3, b4, 1, 0]
			                         - ablock[a1, 1, 1] * bblock[b1, b2, b3, b4, 1, 1]
			                         - ablock[a1, 2, 1] * bblock[b1, b2, b3, b4, 1, 2]
			                         - ablock[a1, 3, 1] * bblock[b1, b2, b3, b4, 1, 3]
			                         - ablock[a1, 4, 1] * bblock[b1, b2, b3, b4, 1, 4];
			
			cblock[c1, 1, 2] = cblock[c1, 1, 2] - ablock[a1, 0, 2] * bblock[b1, b2, b3, b4, 1, 0]
			                         - ablock[a1, 1, 2] * bblock[b1, b2, b3, b4, 1, 1]
			                         - ablock[a1, 2, 2] * bblock[b1, b2, b3, b4, 1, 2]
			                         - ablock[a1, 3, 2] * bblock[b1, b2, b3, b4, 1, 3]
			                         - ablock[a1, 4, 2] * bblock[b1, b2, b3, b4, 1, 4];
			
			cblock[c1, 1, 3] = cblock[c1, 1, 3] - ablock[a1, 0, 3] * bblock[b1, b2, b3, b4, 1, 0]
			                         - ablock[a1, 1, 3] * bblock[b1, b2, b3, b4, 1, 1]
			                         - ablock[a1, 2, 3] * bblock[b1, b2, b3, b4, 1, 2]
			                         - ablock[a1, 3, 3] * bblock[b1, b2, b3, b4, 1, 3]
			                         - ablock[a1, 4, 3] * bblock[b1, b2, b3, b4, 1, 4];
			
			cblock[c1, 1, 4] = cblock[c1, 1, 4] - ablock[a1, 0, 4] * bblock[b1, b2, b3, b4, 1, 0]
			                         - ablock[a1, 1, 4] * bblock[b1, b2, b3, b4, 1, 1]
			                         - ablock[a1, 2, 4] * bblock[b1, b2, b3, b4, 1, 2]
			                         - ablock[a1, 3, 4] * bblock[b1, b2, b3, b4, 1, 3]
			                         - ablock[a1, 4, 4] * bblock[b1, b2, b3, b4, 1, 4];
			
			cblock[c1, 2, 0] = cblock[c1, 2, 0] - ablock[a1, 0, 0] * bblock[b1, b2, b3, b4, 2, 0]
			                         - ablock[a1, 1, 0] * bblock[b1, b2, b3, b4, 2, 1]
			                         - ablock[a1, 2, 0] * bblock[b1, b2, b3, b4, 2, 2]
			                         - ablock[a1, 3, 0] * bblock[b1, b2, b3, b4, 2, 3]
			                         - ablock[a1, 4, 0] * bblock[b1, b2, b3, b4, 2, 4];
			
			cblock[c1, 2, 1] = cblock[c1, 2, 1] - ablock[a1, 0, 1] * bblock[b1, b2, b3, b4, 2, 0]
			                         - ablock[a1, 1, 1] * bblock[b1, b2, b3, b4, 2, 1]
			                         - ablock[a1, 2, 1] * bblock[b1, b2, b3, b4, 2, 2]
			                         - ablock[a1, 3, 1] * bblock[b1, b2, b3, b4, 2, 3]
			                         - ablock[a1, 4, 1] * bblock[b1, b2, b3, b4, 2, 4];
			
			cblock[c1, 2, 2] = cblock[c1, 2, 2] - ablock[a1, 0, 2] * bblock[b1, b2, b3, b4, 2, 0]
			                         - ablock[a1, 1, 2] * bblock[b1, b2, b3, b4, 2, 1]
			                         - ablock[a1, 2, 2] * bblock[b1, b2, b3, b4, 2, 2]
			                         - ablock[a1, 3, 2] * bblock[b1, b2, b3, b4, 2, 3]
			                         - ablock[a1, 4, 2] * bblock[b1, b2, b3, b4, 2, 4];
			
			cblock[c1, 2, 3] = cblock[c1, 2, 3] - ablock[a1, 0, 3] * bblock[b1, b2, b3, b4, 2, 0]
			                         - ablock[a1, 1, 3] * bblock[b1, b2, b3, b4, 2, 1]
			                         - ablock[a1, 2, 3] * bblock[b1, b2, b3, b4, 2, 2]
			                         - ablock[a1, 3, 3] * bblock[b1, b2, b3, b4, 2, 3]
			                         - ablock[a1, 4, 3] * bblock[b1, b2, b3, b4, 2, 4];
			
			cblock[c1, 2, 4] = cblock[c1, 2, 4] - ablock[a1, 0, 4] * bblock[b1, b2, b3, b4, 2, 0]
			                         - ablock[a1, 1, 4] * bblock[b1, b2, b3, b4, 2, 1]
			                         - ablock[a1, 2, 4] * bblock[b1, b2, b3, b4, 2, 2]
			                         - ablock[a1, 3, 4] * bblock[b1, b2, b3, b4, 2, 3]
			                         - ablock[a1, 4, 4] * bblock[b1, b2, b3, b4, 2, 4];
			
			cblock[c1, 3, 0] = cblock[c1, 3, 0] - ablock[a1, 0, 0] * bblock[b1, b2, b3, b4, 3, 0]
			                         - ablock[a1, 1, 0] * bblock[b1, b2, b3, b4, 3, 1]
			                         - ablock[a1, 2, 0] * bblock[b1, b2, b3, b4, 3, 2]
			                         - ablock[a1, 3, 0] * bblock[b1, b2, b3, b4, 3, 3]
			                         - ablock[a1, 4, 0] * bblock[b1, b2, b3, b4, 3, 4];
			
			cblock[c1, 3, 1] = cblock[c1, 3, 1] - ablock[a1, 0, 1] * bblock[b1, b2, b3, b4, 3, 0]
			                         - ablock[a1, 1, 1] * bblock[b1, b2, b3, b4, 3, 1]
			                         - ablock[a1, 2, 1] * bblock[b1, b2, b3, b4, 3, 2]
			                         - ablock[a1, 3, 1] * bblock[b1, b2, b3, b4, 3, 3]
			                         - ablock[a1, 4, 1] * bblock[b1, b2, b3, b4, 3, 4];
			
			cblock[c1, 3, 2] = cblock[c1, 3, 2] - ablock[a1, 0, 2] * bblock[b1, b2, b3, b4, 3, 0]
			                         - ablock[a1, 1, 2] * bblock[b1, b2, b3, b4, 3, 1]
			                         - ablock[a1, 2, 2] * bblock[b1, b2, b3, b4, 3, 2]
			                         - ablock[a1, 3, 2] * bblock[b1, b2, b3, b4, 3, 3]
			                         - ablock[a1, 4, 2] * bblock[b1, b2, b3, b4, 3, 4];
			
			cblock[c1, 3, 3] = cblock[c1, 3, 3] - ablock[a1, 0, 3] * bblock[b1, b2, b3, b4, 3, 0]
			                         - ablock[a1, 1, 3] * bblock[b1, b2, b3, b4, 3, 1]
			                         - ablock[a1, 2, 3] * bblock[b1, b2, b3, b4, 3, 2]
			                         - ablock[a1, 3, 3] * bblock[b1, b2, b3, b4, 3, 3]
			                         - ablock[a1, 4, 3] * bblock[b1, b2, b3, b4, 3, 4];
			
			cblock[c1, 3, 4] = cblock[c1, 3, 4] - ablock[a1, 0, 4] * bblock[b1, b2, b3, b4, 3, 0]
			                         - ablock[a1, 1, 4] * bblock[b1, b2, b3, b4, 3, 1]
			                         - ablock[a1, 2, 4] * bblock[b1, b2, b3, b4, 3, 2]
			                         - ablock[a1, 3, 4] * bblock[b1, b2, b3, b4, 3, 3]
			                         - ablock[a1, 4, 4] * bblock[b1, b2, b3, b4, 3, 4];
			
			cblock[c1, 4, 0] = cblock[c1, 4, 0] - ablock[a1, 0, 0] * bblock[b1, b2, b3, b4, 4, 0]
			                         - ablock[a1, 1, 0] * bblock[b1, b2, b3, b4, 4, 1]
			                         - ablock[a1, 2, 0] * bblock[b1, b2, b3, b4, 4, 2]
			                         - ablock[a1, 3, 0] * bblock[b1, b2, b3, b4, 4, 3]
			                         - ablock[a1, 4, 0] * bblock[b1, b2, b3, b4, 4, 4];
			
			cblock[c1, 4, 1] = cblock[c1, 4, 1] - ablock[a1, 0, 1] * bblock[b1, b2, b3, b4, 4, 0]
			                         - ablock[a1, 1, 1] * bblock[b1, b2, b3, b4, 4, 1]
			                         - ablock[a1, 2, 1] * bblock[b1, b2, b3, b4, 4, 2]
			                         - ablock[a1, 3, 1] * bblock[b1, b2, b3, b4, 4, 3]
			                         - ablock[a1, 4, 1] * bblock[b1, b2, b3, b4, 4, 4];
			
			cblock[c1, 4, 2] = cblock[c1, 4, 2] - ablock[a1, 0, 2] * bblock[b1, b2, b3, b4, 4, 0]
			                         - ablock[a1, 1, 2] * bblock[b1, b2, b3, b4, 4, 1]
			                         - ablock[a1, 2, 2] * bblock[b1, b2, b3, b4, 4, 2]
			                         - ablock[a1, 3, 2] * bblock[b1, b2, b3, b4, 4, 3]
			                         - ablock[a1, 4, 2] * bblock[b1, b2, b3, b4, 4, 4];
			
			cblock[c1, 4, 3] = cblock[c1, 4, 3] - ablock[a1, 0, 3] * bblock[b1, b2, b3, b4, 4, 0]
			                         - ablock[a1, 1, 3] * bblock[b1, b2, b3, b4, 4, 1]
			                         - ablock[a1, 2, 3] * bblock[b1, b2, b3, b4, 4, 2]
			                         - ablock[a1, 3, 3] * bblock[b1, b2, b3, b4, 4, 3]
			                         - ablock[a1, 4, 3] * bblock[b1, b2, b3, b4, 4, 4];
			
			cblock[c1, 4, 4] = cblock[c1, 4, 4] - ablock[a1, 0, 4] * bblock[b1, b2, b3, b4, 4, 0]
			                         - ablock[a1, 1, 4] * bblock[b1, b2, b3, b4, 4, 1]
			                         - ablock[a1, 2, 4] * bblock[b1, b2, b3, b4, 4, 2]
			                         - ablock[a1, 3, 4] * bblock[b1, b2, b3, b4, 4, 3]
			                         - ablock[a1, 4, 4] * bblock[b1, b2, b3, b4, 4, 4];
			                         
			return 0;
		} // end activate method 
	}
}
