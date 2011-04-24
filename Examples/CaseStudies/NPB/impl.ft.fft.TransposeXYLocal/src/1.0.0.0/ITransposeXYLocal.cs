using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.XY;
using ft.fft.TransposeLocal;

namespace impl.ft.fft.TransposeXYLocal { 
	public class ITransposeXYLocal<I, C, DIR> : BaseITransposeXYLocal<I, C, DIR>, ITransposeLocal<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXY{
	   
	    private int d1, d2, d3;
	    private double[, , ,] xin;
	    private double[, , ,] xout;
	
		public ITransposeXYLocal() { 
		
		} 
		
		public override int go() { 
            int m1, m2, _i, _j, _k, om1, om2, o_i, o_j, o_k;
            int i, j, k, ii, io;
            for(k = 0; k < d3; k++) {
                for(i = 0; i < d1; i++) {
                    for(j = 0; j < d2; j++) {
                        ii = ((k*d2+j)*d1+i)*2;
                        io = ((i*d3+k)*d2+j)*2;

                        m1 = (ii % size1);
                        m2 = (m1 % size2);
                        _i = ii/size1;
                        _j = m1/size2;
                        _k = m2/2;

                        om1 = (io % size1);
                        om2 = (om1 % size2);
                        o_i = io/size1;
                        o_j = om1/size2;
                        o_k = om2/2;

                        xout[o_i, o_j, o_k, REAL] = xin[_i, _j, _k, REAL];
                        xout[o_i, o_j, o_k, IMAG] = xin[_i, _j, _k, IMAG];
                    }
                }
            }
		   return 0;
		}
		public void setParameters(int d1, int d2, int d3, double[, , ,] xin, double[, , ,] xout){
		   this.d1 = d1;
		   this.d2 = d2;
		   this.d3 = d3;
		   this.xin = xin;
		   this.xout = xout;
		}
	}
}
