using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.exchange.ExchangePattern4;
using lu.exchange.Exchange2D;
using MPI;


namespace impl.lu.Exchange4 { 
	public class IExchange4<I, C, E> : BaseIExchange4<I, C, E>, IExchange2D<I, C, E>
	where I:IInstance_LU<C>
	where C:IClass 
	where E:IExchangePattern4
	{
	    protected static int from_s = 1, from_n = 2, from_e = 3, from_w = 4;
		
	    private double[,] g;
	    private double[,] h;
	    private int ibeg;
	    private int ifin1;
	    private int jbeg; 
	    private int jfin1;
	    
		public override int go() 
		{ 
            int i, j, ny2;
            ny2 = ny + 2;
			
            if(jfin1==ny) 
			{
                double[] dum = new double[2*nx];
                MPI.Request msgid3 = worldcomm.ImmediateReceive<double>(east, from_e, dum);
				msgid3.Wait();
				
                for(i = 1; i<=nx; i++) 
				{
                    g[ny+1, i] = dum[i-1];
                    h[ny+1, i] = dum[i+nx-1];
                }
            }
			
            if(jbeg==1) 
			{
                double[] dum;
                dum = new double[2*nx];
                for(i = 1; i<=nx; i++) 
				{
                    dum[i-1]    = g[1, i];
                    dum[i+nx-1] = h[1, i];
                }
                worldcomm.Send<double>(dum, west, from_e);				
            }
			
            if(ifin1==nx) 
			{
                double[] dum;
                dum = new double[2*ny2];
                MPI.Request msgid1 = worldcomm.ImmediateReceive<double>(south, from_s, dum); 
				msgid1.Wait();
				
                for(j = 0; j<=ny+1; j++) 
				{
                    g[j, nx+1] = dum[j];
                    h[j, nx+1] = dum[j+ny2];
                }
            }
			
            if(ibeg==1) 
			{
                double[] dum;
                dum = new double[2*ny2];
                for(j = 0; j<=ny+1; j++) 
				{
                    dum[j]     = g[j, 1];
                    dum[j+ny2] = h[j, 1];
                }
                worldcomm.Send<double>(dum, north, from_s);
				
            }
            
			return 0;
		}
		
		public void setParameters(double[,,,] g, int k) {}
		public void setParameters(double[,,,] g) {}
	    public void setParameters(double[,] g, int beg, int fin1) {}
		
		public void setParameters(double[,] g, double[,] h, int ibeg, int ifin1, int jbeg, int jfin1)
		{
		   this.g     = g;
		   this.h     = h;
		   this.ibeg  = ibeg;
		   this.ifin1 = ifin1;
		   this.jbeg  = jbeg;
		   this.jfin1 = jfin1;		   
		}
	}
}
