using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.data.FftInit;

namespace impl.ft.data.FftInitImpl { 
	public class IFftInitImpl<I, C> : BaseIFftInitImpl<I, C>, IFftInit<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private int n;
	
		public IFftInitImpl() { 
		
		} 
		
		public override int go() { 
            int m,nu,ku,i,j,ln;
            double t, ti;
            double pi = Math.PI;

            nu = n;
            m = ilog2(n);
            u[0, 0] = m;
            u[0, 1] = 0.0;
            ku = 2;
            ln = 1;
            int idx;
            for(j = 1; j <= m; j++) {
                t = pi / ln;
                for(i = 0; i <= ln - 1; i++) {
                    ti = i * t;

                    idx = (i+ku)-1;
                    u[idx, REAL] = Math.Cos(ti);
                    u[idx, IMAG] = Math.Sin(ti);
                }
                ku = ku + ln;
                ln = 2 * ln;
            }
		    return 0;
		}
        public int ilog2(int n) {
            int nn, lg;
            if(n == 1) {
                return 0;
            }
            lg = 1;
            nn = 2;
            while(nn < n) {
                nn = nn * 2;
                lg = lg + 1;
            }
            return lg;
        }
		public void setParameters(int n){
		   this.n = n;
		}
	}
}
