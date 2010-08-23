package hPE.frontend;

import hPE.HPEProperties;
import hPE.frontend.core.locations.locations.CoreType;
import hPE.frontend.core.locations.locations.DocumentRoot;
import hPE.frontend.core.locations.locations.LocationType;
import hPE.frontend.core.locations.locations.LocationsFactory;
import hPE.frontend.core.locations.locations.LocationsPackage;
import hPE.frontend.core.locations.locations.impl.DocumentRootImpl;
import hPE.frontend.core.locations.locations.util.LocationsResourceFactoryImpl;
import hPE.frontend.core.locations.locations.util.LocationsResourceImpl;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CoreLocationList {

	private static LocationsFactory factory = LocationsFactory.eINSTANCE;

	private static String fileSites = null;
	
	private static String getFileSites() {
		if (fileSites == null) {
			fileSites = HPEProperties.getInstance().getValue("core_locations");
		}
		return fileSites;
	}

	public static void readCoreLocationsFile(Map<String,CoreLocationInfo> coreLocations) {

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put	(Resource.Factory.Registry.DEFAULT_EXTENSION, new LocationsResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(LocationsPackage.eNS_URI, LocationsPackage.eINSTANCE);
    			
		URI uri = URI.createFileURI(getFileSites());
		
		Resource resource = null;
		
		try {
			
			resource = resourceSet.getResource(uri, true);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getCause() instanceof FileNotFoundException) {
				resource = saveData(coreLocations);
			}			
		} finally {
			
			LocationsResourceImpl cResource = (LocationsResourceImpl) resource;
			EList rs = cResource.getContents();

		    CoreType services = ((DocumentRootImpl) rs.get(0)).getCore();
			if (services.getLocation() != null) {
				for (LocationType l : services.getLocation()) {
					String name = l.getName();
					String locURI = l.getUri();
					CoreLocationInfo bel = new CoreLocationInfo(name, locURI);
					coreLocations.put(name,bel);                	
				}
			}
		}
	}

	
	public static Resource saveData(Map<String,CoreLocationInfo> coreLocations) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();
			
			// Register the appropriate resource factory to handle all file extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
				(Resource.Factory.Registry.DEFAULT_EXTENSION, 
				 new LocationsResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put
				(LocationsPackage.eNS_URI, 
				 LocationsPackage.eINSTANCE);
	        
			// If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createFileURI(getFileSites());
			Resource resource = resourceSet.createResource(uri);
			
			DocumentRoot dX = factory.createDocumentRoot();
			CoreType cX = saveInfo(coreLocations.values());
			dX.setCore(cX);
		
			resource.getContents().add(dX);
			resource.save(null); 
			
			return resource;
		} catch (IOException e) {
			return null;
		}
		
	}
	
	private static CoreType saveInfo(Collection<CoreLocationInfo> values) {
		CoreType s = factory.createCoreType();
		
		for (CoreLocationInfo b : values) {
		   LocationType l = factory.createLocationType();
		   l.setName(b.name);
		   l.setUri(b.locURI);
		   s.getLocation().add(l);
		}
		
	    return s;	
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
	protected static void createFile(IFile fileHandle, InputStream contents,
	        IProgressMonitor monitor) throws CoreException {
	    if (contents == null)
	        contents = new ByteArrayInputStream(new byte[0]);

	    try {
	        // Create a new file resource in the workspace
//	        if (linkTargetPath != null)
//	               fileHandle.createLink(linkTargetPath,
//	                     IResource.ALLOW_MISSING_LOCAL, monitor);
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
	            fileHandle.create(contents, true, monitor);
	        
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
	
	public static class CoreLocationInfo {
		public String name = null;
		public String locURI = null;

		public CoreLocationInfo() {}
		
		public CoreLocationInfo(String name, String locURI) {
		   this.name = name;
		   this.locURI = locURI;
		}
		
		public String toString() {
			return name;
		}
		
	}

	public static List<URI> fetchLocations() {

		List<URI> locations = new ArrayList<URI>();
		Map<String,CoreLocationInfo> coreLocations = new HashMap<String,CoreLocationInfo>();
		readCoreLocationsFile(coreLocations);
		
		for (CoreLocationInfo c : coreLocations.values()) {
			locations.add(URI.createURI(c.locURI));
		}
		
		return locations;
	}
	
}
