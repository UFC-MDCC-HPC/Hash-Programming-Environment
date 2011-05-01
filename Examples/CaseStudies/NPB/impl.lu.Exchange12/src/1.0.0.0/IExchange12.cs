using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange;
using lu.exchange.ExchangePattern11;
using lu.triangular.Lower;


namespace impl.lu.Exchange12 
{ 
	public class IExchange12<I, C, E, DIS> : BaseIExchange12<I, C, E, DIS>, IExchange<I, C, E, DIS>
		where I:IInstance_LU<C>
		where C:IClass 
		where E:IExchangePattern11
		where DIS:ILower
	{	   
	    private double[,,,] g;
	    private int k;
	    
		public override int go() 
		{ 
	        int i,j;
            if(south != -1) 
			{
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
				Shift_to_south.go();
            }
            
            if(east != -1) 
			{
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
				Shift_to_east.go();
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
