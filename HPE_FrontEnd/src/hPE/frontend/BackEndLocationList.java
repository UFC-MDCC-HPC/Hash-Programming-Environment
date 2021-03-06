package hPE.frontend;

import hPE.HPEProperties;

import hPE.backend.BackEnd_WSLocator;
import hPE.backend.BackEnd_WSSoap;
import hPE.frontend.backend.environment.DeployedComponentInfoType;
import hPE.frontend.backend.environment.DeployedParameterType;
import hPE.frontend.backend.environment.EnvironmentPackage;
import hPE.frontend.backend.environment.EnvironmentType;
import hPE.frontend.backend.environment.util.EnvironmentResourceFactoryImpl;
import hPE.frontend.backend.environment.util.EnvironmentResourceImpl;
import hPE.frontend.backend.locations.DocumentRoot;
import hPE.frontend.backend.locations.Location;
import hPE.frontend.backend.locations.LocationsFactory;
import hPE.frontend.backend.locations.LocationsPackage;
import hPE.frontend.backend.locations.Services;
import hPE.frontend.backend.locations.util.LocationsResourceFactoryImpl;
import hPE.frontend.core.locations.LocationManager;
import hPE.frontend.backend.locations.impl.DocumentRootImpl;
import hPE.frontend.backend.locations.util.LocationsResourceImpl;
import org.eclipse.core.runtime.Path;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

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

@Deprecated
// TODO usar a classe LocationManager.
// refatorada!
public class BackEndLocationList {

	private static LocationsFactory factory = LocationsFactory.eINSTANCE;

	private static String fileSites = null;

	private static String getFileSites() {
		if (fileSites == null) {
			fileSites = HPEProperties.getInstance().getValue("backend_locations");
		}
		return fileSites;
	}

	@Deprecated
	public static void loadBackEndsInfo2
	(
		Map<String, BackEndLocationInfo> backendList) {
		Collection<Location> locations = LocationManager.getInstance().getBackendLocations().values();

		BackEndLocationInfo backend;
		for (Location l : locations) {
			backend = new BackEndLocationInfo();
			backend.name = l.getName();
			backend.locURI = l.getUri();

			backendList.put(backend.name, backend);
		}

	}

	// TODO a �nica coisa que esse m�todo faz � carregar a lista de backend? Que
	// confus�o � essa?
	 public static void loadBackEndsInfo(Map<String, BackEndLocationInfo> backendList) 
	 {
	
	 ResourceSet resourceSet = new ResourceSetImpl();
	
	 resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new LocationsResourceFactoryImpl());
	
	 resourceSet.getPackageRegistry().put(LocationsPackage.eNS_URI, LocationsPackage.eINSTANCE);
	
	 URI uri = URI.createFileURI(getFileSites());
	
	 Resource resource = null;
	
