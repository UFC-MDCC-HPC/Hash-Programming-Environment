using br.ufc.pargo.hpe.kinds;

namespace lu.topology.Neighbors { 

public interface INeighbors : BaseINeighbors
{
		int north {get; set;}
		int south {get; set;}
		int east {get; set;}
		int west {get; set;}	
		
//        int ydim {get;}
//        int node {get;}
//        int xdim {get;}
//        int row {get;}
//        int col {get;}

} // end main interface 

} // end namespace 
