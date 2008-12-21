package hPE.model.interfaces;

import hPE.model.base.HInterfaceSlice;


public interface IUnitSlice extends ICanReplicate {

	public IComponentEntry getComponentEntry();
	
	public IInterface getInterface();
		
	public HInterfaceSlice getInterfaceSlice();
	
	public IUnit getUnit();
	
	public int getNestingFactor();
}