	 try {
	
		 resource = resourceSet.getResource(uri, true);
	
	 } 
	 catch (Exception e) 
	 {
		 System.out.println(e.getMessage());
		 if (e.getCause() instanceof FileNotFoundException) {
			 resource = saveData(backendList);
		 }
	 } 
	 finally {
		 LocationsResourceImpl cResource = (LocationsResourceImpl) resource;
		 EList rs = cResource.getContents();
		
		 Services services = ((DocumentRootImpl) rs.get(0)).getServices();
		 
		 if (services.getBackend() != null) {
			 for (Location l : services.getBackend()) {
				 String name = l.getName();
				 String locURI = l.getUri();
				 String login = l.getLogin();
				 String password = l.getPassword();
				 IPath curdir = l.getCurdir() != null ? new Path(l.getCurdir()) : null;
				 BackEndLocationInfo bel = new BackEndLocationInfo(name,locURI, login, password, curdir);
				 backendList.put(name, bel);
			 }
		 }
	 }
	 }

	@Deprecated
	// aparentemente esse m�todo s� transforma um Map num Resource.
	public static Resource saveData(Map<String, BackEndLocationInfo> backendList) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register the appropriate resource factory to handle all file
			// extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new LocationsResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put(LocationsPackage.eNS_URI,
					LocationsPackage.eINSTANCE);

			// If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createFileURI(getFileSites());
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

	// substitui uma Collection por um Services
	@Deprecated
	private static Services saveInfo(Collection<BackEndLocationInfo> values) {
		Services s = factory.createServices();

		for (BackEndLocationInfo b : values) {
			Location l = factory.createLocation();
			l.setName(b.name);
			l.setUri(b.locURI);
			if (b.login != null && !b.login.equals("")) {
				l.setLogin(b.login);
				l.setPassword(b.password);
			}
			if (b.curdir != null)
				l.setCurdir(b.curdir.toString());

			s.getBackend().add(l);
		}

		return s;
	}

	@Deprecated
	// TODO se a classe � realmente necess�ria, criar uma classe tradicional num
	// arquivo a parte.
	public static class DeployedComponentInfo {
		public boolean isAbstract;
		public String[] thePackage;
		public String name;
		public int cid;
		public int cidBase;
		public String locationURI;
		public int kind;
		public String[] enumerators;
		public int[] enumValuation;
		public DeployedComponentInfoParameter[] parameters;

		public String toString() {
			return name;
		}

		public DeployedComponentInfo() {
		};

		public DeployedComponentInfo(boolean isAbstract, String[] thePackage,
				String name, int cid, int cidBase, String locationURI,
				int kind, String[] enumerators,
				DeployedComponentInfoParameter[] parameter) {
			this.isAbstract = isAbstract;
			this.thePackage = thePackage;
			this.name = name;
			this.cid = cid;
			this.cidBase = cidBase;
			this.locationURI = locationURI;
			this.kind = kind;
			this.enumerators = enumerators;
			this.parameters = parameter;
		};

	}

	@Deprecated
	// TODO se a classe � realmente necess�ria, criar uma classe tradicional num
	// arquivo a parte.
	public static class DeployedComponentInfoParameter {
		public String parameter_id = null;
		public int component_name = -1;
		public DeployedComponentInfoParameter[] parameter = null;
	}

	public static List<DeployedComponentInfo> loadDeployedComponentsInfo(
			String urlWS, Map<Integer, DeployedComponentInfo> dcListAbstract,
			Map<Integer, DeployedComponentInfo> dcListConcrete)
			throws IOException, ServiceException {

		List<DeployedComponentInfo> l = new ArrayList<DeployedComponentInfo>();

		BackEnd_WSLocator server = new BackEnd_WSLocator();
		server.setBackEnd_WSSoapEndpointAddress(urlWS);

		BackEnd_WSSoap backend = server.getBackEnd_WSSoap();

		byte[] data = backend.readEnvironment();

		EnvironmentType env = loadEnvironment(data);

		List<DeployedComponentInfoType> dcList = env.getDeployed();
		if (dcList.size() > 0) {

			dcListAbstract.clear();
			dcListConcrete.clear();

			for (DeployedComponentInfoType dc : dcList) {
				boolean isAbstract = dc.isAbstract();
				String[] package_ = (String[]) dc.getPackage().toArray();
				String name_ = dc.getName();
				int id_ = dc.getCid();
				;
				int idBase_ = dc.isSetCidBase() ? dc.getCidBase() : -1;
				String uri_ = dc.getLocationURI();
				int kind_ = HPEKinds.kind(dc.getKind());
				String[] enumerators_ = (String[]) dc.getEnumerator().toArray();
				DeployedComponentInfoParameter[] parameters_ = loadParameters(dc
						.getParameter());
				DeployedComponentInfo dci = new DeployedComponentInfo(
						isAbstract, package_, name_, id_, idBase_, uri_, kind_,
						enumerators_, parameters_);
				l.add(dci);
				if (isAbstract)
					dcListAbstract.put(new Integer(id_), dci);
				else
					dcListConcrete.put(new Integer(id_), dci);
			}
		}

		return l;
	}

	private static DeployedComponentInfoParameter[] loadParameters(
			EList<DeployedParameterType> parameters) {

		DeployedComponentInfoParameter[] result = new DeployedComponentInfoParameter[parameters
				.size()];

		int i = 0;
		for (DeployedParameterType parameter : parameters) {
			DeployedComponentInfoParameter p = new DeployedComponentInfoParameter();
			p.parameter_id = parameter.getParameterId();
			p.component_name = parameter.isSetActual() ? parameter.getActual()
					: -1;
			p.parameter = loadParameters(parameter.getParameter());
			result[i++] = p;
		}

		return result;
	}

	private static EnvironmentType loadEnvironment(byte[] data) {
		try {

			java.io.File fileTemp = java.io.File.createTempFile("env", "xml");
			OutputStream out = new FileOutputStream(fileTemp);
			out.write(data);

			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new EnvironmentResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(EnvironmentPackage.eNS_URI,
					EnvironmentPackage.eINSTANCE);

			URI uri = URI.createFileURI(fileTemp.getAbsolutePath());

			Resource resource = null;

			resource = resourceSet.getResource(uri, true);

			EnvironmentResourceImpl cResource = (EnvironmentResourceImpl) resource;
			EList rs = cResource.getContents();

			EnvironmentType environment = ((hPE.frontend.backend.environment.impl.DocumentRootImpl) rs
					.get(0)).getEnvironment();

			return environment;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates a file resource given the file handle and contents.
	 * 
	 * @param fileHandle
	 *            the file handle to create a file resource with
	 * @param contents
	 *            the initial contents of the new file resource, or
	 *            <code>null</code> if none (equivalent to an empty stream)
	 * @param monitor
	 *            the progress monitor to show visual progress with
	 * @exception CoreException
	 *                if the operation fails
	 * @exception OperationCanceledException
	 *                if the operation is canceled
	 */
	protected static void createFile(IFile fileHandle, InputStream contents,
			IProgressMonitor monitor) throws CoreException {
		if (contents == null)
			contents = new ByteArrayInputStream(new byte[0]);

		try {
			// Create a new file resource in the workspace
			// if (linkTargetPath != null)
			// fileHandle.createLink(linkTargetPath,
			// IResource.ALLOW_MISSING_LOCAL, monitor);
			// else {
			IPath path = fileHandle.getFullPath();
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			int numSegments = path.segmentCount();
			if (numSegments > 2
					&& !root.getFolder(path.removeLastSegments(1)).exists()) {
				// If the direct parent of the path doesn't exist, try to create
				// the
				// necessary directories.
				for (int i = numSegments - 2; i > 0; i--) {
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

	@Deprecated
	public static class BackEndLocationInfo {
		public String name = null;
		public String locURI = null;
		public String login = null;
		public String password = null;
		public IPath curdir = null;

		public BackEndLocationInfo() {
		}

		public BackEndLocationInfo(String name, String locURI, String login,
				String password, IPath curdir) {
			this.name = name;
			this.locURI = locURI;
			this.login = login;
			this.password = password;
			this.curdir = curdir;
		}

		public String toString() {
			return name;
		}

	}

	public static List<URI> fetchLocations() {

		List<URI> locations = new ArrayList<URI>();
		Map<String, BackEndLocationInfo> coreLocations = new HashMap<String, BackEndLocationInfo>();
		loadBackEndsInfo(coreLocations);
		
		for (BackEndLocationInfo c : coreLocations.values()) {
			locations.add(URI.createURI(c.locURI));
		}

		return locations;
	}

	public static URI fetchURI(String loc_name) {

		Map<String, BackEndLocationInfo> coreLocations = new HashMap<String, BackEndLocationInfo>();
		loadBackEndsInfo(coreLocations);

		if (coreLocations.containsKey(loc_name)) {
			return URI.createURI(coreLocations.get(loc_name).locURI);
		} else {
			return null;
		}
	}

	public static String fetchLocationName(URI createURI) {
		return "localhost";
	}

	public static String getLocationPresentationMessage(URI createURI) {
		return "presentation message";
	}

}
