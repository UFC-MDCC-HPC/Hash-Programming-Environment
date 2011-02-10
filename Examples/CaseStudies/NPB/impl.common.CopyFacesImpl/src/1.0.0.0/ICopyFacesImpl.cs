using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.CopyFaces;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace impl.common.CopyFacesImpl { 

public class ICopyFacesImpl<I,C> : BaseICopyFacesImpl<I,C>, ICopyFaces<I,C>
		where I:IInstance<C>
		where C:IClass
{
		
	public ICopyFacesImpl() 
	{
		initialize();
    }
		
	private int ncells;

	private int[,] cell_size;
	private int[,] cell_coord;

	private double[,,,,] u;

    private double[][] out_buffer = new double[6][];
    private double[][] in_buffer = new double[6][];
		
    private int east_size;
    private int west_size;
    private int north_size;
    private int south_size;
    private int top_size;
    private int bottom_size;		
		
	public void initialize() 
	{
		ncells = Problem.NCells;
		cell_size = Blocks.cell_size;
		cell_coord = Blocks.cell_coord;		
			
		u = Problem.Field_u;
			
		compute_buffer_size(5);
			
		create_buffers();			
	}
		
	private void compute_buffer_size(int dim) 
	{
        int c, face_size;

        if (ncells == 1) return;

        //---------------------------------------------------------------------
        //      compute the actual sizes of the buffers; note that there is 
        //      always one cell face that does not need buffer space, because it 
        //      is at the boundary of the grid
        //---------------------------------------------------------------------

        west_size = 0;
        east_size = 0;

        for (c = 0; c < ncells; c++)
        {
            face_size = cell_size[c, 1] * cell_size[c, 2] * dim * 2;
            if (cell_coord[c, 0] != 0) west_size = west_size + face_size;
            if (cell_coord[c, 0] != ncells - 1) east_size = east_size + face_size;
        }

        north_size = 0;
        south_size = 0;
        for (c = 0; c < ncells; c++)
        {
            face_size = cell_size[c, 0] * cell_size[c, 2] * dim * 2;
            if (cell_coord[c, 1] != 0) south_size = south_size + face_size;
            if (cell_coord[c, 1] != ncells - 1) north_size = north_size + face_size;
        }

        top_size = 0;
        bottom_size = 0;
        for (c = 0; c < ncells; c++)
        {
            face_size = cell_size[c, 0] * cell_size[c, 1] * dim * 2;
            if (cell_coord[c, 2] != 0) bottom_size = bottom_size + face_size;
            if (cell_coord[c, 2] != ncells - 1) top_size = top_size + face_size;
        }		
	}
		
	private void create_buffers() 
	{
		out_buffer[0] = Output_buffer_x_east.Array = new double[east_size];	
		out_buffer[1] = Output_buffer_x_west.Array = new double[west_size];	
		out_buffer[2] = Output_buffer_y_north.Array = new double[north_size];	
		out_buffer[3] = Output_buffer_y_south.Array = new double[south_size];	
		out_buffer[4] = Output_buffer_z_top.Array = new double[top_size];	
		out_buffer[5] = Output_buffer_z_bottom.Array = new double[bottom_size];	
			
		in_buffer[0] = Input_buffer_x_east.Array = new double[east_size];	
		in_buffer[1] = Input_buffer_x_west.Array = new double[west_size];	
		in_buffer[2] = Input_buffer_y_north.Array = new double[north_size];	
		in_buffer[3] = Input_buffer_y_south.Array = new double[south_size];	
		in_buffer[4] = Input_buffer_z_top.Array = new double[top_size];	
		in_buffer[5] = Input_buffer_z_bottom.Array = new double[bottom_size];				
	}
		
	public override void synchronize() {
	  
			
            int i, j, k, c, m, p0, p1, p2, p3, p4, p5, ksize, jsize, isize;

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


    /*        RequestList requestList = new RequestList(); 

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
    */
			Interact.initiate_recv_west();
			Interact.initiate_recv_east();
			Interact.initiate_recv_south();
			Interact.initiate_recv_north();
			Interact.initiate_recv_bottom();
			Interact.initiate_recv_top();
			
			Interact.initiate_send_east();
			Interact.initiate_send_west();
			Interact.initiate_send_north();
			Interact.initiate_send_south();
			Interact.initiate_send_top();
			Interact.initiate_send_bottom();
			
			Interact.synchronize();
			

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
