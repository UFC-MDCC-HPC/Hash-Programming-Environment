using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.BeamWarmingMethod;
using common.orientation.Z;
using common.solve.Forward;

namespace impl.sp.solve.ZForwardImpl { 

	public class IZForwardImpl<I, C, MTH, DIR> : BaseIZForwardImpl<I, C, MTH, DIR>, IForward<I, C, MTH, DIR>
		where I:IInstance_SP<C>
		where C:IClass
		where MTH:IBeamWarmingMethod
		where DIR:IZ
	{
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
		
		private int c, kstart, kend, isize, jsize;
		
		public void enterStage(int stage)			
		{
            c = slice[stage, 2];

            kstart = 2;
            kend = 2 + cell_size[c, 2] - 1;

            isize = cell_size[c, 0] + 2;
            jsize = cell_size[c, 1] + 2;
		}

		public override void compute() 
		{ 
			int i, j, k, n, k1, k2, m;
			double fac1, fac2;
			
            #region forward
            //---------------------------------------------------------------------
            //         perform the Thomas algorithm; first, FORWARD ELIMINATION     
            //---------------------------------------------------------------------
            n = -1;

            for (k = kstart; k <= kend - 2; k++)
            {
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        k1 = k + 1;
                        k2 = k + 2;
                        fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                        lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                        }
                        lhs[c, k1, j, i, n + 3] = lhs[c, k1, j, i, n + 3] -
                                   lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 4];
                        lhs[c, k1, j, i, n + 4] = lhs[c, k1, j, i, n + 4] -
                                   lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] -
                                    lhs[c, k1, j, i, n + 2] * rhs[c, k, j, i, m];
                        }
                        lhs[c, k2, j, i, n + 2] = lhs[c, k2, j, i, n + 2] -
                                   lhs[c, k2, j, i, n + 1] * lhs[c, k, j, i, n + 4];
                        lhs[c, k2, j, i, n + 3] = lhs[c, k2, j, i, n + 3] -
                                   lhs[c, k2, j, i, n + 1] * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k2, j, i, m] = rhs[c, k2, j, i, m] -
                                    lhs[c, k2, j, i, n + 1] * rhs[c, k, j, i, m];
                        }
                    }
                }
            }

            //---------------------------------------------------------------------
            //         The last two rows in this grid block are a bit different, 
            //         since they do not have two more rows available for the
            //         elimination of off-diagonal entries
            //---------------------------------------------------------------------
            k = kend - 1;
            k1 = kend;
            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
            {
                for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                {
                    fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                    lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                    lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                    }
                    lhs[c, k1, j, i, n + 3] = lhs[c, k1, j, i, n + 3] -
                               lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 4];
                    lhs[c, k1, j, i, n + 4] = lhs[c, k1, j, i, n + 4] -
                               lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] -
                                lhs[c, k1, j, i, n + 2] * rhs[c, k, j, i, m];
                    }
                    //---------------------------------------------------------------------
                    //               scale the last row immediately (some of this is
                    //               overkill in case this is the last cell)
                    //---------------------------------------------------------------------
                    fac2 = 1.0d / lhs[c, k1, j, i, n + 3];
                    lhs[c, k1, j, i, n + 4] = fac2 * lhs[c, k1, j, i, n + 4];
                    lhs[c, k1, j, i, n + 5] = fac2 * lhs[c, k1, j, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k1, j, i, m] = fac2 * rhs[c, k1, j, i, m];
                    }
                }
            }

            //---------------------------------------------------------------------
            //         do the u+c and the u-c factors               
            //---------------------------------------------------------------------
            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (k = kstart; k <= kend - 2; k++)
                {
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            k1 = k + 1;
                            k2 = k + 2;
                            fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                            lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                            lhs[c, k1, j, i, n + 3] = lhs[c, k1, j, i, n + 3] -
                                       lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 4];
                            lhs[c, k1, j, i, n + 4] = lhs[c, k1, j, i, n + 4] -
                                       lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 5];
                            rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] -
                                       lhs[c, k1, j, i, n + 2] * rhs[c, k, j, i, m];
                            lhs[c, k2, j, i, n + 2] = lhs[c, k2, j, i, n + 2] -
                                       lhs[c, k2, j, i, n + 1] * lhs[c, k, j, i, n + 4];
                            lhs[c, k2, j, i, n + 3] = lhs[c, k2, j, i, n + 3] -
                                       lhs[c, k2, j, i, n + 1] * lhs[c, k, j, i, n + 5];
                            rhs[c, k2, j, i, m] = rhs[c, k2, j, i, m] -
                                       lhs[c, k2, j, i, n + 1] * rhs[c, k, j, i, m];
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            And again the last two rows separately
                //---------------------------------------------------------------------
                k = kend - 1;
                k1 = kend;
                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                        lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                        rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                        lhs[c, k1, j, i, n + 3] = lhs[c, k1, j, i, n + 3] -
                                   lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 4];
                        lhs[c, k1, j, i, n + 4] = lhs[c, k1, j, i, n + 4] -
                                   lhs[c, k1, j, i, n + 2] * lhs[c, k, j, i, n + 5];
                        rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] -
                                  lhs[c, k1, j, i, n + 2] * rhs[c, k, j, i, m];
                        //---------------------------------------------------------------------
                        //               Scale the last row immediately (some of this is overkill
                        //               if this is the last cell)
                        //---------------------------------------------------------------------
                        fac2 = 1.0d / lhs[c, k1, j, i, n + 3];
                        lhs[c, k1, j, i, n + 4] = fac2 * lhs[c, k1, j, i, n + 4];
                        lhs[c, k1, j , i, n + 5] = fac2 * lhs[c, k1, j , i, n + 5];
                        rhs[c, k1, j, i, m] = fac2 * rhs[c, k1, j, i, m];

                    }
                }
            }

            #endregion
		} // end activate method 
		
	}

}
