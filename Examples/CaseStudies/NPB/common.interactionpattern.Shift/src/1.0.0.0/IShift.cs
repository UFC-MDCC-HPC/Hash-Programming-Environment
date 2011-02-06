using br.ufc.pargo.hpe.kinds;
using MPI;
using common.direction.Direction;

namespace common.interactionpattern.Shift { 

public interface IShift<DIR> : BaseIShift<DIR>
		where DIR:IDirection
{

    void initiate_send();
    void initiate_recv();
	Request HandleLeft { get; }
	Request HandleRight { get;}
		

} // end main interface 

} // end namespace 
