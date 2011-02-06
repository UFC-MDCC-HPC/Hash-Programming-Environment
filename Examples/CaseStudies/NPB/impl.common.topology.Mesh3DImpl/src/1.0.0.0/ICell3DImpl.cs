using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Mesh3D;

namespace impl.common.topology.Mesh3DImpl { 

public class ICell3DImpl : BaseICell3DImpl, ICell3D
{

	public ICell3DImpl() { 
	
	} 

    public int West   { get { return X.predecessor;   } set { X.predecessor = value;   } }  // x direction
    public int East   { get { return X.successor;   } set { X.successor = value;   } }  // x direction
    
    public int North  { get { return Y.predecessor;  } set { Y.predecessor = value;  } }  // y direction
    public int South  { get { return Y.successor;  } set { Y.successor = value;  } }  // y direction
    
    public int Top    { get { return Z.predecessor;    } set { Z.predecessor = value;    } }  // z direction
    public int Bottom { get { return Z.successor; } set { Z.successor = value; } }  // z direction

}

}
