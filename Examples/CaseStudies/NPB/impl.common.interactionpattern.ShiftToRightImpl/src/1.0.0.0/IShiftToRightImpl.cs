using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.interactionpattern.Shift;
using MPI;
using common.direction.LeftToRight;

namespace impl.common.interactionpattern.ShiftToRightImpl { 

public class IShiftToRightImpl<DIR> : BaseIShiftToRightImpl<DIR>, IShift<DIR>
		where DIR:ILeftToRight
{
	
	private RequestList requestList = new RequestList();
			
	public IShiftToRightImpl() 
	{ 				   
	} 
			
	private static int DEFAULT_TAG = 0;		
			
	public void initiate_send()
	{
		if (handle_right != null)
			requestList.Remove(handle_right);
		int rank = comm.Rank;
		//Console.WriteLine(rank + ": shift-to-right : initiate_send : " + Cell.successor);
		handle_right = comm.ImmediateSend<double>(Output_buffer.Array, Cell.successor, DEFAULT_TAG);      
		requestList.Add(handle_right);
	}
	
	public void initiate_recv() 
	{
		if (handle_left != null)
			requestList.Remove(handle_left);
		int rank = comm.Rank;
		//Console.WriteLine(rank + ": shift-to-right : initiate_recv : " + Cell.predecessor);
		handle_left = comm.ImmediateReceive<double>(Cell.predecessor, DEFAULT_TAG, Input_buffer.Array);			
		requestList.Add(handle_left);
	}
			
	private Request handle_left;
	private Request handle_right;
			
	public Request HandleLeft { get { return handle_left; } }
	public Request HandleRight { get { return handle_right; } }
			
	public override int go() 
	{ 			
	    int rank = comm.Rank;
	    //Console.Error.WriteLine(rank + ": shift to right begin");
	    requestList.WaitAll();
	    //Console.Error.WriteLine(rank + ": shift to right end");
			
		return 0;			
	} // end activate method 

}

}
