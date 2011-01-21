using br.ufc.pargo.hpe.kinds;

namespace br.ufc.lia.pargo.hpe.casestudies.npb.common.interactionpattern.Systolic3D { 

public interface IPeer : BaseIPeer
{
   void shift_x();  // moving data in x direction
   void shift_y();  // moving data in y direction
   void shift_z();  // moving data in z direction
   
   /* for asynchronous communication */
   void initiate_send_east();       
   void initiate_recv_west();
   void initiate_send_south();
   void initiate_recv_north();
   void initiate_send_bottom();
   void initiate_recv_top();
   
} // end main interface 

} // end namespace 
