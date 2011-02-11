using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.BeamWarmingMethod;
using common.orientation.X;
using common.solve.Solve;

namespace impl.sp.solve.XSolve { 
	
	public class IXSolveImpl<I, C, MTH, DIR> : BaseIXSolveImpl<I, C, MTH, DIR>, ISolve<I, C, MTH, DIR>
		where I:IInstance_SP<C>
		where C:IClass
		where MTH:IBeamWarmingMethod
		where DIR:IX
	{
		public IXSolveImpl()
		{
		}
					
		public override void compute() { 
					
		    int c, i, j, k, n, iend, jsize, ksize, i1, i2, m, buffer_size, p, istart, stage;
		    double r1, r2, d, e, sm1, sm2, fac1, fac2;
		    double[] s = new double[5];
		    double[] in_buffer_x;
		    double[] out_buffer_x;
		
		    for (stage = 0; stage < ncells; stage++)
		    {
				Forward.enterStage(stage);
				Lhs.enterStage(stage);
						
		        c = slice[stage, 0];
		
		        istart = 2;
		        iend = 2 + cell_size[c, 0] - 1;
		
		        jsize = cell_size[c, 1] + 2;
		        ksize = cell_size[c, 2] + 2;
		
				buffer_size = (jsize - start[c, 1] - end[c, 1]) *
		                      (ksize - start[c, 2] - end[c, 2]);
						
		        Input_buffer.Array = in_buffer_x = new double[22*buffer_size];
		        Output_buffer.Array = out_buffer_x = new double[22*buffer_size];
		        
		        if (stage != 0)
		        {
					Shift.initiate_recv();
					
					Lhs.compute();
					
					Shift.synchronize();
		            
		            #region read buffer
		            //---------------------------------------------------------------------
		            //            unpack the buffer                                 
		            //---------------------------------------------------------------------
		            i = istart;
		            i1 = istart + 1;
		            n = -1;
		
		            //---------------------------------------------------------------------
		            //            create a running pointer
		            //---------------------------------------------------------------------
		
		            p = 0;
		            for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		            {
		                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                {
		                    lhs[c, k, j, i, n + 2] = lhs[c, k, j, i, n + 2] -
		                             in_buffer_x[p    ] * lhs[c, k, j, i, n + 1];
		                    lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] -
		                             in_buffer_x[p + 1] * lhs[c, k, j, i, n + 1];
		                    for (m = 0; m <= 2; m++)
		                    {
		                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
		                              in_buffer_x[p + 2 + m] * lhs[c, k, j, i, n + 1];
		                    }
		                    d = in_buffer_x[p + 5];
		                    e = in_buffer_x[p + 6];
		                    for (m = 0; m <= 2; m++)
		                    {
		                        s[m] = in_buffer_x[p + 7 + m];
		                    }
		                    r1 = lhs[c, k, j, i, n + 2];
		                    lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] - d * r1;
		                    lhs[c, k, j, i, n + 4] = lhs[c, k, j, i, n + 4] - e * r1;
		                    for (m = 0; m <= 2; m++)
		                    {
		                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - s[m] * r1;
		                    }
		                    r2 = lhs[c, k, j, i1, n + 1];
		                    lhs[c, k, j, i1, n + 2] = lhs[c, k, j, i1, n + 2] - d * r2;
		                    lhs[c, k, j, i1, n + 3] = lhs[c, k, j, i1, n + 3] - e * r2;
		                    for (m = 0; m <= 2; m++)
		                    {
		                        rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] - s[m] * r2;
		                    }
		                    p = p + 10;
		                }
		            }
		
		            for (m = 3; m <= 4; m++)
		            {
		                n = (m - 2) * 5 - 1;
		                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		                {
		                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                    {
		                        lhs[c, k, j, i, n + 2] = lhs[c, k, j, i, n + 2] -
		                                 in_buffer_x[p] * lhs[c, k, j, i, n + 1];
		                        lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] -
		                                 in_buffer_x[p + 1] * lhs[c, k, j, i, n + 2];
		                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
		                                 in_buffer_x[p + 2] * lhs[c, k, j, i, n + 1];
		                        d = in_buffer_x[p + 3];
		                        e = in_buffer_x[p + 4];
		                        s[m] = in_buffer_x[p + 5];
		                        r1 = lhs[c, k, j, i, n + 2];
		                        lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] - d * r1;
		                        lhs[c, k, j, i, n + 4] = lhs[c, k, j, i, n + 4] - e * r1;
		                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - s[m] * r1;
		                        r2 = lhs[c, k, j, i1, n + 1];
		                        lhs[c, k, j, i1, n + 2] = lhs[c, k, j, i1, n + 2] - d * r2;
		                        lhs[c, k, j, i1, n + 3] = lhs[c, k, j, i1, n + 3] - e * r2;
		                        rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] - s[m] * r2;
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
		        //         is the last grid block
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
		                for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                {
		                    for (i = iend - 1; i <= iend; i++)
		                    {
		                        out_buffer_x[p] = lhs[c, k, j, i, n + 4];
		                        out_buffer_x[p + 1] = lhs[c, k, j, i, n + 5];
		                        for (m = 0; m <= 2; m++)
		                        {
		                            out_buffer_x[p + 2 + m] = rhs[c, k, j, i, m];
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
		                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                    {
		                        for (i = iend - 1; i <= iend; i++)
		                        {
		                            out_buffer_x[p] = lhs[c, k, j, i, n + 4];
		                            out_buffer_x[p + 1] = lhs[c, k, j, i, n + 5];
		                            out_buffer_x[p + 2] = rhs[c, k, j, i, m];
		                            p = p + 3;
		                        }
		                    }
		                }
		            }
		            #endregion
					
					Shift.initiate_send();
		        }
		
		
		    } // cells loop
		
