package hPE.model.interfaces;

import java.util.List;

import hPE.model.base.IBindingTarget;

public interface IComponentEntry {

	public String getName2();
	
	public IComponent getComponent();
	
	public IInterface getInterface();
		
	public List getInnerEntries();
		
	public IUnit fetchCorrespondingUnit();
	
	public IConfiguration getConfiguration();
	
}
