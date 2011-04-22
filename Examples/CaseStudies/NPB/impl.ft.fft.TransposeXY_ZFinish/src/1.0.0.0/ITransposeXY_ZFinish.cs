using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.XY_Z;
using ft.fft.TransposeFinish;

namespace impl.ft.fft.TransposeXY_ZFinish { 
	public class ITransposeXY_ZFinish<I, C, DIR> : BaseITransposeXY_ZFinish<I, C, DIR>, ITransposeFinish<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXY_Z{
	   
	    private int d1, d2, d3;
	    private double[, , ,] xin;
	    private double[, , ,] xout;
	    
		public ITransposeXY_ZFinish() { 
		
		} 
		
		public override int go() { 
            int m1, m2, _i, _j, _k, om1, om2, o_i, o_j, o_k;
            int n1 = d1*d2;
            int n2 = d3;
            int i, j, p, ioff, ii, io;
            for(p = 0; p <= np2 - 1; p++) {
                ioff = p*n2;
                for(j = 0; j < n1 / np2; j++) {
                    for(i = 0; i < n2; i++) {
                        ii = ((p*(n1/np2)+j)*n2+i)*2;
                        io = (j*n2*np2+(i+ioff))*2;
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
