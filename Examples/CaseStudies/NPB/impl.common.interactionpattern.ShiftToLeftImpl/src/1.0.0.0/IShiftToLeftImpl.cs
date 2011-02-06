using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.interactionpattern.Shift;
using MPI;
using common.direction.RightToLeft;

namespace impl.common.interactionpattern.ShiftToLeftImpl { 

public class IShiftToLeftImpl<DIR> : BaseIShiftToLeftImpl<DIR>, IShift<DIR>
		where DIR:IRightToLeft
{

	private Intracommunicator comm;		
			
	private RequestList requestList;
			
	public IShiftToLeftImpl() 
	{ 
	   comm = Mpi.localComm(this);
	   requestList = new RequestList();
	} 
			
	private static int DEFAULT_TAG = 0;		
			
	public void initiate_send()
	{
		if (handle_left != null)
				requestList.Remove(handle_left);
		handle_left = comm.ImmediateSend<double>(Output_buffer.Array, Cell.predecessor, DEFAULT_TAG);      
		requestList.Add(handle_left);
	}
	
	public void initiate_recv() 
	{
		if (handle_right != null)
				requestList.Remove(handle_right);
		handle_right = comm.ImmediateReceive<double>(Cell.successor, DEFAULT_TAG, Input_buffer.Array);			
		requestList.Add(handle_right);
	}
			
	private Request handle_left;
	private Request handle_right;
			
	public Request HandleLeft { get { return handle_left; } }
	public Request HandleRight { get { return handle_right; } }
			
	public override void synchronize() { 
	   
	   requestList.WaitAll();
				
	} // end activate method 

}

}
