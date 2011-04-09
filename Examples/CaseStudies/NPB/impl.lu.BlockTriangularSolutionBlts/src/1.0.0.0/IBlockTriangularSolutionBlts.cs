using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.triangular.Lower;
using lu.BlockTriangularSolution;

namespace impl.lu.BlockTriangularSolutionBlts { 
	public class IBlockTriangularSolutionBlts<I, C, DIS> : BaseIBlockTriangularSolutionBlts<I, C, DIS>, IBlockTriangularSolution<I, C, DIS>
	where I:IInstance_LU<C>
	where C:IClass
	where DIS:ILower {
	    private int k;
	    private double omega;
	    private double[,,,] ldx;
	    private double[,,,] ldy;
	    private double[,,,] ldz;
	
		public IBlockTriangularSolutionBlts() { 
		
		} 
		
		public override void compute() { 
            int i, j, m, iex;
            double  tmp, tmp1;
            double[,] tmat = new double[5, 5];
            iex = 0;
            Exchange1.setParameters(rsd, iex, k);
            Exchange1.compute();
            for(j = jst; j<= jend; j++) {
                for(i = ist; i<= iend; i++) {
                    for(m = 1; m<= 5; m++) {
                        rsd[k-1, j+1, i+1, m -1] =  rsd[k-1, j+1, i+1, m -1]
             - omega * (  ldz[j-1, i-1, 0, m-1] * rsd[k-2, j+1, i+1, 0]
                        + ldz[j-1, i-1, 1, m-1] * rsd[k-2, j+1, i+1, 1]
                        + ldz[j-1, i-1, 2, m-1] * rsd[k-2, j+1, i+1, 2]
                        + ldz[j-1, i-1, 3, m-1] * rsd[k-2, j+1, i+1, 3]
                        + ldz[j-1, i-1, 4, m-1] * rsd[k-2, j+1, i+1, 4]);
                    }
                }
            }
            for(j=jst; j<=jend; j++) {
                for(i = ist; i<= iend; i++) {
                    for(m = 1; m<= 5; m++) {
                        rsd[k-1, j+1, i+1, m-1] =  rsd[k-1, j+1, i+1, m-1]
                        - omega * ( ldy[j-1, i-1, 0, m-1] * rsd[k-1, j, i+1, 0]
                                  + ldx[j-1, i-1, 0, m-1] * rsd[k-1, j+1, i, 0]
                                  + ldy[j-1, i-1, 1, m-1] * rsd[k-1, j, i+1, 1]
                                  + ldx[j-1, i-1, 1, m-1] * rsd[k-1, j+1, i, 1]
                                  + ldy[j-1, i-1, 2, m-1] * rsd[k-1, j, i+1, 2]
                                  + ldx[j-1, i-1, 2, m-1] * rsd[k-1, j+1, i, 2]
                                  + ldy[j-1, i-1, 3, m-1] * rsd[k-1, j, i+1, 3]
                                  + ldx[j-1, i-1, 3, m-1] * rsd[k-1, j+1, i, 3]
                                  + ldy[j-1, i-1, 4, m-1] * rsd[k-1, j, i+1, 4]
                                  + ldx[j-1, i-1, 4, m-1] * rsd[k-1, j+1, i, 4]);
                    }
                    for(m = 0; m< 5; m++) {
                        tmat[0, m] = d[j-1, i-1, 0, m];
                        tmat[1, m] = d[j-1, i-1, 1, m];
                        tmat[2, m] = d[j-1, i-1, 2, m];
                        tmat[3, m] = d[j-1, i-1, 3, m];
                        tmat[4, m] = d[j-1, i-1, 4, m];
                    }
                    tmp1 = 1.0d /tmat[0, 0];
                    tmp = tmp1 * tmat[0, 1];
                    tmat[1, 1] =  tmat[1, 1] - tmp * tmat[1, 0];
                    tmat[2, 1] =  tmat[2, 1] - tmp * tmat[2, 0];
                    tmat[3, 1] =  tmat[3, 1] - tmp * tmat[3, 0];
                    tmat[4, 1] =  tmat[4, 1] - tmp * tmat[4, 0];
                    rsd[k-1, j+1, i+1, 1] = rsd[k-1, j+1, i+1, 1] - rsd[k-1, j+1, i+1, 0] * tmp;

                    tmp = tmp1 * tmat[0, 2];
                    tmat[1, 2] =  tmat[1, 2] - tmp * tmat[1, 0];
                    tmat[2, 2] =  tmat[2, 2] - tmp * tmat[2, 0];
                    tmat[3, 2] =  tmat[3, 2] - tmp * tmat[3, 0];
                    tmat[4, 2] =  tmat[4, 2] - tmp * tmat[4, 0];
                    rsd[k-1, j+1, i+1, 2] = rsd[k-1, j+1, i+1, 2] - rsd[k-1, j+1, i+1, 0] * tmp;

                    tmp = tmp1 * tmat[0, 3];
                    tmat[1, 3] =  tmat[1, 3] - tmp * tmat[1, 0];
                    tmat[2, 3] =  tmat[2, 3] - tmp * tmat[2, 0];
                    tmat[3, 3] =  tmat[3, 3] - tmp * tmat[3, 0];
                    tmat[4, 3] =  tmat[4, 3] - tmp * tmat[4, 0];
                    rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3] - rsd[k-1, j+1, i+1, 0] * tmp;

                    tmp = tmp1 * tmat[0, 4];
                    tmat[1, 4] =  tmat[1, 4] - tmp * tmat[1, 0];
                    tmat[2, 4] =  tmat[2, 4] - tmp * tmat[2, 0];
                    tmat[3, 4] =  tmat[3, 4] - tmp * tmat[3, 0];
                    tmat[4, 4] =  tmat[4, 4] - tmp * tmat[4, 0];
                    rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4] - rsd[k-1, j+1, i+1, 0] * tmp;

                    tmp1 = 1.0d /tmat[1, 1];
                    tmp = tmp1 * tmat[1, 2];
                    tmat[2, 2] =  tmat[2, 2] - tmp * tmat[2, 1];
                    tmat[3, 2] =  tmat[3, 2] - tmp * tmat[3, 1];
                    tmat[4, 2] =  tmat[4, 2] - tmp * tmat[4, 1];
                    rsd[k-1, j+1, i+1, 2] = rsd[k-1, j+1, i+1, 2] - rsd[k-1, j+1, i+1, 1] * tmp;

                    tmp = tmp1 * tmat[1, 3];
                    tmat[2, 3] =  tmat[2, 3] - tmp * tmat[2, 1];
                    tmat[3, 3] =  tmat[3, 3] - tmp * tmat[3, 1];
                    tmat[4, 3] =  tmat[4, 3] - tmp * tmat[4, 1];
                    rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3] - rsd[k-1, j+1, i+1, 1] * tmp;

                    tmp = tmp1 * tmat[1, 4];
                    tmat[2, 4] =  tmat[2, 4] - tmp * tmat[2, 1];
                    tmat[3, 4] =  tmat[3, 4] - tmp * tmat[3, 1];
                    tmat[4, 4] =  tmat[4, 4] - tmp * tmat[4, 1];
                    rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4] - rsd[k-1, j+1, i+1, 1] * tmp;

