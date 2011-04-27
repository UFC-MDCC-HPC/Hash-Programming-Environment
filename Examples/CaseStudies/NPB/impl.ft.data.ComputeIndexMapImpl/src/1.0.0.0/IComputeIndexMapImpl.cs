using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.data.ComputeIndexMap;

namespace impl.ft.data.ComputeIndexMapImpl { 
	public class IComputeIndexMapImpl<I, C> : BaseIComputeIndexMapImpl<I, C>, IComputeIndexMap<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private double[] twiddle;
	    private int d1, d2, d3;
	
		public IComputeIndexMapImpl() { 
		
		} 
		
		public override int go() { 
            int i, j, k, ii, ii2, jj, ij2, kk;
            double ap;
            double alpha=.000001, pi = Math.PI;

            ap = -4.0 * alpha * pi * pi;

            int idx;
            if(layout_type == layout_0D) { //xyz layout
                for(i = 1; i <= d1; i++) {
                    ii =  (int)mod(i+xstart[2]-2+nx/2, nx) - nx/2;
                    ii2 = ii*ii;
                    for(j = 1; j <= d2; j++) {
                        jj = (int)mod(j+ystart[2]-2+ny/2, ny) - ny/2;
                        ij2 = jj * jj + ii2;
                        for(k = 1; k <= d3; k++) {
                            kk = (int)mod(k+zstart[2]-2+nz/2, nz) - nz/2;
                            idx = (((k-1)*d2+(j-1))*d1+(i-1));//twiddle[k, j, i]
                            twiddle[idx] = Math.Exp(ap * (double)(kk * kk + ij2));
                        }
                    }
                }
            }
            else if(layout_type == layout_1D) { // zxy layout 
                for(i = 1; i <= d2; i++) {
                    ii =  (int)mod(i+xstart[2]-2+nx/2, nx) - nx/2;
                    ii2 = ii*ii;
                    for(j = 1; j <= d3; j++) {
                        jj = (int)mod(j+ystart[2]-2+ny/2, ny) - ny/2;
                        ij2 = jj*jj+ii2;
                        for(k = 1; k <= d1; k++) {
                            kk = (int)mod(k+zstart[2]-2+nz/2, nz) - nz/2;
                            idx = (((j-1)*d2+(i-1))*d1+(k-1)); //twiddle[j, i, k] 
                            twiddle[idx] = Math.Exp(ap * (double)(kk * kk + ij2));
                        }
                    }
                }
            }
            else if(layout_type == layout_2D) { // zxy layout
                for(i = 1; i <= d2; i++) {
                    ii =  (int)mod(i+xstart[2]-2+nx/2, nx) - nx/2;
                    ii2 = ii*ii;
                    for(j = 1; j <= d3; j++) {
                        jj = (int)mod(j+ystart[2]-2+ny/2, ny) - ny/2;
                        ij2 = jj*jj+ii2;
                        for(k = 1; k <= d1; k++) {
                            kk = (int)mod(k+zstart[2]-2+nz/2, nz) - nz/2;
                            idx = (((j-1)*d2+(i-1))*d1+(k-1)); // twiddle[j,i,k]
                            twiddle[idx] = Math.Exp(ap * (double)(kk*kk+ij2));
                        }
                    }
                }
            }
            else {
                Console.WriteLine(" Unknown layout type " + layout_type);
            }
		    return 0;
		}
		public static double mod(double a, double b) { return (a % b); }
		public void setParameters(double[] twiddle, int d1, int d2, int d3){
		   this.twiddle = twiddle;
		   this.d1 = d1;
		   this.d2 = d2;
		   this.d3 = d3;
		}
	}
}
