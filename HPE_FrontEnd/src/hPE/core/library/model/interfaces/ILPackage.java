package hPE.core.library.model.interfaces;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import hPE.xml.component.ComponentType;


public interface ILPackage extends IHPEComponentLibraryItem {

	public List getComponents();
	
	public boolean isAllowedToModifyPackage();
	
	public void addComponent(ComponentType component, URI locationSite);
	public void removeComponent(ILComponentView componentView);
	
	public String[] getPackagePath();
	
	public void addLocation(URI uri);
	public List<URI> getLocations();
	
}
