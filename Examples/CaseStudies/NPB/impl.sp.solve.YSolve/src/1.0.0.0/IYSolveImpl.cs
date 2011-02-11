using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.BeamWarmingMethod;
using common.orientation.Y;
using common.solve.Solve;

namespace impl.sp.solve.YSolve { 

	public class IYSolveImpl<I, C, MTH, DIR> : BaseIYSolveImpl<I, C, MTH, DIR>, ISolve<I, C, MTH, DIR>
		where I:IInstance_SP<C>
		where C:IClass
		where MTH:IBeamWarmingMethod
		where DIR:IY
	{
		public IYSolveImpl()
		{
		}
			
		public override void compute() { 
            int i, j, k, stage, n, isize, jend, ksize, j1, buffer_size, c, m, p, jstart; /* requests(2), statuses(MPI_STATUS_SIZE, 2);*/
            double r1, r2, d, e, sm1, sm2;
            double[] s = new double[5];
            double[] in_buffer_y;
            double[] out_buffer_y;

            //---------------------------------------------------------------------
            //---------------------------------------------------------------------

            // if (timeron) timer.start(t_ysolve);

            //---------------------------------------------------------------------
            // now do a sweep on a layer-by-layer basis, i.e. sweeping through cells
            // on this node in the direction of increasing i for the forward sweep,
            // and after that reversing the direction for the backsubstitution  
            //---------------------------------------------------------------------

            //---------------------------------------------------------------------
            //                          FORWARD ELIMINATION  
            //---------------------------------------------------------------------
            for (stage = 0; stage < ncells; stage++)
            {
				Lhs.enterStage(stage);
				Backward.enterStage(stage);
				
                c = slice[stage, 1];

                jstart = 2;
                jend = 2 + cell_size[c, 1] - 1;

                isize = cell_size[c, 0] + 2;
                ksize = cell_size[c, 2] + 2;

                buffer_size = (isize - start[c, 0] - end[c, 0]) * (ksize - start[c, 2] - end[c, 2]);

                Input_buffer.Array = in_buffer_y = new double[22*buffer_size];
                Output_buffer.Array = out_buffer_y = new double[22*buffer_size];

                if (stage != 0)
                {
					Shift.initiate_recv();

					Lhs.compute();

					Shift.synchronize();

                    #region read buffer
                    //---------------------------------------------------------------------
                    //            unpack the buffer                                 
                    //---------------------------------------------------------------------
                    j = jstart;
                    j1 = jstart + 1;
                    n = -1;
                    //---------------------------------------------------------------------
                    //            create a running pointer
                    //---------------------------------------------------------------------
                    p = 0;
                    for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            lhs[c, k, j, i, n + 2] = lhs[c, k, j, i, n + 2] -
                                    in_buffer_y[p] * lhs[c, k, j, i, n + 1];
                            lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] -
                                    in_buffer_y[p + 1] * lhs[c, k, j, i, n + 1];
                            for (m = 0; m <= 2; m++)
                            {
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                      in_buffer_y[p + 2 + m] * lhs[c, k, j, i, n + 1];
                            }
                            d = in_buffer_y[p + 5]; ;
                            e = in_buffer_y[p + 6];
                            for (m = 0; m <= 2; m++)
                            {
                                s[m] = in_buffer_y[p + 7 + m];
                            }
                            r1 = lhs[c, k, j, i, n + 2];
                            lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] - d * r1;
                            lhs[c, k, j, i, n + 4] = lhs[c, k, j, i, n + 4] - e * r1;
                            for (m = 0; m <= 2; m++)
                            {
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - s[m] * r1;
                            }
                            r2 = lhs[c, k, j1, i, n+1];
                            lhs[c, k, j1, i, n + 2] = lhs[c, k, j1, i, n + 2] - d * r2;
                            lhs[c, k, j1, i, n + 3] = lhs[c, k, j1, i, n + 3] - e * r2;
                            for (m = 0; m <= 2; m++)
                            {
                                rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] - s[m] * r2;
                            }
                            p = p + 10;
                        }
                    }

                    for (m = 3; m <= 4; m++)
                    {
                        n = (m - 2) * 5 - 1;
                        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                lhs[c, k, j, i, n + 2] = lhs[c, k, j, i, n + 2] -
                                         in_buffer_y[p] * lhs[c, k, j, i, n + 1];
                                lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] -
                                         in_buffer_y[p + 1] * lhs[c, k, j, i, n + 1];
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                         in_buffer_y[p + 2] * lhs[c, k, j, i, n + 1];
                                d = in_buffer_y[p + 3];
                                e = in_buffer_y[p + 4];
                                s[m] = in_buffer_y[p + 5];
                                r1 = lhs[c, k, j, i, n + 2];
                                lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] - d * r1;
                                lhs[c, k, j, i, n + 4] = lhs[c, k, j, i, n + 4] - e * r1;
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - s[m] * r1;
                                r2 = lhs[c, k, j1, i, n + 1];
                                lhs[c, k, j1, i, n + 2] = lhs[c, k, j1, i, n + 2] - d * r2;
                                lhs[c, k, j1, i, n + 3] = lhs[c, k, j1, i, n + 3] - e * r2;
                                rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] - s[m] * r2;
                                p = p + 6;
                            }
                        }
                    }
                    #endregion
                }
                else
                {
					Lhs.compute();
                }

				Forward.compute();

                //---------------------------------------------------------------------
                //         send information to the next processor, except when this
                //         is the last grid block;
                //---------------------------------------------------------------------

                if (stage != ncells - 1)
                {
                    #region write buffer
                    //---------------------------------------------------------------------
                    //            create a running pointer for the send buffer  
                    //---------------------------------------------------------------------
                    p = 0;
                    n = -1;
                    for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            for (j = jend - 1; j <= jend; j++)
                            {
                                out_buffer_y[p    ] = lhs[c, k, j, i, n + 4];
                                out_buffer_y[p + 1] = lhs[c, k, j, i, n + 5];
                                for (m = 0; m <= 2; m++)
                                {
                                    out_buffer_y[p + 2 + m] = rhs[c, k, j, i, m];
                                }
                                p = p + 5;
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
                                for (j = jend - 1; j <= jend; j++)
                                {
                                    out_buffer_y[p] = lhs[c, k, j, i, n + 4];
                                    out_buffer_y[p + 1] = lhs[c, k, j, i, n + 5];
                                    out_buffer_y[p + 2] = rhs[c, k, j, i, m];
                                    p = p + 3;
                                }
                            }
                        }
                    }

                    #endregion
					
					Shift.initiate_send();
                }
            }

            //---------------------------------------------------------------------
            //      now go in the reverse direction                      
            //---------------------------------------------------------------------

            //---------------------------------------------------------------------
            //                         BACKSUBSTITUTION 
            //---------------------------------------------------------------------
            for (stage = ncells - 1; stage >= 0; stage--)
            {
				Matvecproduct.enterStage(stage);
				Backward.enterStage(stage);
				
                c = slice[stage, 1];

                jstart = 2;
                jend = 2 + cell_size[c, 1] - 1;

                isize = cell_size[c, 0] + 2;
                ksize = cell_size[c, 2] + 2;

                buffer_size = (isize - start[c, 0] - end[c, 0]) *
                             (ksize - start[c, 2] - end[c, 2]);

                Input_buffer.Array = in_buffer_y = new double[10 * buffer_size];
                Output_buffer.Array = out_buffer_y = new double[10 * buffer_size];

                if (stage != ncells - 1)
                {
					Shift.initiate_recv();
					
					Matvecproduct.compute();

					Shift.synchronize();

                    #region read_buffer
                    //---------------------------------------------------------------------
                    //            unpack the buffer for the first three factors         
                    //---------------------------------------------------------------------
                    n = -1;
                    p = 0;
                    j = jend;
                    j1 = j - 1;
                    for (m = 0; m <= 2; m++)
                    {
                        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                sm1 = in_buffer_y[p];
                                sm2 = in_buffer_y[p + 1];
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                       lhs[c, k, j, i, n + 4] * sm1 -
                                       lhs[c, k, j, i, n + 5] * sm2;
                                rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] -
                                       lhs[c, k, j1, i, n + 4] * rhs[c, k, j, i, m] -
                                       lhs[c, k, j1, i, n + 5] * sm1;
                                p = p + 2;
                            }
                        }
                    }

                    //---------------------------------------------------------------------
                    //            now unpack the buffer for the remaining two factors
                    //---------------------------------------------------------------------
                    for (m = 3; m <= 4; m++)
                    {
                        n = (m - 2) * 5 - 1;
                        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                sm1 = in_buffer_y[p];
                                sm2 = in_buffer_y[p + 1];
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                       lhs[c, k, j, i, n + 4] * sm1 -
                                       lhs[c, k, j, i, n + 5] * sm2;
                                rhs[c, k, j1, i, m] = rhs[c, k, j1, i, m] -
                                       lhs[c, k, j1, i, n + 4] * rhs[c, k, j, i, m] -
                                       lhs[c, k, j1, i, n + 5] * sm1;
                                p = p + 2;
                            }
                        }
                    }
                    #endregion
                }
                else
                {
					Backward.init();
                }

				Backward.compute();

                //---------------------------------------------------------------------
                //         send on information to the previous processor, if needed
                //---------------------------------------------------------------------
                if (stage != 0)
                {
                    #region write buffer

                    j = jstart;
                    j1 = jstart + 1;
                    p = 0;
                    for (m = 0; m <= 4; m++)
                    {
                        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                out_buffer_y[p] = rhs[c, k, j, i, m];
                                out_buffer_y[p + 1] = rhs[c, k, j1, i, m];
                                p = p + 2;
                            }
                        }
                    }

                    #endregion
					
					Shift.initiate_send();
                }

                //---------------------------------------------------------------------
                //         If this was the last stage, do the block-diagonal inversion          
                //---------------------------------------------------------------------
                if (stage == 0)
                {
					Matvecproduct.compute();
                }

            }
		
		} // end activate method 
		
	}

}
