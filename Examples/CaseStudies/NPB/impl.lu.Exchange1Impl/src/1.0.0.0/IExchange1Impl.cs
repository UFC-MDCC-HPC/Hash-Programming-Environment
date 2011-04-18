using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange1;

namespace impl.lu.Exchange1Impl { 
	public class IExchange1Impl<I, C> : BaseIExchange1Impl<I, C>, IExchange1<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
	    private double[,,,] g;
	    private int iex;
	    private int k;
	    
		public IExchange1Impl() { 

		}

		public override int go() { 

            if(k>=0) {
                int i, j;
                if(iex == 0) {
                    if(north != -1) {
                        double[] dum1;
                        dum1 = Input_buffer.Array = new double[5*(jend-jst+1)];
                        int idx = 0;
                        Shift_to_south.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(north, from_n, dum1);mid.Wait();
                        for(j=jst; j<=jend; j++) {
                            g[k-1, j+1, 1, 0] = dum1[0+idx];
                            g[k-1, j+1, 1, 1] = dum1[1+idx];
                            g[k-1, j+1, 1, 2] = dum1[2+idx];
                            g[k-1, j+1, 1, 3] = dum1[3+idx];
                            g[k-1, j+1, 1, 4] = dum1[4+idx];
                            idx = idx + 5;
                        }
                    }
                    if(west != -1) {
                        double[] dum1;
                        dum1 = Input_buffer.Array = new double[(5*(iend-ist+1))];
                        int idx = 0;
                        Shift_to_east.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(west, from_w, dum1);mid.Wait();
                        for(i=ist; i<=iend; i++) {
                            g[k-1, 1, i+1, 0] = dum1[0+idx];
                            g[k-1, 1, i+1, 1] = dum1[1+idx];
                            g[k-1, 1, i+1, 2] = dum1[2+idx];
                            g[k-1, 1, i+1, 3] = dum1[3+idx];
                            g[k-1, 1, i+1, 4] = dum1[4+idx];
                            idx = idx + 5;
                        }
                    }
                }
                else if(iex == 1) {
                    if(south != -1) {
                        double[] dum1;
                        dum1 = Input_buffer.Array = new double[(5*(jend-jst+1))];
                        int idx = 0;
                        Shift_to_north.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(south, from_s, dum1);mid.Wait();
                        for(j=jst; j<=jend; j++) {
                            g[k-1, j+1, nx+2, 0] = dum1[0+idx];
                            g[k-1, j+1, nx+2, 1] = dum1[1+idx];
                            g[k-1, j+1, nx+2, 2] = dum1[2+idx];
                            g[k-1, j+1, nx+2, 3] = dum1[3+idx];
                            g[k-1, j+1, nx+2, 4] = dum1[4+idx];
                            idx = idx + 5;
                        }
                    }
                    if(east != -1) {
                        double[] dum1;
                        dum1 = Input_buffer.Array = new double[(5*(iend-ist+1))];
                        int idx = 0;
                        Shift_to_west.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(east, from_e, dum1);mid.Wait();
                        for(i=ist; i<=iend; i++) {
                            g[k-1, ny+2, i+1, 0] = dum1[0+idx];
                            g[k-1, ny+2, i+1, 1] = dum1[1+idx];
                            g[k-1, ny+2, i+1, 2] = dum1[2+idx];
                            g[k-1, ny+2, i+1, 3] = dum1[3+idx];
                            g[k-1, ny+2, i+1, 4] = dum1[4+idx];
                            idx = idx + 5;
                        }
                    }
                }
                else if(iex == 2) {
                    if(south != -1) {
                        double[] dum;
                        dum = Output_buffer.Array = new double[5*(jend-jst+1)];
                        int idx = 0;
                        for(j=jst; j<=jend; j++) {
                            dum[0+idx] = g[k-1, j+1, nx+1, 0];
                            dum[1+idx] = g[k-1, j+1, nx+1, 1];
                            dum[2+idx] = g[k-1, j+1, nx+1, 2];
                            dum[3+idx] = g[k-1, j+1, nx+1, 3];
                            dum[4+idx] = g[k-1, j+1, nx+1, 4];
                            idx = idx + 5;
                        }
                        Shift_to_south.initiate_send();//worldcomm.Send<double>(dum, south, from_n);
                    }
                    if(east != -1) {
                        double[] dum;
                        dum = Output_buffer.Array = new double[(5*(iend-ist+1))];
                        int idx = 0;
                        for(i=ist; i<=iend; i++) {
                            dum[0+idx] = g[k-1, ny+1, i+1, 0];
                            dum[1+idx] = g[k-1, ny+1, i+1, 1];
                            dum[2+idx] = g[k-1, ny+1, i+1, 2];
                            dum[3+idx] = g[k-1, ny+1, i+1, 3];
                            dum[4+idx] = g[k-1, ny+1, i+1, 4];
                            idx = idx + 5;
                        }
                        Shift_to_east.initiate_send();//worldcomm.Send<double>(dum, east, from_w);
                    }
                }
                else {
                    if(north != -1) {
                        double[] dum;
                        dum = Output_buffer.Array = new double[(5*(jend-jst+1))];
                        int idx = 0;
                        for(j=jst; j<=jend; j++) {
                            dum[0+idx] = g[k-1, j+1, 2, 0];
                            dum[1+idx] = g[k-1, j+1, 2, 1];
                            dum[2+idx] = g[k-1, j+1, 2, 2];
                            dum[3+idx] = g[k-1, j+1, 2, 3];
                            dum[4+idx] = g[k-1, j+1, 2, 4];
                            idx = idx + 5;
                        }
                        Shift_to_north.initiate_send();//worldcomm.Send<double>(dum, north, from_s);
                    }
                    if(west != -1) {
                        double[] dum;
                        dum = Output_buffer.Array = new double[(5*(iend-ist+1))];
                        int idx = 0;
                        for(i=ist; i<=iend; i++) {
                            dum[0+idx] = g[k-1, 2, i+1, 0];
                            dum[1+idx] = g[k-1, 2, i+1, 1];
                            dum[2+idx] = g[k-1, 2, i+1, 2];
                            dum[3+idx] = g[k-1, 2, i+1, 3];
                            dum[4+idx] = g[k-1, 2, i+1, 4];
                            idx = idx + 5;
                        }
                        Shift_to_west.initiate_send();//worldcomm.Send<double>(dum, west, from_e);
                    }
                }
            }
            else {
                int i, j, k0;
                int ipos1, ipos2;
                int bsize = 10*ny*nz;
                int size2 = bsize / 5;
                double[] buf1;
                buf1 = Input_buffer.Array = new double[bsize];
                double[] buf;
                buf = Output_buffer.Array  = new double[bsize];

                if(iex==0) {
                    if(north!=-1) {
                        Shift_to_south.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(north, from_n, buf1);mid.Wait();
                    }
                    if(south!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(j = 1; j<=ny; j++) {
                                ipos1 = (k0-1)*ny+j - 1;
                                ipos2 = ipos1 + ny*nz;
                                buf[0*size2+ipos1] = g[k0-1, j+1, nx, 0];
                                buf[1*size2+ipos1] = g[k0-1, j+1, nx, 1];
                                buf[2*size2+ipos1] = g[k0-1, j+1, nx, 2];
                                buf[3*size2+ipos1] = g[k0-1, j+1, nx, 3];
                                buf[4*size2+ipos1] = g[k0-1, j+1, nx, 4];

                                buf[0*size2+ipos2] = g[k0-1, j+1, nx+1, 0];
                                buf[1*size2+ipos2] = g[k0-1, j+1, nx+1, 1];
                                buf[2*size2+ipos2] = g[k0-1, j+1, nx+1, 2];
                                buf[3*size2+ipos2] = g[k0-1, j+1, nx+1, 3];
                                buf[4*size2+ipos2] = g[k0-1, j+1, nx+1, 4];
                            }
                        }
                        Shift_to_south.initiate_send();//worldcomm.Send<double>(buf, south, from_n);
                    }
                    if(north!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(j = 1; j<=ny; j++) {
                                ipos1 = (k0-1)*ny + j - 1;
                                ipos2 = ipos1 + ny*nz;
                                g[k0-1, j+1, 0, 0] = buf1[0*size2+ipos1];
                                g[k0-1, j+1, 0, 1] = buf1[1*size2+ipos1];
                                g[k0-1, j+1, 0, 2] = buf1[2*size2+ipos1];
                                g[k0-1, j+1, 0, 3] = buf1[3*size2+ipos1];
                                g[k0-1, j+1, 0, 4] = buf1[4*size2+ipos1];

                                g[k0-1, j+1, 1, 0] = buf1[0*size2+ipos2];
                                g[k0-1, j+1, 1, 1] = buf1[1*size2+ipos2];
                                g[k0-1, j+1, 1, 2] = buf1[2*size2+ipos2];
                                g[k0-1, j+1, 1, 3] = buf1[3*size2+ipos2];
                                g[k0-1, j+1, 1, 4] = buf1[4*size2+ipos2];
                            }
                        }
                    }
                    if(south!=-1) {
                        Shift_to_north.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(south, from_s, buf1);mid.Wait();
                    }
                    if(north!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(j = 1; j<=ny; j++) {
                                ipos1 = (k0-1)*ny + j - 1;
                                ipos2 = ipos1 + ny*nz;
                                buf[0*size2+ipos1] = g[k0-1, j+1, 3, 0];
                                buf[1*size2+ipos1] = g[k0-1, j+1, 3, 1];
                                buf[2*size2+ipos1] = g[k0-1, j+1, 3, 2];
                                buf[3*size2+ipos1] = g[k0-1, j+1, 3, 3];
                                buf[4*size2+ipos1] = g[k0-1, j+1, 3, 4];

                                buf[0*size2+ipos2] = g[k0-1, j+1, 2, 0];
                                buf[1*size2+ipos2] = g[k0-1, j+1, 2, 1];
                                buf[2*size2+ipos2] = g[k0-1, j+1, 2, 2];
                                buf[3*size2+ipos2] = g[k0-1, j+1, 2, 3];
                                buf[4*size2+ipos2] = g[k0-1, j+1, 2, 4];
                            }
                        }
                        Shift_to_north.initiate_send();//worldcomm.Send<double>(buf, north, from_s);
                    }
                    if(south!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(j = 1; j<=ny; j++) {
                                ipos1 = (k0-1)*ny + j - 1;
                                ipos2 = ipos1 + ny*nz;
                                g[k0-1, j+1, nx+3, 0]  = buf1[0*size2+ipos1];
                                g[k0-1, j+1, nx+3, 1]  = buf1[1*size2+ipos1];
                                g[k0-1, j+1, nx+3, 2]  = buf1[2*size2+ipos1];
                                g[k0-1, j+1, nx+3, 3]  = buf1[3*size2+ipos1];
                                g[k0-1, j+1, nx+3, 4]  = buf1[4*size2+ipos1];

                                g[k0-1, j+1, nx+2, 0] = buf1[0*size2+ipos2];
                                g[k0-1, j+1, nx+2, 1] = buf1[1*size2+ipos2];
                                g[k0-1, j+1, nx+2, 2] = buf1[2*size2+ipos2];
                                g[k0-1, j+1, nx+2, 3] = buf1[3*size2+ipos2];
                                g[k0-1, j+1, nx+2, 4] = buf1[4*size2+ipos2];
                            }
                        }
                    }
                }
                else {
                    bsize = 10*nx*nz;
                    size2 = bsize/5;
                    buf1 = Input_buffer.Array  = new double[bsize];
                    buf  = Output_buffer.Array = new double[bsize];
                    if(west!=-1) {
                        Shift_to_east.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(west, from_w, buf1);mid.Wait();
                    }
                    if(east!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(i = 1; i<=nx; i++) {
                                ipos1 = (k0-1)*nx+i - 1;
                                ipos2 = ipos1+nx*nz;
                                buf[0*size2+ipos1] = g[k0-1, ny, i+1, 0];
                                buf[1*size2+ipos1] = g[k0-1, ny, i+1, 1];
                                buf[2*size2+ipos1] = g[k0-1, ny, i+1, 2];
                                buf[3*size2+ipos1] = g[k0-1, ny, i+1, 3];
                                buf[4*size2+ipos1] = g[k0-1, ny, i+1, 4];

                                buf[0*size2+ipos2] = g[k0-1, ny+1, i+1, 0];
                                buf[1*size2+ipos2] = g[k0-1, ny+1, i+1, 1];
                                buf[2*size2+ipos2] = g[k0-1, ny+1, i+1, 2];
                                buf[3*size2+ipos2] = g[k0-1, ny+1, i+1, 3];
                                buf[4*size2+ipos2] = g[k0-1, ny+1, i+1, 4];
                            }
                        }
                        Shift_to_east.initiate_send();//worldcomm.Send<double>(buf, east, from_w);
                    }
                    if(west!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(i = 1; i<=nx; i++) {
                                ipos1 = (k0-1)*nx + i - 1;
                                ipos2 = ipos1 + nx*nz;
                                g[k0-1, 0, i+1, 0] = buf1[0*size2+ipos1];
                                g[k0-1, 0, i+1, 1] = buf1[1*size2+ipos1];
                                g[k0-1, 0, i+1, 2] = buf1[2*size2+ipos1];
                                g[k0-1, 0, i+1, 3] = buf1[3*size2+ipos1];
                                g[k0-1, 0, i+1, 4] = buf1[4*size2+ipos1];

                                g[k0-1, 1, i+1, 0] = buf1[0*size2+ipos2];
                                g[k0-1, 1, i+1, 1] = buf1[1*size2+ipos2];
                                g[k0-1, 1, i+1, 2] = buf1[2*size2+ipos2];
                                g[k0-1, 1, i+1, 3] = buf1[3*size2+ipos2];
                                g[k0-1, 1, i+1, 4] = buf1[4*size2+ipos2];
                            }
                        }
                    }
                    if(east!=-1) {
                        Shift_to_west.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(east, from_e, buf1);mid.Wait();
                    }
                    if(west!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(i = 1; i<=nx; i++) {
                                ipos1 = (k0-1)*nx + i - 1;
                                ipos2 = ipos1 + nx*nz;
                                buf[0*size2+ipos1] = g[k0-1, 3, i+1, 0];
                                buf[1*size2+ipos1] = g[k0-1, 3, i+1, 1];
                                buf[2*size2+ipos1] = g[k0-1, 3, i+1, 2];
                                buf[3*size2+ipos1] = g[k0-1, 3, i+1, 3];
                                buf[4*size2+ipos1] = g[k0-1, 3, i+1, 4];

                                buf[0*size2+ipos2] = g[k0-1, 2, i+1, 0];
                                buf[1*size2+ipos2] = g[k0-1, 2, i+1, 1];
                                buf[2*size2+ipos2] = g[k0-1, 2, i+1, 2];
                                buf[3*size2+ipos2] = g[k0-1, 2, i+1, 3];
                                buf[4*size2+ipos2] = g[k0-1, 2, i+1, 4];
                            }
                        }
                        Shift_to_west.initiate_send();//worldcomm.Send<double>(buf, west, from_e);
                    }
                    if(east!=-1) {
                        for(k0 = 1; k0<=nz; k0++) {
                            for(i = 1; i<=nx; i++) {
                                ipos1 = (k0-1)*nx + i - 1;
                                ipos2 = ipos1 + nx*nz;
                                g[k0-1, ny+3, i+1, 0]  = buf1[0*size2+ipos1];
                                g[k0-1, ny+3, i+1, 1]  = buf1[1*size2+ipos1];
                                g[k0-1, ny+3, i+1, 2]  = buf1[2*size2+ipos1];
                                g[k0-1, ny+3, i+1, 3]  = buf1[3*size2+ipos1];
                                g[k0-1, ny+3, i+1, 4]  = buf1[4*size2+ipos1];

                                g[k0-1, ny+2, i+1, 0] = buf1[0*size2+ipos2];
                                g[k0-1, ny+2, i+1, 1] = buf1[1*size2+ipos2];
                                g[k0-1, ny+2, i+1, 2] = buf1[2*size2+ipos2];
                                g[k0-1, ny+2, i+1, 3] = buf1[3*size2+ipos2];
                                g[k0-1, ny+2, i+1, 4] = buf1[4*size2+ipos2];
                            }
                        }
                    }
                }            
            }
			return 0;
		}
		
		public void setParameters(double[,,,] g, int iex, int k){
		   this.g = g;
		   this.iex = iex;
		   this.k = k;
		}
		
		public void setParameters(double[,,,] g, int iex){
		   this.g = g;
		   this.iex = iex;
		   this.k = -1;
		}
	}
}
