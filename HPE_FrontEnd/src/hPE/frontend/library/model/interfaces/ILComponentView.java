package hPE.frontend.library.model.interfaces;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFile;

public interface ILComponentView extends IHPEComponentLibraryItem {

	public List getUnits();  // returns observable units;
	
	public String getName();
	
	public IFile getComponent(boolean useCached);

	public boolean isOK();
}
