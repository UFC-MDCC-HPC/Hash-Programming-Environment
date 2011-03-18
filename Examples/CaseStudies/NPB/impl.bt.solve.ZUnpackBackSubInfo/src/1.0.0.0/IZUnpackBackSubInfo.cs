using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.UnpackBackSubInfo;

namespace impl.bt.solve.ZUnpackBackSubInfo { 
	public class IZUnpackBackSubInfo<I, C, DIR, MTH> : BaseIZUnpackBackSubInfo<I, C, DIR, MTH>, IUnpackBackSubInfo<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IZ
	where MTH:IBeamWarmingMethod {
	   
		private double[,,,] backsub_info;
		private double[] out_buffer_z;
		private int c;

		public void setParameters(double[,,,] backsub_info, double[] out_buffer_z, int c) {
			this.backsub_info = backsub_info;
			this.out_buffer_z = out_buffer_z;
			this.c = c;
		}
		
		public IZUnpackBackSubInfo() { 
		
		} 
		
		public override void compute() { 
            int ptr = 0;
            for(int j = 0; j <= JMAX - 1; j++) {
                for(int i = 0; i <= IMAX - 1; i++) {
                    for(int n = 0; n < 5; n++) {
                        backsub_info[c, j+2, i+2, n] = out_buffer_z[ptr + n];
                    }
                    ptr = ptr + 5;
                }
            }
		}
	}
}
