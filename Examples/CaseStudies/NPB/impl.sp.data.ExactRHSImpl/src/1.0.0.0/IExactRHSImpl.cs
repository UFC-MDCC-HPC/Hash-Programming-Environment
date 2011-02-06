using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.data.ExactRHS;
using common.data.ProblemDefinition;

namespace impl.sp.data.ExactRHSImpl { 

	public class IExactRHSImpl<I, C> : BaseIExactRHSImpl<I, C>, IExactRHS<I, C>
		where I:IInstance_SP<C>
		where C:IClass
	{
	
		public IExactRHSImpl() 
		{ 
		
		} 
		
		private int[,] cell_size, cell_low, start, end;
		
		private int ncells;
		
		private double[,,,,] forcing;
		
		private double[,] ue, buf;

	    private double[] cuf, q;
		
        private double dnzm1, dnym1, dnxm1, c1, c2, dssp, 
		               tx2, dx1tx1, xxcon1, dx2tx1, xxcon2, dx3tx1, dx4tx1, xxcon3, xxcon4, xxcon5, dx5tx1, 
					   ty2, dy1ty1, yycon2, dy2ty1, yycon1, dy3ty1, dy4ty1, yycon3, yycon4, yycon5, dy5ty1,
					   tz2, dz1tz1, zzcon2, dz2tz1, zzcon1, dz3tz1, dz4tz1, zzcon3, zzcon4, zzcon5, dz5tz1;
		
		public void initialize()
		{
			int MAX_CELL_DIM = Problem.MAX_CELL_DIM;
			
			ue = new double[MAX_CELL_DIM + 4, 5];  
            buf = new double[MAX_CELL_DIM + 4, 5]; 
			cuf = new double[MAX_CELL_DIM + 4];    
			q = new double[MAX_CELL_DIM + 4];      

			
			ncells = Problem.NCells;
			forcing = Problem.Field_forcing;
			
			cell_size = Blocks.cell_size;
			cell_low = Blocks.cell_low;
			start = Blocks.cell_start;
			end = Blocks.cell_end;
			
			dnzm1 = Constants.dnzm1;
			dnym1 = Constants.dnym1;
			dnxm1 = Constants.dnxm1;
			c1 = Constants.c1;
			c2 = Constants.c2;
			dssp = Constants.dssp;
			tx2 = Constants.tx2;
			dx1tx1 = Constants.dx1tx1;
			dx2tx1 = Constants.dx2tx1;
		    dx3tx1 = Constants.dx3tx1;
			dx5tx1 = Constants.dx5tx1;
			dx4tx1 = Constants.dx4tx1;
			xxcon1 = Constants.xxcon1;
			xxcon2 = Constants.xxcon2;
			xxcon3 = Constants.xxcon3;
			xxcon4 = Constants.xxcon4;
			xxcon5 = Constants.xxcon5;
			ty2 = Constants.ty2; 
		    dy1ty1 = Constants.dy1ty1;
			yycon2 = Constants.yycon2;
			dy2ty1 = Constants.dy2ty1;
			yycon1 = Constants.yycon1;
			dy3ty1 = Constants.dy3ty1;
		    dy4ty1 = Constants.dy4ty1;
			yycon3 = Constants.yycon3;
			yycon4 = Constants.yycon4;
			yycon5 = Constants.yycon5;
			dy5ty1 = Constants.dy5ty1;
			tz2 = Constants.tx2;
			dz1tz1 = Constants.dz1tz1;
			dz2tz1 = Constants.dz2tz1;
		    dz3tz1 = Constants.dz3tz1;
			dz5tz1 = Constants.dz5tz1;
			dz4tz1 = Constants.dz4tz1;
			zzcon1 = Constants.zzcon1;
			zzcon2 = Constants.zzcon2;
			zzcon3 = Constants.zzcon3;
			zzcon4 = Constants.zzcon4;
			zzcon5 = Constants.zzcon5;
			
		}
				
		public override void compute() { 
		
		    double[] dtemp = new double[5];
		    double xi, eta, zeta, dtpp;
		    int c, m, i, j, k, ip1, im1, jp1, jm1, km1, kp1, ksize, jsize, isize;
		
		    // int ii, jj, kk;  /* +2 offset required by C# arrays for Fortran with -2 lower limit */
		
		
		    for (c = 0; c < ncells; c++)
		    {
		        ksize = cell_size[c, 2] + 2;
		        jsize = cell_size[c, 1] + 2;
		        isize = cell_size[c, 0] + 2;
		
		        //---------------------------------------------------------------------
		        //      initialize                                  
		        //---------------------------------------------------------------------
		        for (m = 0; m < 5; m++)
		        {
		            for (k = 2; k < ksize; k++)
		            {
		                for (j = 2; j < jsize; j++)
		                {
		                    for (i = 2; i < isize; i++)
		                    {
		                        forcing[c, k, j, i, m] = 0.0d;
		                    }
		                }
		            }
		        }
		
		        //---------------------------------------------------------------------
		        //      xi-direction flux differences                      
		        //---------------------------------------------------------------------
		        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		        {
		            zeta = (k - 2 + cell_low[c, 2]) * dnzm1;
		            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		            {
		                eta = (j - 2 + cell_low[c, 1]) * dnym1;
		                for (i = 2 * start[c, 0] - 4; i <= isize + 1 - 2 * end[c, 0]; i++)
		                {
		                    xi = (i - 2 + cell_low[c, 0]) * dnxm1;
		
		                    Exact_solution.setParameters(xi, eta, zeta, dtemp, 0);
							Exact_solution.compute();
		                    for (m = 0; m < 5; m++)
		                    {
		                        ue[i, m] = dtemp[m]; // OK ue[i,m]
		                    }
		
		                    dtpp = 1.0d / dtemp[0];
		
		                    for (m = 1; m < 5; m++)
		                    {
		                        buf[i, m] = dtpp * dtemp[m]; // OK buf[i,m]
		                    }
		
		                    cuf[i] = buf[i, 1] * buf[i, 1];
		                    buf[i, 0] = cuf[i] + buf[i, 2] * buf[i, 2] +
		                                         buf[i, 3] * buf[i, 3];
		                    q[i] = 0.5d * (buf[i, 1] * ue[i, 1] + buf[i, 2] * ue[i, 2] +
		                                                         buf[i, 3] * ue[i, 3]);
		                    // OK cuf[i], buf[i,0], q[i]
		                }
		
		                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
		                {
		                    im1 = i - 1;
		                    ip1 = i + 1;
		
		                    double b = forcing[c, k, j, i, 0];
		
		                    forcing[c, k, j, i, 0] = forcing[c, k, j, i, 0] -
		                                     tx2 * (ue[ip1, 1] - ue[im1, 1]) +
		                                     dx1tx1 * (ue[ip1, 0] - 2.0d * ue[i, 0] + ue[im1, 0]);
		
		                    forcing[c, k, j, i, 1] = forcing[c, k, j, i, 1] - tx2 * (
		                                    (ue[ip1, 1] * buf[ip1, 1] + c2 * (ue[ip1, 4] - q[ip1])) -
		                                    (ue[im1, 1] * buf[im1, 1] + c2 * (ue[im1, 4] - q[im1]))) +
		                                     xxcon1 * (buf[ip1, 1] - 2.0d * buf[i, 1] + buf[im1, 1]) +
		                                     dx2tx1 * (ue[ip1, 1] - 2.0d * ue[i, 1] + ue[im1, 1]);
		
		                    forcing[c, k, j, i, 2] = forcing[c, k, j, i, 2] - tx2 * (
		                                     ue[ip1, 2] * buf[ip1, 1] - ue[im1, 2] * buf[im1, 1]) +
		                                     xxcon2 * (buf[ip1, 2] - 2.0d * buf[i, 2] + buf[im1, 2]) +
		                                     dx3tx1 * (ue[ip1, 2] - 2.0d * ue[i, 2] + ue[im1, 2]);
		
		
		                    forcing[c, k, j, i, 3] = forcing[c, k, j, i, 3] - tx2 * (
		                                     ue[ip1, 3] * buf[ip1, 1] - ue[im1, 3] * buf[im1, 1]) +
		                                     xxcon2 * (buf[ip1, 3] - 2.0d * buf[i, 3] + buf[im1, 3]) +
		                                     dx4tx1 * (ue[ip1, 3] - 2.0d * ue[i, 3] + ue[im1, 3]);
		
		                    forcing[c, k, j, i, 4] = forcing[c, k, j, i, 4] - tx2 * (
		                                     buf[ip1, 1] * (c1 * ue[ip1, 4] - c2 * q[ip1]) -
		                                     buf[im1, 1] * (c1 * ue[im1, 4] - c2 * q[im1])) +
		                                     0.5d * xxcon3 * (buf[ip1, 0] - 2.0d * buf[i, 0] +
		                                                   buf[im1, 0]) +
		                                     xxcon4 * (cuf[ip1] - 2.0d * cuf[i] + cuf[im1]) +
		                                     xxcon5 * (buf[ip1, 4] - 2.0d * buf[i, 4] + buf[im1, 4]) +
		                                     dx5tx1 * (ue[ip1, 4] - 2.0d * ue[i, 4] + ue[im1, 4]);
		                }
		
		                //---------------------------------------------------------------------
		                //            Fourth-order dissipation                         
		                //---------------------------------------------------------------------
		                if (start[c, 0] > 2)
		                {
		                    
		                    for (m = 0; m < 5; m++)
		                    {
		                        i = 3;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                            (5.0d * ue[i, m] - 4.0d * ue[i + 1, m] + ue[i + 2, m]);
		                        i = 4;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                           (-4.0d * ue[i - 1, m] + 6.0d * ue[i, m] -
		                                             4.0d * ue[i + 1, m] + ue[i + 2, m]);
		                    }
		                }
		
		                for (m = 0; m < 5; m++)
		                {
		                    for (i = 3 * start[c, 0] - 4; i < isize - 3 * end[c, 0]; i++)
		                    {
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                         (ue[i - 2, m] - 4.0d * ue[i - 1, m] +
		                                          6.0d * ue[i, m] - 4.0d * ue[i + 1, m] + ue[i + 2, m]);
		                    }
		                }
		
		                if (end[c, 0] > 0)
		                {
		                    for (m = 0; m < 5; m++)
		                    {
		                        i = isize - 3;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                           (ue[i - 2, m] - 4.0d * ue[i - 1, m] +
		                                            6.0d * ue[i, m] - 4.0d * ue[i + 1, m]);
		                        i = isize - 2;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                           (ue[i - 2, m] - 4.0d * ue[i - 1, m] + 5.0d * ue[i, m]);
		                    }
		                }
		            }
		        } // end k
		
		        //---------------------------------------------------------------------
		        //  eta-direction flux differences             
		        //---------------------------------------------------------------------
		        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		        {
		            zeta = (k - 2 + cell_low[c, 2]) * dnzm1;
		            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
		            {
		                xi = (i - 2 + cell_low[c, 0]) * dnxm1;
		
		                for (j = 2 * start[c, 1] - 4; j <= jsize + 1 - 2 * end[c, 1]; j++)
		                {
		                    eta = (j - 2 + cell_low[c, 1]) * dnym1;
		
		                    Exact_solution.setParameters(xi, eta, zeta, dtemp, 0);
							Exact_solution.compute();
		                    for (m = 0; m < 5; m++)
		                    {
		                        ue[j, m] = dtemp[m];
		                    }
		                    dtpp = 1.0d / dtemp[0];
		
		                    for (m = 1; m < 5; m++)
		                    {
		                        buf[j, m] = dtpp * dtemp[m];
		                    }
		
		                    cuf[j] = buf[j, 2] * buf[j, 2];
		                    buf[j, 0] = cuf[j] + buf[j, 1] * buf[j, 1] +
		                                         buf[j, 3] * buf[j, 3];
		                    q[j] = 0.5d * (buf[j, 1] * ue[j, 1] +
		                                  buf[j, 2] * ue[j, 2] +
		                                  buf[j, 3] * ue[j, 3]);
		                }
		
		                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                {
		                    jm1 = j - 1;
		                    jp1 = j + 1;
		
		                    forcing[c, k, j, i, 0] = forcing[c, k, j, i, 0] -
		                          ty2 * (ue[jp1, 2] - ue[jm1, 2]) +
		                          dy1ty1 * (ue[jp1, 0] - 2.0d * ue[j, 0] + ue[jm1, 0]);
		
		                    forcing[c, k, j, i, 1] = forcing[c, k, j, i, 1] - ty2 * (
		                          ue[jp1, 1] * buf[jp1, 2] - ue[jm1, 1] * buf[jm1, 2]) +
		                          yycon2 * (buf[jp1, 1] - 2.0d * buf[j, 1] + buf[jm1, 1]) +
		                          dy2ty1 * (ue[jp1, 1] - 2.0d * ue[j, 1] + ue[jm1, 1]);
		
		                    forcing[c, k, j, i, 2] = forcing[c, k, j, i, 2] - ty2 * (
		                          (ue[jp1, 2] * buf[jp1, 2] + c2 * (ue[jp1, 4] - q[jp1])) -
		                          (ue[jm1, 2] * buf[jm1, 2] + c2 * (ue[jm1, 4] - q[jm1]))) +
		                          yycon1 * (buf[jp1, 2] - 2.0d * buf[j, 2] + buf[jm1, 2]) +
		                          dy3ty1 * (ue[jp1, 2] - 2.0d * ue[j, 2] + ue[jm1, 2]);
		
		                    forcing[c, k, j, i, 3] = forcing[c, k, j, i, 3] - ty2 * (
		                          ue[jp1, 3] * buf[jp1, 2] - ue[jm1, 3] * buf[jm1, 2]) +
		                          yycon2 * (buf[jp1, 3] - 2.0d * buf[j, 3] + buf[jm1, 3]) +
		                          dy4ty1 * (ue[jp1, 3] - 2.0d * ue[j, 3] + ue[jm1, 3]);
		
		                    forcing[c, k, j, i, 4] = forcing[c, k, j, i, 4] - ty2 * (
		                          buf[jp1, 2] * (c1 * ue[jp1, 4] - c2 * q[jp1]) -
		                          buf[jm1, 2] * (c1 * ue[jm1, 4] - c2 * q[jm1])) +
		                          0.5d * yycon3 * (buf[jp1, 0] - 2.0d * buf[j, 0] +
		                                        buf[jm1, 0]) +
		                          yycon4 * (cuf[jp1] - 2.0d * cuf[j] + cuf[jm1]) +
		                          yycon5 * (buf[jp1, 4] - 2.0d * buf[j, 4] + buf[jm1, 4]) +
		                          dy5ty1 * (ue[jp1, 4] - 2.0d * ue[j, 4] + ue[jm1, 4]);
		                }
		
		                //---------------------------------------------------------------------
		                //            Fourth-order dissipation                      
		                //---------------------------------------------------------------------
		                if (start[c, 1] > 2)
		                {
		                    for (m = 0; m < 5; m++)
		                    {
		                        j = 3;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                  (5.0d * ue[j, m] - 4.0d * ue[j + 1, m] + ue[j + 2, m]);
		                        j = 4;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                 (-4.0d * ue[j - 1, m] + 6.0d * ue[j, m] -
		                                   4.0d * ue[j + 1, m] + ue[j + 2, m]);
		                    }
		                }
		
		                for (m = 0; m < 5; m++)
		                {
		                    for (j = 3 * start[c, 1] - 4; j < jsize - 3 * end[c, 1]; j++)
		                    {
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                              (ue[j - 2, m] - 4.0d * ue[j - 1, m] +
		                               6.0d * ue[j, m] - 4.0d * ue[j + 1, m] + ue[j + 2, m]);
		                    }
		                }
		
		                if (end[c, 1] > 0)
		                {
		                    for (m = 0; m < 5; m++)
		                    {
		                        j = jsize - 3;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                 (ue[j - 2, m] - 4.0d * ue[j - 1, m] +
		                                  6.0d * ue[j, m] - 4.0d * ue[j + 1, m]);
		                        j = jsize - 2;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                 (ue[j - 2, m] - 4.0d * ue[j - 1, m] + 5.0d * ue[j, m]);
		
		                    }
		                }
		
		            }
		        }
		
		        //---------------------------------------------------------------------
		        //      zeta-direction flux differences                      
		        //---------------------------------------------------------------------
		        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		        {
		            eta = (j - 2 + cell_low[c, 1]) * dnym1;
		            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
		            {
		                xi = (i - 2 + cell_low[c, 0]) * dnxm1;
		
		                for (k = 2 * start[c, 2] - 4; k <= ksize + 1 - 2 * end[c, 2]; k++)
		                {
		                    zeta = (k - 2 + cell_low[c, 2]) * dnzm1;
		
							Exact_solution.setParameters(xi, eta, zeta, dtemp, 0);
							Exact_solution.compute();
							
		                    for (m = 0; m <= 4; m++)
		                    {
		                        ue[k, m] = dtemp[m];
		                    }
		
		                    dtpp = 1.0d / dtemp[0];
		
		                    for (m = 1; m < 5; m++)
		                    {
		                        buf[k, m] = dtpp * dtemp[m];
		                    }
		
		                    cuf[k] = buf[k, 3] * buf[k, 3];
		                    buf[k, 0] = cuf[k] + buf[k, 1] * buf[k, 1] +
		                               buf[k, 2] * buf[k, 2];
		                    q[k] = 0.5d * (buf[k, 1] * ue[k, 1] + buf[k, 2] * ue[k, 2] +
		                                  buf[k, 3] * ue[k, 3]);
		                }
		
		                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		                {
		                    km1 = k - 1;
		                    kp1 = k + 1;
		
		                    forcing[c, k, j, i, 0] = forcing[c, k, j, i, 0] -
		                           tz2 * (ue[kp1, 3] - ue[km1, 3]) +
		                           dz1tz1 * (ue[kp1, 0] - 2.0d * ue[k, 0] + ue[km1, 0]);
		
		                    forcing[c, k, j, i, 1] = forcing[c, k, j, i, 1] - tz2 * (
		                           ue[kp1, 1] * buf[kp1, 3] - ue[km1, 1] * buf[km1, 3]) +
		                           zzcon2 * (buf[kp1, 1] - 2.0d * buf[k, 1] + buf[km1, 1]) +
		                           dz2tz1 * (ue[kp1, 1] - 2.0d * ue[k, 1] + ue[km1, 1]);
		
		                    forcing[c, k, j, i, 2] = forcing[c, k, j, i, 2] - tz2 * (
		                           ue[kp1, 2] * buf[kp1, 3] - ue[km1, 2] * buf[km1, 3]) +
		                           zzcon2 * (buf[kp1, 2] - 2.0d * buf[k, 2] + buf[km1, 2]) +
		                           dz3tz1 * (ue[kp1, 2] - 2.0d * ue[k, 2] + ue[km1, 2]);
		
		                    forcing[c, k, j, i, 3] = forcing[c, k, j, i, 3] - tz2 * (
		                          (ue[kp1, 3] * buf[kp1, 3] + c2 * (ue[kp1, 4] - q[kp1])) -
		                          (ue[km1, 3] * buf[km1, 3] + c2 * (ue[km1, 4] - q[km1]))) +
		                          zzcon1 * (buf[kp1, 3] - 2.0d * buf[k, 3] + buf[km1, 3]) +
		                          dz4tz1 * (ue[kp1, 3] - 2.0d * ue[k, 3] + ue[km1, 3]);
		
		                    forcing[c, k, j, i, 4] = forcing[c, k, j, i, 4] - tz2 * (
		                           buf[kp1, 3] * (c1 * ue[kp1, 4] - c2 * q[kp1]) -
		                           buf[km1, 3] * (c1 * ue[km1, 4] - c2 * q[km1])) +
		                           0.5d * zzcon3 * (buf[kp1, 0] - 2.0d * buf[k, 0]
		                                        + buf[km1, 0]) +
		                           zzcon4 * (cuf[kp1] - 2.0d * cuf[k] + cuf[km1]) +
		                           zzcon5 * (buf[kp1, 4] - 2.0d * buf[k, 4] + buf[km1, 4]) +
		                           dz5tz1 * (ue[kp1, 4] - 2.0d * ue[k, 4] + ue[km1, 4]);
		                }
		
		                //---------------------------------------------------------------------
		                //            Fourth-order dissipation
		                //---------------------------------------------------------------------
		                if (start[c, 2] > 2)
		                {
		                    for (m = 0; m < 5; m++)
		                    {
		                        k = 3;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                  (5.0d * ue[k, m] - 4.0d * ue[k + 1, m] + ue[k + 2, m]);
		                        k = 4;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                 (-4.0d * ue[k - 1, m] + 6.0d * ue[k, m] -
		                                   4.0d * ue[k + 1, m] + ue[k + 2, m]);
		                    }
		                }
		
		                for (m = 0; m < 5; m++)
		                {
		                    for (k = 3 * start[c, 2] - 4; k < ksize - 3 * end[c, 2]; k++)
		                    {
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                              (ue[k - 2, m] - 4.0d * ue[k - 1, m] +
		                               6.0d * ue[k, m] - 4.0d * ue[k + 1, m] + ue[k + 2, m]);
		                    }
		                }
		
		                if (end[c, 2] > 0)
		                {
		                    for (m = 0; m < 5; m++)
		                    {
		                        k = ksize - 3;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                                 (ue[k - 2, m] - 4.0d * ue[k - 1, m] +
		                                  6.0d * ue[k, m] - 4.0d * ue[k + 1, m]);
		                        k = ksize - 2;
		                        forcing[c, k, j, i, m] = forcing[c, k, j, i, m] - dssp *
		                              (ue[k - 2, m] - 4.0d * ue[k - 1, m] + 5.0d * ue[k, m]);
		                    }
		                }
		            }
		        }
		
		        //---------------------------------------------------------------------
		        // now change the sign of the forcing function, 
		        //---------------------------------------------------------------------
		        for (m = 0; m < 5; m++)
		        {
		            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		            {
		                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                {
		                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
		                    {
		                        forcing[c, k, j, i, m] = -1.0d * forcing[c, k, j, i, m];
		                    }
		                }
		            }
		        }
		    } // cell loop
		} // end activate method 
		
	}

}