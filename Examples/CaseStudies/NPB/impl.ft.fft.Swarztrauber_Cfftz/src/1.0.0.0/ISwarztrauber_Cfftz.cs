using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.fft.Swarztrauber;

namespace impl.ft.fft.Swarztrauber_Cfftz { 
	public class ISwarztrauber_Cfftz<I, C> : BaseISwarztrauber_Cfftz<I, C>, ISwarztrauber<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private int dir, m, n;
	    private double[, , ,] y;
	
		public ISwarztrauber_Cfftz() { 
		
		} 
		
		public override int go() { 
            int i,j,l,mx;
            mx = (int)u[0, 0];
            if((dir != 1 && dir != -1) || m < 1 || m > mx) {
                Console.WriteLine("CFFTZ: Either U has not been initialized, or else one of the input parameters iis invalid " + dir + " " + m + " " + mx);
            }
            for(l = 1; l <= m; l = l + 2) {
                fftz2(dir, l, m, n, u, y, 0, 1);
                if(l == m) {
                    for(j = 0; j < n; j++) {
                        for(i = 0; i < fftblock; i++) {
                            y[0, j, i, REAL] = y[1, j, i, REAL];
                            y[0, j, i, IMAG] = y[1, j, i, IMAG];
                        }
                    }
                    return 0;
                }
                fftz2(dir, l + 1, m, n, u, y, 1, 0);
            }
		   return 0;
		}
        public void fftz2(int dir, int l, int m, int n, double[,] u, double[, , ,] y, int iread, int iwrite) { //u=u x=ytemp y = ytemp
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
        }
		public void setParameters(int dir, int m, int n, double[, , ,] y){
		   this.dir = dir;
		   this.m   = m;
		   this.n   = n;
		   this.y   = y;
		}
	}
}
