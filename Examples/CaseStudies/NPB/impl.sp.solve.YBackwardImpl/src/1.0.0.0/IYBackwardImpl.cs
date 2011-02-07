using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.orientation.Y;
using common.solve.BeamWarmingMethod;
using common.solve.Backward;

namespace impl.sp.solve.YBackwardImpl { 

	public class IYBackwardImpl<I, C, DIR, MTH> : BaseIYBackwardImpl<I, C, DIR, MTH>, IBackward<I, C, DIR, MTH>
		where I:IInstance_SP<C>
		where C:IClass
		where DIR:IY
		where MTH:IBeamWarmingMethod
	{
		public IYBackwardImpl() 
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
			int i, j, k, n, j1, m;
			
        	#region backward_init
            //---------------------------------------------------------------------
            //            now we know this is the first grid block on the back sweep,
            //            so we don't need a message to start the substitution. 
            //---------------------------------------------------------------------

            j = jend - 1;
            j1 = jend;
            n = -1;
            for (m = 0; m <= 2; m++)
            {
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                    lhs[c, k, j, i, n + 4] * rhs[c, k, j1, i, m];
                    }
                }
            }

            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                    lhs[c, k, j, i, n + 4] * rhs[c, k, j1, i, m];
                    }
                }
            }
            #endregion 
		}

		
		private int c, jstart, jend, isize, ksize;
		
		public void enterStage(int stage)			
		{
            c = slice[stage, 1];

            jstart = 2;
            jend = 2 + cell_size[c, 1] - 1;

            isize = cell_size[c, 0] + 2;
            ksize = cell_size[c, 2] + 2;
		
		}
				
		public override void compute() { 
			
            int i, j, k, n, j1, j2, m; /* requests(2), statuses(MPI_STATUS_SIZE, 2);*/              

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
                    for (j = jend - 2; j >= jstart; j--)   
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            j1 = j + 1;
                            j2 = j + 2;
                            rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k, j1, i, m] -
                                     lhs[c, k, j, i, n + 5] * rhs[c, k, j2, i, m];
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
                    for (j = jend - 2; j >= jstart; j--)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            j1 = j + 1;
                            j2 = j1 + 1;
                            rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                     lhs[c, k, j, i, n + 4] * rhs[c, k, j1, i, m] -
                                     lhs[c, k, j, i, n + 5] * rhs[c, k, j2, i, m];
                        }
                    }
                }
            }
            #endregion
		
		} // end activate method 
	
	}

}
