using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.ERhs;

namespace impl.lu.ERhsImpl 
{ 
	public class IERhsImpl<I, C> : BaseIERhsImpl<I, C>, IERhs<I, C>
		where I:IInstance_LU<C>
		where C:IClass 
	{

		public override int go() 
		{
            int i, j, k, m;
            int iglob, jglob;
            int L1, L2;
            int ist1, iend1;
            int jst1, jend1;
            double dsspm;
            double xi, eta, zeta;
            double q;
            double u21, u31, u41;
            double tmp;
            double u21i, u31i, u41i, u51i;
            double u21j, u31j, u41j, u51j;
            double u21k, u31k, u41k, u51k;
            double u21im1, u31im1, u41im1, u51im1;
            double u21jm1, u31jm1, u41jm1, u51jm1;
            double u21km1, u31km1, u41km1, u51km1;
            dsspm = dssp;
            
            for(k = 0; k < nz; k++) 
            {
                for(j = 2; j < ny+2; j++) 
                {
                    for(i = 2; i < nx+2; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j, i, m] = 0.0d;
                        }
                    }
                }
            }
            
            for(k = 0; k< nz; k++) 
            {
                zeta = ((double)(k))/(nz-1);
                for(j = 2; j< ny+2; j++) 
                {
                    jglob = jpt + j - 2;
                    eta = ((double)(jglob))/(ny0-1);
                    for(i = 2; i< nx+2; i++) 
                    {
                        iglob = ipt + i - 2;
                        xi = ((double)(iglob))/(nx0-1);
                        for(m = 0; m < 5; m++) 
                        {
                            rsd[k, j, i, m] =  ce[0, m]
                            + ce[1, m] * xi
                            + ce[2, m] * eta
                            + ce[3, m] * zeta
                            + ce[4, m] * xi * xi
                            + ce[5, m] * eta * eta
                            + ce[6, m] * zeta * zeta
                            + ce[7, m] * xi * xi * xi
                            + ce[8, m] * eta * eta * eta
                            + ce[9, m] * zeta * zeta * zeta
                            + ce[10, m] * xi * xi * xi * xi
                            + ce[11, m] * eta * eta * eta * eta
                            + ce[12, m] * zeta * zeta * zeta * zeta;
                        }
                    }
                }
            }
            
            
            //---------------------------------------------------------------------
            //   communicate and receive/send two rows of data
            //---------------------------------------------------------------------
            Exchange30.setParameters(rsd);
            Exchange30.go();
            
            L1 = 0;
            
            if(north==-1)
                L1 = 1;
                
            L2 = nx + 1;
            
            if(south==-1)
                L2 = nx;

            ist1 = 1;
            iend1 = nx;
            
            if(north==-1)
                ist1 = 4;
                
            if(south==-1)
                iend1 = nx - 3;
                
