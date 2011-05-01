using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Exact;

namespace impl.lu.ExactImpl 
{ 
	public class IExactImpl<I, C> : BaseIExactImpl<I, C>, IExact<I, C>
	where I:IInstance_LU<C>
	where C:IClass 
	{	   
	    private int i,j,k,i1,i2,i3;
	    private double[,,,] u000ijk;
	    
		public override int go() 
		{
            int m;
            double xi, eta, zeta;
            xi   = ((double)(i-1))/(nx0-1);
            eta  = ((double)(j-1))/(ny0-1);
            zeta = ((double)(k-1))/(nz -1);
            //Console.WriteLine("i1=" + i1 + " i2=" + i2 + " i3=" + i3);
            for(m = 0; m< 5; m++)    
            {  
                u000ijk[i1, i2, i3, m] = ce[0, m] 
                    + ce[1, m]*xi 
                    + ce[2, m]*eta 
                    + ce[3, m]*zeta 
                    + ce[4, m]*xi*xi 
                    + ce[5, m]*eta*eta
                    + ce[6, m]*zeta*zeta 
                    + ce[7, m]*xi*xi*xi 
                    + ce[8, m]*eta*eta*eta 
                    + ce[9, m]*zeta*zeta*zeta 
                    + ce[10, m]*xi*xi*xi*xi
                    + ce[11, m]*eta*eta*eta*eta 
                    + ce[12, m]*zeta*zeta*zeta*zeta;
            }
            
			return 0;
		}
		
		public void setParameters(int i, int j, int k, double[,,,] u000ijk, int i1, int i2, int i3)
		{
		   this.i  = i;
		   this.j  = j;
		   this.k  = k;
		   this.i1 = i1;
		   this.i2 = i2;
		   this.i3 = i3;
		   this.u000ijk = u000ijk;
		}
	}
}