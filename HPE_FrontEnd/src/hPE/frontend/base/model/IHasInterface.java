package hPE.frontend.base.model;

import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;

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
