package hPE.frontend.base.interfaces;

import hPE.core.library.model.interfaces.ILComponentView;

import java.util.Collection;


public interface IComponent extends ICanReplicate {

	public IConfiguration getConfiguration(); // configuration where the component is being used.
	
	public Collection getEntries();
	
	public String getComponentName();
	
	public boolean isTopConfiguration ();
	
	public IConfiguration fetchSelfConfiguration();  // the configuration of the component, retrieved from the library.
	
	public IConfiguration getTopConfiguration();
	
	public boolean isDirectSonOfTheTopConfiguration ();
	
	public String getLocalLocation();

	public IComponent getMyCopy();

	public boolean isAbstract();
}
