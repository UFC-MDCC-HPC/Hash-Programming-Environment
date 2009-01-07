package hPE.core.library.model.interfaces;

import java.util.List;

public interface ILComponentView extends IHPEComponentLibraryItem {

	public List getUnits();  // returns observable units;
	
	public String getName();
	
	public java.io.File getComponent(boolean useCached);

	public boolean isOK();
}
