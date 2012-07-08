package hPE.frontend.base.interfaces;

import java.util.Collection;

import hPE.core.library.model.interfaces.ILComponentView;
import hPE.frontend.base.model.HComponent;

public interface IConfiguration {

	public String getComponentName();
	
	public String getRef();
	
	public String getLocalLocation();
	
	public Collection getUnits();
	
	public IConfiguration getConfiguration();
	
	public boolean isParameter();
	
	public boolean isAbstractConfiguration();
	
	public IConfiguration getTopConfiguration();
	
	public abstract String kindString();

	public void removeComponent(HComponent c);
	
}
