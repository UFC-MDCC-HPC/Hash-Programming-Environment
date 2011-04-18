using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Error;
using MPI;

namespace impl.lu.ErrorImpl {
	public class IErrorImpl<I, C> : BaseIErrorImpl<I, C>, IError<I, C>
	where I:IInstance_LU<C>
	where C:IClass{
		public IErrorImpl() { 
		
		} 		
		public override int go() { 

            int i, j, k, m, iglob, jglob;
            double tmp;
            double[,,,] u000ijk = new double[1, 1, 1, 5];
            double[] dummy = new double[5];
            errnm = new double[5];
            for(m = 0; m< 5; m++) {
                errnm[m] = 0.0d;
                dummy[m] = 0.0d;
            }
            for(k = 2; k<= nz-1; k++) {
                for(j = jst; j<= jend; j++) {
                    jglob = jpt + j;
                    for(i = ist; i<= iend; i++) {
                        iglob = ipt + i;
                        Exact.setParameters(iglob, jglob, k, u000ijk, 0, 0, 0);
                        Exact.go();
                        for(m = 0; m< 5; m++) {
                            tmp = (u000ijk[0, 0, 0, m] - u[k-1, j+1, i+1, m]);
                            dummy[m] = dummy[m] + pow2(tmp);
                        }
                    }
                }
            }
            worldcomm.Allreduce<double>(dummy, MPI.Operation<double>.Add, ref errnm);
            for(m = 0; m< 5; m++) {
                errnm[m] = Math.Sqrt(errnm[m]/((nx0-2)*(ny0-2)*(nz0-2)));
            }
			return 0;
		}
		
		private double[] errnm;
		public double[] Errnm { get { return errnm; } }
		
		public static double pow2(double p) { return p * p; } 
	}
}
