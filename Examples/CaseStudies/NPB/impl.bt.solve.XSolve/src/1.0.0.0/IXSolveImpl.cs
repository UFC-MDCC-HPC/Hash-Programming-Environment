using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.Solve;

namespace impl.bt.solve.XSolve 
{ 
	public class IXSolveImpl<I, C, DIR, MTH> : BaseIXSolveImpl<I, C, DIR, MTH>, ISolve<I, C, DIR, MTH>
		where I:IInstance_BT<C>
		where C:IClass
		where DIR:IX
		where MTH:IBeamWarmingMethod 
	{
		public override int go()   
		{ 
			int c, stage, first, last, buffer_size;
			buffer_size = MAX_CELL_DIM * MAX_CELL_DIM * (5 * 5 + 5);
			double[] out_buffer_x;// = new double[buffer_size];
			double[,,,,,] lhsc = new double[maxcells, KMAX+2, JMAX+2, IMAX+2, 5, 5];
			double[,,,] backsub_info = new double[maxcells, MAX_CELL_DIM+3, MAX_CELL_DIM+3, 5];
			
			Input_buffer.Array = out_buffer_x = new double[buffer_size];
			
			for(stage = 0; stage < ncells; stage++) 
			{
			    c = slice[stage, 0];
			    if(stage == ncells-1) 
			    {
			        last = 1;
			    }
			    else 
			    {
			        last = 0;
			    }
			    
			    if(stage == 0) 
			    {
			        first = 1;
			        Solve_cell.setParameters(lhsc, first, last, c);
			        Solve_cell.go();
			    }
			    else 
			    {
			        first = 0;
			        int jp = cell_coord[c,1];
			        int kp = cell_coord[c,2];
			        Shift_lr.initiate_recv();
			        Shift_lr.go();
			        //requests[0] = comm_solve.ImmediateReceive<double>(predecessor[0], WEST + jp + kp * ncells, out_buffer_x); 
			        //requests[1].Wait(); 
			        //requests[0].Wait(); 
			        Unpack_solve_info.setParameters(lhsc, out_buffer_x, c);
			        Unpack_solve_info.go();
			        Solve_cell.setParameters(lhsc, first, last, c);
			        Solve_cell.go();
			    }
			    
			    if(last == 0) 
			    {
			        double[] in_buffer_x = Output_buffer.Array = new double[buffer_size];
			        Pack_solve_info.setParameters(lhsc, in_buffer_x, c);
			        Pack_solve_info.go();
			        //int jp = cell_coord[c,1];
			        //int kp = cell_coord[c,2];
			        Shift_lr.initiate_send();
			        //requests[1] = comm_solve.ImmediateSend<double>(in_buffer_x, successor[0], WEST+jp+kp*ncells);
			    }
			}
			
			Input_buffer.Array = out_buffer_x = null;
			buffer_size = MAX_CELL_DIM * MAX_CELL_DIM * 5;
			Input_buffer.Array = out_buffer_x = new double[buffer_size];
			
			for(stage = ncells-1; stage >= 0; stage--) 
			{
			    c = slice[stage, 0];
			    first = 0;
			    last = 0;
			    
			    if(stage == 0)
			        first = 1;
			        
			    if(stage == (ncells-1)) 
			    {
			        last = 1;
			        Back_substitute.setParameters(lhsc, backsub_info, first, last, c);
			        Back_substitute.go();
			    }
			    else 
			    {
			       // int jp = cell_coord[c,1];
			       // int kp = cell_coord[c,2];
				    Shift_rl.initiate_recv();
			        Shift_rl.go();		        
			        //requests[0] = comm_solve.ImmediateReceive<double>(successor[0], EAST+jp+kp*ncells, out_buffer_x); 
			        //requests[1].Wait(); 
			        //requests[0].Wait(); 
			        Unpack_back_sub_info.setParameters(backsub_info, out_buffer_x, c);
			        Unpack_back_sub_info.go();
			        Back_substitute.setParameters(lhsc, backsub_info, first, last, c);
			        Back_substitute.go();
			    }
			    
			    if(first == 0) 
			    {
			      //  int jp = cell_coord[c,1];
			       // int kp = cell_coord[c,2];
			        double[] in_buffer_x = Output_buffer.Array = new double[buffer_size];
			        Pack_back_sub_info.setParameters(in_buffer_x, c);
			        Pack_back_sub_info.go();
			        Shift_rl.initiate_send();
			        //requests[1] = comm_solve.ImmediateSend<double>(in_buffer_x, predecessor[0], EAST+jp+kp*ncells);                    
			    }
			}
			
			return 0;
		}
	}
}

