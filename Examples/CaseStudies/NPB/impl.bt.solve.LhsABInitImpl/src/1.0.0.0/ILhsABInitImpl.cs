using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.LhsABInit;

namespace impl.bt.solve.LhsABInitImpl {

	public class ILhsABInitImpl<I, C> : BaseILhsABInitImpl<I, C>, ILhsABInit<I, C>
	where I:IInstance_BT<C>
	where C:IClass {
		private double[,,] lhsa;
		private double[,,] lhsb;
		private int size;
	
		public void setParameters(double[,,] lhsa, double[,,] lhsb, int size) {
		   this.lhsa = lhsa;
		   this.lhsb = lhsb;
		   this.size = size;
		}
		public ILhsABInitImpl() { 
		
		}
		public override void compute() { 
            for(int i = 2; i <= size; i++) {
                for(int m = 0; m < 5; m++) {
                    for(int n = 0; n < 5; n++) {
                        lhsa[i, n, m] = 0.0d;
                        lhsb[i, n, m] = 0.0d;
                    }
                    lhsb[i, m, m] = 1.0d;
                }
            }
		}
	}
}
