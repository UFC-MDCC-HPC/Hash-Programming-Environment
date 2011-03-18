using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackBackSubInfo;

namespace impl.bt.solve.XPackBackSubInfo { 
	public class IXPackBackSubInfo<I, C, DIR, MTH> : BaseIXPackBackSubInfo<I, C, DIR, MTH>, IPackBackSubInfo<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod {	    
	    private double[] in_buffer_x;
		private int c;
		public void setParameters(double[] buffer, int c) {
		   this.in_buffer_x = buffer;
		   this.c = c;
		}

		public IXPackBackSubInfo() { 

		} 

		public override void compute() {
			int ptr = 0, istart = 2;
			for(int k = 0; k <= KMAX - 1; k++) {
			    for(int j = 0; j <= JMAX - 1; j++) {
			        for(int n = 0; n < 5; n++) {
			            in_buffer_x[ptr + n] = rhs[c, k+2, j+2, istart, n];
			        }
			        ptr = ptr + 5;
			    }
			}
		}		
	}
}
