using br.ufc.pargo.hpe.kinds;

namespace common.interactionpattern.Interact { 

public interface IInteract : BaseIInteract
{
	void initiate_send_west();
    void initiate_recv_west();		
	void initiate_send_east();
    void initiate_recv_east();		
	void initiate_send_north();
    void initiate_recv_north();
	void initiate_send_south();
    void initiate_recv_south();
	void initiate_send_top();
    void initiate_recv_top();		
	void initiate_send_bottom();
    void initiate_recv_bottom();
		
	void shift_x_right();
	void shift_x_left();
	void shift_y_right();
	void shift_y_left();
	void shift_z_right();
	void shift_z_left();
		
} // end main interface 

} // end namespace 
