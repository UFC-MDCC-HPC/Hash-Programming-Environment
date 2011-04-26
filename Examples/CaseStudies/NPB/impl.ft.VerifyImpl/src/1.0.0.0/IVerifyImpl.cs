using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.Verify;
using ft.problem_size.Instance;

namespace impl.ft.VerifyImpl { 
	public class IVerifyImpl<I, C> : BaseIVerifyImpl<I, C>, IVerify<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private int nt;
	    private double[] sums;
	
		public IVerifyImpl() { 
		
		} 
		
		public override int go() {
            double err, epsilon, a, b, c, d, r1, r2;
            PROBLEM_CLASS clss = Instance.CLASS;
            int node = this.GlobalRank;
            if(node != 0)
                return 0;
            epsilon = 0.000000000001;
            int verified = 0;

            for(int i = 0; i < nt; i++) {
                a = sums[i*2+REAL] - csum_ref[i*2+REAL];
                b = sums[i*2+IMAG] - csum_ref[i*2+IMAG];
                c = csum_ref[i*2+REAL];
                d = csum_ref[i*2+IMAG];
                r1 = ((a * c + b * d) / ((c * c) + (d * d))) * ((a * c + b * d) / ((c * c) + (d * d)));
                r2 = ((c * b - a * d) / (c * c + d * d)) * ((c * b - a * d) / (c * c + d * d));
                err = Math.Sqrt(r1 + r2);
                if(!(err <= epsilon))
                    goto Go100;
            }
            verified = 1;

            Go100:
            if(verified==1) {
                Console.WriteLine(" Result verification successful");
            }
            else {
                Console.WriteLine(" Result verification failed");
            }
            Console.WriteLine("Class = "+ clss.ToString()[0]);
            return verified;
		}
		public void setParameters(int nt, double[] sums){
		   this.nt   = nt;
		   this.sums = sums;
		}
	}
}
