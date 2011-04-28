using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.fft.Fftz2;

namespace impl.ft.fft.Fftz2Impl { 
	public class IFftz2Impl<I, C> : BaseIFftz2Impl<I, C>, IFftz2<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private int dir, l, m, n, iread, iwrite;
		private double[, , ,] y;
		private double[,] u;
	
		public IFftz2Impl() { 
		
		} 
		
		public override int go() { 
            int k, n1, li, lj, lk, ku, i, j, i11, i12, i21, i22;
            double[] u1 = new double[2];
            double[] x11= new double[2];
            double[] x21= new double[2];

            int ny  = fftblock;
            int ny1 = fftblockpad;

            n1 = n / 2;
            lk = (int)Math.Pow(2, (l - 1));
            li = (int)Math.Pow(2, (m - l));
            lj = 2 * lk;
            ku = li;

            for(i = 0; i <= li - 1; i++) {
                i11 = i * lk;
                i12 = i11 + n1;
                i21 = i * lj;
                i22 = i21 + lk;

                u1[REAL] = u[(ku+i), REAL];
                if(dir >= 1) {
                    u1[1] = u[ku+i, IMAG];
                }
                else {
                    u1[1] = -1*u[ku+i, IMAG];
                }

                for(k = 0; k <= lk - 1; k++) {
                    for(j = 0; j < ny; j++) {
                        x11[REAL] = y[iread, i11 + k, j, REAL];
                        x11[IMAG] = y[iread, i11 + k, j, IMAG];
                        x21[REAL] = y[iread, i12 + k, j, REAL];
                        x21[IMAG] = y[iread, i12 + k, j, IMAG];
                        y[iwrite, i21 + k, j, REAL] = x11[REAL] + x21[REAL];
                        y[iwrite, i21 + k, j, IMAG] = x11[IMAG] + x21[IMAG];
                        y[iwrite, i22 + k, j, REAL] = u1[REAL] * (x11[REAL] - x21[REAL]) - u1[IMAG] * (x11[IMAG] - x21[IMAG]);
                        y[iwrite, i22 + k, j, IMAG] = u1[IMAG] * (x11[REAL] - x21[REAL]) + u1[REAL] * (x11[IMAG] - x21[IMAG]);
                    }
                }
            }
		    return 0;
		}
		public void setParameters(int dir, int l, int m, int n, double[,] u, double[, , ,] y, int iread, int iwrite){
		   this.dir    = dir;
		   this.l      = l;
		   this.m      = m;
		   this.n      = n;
		   this.iread  = iread;
		   this.iwrite = iwrite;
		   
		   this.y = y;
		   this.u = u;
		}
	}
}
