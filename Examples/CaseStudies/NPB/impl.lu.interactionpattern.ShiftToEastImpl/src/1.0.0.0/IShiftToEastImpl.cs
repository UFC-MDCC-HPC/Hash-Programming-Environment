using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.direction.WestToEast;
using lu.interactionpattern.Shift;
using MPI;

namespace impl.lu.interactionpattern.ShiftToEastImpl { 
	public class IShiftToEastImpl<DIR> : BaseIShiftToEastImpl<DIR>, IShift<DIR>
	where DIR:IWestToEast {
	
		public IShiftToEastImpl() { 
		
		} 
		
		public override int go() { 
			return 0;
		
		} 
		
		private static int from_w = 4; //from_s = 1, from_n = 2, from_e = 3;
				
		public void initiate_send(){//Blocking Send
			comm.Send<double>(Output_buffer.Array, Neighbors.east, from_w);      
		}
		
		public void initiate_recv(){//Blocking Receive
			handle = comm.ImmediateReceive<double>(Neighbors.west, from_w, Input_buffer.Array);			
		    handle.Wait(); 
		}
				
		private Request handle;
		public Request Handle { get { return handle; } }
	}
}
