using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Pintgr;
using MPI;

namespace impl.lu.PintgrImpl 
{
	public class IPintgrImpl<I, C> : BaseIPintgrImpl<I, C>, IPintgr<I, C>
	where I:IInstance_LU<C>
	where C:IClass 
	{	
		public override int go() 
		{ 
            int i, j, k, ibeg, ifin, ifin1, jbeg, jfin, jfin1, iglob, iglob1, iglob2, jglob, jglob1, jglob2, ind1, ind2;
            double[,] phi1 = new double[isiz3+2, isiz2+2];
            double[,] phi2 = new double[isiz3+2, isiz2+2];
            double frc1, frc2, frc3, dummy;
			
            ibeg = nx + 1;
            ifin = 0;
            iglob1 = ipt + 1;
            iglob2 = ipt + nx;
            if(iglob1>=ii1 && iglob2<ii2+nx)
                ibeg = 1;
            if(iglob1>ii1-nx && iglob2<=ii2)
                ifin = nx;
            if(ii1>=iglob1 && ii1<=iglob2)
                ibeg = ii1 - ipt;
            if(ii2>=iglob1 && ii2<=iglob2)
                ifin = ii2 - ipt;
            jbeg = ny + 1;
            jfin = 0;
            jglob1 = jpt + 1;
            jglob2 = jpt + ny;
            if(jglob1>=ji1 && jglob2<ji2+ny)
                jbeg = 1;
            if(jglob1>ji1-ny && jglob2<=ji2)
                jfin = ny;
            if(ji1>=jglob1 && ji1<=jglob2)
                jbeg = ji1 - jpt;
            if(ji2>=jglob1 && ji2<=jglob2)
                jfin = ji2 - jpt;
            ifin1 = ifin;
            jfin1 = jfin;
            if(ipt+ifin1 == ii2)
                ifin1 = ifin - 1;
            if(jpt+jfin1 == ji2)
                jfin1 = jfin - 1;
                
            for(i = 0; i<=isiz2+1; i++) 
            {
                for(k = 0; k<=isiz3+1; k++) 
                {
                    phi1[k, i] = 0.0;
                    phi2[k, i] = 0.0;
                }
            }
            
            for(j = jbeg; j<=jfin; j++) 
            {
                jglob = jpt + j;
                for(i = ibeg; i<=ifin; i++) 
                {
                    iglob = ipt + i;
                    k = ki1;
                    phi1[j, i] = c2*(u[k-1, j+1, i+1, 4]
                      -0.50d*(pow2(u[k-1, j+1, i+1, 1])
                            + pow2(u[k-1, j+1, i+1, 2])
                            + pow2(u[k-1, j+1, i+1, 3]))
                                 / u[k-1, j+1, i+1, 0]);
                    k = ki2;
                    phi2[j, i] = c2*(u[k-1, j+1, i+1, 4]
                      -0.50d*(pow2(u[k-1, j+1, i+1, 1])
                            + pow2(u[k-1, j+1, i+1, 2])
                            + pow2(u[k-1, j+1, i+1, 3]))
                                 / u[k-1, j+1, i+1, 0]);
                }
            }
            
            Exchange4.setParameters(phi1, phi2, ibeg, ifin1, jbeg, jfin1); 
            Exchange4.go();
            frc1 = 0.0d;
            for(j = jbeg; j<=jfin1; j++) 
            {
                for(i = ibeg; i<= ifin1; i++) 
                {
                    frc1 = frc1 + (phi1[j, i]
                                + phi1[j, i+1]
                                + phi1[j+1, i]
                                + phi1[j+1, i+1]
                                + phi2[j, i]    
                                + phi2[j, i+1]  
                                + phi2[j+1, i]  
                                + phi2[j+1, i+1]);
                }
            }
            
            dummy = frc1;
            frc1 = worldcomm.Allreduce<double>(dummy, MPI.Operation<double>.Add);
            frc1 = dxi * deta * frc1;
            
            for(i = 0; i<=isiz2+1; i++) 
            {
                for(k = 0; k<=isiz3+1; k++) 
                {
                    phi1[k, i] = 0.0;
                    phi2[k, i] = 0.0;
                }
            }
            
            jglob = jpt + jbeg;
            ind1 = 0;
            if(jglob==ji1) 
            {
                ind1 = 1;
                for(k = ki1; k<= ki2; k++) 
                {
                    for(i = ibeg; i<= ifin; i++) 
                    {
                        iglob = ipt + i;
                        phi1[k, i] = c2 * (u[k-1, jbeg+1, i+1, 4]
                        - 0.50d*(pow2(u[k-1, jbeg+1, i+1, 1])
                               + pow2(u[k-1, jbeg+1, i+1, 2])
                               + pow2(u[k-1, jbeg+1, i+1, 3]))
                                    / u[k-1, jbeg+1, i+1, 0]);
                    }
                }
            }
            
            jglob = jpt + jfin;
            ind2 = 0;
            if(jglob==ji2) 
            {
                ind2 = 1;
                for(k = ki1; k<= ki2; k++) 
                {
                    for(i = ibeg; i<= ifin; i++) 
                    {
                        iglob = ipt + i;
                        phi2[k, i] = c2*(u[k-1, jfin+1, i+1, 4]
                        -0.50d*(pow2(u[k-1, jfin+1, i+1, 1])
                              + pow2(u[k-1, jfin+1, i+1, 2])
                              + pow2(u[k-1, jfin+1, i+1, 3]))
                                   / u[k-1, jfin+1, i+1, 0]);
                    }
                }
            }
            
            if(ind1 == 1) 
            {
                Exchange5.setParameters(phi1, ibeg, ifin1);
                Exchange5.go();
            }
            
            if(ind2 == 1) 
            {
                Exchange5.setParameters(phi2, ibeg, ifin1);
                Exchange5.go();
            }
            
            frc2 = 0.0d;
            for(k = ki1; k<= ki2-1; k++) 
            {
                for(i = ibeg; i<= ifin1; i++) 
                {
                    frc2 = frc2 + (phi1[k, i]
                                + phi1[k, i+1]
                                + phi1[k+1, i]
                                + phi1[k+1, i+1]
                                + phi2[k, i]    
                                + phi2[k, i+1]  
                                + phi2[k+1, i]  
                                + phi2[k+1, i+1]);
                }
            }
            
            dummy = frc2;
            frc2 = worldcomm.Allreduce<double>(dummy, MPI.Operation<double>.Add);
            frc2 = dxi * dzeta * frc2;
            for(i = 0; i<=isiz2+1; i++) 
            {
                for(k = 0; k<=isiz3+1; k++) 
                {
                    phi1[k, i] = 0.0;
                    phi2[k, i] = 0.0;
                }
            }
            
            iglob = ipt + ibeg;
            ind1 = 0;
            if(iglob==ii1) 
            {
                ind1 = 1;
                for(k = ki1; k<= ki2; k++) {
                    for(j = jbeg; j<= jfin; j++) {
                        jglob = jpt + j;
                        phi1[k, j] = c2*(u[k-1, j+1, ibeg+1, 4]
                        -0.50d*(pow2(u[k-1, j+1, ibeg+1, 1])
                              + pow2(u[k-1, j+1, ibeg+1, 2])
                              + pow2(u[k-1, j+1, ibeg+1, 3]))
                                   / u[k-1, j+1, ibeg+1, 0]);
                    }
                }
            }
            
            iglob = ipt + ifin;
            ind2 = 0;
            if(iglob==ii2) 
            {
                ind2 = 1;
                for(k = ki1; k<= ki2; k++) 
                {
                    for(j = jbeg; j<= jfin; j++) 
                    {
                        jglob = jpt + j;
                        phi2[k, j] = c2*(u[k-1, j+1, ifin+1, 4]
                        -0.50d*(pow2(u[k-1, j+1, ifin+1, 1])
                              + pow2(u[k-1, j+1, ifin+1, 2])
                              + pow2(u[k-1, j+1, ifin+1, 3]))
                                   / u[k-1, j+1, ifin+1, 0]);
                    }
                }
            }
            
            if(ind1==1) 
            {
                Exchange6.setParameters(phi1, jbeg, jfin1);
                Exchange6.go();
            }
            
            if(ind2==1) 
            {
                Exchange6.setParameters(phi2, jbeg, jfin1);
                Exchange6.go();
            }
            frc3 = 0.0d;
            for(k = ki1; k<= ki2-1; k++)
            {
                for(j = jbeg; j<= jfin1; j++) 
                {
                    frc3 = frc3 + (phi1[k, j]
                                + phi1[k, j+1]
                                + phi1[k+1, j]
                                + phi1[k+1, j+1]
                                + phi2[k, j]    
                                + phi2[k, j+1]  
                                + phi2[k+1, j]  
                                + phi2[k+1, j+1]);
                }
            }
            
            dummy = frc3;
            frc3 = worldcomm.Allreduce<double>(dummy, MPI.Operation<double>.Add);
            frc3 = deta * dzeta * frc3;
			
            frc = 0.25d * (frc1 + frc2 + frc3);
            
			return 0;
		}
		
		public static double pow2(double p) { return p * p; } 
		
		protected double frc;
		public double Frc {get { return frc; } }
	}
}
