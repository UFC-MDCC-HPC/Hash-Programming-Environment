using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.orientation.X;
using common.solve.BeamWarmingMethod;
using common.solve.Backward;

namespace impl.sp.solve.XBackwardImpl { 

	public class IXBackwardImpl<I, C, DIR, MTH> : BaseIXBackwardImpl<I, C, DIR, MTH>, IBackward<I, C, DIR, MTH>
		where I:IInstance_SP<C>
		where C:IClass
		where DIR:IX
		where MTH:IBeamWarmingMethod
	{	
		public IXBackwardImpl()
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
			int i, j, k, n, i1, m;
			
            #region backward_init
            //---------------------------------------------------------------------
            //            now we know this is the first grid block on the back sweep,
            //            so we do not need a message to start the substitution. 
            //---------------------------------------------------------------------
            i = iend - 1;
            i1 = iend;
            n = -1;
            for (m = 0; m <= 2; m++)
            {
                for (k = start[c, 2]; k < ksize - end[c, 2] - 1; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1] - 1; j++)
                    {
                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                    lhs[c, k, j, i, n + 4] * rhs[c, k, j, i1, m];
                    }
                }
            }

            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k, j, i1, m];
                    }
                }
            }
            #endregion
 		}
		
		private int c, istart, iend, jsize, ksize;
		
		public void enterStage(int stage)			
		{
            c = slice[stage, 0];

            istart = 2;
            iend = 2 + cell_size[c, 0] - 1;

            jsize = cell_size[c, 1] + 2;
            ksize = cell_size[c, 2] + 2;
		}
				
		public override void compute() 
		{ 		
            int i, j, k, n, i1, i2, m;
			
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
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = iend - 2; i >= istart; i--)
                        {
                            i1 = i + 1;
                            i2 = i + 2;
                            rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k, j, i1, m] -
                                     lhs[c, k, j, i, n + 5] * rhs[c, k, j, i2, m];
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
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = iend - 2; i >= istart; i--)
                        {
                            i1 = i + 1;
                            i2 = i + 2;
                            rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k, j, i1, m] -
                                     lhs[c, k, j, i, n + 5] * rhs[c, k, j, i2, m];
                        }
                    }
                }
            }
            #endregion backward
		
		} // end activate method 
	
	}
	
}
