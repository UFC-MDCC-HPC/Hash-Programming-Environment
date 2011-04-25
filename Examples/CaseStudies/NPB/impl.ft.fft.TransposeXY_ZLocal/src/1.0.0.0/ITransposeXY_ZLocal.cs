using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.XY_Z;
using ft.fft.TransposeLocal;

namespace impl.ft.fft.TransposeXY_ZLocal { 
	public class ITransposeXY_ZLocal<I, C, DIR> : BaseITransposeXY_ZLocal<I, C, DIR>, ITransposeLocal<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXY_Z{
	   
	    private int d1, d2, d3;
	    private double[, , ,] xin;
	    private double[, , ,] xout;
	
		public ITransposeXY_ZLocal() { 
		
		} 
		
		public override int go() { 
            double[,,] z = new double[transblockpad, transblock, 2];
            int i, j, ii, jj, iin, io;
            int m1, m2, _i, _j, _k, om1, om2, o_i, o_j, o_k;
            int n1 = d1*d2;
            int n2 = d3;
            if(n1 < transblock || n2 < transblock) {
                if(n1 >= n2) {
                    for(j = 0; j < n2; j++) {
                        for(i = 0; i < n1; i++) {
                            iin = (j * n1 + i)*2;
                            io = (i * n2 + j)*2;

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
                else {
                    for(i = 0; i < n1; i++) {
                        for(j = 0; j < n2; j++) {
                            iin = (j * n1 + i)*2;
                            io = (i * n2 + j)*2;

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
            else {
                for(j = 0; j <= n2 - 1; j = j + transblock) {
                    for(i = 0; i <= n1 - 1; i = i + transblock) {
                        for(jj = 0; jj < transblock; jj++) {
                            for(ii = 0; ii < transblock; ii++) {
                                iin = ((j+jj)*n1+(i+ii))*2;

                                m1 = (iin % size1);
                                m2 = (m1 % size2);
                                _i = iin/size1;
                                _j = m1/size2;
                                _k = m2/2;

                                z[ii,jj,REAL] = xin[_i, _j, _k, REAL];
                                z[ii,jj,IMAG] = xin[_i, _j, _k, IMAG];
                            }
                        }
                        for(ii = 0; ii < transblock; ii++) {
                            for(jj = 0; jj < transblock; jj++) {
                                io = ((i+ii)*n2+(j+jj))*2;

                                m1 = (io % size1);
                                m2 = (m1 % size2);
                                _i = io/size1;
                                _j = m1/size2;
                                _k = m2/2;
                                xout[_i, _j, _k, REAL] = z[ii, jj, REAL];
                                xout[_i, _j, _k, IMAG] = z[ii, jj, IMAG];
                            }
                        }

                    }
                }
            }
            return 0;
		}
		public void setParameters(int d1, int d2, int d3, double[, , ,] xin, double[, , ,] xout) {
		   this.d1 = d1;
		   this.d2 = d2;
		   this.d3 = d3;
		   this.xin = xin;
		   this.xout = xout;
		}
	}
}
