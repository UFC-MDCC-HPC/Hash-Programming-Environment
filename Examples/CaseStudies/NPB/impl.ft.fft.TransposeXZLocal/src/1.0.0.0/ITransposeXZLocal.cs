using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.XZ;
using ft.fft.TransposeLocal;

namespace impl.ft.fft.TransposeXZLocal { 
	public class ITransposeXZLocal<I, C, DIR> : BaseITransposeXZLocal<I, C, DIR>, ITransposeLocal<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXZ{
	   
	    private int d1, d2, d3;
	    private double[, , ,] xin;
	    private double[, , ,] xout;
	
		public ITransposeXZLocal() { 
		
		} 
		
		public override int go() { 
            double[,,] buf = new double[maxdim, transblockpad, 2];
            int block1, block3;
            int i, j, k, kk, ii, i1, k1;
            int m1, m2, _i, _j, _k, om1, om2, o_i, o_j, o_k;

            if(d1 < 32)
                goto G100;
            block3 = d3;
            if(block3 == 1)
                goto G100;
            if(block3 > transblock)
                block3 = transblock;
            block1 = d1;
            if(block1*block3 > transblock*transblock)
                block1 = transblock*transblock/block3;
            int iin = 0, io = 0;
            for(j = 0; j < d2; j++) {
                for(kk = 0; kk <= d3 - block3; kk = kk + block3) {
                    for(ii = 0; ii <= d1 - block1; ii = ii + block1) {
                        for(k = 0; k < block3; k++) {
                            k1 = k + kk;
                            for(i = 0; i < block1; i++) {
                                iin = ((k1*d2+j)*d1+(i+ii))*2;

                                m1 = (iin % size1);
                                m2 = (m1 % size2);
                                _i = iin/size1;
                                _j = m1/size2;
                                _k = m2/2;

                                buf[i, k, REAL] = xin[_i, _j, _k, REAL];
                                buf[i, k, IMAG] = xin[_i, _j, _k, IMAG];
                            }
                        }
                        for(i = 0; i < block1; i++) {
                            i1 = i + ii;
                            for(k = 0; k < block3; k++) {
                                io  = ((i1*d2+j)*d3+(k+kk))*2;

                                m1 = (io % size1);
                                m2 = (m1 % size2);
                                _i = io/size1;
                                _j = m1/size2;
                                _k = m2/2;

                                xout[_i, _j, _k, REAL] = buf[i, k, REAL];
                                xout[_i, _j, _k, IMAG] = buf[i, k, IMAG];
                            }
                        }
                    }
                }
            }
            return 0;

            G100: {
                for(j = 0; j < d2; j++) {
                    for(k = 0; k < d3; k++) {
                        for(i = 0; i < d1; i++) {
                            iin = ((k*d2+j)*d1+i)*2;
                            io  = ((i*d2+j)*d3+k)*2;

                            m1 = (iin % size1);
                            m2 = (m1 % size2);
                            _i = iin/size1;
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
