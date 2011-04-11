using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.BeamWarmingMethod;
using common.orientation.Y;
using common.solve.Forward;

namespace impl.sp.solve.YForwardImpl { 

	public class IYForwardImpl<I, C, MTH, DIR> : BaseIYForwardImpl<I, C, MTH, DIR>, IForward<I, C, MTH, DIR>
		where I:IInstance_SP<C>
		where C:IClass
		where MTH:IBeamWarmingMethod
		where DIR:IY
	{	
		public IYForwardImpl()
		{
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

		public override int go() 
		{
            int i, j, k, n, j1, j2, m; /* requests(2), statuses(MPI_STATUS_SIZE, 2);*/              
			double fac1, fac2;
			
			#region forward
            //---------------------------------------------------------------------
            //         perform the Thomas algorithm; first, FORWARD ELIMINATION     
            //---------------------------------------------------------------------
            n = -1;

            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
            {
                for (j = jstart; j <= jend - 2; j++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        j1 = j + 1;
                        j2 = j + 2;
                        fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                        lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                        }
                        lhs[c, k, j1, i, n + 3] = lhs[c, k, j1, i, n + 3] -
                                   lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j1, i, n + 4] = lhs[c, k, j1, i, n + 4] -
                                   lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] -
                                    lhs[c, k, j1, i, n + 2] * rhs[c, k, j, i, m];
                        }
                        lhs[c, k, j2, i, n + 2] = lhs[c, k, j2, i, n + 2] -
                                   lhs[c, k, j2, i, n + 1] * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j2, i, n + 3] = lhs[c, k, j2, i, n + 3] -
                                   lhs[c, k, j2, i, n + 1] * lhs[c, k, j, i, n + 5];
                        for (m = 0; m <= 2; m++)
                        {
                            rhs[c, k, j2, i, m] = rhs[c, k, j2, i, m] -
                                    lhs[c, k, j2, i, n + 1] * rhs[c, k, j, i, m];
                        }
                    }
                }
            }

            //---------------------------------------------------------------------
            //         The last two rows in this grid block are a bit different, 
            //         since they do not have two more rows available for the
            //         elimination of off-diagonal entries
            //---------------------------------------------------------------------

            j = jend - 1;
            j1 = jend;
            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
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
                    lhs[c, k, j1, i, n + 3] = lhs[c, k, j1, i, n + 3] -
                               lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 4];
                    lhs[c, k, j1, i, n + 4] = lhs[c, k, j1, i, n + 4] -
                               lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] -
                                lhs[c, k, j1, i, n + 2] * rhs[c, k, j, i, m];
                    }
                    //---------------------------------------------------------------------
                    //               scale the last row immediately (some of this is
                    //               overkill in case this is the last cell)
                    //---------------------------------------------------------------------
                    fac2 = 1.0d / lhs[c, k, j1, i, n + 3];
                    lhs[c, k, j1, i, n + 4] = fac2 * lhs[c, k, j1, i, n + 4];
                    lhs[c, k, j1, i, n + 5] = fac2 * lhs[c, k, j1, i, n + 5];
                    for (m = 0; m <= 2; m++)
                    {
                        rhs[c, k, j1, i, m] = fac2 * rhs[c, k, j1, i, m];
                    }
                }
            }

            //---------------------------------------------------------------------
            //         do the u+c and the u-c factors                 
            //---------------------------------------------------------------------
            for (m = 3; m <= 4; m++)
            {
                n = (m - 2) * 5 - 1;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (j = jstart; j <= jend - 2; j++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            j1 = j + 1;
                            j2 = j + 2;
                            fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                            lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                            lhs[c, k, j1, i, n + 3] = lhs[c, k, j1, i, n + 3] -
                                       lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j1, i, n + 4] = lhs[c, k, j1, i, n + 4] -
                                      lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] -
                                       lhs[c, k, j1, i, n + 2] * rhs[c, k, j, i, m];
                            lhs[c, k, j2, i, n + 2] = lhs[c, k, j2, i, n + 2] -
                                       lhs[c, k, j2, i, n + 1] * lhs[c, k, j, i, n + 4];
                            lhs[c, k, j2, i, n + 3] = lhs[c, k, j2, i, n + 3] -
                                       lhs[c, k, j2, i, n + 1] * lhs[c, k, j, i, n + 5];
                            rhs[c, k, j2, i, m] = rhs[c, k, j2, i, m] -
                                      lhs[c, k, j2, i, n + 1] * rhs[c, k, j, i, m];
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            And again the last two rows separately
                //---------------------------------------------------------------------
                j = jend - 1;
                j1 = jend;
                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                {
                    for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                    {
                        fac1 = 1.0d / lhs[c, k, j, i, n + 3];
                        lhs[c, k, j, i, n + 4] = fac1 * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j, i, n + 5] = fac1 * lhs[c, k, j, i, n + 5];
                        rhs[c, k, j, i, m] = fac1 * rhs[c, k, j, i, m];
                        lhs[c, k, j1, i, n + 3] = lhs[c, k, j1, i, n + 3] -
                                   lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 4];
                        lhs[c, k, j1, i, n + 4] = lhs[c, k, j1, i, n + 4] -
                                   lhs[c, k, j1, i, n + 2] * lhs[c, k, j, i, n + 5];
                        rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] -
                                   lhs[c, k, j1, i, n + 2] * rhs[c, k, j, i, m];
                        //---------------------------------------------------------------------
                        //              Scale the last row immediately (some of this is overkill
                        //               if this is the last cell)
                        //---------------------------------------------------------------------
                        fac2 = 1.0d / lhs[c, k, j1, i, n + 3];
                        lhs[c, k, j1, i, n + 4] = fac2 * lhs[c, k, j1, i, n + 4];
                        lhs[c, k, j1, i, n + 5] = fac2 * lhs[c, k, j1, i, n + 5];
                        rhs[c, k, j1, i, m] = fac2 * rhs[c, k, j1, i, m];


                    }
                }
            }
			
            #endregion
			
			return 0;
		} // end activate method 
		
	}

}