            for(k = 1; k<= nz - 2; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = L1; i<= L2; i++) 
                    {
                        flux[k, j, i, 0] = rsd[k, j+1, i+1, 1];
                        u21 = rsd[k, j+1, i+1, 1]/rsd[k, j+1, i+1, 0];
                        q = 0.50d*(rsd[k, j+1, i+1, 1]*rsd[k, j+1, i+1, 1]+rsd[k, j+1, i+1, 2]*rsd[k, j+1, i+1, 2]+rsd[k, j+1, i+1, 3]*rsd[k, j+1, i+1, 3])/rsd[k, j+1, i+1, 0];
                        flux[k, j, i, 1] = rsd[k, j+1, i+1, 1]*u21 + c2*(rsd[k, j+1, i+1, 4] - q);
                        flux[k, j, i, 2] = rsd[k, j+1, i+1, 2] * u21;
                        flux[k, j, i, 3] = rsd[k, j+1, i+1, 3] * u21;
                        flux[k, j, i, 4] = (c1*rsd[k, j+1, i+1, 4] - c2*q)*u21;
                    }
                }
            }
            
            for(k = 1; k<= nz - 2; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, i+1, m] =  frct[k, j+1, i+1, m] - tx2 * (flux[k, j, i+1, m] - flux[k, j, i-1, m]);
                        }
                    }
                    
                    for(i = ist; i<= L2; i++) 
                    {
                        tmp   = 1.0d/rsd[k, j+1, i+1, 0];
                        u21i = tmp * rsd[k, j+1, i+1, 1];
                        u31i = tmp * rsd[k, j+1, i+1, 2];
                        u41i = tmp * rsd[k, j+1, i+1, 3];
                        u51i = tmp * rsd[k, j+1, i+1, 4];
                        tmp   = 1.0d/rsd[k, j+1, i, 0];
                        u21im1 = tmp*rsd[k, j+1, i, 1];
                        u31im1 = tmp*rsd[k, j+1, i, 2];
                        u41im1 = tmp*rsd[k, j+1, i, 3];
                        u51im1 = tmp*rsd[k, j+1, i, 4];

                        flux[k, j, i, 1] = (4.0d/3.0d)*tx3*(u21i - u21im1);
                        flux[k, j, i, 2] = tx3 * (u31i - u31im1);
                        flux[k, j, i, 3] = tx3 * (u41i - u41im1);
                        flux[k, j, i, 4] = 0.50d*(1.0d-c1*c5)*tx3*
                         ((pow2(u21i)+pow2(u31i)+pow2(u41i))
                         -(pow2(u21im1)+pow2(u31im1)+pow2(u41im1)))
                         + (1.0d/6.0d)*tx3*(pow2(u21i) - pow2(u21im1))+c1*c5*tx3*(u51i-u51im1);
                    }
                    
                    for(i = ist; i<= iend; i++) 
                    {
                        frct[k, j+1, i+1, 0] = frct[k, j+1, i+1, 0]+dx1*tx1*(rsd[k, j+1, i, 0]-2.0d*rsd[k, j+1, i+1, 0]+rsd[k, j+1, i+2, 0]);
                        frct[k, j+1, i+1, 1] = frct[k, j+1, i+1, 1]+tx3*c3*c4*(flux[k, j, i+1, 1]-flux[k, j, i, 1])+dx2*tx1*(rsd[k, j+1, i, 1]-2.0d*rsd[k, j+1, i+1, 1]+rsd[k, j+1, i+2, 1]);
                        frct[k, j+1, i+1, 2] = frct[k, j+1, i+1, 2]+tx3*c3*c4*(flux[k, j, i+1, 2]-flux[k, j, i, 2])+dx3*tx1*(rsd[k, j+1, i, 2]-2.0d*rsd[k, j+1, i+1, 2]+rsd[k, j+1, i+2, 2]);
                        frct[k, j+1, i+1, 3] = frct[k, j+1, i+1, 3]+tx3*c3*c4*(flux[k, j, i+1, 3]-flux[k, j, i, 3])+dx4*tx1*(rsd[k, j+1, i, 3]-2.0d*rsd[k, j+1, i+1, 3]+rsd[k, j+1, i+2, 3]);
                        frct[k, j+1, i+1, 4] = frct[k, j+1, i+1, 4]+tx3*c3*c4*(flux[k, j, i+1, 4]-flux[k, j, i, 4])+dx5*tx1*(rsd[k, j+1, i, 4]-2.0d*rsd[k, j+1, i+1, 4]+rsd[k, j+1, i+2, 4]);
                    }
                    
                    //---------------------------------------------------------------------
                    //   Fourth-order dissipation
                    //---------------------------------------------------------------------
                    if(north==-1) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, 3, m] = frct[k, j+1, 3, m]-dsspm*(+5.0d*rsd[k, j+1, 3, m]-4.0d*rsd[k, j+1, 4, m]+rsd[k, j+1, 5, m]);
                            frct[k, j+1, 4, m] = frct[k, j+1, 4, m]-dsspm*(-4.0d*rsd[k, j+1, 3, m]+6.0d*rsd[k, j+1, 4, m]-4.0d*rsd[k, j+1, 5, m]+rsd[k, j+1, 6, m]);
                        }
                    }
                    
                    for(i = ist1; i<=iend1; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, i+1, m] = frct[k, j+1, i+1, m]-dsspm*(rsd[k, j+1, i-1, m]-
                            4.0d*rsd[k, j+1, i, m]+6.0d*rsd[k, j+1, i+1, m]-4.0d*rsd[k, j+1, i+2, m]+rsd[k, j+1, i+3, m]);
                        }
                    }
                    
                    if(south==-1) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, nx-1, m] = frct[k, j+1, nx-1, m]-dsspm*(rsd[k, j+1, nx-3, m]-4.0d*rsd[k, j+1, nx-2, m]+6.0d*rsd[k, j+1, nx-1, m]-4.0d*rsd[k, j+1, nx, m]);
                            frct[k, j+1, nx, m]   = frct[k, j+1, nx, m]  -dsspm*(rsd[k, j+1, nx-2, m]-4.0d*rsd[k, j+1, nx-1, m]+5.0d*rsd[k, j+1, nx, m]);
                        }
                    }
                }
            }
			
            //---------------------------------------------------------------------
            //   communicate and receive/send two rows of data
            //---------------------------------------------------------------------
            Exchange31.setParameters(rsd);
            Exchange31.go();
            L1 = 0;
            
            if(west==-1)
                L1 = 1;
                
            L2 = ny + 1;
            
            if(east==-1)
                L2 = ny;
                
            jst1 = 1;
            jend1 = ny;
            
            if(west==-1)
                jst1 = 4;
                
            if(east==-1)
                jend1 = ny - 3;
                
            for(k = 1; k<= nz - 2; k++) 
            {
                for(j = L1; j<= L2; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        flux[k, j, i, 0] = rsd[k, j+1, i+1, 2];
                        u31 = rsd[k, j+1, i+1, 2] / rsd[k, j+1, i+1, 0];
                        q          = 0.50d*(rsd[k, j+1, i+1, 1]*rsd[k, j+1, i+1, 1]+rsd[k, j+1, i+1, 2]*rsd[k, j+1, i+1, 2]
                                        +rsd[k, j+1, i+1, 3]*rsd[k, j+1, i+1, 3])/rsd[k, j+1, i+1, 0];
                        flux[k, j, i, 1] =     rsd[k, j+1, i+1, 1]*u31;
                        flux[k, j, i, 2] =     rsd[k, j+1, i+1, 2]*u31+c2*(rsd[k, j+1, i+1, 4]-q);
                        flux[k, j, i, 3] =     rsd[k, j+1, i+1, 3]*u31;
                        flux[k, j, i, 4] = (c1*rsd[k, j+1, i+1, 4]-c2*q)*u31;
                    }
                }
            }
            
            for(k = 1; k<= nz - 2; k++) 
            {
                for(i = ist; i<= iend; i++) 
                {
                    for(j = jst; j<= jend; j++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, i+1, m] =  frct[k, j+1, i+1, m] - ty2 * (flux[k, j+1, i, m] - flux[k, j-1, i, m]);
                        }
                    }
                }
                
                for(j = jst; j<= L2; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        tmp = 1.0d / rsd[k, j+1, i+1, 0];
                        u21j = tmp * rsd[k, j+1, i+1, 1];
                        u31j = tmp * rsd[k, j+1, i+1, 2];
                        u41j = tmp * rsd[k, j+1, i+1, 3];
                        u51j = tmp * rsd[k, j+1, i+1, 4];
                        tmp = 1.0d / rsd[k, j, i+1, 0];
                        u21jm1 = tmp*rsd[k, j, i+1, 1];
                        u31jm1 = tmp*rsd[k, j, i+1, 2];
                        u41jm1 = tmp*rsd[k, j, i+1, 3];
                        u51jm1 = tmp*rsd[k, j, i+1, 4];
                        flux[k, j, i, 1] = ty3*(u21j-u21jm1);
                        flux[k, j, i, 2] = (4.0d/3.0d)*ty3*(u31j-u31jm1);
                        flux[k, j, i, 3] = ty3*(u41j-u41jm1);
                        flux[k, j, i, 4] = 0.50d*(1.0d-c1*c5)*ty3*((pow2(u21j)+pow2(u31j)+pow2(u41j))-(pow2(u21jm1)+pow2(u31jm1)+pow2(u41jm1)))+(1.0d/6.0d)*ty3*(pow2(u31j)-pow2(u31jm1))+c1*c5*ty3*(u51j-u51jm1);
                    }
                }
                
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        frct[k, j+1, i+1, 0] = frct[k, j+1, i+1, 0]+dy1*ty1*(rsd[k, j, i+1, 0]-2.0d*rsd[k, j+1, i+1, 0]+rsd[k, j+2, i+1, 0]);
                        frct[k, j+1, i+1, 1] = frct[k, j+1, i+1, 1]+ty3*c3*c4*(flux[k, j+1, i, 1]-flux[k, j, i, 1])+dy2*ty1*(rsd[k, j, i+1, 1]-2.0d*rsd[k, j+1, i+1, 1]+rsd[k, j+2, i+1, 1]);
                        frct[k, j+1, i+1, 2] = frct[k, j+1, i+1, 2]+ty3*c3*c4*(flux[k, j+1, i, 2]-flux[k, j, i, 2])+dy3*ty1*(rsd[k, j, i+1, 2]-2.0d*rsd[k, j+1, i+1, 2]+rsd[k, j+2, i+1, 2]);
                        frct[k, j+1, i+1, 3] = frct[k, j+1, i+1, 3]+ty3*c3*c4*(flux[k, j+1, i, 3]-flux[k, j, i, 3])+dy4*ty1*(rsd[k, j, i+1, 3]-2.0d*rsd[k, j+1, i+1, 3]+rsd[k, j+2, i+1, 3]);
                        frct[k, j+1, i+1, 4] = frct[k, j+1, i+1, 4]+ty3*c3*c4*(flux[k, j+1, i, 4]-flux[k, j, i, 4])+dy5*ty1*(rsd[k, j, i+1, 4]-2.0d*rsd[k, j+1, i+1, 4]+rsd[k, j+2, i+1, 4]);
                    }
                }
                
                //---------------------------------------------------------------------
                //   fourth-order dissipation
                //---------------------------------------------------------------------
                if(west==-1) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, 3, i+1, m] = frct[k, 3, i+1, m]-dsspm*(+5.0d*rsd[k, 3, i+1, m]-4.0d*rsd[k, 4, i+1, m]+rsd[k, 5, i+1, m]);
                            frct[k, 4, i+1, m] = frct[k, 4, i+1, m]-dsspm*(-4.0d*rsd[k, 3, i+1, m]+6.0d*rsd[k, 4, i+1, m]-4.0d*rsd[k, 5, i+1, m]+rsd[k, 6, i+1, m]);
                        }
                    }
                }
                
                for(j = jst1; j<= jend1; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, i+1, m]=frct[k, j+1, i+1, m]-dsspm*(rsd[k, j-1, i+1, m]-4.0d*rsd[k, j, i+1, m]+6.0d*rsd[k, j+1, i+1, m]-4.0d*rsd[k, j+2, i+1, m]+rsd[k, j+3, i+1, m]);
                        }
                    }
                }
                
                if(east==-1) 
                {
                    for(i = ist; i<= iend; i++)
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, ny-1, i+1, m] = frct[k, ny-1, i+1, m]-dsspm*(rsd[k, ny-3, i+1, m]-4.0d*rsd[k, ny-2, i+1, m]+6.0d*rsd[k, ny-1, i+1, m]-4.0d*rsd[k, ny, i+1, m]);
                            frct[k, ny, i+1, m] = frct[k, ny, i+1, m]-dsspm*(rsd[k, ny-2, i+1, m]-4.0d*rsd[k, ny-1, i+1, m]+5.0d*rsd[k, ny, i+1, m]);
                        }
                    }
                }
            }
            
            //---------------------------------------------------------------------
            //   zeta-direction flux differences
            //---------------------------------------------------------------------
            for(k = 0; k< nz; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        flux[k, j, i, 0] = rsd[k, j+1, i+1, 3];
                        u41 = rsd[k, j+1, i+1, 3] / rsd[k, j+1, i+1, 0];
                        q = 0.50d*(rsd[k, j+1, i+1, 1]*rsd[k, j+1, i+1, 1]+rsd[k, j+1, i+1, 2]*rsd[k, j+1, i+1, 2]+rsd[k, j+1, i+1, 3]*rsd[k, j+1, i+1, 3])/rsd[k, j+1, i+1, 0];
                        flux[k, j, i, 1] =rsd[k, j+1, i+1, 1] * u41;
                        flux[k, j, i, 2] =rsd[k, j+1, i+1, 2] * u41;
                        flux[k, j, i, 3] =rsd[k, j+1, i+1, 3] * u41 + c2*(rsd[k, j+1, i+1, 4] - q);
                        flux[k, j, i, 4] =(c1*rsd[k, j+1, i+1, 4]-c2*q)*u41;
                    }
                }
            }
            
            for(k = 1; k<= nz - 2; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, i+1, m] =  frct[k, j+1, i+1, m] - tz2 * (flux[k+1, j, i, m] - flux[k-1, j, i, m]);
                        }
                    }
                }
            }
            for(k = 1; k< nz; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        tmp = 1.0d / rsd[k, j+1, i+1, 0];
                        u21k = tmp * rsd[k, j+1, i+1, 1];
                        u31k = tmp * rsd[k, j+1, i+1, 2];
                        u41k = tmp * rsd[k, j+1, i+1, 3];
                        u51k = tmp * rsd[k, j+1, i+1, 4];

                        tmp = 1.0d / rsd[k-1, j+1, i+1, 0];
                        u21km1 = tmp*rsd[k-1, j+1, i+1, 1];
                        u31km1 = tmp*rsd[k-1, j+1, i+1, 2];
                        u41km1 = tmp*rsd[k-1, j+1, i+1, 3];
                        u51km1 = tmp*rsd[k-1, j+1, i+1, 4];

                        flux[k, j, i, 1] = tz3 * (u21k - u21km1);
                        flux[k, j, i, 2] = tz3 * (u31k - u31km1);
                        flux[k, j, i, 3] = (4.0d/3.0d) * tz3 * (u41k - u41km1);
                        flux[k, j, i, 4] = 0.50d*(1.0d-c1*c5)*tz3*((pow2(u21k)+pow2(u31k)+pow2(u41k))-(pow2(u21km1)+pow2(u31km1)+pow2(u41km1)))+(1.0d/6.0d)*tz3*(pow2(u41k)-pow2(u41km1))+c1*c5*tz3*(u51k-u51km1);
                    }
                }
            }
            
            for(k = 1; k<= nz - 2; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        frct[k, j+1, i+1, 0] = frct[k, j+1, i+1, 0]+dz1*tz1*(rsd[k+1, j+1, i+1, 0]-2.0d*rsd[k, j+1, i+1, 0]+rsd[k-1, j+1, i+1, 0]);
                        frct[k, j+1, i+1, 1] = frct[k, j+1, i+1, 1]+tz3*c3*c4*(flux[k+1, j, i, 1]-flux[k, j, i, 1])+dz2*tz1*(rsd[k+1, j+1, i+1, 1]-2.0d*rsd[k, j+1, i+1, 1]+rsd[k-1, j+1, i+1, 1]);
                        frct[k, j+1, i+1, 2] = frct[k, j+1, i+1, 2]+tz3*c3*c4*(flux[k+1, j, i, 2]-flux[k, j, i, 2])+dz3*tz1*(rsd[k+1, j+1, i+1, 2]-2.0d*rsd[k, j+1, i+1, 2]+rsd[k-1, j+1, i+1, 2]);
                        frct[k, j+1, i+1, 3] = frct[k, j+1, i+1, 3]+tz3*c3*c4*(flux[k+1, j, i, 3]-flux[k, j, i, 3])+dz4*tz1*(rsd[k+1, j+1, i+1, 3]-2.0d*rsd[k, j+1, i+1, 3]+rsd[k-1, j+1, i+1, 3]);
                        frct[k, j+1, i+1, 4] = frct[k, j+1, i+1, 4]+tz3*c3*c4*(flux[k+1, j, i, 4]-flux[k, j, i, 4])+dz5*tz1*(rsd[k+1, j+1, i+1, 4]-2.0d*rsd[k, j+1, i+1, 4]+rsd[k-1, j+1, i+1, 4]);
                    }
                }
            }
            
            //---------------------------------------------------------------------
            //   fourth-order dissipation
            //---------------------------------------------------------------------
            for(j = jst; j<= jend; j++) 
            {
                for(i = ist; i<= iend; i++) 
                {
                    for(m = 0; m< 5; m++) 
                    {
                        frct[1, j+1, i+1, m] = frct[1, j+1, i+1, m]-dsspm*(+5.0d*rsd[1, j+1, i+1, m]-4.0d*rsd[2, j+1, i+1, m]+rsd[3, j+1, i+1, m]);
                        frct[2, j+1, i+1, m] = frct[2, j+1, i+1, m]-dsspm*(-4.0d*rsd[1, j+1, i+1, m]+6.0d*rsd[2, j+1, i+1, m]-4.0d*rsd[3, j+1, i+1, m]+rsd[4, j+1, i+1, m]);
                    }
                }
            }
            
            for(k = 3; k<= nz - 4; k++) 
            {
                for(j = jst; j<= jend; j++) 
                {
                    for(i = ist; i<= iend; i++) 
                    {
                        for(m = 0; m< 5; m++) 
                        {
                            frct[k, j+1, i+1, m] = frct[k, j+1, i+1, m]-dsspm*(rsd[k-2, j+1, i+1, m]-4.0d*rsd[k-1, j+1, i+1, m]+6.0d*rsd[k, j+1, i+1, m]-4.0d*rsd[k+1, j+1, i+1, m]+rsd[k+2, j+1, i+1, m]);
                        }
                    }
                }
            }
            
            for(j = jst; j<= jend; j++) 
            {
                for(i = ist; i<= iend; i++) 
                {
                    for(m = 0; m< 5; m++) 
                    {
                        frct[nz-3, j+1, i+1, m] = frct[nz-3, j+1, i+1, m]-dsspm*(rsd[nz-5, j+1, i+1, m]- 4.0d*rsd[nz-4, j+1, i+1, m]+6.0d*rsd[nz-3, j+1, i+1, m]-4.0d*rsd[nz-2, j+1, i+1, m]);
                        frct[nz-2, j+1, i+1, m] = frct[nz-2, j+1, i+1, m]-dsspm*(rsd[nz-4, j+1, i+1, m]- 4.0d*rsd[nz-3, j+1, i+1, m]+5.0d*rsd[nz-2, j+1, i+1, m]);
                    }
                }
            }
			return 0;
		}
		
		public static double pow2(double p) { return p * p; } 
	}
}
