using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.UnpackBackSubInfo;

namespace impl.bt.solve.YUnpackBackSubInfo 
{ 
	public class IYUnpackBackSubInfo<I, C, DIR, MTH> : BaseIYUnpackBackSubInfo<I, C, DIR, MTH>, IUnpackBackSubInfo<I, C, DIR, MTH>
		where I:IInstance_BT<C>
		where C:IClass
		where DIR:IY
		where MTH:IBeamWarmingMethod 
	{
		private double[,,,] backsub_info;
		private double[] out_buffer_y;
		private int c;
		
		public void setParameters(double[,,,] backsub_info, double[] out_buffer_y, int c) 
		{
			this.backsub_info = backsub_info;
			this.out_buffer_y = out_buffer_y;
			this.c = c;
		}
		
        public override int go() 		
        { 
            int ptr = 0;
            for(int k = 0; k <= KMAX - 1; k++) 
            {
                for(int i = 0; i <= IMAX - 1; i++) 
                {
                    for(int n = 0; n < 5; n++) 
                    {
                        backsub_info[c, k+2, i+2, n] = out_buffer_y[ptr + n];
                    }
                    ptr = ptr + 5;
                }
            }
            
            return 0;
		}
	}
}
