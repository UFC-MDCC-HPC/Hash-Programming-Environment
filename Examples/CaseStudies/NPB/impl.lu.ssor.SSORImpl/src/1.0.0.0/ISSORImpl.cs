using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.ssor.SSOR;

namespace impl.lu.ssor.SSORImpl 
{ 
	public class ISSORImpl<I, C> : BaseISSORImpl<I, C>, ISSOR<I, C>
		where I:IInstance_LU<C>
		where C:IClass
	{
	    private int niter;
	
		public override int go() 
		{
            int i, j, k, m;
            int istep;
            double  tmp;
            double[] delunm = new double[5];
            double[] tolrsd = {1.0E-08, 1.0E-08, 1.0E-08, 1.0E-08, 1.0E-08};
            double omega=1.2d;
            rsdnm  = new double[5];
            double wtime;
            int node = this.GlobalRank;
            tmp = 1.0d/(omega*(2.0d-omega));
            
            //---------------------------------------------------------------------
            //   initialize a,b,c,d to zero [guarantees that page tables have been
            //   formed, if applicable on given architecture, before timestepping].
            //---------------------------------------------------------------------
            for(m=0; m<isiz2; m++) 
            {
                for(k=0; k<isiz1; k++) 
                {
                    for(j=0; j<5; j++) 
                    {
                        for(i=0; i<5; i++) 
                        {
                            a[m, k, j, i] = 0.0;
                            b[m, k, j, i] = 0.0;
                            c[m, k, j, i] = 0.0;
                            d[m, k, j, i] = 0.0;
                        }
                    }
                }
            }
			
            //---------------------------------------------------------------------
            //   compute the steady-state residuals
            //---------------------------------------------------------------------
            Rhs.go();
			
            //---------------------------------------------------------------------
            //   compute the L2 norms of newton iteration residuals
            //---------------------------------------------------------------------
            L2norm.setParameters(rsdnm);
            L2norm.go();
            
            worldcomm.Barrier();
            
            Timer.resetTimer(1);
            Timer.start(1);
            
            //---------------------------------------------------------------------
            //   the timestep loop
            //---------------------------------------------------------------------
            for(istep = 1; istep<= niter; istep++) 
            {
                if(node == 0) 
                {
                    if(mod(istep, 20) == 0 || istep == itmax || istep == 1) 
                    {
                        if(niter > 1)
                            Console.WriteLine(" Time step "+istep);
                    }
                }
                
                //---------------------------------------------------------------------
                //   perform SSOR iteration
                //---------------------------------------------------------------------
                for(k = 1; k < nz - 1; k++) 
                {
                    for(j = jst+1; j <= jend+1; j++) 
                    {
                        for(i = ist+1; i <= iend+1; i++) 
                        {
                            for(m = 0; m < 5; m++) 
                            {
                                rsd[k, j, i, m] = dt * rsd[k, j, i, m];
//								Console.WriteLine("rsd1[" + k + "," + j + "," + i + "," + m +"] = " + rsd[k, j, i, m]);
                            }
                        }
                    }
                }
                
                for(k = 2; k <= nz-1; k++) 
                {
                    //---------------------------------------------------------------------
                    //   form the lower triangular part of the jacobian matrix
                    //---------------------------------------------------------------------
                    Jacld.setParameters(k);
                    Jacld.go();
					
                    //---------------------------------------------------------------------
                    //   perform the lower triangular solution
                    //---------------------------------------------------------------------
                    Blts.setParameters(k, omega/*, a, b, c*/);
                    Blts.go();
                }
                 			    
                for(k = nz-1; k >= 2; k--) 
                {
                    //---------------------------------------------------------------------
                    //   form the strictly upper triangular part of the jacobian matrix
                    //---------------------------------------------------------------------
                    Jacu.setParameters(k);
                    Jacu.go();
					
                    //---------------------------------------------------------------------
                    //   perform the upper triangular solution
                    //---------------------------------------------------------------------
                    Buts.setParameters(k, omega/*, a, b, c*/);
                    Buts.go();
                }
                
                //---------------------------------------------------------------------
                //   update the variables
                //---------------------------------------------------------------------
                for(k = 1; k< nz-1; k++) 
                {
                    for(j = jst+1; j<= jend+1; j++) 
                    {
                        for(i = ist+1; i<= iend+1; i++) 
                        {
                            for(m = 0; m< 5; m++) 
                            {
//   				                Console.WriteLine("rsd5[" + k + "," + j + "," + i + "," + m +"] = " + rsd[k, j, i, m]);
								//Console.WriteLine("u1[" + k + "," + j + "," + i + "," + m + "] = " + u[k, j, i, m]);
                                u[k, j, i, m] = u[k, j, i, m] + tmp * rsd[k, j, i, m];
								//Console.WriteLine("u2[" + k + "," + j + "," + i + "," + m + "] = " + u[k, j, i, m]);
                            }
                        }
                    }
                }
                
                //---------------------------------------------------------------------
                //   compute the max-norms of newton iteration corrections
                //---------------------------------------------------------------------
                if(mod(istep, inorm) == 0) 
                {
                    L2norm.setParameters(delunm);
                    L2norm.go();
                }
                
                //---------------------------------------------------------------------
                //   compute the steady-state residuals
                //---------------------------------------------------------------------
                Rhs.go();
                
                //---------------------------------------------------------------------
                //   compute the max-norms of newton iteration residuals
                //---------------------------------------------------------------------
                if((mod(istep, inorm)== 0) || (istep==itmax)) 
                {
                    L2norm.setParameters(rsdnm);
                    L2norm.go();
                }
                
                //---------------------------------------------------------------------
                //   check the newton-iteration residuals against the tolerance levels
                //---------------------------------------------------------------------
                if((rsdnm[0]<tolrsd[0]) && 
                   (rsdnm[1]<tolrsd[1]) && 
                   (rsdnm[2]<tolrsd[2]) && 
                   (rsdnm[3]<tolrsd[3]) && 
                   (rsdnm[4]<tolrsd[4])) 
                {
                    return 0;
                }
            }
            
            Timer.stop(1);
            wtime = Timer.readTimer(1);
            
            maxtime = worldcomm.Allreduce<double>(wtime, MPI.Operation<double>.Max);
            
			return 0;
		}
		
		public static double mod(double a, double b) { return (a % b); }
		
		public void setParameters(int niter)
		{
		   this.niter = niter;
		}
		
		protected double[] rsdnm;
		protected double maxtime;
		public double[] Rsdnm { get{ return rsdnm; } }
		public double Maxtime { get{ return maxtime; } }
	}
}
