using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.BeamWarmingMethod;
using common.orientation.X;
using common.solve.Forward;

namespace impl.sp.solve.XForwardImpl { 

	public class IXForwardImpl<I, C, MTH, DIR> : BaseIXForwardImpl<I, C, MTH, DIR>, IForward<I, C, MTH, DIR>
		where I:IInstance_SP<C>
		where C:IClass
		where MTH:IBeamWarmingMethod
		where DIR:IX
	{
        private int[,] start, end, slice, cell_size;
		private double[,,,,] lhs, rhs;
		
		public IXForwardImpl()
		{
    		initialize();			
		}		
		
		public void initialize()
		{
			start = Blocks.cell_start;
			end = Blocks.cell_end;
			slice = Blocks.cell_slice;
			cell_size = Blocks.cell_size;
			
			lhs = Problem.Field_lhs;
			rhs = Problem.Field_rhs;
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
			int i, j, k, n,  i1, i2, m;
			double fac1, fac2;
						
			// **************************
			
            n = -1;

            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = istart; i <= iend - 2; i++)
                    {
                        i1 = i + 1;
                        i2 = i + 2;
                        fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                        lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                        }
                        lhs[c, k, j, i1, n + 3] = lhs[c, k, j, i1, n + 3] -
                                       lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i1, n + 4] = lhs[c, k, j, i1, n + 4] -
                                       lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] -
                                        lhs[c, k, j, i1, n + 2] * rhs[c, k, j, i, m];
                        }
                        lhs[c, k, j, i2, n + 2] = lhs[c, k, j, i2, n + 2] -
                                       lhs[c, k, j, i2, n + 1] * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i2, n + 3] = lhs[c, k, j, i2, n + 3] -
                                       lhs[c, k, j, i2, n + 1] * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j, i2, m] = rhs[c, k, j, i2, m] -
                                        lhs[c, k, j, i2, n + 1] * rhs[c, k, j, i, m];
                        }
                    }
                }
            }

            //---------------------------------------------------------------------
            //      The last two rows in this grid block are a bit different, 
            //      since they do not have two more rows available for the
            //      elimination of off-diagonal entries
            //---------------------------------------------------------------------

            i = iend - 1;
            i1 = iend;
            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                    lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                    lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                    }
                    lhs[c, k, j, i1, n + 3] = lhs[c, k, j, i1, n + 3] -
                                   lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 4];
                    lhs[c, k, j, i1, n + 4] = lhs[c, k, j, i1, n + 4] -
                                   lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] -
                                    lhs[c, k, j, i1, n + 2] * rhs[c, k, j, i, m];
                    }
                    //---------------------------------------------------------------------
                    //            scale the last row immediately 
                    //---------------------------------------------------------------------
                    fac2 = 1.0d / lhs[c, k, j, i1, n + 3];
                    lhs[c, k, j, i1, n + 4] = fac2 * lhs[c, k, j, i1, n + 4];
                    lhs[c, k, j, i1, n + 5] = fac2 * lhs[c, k, j, i1, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k, j, i1, m] = fac2 * rhs[c, k, j, i1, m];
                    }
                }
            }

            //---------------------------------------------------------------------
            //      do the u+c and the u-c factors                 
            //---------------------------------------------------------------------

            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = istart; i <= iend - 2; i++)
                        {
                            i1 = i + 1;
                            i2 = i + 2;
                            fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                            lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                            lhs[c, k, j, i1, n + 3] = lhs[c, k, j, i1, n + 3] -
                                          lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j, i1, n + 4] = lhs[c, k, j, i1, n + 4] -
                                          lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] -
                                          lhs[c, k, j, i1, n + 2] * rhs[c, k, j, i, m];
                            lhs[c, k, j, i2, n + 2] = lhs[c, k, j, i2, n + 2] -
                                          lhs[c, k, j, i2, n + 1] * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j, i2, n + 3] = lhs[c, k, j, i2, n + 3] -
                                          lhs[c, k, j, i2, n + 1] * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j, i2, m] = rhs[c, k, j, i2, m] -
                                          lhs[c, k, j, i2, n + 1] * rhs[c, k, j, i, m];
                        }
                    }
                }


//                    Console.WriteLine(node + ": X-SOLVE - PASS 3" + stage);

                //---------------------------------------------------------------------
                //         And again the last two rows separately
                //---------------------------------------------------------------------
                i = iend - 1;
                i1 = iend;

                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                        lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                        rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];                        //*
                        lhs[c, k, j, i1, n + 3] = lhs[c, k, j, i1, n + 3] -
                                       lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 4];       //*
                        lhs[c, k, j, i1, n + 4] = lhs[c, k, j, i1, n + 4] -
                                       lhs[c, k, j, i1, n + 2] * lhs[c, k, j, i, n + 5];
                        rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] -
                                       lhs[c, k, j, i1, n + 2] * rhs[c, k, j, i, m];           //*
                        //---------------------------------------------------------------------
                        //               Scale the last row immediately
                        //---------------------------------------------------------------------
                        fac2 = 1.0d / lhs[c, k, j, i1, n + 3];
                        lhs[c, k, j, i1, n + 4] = fac2 * lhs[c, k, j, i1, n + 4];
                        lhs[c, k, j, i1, n + 5] = fac2 * lhs[c, k, j, i1, n + 5];
                        rhs[c, k, j, i1, m] = fac2 * rhs[c, k, j, i1, m];                     //*

                    }
                }
            }
		} // end activate method 
		
	}

}
