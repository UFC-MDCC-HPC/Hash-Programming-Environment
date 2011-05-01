using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange;
using lu.exchange.ExchangePattern6;
using common.Discretization;

namespace impl.lu.Exchange6 
{ 
	public class IExchange6<I, C, E, DIS> : BaseIExchange6<I, C, E, DIS>, IExchange<I, C, E, DIS>
		where I:IInstance_LU<C>
		where C:IClass 
		where E:IExchangePattern6
		where DIS:IDiscretization
	{
	   
	    private double[,] g;
	    private int beg;
	    private int fin1; 
	    
 		public override int go() 
		{ 
            int k;
            if(fin1==ny) 
			{
                double[] dum;
                dum = Input_buffer.Array = new double[nz];
                Shift_to_west.initiate_recv();//msgid3 = worldcomm.ImmediateReceive<double>(east, from_e, dum);msgid3.Wait();
				Shift_to_west.go();
                for(k = 1; k<=nz; k++) 
				{
                    g[k, ny+1] = dum[k-1];
                }
            }
			
            if(beg==1) 
			{
                double[] dum;
                dum = Output_buffer.Array = new double[nz];
                for(k = 1; k<=nz; k++) 
				{
                    dum[k-1] = g[k, 1];
                }
                Shift_to_west.initiate_send();//worldcomm.Send<double>(dum, west, from_e);
				Shift_to_west.go();
            }
			return 0;
		}
		
		public void setParameters(double[,] g, int beg, int fin1)
		{
		   this.g = g;
		   this.beg = beg;
		   this.fin1 = fin1;
		}
		
		public void setParameters(double[,,,] g) {}
		public void setParameters(double[,,,] g, int k) {}
		public void setParameters(double[,] g, double[,] h, int ibeg, int ifin1, int jbeg, int jfin1) {}
	}
}
