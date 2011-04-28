using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.Z;
using ft.fft.Cffts;

namespace impl.ft.fft.Cffts3 { 
	public class ICffts3<I, C, DIR> : BaseICffts3<I, C, DIR>, ICffts<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IZ{
	   
	    private int dir, d1, d2, d3;
	    private double[, , ,] x;
	    private double[, , ,] xout;
	
		public ICffts3() { 
		
		} 
		
		public override int go() { 
            int logd3;
            double[,,,] y = new double[2, d3, fftblockpad, 2];
            int i, j, k, ii, io;

            logd3 = ilog2(d3);

            for(j = 0; j < d2; j++) {
                for(ii = 0; ii <= d1 - fftblock; ii = ii + fftblock) {
                    for(k = 0; k < d3; k++) {
                        for(i = 0; i < fftblock; i++) {
                            io = ((k*d2+j)*d1+(i+ii))*2;

                            int m1 = (io % size1);
                            int m2 = (m1 % size2);
                            int _i = io/size1;
                            int _j = m1/size2;
                            int _k = m2/2;

                            y[0, k, i, REAL] = x[_i, _j, _k, REAL];
                            y[0, k, i, IMAG] = x[_i, _j, _k, IMAG];
                        }
                    }

                    Swarztrauber.setParameters(dir, logd3, d3, y);
                    Swarztrauber.go();

                    for(k = 0; k < d3; k++) {
                        for(i = 0; i < fftblock; i++) {
                            io  = (((k*d2+j)*d1+(i+ii))*2);

                            int m1 = (io % size1);
                            int m2 = (m1 % size2);
                            int _i = io/size1;
                            int _j = m1/size2;
                            int _k = m2/2;

                            xout[_i, _j, _k, REAL] = y[0, k, i, REAL];
                            xout[_i, _j, _k, IMAG] = y[0, k, i, IMAG];
                        }
                    }
                }
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
		public void setParameters(int dir, int d1, int d2, int d3, double[, , ,] x, double[, , ,] xout){
		    this.dir  = dir;
		    this.d1   = d1;
		    this.d2   = d2;
		    this.d3   = d3;
		    this.x    = x;
		    this.xout = xout;
		}
	}
}
