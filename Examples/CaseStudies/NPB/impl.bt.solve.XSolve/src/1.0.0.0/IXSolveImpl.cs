using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.Solve;

namespace impl.bt.solve.XSolve { 
	public class IXSolveImpl<I, C, DIR, MTH> : BaseIXSolveImpl<I, C, DIR, MTH>, ISolve<I, C, DIR, MTH>
	where I:IInstance_BT<C>
	where C:IClass
	where DIR:IX
	where MTH:IBeamWarmingMethod {
		public IXSolveImpl() { 
		} 
		public override void compute() { 
			int c, stage, first, last, buffer_size;
			buffer_size = MAX_CELL_DIM * MAX_CELL_DIM * (5 * 5 + 5);
			MPI.Request[] requests = new MPI.Request[2] { null, null };
			double[] out_buffer_x = new double[buffer_size];
			double[,,,,,] lhsc = new double[maxcells, KMAX+2, JMAX+2, IMAX+2, 5, 5];
			double[,,,] backsub_info = new double[maxcells, MAX_CELL_DIM+3, MAX_CELL_DIM+3, 5];
			for(stage = 0; stage < ncells; stage++) {
			    c = slice[stage, 0];
			    if(stage == ncells-1) {
			        last = 1;
			    }
			    else {
			        last = 0;
			    }
			    if(stage == 0) {
			        first = 1;
			        x_solve_cell(lhsc, first, last, c);
			    }
			    else {
			        first = 0;
			        int jp = cell_coord[c,1];
			        int kp = cell_coord[c,2];
			        //requests[0] = comm_solve.ImmediateReceive<double>(predecessor[0], WEST + jp + kp * ncells, out_buffer_x); 
			        //requests[1].Wait(); 
			        //requests[0].Wait(); 
			        Unpack_solve_info(lhsc, out_buffer_x, c);
			        Solve_cell(lhsc, first, last, c);
			    }
			    if(last == 0) {
			        double[] in_buffer_x = new double[buffer_size];
			        x_pack_solve_info(lhsc, in_buffer_x, c); 
			        int jp = cell_coord[c,1];
			        int kp = cell_coord[c,2];
			        //requests[1] = comm_solve.ImmediateSend<double>(in_buffer_x, successor[0], WEST+jp+kp*ncells);
			    }
			}
			out_buffer_x = null;
			buffer_size = MAX_CELL_DIM * MAX_CELL_DIM * 5;
			out_buffer_x = new double[buffer_size];
			for(stage = ncells-1; stage >= 0; stage--) {
			    c = slice[stage, 0];
			    first = 0;
			    last = 0;
			    if(stage == 0)
			        first = 1;
			    if(stage == (ncells-1)) {
			        last = 1;
			        Back_substitute(lhsc, backsub_info, first, last, c);
			    }
			    else {
			        int jp = cell_coord[c,1];
			        int kp = cell_coord[c,2];
			        //requests[0] = comm_solve.ImmediateReceive<double>(successor[0], EAST+jp+kp*ncells, out_buffer_x); 
			        //requests[1].Wait(); 
			        //requests[0].Wait(); 
			        Unpack_back_sub_info(backsub_info, out_buffer_x, c);
			        Back_substitute(lhsc, backsub_info, first, last, c);
			    }
			    if(first == 0) {
			        int jp = cell_coord[c,1];
			        int kp = cell_coord[c,2];
			        double[] in_buffer_x = new double[buffer_size];
			        Pack_back_sub_info(in_buffer_x, c); 
			        //requests[1] = comm_solve.ImmediateSend<double>(in_buffer_x, predecessor[0], EAST+jp+kp*ncells);                    
			    }
			}
		}
	}
}
