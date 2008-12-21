package hPE.frontend.library.model.classes;

import hPE.frontend.library.HPELocationEntry;
import hPE.frontend.library.model.interfaces.IHPEComponentLibrary;
import hPE.frontend.library.model.interfaces.ILComponentView;
import hPE.frontend.library.model.interfaces.ILPackage;
import hPE.xml.component.ComponentType;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;

public class LPackage extends HPEComponentLibraryItem implements ILPackage {

	private String[] packagePath;
	
	public LPackage(IHPEComponentLibrary parentLibrary, String[] packagePath) {
		super(parentLibrary);	
		this.packagePath = packagePath;
	}

	private List<URI> locations = new ArrayList<URI>();
	
	public void addLocation(URI uri) {
		locations.add(uri);
		readFrom(uri);
	}
	
	public List<URI> getLocations() {
		if (locations == null) locations = new ArrayList<URI>();
		return locations;
	}
	
	protected void readFrom(Object model) {
	    readFromPackageLocation((URI) model);
	}
	
	private void readFromPackageLocation(URI locationSite) {
		List<String> components = HPELocationEntry.fetchComponents(locationSite,packagePath);
		this.clearChildren();
		for (String componentName : components) {
			ILComponentView componentView = new LComponentView(this,componentName,locationSite);
			this.addChild(componentView);
		}
		
	}
	
	public String getTitle() {
		return putSeparator(getPackagePath(),".",false);
	}
	
	private String putSeparator(String[] path,String sep, boolean begin) {
		
		String returnPath = begin ? sep : "";
		
		for (int i = 0; i < path.length-1; i++) {
			returnPath = returnPath.concat(path[i]).concat(sep);
		}
		
		returnPath = returnPath.concat(path[path.length-1]);
		
		return returnPath;
		
	}

	public List getComponents() {
		return getChildren();
	}
	
    public boolean isAllowedToModifyPackage() {
		// TODO: library (isAllowedToModifyPackage)
		return false;
	}
	
	private void registerNewComponent(ComponentType component) {
	    // TODO: library (registerNewComponent)
	}
	
	private void unregisterComponent(ComponentType component) {
		// TODO: library (unregisterComponent)
	}
	
	public void addComponent(ComponentType componentConfig, URI locationSite) {
		if (isAllowedToModifyPackage()) {			
			ILComponentView componentView = new LComponentView(this,componentConfig.getHeader().getName(),locationSite);
			this.registerNewComponent(componentConfig);
			this.addChild(componentView);
		}
	}

	public void removeComponent(ILComponentView theComponent) {
		if (isAllowedToModifyPackage()) {
			
			// TODO THE line below ...
			// this.unregisterComponent(theComponent.getComponent(false));
			this.removeChild(theComponent);
		} else {
			// ERROR: operation now allowed (remove package).
		}
	}	
	
	public String[] getPackagePath() {
		return this.packagePath;
	}
		
	
}