		    //---------------------------------------------------------------------
		    //                         BACKSUBSTITUTION 
		    //---------------------------------------------------------------------
		
		    for (stage = ncells - 1; stage >= 0; stage--)
		    {
		        Backward.enterStage(stage);
				Matvecproduct.enterStage(stage);
						
				c = slice[stage, 0];
		
		        istart = 2;
		        iend = 2 + cell_size[c, 0] - 1;
		
		        jsize = cell_size[c, 1] + 2;
		        ksize = cell_size[c, 2] + 2; 
		
		        buffer_size = (jsize - start[c, 1] - end[c, 1]) * (ksize - start[c, 2] - end[c, 2]);
		
		        in_buffer_x = Input_buffer.Array = new double[10 * buffer_size];
		        out_buffer_x = Output_buffer.Array = new double[10 * buffer_size];
		
		        if (stage != ncells - 1)
		        {
					Shift.initiate_recv();
		
					Matvecproduct.compute();
		
					Shift.synchronize();
		
		            #region read_buffer_x_back
		
		            //---------------------------------------------------------------------
		            //            unpack the buffer for the first three factors         
		            //---------------------------------------------------------------------
		            n = -1;
		            p = 0;
		            i = iend;
		            i1 = i - 1;
		            for (m = 0; m <= 2; m++)
		            {
		                for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		                {
		                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                    {
		                        sm1 = in_buffer_x[p];
		                        sm2 = in_buffer_x[p + 1];
		                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
		                               lhs[c, k, j, i, n + 4] * sm1 -
		                               lhs[c, k, j, i, n + 5] * sm2;
		                        rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] -
		                               lhs[c, k, j, i1, n + 4] * rhs[c, k, j, i, m] -
		                               lhs[c, k, j, i1, n + 5] * sm1;
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
		                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		                    {
		                        sm1 = in_buffer_x[p];
		                        sm2 = in_buffer_x[p + 1];
		                        rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
		                               lhs[c, k, j, i, n + 4] * sm1 -
		                               lhs[c, k, j, i, n + 5] * sm2;
		                        rhs[c, k, j, i1, m] = rhs[c, k, j, i1, m] -
		                               lhs[c, k, j, i1, n + 4] * rhs[c, k, j, i, m] -
		                               lhs[c, k, j, i1, n + 5] * sm1;
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
                    i = istart;
                    i1 = istart + 1;
                    p = 0;
                    for (m = 0; m <= 4; m++)
                    {
                        for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
                        {
                            for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                            {
                                out_buffer_x[p] = rhs[c, k, j, i, m];
                                out_buffer_x[p + 1] = rhs[c, k, j, i1, m];
                                p = p + 2;
                            }
                        }
                    }
                    #endregion
					
					Shift.initiate_send();
		        }
		
		        //if (timeron) timer.stop(t_xsolve);
		
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