                    tmp1 = 1.0d /tmat[2, 2];
                    tmp = tmp1 * tmat[2, 3];
                    tmat[3, 3] =  tmat[3, 3] - tmp * tmat[3, 2];
                    tmat[4, 3] =  tmat[4, 3] - tmp * tmat[4, 2];
                    rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3] - rsd[k-1, j+1, i+1, 2] * tmp;

                    tmp = tmp1 * tmat[2, 4];
                    tmat[3, 4] =  tmat[3, 4] - tmp * tmat[3, 2];
                    tmat[4, 4] =  tmat[4, 4] - tmp * tmat[4, 2];
                    rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4] - rsd[k-1, j+1, i+1, 2] * tmp;

                    tmp1 = 1.0d /tmat[3, 3];
                    tmp = tmp1 * tmat[3, 4];
                    tmat[4, 4] =  tmat[4, 4] - tmp * tmat[4, 3];
                    rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4] - rsd[k-1, j+1, i+1, 3] * tmp;

                    rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4]/ tmat[4, 4];
                    rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3]- tmat[4, 3] * rsd[k-1, j+1, i+1, 4];
                    rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3]/ tmat[3, 3];
                    rsd[k-1, j+1, i+1, 2] = rsd[k-1, j+1, i+1, 2] -tmat[3, 2] * rsd[k-1, j+1, i+1, 3] - tmat[4, 2] * 
                                                                       rsd[k-1, j+1, i+1, 4];
                    rsd[k-1, j+1, i+1, 2] = rsd[k-1, j+1, i+1, 2] /tmat[2, 2];
                    rsd[k-1, j+1, i+1, 1] = rsd[k-1, j+1, i+1, 1]- tmat[2, 1] * rsd[k-1, j+1, i+1, 2]-tmat[3, 1]*
                                                                       rsd[k-1, j+1, i+1, 3]-tmat[4, 1]*
                                                                       rsd[k-1, j+1, i+1, 4];
                    rsd[k-1, j+1, i+1, 1] = rsd[k-1, j+1, i+1, 1] /tmat[1, 1];
                    rsd[k-1, j+1, i+1, 0] = rsd[k-1, j+1, i+1, 0] -tmat[1, 0] * rsd[k-1, j+1, i+1, 1]-
                                                           tmat[2, 0] * rsd[k-1, j+1, i+1, 2]-
                                                           tmat[3, 0] * rsd[k-1, j+1, i+1, 3]-
                                                           tmat[4, 0] * rsd[k-1, j+1, i+1, 4];
                    rsd[k-1, j+1, i+1, 0] = rsd[k-1, j+1, i+1, 0] /tmat[0, 0];

                }
            }
            iex = 2;
            Exchange1.setParameters(rsd, iex, k);
            Exchange1.compute();
		}
		
		public void setParameters(int k, double omega, double[,,,] dx, double[,,,] dy, double[,,,] dz){
		   this.k     = k;
		   this.omega = omega;
		   this.ldx   = dx;
		   this.ldy   = dy;
		   this.ldz   = dz;
		}
	}
}