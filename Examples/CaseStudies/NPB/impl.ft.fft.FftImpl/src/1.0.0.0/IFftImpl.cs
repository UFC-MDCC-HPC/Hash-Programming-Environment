using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.fft.Fft;

namespace impl.ft.fft.FftImpl { 
	public class IFftImpl<I, C> : BaseIFftImpl<I, C>, IFft<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private int dir;
	    private double[, , ,] u1;
	    private double[, , ,] u02;
	
		public IFftImpl() { 
		
		} 
		
		public override int go() { 
            if(dir == 1) {
                if(layout_type == layout_0D) {
                    Cffts1.setParameters(dir, dims[0, 0], dims[1, 0], dims[2, 0], u1, u1);
                    Cffts1.go();
                    Cffts2.setParameters(dir, dims[0, 1], dims[1, 1], dims[2, 1], u1, u1);
                    Cffts2.go();
                    Cffts3.setParameters(dir, dims[0, 2], dims[1, 2], dims[2, 2], u1, u02);
                    Cffts3.go();
                }
                else if(layout_type == layout_1D) {
                    Cffts1.setParameters(dir, dims[0, 0], dims[1, 0], dims[2, 0], u1, u1);
                    Cffts1.go();
                    Cffts2.setParameters(dir, dims[0, 1], dims[1, 1], dims[2, 1], u1, u1);
                    Cffts2.go();
                    Transpose_xy_z.setParameters(1, 2, u1, u02);
                    Transpose_xy_z.go();
                    Cffts1.setParameters(dir, dims[0, 2], dims[1, 2], dims[2, 2], u02, u02);
                    Cffts1.go();
                }
                else if(layout_type == layout_2D) {
                    Cffts1.setParameters(dir, dims[0, 0], dims[1, 0], dims[2, 0], u1, u1);
                    Cffts1.go();
                    Transpose_x_y.setParameters(0, 1, u1, u02);
                    Transpose_x_y.go();
                    Cffts1.setParameters(dir, dims[0, 1], dims[1, 1], dims[2, 1], u02, u02);
                    Cffts1.go();
                    Transpose_x_z.setParameters(1, 2, u02, u1);
                    Transpose_x_z.go();
                    Cffts1.setParameters(dir, dims[0, 2], dims[1, 2], dims[2, 2], u1, u02);
                    Cffts1.go();
                }
            }
            else {
                if(layout_type == layout_0D) {
                    Cffts3.setParameters(dir, dims[0, 2], dims[1, 2], dims[2, 2], u1, u1);
                    Cffts3.go();
                    Cffts2.setParameters(dir, dims[0, 1], dims[1, 1], dims[2, 1], u1, u1);
                    Cffts2.go();
                    Cffts1.setParameters(dir, dims[0, 0], dims[1, 0], dims[2, 0], u1, u02);
                    Cffts1.go();
                }
                else if(layout_type == layout_1D) {
                    Cffts1.setParameters(dir, dims[0, 2], dims[1, 2], dims[2, 2], u1, u1);
                    Cffts1.go();
                    Transpose_x_yz.setParameters(2, 1, u1, u02);
                    Transpose_x_yz.go();
                    Cffts2.setParameters(dir, dims[0, 1], dims[1, 1], dims[2, 1], u02, u02);
                    Cffts2.go();
                    Cffts1.setParameters(dir, dims[0, 0], dims[1, 0], dims[2, 0], u02, u02);
                    Cffts1.go();
                }
                else if(layout_type == layout_2D) {
                    Cffts1.setParameters(dir, dims[0, 2], dims[1, 2], dims[2, 2], u1, u1);
                    Cffts1.go();
                    Transpose_x_z.setParameters(2, 1, u1, u02);
                    Transpose_x_z.go();
                    Cffts1.setParameters(dir, dims[0, 1], dims[1, 1], dims[2, 1], u02, u02);
                    Cffts1.go();
                    Transpose_x_y.setParameters(1, 0, u02, u1);
                    Transpose_x_y.go();
                    Cffts1.setParameters(dir, dims[0, 0], dims[1, 0], dims[2, 0], u1, u02);
                    Cffts1.go();
                }
            }
		    return 0;
		}
		public void setParameters(int dir, double[, , ,] u1, double[, , ,] u02){
		   this.dir = dir;
		   this.u1  = u1;
		   this.u02 = u02;
		}
	}
}
