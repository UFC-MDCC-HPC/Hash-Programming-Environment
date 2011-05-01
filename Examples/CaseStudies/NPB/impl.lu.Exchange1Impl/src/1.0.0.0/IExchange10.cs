using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange;
using lu.exchange.ExchangePattern10;
using lu.triangular.Lower;

namespace impl.lu.Exchange10 
{ 
	public class IExchange10<I, C, E, DIS> : BaseIExchange10<I, C, E, DIS>, IExchange<I, C, E, DIS>
		where I:IInstance_LU<C>
		where C:IClass 
		where E:IExchangePattern10
		where DIS:ILower
	{	   
	    private double[,,,] g;
	    private int k;
	    
		public override int go() 
		{ 
			int i, j;
			
            if(north != -1) 
			{
                double[] dum1;
                dum1 = Input_buffer.Array = new double[5*(jend-jst+1)];
                int idx = 0;
                Shift_to_south.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(north, from_n, dum1);mid.Wait();
				Shift_to_south.go();
                for(j=jst; j<=jend; j++) 
				{
                    g[k-1, j+1, 1, 0] = dum1[0+idx];
                    g[k-1, j+1, 1, 1] = dum1[1+idx];
                    g[k-1, j+1, 1, 2] = dum1[2+idx];
                    g[k-1, j+1, 1, 3] = dum1[3+idx];
                    g[k-1, j+1, 1, 4] = dum1[4+idx];
                    idx = idx + 5;
                }
            }
			
            if(west != -1) 
			{
                double[] dum1;
                dum1 = Input_buffer.Array = new double[(5*(iend-ist+1))];
                int idx = 0;
                Shift_to_east.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(west, from_w, dum1);mid.Wait();
				Shift_to_east.go();
                for(i=ist; i<=iend; i++) 
				{
                    g[k-1, 1, i+1, 0] = dum1[0+idx];
                    g[k-1, 1, i+1, 1] = dum1[1+idx];
                    g[k-1, 1, i+1, 2] = dum1[2+idx];
                    g[k-1, 1, i+1, 3] = dum1[3+idx];
                    g[k-1, 1, i+1, 4] = dum1[4+idx];
                    idx = idx + 5;
                }
            }
			return 0;
		}
		
		public void setParameters(double[,,,] g, int k)
		{
		   this.g = g;
		   this.k = k;
		}
		
		public void setParameters(double[,,,] g) {}
	    public void setParameters(double[,] g, int beg, int fin1) {}
	    public void setParameters(double[,] g, double[,] h, int ibeg, int ifin1, int jbeg, int jfin1) {}
		
	}
}
