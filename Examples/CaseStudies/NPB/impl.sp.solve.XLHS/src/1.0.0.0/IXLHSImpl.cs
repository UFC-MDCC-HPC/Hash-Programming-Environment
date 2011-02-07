using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;
using common.solve.LHS;
using common.problem_size.Class;
using sp.problem_size.Instance_SP;
using common.orientation.X;
using common.solve.BeamWarmingMethod;

namespace impl.sp.solve.XLHS { 

	public class IXLHSImpl<I,C,DIR,MTH> : BaseIXLHSImpl<I,C,DIR,MTH>, ILHS<I,C,DIR,MTH>
	where I:IInstance_SP<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod
	{
	
		public IXLHSImpl() 
		{ 
			initialize();
		} 
			
		private int c;

		public void enterStage(int stage)			
		{
            c = slice[stage, 0];

		}
			
		private int[,] start, end, cell_size, slice;
		private double[,,,,] lhs, rho_i, speed, us;
		private double c3c4, dttx2, c2dttx1, dttx1, con43, dx5, dx1,
		               comz5, comz4, comz1, comz6, dx2, c1c5, dxmax;
				
		private double[] cv, rhon;
		
		private int MAX_CELL_DIM;
		
		public void initialize() 
		{
			MAX_CELL_DIM = Problem.MAX_CELL_DIM;
			
		    cv = new double[MAX_CELL_DIM + 4];     /* -2 */   // lhsx, lhsy, lhsz (def/use)
		    rhon = new double[MAX_CELL_DIM + 4];   /* -2 */   // lhsx (local)
			
			start = Blocks.cell_start;
			end = Blocks.cell_end;
			cell_size = Blocks.cell_size;
			slice = Blocks.cell_slice;
					
			lhs = Problem.Field_lhs;
			rho_i = Problem.Field_rho;
			speed = Problem.Field_speed;
			us = Problem.Field_us;
					
			c3c4 = Constants.c3c4;
			dttx2 = Constants.dttx2;
			c2dttx1 = Constants.c2dttx1;
			dttx1 = Constants.dttx1;
			con43 = Constants.con43;
			dx5 = Constants.dx5;
			dx1 = Constants.dx1;
			comz4 = Constants.comz4;
			comz1 = Constants.comz1;
			comz6 = Constants.comz6;
			comz5 = Constants.comz5;
			dx2 = Constants.dx2;
			c1c5 = Constants.c1c5;
			dxmax = Constants.dxmax;
		}
		
		public override void compute() 
		{ 
            double ru1;
            int i, j, k;

            int ksize = cell_size[c, 2] + 2;
            int jsize = cell_size[c, 1] + 2;
            int isize = cell_size[c, 0] + 2;

            //---------------------------------------------------------------------
            //      treat only cell c             
            //---------------------------------------------------------------------

            //---------------------------------------------------------------------
            //      first fill the lhs for the u-eigenvalue                   
            //---------------------------------------------------------------------
            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = start[c, 0] - 1; i < isize - end[c, 0] + 1; i++)
                    {
                        ru1 = c3c4 * rho_i[c, k, j, i, 0];
                        cv[i] = us[c, k, j, i, 0];
                        rhon[i] = dmax1(dx2 + con43 * ru1, dx5 + c1c5 * ru1, dxmax + ru1, dx1);
                    }

                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        lhs[c, k, j, i, 0] = 0.0d;
                        lhs[c, k, j, i, 1] = -dttx2 * cv[i - 1] - dttx1 * rhon[i - 1];
                        lhs[c, k, j, i, 2] = 1.0d + c2dttx1 * rhon[i];
                        lhs[c, k, j, i, 3] = dttx2 * cv[i + 1] - dttx1 * rhon[i + 1];
                        lhs[c, k, j, i, 4] = 0.0d;
                    }
                }
            }

            //---------------------------------------------------------------------
            //      add fourth order dissipation                             
            //---------------------------------------------------------------------
            if (start[c, 0] > 2)
            {
                i = 3;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        lhs[c, k, j, i, 2] = lhs[c, k, j, i, 2] + comz5;
                        lhs[c, k, j, i, 3] = lhs[c, k, j, i, 3] - comz4;
                        lhs[c, k, j, i, 4] = lhs[c, k, j, i, 4] + comz1;

                        lhs[c, k, j, i + 1, 1] = lhs[c, k, j, i + 1, 1] - comz4;
                        lhs[c, k, j, i + 1, 2] = lhs[c, k, j, i + 1, 2] + comz6;
                        lhs[c, k, j, i + 1, 3] = lhs[c, k, j, i + 1, 3] - comz4;
                        lhs[c, k, j, i + 1, 4] = lhs[c, k, j, i + 1, 4] + comz1;
                    }
                }
            }

            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = 3 * start[c, 0] - 4; i < isize - 3 * end[c, 0]; i++)
                    {
                        lhs[c, k, j, i, 0] = lhs[c, k, j, i, 0] + comz1;
                        lhs[c, k, j, i, 1] = lhs[c, k, j, i, 1] - comz4;
                        lhs[c, k, j, i, 2] = lhs[c, k, j, i, 2] + comz6;
                        lhs[c, k, j, i, 3] = lhs[c, k, j, i, 3] - comz4;
                        lhs[c, k, j, i, 4] = lhs[c, k, j, i, 4] + comz1;
                    }
                }
            }

            if (end[c, 0] > 0)
            {
                i = isize - 3;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        lhs[c, k, j, i, 0] = lhs[c, k, j, i, 0] + comz1;
                        lhs[c, k, j, i, 1] = lhs[c, k, j, i, 1] - comz4;
                        lhs[c, k, j, i, 2] = lhs[c, k, j, i, 2] + comz6;
                        lhs[c, k, j, i, 3] = lhs[c, k, j, i, 3] - comz4;

                        lhs[c, k, j, i + 1, 0] = lhs[c, k, j, i + 1, 0] + comz1;
                        lhs[c, k, j, i + 1, 1] = lhs[c, k, j, i + 1, 1] - comz4;
                        lhs[c, k, j, i + 1, 2] = lhs[c, k, j, i + 1, 2] + comz5;
                    }
                }
            }

            //---------------------------------------------------------------------
            //      subsequently, fill the other factors (u+c), (u-c) by a4ing to 
            //      the first  
            //---------------------------------------------------------------------
            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        lhs[c, k, j, i, 0 + 5] = lhs[c, k, j, i, 0];
                        lhs[c, k, j, i, 1 + 5] = lhs[c, k, j, i, 1] -
                                         dttx2 * speed[c, k, j, i - 1, 0];
                        lhs[c, k, j, i, 2 + 5] = lhs[c, k, j, i, 2];
                        lhs[c, k, j, i, 3 + 5] = lhs[c, k, j, i, 3] +
                                         dttx2 * speed[c, k, j, i + 1, 0];
                        lhs[c, k, j, i, 4 + 5] = lhs[c, k, j, i, 4];
                        lhs[c, k, j, i, 0 + 10] = lhs[c, k, j, i, 0];
                        lhs[c, k, j, i, 1 + 10] = lhs[c, k, j, i, 1] +
                                         dttx2 * speed[c, k, j, i - 1, 0];
                        lhs[c, k, j, i, 2 + 10] = lhs[c, k, j, i, 2];
                        lhs[c, k, j, i, 3 + 10] = lhs[c, k, j, i, 3] -
                                         dttx2 * speed[c, k, j, i + 1, 0];
                        lhs[c, k, j, i, 4 + 10] = lhs[c, k, j, i, 4];
                    }
                }
            }
			
		} // end activate method 
		
		public double dmax1(double a, double b)
		{
			if (a < b) return b; else return a;
		}
	
		public double dmax1(double a, double b, double c, double d)
		{
			return dmax1(dmax1(a, b), dmax1(c, d));
		}
	
	}

}
