using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.direction.SouthToNorth;
using lu.interactionpattern.Shift;
using MPI;

namespace impl.lu.interactionpattern.ShiftToNorthImpl { 
	public class IShiftToNorthImpl<DIR> : BaseIShiftToNorthImpl<DIR>, IShift<DIR>
	where DIR:ISouthToNorth {
		public IShiftToNorthImpl() { 
		
		} 
		
		private static int from_s = 1;//, from_n = 2, from_e = 3, from_w = 4;
				
		public void initiate_send(){//Blocking Send
			comm.Send<double>(Output_buffer.Array, Neighbors.north, from_s);      
		}
		
		public void initiate_recv(){//Blocking Receive
			handle = comm.ImmediateReceive<double>(Neighbors.south, from_s, Input_buffer.Array);			
		    handle.Wait(); 
		}
				
		private Request handle;
		public Request Handle { get { return handle; } }

		public override void synchronize() { 
		   
		}
	}
}
