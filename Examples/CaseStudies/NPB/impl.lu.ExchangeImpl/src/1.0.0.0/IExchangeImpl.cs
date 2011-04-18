using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange;

namespace impl.lu.ExchangeImpl { 
	public class IExchangeImpl<I, C> : BaseIExchangeImpl<I, C>, IExchange<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
	    private double[,] g;
	    private int beg;
	    private int fin1; 
	    private int _from;
	    
 	    public IExchangeImpl() { 
		
		}		
		public override int go() { 

            int k;
            int from_s = 1, from_e = 3;
            if(_from==from_s) {
                if(fin1==nx) {
                    double[] dum;
                    dum = Input_buffer.Array = new double[nz];
                    ShiftToNorth.initiate_recv();// msgid1 = worldcomm.ImmediateReceive<double>(south, from_s, dum); msgid1.Wait();
                    for(k = 1; k<=nz; k++) {
                        g[k, nx+1] = dum[k-1];
                    }
                }
                if(beg==1) {
                    double[] dum;
                    dum = Output_buffer.Array = new double[nz];
                    for(k = 1; k<=nz; k++) {
                        dum[k-1] = g[k, 1];
                    }
                    ShiftToNorth.initiate_send();//worldcomm.Send<double>(dum, north, from_s);
                }
            }
            else if(_from==from_e) {
                k = 0;
                if(fin1==ny) {
                    double[] dum;
                    dum = Input_buffer.Array = new double[nz];
                    ShiftToWest.initiate_recv();//msgid3 = worldcomm.ImmediateReceive<double>(east, from_e, dum);msgid3.Wait();
                    for(k = 1; k<=nz; k++) {
                        g[k, ny+1] = dum[k-1];
                    }
                }
                if(beg==1) {
                    double[] dum;
                    dum = Output_buffer.Array = new double[nz];
                    for(k = 1; k<=nz; k++) {
                        dum[k-1] = g[k, 1];
                    }
                    ShiftToWest.initiate_send();//worldcomm.Send<double>(dum, west, from_e);
                }
            }
			return 0;
		}
		public void setParameters(double[,] g, int beg, int fin1, int _from){
		   this.g = g;
		   this.beg = beg;
		   this.fin1 = fin1;
		   this._from = _from;
		}

	}
}
