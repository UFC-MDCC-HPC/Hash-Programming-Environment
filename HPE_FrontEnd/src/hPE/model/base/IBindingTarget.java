package hPE.model.base;

import hPE.model.interfaces.IInterface;
import hPE.model.interfaces.IUnit;



public interface IBindingTarget {

	public HBinding getBinding();
	
	public void setBinding(HBinding binding);
	
	public void unsetBinding();
	
	public IInterface getInterface();
	
	
	
}
