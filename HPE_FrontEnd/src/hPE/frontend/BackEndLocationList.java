package hPE.frontend;

import hPE.frontend.backend.locations.DocumentRoot;
import hPE.frontend.backend.locations.Location;
import hPE.frontend.backend.locations.LocationsFactory;
import hPE.frontend.backend.locations.LocationsPackage;
import hPE.frontend.backend.locations.Services;
import hPE.frontend.backend.locations.impl.DocumentRootImpl;
import hPE.frontend.backend.locations.util.LocationsResourceFactoryImpl;
import hPE.frontend.backend.locations.util.LocationsResourceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class BackEndLocationList {

	private static LocationsFactory factory = LocationsFactory.eINSTANCE;

	public static void loadBackEndsInfo(Map<String,BackEndLocationInfo> backendList) {

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put	(Resource.Factory.Registry.DEFAULT_EXTENSION, new LocationsResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(LocationsPackage.eNS_URI, LocationsPackage.eINSTANCE);
    			
		IPath path = /* ResourcesPlugin.getWorkspace().getRoot().getFullPath() */ new Path("h:\\runtime-workspace");
		
		URI uri = URI.createFileURI(fileSites);
		
		Resource resource = null;
		
		try {
			
			resource = resourceSet.getResource(uri, true);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getCause() instanceof FileNotFoundException) {
				resource = saveData(backendList);
			}			
		} finally {
			
			LocationsResourceImpl cResource = (LocationsResourceImpl) resource;
			EList rs = cResource.getContents();

			Services services = ((DocumentRootImpl) rs.get(0)).getServices();
			if (services.getBackend() != null) {
				for (Location l : services.getBackend()) {
					String name = l.getName();
					String locURI = l.getUri();
					String login = l.getLogin();
					String password = l.getPassword();
					BackEndLocationInfo bel = new BackEndLocationInfo(name, locURI, login, password);
					backendList.put(name,bel);                	
				}
			}
			
			
			
		}
	}

	private static String fileSites = "BackEndLocations.xml";  //  @jve:decl-index=0:
	
	public static Resource saveData(Map<String,BackEndLocationInfo> backendList) {
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
			URI uri = URI.createFileURI(fileSites);
			Resource resource = resourceSet.createResource(uri);
			
			DocumentRoot dX = factory.createDocumentRoot();
			Services cX = saveInfo(backendList.values());
			dX.setServices(cX);
		
			resource.getContents().add(dX);
			resource.save(null); 
			
			return resource;
		} catch (IOException e) {
			return null;
		}
		
	}
	
	private static Services saveInfo(Collection<BackEndLocationInfo> values) {
		Services s = factory.createServices();
		
		for (BackEndLocationInfo b : values) {
		   Location l = factory.createLocation();
		   l.setName(b.name);
		   l.setUri(b.locURI);
		   if (b.login!=null && !b.login.equals("")) {
			   l.setLogin(b.login);
			   l.setPassword(b.password);
		   }
		   s.getBackend().add(l);
		}
		
	    return s;	
	}

	public static class DeployedComponentInfo {
		public String[] thePackage;
		public String name;
		public int kind;
		public String[] enumerators;
		public Integer[] enumValuation;
		
		public DeployedComponentInfo() {};
		
	}
	
	public static List<DeployedComponentInfo> loadDeployedComponentsInfo(BackEndLocationInfo b) {
	
		
		return null;
	}
		
	
	public static class BackEndLocationInfo {
		public String name = null;
		public String locURI = null;
		public String login = null;
		public String password = null;

		public BackEndLocationInfo() {}
		
		public BackEndLocationInfo(String name, String locURI, String login, String password) {
		   this.name = name;
		   this.locURI = locURI;
		   this.login = login;
		   this.password = password;
		}
		
		public String toString() {
			return name;
		}
		
	}
	
}
