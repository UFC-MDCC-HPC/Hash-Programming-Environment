using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.orientation.Z;
using common.solve.BeamWarmingMethod;
using common.solve.Backward;

namespace impl.sp.solve.ZBackwardImpl { 

	public class IZBackwardImpl<I, C, DIR, MTH> : BaseIZBackwardImpl<I, C, DIR, MTH>, IBackward<I, C, DIR, MTH>
		where I:IInstance_SP<C>
		where C:IClass
		where DIR:IZ
		where MTH:IBeamWarmingMethod
	{	
		public IZBackwardImpl()
		{
			initialize();
		}
		
        private int[,] start, end, slice, cell_size;
		private double[,,,,] lhs, rhs;
		
		public void initialize()
		{
			start = Blocks.cell_start;
			end = Blocks.cell_end;
			slice = Blocks.cell_slice;
			cell_size = Blocks.cell_size;
			
			lhs = Problem.Field_lhs;
			rhs = Problem.Field_rhs;
		}
		
		public void init()
		{
			int i, j, k, n, k1, m;
			
            #region backward init
            //---------------------------------------------------------------------
            //            now we know this is the first grid block on the back sweep,
            //            so we don't need a message to start the substitution. 
            //---------------------------------------------------------------------

            k = kend - 1;
            k1 = kend;
            n = -1;
            for (m = 0; m <= 2; m++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                    lhs[c, k, j, i, n + 4] * rhs[c, k1, j, i, m];
                    }
                }
            }

            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                    lhs[c, k, j, i, n + 4] * rhs[c, k1, j, i, m];
                    }
                }
            }
            #endregion backward_init
		}		
		
		private int c, kstart, kend, isize, jsize;
		
		public void enterStage(int stage)			
		{
            c = slice[stage, 2];

            kstart = 2;
            kend = 2 + cell_size[c, 2] - 1;

            isize = cell_size[c, 0] + 2;
            jsize = cell_size[c, 1] + 2;
		}

		public override void compute() { 
			
			int i, j, k, n, k1, k2, m;
			double fac1, fac2;

			#region backward
            //---------------------------------------------------------------------
            //         Whether or not this is the last processor, we always have
            //         to complete the back-substitution 
            //---------------------------------------------------------------------

            //---------------------------------------------------------------------
            //         The first three factors
            //---------------------------------------------------------------------
            n = -1;
            for (m = 0; m <= 2; m++)
            {
                for (k = kend - 2; k >= kstart; k--)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            k1 = k + 1;
                            k2 = k + 2;
                            rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k1, j, i, m] -
                                     lhs[c, k, j, i, n + 5] * rhs[c, k2, j, i, m];
                        }
                    }
                }
            }

            //---------------------------------------------------------------------
            //         And the remaining two
            //---------------------------------------------------------------------
            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (k = kend - 2; k >= kstart; k--)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            k1 = k + 1;
                            k2 = k + 2;
                            rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k1, j, i, m] -
                                     lhs[c, k, j, i, n + 5] * rhs[c, k2, j, i, m];
                        }
                    }
                }
            }
            #endregion
		} // end activate method 
		
	}

}
