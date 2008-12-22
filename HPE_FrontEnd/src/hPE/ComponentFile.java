package hPE;

import hPE.core.library.model.classes.LComponentView;
import hPE.core.library.model.interfaces.ILComponentView;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

public class ComponentFile extends File {

	public ComponentFile(IPath path, Workspace container, ILComponentView libraryEntry) {
		super(path, container);
		this.libraryEntry = (LComponentView) libraryEntry;
		// TODO Auto-generated constructor stub
	}

	private LComponentView libraryEntry;	
	
	public URI getSystemLocation() {
		return libraryEntry.getLocationSite();
	}
	
	public ILComponentView getLibraryEntry() {
		return (ILComponentView) libraryEntry;
	}

	
}
