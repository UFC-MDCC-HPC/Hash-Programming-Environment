using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.interactionpattern.Interact;
using MPI;

namespace impl.common.interactionpattern.InteractImpl { 
	      
public class IInteractImpl : BaseIInteractImpl, IInteract
{		
    private RequestList requestList = new RequestList();		
		
	public IInteractImpl() 
	{ 	
	} 
		
	public void initiate_send_west()
	{   
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": x - initiate_send_west :");
		if (Shift_x_west.HandleLeft != null)
				requestList.Remove(Shift_x_west.HandleLeft);
		//if (Shift_x_west.HandleRight != null)
		//		requestList.Remove(Shift_x_west.HandleRight);
		Shift_x_west.initiate_send();
		requestList.Add(Shift_x_west.HandleLeft);
		//requestList.Add(Shift_x_west.HandleRight);
	}
		
    public void initiate_recv_east()
	{
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": x - initiate_recv_west :");
	    //if (Shift_x_west.HandleLeft != null)
		//		requestList.Remove(Shift_x_west.HandleLeft);
		if (Shift_x_west.HandleRight != null)
				requestList.Remove(Shift_x_west.HandleRight);
		Shift_x_west.initiate_recv();
		//requestList.Add(Shift_x_west.HandleLeft);
		requestList.Add(Shift_x_west.HandleRight);
	}
		
	public void initiate_send_east()
	{
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": x - initiate_send_east :");
		//if (Shift_x_east.HandleLeft != null)
		//		requestList.Remove(Shift_x_east.HandleLeft);
		if (Shift_x_east.HandleRight != null)
			requestList.Remove(Shift_x_east.HandleRight);
        Shift_x_east.initiate_send();			
		//requestList.Add(Shift_x_east.HandleLeft);
		requestList.Add(Shift_x_east.HandleRight);
	}

	public void initiate_recv_west()
	{
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": x - initiate_recv_east :");
		if (Shift_x_east.HandleLeft != null)
				requestList.Remove(Shift_x_east.HandleLeft);
		//if (Shift_x_east.HandleRight != null)
		//		requestList.Remove(Shift_x_east.HandleRight);
		Shift_x_east.initiate_recv();
		requestList.Add(Shift_x_east.HandleLeft);
		//requestList.Add(Shift_x_east.HandleRight);
	}

	public void initiate_send_north()
	{
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": y - initiate_send_north :");
		if (Shift_y_north.HandleLeft != null)
				requestList.Remove(Shift_y_north.HandleLeft);
		//if (Shift_y_north.HandleRight != null)
		//		requestList.Remove(Shift_y_north.HandleRight);
		Shift_y_north.initiate_send();
		requestList.Add(Shift_y_north.HandleLeft);
		//requestList.Add(Shift_y_north.HandleRight);
	}

    public void initiate_recv_south()
	{
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": y - initiate_recv_north :");
		//if (Shift_y_north.HandleLeft != null)
		//		requestList.Remove(Shift_y_north.HandleLeft);
		if (Shift_y_north.HandleRight != null)
				requestList.Remove(Shift_y_north.HandleRight);
		Shift_y_north.initiate_recv();
		//requestList.Add(Shift_y_north.HandleLeft);
		requestList.Add(Shift_y_north.HandleRight);
	}

	public void initiate_send_south()
	{
	    //int rank = comm.Rank;
	    //Console.Write(rank + ": y - initiate_send_south :");
		//if (Shift_y_south.HandleLeft != null)
		//		requestList.Remove(Shift_y_south.HandleLeft);
		if (Shift_y_south.HandleRight != null)
				requestList.Remove(Shift_y_south.HandleRight);
		Shift_y_south.initiate_send();	
		//requestList.Add(Shift_y_south.HandleLeft);
		requestList.Add(Shift_y_south.HandleRight);
	}

    public void initiate_recv_north()
	{
	   // int rank = comm.Rank;
	   // Console.Write(rank + ": y - initiate_recv_south :");
		if (Shift_y_south.HandleLeft != null)
				requestList.Remove(Shift_y_south.HandleLeft);
		//if (Shift_y_south.HandleRight != null)
		//		requestList.Remove(Shift_y_south.HandleRight);
		Shift_y_south.initiate_recv();
		requestList.Add(Shift_y_south.HandleLeft);
		//requestList.Add(Shift_y_south.HandleRight);
	}

	public void initiate_send_top()
	{
	   // int rank = comm.Rank;
	   // Console.Write(rank + ": z - initiate_send_top :");
		if (Shift_z_top.HandleLeft != null)
		 	requestList.Remove(Shift_z_top.HandleLeft);
		//if (Shift_z_top.HandleRight != null)
		//		requestList.Remove(Shift_z_top.HandleRight);
		Shift_z_top.initiate_send();
		requestList.Add(Shift_z_top.HandleLeft);
		//requestList.Add(Shift_z_top.HandleRight);
	}

    public void initiate_recv_bottom()
	{
	   // int rank = comm.Rank;
	   // Console.Write(rank + ": z - initiate_recv_top :");
		//if (Shift_z_top.HandleLeft != null)
		//		requestList.Remove(Shift_z_top.HandleLeft);
		if (Shift_z_top.HandleRight != null)
				requestList.Remove(Shift_z_top.HandleRight);
		Shift_z_top.initiate_recv();
		//requestList.Add(Shift_z_top.HandleLeft);
		requestList.Add(Shift_z_top.HandleRight);
	}

	public void initiate_send_bottom()
	{
	   // int rank = comm.Rank;
	   // Console.Write(rank + ": z - initiate_send_bottom :");
		//if (Shift_z_bottom.HandleLeft != null)
		//		requestList.Remove(Shift_z_bottom.HandleLeft);
		if (Shift_z_bottom.HandleRight != null)
				requestList.Remove(Shift_z_bottom.HandleRight);
		Shift_z_bottom.initiate_send();
		//requestList.Add(Shift_z_bottom.HandleLeft);
		requestList.Add(Shift_z_bottom.HandleRight);
	}

    public void initiate_recv_top()
	{
	   // int rank = comm.Rank;
	   // Console.Write(rank + ": z - initiate_recv_bottom :");
		if (Shift_z_bottom.HandleLeft != null)
				requestList.Remove(Shift_z_bottom.HandleLeft);
		//if (Shift_z_bottom.HandleRight != null)
		//		requestList.Remove(Shift_z_bottom.HandleRight);
		Shift_z_bottom.initiate_recv();
		requestList.Add(Shift_z_bottom.HandleLeft);
		//requestList.Add(Shift_z_bottom.HandleRight);
	}

	public void shift_x_right() 
	{
		Shift_x_east.go();
	}
		
	public void shift_x_left()
	{
		Shift_x_west.go();
	}
		
	public void shift_y_right()
	{
		Shift_y_south.go();
	}
		
	public void shift_y_left()
	{
		Shift_y_north.go();
	}
		
	public void shift_z_right()
	{
		Shift_z_top.go();
	}
		
	public void shift_z_left()
	{
		Shift_z_bottom.go();
	}
				
	public override int go() 
	{ 			
	    int rank = comm.Rank;
	    int w1 = Shift_x_east.Cell.predecessor; //X.predecessor;
	    int e1 = Shift_x_east.Cell.successor; //X.successor;
	    int n1 = Shift_y_south.Cell.predecessor; //Y.predecessor;
	    int s1 = Shift_y_south.Cell.successor; //Y.successor;
	    int t1 = Shift_z_bottom.Cell.predecessor; //Z.predecessor;
	    int b1 = Shift_z_bottom.Cell.successor; //Z.successor;
	    
	    int e2 = Shift_x_west.Cell.predecessor; //X.predecessor;
	    int w2 = Shift_x_west.Cell.successor; //X.successor;
	    int s2 = Shift_y_north.Cell.predecessor; //Y.predecessor;
	    int n2 = Shift_y_north.Cell.successor; //Y.successor;
	    int b2 = Shift_z_top.Cell.predecessor; //Z.predecessor;
	    int t2 = Shift_z_top.Cell.successor; //Z.successor;
	    
	 //   Console.Error.WriteLine(rank + ": interact begin 1 - " + w1 + e1 + n1 + s1 + t1 + b1);
	 //   Console.Error.WriteLine(rank + ": interact begin 2 - " + w2 + e2 + n2 + s2 + t2 + b2);
	 //   Console.Error.WriteLine(rank + ": interact begin 3 - " + (Shift_x_east.Cell == Shift_y_south.Cell));
		requestList.WaitAll();			
	 //   Console.Error.WriteLine(rank + ": interact end");
		return 0;			
    }
	
	} // end activate method 

}
