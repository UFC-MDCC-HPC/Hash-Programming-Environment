using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.solve.BeamWarmingMethod;
using common.orientation.Z;
using common.solve.Solve;

namespace impl.sp.solve.ZSolve { 

	public class IZSolveImpl<I, C, MTH, DIR> : BaseIZSolveImpl<I, C, MTH, DIR>, ISolve<I, C, MTH, DIR>
		where I:IInstance_SP<C>
		where C:IClass
		where MTH:IBeamWarmingMethod
		where DIR:IZ
	{
		public IZSolveImpl()
		{
		}
		
        private double[][] in_buffer_z_f;
        private double[][] out_buffer_z_f;
        private double[][] in_buffer_z_b;
        private double[][] out_buffer_z_b;
        private int[] buffer_size_a;            

		/* override public void initialize()
		{
		    base.initialize();
		    
		    in_buffer_z_f = new double[ncells][];
		    out_buffer_z_f = new double[ncells][];
		    in_buffer_z_b = new double[ncells][];
		    out_buffer_z_b = new double[ncells][];
		    int buffer_size;
		    
		    for (int stage = 0; stage < ncells; stage++)
            {
                int c = slice[stage, 2];

                int isize = cell_size[c, 0] + 2;
                int jsize = cell_size[c, 1] + 2;

                buffer_size = (isize - start[c, 0] - end[c, 0]) * (jsize - start[c, 1] - end[c, 1]);

                in_buffer_z_f[c] = new double[22 * buffer_size];
                out_buffer_z_f[c] = new double[22 * buffer_size];
                
                in_buffer_z_b[c] = new double[10 * buffer_size];
                out_buffer_z_b[c] = new double[10 * buffer_size];
            }
		}
		*/
		
		public override int go() 
		{ 
            int i, j, k, stage, n, isize, jsize, kend, k1, c, m, p, kstart;
            double r1, r2, d, e, sm1, sm2;
            double[] s = new double[5];
            double[] in_buffer_z;
            double[] out_buffer_z;

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
				Forward.enterStage(stage);
				
                c = slice[stage, 2];

                kstart = 2;
                kend = 2 + cell_size[c, 2] - 1;

                isize = cell_size[c, 0] + 2;
                jsize = cell_size[c, 1] + 2;

         /*       Console.WriteLine("c = " + c + ", length = in_buffer_z_f = " + in_buffer_z_f[c].Length);
                Console.WriteLine("c = " + c + ", length = out_buffer_z_f = " + out_buffer_z_f[c].Length);
                Input_buffer_forward.Array = in_buffer_z = in_buffer_z_f[c]; //= new double[22 * buffer_size];
                Output_buffer_forward.Array = out_buffer_z = out_buffer_z_f[c]; // = new double[22 * buffer_size];
*/
                isize = cell_size[c, 0] + 2;
                jsize = cell_size[c, 1] + 2;

                int buffer_size = (isize - start[c, 0] - end[c, 0]) * (jsize - start[c, 1] - end[c, 1]);
                
                                
                Input_buffer_forward.Array = in_buffer_z = new double[22 * buffer_size];
                Output_buffer_forward.Array = out_buffer_z = new double[22 * buffer_size];

                //Console.WriteLine("c = " + c + ", length = in_buffer_z_f = " + in_buffer_z.Length);
                //Console.WriteLine("c = " + c + ", length = out_buffer_z_f = " + out_buffer_z.Length);
                
                if (stage != 0)
                {
					Shift_forward.initiate_recv();

					Lhs.go();
					
					Shift_forward.go();

                    #region read buffer
                    //---------------------------------------------------------------------
                    //            unpack the buffer                                 
                    //---------------------------------------------------------------------
                    k = kstart;
                    k1 = kstart + 1;
                    n = -1;

                    //---------------------------------------------------------------------
                    //            create a running pointer
                    //---------------------------------------------------------------------
                    p = 0;
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            lhs[c, k, j, i, n + 2] = lhs[c, k, j, i, n + 2] -
                                     in_buffer_z[p] * lhs[c, k, j, i, n + 1];
                            lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] -
                                     in_buffer_z[p + 1] * lhs[c, k, j, i, n + 1];
                            for (m = 0; m <= 2; m++)
                            {
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                      in_buffer_z[p + 2 + m] * lhs[c, k, j, i, n + 1];
                            }
                            d = in_buffer_z[p + 5];
                            e = in_buffer_z[p + 6];
                            for (m = 0; m <= 2; m++)
                            {
                                s[m] = in_buffer_z[p + 7 + m];
                            }
                            r1 = lhs[c, k, j, i, n + 2];
                            lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] - d * r1;
                            lhs[c, k, j, i, n + 4] = lhs[c, k, j, i, n + 4] - e * r1;
                            for (m = 0; m <= 2; m++)
                            {
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - s[m] * r1;
                            }
                            r2 = lhs[c, k1, j, i, n + 1];
                            lhs[c, k1, j, i, n + 2] = lhs[c, k1, j, i, n + 2] - d * r2;
                            lhs[c, k1, j, i, n + 3] = lhs[c, k1, j, i, n + 3] - e * r2;
                            for (m = 0; m <= 2; m++)
                            {
                                rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] - s[m] * r2;
                            }
                            p = p + 10;
                        }
                    }

                    for (m = 3; m <= 4; m++)
                    {
                        n = (m - 2) * 5 - 1;
                        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                lhs[c, k, j, i, n + 2] = lhs[c, k, j, i, n + 2] -
                                         in_buffer_z[p] * lhs[c, k, j, i, n + 1];
                                lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] -
                                         in_buffer_z[p + 1] * lhs[c, k, j, i, n + 1];
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                         in_buffer_z[p + 2] * lhs[c, k, j, i, n + 1];
                                d = in_buffer_z[p + 3];
                                e = in_buffer_z[p + 4];
                                s[m] = in_buffer_z[p + 5];
                                r1 = lhs[c, k, j, i, n + 2];
                                lhs[c, k, j, i, n + 3] = lhs[c, k, j, i, n + 3] - d * r1;
                                lhs[c, k, j, i, n + 4] = lhs[c, k, j, i, n + 4] - e * r1;
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - s[m] * r1;
                                r2 = lhs[c, k1, j, i, n + 1];
                                lhs[c, k1, j, i, n + 2] = lhs[c, k1, j, i, n + 2] - d * r2;
                                lhs[c, k1, j, i, n + 3] = lhs[c, k1, j, i, n + 3] - e * r2;
                                rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] - s[m] * r2;
                                p = p + 6;
                            }
                        }
                    }
                    #endregion
                }
                else
                {
					Lhs.go();
                }

				Forward.go();

                //---------------------------------------------------------------------
                //         send information to the next processor, except when this
                //         is the last grid block,
                //---------------------------------------------------------------------

                if (stage != ncells - 1)
                {					
                    #region write buffer
                    //---------------------------------------------------------------------
                    //            create a running pointer for the send buffer  
                    //---------------------------------------------------------------------
                    p = 0;
                    n = -1;
                    for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                    {
                        for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                        {
                            for (k = kend - 1; k <= kend; k++)
                            {
                                out_buffer_z[p    ] = lhs[c, k, j, i, n + 4];
                                out_buffer_z[p + 1] = lhs[c, k, j, i, n + 5];
                                for (m = 0; m <= 2; m++)
                                {
                                    out_buffer_z[p + 2 + m] = rhs[c, k, j, i, m];
                                }
                                p = p + 5;
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
                                for (k = kend - 1; k <= kend; k++)
                                {
                                    out_buffer_z[p] = lhs[c, k, j, i, n + 4];
                                    out_buffer_z[p + 1] = lhs[c, k, j, i, n + 5];
                                    out_buffer_z[p + 2] = rhs[c, k, j, i, m];
                                    p = p + 3;
                                }
                            }
                        }
                    }

                    #endregion
					
					Shift_forward.initiate_send();
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
				Backward.enterStage(stage);
				
                c = slice[stage, 2];

                kstart = 2;
                kend = 2 + cell_size[c, 2] - 1;

                isize = cell_size[c, 0] + 2;
                jsize = cell_size[c, 1] + 2;

                /* Console.WriteLine("c = " + c + ", length = in_buffer_z_b = " + in_buffer_z_b[c].Length);
                Console.WriteLine("c = " + c + ", length = out_buffer_z_b = " + out_buffer_z_b[c].Length);
                Input_buffer_backward.Array = in_buffer_z = in_buffer_z_b[c]; //new double[10 * buffer_size];
                Output_buffer_backward.Array = out_buffer_z = out_buffer_z_b[c]; //new double[10 * buffer_size];
                */
                int buffer_size = (isize - start[c, 0] - end[c, 0]) *  (jsize - start[c, 1] - end[c, 1]);

                Input_buffer_backward.Array = in_buffer_z = new double[10 * buffer_size];
                Output_buffer_backward.Array = out_buffer_z = new double[10 * buffer_size];
                

                if (stage != ncells - 1)
                {
					Shift_backward.initiate_recv();

				    Matvecproduct.enterStage(stage + 1);
					Matvecproduct.go(); //tzetar

					Shift_backward.go();

                    #region read buffer
                    //---------------------------------------------------------------------
                    //            unpack the buffer for the first three factors         
                    //---------------------------------------------------------------------
                    n = -1;
                    p = 0;
                    k = kend;
                    k1 = k - 1;
                    for (m = 0; m <= 2; m++)
                    {
                        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
		                 //       Console.WriteLine("in_buffer_z["+ p + "] = " + in_buffer_z[p]);
		                 //       Console.WriteLine("in_buffer_z["+ (p+1) + "] = " + in_buffer_z[p+1]);
                                sm1 = in_buffer_z[p];
                                sm2 = in_buffer_z[p + 1];
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                       lhs[c, k, j, i, n + 4] * sm1 -
                                       lhs[c, k, j, i, n + 5] * sm2;
                                rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] -
                                       lhs[c, k1, j, i, n + 4] * rhs[c, k, j, i, m] -
                                       lhs[c, k1, j , i, n + 5] * sm1;
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
                        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
		        //                Console.WriteLine("in_buffer_z["+ p + "] = " + in_buffer_z[p]);
		         //               Console.WriteLine("in_buffer_z["+ (p+1) + "] = " + in_buffer_z[p+1]);
                                sm1 = in_buffer_z[p];
                                sm2 = in_buffer_z[p + 1];
                                rhs[c, k, j, i, m] = rhs[c, k, j, i, m] -
                                       lhs[c, k, j, i, n + 4] * sm1 -
                                       lhs[c, k, j, i, n + 5] * sm2;
                                rhs[c, k1, j, i, m] = rhs[c, k1, j, i, m] -
                                       lhs[c, k1, j, i, n + 4] * rhs[c, k, j, i, m] -
                                       lhs[c, k1, j , i, n + 5] * sm1;
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
				
				Backward.go();

                //---------------------------------------------------------------------
                //         send on information to the previous processor, if needed
                //---------------------------------------------------------------------
                if (stage != 0)
                {
                    #region write buffer
                    k = kstart;
                    k1 = kstart + 1;
                    p = 0;
                    for (m = 0; m <= 4; m++)
                    {
                        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
                        {
                            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
                            {
                                out_buffer_z[p] = rhs[c, k, j, i, m];
                                out_buffer_z[p + 1] = rhs[c, k1, j, i, m];
                                p = p + 2;
                            }
                        }
                    }
                    #endregion
					
					Shift_backward.initiate_send();
                }

                // if (timeron) timer.stop(t_zsolve);

                //---------------------------------------------------------------------
                //         If this was the last stage, do the block-diagonal inversion
                //---------------------------------------------------------------------
                if (stage == 0)
                {
                    Matvecproduct.enterStage(stage);
					Matvecproduct.go(); // tzetar
                }

            }
			return 0;
		} // end activate method 
		
	}

}
