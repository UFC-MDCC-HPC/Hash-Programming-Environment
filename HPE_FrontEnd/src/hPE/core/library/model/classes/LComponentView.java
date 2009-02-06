package hPE.core.library.model.classes;

import hPE.core.library.HPEComponentFileNotFound;
import hPE.core.library.HPELocationEntry;
import hPE.core.library.model.interfaces.ILComponentView;
import hPE.core.library.model.interfaces.ILInterfaceCompositeView;
import hPE.core.library.model.interfaces.ILPackage;
import hPE.frontend.base.model.HComponent;
import hPE.xml.component.ComponentType;
import hPE.xml.component.InterfaceType;
import hPE.xml.factory.HComponentFactoryImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class LComponentView extends HPEComponentLibraryItem implements ILComponentView {

	private String componentName;
	
	private String version;
	
	private URI locationSite;

	private boolean obsolete;
	
	public URI getLocationSite() {
		return locationSite;
	}
		
	public LComponentView(ILPackage parentPackage, String componentName, String version, URI locationSite, boolean obsolete) {
		super(parentPackage);
		this.locationSite = locationSite;
		this.componentName = componentName;
		this.version = version;
		this.obsolete = obsolete;
		//readFrom(componentName);
	}
	
	
	protected void readFrom(Object model) {
	    try {
	    	readFromComponent((String) model);
	    } catch (HPEComponentFileNotFound e) {
	        e.printStackTrace();
	    }
	}
	
	private void readFromComponent(String componentName) throws HPEComponentFileNotFound {
		this.clearChildren();
		this.componentName = componentName;
	}
		
	public java.io.File getComponent(boolean useCached) {
		java.io.File file = null;
		if (!useCached) {
			if (!obsolete) {
				String[] pkName = ((ILPackage) this.getParent()).getPackagePath();
				try {
					file = HPELocationEntry.getComponent(pkName,componentName, version, locationSite);
				} catch (HPEComponentFileNotFound e) {
					e.printStackTrace();
					ok = false;				
		        	JOptionPane.showMessageDialog(null,
		        		    "Missing Component " + pkName[0] + "." + componentName.toString() + " in Location " + this.getLocationSite().toString(),
		        		    "Error",
		        		    JOptionPane.ERROR_MESSAGE);
				}
			} else {
				ok = false;
	        	JOptionPane.showMessageDialog(null, componentName + " is obsolete !",
	        		    "Error",
	        		    JOptionPane.ERROR_MESSAGE);
			}
			
		}
		return file;
	}
	
	private boolean ok = true;
	
	public boolean isOK() { return ok; }
			
	public String getTitle() {
		return getName() + (getVersion() == null ? "" : " - " + getVersion()) + (obsolete ? " (obsolete)" : "");
	}
	
	private String getVersion() {
		return version;
	}

	public List getUnits() {
		// returns observable units;
		return getChildren();
	}
	
	public String getName() {
         return componentName;
	}

	@Override
	public boolean isObsolete() {
		return this.obsolete;
	}
	
	
	
}
