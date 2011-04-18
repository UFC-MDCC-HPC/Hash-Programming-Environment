using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.triangular.Lower;
using lu.ssor.TriangularPartJacobianMatrix;

namespace impl.lu.ssor.TriangularPartJacobianMatrix_Jacld { 
	public class ITriangularPartJacobianMatrix_Jacld<I, C, DIS> : BaseITriangularPartJacobianMatrix_Jacld<I, C, DIS>, ITriangularPartJacobianMatrix<I, C, DIS>
	where I:IInstance_LU<C>
	where C:IClass
	where DIS:ILower{
	    private int k;
	
		public ITriangularPartJacobianMatrix_Jacld() { 
		
		} 
		
		public override int go() { 

            int i, j;
            double  r43;
            double  c1345;
            double  c34;
            double  tmp1, tmp2, tmp3;

            r43 = (4.0d/3.0d);
            c1345 = c1*c3*c4*c5;
            c34 = c3*c4;

            for(j = jst; j<= jend; j++) {
                for(i = ist; i<= iend; i++) {
                    //---------------------------------------------------------------------
                    //   form the block daigonal
                    //---------------------------------------------------------------------
                    tmp1 = 1.0d / u[k-1, j+1, i+1, 0];
                    tmp2 = tmp1 * tmp1;
                    tmp3 = tmp1 * tmp2;

                    d[j-1, i-1, 0, 0] =  1.0d+ dt * 2.0d * (tx1 * dx1+ ty1 * dy1+ tz1 * dz1);
                    d[j-1, i-1, 1, 0] =  0.0d;
                    d[j-1, i-1, 2, 0] =  0.0d;
                    d[j-1, i-1, 3, 0] =  0.0d;
                    d[j-1, i-1, 4, 0] =  0.0d;

                    d[j-1, i-1, 0, 1] =  dt*2.0d*(tx1*(-r43*c34*tmp2*u[k-1, j+1, i+1, 1])+ty1*(-c34*tmp2*u[k-1, j+1, i+1, 1])+tz1*(-c34*tmp2*u[k-1, j+1, i+1, 1]));
                    d[j-1, i-1, 1, 1] =  1.0d+dt*2.0d*(tx1*r43*c34*tmp1+ty1*c34*tmp1+tz1*c34*tmp1)+dt*2.0d*(tx1*dx2+ty1*dy2+tz1*dz2);
                    d[j-1, i-1, 2, 1] = 0.0d;
                    d[j-1, i-1, 3, 1] = 0.0d;
                    d[j-1, i-1, 4, 1] = 0.0d;

                    d[j-1, i-1, 0, 2] = dt*2.0d*(tx1*(-c34*tmp2*u[k-1, j+1, i+1, 2])+ty1*(-r43*c34*tmp2*u[k-1, j+1, i+1, 2])+tz1*(-c34*tmp2*u[k-1, j+1, i+1, 2]));
                    d[j-1, i-1, 1, 2] = 0.0d;
                    d[j-1, i-1, 2, 2] = 1.0d+dt*2.0d*(tx1*c34*tmp1+ty1*r43*c34*tmp1+tz1*c34*tmp1)+dt*2.0d*(tx1*dx3+ty1*dy3+tz1*dz3);
                    d[j-1, i-1, 3, 2] = 0.0d;
                    d[j-1, i-1, 4, 2] = 0.0d;

                    d[j-1, i-1, 0, 3] = dt*2.0d*(tx1*(-c34*tmp2*u[k-1, j+1, i+1, 3])+ty1*(-c34*tmp2*u[k-1, j+1, i+1, 3])+tz1*(-r43*c34*tmp2*u[k-1, j+1, i+1, 3]));
                    d[j-1, i-1, 1, 3] = 0.0d;
                    d[j-1, i-1, 2, 3] = 0.0d;
                    d[j-1, i-1, 3, 3] = 1.0d+dt*2.0d*(tx1*c34*tmp1+ty1*c34*tmp1+tz1*r43*c34*tmp1)+dt*2.0d*(tx1*dx4+ty1*dy4+tz1*dz4);
                    d[j-1, i-1, 4, 3] = 0.0d;

                    d[j-1, i-1, 0, 4] = dt*2.0d*(tx1*(-(r43*c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 1]))-(c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 2]))-(c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 3]))-(c1345)*tmp2*u[k-1, j+1, i+1, 4])+ty1*(-(c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 1]))-(r43*c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 2]))-(c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 3]))-(c1345)*tmp2*u[k-1, j+1, i+1, 4])+tz1*(-(c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 1]))-(c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 2]))-(r43*c34-c1345)*tmp3*(pow2(u[k-1, j+1, i+1, 3]))-(c1345)*tmp2*u[k-1, j+1, i+1, 4]));
                    d[j-1, i-1, 1, 4] = dt*2.0d*(tx1*(r43*c34-c1345)*tmp2*u[k-1, j+1, i+1, 1]+ty1*(c34-c1345)*tmp2*u[k-1, j+1, i+1, 1]+tz1*(c34-c1345)*tmp2*u[k-1, j+1, i+1, 1]);
                    d[j-1, i-1, 2, 4] = dt*2.0d*(tx1*(c34-c1345)*tmp2*u[k-1, j+1, i+1, 2]+ty1*(r43*c34-c1345)*tmp2*u[k-1, j+1, i+1, 2]+tz1*(c34-c1345)*tmp2*u[k-1, j+1, i+1, 2]);
                    d[j-1, i-1, 3, 4] = dt*2.0d*(tx1*(c34-c1345)*tmp2*u[k-1, j+1, i+1, 3]+ty1*(c34-c1345)*tmp2*u[k-1, j+1, i+1, 3]+tz1*(r43*c34-c1345)*tmp2*u[k-1, j+1, i+1, 3]);
                    d[j-1, i-1, 4, 4] = 1.0d+dt*2.0d*(tx1*c1345*tmp1+ty1*c1345*tmp1+tz1*c1345*tmp1)+dt*2.0d*(tx1*dx5+ty1*dy5+tz1*dz5);
                    //---------------------------------------------------------------------
                    //   form the first block sub-diagonal
                    //---------------------------------------------------------------------
                    tmp1 = 1.0d/u[k-2, j+1, i+1, 0];
                    tmp2 = tmp1 * tmp1;
                    tmp3 = tmp1 * tmp2;

                    a[j-1, i-1, 0, 0] = -dt * tz1 * dz1;
                    a[j-1, i-1, 1, 0] =   0.0d;
                    a[j-1, i-1, 2, 0] =   0.0d;
                    a[j-1, i-1, 3, 0] = -dt * tz2;
                    a[j-1, i-1, 4, 0] =   0.0d;

                    a[j-1, i-1, 0, 1] = -dt*tz2*(-(u[k-2, j+1, i+1, 1]*u[k-2, j+1, i+1, 3])*tmp2)-dt*tz1*(-c34*tmp2*u[k-2, j+1, i+1, 1]);
                    a[j-1, i-1, 1, 1] = -dt*tz2*(u[k-2, j+1, i+1, 3]*tmp1)-dt*tz1*c34*tmp1-dt*tz1*dz2;
                    a[j-1, i-1, 2, 1] = 0.0d;
                    a[j-1, i-1, 3, 1] = -dt*tz2*(u[k-2, j+1, i+1, 1]*tmp1);
                    a[j-1, i-1, 4, 1] = 0.0d;

                    a[j-1, i-1, 0, 2] = -dt * tz2* (-(u[k-2, j+1, i+1, 2]*u[k-2, j+1, i+1, 3]) * tmp2)- dt * tz1 * (-c34 * tmp2 * u[k-2, j+1, i+1, 2]);
                    a[j-1, i-1, 1, 2] = 0.0d;
                    a[j-1, i-1, 2, 2] = -dt * tz2 * (u[k-2, j+1, i+1, 3] * tmp1)- dt * tz1 * (c34 * tmp1)- dt * tz1 * dz3;
                    a[j-1, i-1, 3, 2] = -dt * tz2 * (u[k-2, j+1, i+1, 2] * tmp1);
                    a[j-1, i-1, 4, 2] = 0.0d;

                    a[j-1, i-1, 0, 3] = -dt*tz2*(-pow2((u[k-2, j+1, i+1, 3]*tmp1))+0.50d*c2*((u[k-2, j+1, i+1, 1]*u[k-2, j+1, i+1, 1]+u[k-2, j+1, i+1, 2]*u[k-2, j+1, i+1, 2]+u[k-2, j+1, i+1, 3]*u[k-2, j+1, i+1, 3])*tmp2))-dt*tz1*(-r43*c34*tmp2*u[k-2, j+1, i+1, 3]);
                    a[j-1, i-1, 1, 3] = -dt * tz2* (-c2 * (u[k-2, j+1, i+1, 1] * tmp1));
                    a[j-1, i-1, 2, 3] = -dt * tz2* (-c2 * (u[k-2, j+1, i+1, 2] * tmp1));
                    a[j-1, i-1, 3, 3] = -dt * tz2 *(2.0d-c2)*(u[k-2, j+1, i+1, 3] * tmp1)- dt * tz1 * (r43 * c34 * tmp1)- dt * tz1 * dz4;
                    a[j-1, i-1, 4, 3] = -dt * tz2 * c2;

                    a[j-1, i-1, 0, 4] = -dt*tz2*((c2*(u[k-2, j+1, i+1, 1]*u[k-2, j+1, i+1, 1]+ u[k-2, j+1, i+1, 2] * u[k-2, j+1, i+1, 2]+ u[k-2, j+1, i+1, 3] * u[k-2, j+1, i+1, 3]) * tmp2- c1 * (u[k-2, j+1, i+1, 4] * tmp1))* (u[k-2, j+1, i+1, 3] * tmp1))- dt * tz1* (-(c34 - c1345) * tmp3 * (pow2(u[k-2, j+1, i+1, 1]))- (c34 - c1345) * tmp3 * (pow2(u[k-2, j+1, i+1, 2]))- (r43*c34 - c1345)* tmp3 *(pow2(u[k-2, j+1, i+1, 3]))- c1345 * tmp2 * u[k-2, j+1, i+1, 4]);
                    a[j-1, i-1, 1, 4] = -dt*tz2*(-c2*(u[k-2, j+1, i+1, 1]*u[k-2, j+1, i+1, 3])*tmp2)-dt*tz1*(c34-c1345)*tmp2*u[k-2, j+1, i+1, 1];
                    a[j-1, i-1, 2, 4] = -dt*tz2*(-c2*(u[k-2, j+1, i+1, 2]*u[k-2, j+1, i+1, 3])*tmp2)-dt*tz1*(c34-c1345)*tmp2*u[k-2, j+1, i+1, 2];
                    a[j-1, i-1, 3, 4] = -dt*tz2*(c1*(u[k-2, j+1, i+1, 4]*tmp1)-0.50d*c2*((u[k-2, j+1, i+1, 1]*u[k-2, j+1, i+1, 1]+u[k-2, j+1, i+1, 2]*u[k-2, j+1, i+1, 2]+3.0d*u[k-2, j+1, i+1, 3]*u[k-2, j+1, i+1, 3])*tmp2))-dt*tz1*(r43*c34-c1345)*tmp2*u[k-2, j+1, i+1, 3];
                    a[j-1, i-1, 4, 4] = -dt*tz2*(c1*(u[k-2, j+1, i+1, 3]*tmp1))-dt*tz1*c1345*tmp1-dt*tz1*dz5;
                    //---------------------------------------------------------------------
                    //   form the second block sub-diagonal
                    //---------------------------------------------------------------------
                    tmp1 = 1.0d / u[k-1, j, i+1, 0];
                    tmp2 = tmp1 * tmp1;
                    tmp3 = tmp1 * tmp2;

                    b[j-1, i-1, 0, 0] = -dt * ty1 * dy1;
                    b[j-1, i-1, 1, 0] =   0.0d;
                    b[j-1, i-1, 2, 0] = -dt * ty2;
                    b[j-1, i-1, 3, 0] =   0.0d;
                    b[j-1, i-1, 4, 0] =   0.0d;

                    b[j-1, i-1, 0, 1] = -dt*ty2*(-(u[k-1, j, i+1, 1]*u[k-1, j, i+1, 2])*tmp2)-dt*ty1*(-c34*tmp2*u[k-1, j, i+1, 1]);
                    b[j-1, i-1, 1, 1] = -dt*ty2*(u[k-1, j, i+1, 2]*tmp1)-dt*ty1*(c34*tmp1)-dt*ty1*dy2;
                    b[j-1, i-1, 2, 1] = -dt*ty2*(u[k-1, j, i+1, 1]*tmp1);
                    b[j-1, i-1, 3, 1] = 0.0d;
                    b[j-1, i-1, 4, 1] = 0.0d;

                    b[j-1, i-1, 0, 2] = -dt*ty2*(-pow2((u[k-1, j, i+1, 2]*tmp1))+0.50d*c2*((u[k-1, j, i+1, 1]* u[k-1, j, i+1, 1]+ u[k-1, j, i+1, 2]* u[k-1, j, i+1, 2]+ u[k-1, j, i+1, 3]* u[k-1, j, i+1, 3])* tmp2))- dt * ty1 *(-r43 * c34 * tmp2 * u[k-1, j, i+1, 2]);
                    b[j-1, i-1, 1, 2] = -dt*ty2*(-c2*(u[k-1, j, i+1, 1]*tmp1));
                    b[j-1, i-1, 2, 2] = -dt*ty2*((2.0d-c2)*(u[k-1, j, i+1, 2]*tmp1))-dt*ty1*(r43*c34*tmp1)-dt*ty1*dy3;
                    b[j-1, i-1, 3, 2] = -dt*ty2*(-c2*(u[k-1, j, i+1, 3]*tmp1));
                    b[j-1, i-1, 4, 2] = -dt*ty2*c2;

                    b[j-1, i-1, 0, 3] = -dt*ty2*(-(u[k-1, j, i+1, 2]*u[k-1, j, i+1, 3]) * tmp2)- dt * ty1 * (-c34 * tmp2 * u[k-1, j, i+1, 3]);
                    b[j-1, i-1, 1, 3] = 0.0d;
                    b[j-1, i-1, 2, 3] = -dt*ty2* (u[k-1, j, i+1, 3] * tmp1);
                    b[j-1, i-1, 3, 3] = -dt*ty2* (u[k-1, j, i+1, 2] * tmp1)- dt * ty1 * (c34 * tmp1)- dt * ty1 * dy4;
                    b[j-1, i-1, 4, 3] = 0.0d;

                    b[j-1, i-1, 0, 4] = -dt * ty2* ((c2 * (u[k-1, j, i+1, 1] *u[k-1, j, i+1, 1]+ u[k-1, j, i+1, 2] *u[k-1, j, i+1, 2]+ u[k-1, j, i+1, 3] * u[k-1, j, i+1, 3]) * tmp2- c1 * (u[k-1, j, i+1, 4] * tmp1))* (u[k-1, j, i+1, 2] * tmp1))- dt * ty1* (-(c34 - c1345)*tmp3*(pow2(u[k-1, j, i+1, 1]))- (r43*c34 - c1345)*tmp3*(pow2(u[k-1, j, i+1, 2]))- (c34 - c1345)*tmp3*(pow2(u[k-1, j, i+1, 3]))- c1345*tmp2*u[k-1, j, i+1, 4]);
                    b[j-1, i-1, 1, 4] = -dt * ty2* (-c2 * (u[k-1, j, i+1, 1]*u[k-1, j, i+1, 2]) * tmp2)- dt * ty1* (c34 - c1345) * tmp2 * u[k-1, j, i+1, 1];
                    b[j-1, i-1, 2, 4] = -dt * ty2* (c1 *(u[k-1, j, i+1, 4] * tmp1)- 0.50d * c2 *((u[k-1, j, i+1, 1]*u[k-1, j, i+1, 1]+ 3.0d * u[k-1, j, i+1, 2]*u[k-1, j, i+1, 2]+u[k-1, j, i+1, 3]*u[k-1, j, i+1, 3]) * tmp2))- dt * ty1* (r43*c34 - c1345) * tmp2 * u[k-1, j, i+1, 2];
                    b[j-1, i-1, 3, 4] = -dt * ty2* (-c2 *(u[k-1, j, i+1, 2]*u[k-1, j, i+1, 3])* tmp2)- dt * ty1 * (c34 - c1345)* tmp2 *u[k-1, j, i+1, 3];
                    b[j-1, i-1, 4, 4] = -dt * ty2* (c1 *(u[k-1, j, i+1, 2] * tmp1))- dt * ty1 * c1345 * tmp1- dt * ty1 * dy5;
                    //---------------------------------------------------------------------
                    //   form the third block sub-diagonal
                    //---------------------------------------------------------------------                      
                    tmp1 = 1.0d / u[k-1, j+1, i, 0];
                    tmp2 = tmp1 * tmp1;
                    tmp3 = tmp1 * tmp2;

                    c[j-1, i-1, 0, 0] = -dt * tx1 * dx1;
                    c[j-1, i-1, 1, 0] = -dt * tx2;
                    c[j-1, i-1, 2, 0] =   0.0d;
                    c[j-1, i-1, 3, 0] =   0.0d;
                    c[j-1, i-1, 4, 0] =   0.0d;

                    c[j-1, i-1, 0, 1] = -dt*tx2*(-pow2((u[k-1, j+1, i, 1]*tmp1))+ c2 * 0.50d * (u[k-1, j+1, i, 1] * u[k-1, j+1, i, 1]+ u[k-1, j+1, i, 2] * u[k-1, j+1, i, 2]+ u[k-1, j+1, i, 3] * u[k-1, j+1, i, 3]) * tmp2)- dt * tx1 * (-r43 * c34 * tmp2 * u[k-1, j+1, i, 1]);
                    c[j-1, i-1, 1, 1] = -dt*tx2*((2.0d-c2)*(u[k-1, j+1, i, 1] * tmp1))- dt * tx1 * (r43 * c34 * tmp1)- dt * tx1 * dx2;
                    c[j-1, i-1, 2, 1] = -dt*tx2*(-c2*(u[k-1, j+1, i, 2] * tmp1));
                    c[j-1, i-1, 3, 1] = -dt*tx2*(-c2*(u[k-1, j+1, i, 3] * tmp1));
                    c[j-1, i-1, 4, 1] = -dt*tx2*c2;

                    c[j-1, i-1, 0, 2] = -dt*tx2*(-(u[k-1, j+1, i, 1] * u[k-1, j+1, i, 2]) * tmp2)- dt * tx1 * (-c34 * tmp2 * u[k-1, j+1, i, 2]);
                    c[j-1, i-1, 1, 2] = -dt*tx2*(u[k-1, j+1, i, 2] * tmp1);
                    c[j-1, i-1, 2, 2] = -dt*tx2*(u[k-1, j+1, i, 1] * tmp1)- dt * tx1 * (c34 * tmp1)- dt * tx1 * dx3;
                    c[j-1, i-1, 3, 2] = 0.0d;
                    c[j-1, i-1, 4, 2] = 0.0d;

                    c[j-1, i-1, 0, 3] = -dt * tx2*(-(u[k-1, j+1, i, 1]*u[k-1, j+1, i, 3]) * tmp2)- dt * tx1 * (-c34 * tmp2 * u[k-1, j+1, i, 3]);
                    c[j-1, i-1, 1, 3] = -dt * tx2 * (u[k-1, j+1, i, 3] * tmp1);
                    c[j-1, i-1, 2, 3] = 0.0d;
                    c[j-1, i-1, 3, 3] = -dt * tx2 * (u[k-1, j+1, i, 1] * tmp1)- dt * tx1 * (c34 * tmp1)- dt * tx1 * dx4;
                    c[j-1, i-1, 4, 3] = 0.0d;

                    c[j-1, i-1, 0, 4] = -dt * tx2* ((c2 * (u[k-1, j+1, i, 1] * u[k-1, j+1, i, 1]+ u[k-1, j+1, i, 2] * u[k-1, j+1, i, 2]+ u[k-1, j+1, i, 3] * u[k-1, j+1, i, 3]) * tmp2- c1 * (u[k-1, j+1, i, 4] * tmp1))* (u[k-1, j+1, i, 1] * tmp1))- dt * tx1* (-(r43*c34 - c1345) * tmp3 * (pow2(u[k-1, j+1, i, 1]))- (c34 - c1345) * tmp3 * (pow2(u[k-1, j+1, i, 2]))- (c34 - c1345) * tmp3 * (pow2(u[k-1, j+1, i, 3]))- c1345 * tmp2 * u[k-1, j+1, i, 4]);
                    c[j-1, i-1, 1, 4] = -dt * tx2* (c1 * (u[k-1, j+1, i, 4] * tmp1)- 0.50d * c2* ((3.0d*u[k-1, j+1, i, 1]*u[k-1, j+1, i, 1]+u[k-1, j+1, i, 2]*u[k-1, j+1, i, 2]+u[k-1, j+1, i, 3]*u[k-1, j+1, i, 3]) * tmp2))- dt * tx1* (r43*c34 - c1345) * tmp2 * u[k-1, j+1, i, 1];
                    c[j-1, i-1, 2, 4] = -dt * tx2* (-c2 * (u[k-1, j+1, i, 2]*u[k-1, j+1, i, 1]) * tmp2)- dt * tx1* (c34 - c1345) * tmp2 * u[k-1, j+1, i, 2];
                    c[j-1, i-1, 3, 4] = -dt * tx2* (-c2 * (u[k-1, j+1, i, 3]*u[k-1, j+1, i, 1]) * tmp2)- dt * tx1* (c34 - c1345) * tmp2 * u[k-1, j+1, i, 3];
                    c[j-1, i-1, 4, 4] = -dt * tx2* (c1 * (u[k-1, j+1, i, 1] * tmp1))- dt * tx1 * c1345 * tmp1- dt * tx1 * dx5;
                }
            }
			return 0;
		}
		public void setParameters(int k){
		   this.k = k;
		}
		public static double pow2(double p) { return p * p; } 
	}
}
