using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackBackSubInfo;

namespace impl.bt.solve.ZPackBackSubInfo { 
	public class IZPackBackSubInfo<I, C, DIR, MTH> : BaseIZPackBackSubInfo<I, C, DIR, MTH>, IPackBackSubInfo<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IZ
	where MTH:IBeamWarmingMethod {
		private double[] in_buffer_z;
		private int c;
		public void setParameters(double[] in_buffer_z, int c) {
		   this.in_buffer_z = in_buffer_z;
		   this.c = c;
		}
		
		public IZPackBackSubInfo() { 
		
		} 

		public override void compute() {
            int ptr = 0, kstart = 2;
            for(int j = 0; j <= JMAX - 1; j++) {
                for(int i = 0; i <= IMAX - 1; i++) {
                    for(int n = 0; n < 5; n++) {
                        in_buffer_z[ptr + n] = rhs[c, kstart, j+2, i+2, n];
                    }
                    ptr = ptr + 5;
                }
            }
		}
	}
}
