using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.direction.EastToWest;
using lu.interactionpattern.Shift;
using MPI;

namespace impl.lu.interactionpattern.ShiftToWestImpl { 
	public class IShiftToWestImpl<DIR> : BaseIShiftToWestImpl<DIR>, IShift<DIR>
	where DIR:IEastToWest {
	
		public IShiftToWestImpl() { 
		
		} 
		
		public override void synchronize() { 
		
		}
		 
		private static int from_e = 3; //from_s = 1, from_n = 2, from_w = 4;
				
		public void initiate_send(){//Blocking Send
			comm.Send<double>(Output_buffer.Array, Neighbors.west, from_e);      
		}
		
		public void initiate_recv(){//Blocking Receive
			handle = comm.ImmediateReceive<double>(Neighbors.east, from_e, Input_buffer.Array);			
		    handle.Wait(); 
		}
				
		private Request handle;
		public Request Handle { get { return handle; } }
	}
}
