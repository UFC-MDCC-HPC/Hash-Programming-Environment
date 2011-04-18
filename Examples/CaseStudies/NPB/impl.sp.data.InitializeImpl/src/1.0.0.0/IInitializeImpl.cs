using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.data.Initialize;
using common.data.ProblemDefinition;

namespace impl.common.data.InitializeImpl { 

	public class IInitializeImpl<I, C> : BaseIInitializeImpl<I, C>, IInitialize<I, C>
		where I:IInstance<C>
		where C:IClass
	{
	
		public IInitializeImpl() 
		{ 
		} 
								
		public override int go() { 
			int c, i, j, k, m, ii, jj, kk, ix, iy, iz;
			double xi, eta, zeta, Pxi, Peta, Pzeta; 
	        double[] Pface = new double[5*3*2];
			double[] temp = new double[5];
	
			//---------------------------------------------------------------------
			//  Later (in compute_rhs) we compute 1/u for every element. A few of 
			//  the corner elements are not used, but it convenient (and faster) 
			//  to compute the whole thing with a simple loop. Make sure those 
			//  values are nonzero by initializing the whole thing here. 
			//---------------------------------------------------------------------
	        for (c = 0; c < ncells; c++)
	        {
	            for (k = 1; k <= IMAX + 2; k++)
	            {
	                for (j = 1; j <= IMAX + 2; j++)
	                {
	                    for (i = 1; i <= IMAX + 2; i++)
	                    {
	                        u[c, k, j, i, 0] = 1.0d;
	                        u[c, k, j, i, 1] = 0.0d;
	                        u[c, k, j, i, 2] = 0.0d;
	                        u[c, k, j, i, 3] = 0.0d;
	                        u[c, k, j, i, 4] = 1.0d;
	                    }
	                }
	            }
	        }
	
	
			//---------------------------------------------------------------------
			// first store the "interpolated" values everywhere on the grid    
			//---------------------------------------------------------------------
	        for (c = 0; c < maxcells; c++)
	        {
	            kk = 2;
	            for (k = cell_low[c,2]; k <= cell_high[c,2]; k++)
	            {
	                zeta = k * dnzm1;
	                jj = 2;
	                for (j = cell_low[c,1]; j <= cell_high[c,1]; j++)
	                {
	                    eta = j * dnym1;
	                    ii = 2;
	                    for (i = cell_low[c,0]; i <= cell_high[c,0]; i++)
	                    {
	                        xi = i * dnxm1;
	
	                        for (ix = 0; ix <= 1; ix++)
	                        {
	                            Exact_solution.setParameters(ix, eta, zeta, Pface, 0 + 0 * 5 + ix * 15);
							    Exact_solution.go();
	                        }
	                        for (iy = 0; iy <= 1; iy++)
	                        {
	                            Exact_solution.setParameters(xi, iy, zeta, Pface, 0 + 1 * 5 + iy * 15);
							    Exact_solution.go();
	                        }
	
	                        for (iz = 0; iz <= 1; iz++)
	                        {
	                            Exact_solution.setParameters(xi, eta, iz, Pface, 0 + 2 * 5 + iz * 15);
							    Exact_solution.go();
	                        }
	
	                        for (m = 0; m < 5; m++)
	                        {
	                            Pxi = xi * Pface[m + 0 * 5 + 1 * 15] +
	                                (1.0d - xi) * Pface[m + 0 * 5 + 0 * 15];
	                            Peta = eta * Pface[m + 1 * 5 + 1 * 15] +
	                                    (1.0d - eta) * Pface[m + 1 * 5 + 0 * 15];
	                            Pzeta = zeta * Pface[m + 2 * 5 + 1 * 15] +
	                                    (1.0d - zeta) * Pface[m + 2 * 5 + 0 * 15];
	
	                            u[c, kk, jj, ii, m] =
	                              Pxi + Peta + Pzeta -
	                                      Pxi * Peta - Pxi * Pzeta - Peta * Pzeta +
	                                      Pxi * Peta * Pzeta;
						        
	                        }
	                        ii++;
	                    }
	                    jj++;
	                }
	                kk++;
	            }
	        }
	        
	
			//---------------------------------------------------------------------
			// now store the exact values on the boundaries        
			//---------------------------------------------------------------------
	
			//---------------------------------------------------------------------
			// west face                                                  
			//---------------------------------------------------------------------
	
	        c = slice[0, 0];
	        ii = 2;
			xi = 0.0d;
			kk = 2;
			for (k = cell_low[c,2]; k <= cell_high[c,2]; k++)
			{
				zeta = k * dnzm1;
	            jj = 2;
				for (j = cell_low[c,1]; j <= cell_high[c,1]; j++)
				{
					eta = j * dnym1;
					Exact_solution.setParameters(xi, eta, zeta, temp, 0);
					Exact_solution.go();
				    for (m = 0; m < 5 ; m++)
					{
	                    u[c, kk, jj, ii, m] = temp[m];
	                }
	                jj++;
				}
	            kk++;
			}
	
			//---------------------------------------------------------------------
			// east face                                                      
			//---------------------------------------------------------------------
	
	        c = slice[ncells - 1, 0];
	        ii = 2 + cell_size[c, 0] - 1;
			xi = 1.0d;
	        kk = 2;
			for (k = cell_low[c,2]; k <= cell_high[c,2]; k++)
			{
				zeta = k * dnzm1;
	            jj = 2;
				for (j = cell_low[c,1]; j <= cell_high[c,1]; j++)
				{
	                eta = j * dnym1;
					Exact_solution.setParameters(xi, eta, zeta, temp, 0);
				    Exact_solution.go();
					for (m = 0; m <= 4; m++)
					{
	                    u[c, kk, jj, ii, m] = temp[m];
						
	                }
	                jj++;
				}
	            kk++;
			}
	
			//---------------------------------------------------------------------
			// south face                                                 
			//---------------------------------------------------------------------
	
	        c = slice[0,1];
	        jj = 2;
			eta = 0.0d;
			kk = 2;
			for (k = cell_low[c,2]; k <= cell_high[c,2]; k++)
			{
				zeta = k * dnzm1;
	            ii = 2;
				for (i = cell_low[c,0]; i <= cell_high[c,0]; i++)
				{
					xi = i * dnxm1;
					Exact_solution.setParameters(xi, eta, zeta, temp, 0);
				    Exact_solution.go();
					for (m = 0; m <= 4; m++)
					{
	                    u[c, kk, jj, ii, m] = temp[m];
						
	                }
	                ii++;
				}
	            kk++;
			}
	
			//---------------------------------------------------------------------
			// north face                                    
			//---------------------------------------------------------------------
	
	        c = slice[ncells - 1, 1];
	        jj = 2 + cell_size[c, 1] - 1;
			eta = 1.0d;
	        kk = 2;
			for (k = cell_low[c,2]; k <= cell_high[c,2]; k++)
			{
				zeta = k * dnzm1;
	            ii = 2;
	            for (i = cell_low[c,0]; i <= cell_high[c,0]; i++)
	            {
	                xi = i * dnxm1;
	                Exact_solution.setParameters(xi, eta, zeta, temp, 0);
				    Exact_solution.go();
	                for (m = 0; m <= 4; m++)
	                {
	                    u[c, kk, jj, ii, m] = temp[m];
						
	                }
	                ii++;
	            }
	            kk++;
			}
	
			//---------------------------------------------------------------------
			// bottom face                                       
			//---------------------------------------------------------------------
	
	        c = slice[0, 2];
	        kk = 2;
			zeta = 0.0d;
			jj = 2;
	        for (j = cell_low[c, 1]; j <= cell_high[c, 1]; j++)
	        {
	            eta = j * dnym1;
	            ii = 2;
	            for (i = cell_low[c, 0]; i <= cell_high[c, 0]; i++)
	            {
	                xi = i * dnxm1;
	                Exact_solution.setParameters(xi, eta, zeta, temp, 0);
				    Exact_solution.go();
	                for (m = 0; m <= 4; m++)
	                {
	                    u[c, kk, jj, ii, m] = temp[m];
						
	                }
	                ii++;
	            }
	            jj++;
	        }
	
			//---------------------------------------------------------------------
			// top face     
			//---------------------------------------------------------------------
	
	        c = slice[ncells - 1, 2];
	        kk = 2 + cell_size[c, 2] - 1;
			zeta = 1.0d;
	        jj = 2;
			for (j = cell_low[c,1]; j <= cell_high[c,1]; j++)
			{
	            eta = j * dnym1;
	            ii = 2;
				for (i = cell_low[c,0]; i <= cell_high[c,0]; i++)
				{
	                xi = i * dnxm1;
				    Exact_solution.setParameters(xi, eta, zeta, temp, 0);
				    Exact_solution.go();
					for (m = 0; m <= 4; m++)
					{
						u[c, kk, jj, ii, m] = temp[m];
						
	                }
	                ii++;
				}
	            jj++;
			}
						
			return 0;
		} // end activate method 
		
	}

}
