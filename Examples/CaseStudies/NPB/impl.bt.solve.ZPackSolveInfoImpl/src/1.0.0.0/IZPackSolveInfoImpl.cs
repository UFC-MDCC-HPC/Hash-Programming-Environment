using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackUnpack;

namespace impl.bt.solve.ZPackSolveInfoImpl { 
	public class IZPackSolveInfoImpl<I, C, DIR, MTH> : BaseIZPackSolveInfoImpl<I, C, DIR, MTH>, IPackUnpack<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IZ
	where MTH:IBeamWarmingMethod {
		private double[,,,,,] lhsc;
		private double[] in_buffer_z;
		private int c;
		public void setParameters(double[,,,,,] lhsc, double[] in_buffer_z, int c) {
			this.lhsc = lhsc;
			this.in_buffer_z = in_buffer_z;
			this.c = c;
		}
		public IZPackSolveInfoImpl() { 
		
		}
		public override void compute() {
            int ksize, ptr = 0;
            ksize = cell_size[c, 2] + 1;
            for(int j = 0; j <= JMAX - 1; j++) {
                for(int i = 0; i <= IMAX - 1; i++) {
                    for(int m = 1; m <= 5; m++) {
                        for(int n = 0; n < 5; n++) {
                            in_buffer_z[ptr + n] = lhsc[c, ksize, j+2, i+2, n, m-1];
                        }
                        ptr = ptr + 5;
                    }
                    for(int n = 0; n < 5; n++) {
                        in_buffer_z[ptr + n] = rhs[c, ksize, j+2, i+2, n];
                    }
                    ptr = ptr + 5;
                }
            }
		}
	}
}
