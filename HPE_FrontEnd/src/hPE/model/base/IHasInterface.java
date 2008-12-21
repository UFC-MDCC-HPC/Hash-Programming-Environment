package hPE.model.base;

import hPE.model.interfaces.IInterface;
import hPE.model.interfaces.IConfiguration;

public interface IHasInterface {

	public IInterface getInterface();

	/**
	 */
	public abstract void setInterface(HInterface the_interface);
	
	public boolean visibleInterface();
	
	public void showInterface();
	
	public void hideInterface();	
	
	public void notifyColorChange();
	
	public IConfiguration getConfiguration();
	
	public HLinkToInterface getLinkToInterface();
	
	
}
