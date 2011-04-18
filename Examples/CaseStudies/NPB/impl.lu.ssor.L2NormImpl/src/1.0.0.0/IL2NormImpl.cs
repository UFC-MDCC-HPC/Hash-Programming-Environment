using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.ssor.L2Norm;
using MPI;

namespace impl.lu.ssor.L2NormImpl { 
	public class IL2NormImpl<I, C> : BaseIL2NormImpl<I, C>, IL2Norm<I, C>
	where I:IInstance_LU<C>
	where C:IClass{
	    private double[, , ,] v;
	    private double[] sum;
		public IL2NormImpl() {
		   
		} 		
		public override int go() { 

            double[] dummy = new double[5];
            for(int m = 0; m< 5; m++) {
                dummy[m] = 0.0d;
            }
            for(int k = 2; k<= nz0-1; k++) {
                for(int j = jst; j<= jend; j++) {
                    for(int i = ist; i<= iend; i++) {
                        for(int m = 0; m< 5; m++) {
                            dummy[m] = dummy[m] + v[k-1, j+1, i+1, m] * v[k-1, j+1, i+1, m];
                        }
                    }
                }
            }
            //---------------------------------------------------------------------
            //   compute the global sum of individual contributions to dot product.
            //---------------------------------------------------------------------
            worldcomm.Allreduce<double>(dummy, MPI.Operation<double>.Add, ref sum);
            for(int m = 0; m< 5; m++) {
                sum[m] = Math.Sqrt(sum[m]/((nx0-2)*(ny0-2)*(nz0-2)));
            }
			return 0;
		}
		public void setParameters(double[, , ,] v, double[] sum){
		   this.v = v;
		   this.sum = sum;
		}
	}
}
