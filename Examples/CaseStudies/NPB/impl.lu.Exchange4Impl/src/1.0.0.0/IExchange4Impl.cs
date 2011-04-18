using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange4;

namespace impl.lu.Exchange4Impl { 
	public class IExchange4Impl<I, C> : BaseIExchange4Impl<I, C>, IExchange4<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
	    private double[,] g;
	    private double[,] h;
	    private int ibeg;
	    private int ifin1;
	    private int jbeg; 
	    private int jfin1;
	    
		public IExchange4Impl() { 
		
		} 		
		public override int go() { 

            int i, j, ny2;
            int from_s = 1, from_e = 3;
            ny2 = ny + 2;
            if(jfin1==ny) {
                double[] dum;
                dum = Input_buffer.Array = new double[2*nx];
                Shift_to_west.initiate_recv();//msgid3 = worldcomm.ImmediateReceive<double>(east, from_e, dum);msgid3.Wait();
                for(i = 1; i<=nx; i++) {
                    g[ny+1, i] = dum[i-1];
                    h[ny+1, i] = dum[i+nx-1];
                }
            }
            if(jbeg==1) {
                double[] dum;
                dum = Output_buffer.Array = new double[2*nx];
                for(i = 1; i<=nx; i++) {
                    dum[i-1]    = g[1, i];
                    dum[i+nx-1] = h[1, i];
                }
                Shift_to_west.initiate_send();//worldcomm.Send<double>(dum, west, from_e);
            }
            if(ifin1==nx) {
                double[] dum;
                dum = Input_buffer.Array = new double[2*ny2];
                Shift_to_north.initiate_recv();//msgid1 = worldcomm.ImmediateReceive<double>(south, from_s, dum); msgid1.Wait();
                for(j = 0; j<=ny+1; j++) {
                    g[j, nx+1] = dum[j];
                    h[j, nx+1] = dum[j+ny2];
                }
            }
            if(ibeg==1) {
                double[] dum;
                dum = Output_buffer.Array = new double[2*ny2];
                for(j = 0; j<=ny+1; j++) {
                    dum[j]     = g[j, 1];
                    dum[j+ny2] = h[j, 1];
                }
                Shift_to_north.initiate_send();//worldcomm.Send<double>(dum, north, from_s);
            }
			return 0;
		}
		public void setParameters(double[,] g, double[,] h, int ibeg, int ifin1, int jbeg, int jfin1){
		   this.g     = g;
		   this.h     = h;
		   this.ibeg  = ibeg;
		   this.ifin1 = ifin1;
		   this.jbeg  = jbeg;
		   this.jfin1 = jfin1;
		   
		}
	}
}
