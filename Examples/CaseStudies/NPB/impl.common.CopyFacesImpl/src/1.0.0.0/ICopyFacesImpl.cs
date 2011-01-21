using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.CopyFaces;

namespace impl.common.CopyFacesImpl { 

public class ICopyFacesImpl : BaseICopyFacesImpl, ICopyFaces
{
		
	private int ncells;

	private int[,] cell_size;
	private int[,] cell_coord;

	private double[,,,,] u;

	public void initialize() 
	{
		ncells = Problem.NCells;
		cell_size = Blocks.cell_size;
		cell_coord = Blocks.cell_coord;
			
		u = Problem.Field_u;

			
			
	}
		
	public override void synchronize() {
	  
	
		    Shift_y.synchronize();
			Shift_z.synchronize();
			Shift_x.synchronize();
			
			//-------
			
            int i, j, k, c, m, p0, p1, p2, p3, p4, p5, ksize, jsize, isize;
            Request[] requests;
            int[] b_size;

            double[][] out_buffer = new double[6][];
            double[][] in_buffer = new double[6][];

//            requests = new Request[12];
            b_size = new int[6];

            b_size[0] = east_size;
            b_size[1] = west_size;
            b_size[2] = north_size;
            b_size[3] = south_size;
            b_size[4] = top_size;
            b_size[5] = bottom_size;

            for (i = 0; i < 6; i++)
            {
                out_buffer[i] = new double[b_size[i]];
                in_buffer[i] = new double[b_size[i]];
            }


            //---------------------------------------------------------------------
            // because the difference stencil for the diagonalized scheme is 
            // orthogonal, we do not have to perform the staged copying of faces, 
            // but can send all face information simultaneously to the neighboring 
            // cells in all directions          
            //---------------------------------------------------------------------
            p0 = 0;
            p1 = 0;
            p2 = 0;
            p3 = 0;
            p4 = 0;
            p5 = 0;

            for (c = 0; c < ncells; c++)
            {
                ksize = cell_size[c, 2] + 2;
                jsize = cell_size[c, 1] + 2;
                isize = cell_size[c, 0] + 2;

                //---------------------------------------------------------------------
                //            fill the buffer to be sent to eastern neighbors (i-dir)
                //---------------------------------------------------------------------
                if (cell_coord[c, 0] != ncells - 1)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = isize - 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    out_buffer[0][p0++] = u[c, k, j, i, m];
                                }
                            }
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            fill the buffer to be sent to western neighbors 
                //---------------------------------------------------------------------
                if (cell_coord[c, 0] != 0)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = 2; i <= 3; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    out_buffer[1][p1++] = u[c, k, j, i, m];
                                }
                            }
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            fill the buffer to be sent to northern neighbors (j_dir)
                //---------------------------------------------------------------------
                if (cell_coord[c, 1] != ncells - 1)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = jsize - 2; j < jsize; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    out_buffer[2][p2++] = u[c, k, j, i, m];
                                }
                            }
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            fill the buffer to be sent to southern neighbors 
                //---------------------------------------------------------------------
                if (cell_coord[c, 1] != 0)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = 2; j <= 3; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    out_buffer[3][p3++] = u[c, k, j, i, m];
                                }
                            }
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            fill the buffer to be sent to top neighbors (k-dir)
                //---------------------------------------------------------------------
                if (cell_coord[c, 2] != ncells - 1)
                {
                    for (k = ksize - 2; k < ksize; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    out_buffer[4][p4++] = u[c, k, j, i, m];
                                }
                            }
                        }
                    }
                }

                //---------------------------------------------------------------------
                //            fill the buffer to be sent to bottom neighbors
                //---------------------------------------------------------------------
                if (cell_coord[c, 2] != 0)
                {
                    for (k = 2; k <= 3; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    out_buffer[5][p5++] = u[c, k, j, i, m];
                                }
                            }
                        }
                    }
                }
            }


            RequestList requestList = new RequestList();

            requests[0] = comm_rhs.ImmediateReceive<double>(successor[0], WEST, in_buffer[0]);
            requests[1] = comm_rhs.ImmediateReceive<double>(predecessor[0], EAST, in_buffer[1]);
            requests[2] = comm_rhs.ImmediateReceive<double>(successor[1], SOUTH, in_buffer[2]);
            requests[3] = comm_rhs.ImmediateReceive<double>(predecessor[1], NORTH, in_buffer[3]);
            requests[4] = comm_rhs.ImmediateReceive<double>(successor[2], BOTTOM, in_buffer[4]);
            requests[5] = comm_rhs.ImmediateReceive<double>(predecessor[2], TOP, in_buffer[5]);
            requests[6] = comm_rhs.ImmediateSend<double>(out_buffer[0], successor[0], EAST);
            requests[7] = comm_rhs.ImmediateSend<double>(out_buffer[1], predecessor[0], WEST);
            requests[8] = comm_rhs.ImmediateSend<double>(out_buffer[2], successor[1], NORTH);
            requests[9] = comm_rhs.ImmediateSend<double>(out_buffer[3], predecessor[1], SOUTH);
            requests[10] = comm_rhs.ImmediateSend<double>(out_buffer[4], successor[2], TOP);
            requests[11] = comm_rhs.ImmediateSend<double>(out_buffer[5], predecessor[2], BOTTOM);

            foreach (Request request in requests)
            {
                requestList.Add(request);
            }

            requestList.WaitAll();

            //---------------------------------------------------------------------
            // unpack the data that has just been received;             
            //---------------------------------------------------------------------
            p0 = 0;
            p1 = 0;
            p2 = 0;
            p3 = 0;
            p4 = 0;
            p5 = 0;

            for (c = 0; c < ncells; c++)
            {
                isize = cell_size[c, 0] + 2;
                jsize = cell_size[c, 1] + 2;
                ksize = cell_size[c, 2] + 2;

                if (cell_coord[c, 0] != 0)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = 0; i <= 1; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    u[c, k, j, i, m] = in_buffer[1][p0++];
                                }
                            }
                        }
                    }
                }

                if (cell_coord[c, 0] != ncells - 1)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = isize; i <= isize + 1; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    u[c, k, j, i, m] = in_buffer[0][p1++];
                                }
                            }
                        }
                    }
                }

                if (cell_coord[c, 1] != 0)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = 0; j <= 1; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    u[c, k, j, i, m] = in_buffer[3][p2++];
                                }
                            }
                        }
                    }
                }

                if (cell_coord[c, 1] != ncells - 1)
                {
                    for (k = 2; k < ksize; k++)
                    {
                        for (j = jsize; j <= jsize + 1; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    u[c, k, j, i, m] = in_buffer[2][p3++];
                                }
                            }
                        }
                    }
                }

                if (cell_coord[c, 2] != 0)
                {
                    for (k = 0; k <= 1; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    u[c, k, j, i, m] = in_buffer[5][p4++];
                                }
                            }
                        }
                    }
                }

                if (cell_coord[c, 2] != ncells - 1)
                {
                    for (k = ksize; k <= ksize + 1; k++)
                    {
                        for (j = 2; j < jsize; j++)
                        {
                            for (i = 2; i < isize; i++)
                            {
                                for (m = 0; m < 5; m++)
                                {
                                    u[c, k, j, i, m] = in_buffer[4][p5++];
                                }
                            }
                        }
                    }
                }

                //---------------------------------------------------------------------
                //      cells loop
                //---------------------------------------------------------------------
            }
			
	}

} 


}
