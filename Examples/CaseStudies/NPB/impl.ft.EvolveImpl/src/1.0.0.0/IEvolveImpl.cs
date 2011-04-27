using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.Evolve;

namespace impl.ft.EvolveImpl { 
	public class IEvolveImpl<I, C> : BaseIEvolveImpl<I, C>, IEvolve<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	    private double[, , ,] u0;
	    private double[, , ,] u1;
	    private double[] twiddle;
	    private int d1, d2, d3;
	
		public IEvolveImpl() { 
		
		} 
		
		public override int go() { 
            int i, j, k, idx, m1, m2, _i, _j, _k;
            for(k = 0; k < d3; k++) {
                for(j = 0; j < d2; j++) {
                    for(i = 0; i < d1; i++) {
                        idx = ((k*d2+j)*d1+i);

                        m1 = (idx*2 % size1);
                        m2 = (m1 % size2);
                        _i = idx*2/size1;
                        _j = m1/size2;
                        _k = m2/2;

                        u0[_i,_j,_k,REAL] = u0[_i,_j,_k,REAL]*twiddle[idx];
                        u0[_i,_j,_k,IMAG] = u0[_i,_j,_k,IMAG]*twiddle[idx];
                        u1[_i,_j,_k,REAL] = u0[_i,_j,_k,REAL];
                        u1[_i,_j,_k,IMAG] = u0[_i,_j,_k,IMAG];
                    }
                }
            }
            return 0;
		}
		public void setParameters(double[, , ,] u0, double[, , ,] u1, double[] twiddle, int d1, int d2, int d3){
		    this.u0      = u0;
		    this.u1      = u1;
		    this.twiddle = twiddle;
		    this.d1      = d1;
		    this.d2      = d2;
		    this.d3      = d3;
		}
	}
}
