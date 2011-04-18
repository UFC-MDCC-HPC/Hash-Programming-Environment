using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.data.BoundaryValues;

namespace impl.lu.data.BoundaryValues_Setbv { 
	public class IBoundaryValues_Setbv<I, C> : BaseIBoundaryValues_Setbv<I, C>, IBoundaryValues<I, C>
	where I:IInstance_LU<C>
	where C:IClass{
	
		public IBoundaryValues_Setbv() { 
		
		} 
		
		public override int go() { 

            int i, j, k, iglob, jglob;
            for(j = 1; j<= ny; j++) {
                jglob = jpt + j;
                for(i = 1; i<= nx; i++) {
                    iglob = ipt + i;
                    Exact.setParameters(iglob, jglob, 1, u, 0, j+1, i+1);
                    Exact.go();
                    Exact.setParameters(iglob, jglob, nz, u, nz-1, j+1, i+1);
                    Exact.go();
                }
            }
            if(west==-1) {
                for(k = 1; k<= nz; k++) {
                    for(i = 1; i<= nx; i++) {
                        iglob = ipt + i;
                        Exact.setParameters(iglob, 1, k, u, k-1, 1+1, i+1);
                        Exact.go();
                    }
                }
            }
            if(east==-1) {
                for(k = 1; k<= nz; k++) {
                    for(i = 1; i<= nx; i++) {
                        iglob = ipt + i;
                        Exact.setParameters(iglob, ny0, k, u, k-1, ny+1, i+1);
                        Exact.go();
                    }
                }
            }
            if(north==-1) {
                for(k = 1; k<= nz; k++) {
                    for(j = 1; j<= ny; j++) {
                        jglob = jpt + j;
                        Exact.setParameters(1, jglob, k, u, k-1, j+1, 1+1);
                        Exact.go();
                    }
                }
            }
            if(south==-1) {
                for(k = 1; k<= nz; k++) {
                    for(j = 1; j<= ny; j++) {
                        jglob = jpt + j;
                        Exact.setParameters(nx0, jglob, k, u, k-1, j+1, nx+1);
                        Exact.go();
                    }
                }
            }
			return 0;
		}
	}
}
