using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.direction.SouthToNorth;
using lu.interactionpattern.Shift;

namespace impl.lu.interactionpattern.ShiftToNorthImpl { 
	public class IShiftToNorthImpl<DIR> : BaseIShiftToNorthImpl<DIR>, IShift<DIR>
	where DIR:ISouthToNorth {
	   private RequestList requestList = new RequestList();
	   
		public IShiftToNorthImpl() { 
		
		} 
		
		private static int from_s = 1, from_n = 2, from_e = 3, from_w = 4;
				
		public void initiate_send(){
			comm.Send<double>(Output_buffer.Array, Neighbors.north, from_s);      
		}
		
		public void initiate_recv(){
			comm.Receive<double>(Neighbors.south, from_s, Input_buffer.Array);			
		}
				
//		private Request handle_left;
//		private Request handle_right;
//				
//		public Request HandleLeft { get { return handle_left; } }
//		public Request HandleRight { get { return handle_right; } }		
		
		public override void synchronize() { 
		   
		}
	}
}
