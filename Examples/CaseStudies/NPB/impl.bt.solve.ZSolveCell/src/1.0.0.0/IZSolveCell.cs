using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Z;
using bt.solve.BeamWarmingMethod;
using bt.solve.SolveCell;

namespace impl.bt.solve.ZSolveCell 
{ 
	public class IZSolveCell<I, C, DIR, MTH> : BaseIZSolveCell<I, C, DIR, MTH>, ISolveCell<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IZ
	where MTH:IBeamWarmingMethod 
	{
		private double[,,,,,] lhsc;
		private int first;
		private int last;
		private int c;
		
		public void setParameters(double[,,,,,] lhsc, int first, int last, int c)
		{
			this.lhsc = lhsc;
			this.first = first;
			this.last = last;
			this.c = c;
		}
		
		public override int go() 
		{ 
            int i, j, k, isize, ksize, jsize, kstart;
            double tmp1, tmp2, tmp3;
            double[,] utmp = new double[KMAX + 4, 7];   
            double[,,] fjac = new double[MAX_CELL_DIM+5, 5, 5];
            double[,,] njac = new double[MAX_CELL_DIM+5, 5, 5];
            double[,,] lhsa = new double[MAX_CELL_DIM+3, 5, 5];
            double[,,] lhsb = new double[MAX_CELL_DIM+3, 5, 5];
            kstart = 2;
            isize = cell_size[c, 0] - end[c, 0] + 1;
            jsize = cell_size[c, 1] - end[c, 1] + 1;
            ksize = cell_size[c, 2] + 1;

            Lhsabinit.setParameters(lhsa, lhsb, ksize); 
            Lhsabinit.go();

            for(j = start[c, 1]; j <= jsize; j++) 
            {
                for(i = start[c, 0]; i <= isize; i++) 
                {
                    for(k = start[c, 2]-1; k <= cell_size[c, 2] - end[c, 2]+2; k++) 
                    {
                        utmp[k, 1] = 1.0d / u[c, k, j, i, 0];  
                        utmp[k, 2] = u[c, k, j, i, 1];  
                        utmp[k, 3] = u[c, k, j, i, 2];  
                        utmp[k, 4] = u[c, k, j, i, 3];  
                        utmp[k, 5] = u[c, k, j, i, 4];  
                        utmp[k, 6] = qs[c, k, j, i,0];  
                    }
                    for(k = start[c, 2]-1; k <= cell_size[c, 2] - end[c, 2]+2; k++) 
                    {
                        tmp1 = utmp[k, 1];
                        tmp2 = tmp1 * tmp1;
                        tmp3 = tmp1 * tmp2;

                        fjac[k+1, 0, 0] = 0.0d;   
                        fjac[k+1, 1, 0] = 0.0d;
                        fjac[k+1, 2, 0] = 0.0d;
                        fjac[k+1, 3, 0] = 1.0d;
                        fjac[k+1, 4, 0] = 0.0d;

                        fjac[k+1, 0, 1] = -(utmp[k, 2] * utmp[k, 4]) * tmp2;
                        fjac[k+1, 1, 1] = utmp[k, 4] * tmp1;
                        fjac[k+1, 2, 1] = 0.0d;
                        fjac[k+1, 3, 1] = utmp[k, 2] * tmp1;
                        fjac[k+1, 4, 1] = 0.0d;

                        fjac[k+1, 0, 2] = -(utmp[k, 3] * utmp[k, 4]) * tmp2;
                        fjac[k+1, 1, 2] = 0.0d;
                        fjac[k+1, 2, 2] = utmp[k, 4] * tmp1;
                        fjac[k+1, 3, 2] = utmp[k, 3] * tmp1;
                        fjac[k+1, 4, 2] = 0.0d;

                        fjac[k+1, 0, 3] = -(utmp[k, 4] * utmp[k, 4] * tmp2) + c2 * utmp[k, 6];
                        fjac[k+1, 1, 3] = -c2 * utmp[k, 2] * tmp1;
                        fjac[k+1, 2, 3] = -c2 * utmp[k, 3] * tmp1;
                        fjac[k+1, 3, 3] = (2.0d - c2) * utmp[k, 4] * tmp1;
                        fjac[k+1, 4, 3] = c2;

                        fjac[k+1, 0, 4] = (c2 * 2.0d * utmp[k, 6] - c1 * (utmp[k, 5] * tmp1)) * (utmp[k, 4] * tmp1);
                        fjac[k+1, 1, 4] = -c2 * (utmp[k, 2] * utmp[k, 4]) * tmp2;
                        fjac[k+1, 2, 4] = -c2 * (utmp[k, 3] * utmp[k, 4]) * tmp2;
                        fjac[k+1, 3, 4] = c1 * (utmp[k, 5] * tmp1) - c2 * (utmp[k, 6] + utmp[k, 4] * utmp[k, 4] * tmp2);
                        fjac[k+1, 4, 4] = c1 * utmp[k, 4] * tmp1;

                        njac[k+1, 0, 0] = 0.0d;
                        njac[k+1, 1, 0] = 0.0d;
                        njac[k+1, 2, 0] = 0.0d;
                        njac[k+1, 3, 0] = 0.0d;
                        njac[k+1, 4, 0] = 0.0d;

                        njac[k+1, 0, 1] = -c3c4 * tmp2 * utmp[k, 2];
                        njac[k+1, 1, 1] = c3c4 * tmp1;
                        njac[k+1, 2, 1] = 0.0d;
                        njac[k+1, 3, 1] = 0.0d;
                        njac[k+1, 4, 1] = 0.0d;

                        njac[k+1, 0, 2] = -c3c4 * tmp2 * utmp[k, 3];
                        njac[k+1, 1, 2] = 0.0d;
                        njac[k+1, 2, 2] = c3c4 * tmp1;
                        njac[k+1, 3, 2] = 0.0d;
                        njac[k+1, 4, 2] = 0.0d;

                        njac[k+1, 0, 3] = -con43 * c3c4 * tmp2 * utmp[k, 4];
                        njac[k+1, 1, 3] = 0.0d;
                        njac[k+1, 2, 3] = 0.0d;
                        njac[k+1, 3, 3] = con43 * c3 * c4 * tmp1;
                        njac[k+1, 4, 3] = 0.0d;

                        njac[k+1, 0, 4] = -(c3c4 - c1345) * tmp3 * (pow2(utmp[k, 2])) -
                                        (c3c4 - c1345) * tmp3 * (pow2(utmp[k, 3])) - (con43 * c3c4 - c1345) * tmp3 * (pow2(utmp[k, 4])) - c1345 * tmp2 * utmp[k, 5];

                        njac[k+1, 1, 4] = (c3c4 - c1345) * tmp2 * utmp[k, 2];
                        njac[k+1, 2, 4] = (c3c4 - c1345) * tmp2 * utmp[k, 3];
                        njac[k+1, 3, 4] = (con43 * c3c4 - c1345) * tmp2 * utmp[k, 4];
                        njac[k+1, 4, 4] = (c1345) * tmp1;
                    }
                    
                    for(k = start[c, 2]; k <= ksize - end[c, 2]; k++) 
                    {                       
                        tmp1 = dt * tz1;
                        tmp2 = dt * tz2;
                        lhsa[k, 0, 0] = -tmp2 * fjac[k, 0, 0] - tmp1 * njac[k, 0, 0] - tmp1 * dz1;
                        lhsa[k, 1, 0] = -tmp2 * fjac[k, 1, 0] - tmp1 * njac[k, 1, 0];    
                        lhsa[k, 2, 0] = -tmp2 * fjac[k, 2, 0] - tmp1 * njac[k, 2, 0];
                        lhsa[k, 3, 0] = -tmp2 * fjac[k, 3, 0] - tmp1 * njac[k, 3, 0];
                        lhsa[k, 4, 0] = -tmp2 * fjac[k, 4, 0] - tmp1 * njac[k, 4, 0];

                        lhsa[k, 0, 1] = -tmp2 * fjac[k, 0, 1] - tmp1 * njac[k, 0, 1];
                        lhsa[k, 1, 1] = -tmp2 * fjac[k, 1, 1] - tmp1 * njac[k, 1, 1] - tmp1 * dz2;
                        lhsa[k, 2, 1] = -tmp2 * fjac[k, 2, 1] - tmp1 * njac[k, 2, 1];
                        lhsa[k, 3, 1] = -tmp2 * fjac[k, 3, 1] - tmp1 * njac[k, 3, 1];
                        lhsa[k, 4, 1] = -tmp2 * fjac[k, 4, 1] - tmp1 * njac[k, 4, 1];

                        lhsa[k, 0, 2] = -tmp2 * fjac[k, 0, 2] - tmp1 * njac[k, 0, 2];
                        lhsa[k, 1, 2] = -tmp2 * fjac[k, 1, 2] - tmp1 * njac[k, 1, 2];
                        lhsa[k, 2, 2] = -tmp2 * fjac[k, 2, 2] - tmp1 * njac[k, 2, 2] - tmp1 * dz3;
                        lhsa[k, 3, 2] = -tmp2 * fjac[k, 3, 2] - tmp1 * njac[k, 3, 2];
                        lhsa[k, 4, 2] = -tmp2 * fjac[k, 4, 2] - tmp1 * njac[k, 4, 2];

                        lhsa[k, 0, 3] = -tmp2 * fjac[k, 0, 3] - tmp1 * njac[k, 0, 3];
                        lhsa[k, 1, 3] = -tmp2 * fjac[k, 1, 3] - tmp1 * njac[k, 1, 3];
                        lhsa[k, 2, 3] = -tmp2 * fjac[k, 2, 3] - tmp1 * njac[k, 2, 3];
                        lhsa[k, 3, 3] = -tmp2 * fjac[k, 3, 3] - tmp1 * njac[k, 3, 3] - tmp1 * dz4;
                        lhsa[k, 4, 3] = -tmp2 * fjac[k, 4, 3] - tmp1 * njac[k, 4, 3];

                        lhsa[k, 0, 4] = -tmp2 * fjac[k, 0, 4] - tmp1 * njac[k, 0, 4];
                        lhsa[k, 1, 4] = -tmp2 * fjac[k, 1, 4] - tmp1 * njac[k, 1, 4];
                        lhsa[k, 2, 4] = -tmp2 * fjac[k, 2, 4] - tmp1 * njac[k, 2, 4];
                        lhsa[k, 3, 4] = -tmp2 * fjac[k, 3, 4] - tmp1 * njac[k, 3, 4];
                        lhsa[k, 4, 4] = -tmp2 * fjac[k, 4, 4] - tmp1 * njac[k, 4, 4] - tmp1 * dz5;

                        lhsb[k, 0, 0] = 1.0d + tmp1 * 2.0d * njac[k+1, 0, 0] + tmp1 * 2.0d * dz1; 
                        lhsb[k, 1, 0] = tmp1 * 2.0d * njac[k+1, 1, 0];
                        lhsb[k, 2, 0] = tmp1 * 2.0d * njac[k+1, 2, 0];
                        lhsb[k, 3, 0] = tmp1 * 2.0d * njac[k+1, 3, 0];
                        lhsb[k, 4, 0] = tmp1 * 2.0d * njac[k+1, 4, 0];

                        lhsb[k, 0, 1] = tmp1 * 2.0d * njac[k+1, 0, 1];
                        lhsb[k, 1, 1] = 1.0d + tmp1 * 2.0d * njac[k+1, 1, 1] + tmp1 * 2.0d * dz2;
                        lhsb[k, 2, 1] = tmp1 * 2.0d * njac[k+1, 2, 1];
                        lhsb[k, 3, 1] = tmp1 * 2.0d * njac[k+1, 3, 1];
                        lhsb[k, 4, 1] = tmp1 * 2.0d * njac[k+1, 4, 1];

                        lhsb[k, 0, 2] = tmp1 * 2.0d * njac[k+1, 0, 2];
                        lhsb[k, 1, 2] = tmp1 * 2.0d * njac[k+1, 1, 2];
                        lhsb[k, 2, 2] = 1.0d + tmp1 * 2.0d * njac[k+1, 2, 2] + tmp1 * 2.0d * dz3;
                        lhsb[k, 3, 2] = tmp1 * 2.0d * njac[k+1, 3, 2];
                        lhsb[k, 4, 2] = tmp1 * 2.0d * njac[k+1, 4, 2];

                        lhsb[k, 0, 3] = tmp1 * 2.0d * njac[k+1, 0, 3];
                        lhsb[k, 1, 3] = tmp1 * 2.0d * njac[k+1, 1, 3];
                        lhsb[k, 2, 3] = tmp1 * 2.0d * njac[k+1, 2, 3];
                        lhsb[k, 3, 3] = 1.0d + tmp1 * 2.0d * njac[k+1, 3, 3] + tmp1 * 2.0d * dz4;
                        lhsb[k, 4, 3] = tmp1 * 2.0d * njac[k+1, 4, 3];

                        lhsb[k, 0, 4] = tmp1 * 2.0d * njac[k+1, 0, 4];
                        lhsb[k, 1, 4] = tmp1 * 2.0d * njac[k+1, 1, 4];
                        lhsb[k, 2, 4] = tmp1 * 2.0d * njac[k+1, 2, 4];
                        lhsb[k, 3, 4] = tmp1 * 2.0d * njac[k+1, 3, 4];
                        lhsb[k, 4, 4] = 1.0d + tmp1 * 2.0d * njac[k+1, 4, 4] + tmp1 * 2.0d * dz5;

                        lhsc[c, k, j, i, 0, 0] = tmp2 * fjac[k+2, 0, 0] - tmp1 * njac[k+2, 0, 0] - tmp1 * dz1;
                        lhsc[c, k, j, i, 1, 0] = tmp2 * fjac[k+2, 1, 0] - tmp1 * njac[k+2, 1, 0];
                        lhsc[c, k, j, i, 2, 0] = tmp2 * fjac[k+2, 2, 0] - tmp1 * njac[k+2, 2, 0];
                        lhsc[c, k, j, i, 3, 0] = tmp2 * fjac[k+2, 3, 0] - tmp1 * njac[k+2, 3, 0];
                        lhsc[c, k, j, i, 4, 0] = tmp2 * fjac[k+2, 4, 0] - tmp1 * njac[k+2, 4, 0];

                        lhsc[c, k, j, i, 0, 1] = tmp2 * fjac[k+2, 0, 1] - tmp1 * njac[k+2, 0, 1];
                        lhsc[c, k, j, i, 1, 1] = tmp2 * fjac[k+2, 1, 1] - tmp1 * njac[k+2, 1, 1] - tmp1 * dz2;
                        lhsc[c, k, j, i, 2, 1] = tmp2 * fjac[k+2, 2, 1] - tmp1 * njac[k+2, 2, 1];
                        lhsc[c, k, j, i, 3, 1] = tmp2 * fjac[k+2, 3, 1] - tmp1 * njac[k+2, 3, 1];
                        lhsc[c, k, j, i, 4, 1] = tmp2 * fjac[k+2, 4, 1] - tmp1 * njac[k+2, 4, 1];

                        lhsc[c, k, j, i, 0, 2] = tmp2 * fjac[k+2, 0, 2] - tmp1 * njac[k+2, 0, 2];
                        lhsc[c, k, j, i, 1, 2] = tmp2 * fjac[k+2, 1, 2] - tmp1 * njac[k+2, 1, 2];
                        lhsc[c, k, j, i, 2, 2] = tmp2 * fjac[k+2, 2, 2] - tmp1 * njac[k+2, 2, 2] - tmp1 * dz3;
                        lhsc[c, k, j, i, 3, 2] = tmp2 * fjac[k+2, 3, 2] - tmp1 * njac[k+2, 3, 2];
                        lhsc[c, k, j, i, 4, 2] = tmp2 * fjac[k+2, 4, 2] - tmp1 * njac[k+2, 4, 2];

                        lhsc[c, k, j, i, 0, 3] = tmp2 * fjac[k+2, 0, 3] - tmp1 * njac[k+2, 0, 3];
                        lhsc[c, k, j, i, 1, 3] = tmp2 * fjac[k+2, 1, 3] - tmp1 * njac[k+2, 1, 3];
                        lhsc[c, k, j, i, 2, 3] = tmp2 * fjac[k+2, 2, 3] - tmp1 * njac[k+2, 2, 3];
                        lhsc[c, k, j, i, 3, 3] = tmp2 * fjac[k+2, 3, 3] - tmp1 * njac[k+2, 3, 3] - tmp1 * dz4;
                        lhsc[c, k, j, i, 4, 3] = tmp2 * fjac[k+2, 4, 3] - tmp1 * njac[k+2, 4, 3];

                        lhsc[c, k, j, i, 0, 4] = tmp2 * fjac[k+2, 0, 4] - tmp1 * njac[k+2, 0, 4];
                        lhsc[c, k, j, i, 1, 4] = tmp2 * fjac[k+2, 1, 4] - tmp1 * njac[k+2, 1, 4];
                        lhsc[c, k, j, i, 2, 4] = tmp2 * fjac[k+2, 2, 4] - tmp1 * njac[k+2, 2, 4];
                        lhsc[c, k, j, i, 3, 4] = tmp2 * fjac[k+2, 3, 4] - tmp1 * njac[k+2, 3, 4];
                        lhsc[c, k, j, i, 4, 4] = tmp2 * fjac[k+2, 4, 4] - tmp1 * njac[k+2, 4, 4] - tmp1 * dz5;
                    }
                    
                    if(first == 1) 
                    {
                        Binvcrhs.setParameters(lhsb, lhsc, rhs, kstart, c, kstart, j, i, c, kstart, j, i);
                        Binvcrhs.go();
                    }
                    
                    for(k = kstart + first; k <= ksize - last; k++) 
                    {
                        Matvec_sub.setParameters(lhsa, rhs, rhs, k, c, k-1, j, i, c, k, j, i);
                        Matvec_sub.go();
                        Matmul_sub.setParameters(lhsa, lhsc, lhsb, k, c, k-1, j, i, k);
                        Matmul_sub.go();
                        Binvcrhs.setParameters(lhsb, lhsc, rhs, k, c, k, j, i, c, k, j, i);
                        Binvcrhs.go();
                    }
                    
                    if(last == 1) 
                    {
                        Matvec_sub.setParameters(lhsa, rhs, rhs, ksize, c, ksize-1, j, i, c, ksize, j, i);
                        Matvec_sub.go();
                        Matmul_sub.setParameters(lhsa, lhsc, lhsb, ksize, c, ksize-1, j, i, ksize);
                        Matmul_sub.go();
                        Binvrhs.setParameters(lhsb, rhs, ksize, c, ksize, j, i);
                        Binvrhs.go();
                    }
                }
            }
            
            return 0;
		}
	}
}
