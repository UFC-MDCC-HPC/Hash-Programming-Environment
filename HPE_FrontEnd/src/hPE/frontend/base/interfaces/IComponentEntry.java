package hPE.frontend.base.interfaces;

import java.util.List;

import hPE.frontend.base.model.IBindingTarget;

public interface IComponentEntry {

	public String getName2();
	
	public IComponent getComponent();
	
	public IInterface getInterface();
		
	public List getInnerEntries();
		
	public IUnit fetchCorrespondingUnit();
	
	public IConfiguration getConfiguration();

	public int getIndex();
	
}
