using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.direction.NorthToSouth;
using lu.interactionpattern.Shift;
using MPI;

namespace impl.lu.interactionpattern.ShiftToSouthImpl { 
	public class IShiftToSouthImpl<DIR> : BaseIShiftToSouthImpl<DIR>, IShift<DIR>
	where DIR:INorthToSouth {
		public IShiftToSouthImpl() { 
		
		} 
		
		public override int go() { 
			return 0;

		
		}
		
		private static int from_n = 2;//from_s = 1, from_e = 3, from_w = 4;
				
		public void initiate_send(){//Blocking Send
			comm.Send<double>(Output_buffer.Array, Neighbors.south, from_n);      
		}
		
		public void initiate_recv(){//Blocking Receive
			handle = comm.ImmediateReceive<double>(Neighbors.north, from_n, Input_buffer.Array);			
		    handle.Wait(); 
		}
				
		private Request handle;
		public Request Handle { get { return handle; } }
	}
}
