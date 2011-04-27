using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.Checksum;
using MPI;

namespace impl.ft.ChecksumImpl { 
	public class IChecksumImpl<I, C> : BaseIChecksumImpl<I, C>, IChecksum<I, C>
	where I:IInstance_FT<C>
	where C:IClass{

	    private int iter, d1, d2, d3;
	    private double[] sums;
	    private double[, , ,] u2;
	    private Intracommunicator worldcomm;

		public IChecksumImpl() { 
		
		} 
		
		public override int go() { 
            int j, q,r,s, m1,m2,_i,_j,_k;
            double chk_Real, chk_Imag;
            double allchk_Real=0, allchk_Imag=0;
            int node = this.GlobalRank;
            
            worldcomm = this.WorldComm;

            chk_Real = 0.0;
            chk_Imag = 0.0;

            int idx=0;
            for(j = 1; j <= 1024; j++) {
                q = (int)mod(j, nx)+1;
                if(q >= xstart[0] && q <= xend[0]) {
                    r = (int)mod(3*j, ny)+1;
                    if(r >= ystart[0] && r <= yend[0]) {
                        s = (int)mod(5*j, nz)+1;
                        if(s >= zstart[0] && s <= zend[0]) {

                            idx = (((s-zstart[0])*d2+(r-ystart[0]))*d1+(q-xstart[0]))*2;
                            m1 = (idx % size1);
                            m2 = (m1 % size2);
                            _i = idx/size1;
                            _j = m1/size2;
                            _k = m2/2;
                            chk_Real=chk_Real+u2[_i,_j,_k,REAL];
                            chk_Imag=chk_Imag+u2[_i,_j,_k,IMAG];
                        }
                    }
                }
            }
            chk_Real = chk_Real/((double)(nx*ny*nz));
            chk_Imag = chk_Imag/((double)(nx*ny*nz));

            allchk_Real = worldcomm.Reduce<double>(chk_Real, MPI.Operation<double>.Add, root);
            allchk_Imag = worldcomm.Reduce<double>(chk_Imag, MPI.Operation<double>.Add, root);

            if(node == root) {
                Console.WriteLine(" T = " + iter + "  Checksum = (" + allchk_Real + ") (" + allchk_Imag + ")");
            }
            if(iter >= 0) {
                sums[iter*2+REAL] = allchk_Real;
                sums[iter*2+IMAG] = allchk_Imag;
            }
		    return 0;
		}
		public static double mod(double a, double b) { return (a % b); }
		public void setParameters(int iter, double[] sums, double[, , ,] u2, int d1, int d2, int d3){
		   this.iter = iter;
		   this.sums = sums;
		   this.u2   = u2;
		   this.d1   = d1;
		   this.d2   = d2;
		   this.d3   = d3;
		}
	}
}
