using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange;
using lu.exchange.ExchangePattern30;
using common.Discretization;


namespace impl.lu.Exchange30 
{ 
	public class IExchange30<I, C, E, DIS> : BaseIExchange30<I, C, E, DIS>, IExchange<I, C, E, DIS>
		where I:IInstance_LU<C>
		where C:IClass 
		where E:IExchangePattern30
		where DIS:IDiscretization
	{	   
	    private double[,,,] g;
	    
		public override int go() 
		{ 		   
            int j, k0;
            int ipos1, ipos2;
            int bsize = 10*ny*nz;
            int size2 = bsize / 5;
            double[] buf1;
            buf1 = Input_buffer.Array = new double[bsize];
            double[] buf;
            buf = Output_buffer.Array  = new double[bsize];
	   
            if(north!=-1) 
			{
                Shift_to_south.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(north, from_n, buf1);mid.Wait();
				Shift_to_south.go();
            }
            if(south!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(j = 1; j<=ny; j++) 
					{
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
				Shift_to_south.go();
            }
			
            if(north!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(j = 1; j<=ny; j++) 
					{
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
			
            if(south!=-1) 
			{
                Shift_to_north.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(south, from_s, buf1);mid.Wait();
				Shift_to_north.go();
            }
			
            if(north!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(j = 1; j<=ny; j++) 
					{
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
				Shift_to_north.go();
            }
			
            if(south!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(j = 1; j<=ny; j++) 
					{
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
			return 0;
		}
		
		public void setParameters(double[,,,] g)
		{
		   this.g = g;
		}
				
		public void setParameters(double[,,,] g, int k) {}				
	    public void setParameters(double[,] g, int beg, int fin1) {}
	    public void setParameters(double[,] g, double[,] h, int ibeg, int ifin1, int jbeg, int jfin1) {}
	}
}
