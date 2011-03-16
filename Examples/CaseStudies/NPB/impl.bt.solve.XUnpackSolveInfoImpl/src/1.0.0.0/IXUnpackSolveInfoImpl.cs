using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackUnpack;

namespace impl.bt.solve.XUnpackSolveInfoImpl { 
	public class IXUnpackSolveInfoImpl<I, C, DIR, MTH> : BaseIXUnpackSolveInfoImpl<I, C, DIR, MTH>, IPackUnpack<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod {
		private double[,,,,,] lhsc;
		private double[] out_buffer_x; 
		private int c;
		
		public void setParameters(double[,,,,,] lhsc, double[] out_buffer_x, int c) {
			this.lhsc = lhsc;
			this.out_buffer_x = out_buffer_x; 
			this.c = c;
		}
		
		public IXUnpackSolveInfoImpl() { 
		
		} 
		
		public override void compute() { 
            int ptr = 0, istart = 2;
            for(int k = 0; k <= KMAX - 1; k++) {
                for(int j = 0; j <= JMAX - 1; j++) {
                    for(int m = 1; m <= 5; m++) {
                        for(int n = 0; n < 5; n++) {
                            lhsc[c, k+2, j+2, istart-1, n, m-1] = out_buffer_x[ptr + n];
                        }
                        ptr = ptr + 5;
                    }
                    for(int n = 0; n < 5; n++) {
                        rhs[c, k+2, j+2, istart-1, n] = out_buffer_x[ptr + n];
                    }
                    ptr = ptr + 5;
                }
            }
		}
	}
}
