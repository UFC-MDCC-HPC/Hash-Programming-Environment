using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackBackSubInfo;

namespace impl.bt.solve.YPackBackSubInfo 
{ 
	public class IYPackBackSubInfo<I, C, DIR, MTH> : BaseIYPackBackSubInfo<I, C, DIR, MTH>, IPackBackSubInfo<I, C, DIR, MTH>
		where I:IInstance_BT<C>
		where C:IClass
		where DIR:IY
		where MTH:IBeamWarmingMethod 
	{
		private double[] in_buffer_y;
		private int c;		
		
		public void setParameters(double[] in_buffer_y, int c) {
		   this.in_buffer_y = in_buffer_y;
		   this.c = c;
		}
		
		public override int go()  
		{ 
            int ptr = 0, jstart = 2;
            for(int k = 0; k <= KMAX - 1; k++) 
            {
                for(int i = 0; i <= IMAX - 1; i++) 
                {
                    for(int n = 0; n < 5; n++) 
                    {
                        in_buffer_y[ptr + n] = rhs[c, k+2, jstart, i+2, n];
                    }
                    ptr = ptr + 5;
                }
            }
            
            return 0;
		}
	}
}
