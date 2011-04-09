using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.ssor.Rhs;

namespace impl.lu.ssor.RhsImpl { 
	public class IRhsImpl<I, C> : BaseIRhsImpl<I, C>, IRhs<I, C>
	where I:IInstance_LU<C>
	where C:IClass {	
		public IRhsImpl() { 
		
		}		
		public override void compute() {
            int i, j, k, m;
            int iex;
            int L1, L2;
            int ist1, iend1;
            int jst1, jend1;
            double q;
            double u21, u31, u41;
            double tmp;
            double u21i, u31i, u41i, u51i;
            double u21j, u31j, u41j, u51j;
            double u21k, u31k, u41k, u51k;
            double u21im1, u31im1, u41im1, u51im1;
            double u21jm1, u31jm1, u41jm1, u51jm1;
            double u21km1, u31km1, u41km1, u51km1;

            for(k = 0; k< nz; k++) {
                for(j = 1; j<= ny; j++) {
                    for(i = 1; i<= nx; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k, j+1, i+1, m] = -frct[k, j+1, i+1, m];
                        }
                    }
                }
            }
            iex   = 0;
            Exchange1.setParameters(u, iex);
            Exchange1.compute();
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

            for(k = 2; k<= nz - 1; k++) {
                for(j = jst; j<= jend; j++) {
                    for(i = L1; i<= L2; i++) {
                        flux[k-1, j, i, 0] = u[k-1, j+1, i+1, 1];
                        u21=u[k-1, j+1, i+1, 1]/u[k-1, j+1, i+1, 0];

                        q = 0.50d*(u[k-1, j+1, i+1, 1]*u[k-1, j+1, i+1, 1]+u[k-1, j+1, i+1, 2]*u[k-1, j+1, i+1, 2]+u[k-1, j+1, i+1, 3]*u[k-1, j+1, i+1, 3])/u[k-1, j+1, i+1, 0];

                        flux[k-1, j, i, 1] =     u[k-1, j+1, i+1, 1] * u21 + c2 *(u[k-1, j+1, i+1, 4] - q);
                        flux[k-1, j, i, 2] =     u[k-1, j+1, i+1, 2] * u21;
                        flux[k-1, j, i, 3] =     u[k-1, j+1, i+1, 3] * u21;
                        flux[k-1, j, i, 4] = (c1*u[k-1, j+1, i+1, 4]-c2*q)*u21;
                    }
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, i+1, m]=rsd[k-1, j+1, i+1, m]-tx2*(flux[k-1, j, i+1, m] - flux[k-1, j, i-1, m]);
                        }
                    }
                    for(i = ist; i<= L2; i++) {
                        tmp = 1.0d/u[k-1, j+1, i+1, 0];
                        u21i = tmp*u[k-1, j+1, i+1, 1];
                        u31i = tmp*u[k-1, j+1, i+1, 2];
                        u41i = tmp*u[k-1, j+1, i+1, 3];
                        u51i = tmp*u[k-1, j+1, i+1, 4];

                        tmp = 1.0d/ u[k-1, j+1, i, 0];

                        u21im1 = tmp * u[k-1, j+1, i, 1];
                        u31im1 = tmp * u[k-1, j+1, i, 2];
                        u41im1 = tmp * u[k-1, j+1, i, 3];
                        u51im1 = tmp * u[k-1, j+1, i, 4];

                        flux[k-1, j, i, 1] = (4.0d/3.0d)*tx3*(u21i-u21im1);
                        flux[k-1, j, i, 2] = tx3 * (u31i - u31im1);
                        flux[k-1, j, i, 3] = tx3 * (u41i - u41im1);
                        flux[k-1, j, i, 4] = 0.50d*(1.0d-c1*c5)*tx3*((pow2(u21i)+pow2(u31i)+pow2(u41i))-(pow2(u21im1)+pow2(u31im1)+pow2(u41im1)))+(1.0d/6.0d)*tx3*(pow2(u21i)-pow2(u21im1))+c1*c5*tx3*(u51i-u51im1);
                    }
                    for(i = ist; i<= iend; i++) {
                        rsd[k-1, j+1, i+1, 0]=rsd[k-1, j+1, i+1, 0]+dx1*tx1*(u[k-1, j+1, i, 0]-2.0d*u[k-1, j+1, i+1, 0]+u[k-1, j+1, i+2, 0]);
                        rsd[k-1, j+1, i+1, 1]=rsd[k-1, j+1, i+1, 1]+tx3*c3*c4*(flux[k-1, j, i+1, 1]-flux[k-1, j, i, 1])+dx2*tx1*(u[k-1, j+1, i, 1]-2.0d*u[k-1, j+1, i+1, 1]+u[k-1, j+1, i+2, 1]);
                        rsd[k-1, j+1, i+1, 2]=rsd[k-1, j+1, i+1, 2]+tx3*c3*c4*(flux[k-1, j, i+1, 2]-flux[k-1, j, i, 2])+dx3*tx1*(u[k-1, j+1, i, 2]-2.0d*u[k-1, j+1, i+1, 2]+u[k-1, j+1, i+2, 2]);
                        rsd[k-1, j+1, i+1, 3]=rsd[k-1, j+1, i+1, 3]+tx3*c3*c4*(flux[k-1, j, i+1, 3]-flux[k-1, j, i, 3])+dx4*tx1*(u[k-1, j+1, i, 3]-2.0d*u[k-1, j+1, i+1, 3]+u[k-1, j+1, i+2, 3]);
                        rsd[k-1, j+1, i+1, 4]=rsd[k-1, j+1, i+1, 4]+tx3*c3*c4*(flux[k-1, j, i+1, 4]-flux[k-1, j, i, 4])+dx5*tx1*(u[k-1, j+1, i, 4]-2.0d*u[k-1, j+1, i+1, 4]+u[k-1, j+1, i+2, 4]);
                    }
                    if(north==-1) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, 3, m] = rsd[k-1, j+1, 3, m]-dssp*(+5.0d*u[k-1, j+1, 3, m]-4.0d*u[k-1, j+1, 4, m]+     u[k-1, j+1, 5, m]);
                            rsd[k-1, j+1, 4, m] = rsd[k-1, j+1, 4, m]-dssp*(-4.0d*u[k-1, j+1, 3, m]+6.0d*u[k-1, j+1, 4, m]-4.0d*u[k-1, j+1, 5, m]+u[k-1, j+1, 6, m]);
                        }
                    }
                    for(i = ist1; i<=iend1; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, i+1, m] = rsd[k-1, j+1, i+1, m]-dssp*(u[k-1, j+1, i-1, m]-4.0d*u[k-1, j+1, i, m]+6.0d*u[k-1, j+1, i+1, m]-4.0d*u[k-1, j+1, i+2, m]+u[k-1, j+1, i+3, m]);
                        }
                    }
                    if(south==-1) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, nx-1, m] = rsd[k-1, j+1, nx-1, m]-dssp*(u[k-1, j+1, nx-3, m]-4.0d*u[k-1, j+1, nx-2, m]+6.0d*u[k-1, j+1, nx-1, m]-4.0d*u[k-1, j+1, nx, m]);
                            rsd[k-1, j+1, nx, m]   = rsd[k-1, j+1, nx, m]  -dssp*(u[k-1, j+1, nx-2, m]-4.0d*u[k-1, j+1, nx-1, m]+5.0d*u[k-1, j+1, nx, m]);
                        }
                    }
                }
            }
            iex   = 1;
            Exchange1.setParameters(u, iex);
            Exchange1.compute();

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

            for(k = 2; k<= nz - 1; k++) {
                for(j = L1; j<= L2; j++) {
                    for(i = ist; i<= iend; i++) {
                        flux[k-1, j, i, 0]=u[k-1, j+1, i+1, 2];
                        u31=u[k-1, j+1, i+1, 2]/u[k-1, j+1, i+1, 0];

                        q = 0.50d*(u[k-1, j+1, i+1, 1]*u[k-1, j+1, i+1, 1]+u[k-1, j+1, i+1, 2]*u[k-1, j+1, i+1, 2]+u[k-1, j+1, i+1, 3]*u[k-1, j+1, i+1, 3])/u[k-1, j+1, i+1, 0];

                        flux[k-1, j, i, 1] =     u[k-1, j+1, i+1, 1] * u31;
                        flux[k-1, j, i, 2] =     u[k-1, j+1, i+1, 2] * u31 + c2 * (u[k-1, j+1, i+1, 4]-q);
                        flux[k-1, j, i, 3] =     u[k-1, j+1, i+1, 3] * u31;
                        flux[k-1, j, i, 4] = (c1*u[k-1, j+1, i+1, 4]-c2*q)*u31;
                    }
                }
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, i+1, m] =  rsd[k-1, j+1, i+1, m]- ty2 * (flux[k-1, j+1, i, m] - flux[k-1, j-1, i, m]);
                        }
                    }
                }
                for(j = jst; j<= L2; j++) {
                    for(i = ist; i<= iend; i++) {
                        tmp = 1.0d / u[k-1, j+1, i+1, 0];
                        u21j = tmp * u[k-1, j+1, i+1, 1];
                        u31j = tmp * u[k-1, j+1, i+1, 2];
                        u41j = tmp * u[k-1, j+1, i+1, 3];
                        u51j = tmp * u[k-1, j+1, i+1, 4];

                        tmp = 1.0d / u[k-1, j, i+1, 0];
                        u21jm1=tmp * u[k-1, j, i+1, 1];
                        u31jm1=tmp * u[k-1, j, i+1, 2];
                        u41jm1=tmp * u[k-1, j, i+1, 3];
                        u51jm1=tmp * u[k-1, j, i+1, 4];

                        flux[k-1, j, i, 1] = ty3 * (u21j - u21jm1);
                        flux[k-1, j, i, 2] = (4.0d/3.0d) * ty3 * (u31j-u31jm1);
                        flux[k-1, j, i, 3] = ty3 * (u41j - u41jm1);
                        flux[k-1, j, i, 4] = 0.50d*(1.0d-c1*c5)*ty3*((pow2(u21j)+pow2(u31j)+pow2(u41j))-(pow2(u21jm1)+pow2(u31jm1)+pow2(u41jm1)))+(1.0d/6.0d)*ty3*(pow2(u31j)-pow2(u31jm1))+c1*c5*ty3*(u51j-u51jm1);
                    }
                }
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        rsd[k-1, j+1, i+1, 0] = rsd[k-1, j+1, i+1, 0]+dy1*ty1*(u[k-1, j, i+1, 0]-2.0d*u[k-1, j+1, i+1, 0]+u[k-1, j+2, i+1, 0]);
                        rsd[k-1, j+1, i+1, 1] = rsd[k-1, j+1, i+1, 1]+ty3*c3*c4*(flux[k-1, j+1, i, 1]-flux[k-1, j, i, 1])+dy2*ty1*(u[k-1, j, i+1, 1]-2.0d*u[k-1, j+1, i+1, 1]+u[k-1, j+2, i+1, 1]);
                        rsd[k-1, j+1, i+1, 2] = rsd[k-1, j+1, i+1, 2]+ty3*c3*c4*(flux[k-1, j+1, i, 2]-flux[k-1, j, i, 2])+dy3*ty1*(u[k-1, j, i+1, 2]-2.0d*u[k-1, j+1, i+1, 2]+u[k-1, j+2, i+1, 2]);
                        rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3]+ty3*c3*c4*(flux[k-1, j+1, i, 3]-flux[k-1, j, i, 3])+dy4*ty1*(u[k-1, j, i+1, 3]-2.0d*u[k-1, j+1, i+1, 3]+u[k-1, j+2, i+1, 3]);
                        rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4]+ty3*c3*c4*(flux[k-1, j+1, i, 4]-flux[k-1, j, i, 4])+dy5*ty1*(u[k-1, j, i+1, 4]-2.0d*u[k-1, j+1, i+1, 4]+u[k-1, j+2, i+1, 4]);
                    }
                }
                if(west==-1) {
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, 3, i+1, m] = rsd[k-1, 3, i+1, m]-dssp*(+5.0d*u[k-1, 3, i+1, m]-4.0d*u[k-1, 4, i+1, m]+       u[k-1, 5, i+1, m]);
                            rsd[k-1, 4, i+1, m] = rsd[k-1, 4, i+1, m]-dssp*(-4.0d*u[k-1, 3, i+1, m]+6.0d*u[k-1, 4, i+1, m]-4.0d * u[k-1, 5, i+1, m]+u[k-1, 6, i+1, m]);
                        }
                    }
                }
                for(j = jst1; j<= jend1; j++) {
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, i+1, m]=rsd[k-1, j+1, i+1, m]-dssp*(u[k-1, j-1, i+1, m]-4.0d*u[k-1, j, i+1, m]+6.0d*u[k-1, j+1, i+1, m]-4.0d*u[k-1, j+2, i+1, m]+u[k-1, j+3, i+1, m]);
                        }
                    }
                }
                if(east==-1) {
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, ny-1, i+1, m]=rsd[k-1, ny-1, i+1, m]-dssp*(u[k-1, ny-3, i+1, m]-4.0d*u[k-1, ny-2, i+1, m]+6.0d*u[k-1, ny-1, i+1, m]-4.0d*u[k-1, ny, i+1, m]);
                            rsd[k-1, ny, i+1, m]=rsd[k-1, ny, i+1, m]-dssp*(u[k-1, ny-2, i+1, m]-4.0d*u[k-1, ny-1, i+1, m]+5.0d*u[k-1, ny, i+1, m]);
                        }
                    }
                }
            }
            for(k = 1; k<= nz; k++) {
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        flux[k-1, j, i, 0]=u[k-1, j+1, i+1, 3];
                        u41=u[k-1, j+1, i+1, 3]/u[k-1, j+1, i+1, 0];

                        q = 0.50d * (u[k-1, j+1, i+1, 1] * u[k-1, j+1, i+1, 1]+ u[k-1, j+1, i+1, 2] * u[k-1, j+1, i+1, 2]+ u[k-1, j+1, i+1, 3] * u[k-1, j+1, i+1, 3])/u[k-1, j+1, i+1, 0];

                        flux[k-1, j, i, 1] =   u[k-1, j+1, i+1, 1] * u41;
                        flux[k-1, j, i, 2] =   u[k-1, j+1, i+1, 2] * u41;
                        flux[k-1, j, i, 3] =   u[k-1, j+1, i+1, 3] * u41 + c2 * (u[k-1, j+1, i+1, 4]-q);
                        flux[k-1, j, i, 4]=(c1*u[k-1, j+1, i+1, 4]-c2*q)*u41;
                    }
                }
            }
            for(k = 2; k<= nz - 1; k++) {
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, i+1, m] =  rsd[k-1, j+1, i+1, m]- tz2 * (flux[k, j, i, m] - flux[k-2, j, i, m]);
                        }
                    }
                }
            }
            for(k = 2; k<= nz; k++) {
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        tmp = 1.0d / u[k-1, j+1, i+1, 0];
                        u21k = tmp * u[k-1, j+1, i+1, 1];
                        u31k = tmp * u[k-1, j+1, i+1, 2];
                        u41k = tmp * u[k-1, j+1, i+1, 3];
                        u51k = tmp * u[k-1, j+1, i+1, 4];

                        tmp   = 1.0d / u[k-2, j+1, i+1, 0];
                        u21km1 = tmp * u[k-2, j+1, i+1, 1];
                        u31km1 = tmp * u[k-2, j+1, i+1, 2];
                        u41km1 = tmp * u[k-2, j+1, i+1, 3];
                        u51km1 = tmp * u[k-2, j+1, i+1, 4];

                        flux[k-1, j, i, 1] = tz3 * (u21k - u21km1);
                        flux[k-1, j, i, 2] = tz3 * (u31k - u31km1);
                        flux[k-1, j, i, 3] = (4.0d/3.0d) * tz3 * (u41k-u41km1);
                        flux[k-1, j, i, 4] = 0.50d*(1.0d-c1*c5)*tz3*((pow2(u21k)+pow2(u31k)+pow2(u41k))-(pow2(u21km1)+pow2(u31km1)+pow2(u41km1)))+(1.0d/6.0d)*tz3*(pow2(u41k)-pow2(u41km1))+c1*c5*tz3*(u51k-u51km1);
                    }
                }
            }
            for(k = 2; k<= nz - 1; k++) {
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        rsd[k-1, j+1, i+1, 0] = rsd[k-1, j+1, i+1, 0]+dz1*tz1*(u[k-2, j+1, i+1, 0]-2.0d*u[k-1, j+1, i+1, 0]+u[k, j+1, i+1, 0]);
                        rsd[k-1, j+1, i+1, 1] = rsd[k-1, j+1, i+1, 1]+tz3*c3*c4*(flux[k, j, i, 1]-flux[k-1, j, i, 1])+dz2*tz1*(u[k-2, j+1, i+1, 1]-2.0d*u[k-1, j+1, i+1, 1]+u[k, j+1, i+1, 1]);
                        rsd[k-1, j+1, i+1, 2] = rsd[k-1, j+1, i+1, 2]+tz3*c3*c4*(flux[k, j, i, 2]-flux[k-1, j, i, 2])+dz3*tz1*(u[k-2, j+1, i+1, 2]-2.0d*u[k-1, j+1, i+1, 2]+u[k, j+1, i+1, 2]);
                        rsd[k-1, j+1, i+1, 3] = rsd[k-1, j+1, i+1, 3]+tz3*c3*c4*(flux[k, j, i, 3]-flux[k-1, j, i, 3])+dz4*tz1*(u[k-2, j+1, i+1, 3]-2.0d*u[k-1, j+1, i+1, 3]+u[k, j+1, i+1, 3]);
                        rsd[k-1, j+1, i+1, 4] = rsd[k-1, j+1, i+1, 4]+tz3*c3*c4*(flux[k, j, i, 4]-flux[k-1, j, i, 4])+dz5*tz1*(u[k-2, j+1, i+1, 4]-2.0d*u[k-1, j+1, i+1, 4]+u[k, j+1, i+1, 4]);
                    }
                }
            }
            for(j = jst; j<= jend; j++) {
                for(i = ist; i<= iend; i++) {
                    for(m = 0; m< 5; m++) {
                        rsd[-1+2, j+1, i+1, m]=rsd[-1+2, j+1, i+1, m]-dssp*(+5.0d*u[-1+2, j+1, i+1, m]-4.0d*u[-1+3, j+1, i+1, m]+     u[-1+4, j+1, i+1, m]);
                        rsd[-1+3, j+1, i+1, m]=rsd[-1+3, j+1, i+1, m]-dssp*(-4.0d*u[-1+2, j+1, i+1, m]+6.0d*u[-1+3, j+1, i+1, m]-4.0d*u[-1+4, j+1, i+1, m]+u[-1+5, j+1, i+1, m]);
                    }
                }
            }
            for(k = 4; k<= nz - 3; k++) {
                for(j = jst; j<= jend; j++) {
                    for(i = ist; i<= iend; i++) {
                        for(m = 0; m< 5; m++) {
                            rsd[k-1, j+1, i+1, m] = rsd[k-1, j+1, i+1, m]-dssp*(u[k-3, j+1, i+1, m]-4.0d*u[k-2, j+1, i+1, m]+6.0d*u[k-1, j+1, i+1, m]-4.0d*u[k, j+1, i+1, m]+u[k+1, j+1, i+1, m]);
                        }
                    }
                }
            }
            for(j = jst; j<= jend; j++) {
                for(i = ist; i<= iend; i++) {
                    for(m = 0; m< 5; m++) {
                        rsd[-1+nz-2, j+1, i+1, m]=rsd[-1+nz-2, j+1, i+1, m]-dssp*(u[-1+nz-4, j+1, i+1, m]-4.0d*u[-1+nz-3, j+1, i+1, m]+6.0d*u[-1+nz-2, j+1, i+1, m]-4.0d*u[-1+nz-1, j+1, i+1, m]);
                        rsd[-1+nz-1, j+1, i+1, m]=rsd[-1+nz-1, j+1, i+1, m]-dssp*(u[-1+nz-3, j+1, i+1, m]-4.0d*u[-1+nz-2, j+1, i+1, m]+5.0d*u[-1+nz-1, j+1, i+1, m]);
                    }
                }
            }
		}
		
		public static double pow2(double p) { return p * p; } 
	}
}
