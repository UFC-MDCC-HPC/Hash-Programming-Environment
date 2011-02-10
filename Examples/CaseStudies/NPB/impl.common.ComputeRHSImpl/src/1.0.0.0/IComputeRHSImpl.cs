using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.ComputeRHS;
using common.data.ProblemDefinition;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace impl.common.ComputeRHSImpl { 

public class IComputeRHSImpl<I,C> : BaseIComputeRHSImpl<I,C>, IComputeRHS<I,C>
		where I:IInstance<C>
		where C:IClass
{

	public IComputeRHSImpl() 
	{
		initialize();
	}
		
	private int ncells;

	private int[,] start;
	private int[,] end;
	private int[,] cell_size;
			
	private double[,,,,] u, rhs, forcing, us, vs, ws, rho_i, square, qs, speed, ainv;
			
		
    private double tx2, ty2, tz2, dssp, dt, xxcon2, xxcon3, xxcon4, xxcon5, dx1tx1, dx2tx1, dx3tx1,
		  dx4tx1, dx5tx1, yycon2, yycon3, yycon4, yycon5, dy1ty1, dy2ty1, dy3ty1, dy4ty1, dy5ty1,
		  zzcon2, zzcon3, zzcon4, zzcon5, dz1tz1, dz2tz1, dz3tz1, dz4tz1, dz5tz1, c1, c2, c1c2, con43;
		

	// this method must be called before compute.	
	public void initialize() 
	{				
		ncells = Problem.NCells;
				
		u = Problem.Field_u;
		rhs = Problem.Field_rhs;
		forcing = Problem.Field_forcing;
		us = Problem.Field_us;
		vs = Problem.Field_vs;
		ws = Problem.Field_ws; 
		rho_i = Problem.Field_rho;
		square = Problem.Field_square;
		qs = Problem.Field_qs;
		speed = Problem.Field_speed;
		ainv = Problem.Field_ainv;
				
		start = Blocks.cell_start;
		end = Blocks.cell_end;
		cell_size = Blocks.cell_size;
			
		tx2 = Constants.tx2; 
		ty2 = Constants.ty2;
		tz2 = Constants.tz2;
		dssp = Constants.dssp;
		dt = Constants.dt;
		xxcon2 = Constants.xxcon2;
		xxcon3 = Constants.xxcon3;
		xxcon4 = Constants.xxcon4;
		xxcon5 = Constants.xxcon5;
		dx1tx1 = Constants.dx1tx1;
		dx2tx1 = Constants.dx2tx1;
		dx3tx1 = Constants.dx3tx1;
	    dx4tx1 = Constants.dx4tx1; 
		dx5tx1 = Constants.dx5tx1;
		yycon2 = Constants.yycon2;
		yycon3 = Constants.yycon3;
		yycon4 = Constants.yycon4;
		yycon5 = Constants.yycon5;
		dy1ty1 = Constants.dy1ty1;
		dy2ty1 = Constants.dy2ty1;
		dy3ty1 = Constants.dy3ty1;
		dy4ty1 = Constants.dy4ty1;
		dy5ty1 = Constants.dy5ty1;
	    zzcon2 = Constants.zzcon2;
		zzcon3 = Constants.zzcon3;
		zzcon4 = Constants.zzcon4;
		zzcon5 = Constants.zzcon5;
		dz1tz1 = Constants.dz1tz1;
		dz2tz1 = Constants.dz2tz1;
		dz3tz1 = Constants.dz3tz1;
		dz4tz1 = Constants.dz4tz1;
		dz5tz1 = Constants.dz5tz1;
		c1 = Constants.c1;
		c2 = Constants.c2;
		c1c2 = Constants.c1c2;
		con43 = Constants.con43;				
	}

	public override void compute() {
			
				
		int ncells = Problem.NCells;
				
		double[,,,,] u = Problem.Field_u;
		double[,,,,] rhs = Problem.Field_rhs;
		double[,,,,] forcing = Problem.Field_forcing;
		double[,,,,] us = Problem.Field_us, 
				     vs = Problem.Field_vs, 
				     ws = Problem.Field_ws, 
				     rho_i = Problem.Field_rho, 
				     square = Problem.Field_square, 
				     qs = Problem.Field_qs, 
				     speed = Problem.Field_speed, 
				     ainv = Problem.Field_ainv;
				
		int[,] start = Blocks.cell_start;
		int[,] end = Blocks.cell_end;
		int[,] cell_size = Blocks.cell_size;
				
	    int c, i, j, k, m, ksize, jsize, isize;
	    double aux, rho_inv, uijk, up1, um1, vijk, vp1, vm1,
	           wijk, wp1, wm1;
	
	    //---------------------------------------------------------------------
	    // loop over all cells owned by this node                           
	    //---------------------------------------------------------------------
	    for (c = 0; c < ncells; c++)
	    {
	        ksize = cell_size[c, 2] + 2;
	        jsize = cell_size[c, 1] + 2;
	        isize = cell_size[c, 0] + 2;
	
	        //---------------------------------------------------------------------
	        //      compute the reciprocal of density, and the kinetic energy, 
	        //      and the speed of sound. 
	        //---------------------------------------------------------------------
	
	        for (k = 1; k <= ksize; k++)
	        {
	            for (j = 1; j <= jsize; j++)
	            {
	                for (i = 1; i <= isize; i++)
	                {
	                    rho_inv = 1.0d / u[c, k, j, i, 0];
	                    rho_i[c, k, j, i, 0] = rho_inv;
	                    us[c, k, j, i, 0] = u[c, k, j, i, 1] * rho_inv;
	                    vs[c, k, j, i, 0] = u[c, k, j, i, 2] * rho_inv;
	                    ws[c, k, j, i, 0] = u[c, k, j, i, 3] * rho_inv;
	                    square[c, k, j, i, 0] = 0.5d * (
	                                  u[c, k, j, i, 1] * u[c, k, j, i, 1] +
	                                  u[c, k, j, i, 2] * u[c, k, j, i, 2] +
	                                  u[c, k, j, i, 3] * u[c, k, j, i, 3]) * rho_inv;
	                    qs[c, k, j, i, 0] = square[c, k, j, i, 0] * rho_inv;
	                    //---------------------------------------------------------------------
	                    //               (do not need speed and ainx until the lhs computation)
	                    //---------------------------------------------------------------------
	                    aux = c1c2 * rho_inv * (u[c, k, j, i, 4] - square[c, k, j, i, 0]);
	                    aux = Math.Sqrt(aux);
	                    speed[c, k, j, i, 0] = aux;
	                    ainv[c, k, j, i, 0] = 1.0d / aux;
	                }
	            }
	        }
	
	        //---------------------------------------------------------------------
	        // copy the exact forcing term to the right hand side;  because 
	        // this forcing term is known, we can store it on the whole grid
	        // including the boundary                   
	        //---------------------------------------------------------------------
	
	        for (k = 2; k < ksize; k++)
	        {
	            for (j = 2; j < jsize; j++)
	            {
	                for (i = 2; i < isize; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = forcing[c, k, j, i, m];
	                    }
	                }
	            }
	        }
	
	        //---------------------------------------------------------------------
	        //      compute xi-direction fluxes 
	        //---------------------------------------------------------------------
	        //if (timeron) timer.start(t_rhsx);
	        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	        {
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    uijk = us[c, k, j, i, 0];
	                    up1 = us[c, k, j, i + 1, 0];
	                    um1 = us[c, k, j, i - 1, 0];
	
	                    rhs[c, k, j, i, 0] = rhs[c, k, j, i, 0] + dx1tx1 *
	                              (u[c, k, j, i + 1, 0] - 2.0d * u[c, k, j, i, 0] +
	                               u[c, k, j, i - 1, 0]) -
	                              tx2 * (u[c, k, j, i + 1, 1] - u[c, k, j, i - 1, 1]);
	
	                    rhs[c, k, j, i, 1] = rhs[c, k, j, i, 1] + dx2tx1 *
	                              (u[c, k, j, i + 1, 1] - 2.0d * u[c, k, j, i, 1] +
	                               u[c, k, j, i - 1, 1]) +
	                              xxcon2 * con43 * (up1 - 2.0d * uijk + um1) -
	                              tx2 * (u[c, k, j, i + 1, 1] * up1 -
	                                     u[c, k, j, i - 1, 1] * um1 +
	                                     (u[c, k, j, i + 1, 4] - square[c, k, j, i + 1, 0] -
	                                      u[c, k, j, i - 1, 4] + square[c, k, j, i - 1, 0]) *
	                                      c2);
	
	                    rhs[c, k, j, i, 2] = rhs[c, k, j, i, 2] + dx3tx1 *
	                              (u[c, k, j, i + 1, 2] - 2.0d * u[c, k, j, i, 2] +
	                               u[c, k, j, i - 1, 2]) +
	                              xxcon2 * (vs[c, k, j, i + 1, 0] - 2.0d * vs[c, k, j, i, 0] +
	                                        vs[c, k, j, i - 1, 0]) -
	                              tx2 * (u[c, k, j, i + 1, 2] * up1 -
	                                     u[c, k, j, i - 1, 2] * um1);
	
	                    rhs[c, k, j, i, 3] = rhs[c, k, j, i, 3] + dx4tx1 *
	                              (u[c, k, j, i + 1, 3] - 2.0d * u[c, k, j, i, 3] +
	                               u[c, k, j, i - 1, 3]) +
	                              xxcon2 * (ws[c, k, j, i + 1, 0] - 2.0d * ws[c, k, j, i, 0] +
	                                        ws[c, k, j, i - 1, 0]) -
	                              tx2 * (u[c, k, j, i + 1, 3] * up1 -
	                                     u[c, k, j, i - 1, 3] * um1);
	
	                    rhs[c, k, j, i, 4] = rhs[c, k, j, i, 4] + dx5tx1 *
	                              (u[c, k, j, i + 1, 4] - 2.0d * u[c, k, j, i, 4] +
	                               u[c, k, j, i - 1, 4]) +
	                              xxcon3 * (qs[c, k, j, i + 1, 0] - 2.0d * qs[c, k, j, i, 0] +
	                                        qs[c, k, j, i - 1, 0]) +
	                              xxcon4 * (up1 * up1 - 2.0d * uijk * uijk +
	                                        um1 * um1) +
	                              xxcon5 * (u[c, k, j, i + 1, 4] * rho_i[c, k, j, i + 1, 0] -
	                                        2.0d * u[c, k, j, i, 4] * rho_i[c, k, j, i, 0] +
	                                        u[c, k, j, i - 1, 4] * rho_i[c, k, j, i - 1, 0]) -
	                              tx2 * ((c1 * u[c, k, j, i + 1, 4] -
	                                       c2 * square[c, k, j, i + 1, 0]) * up1 -
	                                      (c1 * u[c, k, j, i - 1, 4] -
	                                       c2 * square[c, k, j, i - 1, 0]) * um1);
	                }
	            }
	        }
	
	        //---------------------------------------------------------------------
	        //      add fourth order xi-direction dissipation               
	        //---------------------------------------------------------------------
	
	        if (start[c, 0] > 2)
	        {
	            i = 3;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                      (5.0d * u[c, k, j, i, m] - 4.0d * u[c, k, j, i + 1, m] +
	                              u[c, k, j, i + 2, m]);
	                    }
	                }
	            }
	
	            i = 4;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                      (-4.0d * u[c, k, j, i - 1, m] + 6.0d * u[c, k, j, i, m] -
	                        4.0d * u[c, k, j, i + 1, m] + u[c, k, j, i + 2, m]);
	                    }
	                }
	            }
	
	        }
	
	
	        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	        {
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = 3 * start[c, 0] - 4; i < isize - 3 * end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                           (u[c, k, j, i - 2, m] - 4.0d * u[c, k, j, i - 1, m] +
	                            6.0d * u[c, k, j, i, m] - 4.0d * u[c, k, j, i + 1, m] +
	                                u[c, k, j, i + 2, m]);
	                    }
	                }
	            }
	        }
	
	        if (end[c, 0] > 0)
	        {
	            i = ksize - 3;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	                {
	                    for (m = 0; m <= 4; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (u[c, k, j, i - 2, m] - 4.0d * u[c, k, j, i - 1, m] +
	                                6.0d * u[c, k, j, i, m] - 4.0d * u[c, k, j, i + 1, m]);
	                    }
	                }
	            }
	
	            i = ksize - 2;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	                {
	                    for (m = 0; m <= 4; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (u[c, k, j, i - 2, m] - 4.0d * u[c, k, j, i - 1, m] +
	                                5.0d * u[c, k, j, i, m]);
	                    }
	                }
	            }
	
	        }
	
	        // if (timeron) timer.stop(t_rhsx);
	
	        //---------------------------------------------------------------------
	        //      compute eta-direction fluxes 
	        //---------------------------------------------------------------------
	        // if (timeron) timer.start(t_rhsy);
	
	        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	        {
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    vijk = vs[c, k, j, i, 0];
	                    vp1 = vs[c, k, j + 1, i, 0];
	                    vm1 = vs[c, k, j - 1, i, 0];
	                    rhs[c, k, j, i, 0] = rhs[c, k, j, i, 0] + dy1ty1 *
	                             (u[c, k, j + 1, i, 0] - 2.0d * u[c, k, j, i, 0] +
	                              u[c, k, j - 1, i, 0]) -
	                             ty2 * (u[c, k, j + 1, i, 2] - u[c, k, j - 1, i, 2]);
	                    rhs[c, k, j, i, 1] = rhs[c, k, j, i, 1] + dy2ty1 *
	                             (u[c, k, j + 1, i, 1] - 2.0d * u[c, k, j, i, 1] +
	                              u[c, k, j - 1, i, 1]) +
	                             yycon2 * (us[c, k, j + 1, i, 0] - 2.0d * us[c, k, j, i, 0] +
	                                       us[c, k, j - 1, i, 0]) -
	                             ty2 * (u[c, k, j + 1, i, 1] * vp1 -
	                                    u[c, k, j - 1, i, 1] * vm1);
	                    rhs[c, k, j, i, 2] = rhs[c, k, j, i, 2] + dy3ty1 *
	                             (u[c, k, j + 1, i, 2] - 2.0d * u[c, k, j, i, 2] +
	                              u[c, k, j - 1, i, 2]) +
	                             yycon2 * con43 * (vp1 - 2.0d * vijk + vm1) -
	                             ty2 * (u[c, k, j + 1, i, 2] * vp1 -
	                                    u[c, k, j - 1, i, 2] * vm1 +
	                                    (u[c, k, j + 1, i, 4] - square[c, k, j + 1, i, 0] -
	                                     u[c, k, j - 1, i, 4] + square[c, k, j - 1, i, 0])
	                                    * c2);
	                    rhs[c, k, j, i, 3] = rhs[c, k, j, i, 3] + dy4ty1 *
	                             (u[c, k, j + 1, i, 3] - 2.0d * u[c, k, j, i, 3] +
	                              u[c, k, j - 1, i, 3]) +
	                             yycon2 * (ws[c, k, j + 1, i, 0] - 2.0d * ws[c, k, j, i, 0] +
	                                       ws[c, k, j - 1, i, 0]) -
	                             ty2 * (u[c, k, j + 1, i, 3] * vp1 -
	                                    u[c, k, j - 1, i, 3] * vm1);
	                    rhs[c, k, j, i, 4] = rhs[c, k, j, i, 4] + dy5ty1 *
	                             (u[c, k, j + 1, i, 4] - 2.0d * u[c, k, j, i, 4] +
	                              u[c, k, j - 1, i, 4]) +
	                             yycon3 * (qs[c, k, j + 1, i, 0] - 2.0d * qs[c, k, j, i, 0] +
	                                       qs[c, k, j - 1, i, 0]) +
	                             yycon4 * (vp1 * vp1 - 2.0d * vijk * vijk +
	                                       vm1 * vm1) +
	                             yycon5 * (u[c, k, j + 1, i, 4] * rho_i[c, k, j + 1, i, 0] -
	                                       2.0d * u[c, k, j, i, 4] * rho_i[c, k, j, i, 0] +
	                                       u[c, k, j - 1, i, 4] * rho_i[c, k, j - 1, i, 0]) -
	                             ty2 * ((c1 * u[c, k, j + 1, i, 4] -
	                                     c2 * square[c, k, j + 1, i, 0]) * vp1 -
	                                    (c1 * u[c, k, j - 1, i, 4] -
	                                     c2 * square[c, k, j - 1, i, 0]) * vm1);
	                }
	            }
	        }
	
	
	        //---------------------------------------------------------------------
	        //      add fourth order eta-direction dissipation         
	        //---------------------------------------------------------------------
	
	        if (start[c, 1] > 2)
	        {
	            j = 3;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (5.0d * u[c, k, j, i, m] - 4.0d * u[c, k, j + 1, i, m] +
	                                      u[c, k, j + 2, i, m]);
	                    }
	                }
	            }
	
	
	            j = 4;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m <= 4; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (-4.0d * u[c, k, j - 1, i, m] + 6.0d * u[c, k, j, i, m] -
	                                4.0d * u[c, k, j + 1, i, m] + u[c, k, j + 2, i, m]);
	                    }
	                }
	            }
	        }
	
	        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	        {
	            for (j = 3 * start[c, 1] - 4; j < jsize - 3 * end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                           (u[c, k, j - 2, i, m] - 4.0d * u[c, k, j - 1, i, m] +
	                            6.0d * u[c, k, j, i, m] - 4.0d * u[c, k, j + 1, i, m] +
	                                u[c, k, j + 2, i, m]);
	                    }
	                }
	            }
	        }
	
	
	        if (end[c, 1] > 0)
	        {
	            j = jsize - 3;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m <= 4; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (u[c, k, j - 2, i, m] - 4.0d * u[c, k, j - 1, i, m] +
	                                6.0d * u[c, k, j, i, m] - 4.0d * u[c, k, j + 1, i, m]);
	                    }
	                }
	            }
	
	
	            j = jsize - 2;
	            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m <= 4; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (u[c, k, j - 2, i, m] - 4.0d * u[c, k, j - 1, i, m] +
	                                5.0d * u[c, k, j, i, m]);
	                    }
	                }
	            }
	        }
	
	
	        // if (timeron) timer.stop(t_rhsy);
	
	        //---------------------------------------------------------------------
	        //      compute zeta-direction fluxes 
	        //---------------------------------------------------------------------
	        // if (timeron) timer.start(t_rhsz);
	        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	        {
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    wijk = ws[c, k, j, i, 0];
	                    wp1 = ws[c, k + 1, j, i, 0];
	                    wm1 = ws[c, k - 1, j, i, 0];
	
	                    rhs[c, k, j, i, 0] = rhs[c, k, j, i, 0] + dz1tz1 *
	                             (u[c, k + 1, j, i, 0] - 2.0d * u[c, k, j, i, 0] +
	                              u[c, k - 1, j, i, 0]) -
	                             tz2 * (u[c, k + 1, j, i, 3] - u[c, k - 1, j, i, 3]);
	                    rhs[c, k, j, i, 1] = rhs[c, k, j, i, 1] + dz2tz1 *
	                             (u[c, k + 1, j, i, 1] - 2.0d * u[c, k, j, i, 1] +
	                              u[c, k - 1, j, i, 1]) +
	                             zzcon2 * (us[c, k + 1, j, i, 0] - 2.0d * us[c, k, j, i, 0] +
	                                       us[c, k - 1, j, i, 0]) -
	                             tz2 * (u[c, k + 1, j, i, 1] * wp1 -
	                                    u[c, k - 1, j, i, 1] * wm1);
	                    rhs[c, k, j, i, 2] = rhs[c, k, j, i, 2] + dz3tz1 *
	                             (u[c, k + 1, j, i, 2] - 2.0d * u[c, k, j, i, 2] +
	                              u[c, k - 1, j, i, 2]) +
	                             zzcon2 * (vs[c, k + 1, j, i, 0] - 2.0d * vs[c, k, j, i, 0] +
	                                       vs[c, k - 1, j, i, 0]) -
	                             tz2 * (u[c, k + 1, j, i, 2] * wp1 -
	                                    u[c, k - 1, j, i, 2] * wm1);
	                    rhs[c, k, j, i, 3] = rhs[c, k, j, i, 3] + dz4tz1 *
	                             (u[c, k + 1, j, i, 3] - 2.0d * u[c, k, j, i, 3] +
	                              u[c, k - 1, j, i, 3]) +
	                             zzcon2 * con43 * (wp1 - 2.0d * wijk + wm1) -
	                             tz2 * (u[c, k + 1, j, i, 3] * wp1 -
	                                    u[c, k - 1, j, i, 3] * wm1 +
	                                    (u[c, k + 1, j, i, 4] - square[c, k + 1, j, i, 0] -
	                                     u[c, k - 1, j, i, 4] + square[c, k - 1, j, i, 0])
	                                    * c2);
	                    rhs[c, k, j, i, 4] = rhs[c, k, j, i, 4] + dz5tz1 *
	                             (u[c, k + 1, j, i, 4] - 2.0d * u[c, k, j, i, 4] +
	                              u[c, k - 1, j, i, 4]) +
	                             zzcon3 * (qs[c, k + 1, j, i, 0] - 2.0d * qs[c, k, j, i, 0] +
	                                       qs[c, k - 1, j, i, 0]) +
	                             zzcon4 * (wp1 * wp1 - 2.0d * wijk * wijk +
	                                       wm1 * wm1) +
	                             zzcon5 * (u[c, k + 1, j, i, 4] * rho_i[c, k + 1, j, i, 0] -
	                                       2.0 * u[c, k, j, i, 4] * rho_i[c, k, j, i, 0] +
	                                       u[c, k - 1, j, i, 4] * rho_i[c, k - 1, j, i, 0]) -
	                             tz2 * ((c1 * u[c, k + 1, j, i, 4] -
	                                      c2 * square[c, k + 1, j, i, 0]) * wp1 -
	                                     (c1 * u[c, k - 1, j, i, 4] -
	                                      c2 * square[c, k - 1, j, i, 0]) * wm1);
	                }
	            }
	        }
	
	        //---------------------------------------------------------------------
	        //      add fourth order zeta-direction dissipation                
	        //---------------------------------------------------------------------
	
	        if (start[c, 2] > 2)
	        {
	            k = 3;
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (5.0d * u[c, k, j, i, m] - 4.0d * u[c, k + 1, j, i, m] +
	                                      u[c, k + 2, j, i, m]);
	                    }
	                }
	            }
	
	            k = 4;
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (-4.0d * u[c, k - 1, j, i, m] + 6.0d * u[c, k, j, i, m] -
	                                4.0d * u[c, k + 1, j, i, m] + u[c, k + 2, j, i, m]);
	                    }
	                }
	            }
	        }
	
	        for (k = 3 * start[c, 2] - 4; k < ksize - 3 * end[c, 2]; k++)
	        {
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                           (u[c, k - 2, j, i, m] - 4.0d * u[c, k - 1, j, i, m] +
	                            6.0d * u[c, k, j, i, m] - 4.0d * u[c, k + 1, j, i, m] +
	                                u[c, k + 2, j, i, m]);
	                    }
	                }
	            }
	        }
	
	        if (end[c, 2] > 0)
	        {
	
	            k = ksize - 3;
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (u[c, k - 2, j, i, m] - 4.0d * u[c, k - 1, j, i, m] +
	                                6.0d * u[c, k, j, i, m] - 4.0d * u[c, k + 1, j, i, m]);
	                    }
	                }
	            }
	
	            k = ksize - 2;
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m <= 4; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - dssp *
	                              (u[c, k - 2, j, i, m] - 4.0d * u[c, k - 1, j, i, m] +
	                                5.0d * u[c, k, j, i, m]);
	                    }
	                }
	            }
	        }
	
	        //if (timeron) timer.stop(t_rhsz);
	
	
	        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
	        {
	            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
	            {
	                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
	                {
	                    for (m = 0; m < 5; m++)
	                    {
	                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] * dt;
	                    }
	                }
	            }
	        }
	    }
	
	} // end activate method 

}

}
