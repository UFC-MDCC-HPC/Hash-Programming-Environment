using br.ufc.pargo.hpe.kinds;

namespace lu.topology.Mesh3D { 

public interface IMesh3D : BaseIMesh3D
{
		int north {get;}
		int south {get;}
		int east {get;}
		int west {get;}

        int ydim {get;}
        int node {get;}
        int xdim {get;}
        int row {get;}
        int col {get;}

} // end main interface 

} // end namespace 
