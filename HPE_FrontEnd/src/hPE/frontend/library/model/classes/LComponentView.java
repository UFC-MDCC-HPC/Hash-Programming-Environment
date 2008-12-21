package hPE.frontend.library.model.classes;

import hPE.frontend.library.HPEComponentFileNotFound;
import hPE.frontend.library.HPELocationEntry;
import hPE.frontend.library.model.interfaces.ILComponentView;
import hPE.frontend.library.model.interfaces.ILInterfaceCompositeView;
import hPE.frontend.library.model.interfaces.ILPackage;
import hPE.model.base.HComponent;
import hPE.model.factory.base.HComponentFactoryImpl;
import hPE.xml.component.ComponentType;
import hPE.xml.component.InterfaceType;

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
	
	private URI locationSite;
	
	public URI getLocationSite() {
		return locationSite;
	}
		
	public LComponentView(ILPackage parentPackage, String componentName, URI locationSite) {
		super(parentPackage);
		this.locationSite = locationSite;
		this.componentName = componentName;
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
		List<InterfaceType> interfaces = this.fetchInterfaces(componentName);
		Iterator<InterfaceType> is = interfaces.iterator();
		while (is.hasNext()) {
			InterfaceType i = is.next();
//			if (i instanceof IADTUnit) {
//				ILInterfacePrimitiveView interfaceView = new LInterfacePrimitiveView(this,(IADTUnit) i);
//				this.addChild(interfaceView);
//			} else if (i instanceof IComputationUnit) {
				ILInterfaceCompositeView interfaceView = new LInterfaceCompositeView(this,i);
				this.addChild(interfaceView);
//			}
		}
	}
	
	private ComponentType component = null;
	
	public IFile getComponent(boolean useCached) {
		IFile file = null;
		if (!useCached || component == null) {
			String[] pkName = ((ILPackage) this.getParent()).getPackagePath();
			try {
				file = HPELocationEntry.getComponent(pkName,componentName,locationSite);
			} catch (HPEComponentFileNotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ok = false;				
				component = null;
	        	JOptionPane.showMessageDialog(null,
	        		    "Missing Component " + pkName[0] + "." + componentName.toString() + " in Location " + this.getLocationSite().toString(),
	        		    "Error",
	        		    JOptionPane.ERROR_MESSAGE);
			}
		}
		return file;
	}
	
	private boolean ok = true;
	
	public boolean isOK() { return ok; }
		
	public List<InterfaceType> fetchInterfaces(String componentName) throws HPEComponentFileNotFound {
		
		List<InterfaceType> interfaces = new ArrayList<InterfaceType>();
		
		String[] pkName = ((ILPackage) this.getParent()).getPackagePath();
		
		
		IFile f = HPELocationEntry.getComponent(pkName,componentName,locationSite);
		ComponentType c = null;
		component = null;
		
		// ComponentType c = HComponentFactoryImpl.eInstance.loadComponentX(uri);
		
		Iterator<InterfaceType> is = c.getComponentInfo().getInterface().iterator();
		while (is.hasNext()) {
			InterfaceType i = is.next();
			interfaces.add(i);
		}
		
		return interfaces;
		
		
/*		ILPackage  p = (ILPackage) getParent();
		ILLocation l = (ILLocation) p.getParent();
		 
    	String projectName = ((LWorkspaceLocation) l).getProjectName();
    	IPath path = new Path(projectName.concat(p.getPackagePathRaw()).concat("/").concat(this.getName()).concat(".hpe"));
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        
        HComponent component = null;
        
        try {
  	      ObjectInputStream in = new ObjectInputStream(file.getContents()); 
          component = (HComponent) in.readObject();
		} catch (IOException e) { 
			handleLoadException(e); 
		} catch (CoreException e) { 
			handleLoadException(e); 
		} catch (ClassNotFoundException e) { 
			handleLoadException(e); 
		}
    */    
        
       // TODO: library (fetchConfiguration)
        // retrieves the configuration of the component ...

//        return component;
        
	}

	private void handleLoadException(Exception e) {
		
		System.err.println("** Loading component failed");
		e.printStackTrace();
		
	}
	
	public String getTitle() {
		return getName();
	}
	
	public List getUnits() {
		// returns observable units;
		return getChildren();
	}
	
	public String getName() {
         return componentName;
	}
	
	   /**
     * Creates a file resource given the file handle and contents.
     *
     * @param fileHandle the file handle to create a file resource with
     * @param contents the initial contents of the new file resource, or
     *   <code>null</code> if none (equivalent to an empty stream)
     * @param monitor the progress monitor to show visual progress with
     * @exception CoreException if the operation fails
     * @exception OperationCanceledException if the operation is canceled
     */
    protected void createFile(IFile fileHandle, InputStream contents,
            IProgressMonitor monitor) throws CoreException {
        if (contents == null)
            contents = new ByteArrayInputStream(new byte[0]);

        try {
            // Create a new file resource in the workspace
//            if (linkTargetPath != null)
 //               fileHandle.createLink(linkTargetPath,
   //                     IResource.ALLOW_MISSING_LOCAL, monitor);
     //       else {
                IPath path = fileHandle.getFullPath();
                IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                int numSegments= path.segmentCount();
                if (numSegments > 2 && !root.getFolder(path.removeLastSegments(1)).exists()) {
                    // If the direct parent of the path doesn't exist, try to create the
                    // necessary directories.
                    for (int i= numSegments - 2; i > 0; i--) {
                        IFolder folder = root.getFolder(path.removeLastSegments(i));
                        if (!folder.exists()) {
                            folder.create(false, true, monitor);
                        }
                    }
                }
                if (fileHandle.exists()) {
                   fileHandle.setContents(contents, true, true, monitor);
                } else {
                    fileHandle.create(contents, true, monitor);
                }
            
        } catch (CoreException e) {
            // If the file already existed locally, just refresh to get contents
            if (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED)
                fileHandle.refreshLocal(IResource.DEPTH_ZERO, null);
            else {
                throw e;
            }
        }

        if (monitor.isCanceled())
            throw new OperationCanceledException();
    }

    private IProgressMonitor getProgressMonitor() {
        
    	return new org.eclipse.core.runtime.NullProgressMonitor();
    }
	
	
}
