using br.ufc.pargo.hpe.kinds;
using common.direction.Direction;
using MPI;

namespace lu.interactionpattern.Shift { 
	public interface IShift<DIR> : BaseIShift<DIR>
	where DIR:IDirection {
	    void initiate_send();
	    void initiate_recv();
		Request HandleLeft { get; }
		Request HandleRight { get;}
	
	}  
} 
