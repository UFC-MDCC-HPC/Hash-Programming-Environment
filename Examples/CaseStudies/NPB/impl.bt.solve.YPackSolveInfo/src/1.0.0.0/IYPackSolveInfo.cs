using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackSolveInfo;

namespace impl.bt.solve.YPackSolveInfo 
{
	public class IYPackSolveInfo<I, C, DIR, MTH> : BaseIYPackSolveInfo<I, C, DIR, MTH>, IPackSolveInfo<I, C, DIR, MTH>
		where I:IInstance_BT<C>
		where C:IClass
		where DIR:IY
		where MTH:IBeamWarmingMethod 
	{
		private double[,,,,,] lhsc;
		private double[] in_buffer_y;
		private int c;
		
		public void setParameters(double[,,,,,] lhsc, double[] in_buffer_y, int c) 
		{
			this.lhsc = lhsc;
			this.in_buffer_y = in_buffer_y;
			this.c = c;
		}	   

		public override int go() 
		{
            int jsize, ptr=0;
            jsize = cell_size[c, 1] + 1;
            
            for(int k = 0; k <= KMAX - 1; k++) 
            {
                for(int i = 0; i <= IMAX - 1; i++) 
                {
                    for(int m = 1; m <= 5; m++) 
                    {
                        for(int n = 0; n < 5; n++) 
                        {
                            in_buffer_y[ptr + n] = lhsc[c, k+2, jsize, i+2, n, m-1];
                        }
                        ptr = ptr + 5;
                    }
                    
                    for(int n = 0; n < 5; n++) 
                    {
                        in_buffer_y[ptr + n] = rhs[c, k+2, jsize, i+2, n];
                    }
                    ptr = ptr + 5;
                }
            }
            
            return 0;
		}
	}
}
