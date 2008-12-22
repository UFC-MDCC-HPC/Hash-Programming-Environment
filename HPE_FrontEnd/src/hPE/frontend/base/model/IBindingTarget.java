package hPE.frontend.base.model;

import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IUnit;



public interface IBindingTarget {

	public HBinding getBinding();
	
	public void setBinding(HBinding binding);
	
	public void unsetBinding();
	
	public IInterface getInterface();
	
	
	
}
