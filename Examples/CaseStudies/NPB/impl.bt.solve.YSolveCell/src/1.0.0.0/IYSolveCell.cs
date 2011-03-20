using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.SolveCell;

namespace impl.bt.solve.YSolveCell { 
	public class IYSolveCell<I, C, DIR, MTH> : BaseIYSolveCell<I, C, DIR, MTH>, ISolveCell<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IY
	where MTH:IBeamWarmingMethod {
		private double[,,,,,] lhsc;
		private int first;
		private int last;
		private int c;
		public void setParameters(double[,,,,,] lhsc, int first, int last, int c){
			this.lhsc = lhsc;
			this.first = first;
			this.last = last;
			this.c = c;
		}
		public IYSolveCell() { 
		
		} 
		
		public override void compute() { 
            int i, j, k, isize, ksize, jsize, jstart;
            double tmp1, tmp2, tmp3;
            double[,] utmp = new double[JMAX + 4, 7];
            double[,,] fjac = new double[MAX_CELL_DIM+5, 5, 5];
            double[,,] njac = new double[MAX_CELL_DIM+5, 5, 5];
            double[,,] lhsa = new double[MAX_CELL_DIM+3, 5, 5];
            double[,,] lhsb = new double[MAX_CELL_DIM+3, 5, 5];
            jstart = 2;
            isize = cell_size[c, 0] - end[c, 0] + 1;
            jsize = cell_size[c, 1] + 1;
            ksize = cell_size[c, 2] - end[c, 2] + 1;

            Lhsabinit.setParameters(lhsa, lhsb, jsize);
            Lhsabinit.compute();

            for(k = start[c, 2]; k <= ksize; k++) {
                for(i = start[c, 0]; i <= isize; i++) {
                    for(j = start[c, 1]-1; j <= cell_size[c, 1] - end[c, 1] + 2; j++) {
                        utmp[j, 1] = 1.0d / u[c, k, j, i, 0];  
                        utmp[j, 2] = u[c, k, j, i, 1];         
                        utmp[j, 3] = u[c, k, j, i, 2];         
                        utmp[j, 4] = u[c, k, j, i, 3];         
                        utmp[j, 5] = u[c, k, j, i, 4];         
                        utmp[j, 6] = qs[c, k, j, i, 0];           
                    }

                    for(j = start[c, 1]-1; j <= cell_size[c, 1] - end[c, 1] + 2; j++) {
                        tmp1 = utmp[j, 1];
                        tmp2 = tmp1 * tmp1;
                        tmp3 = tmp1 * tmp2;

                        fjac[j+1, 0, 0] = 0.0d;
                        fjac[j+1, 1, 0] = 0.0d;
                        fjac[j+1, 2, 0] = 1.0d;
                        fjac[j+1, 3, 0] = 0.0d;
                        fjac[j+1, 4, 0] = 0.0d;

                        fjac[j+1, 0, 1] = -(utmp[j, 2] * utmp[j, 3]) * tmp2;
                        fjac[j+1, 1, 1] = utmp[j, 3] * tmp1;
                        fjac[j+1, 2, 1] = utmp[j, 2] * tmp1;
                        fjac[j+1, 3, 1] = 0.0d;
                        fjac[j+1, 4, 1] = 0.0d;

                        fjac[j+1, 0, 2] = -(utmp[j, 3] * utmp[j, 3] * tmp2) + c2 * utmp[j, 6];
                        fjac[j+1, 1, 2] = -c2 * utmp[j, 2] * tmp1;
                        fjac[j+1, 2, 2] = (2.0d - c2) * utmp[j, 3] * tmp1;
                        fjac[j+1, 3, 2] = -c2 * utmp[j, 4] * tmp1;
                        fjac[j+1, 4, 2] = c2;

                        fjac[j+1, 0, 3] = -(utmp[j, 3] * utmp[j, 4]) * tmp2;
                        fjac[j+1, 1, 3] = 0.0d;
                        fjac[j+1, 2, 3] = utmp[j, 4] * tmp1;
                        fjac[j+1, 3, 3] = utmp[j, 3] * tmp1;
                        fjac[j+1, 4, 3] = 0.0d;

                        fjac[j+1, 0, 4] = (c2 * 2.0d * utmp[j, 6] - c1 * utmp[j, 5] * tmp1) * utmp[j, 3] * tmp1;
                        fjac[j+1, 1, 4] = -c2 * utmp[j, 2] * utmp[j, 3] * tmp2;
                        fjac[j+1, 2, 4] = c1 * utmp[j, 5] * tmp1 - c2 * (utmp[j, 6] + utmp[j, 3] * utmp[j, 3] * tmp2);
                        fjac[j+1, 3, 4] = -c2 * (utmp[j, 3] * utmp[j, 4]) * tmp2;
                        fjac[j+1, 4, 4] = c1 * utmp[j, 3] * tmp1;

                        njac[j+1, 0, 0] = 0.0d;
                        njac[j+1, 1, 0] = 0.0d;
                        njac[j+1, 2, 0] = 0.0d;
                        njac[j+1, 3, 0] = 0.0d;
                        njac[j+1, 4, 0] = 0.0d;

                        njac[j+1, 0, 1] = -c3c4 * tmp2 * utmp[j, 2];
                        njac[j+1, 1, 1] = c3c4 * tmp1;
                        njac[j+1, 2, 1] = 0.0d;
                        njac[j+1, 3, 1] = 0.0d;
                        njac[j+1, 4, 1] = 0.0d;

                        njac[j+1, 0, 2] = -con43 * c3c4 * tmp2 * utmp[j, 3];
                        njac[j+1, 1, 2] = 0.0d;
                        njac[j+1, 2, 2] = con43 * c3c4 * tmp1;
                        njac[j+1, 3, 2] = 0.0d;
                        njac[j+1, 4, 2] = 0.0d;

                        njac[j+1, 0, 3] = -c3c4 * tmp2 * utmp[j, 4];
                        njac[j+1, 1, 3] = 0.0d;
                        njac[j+1, 2, 3] = 0.0d;
                        njac[j+1, 3, 3] = c3c4 * tmp1;
                        njac[j+1, 4, 3] = 0.0d;

                        njac[j+1, 0, 4] = -(c3c4 - c1345) * tmp3 * (pow2(utmp[j, 2])) -
                                        (con43 * c3c4 - c1345) * tmp3 * (pow2(utmp[j, 3])) - (c3c4 - c1345) * tmp3 * (pow2(utmp[j, 4])) - c1345 * tmp2 * utmp[j, 5];

                        njac[j+1, 1, 4] = (c3c4 - c1345) * tmp2 * utmp[j, 2];
                        njac[j+1, 2, 4] = (con43 * c3c4 - c1345) * tmp2 * utmp[j, 3];
                        njac[j+1, 3, 4] = (c3c4 - c1345) * tmp2 * utmp[j, 4];
                        njac[j+1, 4, 4] = (c1345) * tmp1;
                    }
                    for(j = start[c, 1]; j <= jsize - end[c, 1]; j++) {
                        tmp1 = dt * ty1;
                        tmp2 = dt * ty2;
                        lhsa[j, 0, 0] = -tmp2 * fjac[j, 0, 0] - tmp1 * njac[j, 0, 0] - tmp1 * dy1;
                        lhsa[j, 1, 0] = -tmp2 * fjac[j, 1, 0] - tmp1 * njac[j, 1, 0];
                        lhsa[j, 2, 0] = -tmp2 * fjac[j, 2, 0] - tmp1 * njac[j, 2, 0];
                        lhsa[j, 3, 0] = -tmp2 * fjac[j, 3, 0] - tmp1 * njac[j, 3, 0];
                        lhsa[j, 4, 0] = -tmp2 * fjac[j, 4, 0] - tmp1 * njac[j, 4, 0]; 

                        lhsa[j, 0, 1] = -tmp2 * fjac[j, 0, 1] - tmp1 * njac[j, 0, 1];
                        lhsa[j, 1, 1] = -tmp2 * fjac[j, 1, 1] - tmp1 * njac[j, 1, 1] - tmp1 * dy2;
                        lhsa[j, 2, 1] = -tmp2 * fjac[j, 2, 1] - tmp1 * njac[j, 2, 1];
                        lhsa[j, 3, 1] = -tmp2 * fjac[j, 3, 1] - tmp1 * njac[j, 3, 1];
                        lhsa[j, 4, 1] = -tmp2 * fjac[j, 4, 1] - tmp1 * njac[j, 4, 1];

                        lhsa[j, 0, 2] = -tmp2 * fjac[j, 0, 2] - tmp1 * njac[j, 0, 2];
                        lhsa[j, 1, 2] = -tmp2 * fjac[j, 1, 2] - tmp1 * njac[j, 1, 2];
                        lhsa[j, 2, 2] = -tmp2 * fjac[j, 2, 2] - tmp1 * njac[j, 2, 2] - tmp1 * dy3;
                        lhsa[j, 3, 2] = -tmp2 * fjac[j, 3, 2] - tmp1 * njac[j, 3, 2];
                        lhsa[j, 4, 2] = -tmp2 * fjac[j, 4, 2] - tmp1 * njac[j, 4, 2];

                        lhsa[j, 0, 3] = -tmp2 * fjac[j, 0, 3] - tmp1 * njac[j, 0, 3];
                        lhsa[j, 1, 3] = -tmp2 * fjac[j, 1, 3] - tmp1 * njac[j, 1, 3];
                        lhsa[j, 2, 3] = -tmp2 * fjac[j, 2, 3] - tmp1 * njac[j, 2, 3];
                        lhsa[j, 3, 3] = -tmp2 * fjac[j, 3, 3] - tmp1 * njac[j, 3, 3] - tmp1 * dy4;
                        lhsa[j, 4, 3] = -tmp2 * fjac[j, 4, 3] - tmp1 * njac[j, 4, 3];

                        lhsa[j, 0, 4] = -tmp2 * fjac[j, 0, 4] - tmp1 * njac[j, 0, 4];
                        lhsa[j, 1, 4] = -tmp2 * fjac[j, 1, 4] - tmp1 * njac[j, 1, 4];
                        lhsa[j, 2, 4] = -tmp2 * fjac[j, 2, 4] - tmp1 * njac[j, 2, 4];
                        lhsa[j, 3, 4] = -tmp2 * fjac[j, 3, 4] - tmp1 * njac[j, 3, 4];
                        lhsa[j, 4, 4] = -tmp2 * fjac[j, 4, 4] - tmp1 * njac[j, 4, 4] - tmp1 * dy5;

                        lhsb[j, 0, 0] = 1.0d + tmp1 * 2.0d * njac[j+1, 0, 0] + tmp1 * 2.0d * dy1;
                        lhsb[j, 1, 0] = tmp1 * 2.0d * njac[j+1, 1, 0];  
                        lhsb[j, 2, 0] = tmp1 * 2.0d * njac[j+1, 2, 0];  
                        lhsb[j, 3, 0] = tmp1 * 2.0d * njac[j+1, 3, 0];  
                        lhsb[j, 4, 0] = tmp1 * 2.0d * njac[j+1, 4, 0];  

                        lhsb[j, 0, 1] = tmp1 * 2.0d * njac[j+1, 0, 1];
                        lhsb[j, 1, 1] = 1.0d + tmp1 * 2.0d * njac[j+1, 1, 1] + tmp1 * 2.0d * dy2;
                        lhsb[j, 2, 1] = tmp1 * 2.0d * njac[j+1, 2, 1];
                        lhsb[j, 3, 1] = tmp1 * 2.0d * njac[j+1, 3, 1];
                        lhsb[j, 4, 1] = tmp1 * 2.0d * njac[j+1, 4, 1];

                        lhsb[j, 0, 2] = tmp1 * 2.0d * njac[j+1, 0, 2];
                        lhsb[j, 1, 2] = tmp1 * 2.0d * njac[j+1, 1, 2];
                        lhsb[j, 2, 2] = 1.0d + tmp1 * 2.0d * njac[j+1, 2, 2] + tmp1 * 2.0d * dy3;
                        lhsb[j, 3, 2] = tmp1 * 2.0d * njac[j+1, 3, 2];
                        lhsb[j, 4, 2] = tmp1 * 2.0d * njac[j+1, 4, 2];

                        lhsb[j, 0, 3] = tmp1 * 2.0d * njac[j+1, 0, 3];
                        lhsb[j, 1, 3] = tmp1 * 2.0d * njac[j+1, 1, 3];
                        lhsb[j, 2, 3] = tmp1 * 2.0d * njac[j+1, 2, 3];
                        lhsb[j, 3, 3] = 1.0d + tmp1 * 2.0d * njac[j+1, 3, 3] + tmp1 * 2.0d * dy4;
                        lhsb[j, 4, 3] = tmp1 * 2.0d * njac[j+1, 4, 3];

                        lhsb[j, 0, 4] = tmp1 * 2.0d * njac[j+1, 0, 4];
                        lhsb[j, 1, 4] = tmp1 * 2.0d * njac[j+1, 1, 4];
                        lhsb[j, 2, 4] = tmp1 * 2.0d * njac[j+1, 2, 4];
                        lhsb[j, 3, 4] = tmp1 * 2.0d * njac[j+1, 3, 4];
                        lhsb[j, 4, 4] = 1.0d + tmp1 * 2.0d * njac[j+1, 4, 4] + tmp1 * 2.0d * dy5;

                        lhsc[c, k, j, i, 0, 0] = tmp2 * fjac[j+2, 0, 0] - tmp1 * njac[j+2, 0, 0] - tmp1 * dy1;
                        lhsc[c, k, j, i, 1, 0] = tmp2 * fjac[j+2, 1, 0] - tmp1 * njac[j+2, 1, 0];
                        lhsc[c, k, j, i, 2, 0] = tmp2 * fjac[j+2, 2, 0] - tmp1 * njac[j+2, 2, 0];
                        lhsc[c, k, j, i, 3, 0] = tmp2 * fjac[j+2, 3, 0] - tmp1 * njac[j+2, 3, 0];
                        lhsc[c, k, j, i, 4, 0] = tmp2 * fjac[j+2, 4, 0] - tmp1 * njac[j+2, 4, 0];

                        lhsc[c, k, j, i, 0, 1] = tmp2 * fjac[j+2, 0, 1] - tmp1 * njac[j+2, 0, 1];
                        lhsc[c, k, j, i, 1, 1] = tmp2 * fjac[j+2, 1, 1] - tmp1 * njac[j+2, 1, 1] - tmp1 * dy2;
                        lhsc[c, k, j, i, 2, 1] = tmp2 * fjac[j+2, 2, 1] - tmp1 * njac[j+2, 2, 1];
                        lhsc[c, k, j, i, 3, 1] = tmp2 * fjac[j+2, 3, 1] - tmp1 * njac[j+2, 3, 1];
                        lhsc[c, k, j, i, 4, 1] = tmp2 * fjac[j+2, 4, 1] - tmp1 * njac[j+2, 4, 1];

                        lhsc[c, k, j, i, 0, 2] = tmp2 * fjac[j+2, 0, 2] - tmp1 * njac[j+2, 0, 2];
                        lhsc[c, k, j, i, 1, 2] = tmp2 * fjac[j+2, 1, 2] - tmp1 * njac[j+2, 1, 2];
                        lhsc[c, k, j, i, 2, 2] = tmp2 * fjac[j+2, 2, 2] - tmp1 * njac[j+2, 2, 2] - tmp1 * dy3;
                        lhsc[c, k, j, i, 3, 2] = tmp2 * fjac[j+2, 3, 2] - tmp1 * njac[j+2, 3, 2];
                        lhsc[c, k, j, i, 4, 2] = tmp2 * fjac[j+2, 4, 2] - tmp1 * njac[j+2, 4, 2];

                        lhsc[c, k, j, i, 0, 3] = tmp2 * fjac[j+2, 0, 3] - tmp1 * njac[j+2, 0, 3];
                        lhsc[c, k, j, i, 1, 3] = tmp2 * fjac[j+2, 1, 3] - tmp1 * njac[j+2, 1, 3];
                        lhsc[c, k, j, i, 2, 3] = tmp2 * fjac[j+2, 2, 3] - tmp1 * njac[j+2, 2, 3];
                        lhsc[c, k, j, i, 3, 3] = tmp2 * fjac[j+2, 3, 3] - tmp1 * njac[j+2, 3, 3] - tmp1 * dy4;
                        lhsc[c, k, j, i, 4, 3] = tmp2 * fjac[j+2, 4, 3] - tmp1 * njac[j+2, 4, 3];

                        lhsc[c, k, j, i, 0, 4] = tmp2 * fjac[j+2, 0, 4] - tmp1 * njac[j+2, 0, 4];
                        lhsc[c, k, j, i, 1, 4] = tmp2 * fjac[j+2, 1, 4] - tmp1 * njac[j+2, 1, 4];
                        lhsc[c, k, j, i, 2, 4] = tmp2 * fjac[j+2, 2, 4] - tmp1 * njac[j+2, 2, 4];
                        lhsc[c, k, j, i, 3, 4] = tmp2 * fjac[j+2, 3, 4] - tmp1 * njac[j+2, 3, 4];
                        lhsc[c, k, j, i, 4, 4] = tmp2 * fjac[j+2, 4, 4] - tmp1 * njac[j+2, 4, 4] - tmp1 * dy5;
                    }
                    if(first == 1) {
                        Binvcrhs.setParameters(lhsb, lhsc, rhs, jstart, c, k, jstart, i, c, k, jstart, i);
                        Binvcrhs.compute();
                    }
                    for(j = jstart + first; j <= jsize - last; j++) {
                        Matvec_sub.setParameters(lhsa, rhs, rhs, j, c, k, j-1, i, c, k, j, i);
                        Matvec_sub.compute();
                        Matmul_sub.setParameters(lhsa, lhsc, lhsb, j, c, k, j-1, i, j);
                        Matmul_sub.compute();
                        Binvcrhs.setParameters(lhsb, lhsc, rhs, j, c, k, j, i, c, k, j, i);
                        Binvcrhs.compute();
                    }
                    if(last == 1) {
                        Matvec_sub.setParameters(lhsa, rhs, rhs, jsize, c, k, jsize-1, i, c, k, jsize, i);
                        Matvec_sub.compute();
                        Matmul_sub.setParameters(lhsa, lhsc, lhsb, jsize, c, k, jsize-1, i, jsize);
                        Matmul_sub.compute();
                        Binvrhs.setParameters(lhsb, rhs, jsize, c, k, jsize, i);
                        Binvrhs.compute();
                    }
                }
            }
		}
	}
}
