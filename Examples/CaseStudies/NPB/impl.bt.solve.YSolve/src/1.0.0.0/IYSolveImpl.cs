using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.Solve;

namespace impl.bt.solve.YSolve { 
	public class IYSolveImpl<I, C, DIR, MTH> : BaseIYSolveImpl<I, C, DIR, MTH>, ISolve<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IY
	where MTH:IBeamWarmingMethod {	
		public IYSolveImpl() { 		
		} 		
		public override void compute() { 
            int c, stage, first, last, buffer_size;
            buffer_size = MAX_CELL_DIM * MAX_CELL_DIM * (5 * 5 + 5);
            double[] out_buffer_y = new double[buffer_size];
            double[] out_buffer_x = new double[buffer_size];
            double[, , , , ,] lhsc = new double[maxcells, KMAX+2, JMAX+2, IMAX+2, 5, 5];
            double[, , ,] backsub_info = new double[maxcells, MAX_CELL_DIM+3, MAX_CELL_DIM+3, 5];
            for(stage = 0; stage < ncells; stage++) {
                c = slice[stage, 1];
                if(stage == ncells-1) {
                    last = 1;
                }
                else {
                    last = 0;
                }
                if(stage == 0) {
                    first = 1;
                    Solve_cell.setParameters(lhsc, first, last, c);
                    Solve_cell.compute();
                }
                else {
                    first = 0;
                    int ip = cell_coord[c,0];
                    int kp = cell_coord[c,2];
			        Shift.initiate_recv();
			        Shift.synchronize();                    
                    //requests[0] = comm_solve.ImmediateReceive<double>(predecessor[1], SOUTH+ip+kp*ncells, out_buffer_y);
                    //requests[1].Wait();
                    //requests[0].Wait();
                    Unpack_solve_info.setParameters(lhsc, out_buffer_y, c);
                    Unpack_solve_info.compute();
                    Solve_cell.setParameters(lhsc, first, last, c); 
                    Solve_cell.compute();
                }
                if(last == 0) {
                    int ip = cell_coord[c,0];
                    int kp = cell_coord[c,2];
                    double[] in_buffer_y = new double[buffer_size];
                    Pack_solve_info.setParameters(lhsc, in_buffer_y, c);
                    Pack_solve_info.compute();
			        Shift.initiate_send();                    
                    //requests[1] = comm_solve.ImmediateSend<double>(in_buffer_y, successor[1], SOUTH+ip+kp*ncells);
                }
            }
            out_buffer_y = null;
            buffer_size = MAX_CELL_DIM * MAX_CELL_DIM * 5;
            out_buffer_y = new double[buffer_size];
            for(stage = ncells-1; stage >= 0; stage--) {  
                c = slice[stage, 1];
                first = 0;
                last = 0;
                if(stage == 0)
                    first = 1;
                if(stage == ncells-1) {
                    last = 1;
                    Back_substitute.setParameters(lhsc, backsub_info, first, last, c);
                    Back_substitute.compute();
                }
                else {
                    int ip = cell_coord[c, 0];
                    int kp = cell_coord[c, 2];
			        Shift.initiate_recv();
			        Shift.synchronize();                    
                    //requests[0] = comm_solve.ImmediateReceive<double>(successor[1], NORTH+ip+kp*ncells, out_buffer_y);
                    //requests[1].Wait();
                    //requests[0].Wait();
                    Unpack_back_sub_info.setParameters(backsub_info, out_buffer_y, c);
                    Unpack_back_sub_info.compute();
                    Back_substitute.setParameters(lhsc, backsub_info, first, last, c);
                    Back_substitute.compute();
                }
                if(first == 0) {
                    int ip = cell_coord[c,0];
                    int kp = cell_coord[c,2];                    
                    double[] in_buffer_y = new double[buffer_size];
                    Pack_back_sub_info.setParameters(in_buffer_y, c);
                    Pack_back_sub_info.compute(); 
			        Shift.initiate_send();
                    //requests[1] = comm_solve.ImmediateSend<double>(in_buffer_y, predecessor[1], NORTH+ip+kp*ncells);
                }
            }
		}
	}
}
