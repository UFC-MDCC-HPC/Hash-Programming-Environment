package hPE.model.interfaces;

import java.util.List;

public interface IUnit extends ICanReplicate {

	public String getName2();
	 
	public IConfiguration getConfiguration();

	public boolean isRepetitive();
	
	// public List getPorts();

	public IInterface getInterface();
	
	public List getSlices();
}
