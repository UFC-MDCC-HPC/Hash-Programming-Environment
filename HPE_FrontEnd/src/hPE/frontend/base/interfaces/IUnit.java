package hPE.frontend.base.interfaces;

import java.util.List;

public interface IUnit extends IElement {

	public String getName2();
	 
	public IConfiguration getConfiguration();

	public boolean isRepetitive();
	
	public IInterface getInterface();
	
	public List getSlices();
	
}
