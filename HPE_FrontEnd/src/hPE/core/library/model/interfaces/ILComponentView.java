package hPE.core.library.model.interfaces;

import java.util.List;

import org.eclipse.emf.common.util.URI;

public interface ILComponentView extends IHPEComponentLibraryItem {

	public List getUnits();  // returns observable units;
	
	public String getName();
	
	public java.io.File getComponent(boolean useCached);

	public boolean isOK();

	public boolean isObsolete();
	
	public URI getLocationSite();
}
