using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;

namespace impl.common.topology.RingImpl { 

public class ICellImpl : BaseICellImpl, ICell
{

	public ICellImpl() { 
	
	} 
		
	private int _successor_;	
	private int _predecessor_;	
		
    public int successor { get { return _successor_; } set { _successor_ = value; } }
    public int predecessor { get { return _predecessor_; } set { _predecessor_ = value; } }		

}

}
