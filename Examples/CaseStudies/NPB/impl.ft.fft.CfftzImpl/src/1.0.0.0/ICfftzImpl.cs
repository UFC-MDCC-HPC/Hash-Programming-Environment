using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.fft.Cfftz;

namespace impl.ft.fft.CfftzImpl { 
	public class ICfftzImpl<I, C> : BaseICfftzImpl<I, C>, ICfftz<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	    
	    private int dir, m, n;
	    private double[, , ,] y;
	
		public ICfftzImpl() { 
		
		} 
		
		public override int go() { 
            int i,j,l,mx;
            mx = (int)u[0, 0];
            if((dir != 1 && dir != -1) || m < 1 || m > mx) {
                Console.WriteLine("CFFTZ: Either U has not been initialized, or else one of the input parameters iis invalid " + dir + " " + m + " " + mx);
            }
            for(l = 1; l <= m; l = l + 2) {
                Fftz2.setParameters(dir, l, m, n, u, y, 0, 1);
                Fftz2.go();
                if(l == m) {
                    for(j = 0; j < n; j++) {
                        for(i = 0; i < fftblock; i++) {
                            y[0, j, i, REAL] = y[1, j, i, REAL];
                            y[0, j, i, IMAG] = y[1, j, i, IMAG];
                        }
                    }
                    return 0;
                }
                Fftz2.setParameters(dir, l + 1, m, n, u, y, 1, 0);
                Fftz2.go();
            }
            return 0;
		}
		public void setParameters(int dir, int m, int n, double[, , ,] y){
		   this.dir = dir;
		   this.m   = m;
		   this.n   = n;
		   this.y   = y;
		}
	}
}
