package hPE.frontend.base.interfaces;

import hPE.frontend.base.model.HInterfaceSlice;


public interface IUnitSlice extends Cloneable{

	public IComponentEntry getComponentEntry();
	
	public IInterface getInterface();
		
	public HInterfaceSlice getInterfaceSlice();
	
	public IUnit getUnit();
	
//	public int getNestingFactor();
}
