using br.ufc.pargo.hpe.kinds;

namespace lu.topology.Neighbors { 

public interface INeighbors : BaseINeighbors
{
		int north {get;}
		int south {get;}
		int east {get;}
		int west {get;}	
		
        int num {get;}
        int node {get;}
        int ndim {get;}
        int row {get;}
        int col {get;}

} // end main interface 

} // end namespace 
