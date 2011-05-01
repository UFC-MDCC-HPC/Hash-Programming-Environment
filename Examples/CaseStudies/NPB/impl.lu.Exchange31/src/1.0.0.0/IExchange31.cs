using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exchange;
using lu.exchange.ExchangePattern31;
using common.Discretization;

namespace impl.lu.Exchange31 
{ 
	public class IExchange31<I, C, E, DIS> : BaseIExchange31<I, C, E, DIS>, IExchange<I, C, E, DIS>
		where I:IInstance_LU<C>
		where C:IClass 
		where E:IExchangePattern31
		where DIS:IDiscretization
	{	   
	    private double[,,,] g;
	    
		public override int go() 
		{ 
            int i, k0;
            int ipos1, ipos2;
            int bsize = 10*ny*nz;
            int size2 = bsize / 5;
            double[] buf1;
            buf1 = Input_buffer.Array = new double[bsize];
            double[] buf;
            buf = Output_buffer.Array  = new double[bsize];
            
            bsize = 10*nx*nz;
            size2 = bsize/5;
            buf1 = Input_buffer.Array  = new double[bsize];
            buf  = Output_buffer.Array = new double[bsize];
            if(west!=-1) 
			{
                Shift_to_east.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(west, from_w, buf1);mid.Wait();
				Shift_to_east.go();
            }
            if(east!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(i = 1; i<=nx; i++) 
					{
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
				Shift_to_east.go();
            }
            if(west!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(i = 1; i<=nx; i++) 
					{
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
			
            if(east!=-1) 
			{
                Shift_to_west.initiate_recv();//mid = worldcomm.ImmediateReceive<double>(east, from_e, buf1);mid.Wait();
				Shift_to_west.go();
            }
			
            if(west!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(i = 1; i<=nx; i++) 
					{
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
				Shift_to_west.go();
            }
			
            if(east!=-1) 
			{
                for(k0 = 1; k0<=nz; k0++) 
				{
                    for(i = 1; i<=nx; i++) 
					{
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
