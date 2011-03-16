using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.PackUnpack;

namespace impl.bt.solve.XUnpackBackSubInfoImpl { 
	public class IXUnpackBackSubInfoImpl<I, C, DIR, MTH> : BaseIXUnpackBackSubInfoImpl<I, C, DIR, MTH>, IPackUnpack<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod {
	
		private double[,,,] backsub_info;
		private double[] out_buffer_x;
		private int c;
		
		public void setParameters(double[,,,] backsub_info, double[] out_buffer_x, int c) {
			this.backsub_info = backsub_info;
			this.out_buffer_x = out_buffer_x;
			this.c = c;
		}
		
		public IXUnpackBackSubInfoImpl() { 
		
		} 
		
		public override void compute() {
			int ptr = 0;
			for(int k = 0; k <= KMAX - 1; k++) {
			    for(int j = 0; j <= JMAX - 1; j++) {
			        for(int n = 0; n < 5; n++) {
			            backsub_info[c, k+2, j+2, n] = out_buffer_x[ptr + n];
			        }
			        ptr = ptr + 5;
			    }
			}
		}
	}
}
