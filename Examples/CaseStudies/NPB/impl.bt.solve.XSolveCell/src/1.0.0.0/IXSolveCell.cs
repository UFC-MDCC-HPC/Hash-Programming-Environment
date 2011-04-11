using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.SolveCell;

namespace impl.bt.solve.XSolveCell 
{ 
	public class IXSolveCell<I, C, DIR, MTH> : BaseIXSolveCell<I, C, DIR, MTH>, ISolveCell<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IX
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
            int i, j, k, isize, ksize, jsize, istart;
            double tmp1, tmp2, tmp3;
            double[,,] fjac = new double[MAX_CELL_DIM+5, 5, 5];
            double[,,] njac = new double[MAX_CELL_DIM+5, 5, 5];
            double[,,] lhsa = new double[MAX_CELL_DIM+3, 5, 5];
            double[,,] lhsb = new double[MAX_CELL_DIM+3, 5, 5];
            istart = 2;
            isize = cell_size[c, 0] + 1;
            jsize = cell_size[c, 1] - end[c, 1] + 1;
            ksize = cell_size[c, 2] - end[c, 2] + 1;

            Lhsabinit.setParameters(lhsa, lhsb, isize);
            Lhsabinit.go();
            
            for(k = start[c, 2]; k <= ksize; k++)             
            {
                for(j = start[c, 1]; j <= jsize; j++) 
                {
                    for(i = start[c, 0]-1; i <= cell_size[c, 0] - end[c, 0]+2; i++) 
                    {
                        tmp1 = rho_i[c, k, j, i, 0];  
                        tmp2 = tmp1 * tmp1;
                        tmp3 = tmp1 * tmp2;

                        fjac[i+1, 0, 0] = 0.0d; 
                        fjac[i+1, 1, 0] = 1.0d; 
                        fjac[i+1, 2, 0] = 0.0d; 
                        fjac[i+1, 3, 0] = 0.0d; 
                        fjac[i+1, 4, 0] = 0.0d; 

                        fjac[i+1, 0, 1] = -(u[c, k, j, i, 1] * tmp2 * u[c, k, j, i, 1]) + c2 * qs[c, k, j, i, 0];
                        fjac[i+1, 1, 1] = (2.0d - c2) * (u[c, k, j, i, 1] * tmp1);
                        fjac[i+1, 2, 1] = -c2 * (u[c, k, j, i, 2] * tmp1);
                        fjac[i+1, 3, 1] = -c2 * (u[c, k, j, i, 3] * tmp1);
                        fjac[i+1, 4, 1] = c2;

                        fjac[i+1, 0, 2] = -(u[c, k, j, i, 1] * u[c, k, j, i, 2]) * tmp2;
                        fjac[i+1, 1, 2] = u[c, k, j, i, 2] * tmp1;
                        fjac[i+1, 2, 2] = u[c, k, j, i, 1] * tmp1;
                        fjac[i+1, 3, 2] = 0.0d;
                        fjac[i+1, 4, 2] = 0.0d;

                        fjac[i+1, 0, 3] = -(u[c, k, j, i, 1] * u[c, k, j, i, 3]) * tmp2;
                        fjac[i+1, 1, 3] = u[c, k, j, i, 3] * tmp1;
                        fjac[i+1, 2, 3] = 0.0d;
                        fjac[i+1, 3, 3] = u[c, k, j, i, 1] * tmp1;
                        fjac[i+1, 4, 3] = 0.0d;

                        fjac[i+1, 0, 4] = (c2 * 2.0d * qs[c, k, j, i, 0] - c1 * (u[c, k, j, i, 4] * tmp1)) * (u[c, k, j, i, 1] * tmp1);
                        fjac[i+1, 1, 4] = c1 * u[c, k, j, i, 4] * tmp1 - c2 * (u[c, k, j, i, 1] * u[c, k, j, i, 1] * tmp2 + qs[c, k, j, i, 0]);
                        fjac[i+1, 2, 4] = -c2 * (u[c, k, j, i, 2] * u[c, k, j, i, 1]) * tmp2;
                        fjac[i+1, 3, 4] = -c2 * (u[c, k, j, i, 3] * u[c, k, j, i, 1]) * tmp2;
                        fjac[i+1, 4, 4] = c1 * (u[c, k, j, i, 1] * tmp1);

                        njac[i+1, 0, 0] = 0.0d;
                        njac[i+1, 1, 0] = 0.0d;
                        njac[i+1, 2, 0] = 0.0d;
                        njac[i+1, 3, 0] = 0.0d;
                        njac[i+1, 4, 0] = 0.0d;

                        njac[i+1, 0, 1] = -con43 * c3c4 * tmp2 * u[c, k, j, i, 1];  
                        njac[i+1, 1, 1] = con43 * c3c4 * tmp1;
                        njac[i+1, 2, 1] = 0.0d;
                        njac[i+1, 3, 1] = 0.0d;
                        njac[i+1, 4, 1] = 0.0d;

                        njac[i+1, 0, 2] = -c3c4 * tmp2 * u[c, k, j, i, 2];  
                        njac[i+1, 1, 2] = 0.0d;
                        njac[i+1, 2, 2] = c3c4 * tmp1;
                        njac[i+1, 3, 2] = 0.0d;
                        njac[i+1, 4, 2] = 0.0d;

                        njac[i+1, 0, 3] = -c3c4 * tmp2 * u[c, k, j, i, 3];  
                        njac[i+1, 1, 3] = 0.0d;
                        njac[i+1, 2, 3] = 0.0d;
                        njac[i+1, 3, 3] = c3c4 * tmp1;
                        njac[i+1, 4, 3] = 0.0d;

                        njac[i+1, 0, 4] = -(con43 * c3c4
                            - c1345) * tmp3 * (pow2(u[c, k, j, i, 1]))           
                            - (c3c4 - c1345) * tmp3 * (pow2(u[c, k, j, i, 2]))  
                            - (c3c4 - c1345) * tmp3 * (pow2(u[c, k, j, i, 3]))  
                            - c1345 * tmp2 * u[c, k, j, i, 4];  

                        njac[i+1, 1, 4] = (con43 * c3c4 - c1345) * tmp2 * u[c, k, j, i, 1];  
                        njac[i+1, 2, 4] = (c3c4 - c1345) * tmp2 * u[c, k, j, i, 2];          
                        njac[i+1, 3, 4] = (c3c4 - c1345) * tmp2 * u[c, k, j, i, 3];          
                        njac[i+1, 4, 4] = (c1345) * tmp1;
                    }
                    
                    for(i = start[c, 0]; i <= isize - end[c, 0]; i++) 
                    {
                        tmp1 = dt * tx1;
                        tmp2 = dt * tx2;

                        lhsa[i, 0, 0] = -tmp2 * fjac[i, 0, 0] - tmp1 * njac[i, 0, 0] - tmp1 * dx1;
                        lhsa[i, 1, 0] = -tmp2 * fjac[i, 1, 0] - tmp1 * njac[i, 1, 0];
                        lhsa[i, 2, 0] = -tmp2 * fjac[i, 2, 0] - tmp1 * njac[i, 2, 0];
                        lhsa[i, 3, 0] = -tmp2 * fjac[i, 3, 0] - tmp1 * njac[i, 3, 0];
                        lhsa[i, 4, 0] = -tmp2 * fjac[i, 4, 0] - tmp1 * njac[i, 4, 0];

                        lhsa[i, 0, 1] = -tmp2 * fjac[i, 0, 1] - tmp1 * njac[i, 0, 1];
                        lhsa[i, 1, 1] = -tmp2 * fjac[i, 1, 1] - tmp1 * njac[i, 1, 1] - tmp1 * dx2;
                        lhsa[i, 2, 1] = -tmp2 * fjac[i, 2, 1] - tmp1 * njac[i, 2, 1];
                        lhsa[i, 3, 1] = -tmp2 * fjac[i, 3, 1] - tmp1 * njac[i, 3, 1];
                        lhsa[i, 4, 1] = -tmp2 * fjac[i, 4, 1] - tmp1 * njac[i, 4, 1];

                        lhsa[i, 0, 2] = -tmp2 * fjac[i, 0, 2] - tmp1 * njac[i, 0, 2];
                        lhsa[i, 1, 2] = -tmp2 * fjac[i, 1, 2] - tmp1 * njac[i, 1, 2];
                        lhsa[i, 2, 2] = -tmp2 * fjac[i, 2, 2] - tmp1 * njac[i, 2, 2] - tmp1 * dx3;
                        lhsa[i, 3, 2] = -tmp2 * fjac[i, 3, 2] - tmp1 * njac[i, 3, 2];
                        lhsa[i, 4, 2] = -tmp2 * fjac[i, 4, 2] - tmp1 * njac[i, 4, 2];

                        lhsa[i, 0, 3] = -tmp2 * fjac[i, 0, 3] - tmp1 * njac[i, 0, 3];
                        lhsa[i, 1, 3] = -tmp2 * fjac[i, 1, 3] - tmp1 * njac[i, 1, 3];
                        lhsa[i, 2, 3] = -tmp2 * fjac[i, 2, 3] - tmp1 * njac[i, 2, 3];
                        lhsa[i, 3, 3] = -tmp2 * fjac[i, 3, 3] - tmp1 * njac[i, 3, 3] - tmp1 * dx4;
                        lhsa[i, 4, 3] = -tmp2 * fjac[i, 4, 3] - tmp1 * njac[i, 4, 3];

                        lhsa[i, 0, 4] = -tmp2 * fjac[i, 0, 4] - tmp1 * njac[i, 0, 4];
                        lhsa[i, 1, 4] = -tmp2 * fjac[i, 1, 4] - tmp1 * njac[i, 1, 4];
                        lhsa[i, 2, 4] = -tmp2 * fjac[i, 2, 4] - tmp1 * njac[i, 2, 4];
                        lhsa[i, 3, 4] = -tmp2 * fjac[i, 3, 4] - tmp1 * njac[i, 3, 4];
                        lhsa[i, 4, 4] = -tmp2 * fjac[i, 4, 4] - tmp1 * njac[i, 4, 4] - tmp1 * dx5;

                        lhsb[i, 0, 0] = 1.0d + tmp1 * 2.0d * njac[i+1, 0, 0] + tmp1 * 2.0d * dx1;
                        lhsb[i, 1, 0] = tmp1 * 2.0d * njac[i+1, 1, 0];
                        lhsb[i, 2, 0] = tmp1 * 2.0d * njac[i+1, 2, 0];
                        lhsb[i, 3, 0] = tmp1 * 2.0d * njac[i+1, 3, 0];
                        lhsb[i, 4, 0] = tmp1 * 2.0d * njac[i+1, 4, 0];

                        lhsb[i, 0, 1] = tmp1 * 2.0d * njac[i+1, 0, 1];
                        lhsb[i, 1, 1] = 1.0d + tmp1 * 2.0d * njac[i+1, 1, 1] + tmp1 * 2.0d * dx2;
                        lhsb[i, 2, 1] = tmp1 * 2.0d * njac[i+1, 2, 1];
                        lhsb[i, 3, 1] = tmp1 * 2.0d * njac[i+1, 3, 1];
                        lhsb[i, 4, 1] = tmp1 * 2.0d * njac[i+1, 4, 1];

                        lhsb[i, 0, 2] = tmp1 * 2.0d * njac[i+1, 0, 2];
                        lhsb[i, 1, 2] = tmp1 * 2.0d * njac[i+1, 1, 2];
                        lhsb[i, 2, 2] = 1.0d + tmp1 * 2.0d * njac[i+1, 2, 2] + tmp1 * 2.0d * dx3;
                        lhsb[i, 3, 2] = tmp1 * 2.0d * njac[i+1, 3, 2];
                        lhsb[i, 4, 2] = tmp1 * 2.0d * njac[i+1, 4, 2];

                        lhsb[i, 0, 3] = tmp1 * 2.0d * njac[i+1, 0, 3];
                        lhsb[i, 1, 3] = tmp1 * 2.0d * njac[i+1, 1, 3];
                        lhsb[i, 2, 3] = tmp1 * 2.0d * njac[i+1, 2, 3];
                        lhsb[i, 3, 3] = 1.0d + tmp1 * 2.0d * njac[i+1, 3, 3] + tmp1 * 2.0d * dx4;
                        lhsb[i, 4, 3] = tmp1 * 2.0d * njac[i+1, 4, 3];

                        lhsb[i, 0, 4] = tmp1 * 2.0d * njac[i+1, 0, 4];
                        lhsb[i, 1, 4] = tmp1 * 2.0d * njac[i+1, 1, 4];
                        lhsb[i, 2, 4] = tmp1 * 2.0d * njac[i+1, 2, 4];
                        lhsb[i, 3, 4] = tmp1 * 2.0d * njac[i+1, 3, 4];
                        lhsb[i, 4, 4] = 1.0d + tmp1 * 2.0d * njac[i+1, 4, 4] + tmp1 * 2.0d * dx5;

                        lhsc[c, k, j, i, 0, 0] = tmp2 * fjac[i+2, 0, 0] - tmp1 * njac[i+2, 0, 0] - tmp1 * dx1;
                        lhsc[c, k, j, i, 1, 0] = tmp2 * fjac[i+2, 1, 0] - tmp1 * njac[i+2, 1, 0];
                        lhsc[c, k, j, i, 2, 0] = tmp2 * fjac[i+2, 2, 0] - tmp1 * njac[i+2, 2, 0];
                        lhsc[c, k, j, i, 3, 0] = tmp2 * fjac[i+2, 3, 0] - tmp1 * njac[i+2, 3, 0];
                        lhsc[c, k, j, i, 4, 0] = tmp2 * fjac[i+2, 4, 0] - tmp1 * njac[i+2, 4, 0];

                        lhsc[c, k, j, i, 0, 1] = tmp2 * fjac[i+2, 0, 1] - tmp1 * njac[i+2, 0, 1];
                        lhsc[c, k, j, i, 1, 1] = tmp2 * fjac[i+2, 1, 1] - tmp1 * njac[i+2, 1, 1] - tmp1 * dx2;
                        lhsc[c, k, j, i, 2, 1] = tmp2 * fjac[i+2, 2, 1] - tmp1 * njac[i+2, 2, 1];
                        lhsc[c, k, j, i, 3, 1] = tmp2 * fjac[i+2, 3, 1] - tmp1 * njac[i+2, 3, 1];
                        lhsc[c, k, j, i, 4, 1] = tmp2 * fjac[i+2, 4, 1] - tmp1 * njac[i+2, 4, 1];

                        lhsc[c, k, j, i, 0, 2] = tmp2 * fjac[i+2, 0, 2] - tmp1 * njac[i+2, 0, 2];
                        lhsc[c, k, j, i, 1, 2] = tmp2 * fjac[i+2, 1, 2] - tmp1 * njac[i+2, 1, 2];
                        lhsc[c, k, j, i, 2, 2] = tmp2 * fjac[i+2, 2, 2] - tmp1 * njac[i+2, 2, 2] - tmp1 * dx3;
                        lhsc[c, k, j, i, 3, 2] = tmp2 * fjac[i+2, 3, 2] - tmp1 * njac[i+2, 3, 2];
                        lhsc[c, k, j, i, 4, 2] = tmp2 * fjac[i+2, 4, 2] - tmp1 * njac[i+2, 4, 2];

                        lhsc[c, k, j, i, 0, 3] = tmp2 * fjac[i+2, 0, 3] - tmp1 * njac[i+2, 0, 3];
                        lhsc[c, k, j, i, 1, 3] = tmp2 * fjac[i+2, 1, 3] - tmp1 * njac[i+2, 1, 3];
                        lhsc[c, k, j, i, 2, 3] = tmp2 * fjac[i+2, 2, 3] - tmp1 * njac[i+2, 2, 3];
                        lhsc[c, k, j, i, 3, 3] = tmp2 * fjac[i+2, 3, 3] - tmp1 * njac[i+2, 3, 3] - tmp1 * dx4;
                        lhsc[c, k, j, i, 4, 3] = tmp2 * fjac[i+2, 4, 3] - tmp1 * njac[i+2, 4, 3];

                        lhsc[c, k, j, i, 0, 4] = tmp2 * fjac[i+2, 0, 4] - tmp1 * njac[i+2, 0, 4];
                        lhsc[c, k, j, i, 1, 4] = tmp2 * fjac[i+2, 1, 4] - tmp1 * njac[i+2, 1, 4];
                        lhsc[c, k, j, i, 2, 4] = tmp2 * fjac[i+2, 2, 4] - tmp1 * njac[i+2, 2, 4];
                        lhsc[c, k, j, i, 3, 4] = tmp2 * fjac[i+2, 3, 4] - tmp1 * njac[i+2, 3, 4];
                        lhsc[c, k, j, i, 4, 4] = tmp2 * fjac[i+2, 4, 4] - tmp1 * njac[i+2, 4, 4] - tmp1 * dx5;
                    }
                    
                    if(first == 1) 
                    {
                        Binvcrhs.setParameters(lhsb, lhsc, rhs, istart, c, k, j, istart, c, k, j, istart);
                        Binvcrhs.go();
                    }
                    
                    for(i = istart + first; i <= isize - last; i++) 
                    {
                        Matvec_sub.setParameters(lhsa, rhs, rhs, i, c, k, j, i-1, c, k, j, i);
                        Matvec_sub.go();
                        Matmul_sub.setParameters(lhsa, lhsc, lhsb, i, c, k, j, i-1, i);
                        Matmul_sub.go();
                        Binvcrhs.setParameters(lhsb, lhsc, rhs, i, c, k, j, i, c, k, j, i);
                        Binvcrhs.go();
                    }
                    
                    if(last == 1) 
                    {
                        Matvec_sub.setParameters(lhsa, rhs, rhs, isize, c, k, j, isize-1, c, k, j, isize);
                        Matvec_sub.go();
                        Matmul_sub.setParameters(lhsa, lhsc, lhsb, isize, c, k, j, isize-1, isize);
                        Matmul_sub.go();
                        Binvrhs.setParameters(lhsb, rhs, isize, c, k, j, isize);
                        Binvrhs.go();
                    }
                }
            }
            
            return 0;
		}
	}
}
