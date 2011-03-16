using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackUnpack;

namespace impl.bt.solve.XPackSolveInfoImpl { 
	public class IXPackSolveInfoImpl<I, C, DIR, MTH> : BaseIXPackSolveInfoImpl<I, C, DIR, MTH>, IPackUnpack<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod {
		protected double[,,,,,] lhsc;
		protected double[] in_buffer_x; 
		protected int c;
		public void setParameters(double[,,,,,] lhsc, double[] in_buffer_x, int c) {
			this.lhsc = lhsc;
			this.in_buffer_x = in_buffer_x; 
			this.c = c;
		}
		public IXPackSolveInfoImpl() { 
		
		} 
		public override void compute() { 
			int isize, ptr=0;
			isize = cell_size[c, 0] + 1;
			for(int k = 0; k <= KMAX - 1; k++) {
			    for(int j = 0; j <= JMAX - 1; j++) {
			        for(int m = 1; m <= 5; m++) {
			            for(int n = 0; n < 5; n++) {
			                in_buffer_x[ptr + n] = lhsc[c, k+2, j+2, isize, n, m-1];
			            }
			            ptr = ptr + 5;
			        }
			        for(n = 0; n < 5; n++) {
			            in_buffer_x[ptr + n] = rhs[c, k+2, j+2, isize, n];
			        }
			        ptr = ptr + 5;
			    }
			}
		}
	}
}
