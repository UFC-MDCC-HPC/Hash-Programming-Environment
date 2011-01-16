package hPE.xml.factory;

import hPE.HPEProperties;
import hPE.core.library.HPEComponentFileNotFound;
import hPE.core.library.HPELocationEntry;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpClassDefinition;
import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpMainDefinition;
import hPE.frontend.base.commands.FuseReplicatorCommand;
import hPE.frontend.base.commands.SupersedeCommand;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IInterfaceSlice;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HPackageLocation;
import hPE.frontend.base.model.HPort;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HReplicatorSplit;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.HVisualElement;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IHVisualElement;
import hPE.frontend.base.model.IHasColor;
import hPE.frontend.base.model.IPointsToReplicator;
import hPE.frontend.base.model.HReplicator.ReplicatorOrigin;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HPrimitiveAction;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;
import hPE.frontend.kinds.activate.model.protocol.HSemaphore;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;
import hPE.frontend.kinds.activate.model.protocol.HSignalAction;
import hPE.frontend.kinds.activate.model.protocol.HSkipAction;
import hPE.frontend.kinds.activate.model.protocol.HWaitAction;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.architecture.model.HArchitectureComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.domain.model.HDomainComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;
import hPE.frontend.kinds.enumerator.model.HEnumeratorInterfaceSlice;
import hPE.frontend.kinds.enumerator.model.HEnumeratorUnitSlice;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.service.model.HServiceComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.util.CommandLine;
import hPE.util.Pair;
import hPE.util.Triple;
import hPE.xml.component.ActionActivateType;
import hPE.xml.component.ActionCombinatorAltType;
import hPE.xml.component.ActionCombinatorParType;
import hPE.xml.component.ActionCombinatorSeqType;
import hPE.xml.component.ActionCombinatorType;
import hPE.xml.component.ActionSignalType;
import hPE.xml.component.ActionSkipType;
import hPE.xml.component.ActionType;
import hPE.xml.component.ActionWaitType;
import hPE.xml.component.BaseTypeType;
import hPE.xml.component.ColorComplexType;
import hPE.xml.component.ComponentBodyType;
import hPE.xml.component.ComponentFactory;
import hPE.xml.component.ComponentHeaderType;
import hPE.xml.component.ComponentInUseType;
import hPE.xml.component.ComponentPackage;
import hPE.xml.component.ComponentType;
import hPE.xml.component.DocumentRoot;
import hPE.xml.component.EnumerableComponentType;
import hPE.xml.component.EnumerableEntryType;
import hPE.xml.component.EnumerableType;
import hPE.xml.component.EnumerableUnitSliceType;
import hPE.xml.component.EnumerableUnitType;
import hPE.xml.component.EnumeratorFromRecursionType;
import hPE.xml.component.EnumeratorType;
import hPE.xml.component.ExtensionTypeType;
import hPE.xml.component.FusionOfReplicatorsType;
import hPE.xml.component.FusionType;
import hPE.xml.component.FusionsOfReplicatorsType;
import hPE.xml.component.InnerComponentType;
import hPE.xml.component.InnerRenamingType;
import hPE.xml.component.InterfaceParameter;
import hPE.xml.component.InterfaceParameterType;
import hPE.xml.component.InterfacePortType;
import hPE.xml.component.InterfaceRefType;
import hPE.xml.component.InterfaceSliceType;
import hPE.xml.component.InterfaceType;
import hPE.xml.component.ParameterRenaming;
import hPE.xml.component.ParameterSupplyType;
import hPE.xml.component.ParameterType;
import hPE.xml.component.PortSliceType;
import hPE.xml.component.RecursiveEntryType;
import hPE.xml.component.SourceFileType;
import hPE.xml.component.SourceType;
import hPE.xml.component.SplitLinkType;
import hPE.xml.component.SplitType;
import hPE.xml.component.SupportedKinds;
import hPE.xml.component.UnitBoundsType;
import hPE.xml.component.UnitRefType;
import hPE.xml.component.UnitSliceType;
import hPE.xml.component.UnitType;
import hPE.xml.component.VersionType;
import hPE.xml.component.VisualElementAttributes;
import hPE.xml.component.impl.DocumentRootImpl;
import hPE.xml.component.util.ComponentResourceFactoryImpl;
import hPE.xml.component.util.ComponentResourceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.swt.graphics.Color;

public final class HComponentFactoryImpl implements HComponentFactory {

	public static class DuplicatedSliceNamesException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 7585695943859883441L;

		/**
		 * 
		 */

		public DuplicatedSliceNamesException(HUnitSlice slice) {
			super("Duplicated slice name " + slice.getName() + " in the unit " + slice.getUnit().getTopUnit(null).getName2() + ".");
		}

	}

	public static class DuplicatedRefInnerException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8792075302351667897L;

		public DuplicatedRefInnerException(String ref) {
			super("Duplicated ID " + ref + " for inner components.");
		}

	}

	public static class UndefinedRefInnerException extends Exception {

		/**
		 * 
		 */

		public UndefinedRefInnerException(HComponent ic) {
			super("Undefined ID for an inner component of type " + ic.getComponentName());
		}

	}

	public HComponentFactoryImpl() {
		super();
	}

	public static HComponentFactory eInstance = new HComponentFactoryImpl();

	public void saveComponent(ComponentType cX, java.io.File file,
			IProgressMonitor monitor) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register the appropriate resource factory to handle all file
			// extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new ComponentResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put(ComponentPackage.eNS_URI,
					ComponentPackage.eINSTANCE);

			// If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createFileURI(file.getPath());
			Resource resource = resourceSet.createResource(uri);

			DocumentRoot dX = factory.createDocumentRoot();
			// ComponentType cX = saveComponent2(c);
			dX.setComponent(cX);

			// file.setContents(dX, true, false, monitor);

			resource.getContents().add(dX);
			resource.save(null);

		} catch (IOException e) {

		}

	}

	public void saveComponent(HComponent c, java.io.File file, IProgressMonitor monitor) throws UndefinedRefInnerException, DuplicatedRefInnerException, DuplicatedSliceNamesException {

		this.component = c;
		ComponentType cX = marshallComponent(c);
		this.saveComponent(cX, file, monitor);

	}

	// Loads a ComponentType object from XML in a HComponent object
	public HComponent loadComponent(URI uri, boolean isTop, boolean isExtending, boolean isImplementing, boolean cached, boolean relativePath)
			throws HPEInvalidComponentResourceException {
			ComponentType component = loadComponentX(uri, cached, relativePath);
			return buildComponent(component, uri, isTop, isExtending, isImplementing);
	}

	private static String workspace_path = null;
	public static IWorkspace workspace = checkWorkspace();
	
	public static void setWorkspacePath(String workspace_path) {
		HComponentFactoryImpl.workspace_path = workspace_path;
	}

	public static String getWorkspacePath() {
		return workspace_path;
	}

	// Loads a ComponentType object from XML in a HComponent object
	public ComponentType loadComponentX(URI uri, boolean cache, boolean relativePath)
			throws HPEInvalidComponentResourceException {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new ComponentResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(ComponentPackage.eNS_URI, ComponentPackage.eINSTANCE);

			Resource resource = null;
			/*if (this.workspace != null || cache) { 
				resource = resourceSet.getResource(uri, true);
			}
			else*/ if (relativePath){
				URI uriFull = URI.createFileURI(this.getWorkspacePath() + Path.SEPARATOR + uri.toString());
				resource = resourceSet.getResource(uriFull, true);
			} else {
				URI uriFull = uri; // URI.createFileURI(uri.toString());
				resource = resourceSet.getResource(uriFull, true);
			}

			ComponentResourceImpl cResource = (ComponentResourceImpl) resource;
			EList rs = cResource.getContents();
			
			if (rs.size() != 1)
				throw new HPEInvalidComponentResourceException();
			
			ComponentType component = ((DocumentRootImpl) rs.get(0)).getComponent();

			return component;

		} catch (Exception e) {
			throw new HPEInvalidComponentResourceException(e);
		}
	}

    public static IPath buildWPath(IPath path_) {
    	IPath path = path_.setDevice(null);
    	File file = path.toFile();    	
    	boolean isRoot = file.exists() && path.toFile().isAbsolute();
    	if (!isRoot) {
			IPath wpath = new Path(getWorkspacePath());			
			IPath rrr = wpath.append(path_);
			File fileW = rrr.toFile();
			System.out.print(fileW.exists());
			return rrr;
    	} else
    		return path_;   
    }
    
    public static java.io.File getFileInWorkspace(IPath path) {
    	
    	if (path.segment(0).equals("file:")) {
    		String pathString = path.toString();
    		path = path.removeFirstSegments(1);
    		if (pathString.startsWith("file:" + Path.SEPARATOR)) {
    		   path = path.makeAbsolute();
    		}
    	}
    	
    	if (path.toFile().isAbsolute()) {
	        File file = null;
			IPath fullpath = path;
			file = fullpath.toFile();        
	        return file;
    	} else {
	        File file = null;
	    	IPath wpath = new Path(getWorkspacePath());			
			IPath fullpath = wpath.append(path);
			file = fullpath.toFile();        
	        return file;
    	}
    	
    	//IPath wpath = new Path(getWorkspacePath());			
		//IPath rrr = wpath.append(path);
	    //return rrr;   
    }

    public static boolean existsInWorkspace(IPath path) {
    	IPath wpath = null;
    	if (path.segment(0).equals("file:")) {
    		String pathString = path.toString();
    		path = path.removeFirstSegments(1);
    		if (pathString.startsWith("file:" + Path.SEPARATOR)) {
    		   path = path.makeAbsolute();
    		}
    	}
    	File file = path.toFile();
    	if (file.isAbsolute()) {
    		wpath = path;
    	} else {
    		wpath = buildWPath(path);	
    	}
    	
    	IPath wpath_ = new Path(wpath.toString().replaceAll("%20", " "));
    	
    	java.io.File path_bin = wpath_.toFile();		
		return path_bin.exists();
    }
	
	
	private static IWorkspace checkWorkspace() {
		IWorkspace w = null;
		try {
		    w = ResourcesPlugin.getWorkspace();
		    workspace_path = w.getRoot().getLocation().toString();
		} catch (IllegalStateException e) {
			System.out.print(e.getMessage());
		}
		return w;
	}

	private Map<String, ComponentInUseType> mC1 = null;
	private Map<ComponentInUseType, HComponent> mC2 = null;
	private Map<String, InterfaceType> mI1 = null;
	private Map<InterfaceType, HInterface> mI2 = null;
	private Map<String, UnitType> mU1 = null;
	private Map<UnitType, HUnit> mU2 = null;
	private Map<String, EnumeratorType> mR1 = null;
	private Map<EnumeratorType, HReplicator> mR2 = null;

	private HComponent component = null;

	private void loadSuperTypeComponent(ComponentHeaderType xCheader)
			throws HPEInvalidComponentResourceException, HPEComponentFileNotFound {
		BaseTypeType xBaseType = xCheader.getBaseType();
		if (xBaseType != null) {
			ExtensionTypeType extType = xBaseType.getExtensionType();
			ComponentInUseType baseComponent = xBaseType.getComponent();


			String name = baseComponent.getName();
			URI locationUri = URI.createURI(baseComponent.getLocation()); 
			VisualElementAttributes v = baseComponent.getVisualDescription();
			Rectangle bounds = new Rectangle((int) v.getX(), (int) v.getY(),(int) v.getW(), (int) v.getH());
			String package_ = baseComponent.getPackage();
			String version = baseComponent.getVersion();
			
			java.io.File fileCache = getCachePath(package_,name,version);
			URI innerUri = null;

			boolean copyToCache = false;
			boolean retrieveLibraries = false;
			if (!fileCache.exists()) {
				if (locationUri.scheme() == null
						|| !locationUri.scheme().equals("http")) {
					// innerUri = locationUri;
					IPath pathC = new Path(locationUri.toString());	
					IPath path = HComponentFactoryImpl.buildWPath(pathC);
					innerUri = URI.createFileURI(path.toString().replaceAll("%20", " "));

					copyToCache = true;
				} else {
					java.io.File file = HPELocationEntry.getComponent(package_.replace(".", ":").split(":"), name, null,locationUri);
					innerUri = URI.createFileURI(file.getAbsolutePath());
					retrieveLibraries = true;
				}
			} else {
				if (locationUri.scheme() == null
						|| !locationUri.scheme().equals("http")) {
					// COMPARE DATES OF THE PROJECT FILE AND CACHED FILE.
					IPath pathC = new Path(locationUri.toString());	
					// IPath path = ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation();
					IPath path = HComponentFactoryImpl.buildWPath(pathC);
					long lastDataCache = fileCache.lastModified();
				    java.io.File fileProject = new File(path.toString());	
				    long lastDateProject = fileProject.lastModified();	
				    // CHECK COMPILED SOURCES STATUS
				    java.io.File parentFileCache = new File(fileCache.getParentFile().getAbsolutePath() + Path.SEPARATOR + "bin" + Path.SEPARATOR + "1.0.0.0");
				    java.io.File parentFileProject = new File(fileProject.getParentFile().getAbsolutePath() + Path.SEPARATOR + "bin" + Path.SEPARATOR + "1.0.0.0");						    
				    FilenameFilter filter = new FilenameFilter () {
						@Override
						public boolean accept(File dir, String name) {									
							return name.endsWith(".dll");
						}};
				    java.io.File[] fsCache = parentFileCache.listFiles(filter);
					java.io.File[] fsProject = parentFileProject.listFiles(filter);
				    
	                if ((fsCache != null && fsProject != null) && (lastDateProject > lastDataCache || fsProject.length > fsCache.length || (fsProject != null && fsCache == null))) 
	                {
						IPath pathC1 = new Path(locationUri.toString());	
						IPath path1 = HComponentFactoryImpl.buildWPath(pathC1);
						innerUri = URI.createFileURI(path1.toString().replaceAll("%20", " "));
						copyToCache = true;
	                } else 
					    innerUri = URI.createFileURI(fileCache.getAbsolutePath());
				} else {
					innerUri = URI.createFileURI(fileCache.getAbsolutePath());
				}
			}
			
			this.isSubType = extType.isSetExtends() && extType.isExtends();
			this.isConcrete = extType.isSetImplements()	&& extType.isImplements();
			
			HComponent superType = (new HComponentFactoryImpl()).loadComponent(innerUri, false, this.isSubType, this.isConcrete, !copyToCache, false);
			
			if (copyToCache)
				copyProjectToCache(superType, version, locationUri);
			
			if (retrieveLibraries)
				retrieveLibraries(superType, locationUri);

			mC1.put(baseComponent.getLocalRef(), baseComponent);
			mC2.put(baseComponent, superType);

			component.loadComponent(superType, bounds.getLocation());
			this.basetype = superType;


			superType.setBounds(bounds);
			superType.setName(baseComponent.getLocalRef());

			loadParameterRenamings(baseComponent, superType);
			loadPorts(baseComponent, superType);
			loadUnitBounds(baseComponent, superType);

			
		}

	}

	private HComponent basetype = null;
	private boolean isConcrete = false;
	private boolean isSubType = false;

	private void loadInnerComponents(ComponentBodyType xCinfo) {
			for (InnerComponentType xInnerC : xCinfo.getInnerComponent()) {
				try {
	
					mC1.put(xInnerC.getLocalRef(), xInnerC);
		
					String name = xInnerC.getName();	
					URI locationUri = xInnerC.getLocation() != null ?  URI.createURI(xInnerC.getLocation()) : 
						                                               URI.createURI(HPEProperties.getInstance().getValue("local_location"));
					String package_ = xInnerC.getPackage();
					String ref = xInnerC.getLocalRef();
					String version = xInnerC.getVersion();
					boolean isExposed = xInnerC.isExposed();
					java.io.File fileCache = getCachePath(package_,name,version);
					URI innerUri = null;
		
					boolean copyToCache = false;
					boolean retrieveLibraries = false;
					if (!fileCache.exists()) {
						if (locationUri.scheme() == null
								|| !locationUri.scheme().equals("http")) {
							IPath pathC = new Path(locationUri.toString());	
							IPath path = HComponentFactoryImpl.buildWPath(pathC);
							innerUri = URI.createFileURI(path.toString().replaceAll("%20", " "));
							copyToCache = true;
						} else {
							java.io.File file = HPELocationEntry.getComponent(package_
									.replace(".", ":").split(":"), name, null,
									locationUri);
							innerUri = URI.createFileURI(file.getAbsolutePath());
							retrieveLibraries = true;
						}
					} else {
						if (locationUri.scheme() == null
								|| !locationUri.scheme().equals("http")) {
							// COMPARE DATES OF THE PROJECT FILE AND CACHED FILE.
							IPath pathC = new Path(locationUri.toString());	
							//IPath path = ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation();
							IPath path = HComponentFactoryImpl.buildWPath(pathC);
							long lastDataCache = fileCache.lastModified();
						    java.io.File fileProject = new File(path.toString());	
						    long lastDateProject = fileProject.lastModified();
						    // COMPARE BINARY FOLDERS
						    java.io.File parentFileCache = new File(fileCache.getParentFile().getAbsolutePath() + Path.SEPARATOR + "bin" + Path.SEPARATOR + "1.0.0.0");
						    java.io.File parentFileProject = new File(fileProject.getParentFile().getAbsolutePath() + Path.SEPARATOR + "bin" + Path.SEPARATOR + "1.0.0.0");						    
						    FilenameFilter filter = new FilenameFilter () {
								@Override
								public boolean accept(File dir, String name) {									
									return name.endsWith(".dll");
								}};
						    java.io.File[] fsCache = parentFileCache.listFiles(filter);
							java.io.File[] fsProject = parentFileProject.listFiles(filter);
						    
			                if ((fsCache != null && fsProject != null) && (lastDateProject > lastDataCache || fsProject.length > fsCache.length || (fsProject != null && fsCache == null))) {
								IPath pathC1 = new Path(locationUri.toString());	
								IPath path1 = HComponentFactoryImpl.buildWPath(pathC1);
								innerUri = URI.createFileURI(path1.toString().replaceAll("%20", " "));
								copyToCache = true;
			                } else 
							    innerUri = URI.createFileURI(fileCache.getAbsolutePath());
						} else {
							innerUri = URI.createFileURI(fileCache.getAbsolutePath());
						}						
					}		
		
					HComponent innerC = (new HComponentFactoryImpl()).loadComponent(innerUri,false, false, false, !copyToCache, false);		
		
				    if (locationUri.scheme() != null && locationUri.scheme().equals("http")) {
						innerC.setRemoteURI(locationUri);						
					}
					
					if (copyToCache)
						copyProjectToCache(innerC, version, locationUri);
					
					if (retrieveLibraries)
						retrieveLibraries(innerC, locationUri);
					
					mC2.put(xInnerC, innerC);
		
					int x,y,w,h,r,g,b;
					Color color;
					if (xInnerC.getVisualDescription() != null) {
						x = (int) xInnerC.getVisualDescription().getX();
						y = (int) xInnerC.getVisualDescription().getY();
						w = (int) xInnerC.getVisualDescription().getW();
						h = (int) xInnerC.getVisualDescription().getH();
						r = xInnerC.getVisualDescription().getColor().getR();
						g = xInnerC.getVisualDescription().getColor().getG();
						b = xInnerC.getVisualDescription().getColor().getB();
						color = new Color(null, r, g, b);
					} else {
					   	x = 0; y = 0; w = 100; h = 100;
					   	color = ColorConstants.white;
					}
					
					
		
					Point where = new Point(x, y);
					component.loadComponent(innerC, where);
					innerC.setBounds(new Rectangle(x, y, w, h));
					innerC.setColor(color);
					innerC.setName(ref);
					innerC.setExposed(isExposed);
					// innerC.setPackagePath(new Path(package_));
		
					loadParameterRenamings(xInnerC, innerC);
					loadPorts(xInnerC, innerC);
					loadUnitBounds(xInnerC, innerC);
				
				}
				catch (HPEInvalidComponentResourceException e) {
					String message = "ERROR loading component " + xInnerC.getPackage() + "." + xInnerC.getName() + " from " + xInnerC.getLocation() + "! (inner component " + xInnerC.getLocalRef() + ").";;
					System.err.println(message);
					JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
				} 
				catch (HPEComponentFileNotFound e) {
					String message = "Component " + xInnerC.getPackage() + "." + xInnerC.getName() + " NOT fuound in " + xInnerC.getLocation() + "! (inner component " + xInnerC.getLocalRef() + ").";
					System.err.println(message);
					JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
				} 
	
			}
		//catch (IOException e) {
			
		//}
		

	}

	private void retrieveLibraries(HComponent innerC, URI locationUri) {

		// List<Integer[]> versions = innerC.getVersions();
		
		for (HInterface i : innerC.getInterfaces()) 
			if (i.getConfiguration() == innerC) {
				//for (Integer[] version : versions) {					
			        String versionID = null; // HInterface.toStringVersion(version);
					HBESourceVersion<HBEAbstractFile> sv = i.getSourceVersion(versionID == null ? "1.0.0.0" : versionID);
					for (HBEAbstractFile file : sv.getFiles()) {
						String packageName = innerC.getPackagePath().toString();
						String componentName = innerC.getComponentName();
						HPELocationEntry.getBinaryFile(packageName, componentName, versionID, file, locationUri);
					}
				//}
		}
		
		
	}

	public static void copyProjectToCache(HComponent innerC, String version, URI locationURI) {

        IPath pathC = new Path(innerC.getLocalLocation());		
    	if (pathC.segment(0).equals("file:")) {
    	    pathC = pathC.removeFirstSegments(1).makeAbsolute();
    	}
				
		//IPath path = ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation().removeLastSegments(1);
		IPath path = HComponentFactoryImpl.buildWPath(pathC.setDevice(null)).removeLastSegments(1);
		
		String cachePath = addSegment(HPEProperties.getInstance().getValue("cache_root"), (new Path(locationURI.toString())).removeLastSegments(1).toString());
				
		try {
			copyDirectory(new File(path.toString()), new File(cachePath));
  		    String gacutil_path = HPEProperties.getInstance().getValue("gacutil_path");
  		    List<String> l = innerC.getModuleNames(version);
  		    for (String fileName : l) {
	            CommandLine.runCommand(new String[] {gacutil_path, "-i", ".." + fileName}, path.toFile());
  		    }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void copyDirectory(File srcPath, File dstPath) throws IOException {

		if (srcPath.isDirectory()){
		
			if (!dstPath.exists()){			
				dstPath.mkdir();			
			}
			
			String files[] = srcPath.list();
			
			for(int i = 0; i < files.length; i++){
				copyDirectory(new File(srcPath, files[i]), 
				new File(dstPath, files[i]));			
			}
		}
		else{
			if(!srcPath.exists()){
				System.out.println("File or directory does not exist.");
				
				// System.exit(0);
			}		
			else
			{
				InputStream in = new FileInputStream(srcPath);
				OutputStream out = new FileOutputStream(dstPath); 
				// Transfer bytes from in to out
				byte[] buf = new byte[1024];
				
				int len;
				
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
			}
		}
		
		// System.out.println("Directory copied.");

}
	

	private static File getCachePath(URI locationUri) {

		String cachePath = HPEProperties.getInstance().getValue("cache_root");

		java.io.File cacheFilePath = new java.io.File(cachePath);
		if (!cacheFilePath.exists())
			cacheFilePath.mkdir();

		String fileName = addSegment(cachePath,locationUri.toString()) ;
		
		java.io.File configFilePath = new java.io.File(fileName);
		configFilePath = new java.io.File(configFilePath.getParent());
		if (!configFilePath.exists())
			configFilePath.mkdir();

		java.io.File binFilePath = new java.io.File(addSegment(configFilePath.getAbsolutePath(),"bin"));
		if (!binFilePath.exists())
			binFilePath.mkdir();
		
		
		// cachePath + Path.SEPARATOR + locationUri.toString();
		
		return new File(fileName);
	}
	
	private static String addSegment(String path, String adding) {
		int l = path.length() - 1;
		if (path.charAt(l) == Path.SEPARATOR) {
			return path + adding;
		} else {
			return path + Path.SEPARATOR + adding;
		}			
	}

	public static File getCachePath(String pk, String componentName, String version) {
		
		URI locationURI = HComponent.getStandardLocationPath(pk, componentName, version); 
		
		return getCachePath(locationURI);
	}

	
	private void loadUnitBounds(ComponentInUseType xInnerC, HComponent innerC) {
		// Configure unit bounds
		for (UnitBoundsType uBound : xInnerC.getUnitBounds()) {
			unitBounds.add(new Pair<HComponent, UnitBoundsType>(innerC, uBound));
		}
	}

	private void loadParameterRenamings(ComponentInUseType xInnerC,
			HComponent innerC) {
		// Apply Parameter Renaming
		for (ParameterRenaming p : xInnerC.getParameter()) {
			String formFieldId = p.getFormFieldId();
			String varName = p.getVarName();
			if (!formFieldId.equals("type ?"))
			   innerC.updateVariableName(formFieldId, varName);
		}
	}

	/*
	 * private void loadPorts(ComponentInUseType xInnerC, HComponent innerC) {
	 * // Load Ports for (PortType port : xInnerC.getPort()) { String pRef =
	 * port.getPRef(); boolean pIsExposed = port.isExposed(); HComponent p =
	 * innerC.getExposedComponentByName(pRef); VisualElementAttributes ve =
	 * port.getVisualDescription(); if (ve != null) { int x1 = (int) ve.getX();
	 * int y1 = (int) ve.getY(); int h1 = (int) ve.getH(); int w1 = (int)
	 * ve.getW(); Rectangle bounds = new Rectangle(x1,y1,w1,h1);
	 * p.setBounds(bounds); } p.setExposed(pIsExposed); }
	 * 
	 * }
	 */

	private List<Entry<InnerComponentType, HComponent>> portsLaterFetch;

	private void loadPorts(ComponentInUseType xInnerC, HComponent innerC) {
		// Load Ports
		for (InnerComponentType port : xInnerC.getPort()) {
			String pRef = port.getLocalRef();
			boolean pIsExposed = port.isExposed();
			HComponent p = innerC.getExposedComponentByName(pRef);
			if (p != null) {
				VisualElementAttributes ve = port.getVisualDescription();
				if (ve != null) {
					int x1 = (int) ve.getX();
					int y1 = (int) ve.getY();
					int h1 = (int) ve.getH();
					int w1 = (int) ve.getW();
					Rectangle bounds = new Rectangle(x1, y1, w1, h1);
					p.setBounds(bounds);
				}
				p.setExposed(pIsExposed);
			} else {
				System.err.print("Port " + pRef + " not found !");
			}
		}

	}

	private void laterFetchPorts() {
		for (Entry<InnerComponentType, HComponent> e : portsLaterFetch) {
			InnerComponentType portX = e.getKey();
			String pRef = portX.getLocalRef();
			HComponent c = e.getValue();
			HComponent port = c.getExposedComponentByName(pRef);
			mC2.put(portX, port);
		}
	}

	private List<Pair<HComponent, UnitBoundsType>> unitBounds = new ArrayList<Pair<HComponent, UnitBoundsType>>();

	private void loadUnitBounds() throws HPEInvalidComponentResourceException {

		// Configure unit bounds
		for (Pair<HComponent, UnitBoundsType> ub : unitBounds) {
			HComponent innerC = ub.fst();
			UnitBoundsType uBound = ub.snd();
			VisualElementAttributes ve = uBound.getVisualDescription();
			int x1 = (int) ve.getX();
			int y1 = (int) ve.getY();
			int h1 = (int) ve.getH();
			int w1 = (int) ve.getW();
			Rectangle bounds = new Rectangle(x1, y1, w1, h1);
			IHUnit u = null;
			if (uBound.isSetReplica()) {
				u = innerC.fetchUnit(uBound.getURef(), (int) uBound
						.getReplica());
				if (u == null)
					System.err.println("Replicated unit " + uBound.getURef() + " not found when loading inner component " + innerC.getRef());
					// throw new HPEInvalidComponentResourceException( "Replicated unit not found in load inner components !");
			} else {
				u = innerC.fetchUnit(uBound.getURef());
				if (u == null)
					System.err.println("Unit " + uBound.getURef() + " not found when loading inner component " + innerC.getRef());
					//throw new HPEInvalidComponentResourceException( "Unit not found in load inner components !");
			}
			if (u != null) {
			   u.setBounds(bounds);
			}
		}

	}

	private void loadSplits(ComponentBodyType xCinfo)
			throws HPEInvalidComponentResourceException {

		// Splits.
		for (SplitType xSplit : xCinfo.getSplit()) {
			String eRef = xSplit.getERef();
			int n = xSplit.getN();

			List<String> oRef = xSplit.getOriginRef();
			HComponent c = !oRef.isEmpty() ? this.mC2.get(mC1.get(oRef.get(0))) : this.component;
			HReplicator enumerator = c.lookForReplicator(eRef, oRef);
			
			String cRefPermutation = xSplit.getCRefPermutation();
			HEnumeratorComponent cPermutation = (HEnumeratorComponent) (cRefPermutation != null ? this.mC2.get(mC1.get(cRefPermutation)) : null);

			EList<SplitLinkType> splitLinks = xSplit.getSplitLink();
			EList<String> splitEnums = xSplit.getSplitEnumerator();

			List<HLinkToReplicator> sLinks = new ArrayList<HLinkToReplicator>();

			for (SplitLinkType sl : splitLinks) {
				String cRef = sl.getCRef();
				String uRef = sl.getURef();

				HComponent ic = mC2.get(mC1.get(cRef));
				HLinkToReplicator l = enumerator.getLinkForItem(ic.fetchUnit(uRef));
				if (l != null) {
					sLinks.add(l);
				} else
					throw new HPEInvalidComponentResourceException(
							"Link to Replicator not found");
				
			}

			HReplicatorSplit split = enumerator.split(n, "", sLinks, component, null);
			if (cPermutation != null) {
				split.setPermutation(cPermutation);
				// component.hideInnerComponent(cPermutation);
			}
			if (splitEnums.size() != split.getReplicators().size())
				throw new HPEInvalidComponentResourceException();
			Iterator<String> ses = splitEnums.iterator();
			Iterator<HReplicator> eSplits = split.getReplicators().iterator();
			while (ses.hasNext() && eSplits.hasNext()) {
				String eRefSplit = ses.next();
				HReplicator eSplit = eSplits.next();
				eSplit.setRef(eRefSplit);
				if (this.delayedSplits.containsKey(eRefSplit)) {
					this.configureReplicator(eSplit, this.delayedSplits.get(eRefSplit));
				}
			}

		}

	}

	private void setupParameters(ComponentBodyType xCinfo) {

		EList<ParameterType> parametersX = xCinfo.getParameter();
		
		for (ParameterType param : parametersX) {
			String formFieldId = param.getFormFieldId();
			String sBaseC = param.getComponentRef();
			HComponent baseC = mC2.get(mC1.get(sBaseC));
			baseC.setParameter(formFieldId);			
		}

	}

	private void setupVariableNamesOfTopLevelInners(ComponentBodyType xCinfo) {

		for (ParameterType param : xCinfo.getParameter()) {
			String sBaseC = param.getComponentRef();
			HComponent baseC = mC2.get(mC1.get(sBaseC));
			String varName = param.getVarName();
			if (baseC.isDirectSonOfTheTopConfiguration()) {
			   baseC.setVariableName(varName);			
			}
		}

	}

	private void supplyParameters(ComponentBodyType xCinfo) {

		for (ParameterSupplyType xSupply : xCinfo.getSupplyParameter()) {
			String varName = xSupply.getVarName();	 
			String cRef = xSupply.getCRef();
			ComponentInUseType c1 = mC1.get(cRef);
			if (c1 != null) {
			    HComponent cSupply = mC2.get(mC1.get(cRef));
			    if (cSupply != null)
			       component.supplyParameter(varName, cSupply);
			} else {
				System.err.print(cRef + " not found in suppyParameters (HComponentFactoryImpl)" );
			}
		}

	}

	private void readInterfaces(ComponentBodyType xCinfo) {

		mI1 = new HashMap<String, InterfaceType>();
		mI2 = new HashMap<InterfaceType, HInterface>();

		for (InterfaceType xI : xCinfo.getInterface()) {
			String iName = xI.getIRef();
			mI1.put(iName, xI);
		}
	}

	private void loadUnits(ComponentBodyType xCinfo)
			throws HPEInvalidComponentResourceException, HPEAbortException {

		mU1 = new HashMap<String, UnitType>();
		mU2 = new HashMap<UnitType, HUnit>();

		for (UnitType xU : xCinfo.getUnit()) {
			HUnit u = buildUnit(xU, component);
		}

	}

	private void loadEnumerators(ComponentBodyType xCinfo)
			throws HPEInvalidComponentResourceException {

		mR1 = new HashMap<String, EnumeratorType>();
		mR2 = new HashMap<EnumeratorType, HReplicator>();
		prs = new ArrayList<Pair<HReplicator, EnumerableType>>();

		Map<HReplicator, EnumeratorType> delayConfigureReplicator = new HashMap<HReplicator, EnumeratorType>();

		for (EnumeratorType xE : xCinfo.getEnumerator()) {
			String ref = xE.getRef().trim();
			boolean fromSplit = xE.isFromSplit();
			EnumeratorFromRecursionType fromRecursion = xE.getFromRecursion();
			List<String> oRef = xE.getOriginRef();
			HReplicator r = null;
			if (!oRef.isEmpty()) {
				List<String> oRefCopy = new ArrayList<String>();
				for (String s : oRef)
					oRefCopy.add(s);
				String oCRef = oRefCopy.get(0);
				HComponent oC = mC2.get(mC1.get(oCRef));
				if (oC == null) {
					System.err.println("Origin component " + oCRef + " of replicator " + ref + " was not found !");
					JOptionPane.showMessageDialog(null,
							"HComponentFactoryImpl.loadEnumerators(): Origin component " + oCRef + " of replicator " + ref + " was not found !", 
		        		    "Loading Component Error",
		        		    JOptionPane.ERROR_MESSAGE);
				} else {
					r = oC.lookForReplicator(ref, oRefCopy);				
					
					if (r == null) {	
						System.err.println("Replicator " + ref + " not found in origin component " + oCRef + " !");
						JOptionPane.showMessageDialog(null,
								"HComponentFactoryImpl.loadEnumerators(): Replicator " + ref + " not found in origin component " + oCRef + " !", 
			        		    "Loading Component Error",
			        		    JOptionPane.ERROR_MESSAGE);
					}
				}
				
			} else if (fromSplit) {
				delayedSplits.put(ref, xE);
			} else if (fromRecursion != null) {
				String cRef = fromRecursion.getCRef();
				HComponent oC = mC2.get(mC1.get(cRef));
				r = oC.getRecEnumerator();
			} else {
				r = new HReplicator(component, new Point(0, 0));
				r.setRef(ref);
			}

			if (r != null) {
				delayConfigureReplicator.put(r,xE);
			}
		}
		
		for (Entry<HReplicator, EnumeratorType> e : delayConfigureReplicator.entrySet()) {
			configureReplicator(e.getKey(), e.getValue());			
		}
	}
	
	

	private void configureReplicator(HReplicator r, EnumeratorType xE) {

		String varId = xE.getVarId();
		int factor = xE.getCardinality();
		int x, y, w, h;
		if (xE.getVisualDescription() != null) {
			x = (int) xE.getVisualDescription().getX();
			y = (int) xE.getVisualDescription().getY();
			w = (int) xE.getVisualDescription().getW();
			h = (int) xE.getVisualDescription().getH();
		} else {
			x = y = w = h = 0;
		}
		
		r.setVaridForced(varId);
		if (factor > 0)
			r.setFactor(factor);
		else
			r.setUndeterminedFactor();
		r.setBounds(new Rectangle(x, y, w, h));

		// LINKS
		for (EnumerableType xL : xE.getLinks()) {
			prs.add(new Pair<HReplicator, EnumerableType>(r, xL));
		}
	}

	private Map<String, EnumeratorType> delayedSplits = new HashMap<String, EnumeratorType>();

	private List<Pair<HReplicator, EnumerableType>> prs;

	private void setRecursive(ComponentBodyType xCinfo) {

		Iterator<RecursiveEntryType> rs = xCinfo.getRecursiveEntry().iterator();
		while (rs.hasNext()) {
			RecursiveEntryType r = rs.next();
			String cRef = r.getCRef();

			HComponent c = mC2.get(mC1.get(cRef));
			c.setRecursive(true);

		}

	}

	// Builds an HComponent object
	public HComponent buildComponent(ComponentType xC, URI uri, boolean isTop, boolean isExtending, boolean isImplementing) {

		try {
			ComponentHeaderType xCheader = xC.getHeader();
			ComponentBodyType xCinfo = xC.getComponentInfo();

			String name = xCheader.getName();
			SupportedKinds kind = xCheader.getKind();
			String packagePath = xCheader.getPackagePath();
			String hash_component_UID = xCheader.getHashComponentUID();			
			String locationURI = xCheader.getLocationURI(); 
			boolean isAbstract = xCheader.isIsAbstract();			
			
			this.isConcrete = false;	
			this.isSubType = false;

			component = this.createComponent(kind, name, uri);
			component.setPackagePath(new Path(packagePath));
			component.setHashComponentUID(hash_component_UID);

			VisualElementAttributes v = xCheader.getVisualAttributes();
			if (v!=null) {
				Color color;
				if (v.getColor() != null) {
					int r = v.getColor().getR();
					int g = v.getColor().getG();
					int b = v.getColor().getB();
					color = new Color(null, r, g, b);
				} else {
					color = ColorConstants.white;
				}
				
				component.setColor(color);
			}
			
			if (locationURI != null) 
				component.setRemoteURI(URI.createURI(locationURI));
			
			if (isTop) 
				checkKeyFile();
			
			if (xCheader.isSetIsAbstract())
				component.setAbstract(isAbstract);

			mC1 = new HashMap<String, ComponentInUseType>();
			mC2 = new HashMap<ComponentInUseType, HComponent>();
			ports = new HashMap<HInterface, List<InterfacePortType>>();
			unitBounds = new ArrayList<Pair<HComponent, UnitBoundsType>>();
			portsLaterFetch = new ArrayList<Entry<InnerComponentType, HComponent>>();

			loadSuperTypeComponent(xCheader);
			loadVersions(xCheader.getVersions());

			if (xCinfo != null) {

				loadInnerComponents(xCinfo);

				applyRenaming(xCinfo);
				loadEnumerators(xCinfo);
				loadSplits(xCinfo); 
				setupVariableNamesOfTopLevelInners(xCinfo);
				laterFetchPorts();

				if (this.isConcrete)
					component.setImplements(this.basetype);
				if (this.isSubType)
					component.setExtends(this.basetype);

				readInterfaces(xCinfo); //
				loadUnits(xCinfo);//
				setupParameters(xCinfo);
				supplyParameters(xCinfo);
				setRecursive(xCinfo);
				loadInterfaces(xCinfo, isTop, isImplementing);
				linksToReplicators(); //
				fuseReplicators(xCinfo);
				loadUnitBounds();

				
				applyFusions(xCinfo);

				loadInterfacePorts();
				
				//component.performAdjustSupply();
			}

			return component;

		} catch (HPEInvalidComponentResourceException e) {
			e.printStackTrace();
		} catch (HPEUnknownKindException e) {
			e.printStackTrace();
		} catch (HPEAbortException e) {
			e.printStackTrace();
		} catch (HPEComponentFileNotFound e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	

	private void checkKeyFile() throws IOException {
		this.component.createComponentKey();

	}

	private void loadVersions(EList<VersionType> versions) {
		if (versions != null) {
			for (VersionType version : versions) {
				Integer[] version_ = new Integer[4];
				version_[0] = version.getField1();
				version_[1] = version.getField2();
				version_[2] = version.getField3();
				version_[3] = version.getField4();
				component.newVersion(version_);
			}
		}

	}

	private void loadInterfacePorts() {
		
		
		for (Entry<HInterface, List<InterfacePortType>> e : ports.entrySet()) {
			HInterface i = e.getKey();
			// Iterator<HPort> iPorts = i.getPorts().iterator();
			List<InterfacePortType> ps = e.getValue();
			for (InterfacePortType xP : ps) {
				String name = xP.getName();
				PortSliceType port_ = xP.getSlice().get(0);
				String sOwner = port_.getSRef();
				String portName = port_.getPRef();
				HPort port = i.fetchPort(sOwner, portName);
				// HPort port = ;
				if (port != null) {
					VisualElementAttributes v = xP.getVisualDescription();
					// HPort port = iPorts.next();
					port.setName(name);
					int x = (int) v.getX();
					int y = (int) v.getY();
					int w = (int) v.getW();
					int h = (int) v.getH();
					Rectangle r = new Rectangle(x, y, w, h);
					port.setBounds(r);
				}
			}
		}

	}

	private void linksToReplicators()
			throws HPEInvalidComponentResourceException {

		for (Pair<HReplicator, EnumerableType> et : prs) {
			HReplicator r = et.fst();
			EnumerableType xL = et.snd();
			IPointsToReplicator pr = lookForEnumeratedItem(xL);
			if (pr != null /* POG: && !(pr instanceof HUnitSlice) */)
				try {
					if (!pr.isReplicatedBy(r)) {
						pr.setReplicator(r);
					} else {
					}
					if (xL instanceof EnumerableEntryType) {
						//if (((EnumerableEntryType) xL).getPermutation() != null) {
							//String cRef = ((EnumerableEntryType) xL).getPermutation();
							//HComponent ec = this.mC2.get(mC1.get(cRef));
							//if (!(ec instanceof HEnumeratorComponent)) {
							//	throw new HPEInvalidComponentResourceException();
							//} else {
							//	HLinkToReplicator lr = r.getLinkForItem(pr);
								//lr.setPermutation((HEnumeratorComponent) ec);
								//this.component.removeComponent(ec);
							//}
						//}
					}
				} catch (HPEUnmatchingEnumeratorsException e) {
					throw new HPEInvalidComponentResourceException(e);
				}
		}

	}

	private void fuseReplicators(ComponentBodyType xCinfo) {

		List<HReplicator> rs = new ArrayList<HReplicator>();

		for (FusionsOfReplicatorsType f : xCinfo.getFusionsOfReplicators()) {
			for (FusionOfReplicatorsType ff : f.getFusionOfReplicators()) {
				String eRef = ff.getERef();
				List<String> cRef = ff.getOriginRef();
				ComponentInUseType tt = mC1.get(cRef.get(0));
				if (tt != null) {
					HComponent c = !cRef.isEmpty() ? this.mC2.get(tt) : this.component;
					HReplicator r = c.lookForReplicator(eRef, cRef);
					if (r != null) rs.add(r);
				} else {
					System.out.println(cRef + " not found (fuseReplicators)");
				}
			}

			CompoundCommand cc = new CompoundCommand();

			HReplicator rTop = null;
			for (HReplicator r : rs) {
				FuseReplicatorCommand c = (FuseReplicatorCommand) new FuseReplicatorCommand(r);
				if (rTop == null)
					rTop = r;
				c.setTop(rTop);
				cc.add(c);
			}

			cc.execute();

			rs.clear();
		}

	}

	private void loadInterfaces(ComponentBodyType xCinfo, boolean isTop, boolean isImplementing)
			throws HPEInvalidComponentResourceException, HPEAbortException {

		for (UnitType xU : xCinfo.getUnit()) {
			String uName = xU.getURef();
			HUnit u = mU2.get(mU1.get(uName));
			loadInterface(xU, u, isTop, isImplementing);
		}

	}

	private void applyRenaming(ComponentBodyType xI) {

		for (InnerRenamingType ir : xI.getInnerRenaming()) {
			String cRef = ir.getCRef();
			String oldName = ir.getCOldName();
			String newName = ir.getCNewName();

			if (cRef != null) {
				if (mC1.containsKey(cRef)) {
					HComponent cc = mC2.get(mC1.get(cRef))
							.getExposedComponentByName(oldName);
					if (cc != null)
						cc.setName(newName);
				} else {
					System.err
							.println("applyRenaming: inner component not found ("
									+ cRef + ")");
				}
			} else {
				// mC2.get(mC1.get(oldName)).setName(newName);
			}
		}

	}

	private void applyFusions(ComponentBodyType xI)
			throws HPEInvalidComponentResourceException {

		List<HComponent> toFuse = new ArrayList<HComponent>();

		EList<FusionType> fs = xI.getFusion();
		for (FusionType f : fs) {
			toFuse.clear();
			EList<String> cs = f.getCRefs();
			String pRef = f.getPRef();
			for (String cRef : cs) {
				ComponentInUseType y = mC1.get(cRef);
				if (y != null)  { 
					HComponent c = mC2.get(y).getExposedComponentByName(pRef);
					if (c != null && !toFuse.contains(c))
						toFuse.add(c);
				}
			}

			HComponent aux = null;
			HComponent source = toFuse.get(0);
			for (HComponent target : toFuse) {
				if (source != target) {
					if (target.isSubTypeOf(source)
							&& !source.isSubTypeOf(target)) {
						aux = source;
						source = target;
						target = aux;
					}
					SupersedeCommand c = new SupersedeCommand(
							(HComponent) source, (HComponent) target);
					if (c.canExecute())
						c.execute();
					else {
						aux = source;
						source = target;
						target = aux;
						SupersedeCommand c_ = new SupersedeCommand(
								(HComponent) source, (HComponent) target);
						if (c_.canExecute())
							c_.execute();
						else {	
							String message = "CANNOT FUSE INNER COMPONENTS ! source = " + source.getRef() + " (" + source.getComponentName() + ") target = " + target.getRef() + " (" + target.getComponentName() + ")";
							System.err.println(message);
							JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
							// throw new HPEInvalidComponentResourceException();
						}
					}
				}
			}

		}

	}

	private ComponentFactory factory = ComponentFactory.eINSTANCE;

	// Saves a HComponent object in a ComponentType object
	public ComponentType marshallComponent(HComponent c) throws UndefinedRefInnerException, DuplicatedRefInnerException, DuplicatedSliceNamesException {

		ComponentType xC = factory.createComponentType();
		ComponentHeaderType xH = factory.createComponentHeaderType();
		ComponentBodyType xI = factory.createComponentBodyType();
		xC.setHeader(xH); 
		xC.setComponentInfo(xI);

		saveHeader(c, xC.getHeader());
		saveInfo(c, xC.getComponentInfo());

		return xC;
	}

	private void saveHeader(HComponent c, ComponentHeaderType xH) throws UndefinedRefInnerException {

		// save name
		xH.setName(c.getComponentName());
		// save kind
		xH.setKind(SupportedKinds.get(c.kindString()));
		// save base type
		HComponent sC = c.isAbstractConfiguration() ? c.getSuperType() : c
				.getWhoItImplements();
		if (sC != null)
			saveBaseType(sC, xH, c.isAbstractConfiguration());
		// save package path
		xH.setPackagePath(c.getPackagePath().toPortableString());
		// save HashComponentUID
		xH.setHashComponentUID(c.getHashComponentUID());
		// save Remote Location UID
		xH.setLocationURI(c.getRemoteLocation());

		xH.setIsAbstract(c.isAbstract());
		
		VisualElementAttributes v = factory.createVisualElementAttributes();
		saveVisualDescription(c,v);		
		xH.setVisualAttributes(v);

		saveVersions(c, xH.getVersions());

	}

	private void saveVersions(HComponent sc, EList<VersionType> list) {

		for (Integer[] version : sc.getVersions()) {
			VersionType v = factory.createVersionType();
			v.setField1(version[0]);
			v.setField2(version[1]);
			v.setField3(version[2]);
			v.setField4(version[3]);
			list.add(v);
		}

	}

	private void saveBaseType(HComponent baseType, ComponentHeaderType xH,
			boolean isAbstract) throws UndefinedRefInnerException {

		BaseTypeType baseTypeX = factory.createBaseTypeType();
		ExtensionTypeType extType = factory.createExtensionTypeType();
		ComponentInUseType superTypeX = factory.createComponentInUseType();

		if (isAbstract)
			extType.setExtends(true);
		else
			extType.setImplements(true);

		baseTypeX.setExtensionType(extType);
		baseTypeX.setComponent(superTypeX);

		String name = baseType.getComponentName();
		String location = baseType.getRemoteLocation() == null ? baseType.getRelativeLocation() : baseType.getRemoteLocation();
		String version = "1.0.0.0";
		String package_ = baseType.getPackagePath().toString();
		String hash_component_UID = baseType.getHashComponentUID();
		VisualElementAttributes v = factory.createVisualElementAttributes();
		saveVisualDescription(baseType, v);

		superTypeX.setName(name);
		superTypeX.setLocalRef(baseType.getRef());
		superTypeX.setLocation(location);
		superTypeX.setVersion(version);
		superTypeX.setPackage(package_);
		superTypeX.setVisualDescription(v);
		superTypeX.setHashComponentUID(hash_component_UID);

		xH.setBaseType(baseTypeX);

		EList<ParameterRenaming> parameterRenaming = superTypeX.getParameter();
		saveVisualDescription(baseType, v);

		EList<UnitBoundsType> unitBounds = superTypeX.getUnitBounds();

		saveParameterRenamings(baseType, parameterRenaming); // OK !
		savePorts(baseType, superTypeX.getPort());
		saveUnitBounds(baseType.getAllUnits(), unitBounds);
	}

	private void saveInfo(HComponent c, ComponentBodyType xI) throws UndefinedRefInnerException, DuplicatedRefInnerException, DuplicatedSliceNamesException {

		saveInnerComponents(c, xI.getInnerComponent()); // OK !
	    saveSupplyParameters(c, xI.getSupplyParameter()); // OK !
		saveParameters(c, xI.getParameter()); // OK !
		saveInnerRenamings(c, xI.getInnerRenaming()); 
		saveFusions(c, xI.getFusion());
		saveSplits(c, xI.getSplit());
		saveInterfaces(c, xI.getInterface());
		saveUnits(c, xI.getUnit());
		saveRecursiveEntries(c, xI.getRecursiveEntry());
		saveEnumerator(c.gettReplicators(), xI.getEnumerator());
		saveEnumeratorFusions(c.gettReplicators(), xI.getFusionsOfReplicators());
	}

	private void saveEnumeratorFusions(List<HReplicator> rs,
			EList<FusionsOfReplicatorsType> fRs) {

		List<HReplicator> touchedR = new ArrayList<HReplicator>();

		for (HReplicator r : rs) {
			HReplicator topR = r.getTopJoined();
			if (topR != r && !touchedR.contains(topR)) {
				touchedR.add(topR);
				List<List<HReplicator>> ss = topR.getFusionsInContext(this.component);

				for (List<HReplicator> rrs : ss) {
					FusionsOfReplicatorsType fOfr = factory
							.createFusionsOfReplicatorsType();
					EList<FusionOfReplicatorsType> ffs = fOfr
							.getFusionOfReplicators();
					FusionOfReplicatorsType ff = factory
							.createFusionOfReplicatorsType();
					ff.setERef(topR.getRef());
					List<HComponent> cOfrs = new ArrayList<HComponent>(topR
							.getConfigurations()); // ;
													// (HComponent)topR.getConfiguration();
					cOfrs.remove(0);
					List<String> cRefs = ff.getOriginRef();
					HComponent cOfr_ = null;
					for (HComponent cOfr : cOfrs) {
						String ref = cOfr_ != null
								&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr
								.getSavedName().get(cOfr_)
								: cOfr.getRef();
						cRefs.add(ref);
						cOfr_ = cOfr;
					}

					ffs.add(ff);
					for (HReplicator r_ : rrs) {
						ff = factory.createFusionOfReplicatorsType();
						ff.setERef(r_.getRef());
						cOfrs = new ArrayList<HComponent>(r_
								.getConfigurations()); // ;
														// (HComponent)topR.getConfiguration();
						cOfrs.remove(0);
						cRefs = ff.getOriginRef();
						cOfr_ = null;
						for (HComponent cOfr : cOfrs) {
							String ref = cOfr_ != null
									&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr
									.getSavedName().get(cOfr_)
									: cOfr.getRef();
							cRefs.add(ref);
							cOfr_ = cOfr;
						}

						ffs.add(ff);
					}
					fRs.add(fOfr);
					// }
				}
			}
		}

	}

	private void saveInnerRenamings(HComponent c, EList<InnerRenamingType> xRs) {

		Map<HComponent, List<HComponent>> vcs = new HashMap<HComponent, List<HComponent>>();

		for (HComponent vc : c.getComponents()) {
			// vcs.(c,vc);
			for (HComponent vc_ : vc.getExposedComponents())
				if (!vcs.containsKey(vc_)) {
					List<HComponent> l = new ArrayList<HComponent>();
					l.add(vc);
					vcs.put(vc_, l);
				} else {
					List<HComponent> l = vcs.get(vc_);
					l.add(vc);
				}
		}

		for (Entry<HComponent, List<HComponent>> vc : vcs.entrySet()) {
			List<HComponent> d1s = vc.getValue();
			HComponent d2 = vc.getKey();
			for (HComponent d1 : d1s) {
				String cRef = d1.getRef();
				String oldName = d2.getSavedName().get(d1);
				String newName = d2.getRef();
				if (oldName != null && !oldName.equals(newName)) {
					InnerRenamingType ir = factory.createInnerRenamingType();
					ir.setCRef(cRef);
					ir.setCOldName(oldName);
					ir.setCNewName(newName);
					xRs.add(ir);
				}
			}
		}
	}

	private void saveFusions(HComponent c, EList<FusionType> xFs) {

		Map<HComponent, List<HComponent>> vcs = new HashMap<HComponent, List<HComponent>>();

		for (HComponent _c : c.getComponents()) {
			for (HComponent __c : _c.getExposedComponents()) {
				if (vcs.containsKey(__c)) {
					List<HComponent> cs = vcs.get(__c);
					cs.add(0, _c);
				} else {
					List<HComponent> cs = new ArrayList<HComponent>();
					cs.add(_c);
					vcs.put(__c, cs);
				}
			}
		}

		List<HComponent> ccs1 = new ArrayList<HComponent>();
		List<HComponent> ccs2 = new ArrayList<HComponent>();
		
		for (Entry<HComponent, List<HComponent>> e : vcs.entrySet()) {
			if (e.getValue().size() <= 1) {
				ccs1.add(e.getKey());
			} else {
				ccs2.add(e.getKey());
			}
		}
		
		for (HComponent cc : ccs1) {
			vcs.remove(cc);
		}
		
		for (Entry<HComponent, List<HComponent>> e : vcs.entrySet()) {
			HComponent p = e.getKey();
			boolean flag = false;
			for (HComponent cc : ccs2) {
				if (cc != p && cc.getAllInnerConfigurations().contains(p)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				FusionType f = factory.createFusionType();
				xFs.add(f);
				f.setPRef(p.getRef());
				EList<String> ps = f.getCRefs();
				for (HComponent _c : e.getValue()) {
					ps.add(_c.getName2());
				}
			}
		}
	}

	private void saveParameters(HComponent c, EList<ParameterType> xI) {

		List<HComponent> cs = new ArrayList<HComponent>();

		cs.addAll(c.getComponents());
		for (Entry<String, HComponent> p : c.getSupplierComponents().entrySet())
			cs.add(p.getValue());

		for (HComponent ic : cs) {

			if (ic.isParameter() && ic.getSupplier() == null) {
				String formFieldId = null;
				String cRef = null;
				String varName = null;

				// SETUP VARIABLES

				formFieldId = ic.getParameterIdentifier(c);
				cRef = ic.getRef();
				varName = ic.getVariableName(c);

				// ---------------

				ParameterType p = factory.createParameterType();
				p.setFormFieldId(formFieldId);
				p.setComponentRef(cRef);
				p.setVarName(varName);

				xI.add(p);
			}
		}

	}

	private void saveInnerComponents(HComponent c, EList<InnerComponentType> xI) throws UndefinedRefInnerException, DuplicatedRefInnerException {

		List<HComponent> cs = new ArrayList<HComponent>();
        int i = 0;
        
        List<String> cRefs = new ArrayList<String>();
        List<String> cRefsSupply = new ArrayList<String>();
		
        for (HComponent cInner : c.getComponents()) {
		    cs.add(cInner);
		    String cRef = cInner.getRef();
			if (cRefs.contains(cRef)) {
				   throw new DuplicatedRefInnerException(cRef); 
			} else {
			   cRefs.add(cRef);
			}
        }
        
		for (Entry<String, HComponent> p : c.getSupplierComponents().entrySet()) {
			String cRef = p.getValue().getRef();
			if (cRefsSupply.contains(cRef)) {
				   throw new DuplicatedRefInnerException(cRef);  
			} else {
				if (!cRefs.contains(cRef)) {
 				   cs.add(i++, p.getValue());
				   cRefs.add(cRef);
				   cRefsSupply.add(cRef);
				}
			}
		}
		
		if (c.isAbstract()) {
			for (HReplicator r : c.gettReplicators()) {
				for (HReplicatorSplit lr : r.getSplits()) {
					HEnumeratorComponent ec = lr.getPermutation();
					if (ec != null && !cs.contains(ec)) {
						cs.add(0,ec);
						String cRef = ec.getRef();
						if (cRefs.contains(cRef)) {
							   throw new DuplicatedRefInnerException(cRef); 
						} else {
						   cRefs.add(cRef);
						}
					}
				}
			}
		}

		for (HComponent ic : cs) {

			if (!ic.isDerivedFromPermutation() && ic != c.getSuperType() && ic != c.getWhoItImplements()) {
                
				InnerComponentType d = factory.createInnerComponentType();
				
				saveInnerComponent(ic, d);

				xI.add(d);
			}

		}
	}

	/*
	 * private void savePorts(HComponent ic, EList<PortType> ports) {
	 * 
	 * for (HComponent c : ic.getExposedComponents()) { PortType port =
	 * factory.createPortType(); String pRef = c.getSavedName().get(ic);
	 * port.setPRef(pRef != null ? pRef : c.getRef());
	 * port.setExposed(c.getExposed()); ports.add(port); VisualElementAttributes
	 * v = factory.createVisualElementAttributes();
	 * port.setVisualDescription(v); saveVisualDescription(c,v); }
	 * 
	 * }
	 */

	private void saveInnerComponent(HComponent ic, InnerComponentType d) throws UndefinedRefInnerException {

		VisualElementAttributes v = factory.createVisualElementAttributes();
		String name = ic.getComponentName();
		String localRef = ic.getRef();

		String location = ic.getRemoteLocation() == null ? ic.getRelativeLocation() : ic.getRemoteLocation();
		String package_ = ic.getPackagePath().toString();
		boolean exposed = ic.isPublic();
		String hash_component_UID = ic.getHashComponentUID();

		String parameterId = ic.getParameterIdentifier(this.component);

		if (localRef.equals(HComponent.UNDEFINED_NAME)) {
			throw new UndefinedRefInnerException(ic);
		}
		
		d.setLocalRef(localRef);
		d.setLocation(location);
		d.setPackage(package_);
		d.setName(name);
		//d.setVersion(version);
		d.setExposed(exposed);
		d.setHashComponentUID(hash_component_UID);
		d.setVisualDescription(v);
		if (!parameterId.equals("type ?"))
			d.setParameterId(parameterId);

		EList<ParameterRenaming> parameterRenaming = d.getParameter();
		EList<UnitBoundsType> unitBounds = d.getUnitBounds();
		// EList<PortType> ports = d.getPort();
		EList<InnerComponentType> ports = d.getPort();

		saveParameterRenamings(ic, parameterRenaming); // OK !
		savePorts(ic, ports);
		saveUnitBounds(ic.getAllUnits(), unitBounds);
		saveVisualDescription(ic, v);

	}

	private void savePorts(HComponent ic, EList<InnerComponentType> ports) throws UndefinedRefInnerException {

		for (HComponent c : ic.getExposedComponents()) 
		{
			InnerComponentType port = factory.createInnerComponentType();

			saveInnerComponent(c, port);

			String pRef = c.getSavedName().get(ic);
			port.setLocalRef(pRef != null ? pRef : c.getRef());

			ports.add(port);
		}

	}

	private void saveUnitBounds(List<IHUnit> units, EList<UnitBoundsType> unitBounds) {

		Integer replica = null;

		for (IHUnit u : units) {

			if (u.isClone()) {
				replica = u.cloneOf().getIndexOfClone(u);
			} else if (u.isCloned()) {
				replica = 0;
			}

			UnitBoundsType b = factory.createUnitBoundsType();
			VisualElementAttributes v = factory.createVisualElementAttributes();

			b.setURef(u.getName2());
			if (replica != null)
				b.setReplica(replica);
			b.setVisualDescription(v);

			saveVisualDescription(u, v);

			unitBounds.add(b);
		}

	}

	private void saveRecursiveEntries(HComponent component, EList<RecursiveEntryType> xI) {

		for (HComponent c : component.getComponents()) {
			if (c.isRecursive()) {
				RecursiveEntryType r = factory.createRecursiveEntryType();
				r.setCRef(c.getName2());
				xI.add(r);
			}
		}
	}

	private void saveSplits(HComponent c, EList<SplitType> splitsX) {

		for (HReplicator r : c.gettReplicators()) {
			for (HReplicatorSplit split : r.getSplits()) {
				if (split.getContext() == c.getTopConfiguration()) {
					SplitType splitX = factory.createSplitType();

					String eRef = r.getRef();
					int n = split.getN();
					String cRefPermutation = split.getPermutation() != null ? split.getPermutation().getRef() : null;

					splitX.setERef(eRef);
					splitX.setN(n);
					if (cRefPermutation != null)
						splitX.setCRefPermutation(cRefPermutation);

					List<String> oRef = splitX.getOriginRef();
					List<HComponent> cOfrs = new ArrayList<HComponent>(r
							.getConfigurations()); // ;
													// (HComponent)topR.getConfiguration();
					cOfrs.remove(0);
					HComponent cOfr_ = null;
					for (HComponent cOfr : cOfrs) {
						String ref = cOfr_ != null
								&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr
								.getSavedName().get(cOfr_)
								: cOfr.getRef();

						oRef.add(ref);
						cOfr_ = cOfr;
					}

					if (n != splitX.getSplitEnumerator().size()) { /* ERROR */
					}

					saveSplitLinks(split.getSplitLinks(), splitX.getSplitLink());
					saveSplitEnumerators(split.getTheReplicators(), splitX.getSplitEnumerator());

					splitsX.add(splitX);
				}
			}

		}
	}

	private void saveSplitLinks(List<HLinkToReplicator> links, EList<SplitLinkType> splitsX) {

		for (HLinkToReplicator l : links) {

			IPointsToReplicator p = l.getReplicated();
			if (p instanceof HUnit) { /* ERROR */
			}
			HUnit u = (HUnit) p;
			HComponent cu = (HComponent) u.getConfiguration();
			if (cu.isTopConfiguration()
					|| !((HComponent) cu.getTopConfiguration()).getComponents()
							.contains(cu)) { /* ERROR */
			}

			SplitLinkType splitLink = factory.createSplitLinkType();
			splitLink.setCRef(cu.getRef());
			splitLink.setURef(u.getName2());
			splitsX.add(splitLink);

		}

	}

	private void saveSplitEnumerators(Collection<HReplicator> rs, EList<String> enumsX) {
		for (HReplicator r : rs) {
			enumsX.add(r.getRef());
		}
	}

	private void saveParameterRenamings(HComponent c, EList<ParameterRenaming> parameterRenamings) {

		for (Entry<String, List<HComponent>> param : c.getParameters().entrySet()) {

			String formField = null;
			String varName = null;

			// SETUP VARIABLES: look for the current variable name of the
			// parameter in the configuration

			HComponent cc = param.getValue().get(0);

			varName = cc.getVariableName(component);
//			if (varName.equals("?"))
//			     varName = cc.getVariableName(c.getTopParentConfigurations().get(0));
			
			
			if (varName.indexOf('@') >= 0)
				varName = varName.substring(0, varName.indexOf('@'));
			formField = cc.getParameterIdentifier(c);

			// ---------------

			ParameterRenaming r = factory.createParameterRenaming();

			r.setFormFieldId(formField);
			r.setVarName(varName);

			parameterRenamings.add(r);
		}

	}

	private void saveInterfaces(HComponent c, EList<InterfaceType> xI) {

		for (HInterface i : c.getInterfaces())
			if (i.getConfiguration() == c) { // Only interfaces of the top configuration

				ActionType a = null;
				String iRef = null;
				VisualElementAttributes v = factory
						.createVisualElementAttributes();

				int nargs = i.getParametersCount();

				InterfaceType iX = factory.createInterfaceType();

				// SETUP VARIABLES

				iRef = i.getPrimName();
				if (i instanceof HActivateInterface) {
					HActivateInterface ia = (HActivateInterface) i;
					if (ia.getProtocol() != null) {
						a = saveAction((HAction) ia.getProtocol().getAction());
						iX.setProtocol(a);
					}
				}
				// ---------------

				iX.setIRef(iRef);
				iX.setVisualDescription(v);
				iX.setNArgs(nargs);

				EList<InterfaceSliceType> slicesX = iX.getSlice();
				EList<SourceType> sourcesX = iX.getSources();
				EList<InterfacePortType> portsX = iX.getPort();
				EList<InterfaceParameterType> parametersX = iX.getParameter();

				saveInterfaceSlices(i.getSlices(), slicesX);
				saveInterfacePorts(i.getPorts(), portsX);
				saveSources(i.getSourceVersions(), sourcesX);
				saveParameters(i.getParameters(), parametersX);
				
				saveVisualDescription(i, v);
				
				List<String> externalRefs = iX.getExternalReferences();
				for (String eRef : i.getExternalReferences()) {
					externalRefs.add(eRef);
				}

				xI.add(iX);
			}

	}

	private void saveParameters(
			List<Triple<String, HInterface, String>> parameters,
			EList<InterfaceParameterType> parametersX) {
		
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		int order = 0;
		for (Triple<String,HInterface,String> parameter : parameters) {
		    InterfaceParameterType parX = factory.createInterfaceParameterType();
		    parX.setParid(parameter.trd());		   
		    if (!m.containsKey(parX.getParid())) {
			   parX.setVarid(parameter.fst());
			   parX.setIname(parameter.snd().getPrimName());
			   parX.setUname(parameter.snd().getCompliantUnits().get(0).getName2());
	    	   parX.setOrder(order++);
		       parametersX.add(parX);
		       m.put(parX.getParid(),parX.getOrder());
		    }
		}
		
		
	}

	private void saveInterfacePorts(List<HPort> ports,
			EList<InterfacePortType> portsX) {

		for (HPort p : ports) {
			InterfacePortType portX = factory.createInterfacePortType();
			VisualElementAttributes v = factory.createVisualElementAttributes();
			List<PortSliceType> portSliceL = portX.getSlice();

			for (HInterfaceSlice sOwner : p.getOwners()) {

				String sRef = sOwner.getName();
				String pRef = p.getDefaultNameOf(sOwner);

				PortSliceType pst = factory.createPortSliceType();
				pst.setPRef(pRef);
				pst.setSRef(sRef);
				portSliceL.add(pst);
			}

			/*
			 * List<PortSliceType> portSliceL = portX.getSlice();
			 * Iterator<HInterfaceSlice> ss1 = p.getOwners().iterator();
			 * Iterator<HInterfaceSlice> ss2 =
			 * p.getInterfaceSlices().iterator(); while (ss1.hasNext() &&
			 * ss2.hasNext()) { HInterfaceSlice s1 = ss1.next(); HInterfaceSlice
			 * s2 = ss2.next(); String sRef = s1.getName(); String pRef =
			 * s2.getName(); PortSliceType pst = factory.createPortSliceType();
			 * pst.setPRef(pRef); pst.setSRef(sRef); portSliceL.add(pst); }
			 */
			portX.setName(p.getName());
			portX.setVisualDescription(v);
			saveVisualDescription(p, v);
			portsX.add(portX);
		}

	}

	private ActionType saveAction(HAction action) {

		ActionType actionX = null;

		if (action instanceof HCombinatorAction) {

			if (action instanceof HParAction) {
				actionX = factory.createActionCombinatorParType();

			} else if (action instanceof HSeqAction) {
				actionX = factory.createActionCombinatorSeqType();

			} else if (action instanceof HAltAction) {
				actionX = factory.createActionCombinatorAltType();
			}

			EList<ActionType> innerActionsX = ((ActionCombinatorType) actionX).getAction();

			HCombinatorAction combinatorAction = (HCombinatorAction) action;

			for (HAction a : combinatorAction.getActions()) {
				innerActionsX.add(saveAction(a));
			}

		} else if (action instanceof HPrimitiveAction) {
			if (action instanceof HDoAction) {
				actionX = factory.createActionActivateType();
				ActionActivateType actionXX = (ActionActivateType) actionX;
				IInterfaceSlice s = ((HDoAction) action).getSliceAbstraction();
				if (s != null)
				   actionXX.setSliceRef(s.getName()); 
			} else if (action instanceof HWaitAction) {
				actionX = factory.createActionWaitType();
				ActionWaitType actionXX = (ActionWaitType) actionX;
				actionXX.setSemaphore(((HWaitAction) action).getSemaphore()
						.getName());
			} else if (action instanceof HSignalAction) {
				actionX = factory.createActionSignalType();
				ActionSignalType actionXX = (ActionSignalType) actionX;
				actionXX.setSemaphore(((HSignalAction) action).getSemaphore()
						.getName());
			} else if (action instanceof HSkipAction) {
				actionX = factory.createActionSkipType();
				ActionSkipType actionXX = (ActionSkipType) actionX;
			}
		}

		VisualElementAttributes vX = factory.createVisualElementAttributes();
		saveVisualDescription(action, vX);
		actionX.setLabel(action.getLabel());
		actionX.setRepeat(action.getRepeatDepth());
		actionX.setVisualDescription(vX);

		return actionX;
	}

	private void saveVisualDescription(Object v, VisualElementAttributes vX) {

		if (v instanceof IHasColor) {
			IHasColor color = (IHasColor) v;
			ColorComplexType colorX = factory.createColorComplexType();
			colorX.setR((short) color.getColor().getRed());
			colorX.setG((short) color.getColor().getGreen());
			colorX.setB((short) color.getColor().getBlue());
			vX.setColor(colorX);
		}

		if (v instanceof IHVisualElement) {
			IHVisualElement ve = (IHVisualElement) v;
			if (ve.getBounds() != null) {
				vX.setX(ve.getBounds().x);
				vX.setY(ve.getBounds().y);
				vX.setH(ve.getBounds().height);
				vX.setW(ve.getBounds().width);
			}
		}

	}

	private void saveSources(
			Collection<HBESourceVersion<HBEAbstractFile>> sources,
			EList<SourceType> sourcesX) {

		for (HBESourceVersion<HBEAbstractFile> src : sources) {
			SourceType s = factory.createSourceType();

			List<SourceFileType> fsX = s.getFile();

			for (HBEAbstractFile f : src.getFiles()) {
				SourceFileType fX = factory.createSourceFileType();
				String uri = f.getBinaryPath().toString();
				String fileType = f.getFileType();
				String versionIdF = f.getVersionID();
				String srcType = f.getSrcType();
				fX.setUri(uri);
				fX.setFileType(fileType);
				fX.setName(f.getFileName());
				fX.setContents(f.getCurrentContents());
				fX.setVersionId(checkVersion(versionIdF) ? versionIdF : "1.0.0.0");
				fX.setSrcType(srcType == null ? "base" : srcType);
				List<String> deps = fX.getDependency();
				deps.addAll(f.getDependencies());
				List<String> edeps = fX.getExternalDependency();
				edeps.addAll(f.getExternalReferences());
				fsX.add(fX);
			}

			String version = src.getVersionID();
			String srcType = src.getFileType();

			s.setSourceType(srcType);
			s.setVersionId(checkVersion(version) ? version : "1.0.0.0");

			sourcesX.add(s);
		}
	}

	private boolean checkVersion(String version) {
		try {
			String[] v = version.split("[.]");
			boolean ok = true;
			for (String i : v) {
				Integer.parseInt(i);
			}
			return v.length == 4;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	private void saveInterfaceSlices(List<HInterfaceSlice> slices,
			EList<InterfaceSliceType> slicesX) {
		
		Map<String, HInterfaceSlice> savedSlices = new HashMap<String, HInterfaceSlice>();
		
		for (HInterfaceSlice slice : slices) 
			if (!savedSlices.containsKey(slice.getName()))
		    /* if (!(slice instanceof HEnumeratorInterfaceSlice)) */ {
			savedSlices.put(slice.getName(), slice);

			InterfaceSliceType sliceX = factory.createInterfaceSliceType();
			VisualElementAttributes v = factory.createVisualElementAttributes();

			String sRef = null;
			String cORef = null;
			String iORef = null;

			// SETUP VARIABLES

			sRef = slice.getName();
			cORef = slice.getInterface().getConfiguration().getRef();
			iORef = ((HInterface) slice.getInterface()).getPrimName();

			// ---------------

			sliceX.setIsRef(sRef);

			InterfaceRefType oRef = factory.createInterfaceRefType();
			oRef.setCRef(cORef);
			oRef.setIRef(iORef);

			sliceX.setOriginRef(oRef);

			sliceX.setVisualDescription(v);

			saveVisualDescription(slice, v);

			slicesX.add(sliceX);
		}
	}

	private void saveUnits(HComponent c, EList<UnitType> xI) throws DuplicatedSliceNamesException {

		for (IHUnit u_ : c.getUnits()) {

			UnitType uX = factory.createUnitType();

			String uRef = null;
			String iRef = null;
			boolean isPrivate = false;
			boolean isSubUnit = false;
			boolean visibleInterface = true;
			String cRefSuper = null;
			String uRefSuper = null;
			Integer replica = null;

			VisualElementAttributes v = factory.createVisualElementAttributes();

			HUnit u = (HUnit) u_;

			isSubUnit = u.hasStubs();
			isPrivate = u.getHidden();
			visibleInterface = u.visibleInterface();
			uRef = u.getName2();
			HInterface i = (HInterface) u.getInterface();

			iRef = i != null ? i.getPrimName() : null;
			if (isSubUnit) {
				HUnitStub stubU = u.getMostRecentStub();
				cRefSuper = ((HComponent) stubU.getConfiguration()).getRef();
				uRefSuper = stubU.getOriginalName();
				if (u.isClone()) {
					replica = u.cloneOf().getIndexOfClone(u);
				} else if (u.isCloned()) {
					replica = 0;
				}
			}

			// ---------------

			uX.setURef(uRef);
			uX.setIRef(iRef);
			uX.setPrivate(isPrivate);
			uX.setVisibleInterface(visibleInterface);
			uX.setVisualDescription(v);

			if (isSubUnit) {
				UnitRefType superUnit = factory.createUnitRefType();
				superUnit.setCRef(cRefSuper);
				superUnit.setURef(uRefSuper);
				if (replica != null)
					superUnit.setReplica(replica);
				uX.setSuper(superUnit);
			}
			saveVisualDescription(u, v);

			EList<UnitSliceType> slicesX = uX.getSlices();
			List<HUnitSlice> transitiveSlices = new ArrayList<HUnitSlice>();
			List<HUnitSlice> directSlices = new ArrayList<HUnitSlice>();
			List<HUnitSlice> ports = u.getPorts();
			List<HUnitSlice> slices = u.getSlices();
			transitiveSlices.addAll(ports);
			for (HUnitSlice usx : slices) {
				if (!transitiveSlices.contains(usx))
					transitiveSlices.add(usx);
			}
			directSlices.addAll(slices);
			saveUnitSlices(directSlices, transitiveSlices, slicesX);

			xI.add(uX);

		}

	}

	private void saveUnitSlices(List<HUnitSlice> directSlices,
			List<HUnitSlice> transitiveSlices, EList<UnitSliceType> slicesX) throws DuplicatedSliceNamesException {

		Map<String, HUnitSlice> savedSlices = new HashMap<String, HUnitSlice>();
		
		for (HUnitSlice slice : transitiveSlices) {
			
			if (savedSlices.containsKey(slice.getName())) {
			//    throw new DuplicatedSliceNamesException(slice);
			}

			//if (!savedSlices.containsKey(slice.getName())) {
				savedSlices.put(slice.getName(), slice);

				// if (!slice.getHiddenSlice()) {
				/*
				 * Essa linha foi acrescentada devido a problema com fatias de
				 * unidades herdadas de subtyping ...
				 */

				IHUnit e = slice.getBinding().getEntry();

				UnitSliceType sliceX = factory.createUnitSliceType();
				VisualElementAttributes v = factory
						.createVisualElementAttributes();
				List<String> portsX = sliceX.getPort();

				String cRef = null;
				String uRef = null;
				int replica = 0;
				String sName = null;

				HUnit uSource = (HUnit) slice.getComponentEntry();

				cRef = uSource.getConfiguration().getRef();
				uRef = uSource.getName2();

				sName = slice.getName();

				if (uSource.isClone()) {
					replica = uSource.cloneOf().getIndexOfClone(uSource);
				} else if (uSource.isCloned()) {
					replica = 0;
				}
				sliceX.setReplica(replica);

				// ---------------

				sliceX.setCRef(cRef);
				sliceX.setURef(uRef);
				sliceX.setSliceName(sName);
				sliceX.setVisualDescription(v);
				sliceX.setTransitive(!directSlices.contains(slice));

				List<HUnitSlice> usPorts = uSource.getPorts();
				for (HUnitSlice usPort : usPorts) {
					HUnit usPortSource = (HUnit) usPort.getComponentEntry();
					String usPortName = usPort.getInterfaceSlice() != null ? usPort
							.getInterfaceSlice().getName()
							: usPortSource.getName2();
					portsX.add(usPortName);
				}

				saveVisualDescription(slice, v);

				slicesX.add(sliceX);
			}
		}
	

	private void saveSupplyParameters(HComponent c, EList<ParameterSupplyType> xI) {

		for (Entry<String, HComponent> pair : c.getSupplierComponents().entrySet()) {

			ParameterSupplyType s = factory.createParameterSupplyType();
			String cRef = null;
			String varName = null;

			// SETUP VARIABLES

			HComponent supplier = pair.getValue();

			varName = pair.getKey();
			cRef = supplier.getRef();

			// ---------------

			s.setCRef(cRef);
			s.setVarName(varName);

			xI.add(s);
		}

	}

	private void saveEnumerator(Collection<HReplicator> replicators, EList<EnumeratorType> xI) {

		HComponent topC = null;

		for (HReplicator e : replicators) /* if (e.getFactor() != 1) */ {

			List<HComponent> cs = new ArrayList<HComponent>(e.getConfigurations());
			cs.remove(0);

			EnumeratorType eX = factory.createEnumeratorType();
			VisualElementAttributes v = factory.createVisualElementAttributes();
			String eRef = null;
			List<String> coRefs = new ArrayList<String>();
			HComponent c_ = null;
			for (HComponent c : cs) {
				// USE THE ORIGINAL NAME OF THE INNER COMPONENT !!
				String ref = c_ != null && c.getSavedName().containsKey(c_) ? c
						.getSavedName().get(c_) : c.getRef();
				coRefs.add(ref);
				c_ = c;
			}
			// String eoRef = null;
			String varId = null;
			int cardinality = 0;
			boolean fromSplit;
			EnumeratorFromRecursionType fromRecursion = e.getReplicatorOrigin() == ReplicatorOrigin.RECURSION_CREATION ? factory
					.createEnumeratorFromRecursionType()
					: null;

			// SETUP VARIABLES

			eRef = e.getRef().trim();
			varId = e.getVarId();
			cardinality = e.getFactor();
			fromSplit = e.isSplitReplicator();
			if (fromRecursion != null)
				fromRecursion.setCRef(e.getRec().getRef());
			String cRefPermutation = null;

			// ---------------

			eX.setRef(eRef);
			eX.setVarId(varId);
			eX.setCardinality(cardinality);
			eX.setFromSplit(fromSplit);
			eX.setVisualDescription(v);
			eX.setFromRecursion(fromRecursion);

			List<String> oRefs = eX.getOriginRef();
			for (String coRef : coRefs) {
				oRefs.add(coRef);
			}

			// EList splitsX = eX.getSplits();
			EList<EnumerableType> linksX = eX.getLinks();

			// saveEnumeratorSplits(e.getSplits(),splitsX); //
			saveEnumeratorLinks(e.getDirectLinksToMe(), linksX);

			saveVisualDescription(e, v);

			xI.add(eX);
		}

	}

	private void saveEnumeratorLinks(Collection<HLinkToReplicator> linksToMe,
			EList<EnumerableType> linksX) {

		List<HVisualElement> replicatedOne = new ArrayList<HVisualElement>();

		List<String> componentsReplicated = new ArrayList<String>();
		
		for (HLinkToReplicator l : linksToMe) {
			IPointsToReplicator p = l.getReplicated();
			if (!replicatedOne.contains(p)) {
				if (p instanceof HUnit) {
					HUnit u = (HUnit) p;
					// Only units of the top configuration. It is possible to
					// infer replication
					// of entries of inner components from the unit slices,
					// below ....
					if (u.getConfiguration() == this.component) {
						EnumerableUnitType uX = factory.createEnumerableUnitType();
						uX.setRef(u.getName2());
						linksX.add(uX);
						replicatedOne.add(u);
					} else if (u.isEntry() && u.getMyClones().isEmpty()) {
						HComponent innerOf_u = (HComponent) u.getConfiguration();
				//		if (innerOf_u.isDirectSonOfTheTopConfiguration()) {
							EnumerableEntryType usX = factory.createEnumerableEntryType();
							HEnumeratorComponent ec = null; // l.getPermutation();
							usX.setCRef(u.getConfiguration().getRef());
							usX.setURef(u.getName2());
							if (u.cloneOf() != null) {
							  usX.setIndex(u.cloneOf().getIndexOfClone(u));
							}
							linksX.add(usX);
							replicatedOne.add(u);
				//		} else {
				//			System.out.print("UNEXPECTED GHOST INNER COMPONENT " + innerOf_u.getRef());
				//		}
					}

				} else if (p instanceof HComponent) {
					HComponent c = (HComponent) p;
					// Only direct inner components of the top configuration
					if (c.getConfiguration() == this.component && !componentsReplicated.contains(c.getRef())) {
						EnumerableComponentType cX = factory.createEnumerableComponentType();
						cX.setRef(c.getRef());
						linksX.add(cX);
						replicatedOne.add(c);
						componentsReplicated.add(c.getRef());
					}

				} 
				 else if (p instanceof HUnitSlice) { 
					 HUnitSlice s = (HUnitSlice) p; // only slices of units of the top configuration ... in fact, it is only necessary for recovering replication of units of inner components. 
					  if (s.getUnit().getConfiguration() == this.component) {
						  EnumerableUnitSliceType sX = factory.createEnumerableUnitSliceType();
						  sX.setURef(s.getUnit().getName2());
						  sX.setCRef(s.getBinding().getEntry().getConfiguration().getRef());
						  sX.setSRef(s.getBinding().getEntry().getName2());
						  if (s.getInterfaceSlice() != null) {
						     sX.setRef(s.getInterfaceSlice().getName());
						  } else {
							 sX.setRef(sX.getSRef());
						  }
						  IHUnit u = s.getBinding().getEntry();
						  sX.setSplitReplica(u.isClone() ? u.cloneOf().getIndexOfClone(u) : 0);
					      linksX.add(sX); 
					   } 
				}
				 
			}
		}

	}

	/*
	 * private void saveEnumeratorSplits(List<HReplicatorSplit> splits, EList
	 * splitsX) {
	 * 
	 * for (HReplicatorSplit s : splits) { SplitType sX =
	 * factory.createSplitType(); EList rsX = sX.getERefOfSplit(); for
	 * (HReplicator r : s.getTheReplicators()) { rsX.add(r.getRef()); }
	 * splitsX.add(sX); }
	 * 
	 * }
	 */
	private IPointsToReplicator lookForEnumeratedItem(EnumerableType item) { // throws
																				// HPEInvalidComponentResourceException
																				// {

		IPointsToReplicator eItem = null;

		String ref = item.getRef();
		if (item instanceof EnumerableComponentType) {
			if (mC1.containsKey(ref)) {
				eItem = mC2.get(mC1.get(ref));
			} // else
			// throw new HPEInvalidComponentResourceException();

		} else if (item instanceof EnumerableUnitType) {
			// OBS.: Units of inner components are already replicated due to
			// loadComponent.
			if (mU1.containsKey(ref)) {
				eItem = mU2.get(mU1.get(ref));
			} // else
			// throw new HPEInvalidComponentResourceException();
		} else if (item instanceof EnumerableEntryType) {
			EnumerableEntryType sItem = (EnumerableEntryType) item;
			String uRef = sItem.getURef();
			String cRef = sItem.getCRef();	
			int index = sItem.getIndex();
			HComponent c1 = mC2.get(mC1.get(cRef));
			eItem = c1.getUnitByName(uRef, index);			
		} else if (item instanceof EnumerableUnitSliceType) { // NOTE: returns
																// the entry and
																// not the unit
																// slice ...
			EnumerableUnitSliceType sItem = (EnumerableUnitSliceType) item;
			String uRef = sItem.getURef();
			String cRef = sItem.getCRef();
			String sRef = sItem.getSRef();
			if (mU1.containsKey(uRef)) {
				HUnit u = mU2.get(mU1.get(uRef));
				eItem = u.lookForUnitSlice(cRef, sRef);
			} // else
			// throw new HPEInvalidComponentResourceException();

		}

		return eItem;

	}

	private HUnit lookForSuperUnit(UnitRefType xUsuper)
			throws HPEInvalidComponentResourceException {
		HUnit u = null;
		String cNameSuper = xUsuper.getCRef();
		String uNameSuper = xUsuper.getURef();
		HComponent cSuper = component.getSuperType(); // mC2.get(mC1.get(cNameSuper));
		if (cSuper == null) {
			String message = "IHUnit " + uNameSuper + " not found in " + cNameSuper;
			System.err.println(message);
			JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
			// throw new HPEInvalidComponentResourceException();
		} else {
			IHUnit u_ = cSuper.fetchUnit(uNameSuper);
			u = (HUnit) u_.getTopUnit(null);
		}
		return u;
	}

	private HUnit lookForImplementingUnit(UnitRefType xUsuper)
			throws HPEInvalidComponentResourceException {
		HUnit u = null;
		String cNameSuper = xUsuper.getCRef();
		String uNameSuper = xUsuper.getURef();
		HComponent cSuper = component.getWhoItImplements(); // mC2.get(mC1.get(cNameSuper));
		if (cSuper == null) {
			String message = "IHUnit " + uNameSuper + " not found in " + cNameSuper;
			System.err.println(message);
			JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
			// throw new HPEInvalidComponentResourceException();
		} else {
			IHUnit u_ = cSuper.fetchUnit(uNameSuper);
			u = (HUnit) u_.getTopUnit(null);
		}
		return u;
	}

	private void loadSlices(UnitType xU, HUnit u)
			throws HPEInvalidComponentResourceException {

		Map<String, String> check = new HashMap<String, String>();

		for (HUnitSlice us : u.getSlices()) 
			if (!(us instanceof HEnumeratorUnitSlice)) {
			HComponent cSlice = (HComponent) us.getConfiguration();
			HUnit uSlice = (HUnit) us.getComponentEntry();
			String key = uSlice.getName2() + cSlice.getRef();
			check.put(key, key);
		}

		for (UnitSliceType uSliceX : xU.getSlices()) 
		 {
			if ((!uSliceX.isTransitive())) {

				String cRef = uSliceX.getCRef();
				String uRef = uSliceX.getURef();
				String sName = uSliceX.getSliceName();

				if (!check.containsKey(uRef + cRef)) {

					// check.add(cRef + uRef);

					int x, y, w, h;
					if (uSliceX.getVisualDescription() != null) {
						x = (int) uSliceX.getVisualDescription().getX();
						y = (int) uSliceX.getVisualDescription().getY();
						w = (int) uSliceX.getVisualDescription().getW();
						h = (int) uSliceX.getVisualDescription().getH();
					} else {
						x = y = 0;
						w = h = HUnitSlice.diameter;
					}
					

					if (mC1.containsKey(cRef)) {
						HComponent c1 = mC2.get(mC1.get(cRef));
						if (!(c1 instanceof HEnumeratorComponent)) {
							IHUnit u1 = null;
							if (uSliceX.isSetReplica() && uSliceX.getReplica() > 0) {
								Integer replica = uSliceX.getReplica();
								int iReplica = replica.intValue();
								u1 = c1.fetchUnit(uRef, iReplica);
							} else {
								u1 = c1.fetchUnit(uRef);
							}
	
							if (u1 == null) {
								System.err.println("HComponentFactoryImpl.loadSlices(): IHUnit " + uRef + " not found in " + cRef);
								JOptionPane.showMessageDialog(null,
										"HComponentFactoryImpl.loadSlices(): IHUnit " + uRef + " not found in " + cRef, 
					        		    "Loading Component Error",
					        		    JOptionPane.ERROR_MESSAGE);
							} else {
								try {
									HUnitSlice uSlice = (HUnitSlice) component.createBinding(u1, u, new Point(x, y));
									uSlice.setBounds(new Rectangle(x, y, w, h));
									if (sName != null)
										uSlice.setName(sName);
								} catch (HPEAbortException e) {
									System.err.println("HComponentFactoryImpl.loadSlices(): Error creating binding (source = " + u1.getName2() + " target = " + u.getName2());
									JOptionPane.showMessageDialog(null,
											"HComponentFactoryImpl.loadSlices(): Error creating binding (source = " + u1.getName2() + " target = " + u.getName2(), 
						        		    "Loading Component Error",
						        		    JOptionPane.ERROR_MESSAGE);									
								}
							}
						}
					} else {
						System.err
								.println("HComponentFactoryImpl.loadSlices(): Local Ref "
										+ cRef
										+ " not found."
										+ ((this.component
												.isAbstractConfiguration()) ? " Probably a reference to an inner component of the super type. "
												: " Probably a reference to hidden inner component in a concrete configuration."));
						// significa que a fatia � de um componente do super
						// tipo
					}
				}
			}
		}
	}

	private void loadInterface(UnitType xU, HUnit u, boolean isTop, boolean isImplementing)
			throws HPEInvalidComponentResourceException, HPEAbortException {

		String iName = xU.getIRef();
		InterfaceType xI = mI1.get(iName);
		HInterface i = null;
		UnitRefType xUsuper = xU.getSuper();

		if (xI != null) {
			if (xUsuper == null) { // The interface is not inherited from the
									// super unit

				if (!mI2.containsKey(xI)) {
					i = buildInterface(u, xI, isTop, isImplementing);
				} else {
					i = mI2.get(xI);
					u.attachToInterface(i);
				}

			} else {
				if (xI != null) {
					int x = (int) xI.getVisualDescription().getX();
					int y = (int) xI.getVisualDescription().getY();
					int w = (int) xI.getVisualDescription().getW();
					int h = (int) xI.getVisualDescription().getH();
					int r = xI.getVisualDescription().getColor().getR();
					int g = xI.getVisualDescription().getColor().getG();
					int b = xI.getVisualDescription().getColor().getB();

					i = (HInterface) u.getInterface();

					updateSlices(i, xI, isTop, isImplementing);
					
					loadSourceVersions(i, xI);

					mI2.put(xI, i);

					i.setBounds(new Rectangle(x, y, w, h));
					i.setColor(new Color(null, r, g, b));
					i.setName(xI.getIRef());

					ports.put(i, xI.getPort());
					
					i.addExternalReferences(xI.getExternalReferences());
				}
			}

			// Protocol ...

			if (i instanceof HActivateInterface) {
				HActivateInterface ia = (HActivateInterface) i;
				if (xI.getProtocol() != null) {
					HProtocol p = new HProtocol(ia);
					HCombinatorAction aaux = new HParAction("dummy", p);
					HAction action = buildAction(xI.getProtocol(), aaux, i,
							new HashMap<String, HSemaphore>(), p);
					action.setProtocol(p);
					Rectangle r = p.getBounds();
					r.height = action.getBounds().height + 2
							* action.getBounds().y;
					r.width = action.getBounds().width + 2
							* action.getBounds().x;
					p.setBounds(r);

				}
			}
		} // else {
		// loadSourceVersions(i,xI);
		// }

	}

	private HUnit buildUnit(UnitType xU, HComponent c)
			throws HPEInvalidComponentResourceException, HPEAbortException {

		String uName = xU.getURef();
		int x = (int) xU.getVisualDescription().getX();
		int y = (int) xU.getVisualDescription().getY();
		int w = (int) xU.getVisualDescription().getW();
		int h = (int) xU.getVisualDescription().getH();

		UnitRefType xUsuper = xU.getSuper();

		HUnit u = (HUnit) c.getUnitByName(uName);
        if (u==null) {
			if (component.getSuperType() != null) {
				u = xUsuper != null ? lookForSuperUnit(xUsuper) : c.createUnit();
			} else if (!component.isAbstractConfiguration()) {
				u = xUsuper != null ? lookForImplementingUnit(xUsuper) : c.createUnit();
			} else {
	 		    u = c.createUnit();
			}
        }

		mU1.put(uName, xU);
		mU2.put(xU, u);
		u.setName(uName);
		u.setBounds(new Rectangle(x, y, w, h));
		u.setHidden(xU.isPrivate());
		if (xU.getIRef() != null)
			u.setInterfaceName(xU.getIRef());
		
		if (this.component.isAbstractConfiguration())
			loadSlices(xU, u);
		// loadInterface(xU,u);

		if (xU.isVisibleInterface())
			u.showInterface();
		else
			u.hideInterface();

		return u;
	}

	private HInterface buildInterface(HUnit u, InterfaceType xI, boolean isTop, boolean isImplementing)
			throws HPEAbortException, HPEInvalidComponentResourceException {

		int x = (int) xI.getVisualDescription().getX();
		int y = (int) xI.getVisualDescription().getY();
		int w = (int) xI.getVisualDescription().getW();
		int h = (int) xI.getVisualDescription().getH();
		int r = xI.getVisualDescription().getColor().getR();
		int g = xI.getVisualDescription().getColor().getG();
		int b = xI.getVisualDescription().getColor().getB();

		HInterface i = (HInterface) u.getInterface();
		if (i == null) {
		   i = u.createInterface(new Point(x, y));
		}
		mI2.put(xI, i);

		i.setBounds(new Rectangle(x, y, w, h));
		i.setColor(new Color(null, r, g, b));
		i.setName(xI.getIRef());

		
		updateSlices(i, xI, isTop, isImplementing);
		
		ports.put(i, xI.getPort());

		// load source versions ...
		loadSourceVersions(i, xI);
		
		// external references
		i.addExternalReferences(xI.getExternalReferences());

		return i;
	}

	private Map<HInterface, List<InterfacePortType>> ports = new HashMap<HInterface, List<InterfacePortType>>();

	private void updateSlices(HInterface i, InterfaceType xI, boolean isTop, boolean isImplementing)
			throws HPEInvalidComponentResourceException {

		for (InterfaceSliceType sX : xI.getSlice()) {
			String sRef = sX.getIsRef();
			VisualElementAttributes ve = sX.getVisualDescription();
			InterfaceRefType rtX = sX.getOriginRef();
			String cRef = rtX.getCRef();
			String iRef = rtX.getIRef();
			HInterfaceSlice s = i.fetchSlice(cRef, iRef);
			if (s!=null) {
				if (!(s instanceof HEnumeratorInterfaceSlice) ) {
					if (!isImplementing && !isTop) {
						List<HPort> ps = s.getPorts();
						for (HPort p_ : ps) {
							for (HInterfaceSlice s_ : p_.getInterfaceSlices()) {
								s_.resetDefaultName();
								s_.resetOriginalName();
							}
						}
					}
					//if (s == null)
					//	throw new HPEInvalidComponentResourceException();
					Rectangle bounds = new Rectangle((int) ve.getX(), (int) ve.getY(),
							(int) ve.getW(), (int) ve.getH());
					s.setName(sRef);
					s.setBounds(bounds);
				}
			}
		}
	}

	private void loadSourceVersions(HInterface i, InterfaceType xI) {

		for (SourceType s : xI.getSources()) {
			String versionId = s.getVersionId();
			versionId = checkVersion(versionId) ? versionId : "1.0.0.0";
			String sourceType = s.getSourceType();
			HBESourceVersion<HBEAbstractFile> source = i.createSourceVersion(sourceType);
			source.setVersionID(versionId);

			for (SourceFileType f : s.getFile()) {
				String fileType = f.getFileType().equals("dll") ? "library" : f
						.getFileType();
				String locallocation = this.component.getRelativeLocation();
				URI uriRootPath = URI.createURI(locallocation);
				String rootPath = uriRootPath.toString();
				rootPath = rootPath.replaceAll("%20", " ");
				
				String versionIdF = f.getVersionId();
				versionIdF = checkVersion(versionIdF) ? versionIdF : "1.0.0.0";
				String name = f.getName();
				String contents = f.getContents();
				
				String srcType = f.getSrcType();

				HBEAbstractFile ff = createFile(fileType, name, contents, rootPath, versionIdF, i, srcType);
				ff.setDependencies(new ArrayList<String>(f.getDependency()));
				ff.addExternalReferences(new ArrayList<String>(f.getExternalDependency()));

				try {
					source.addFile(ff);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// if (this.component.containsVersion(toVersion(versionId)));
			i.addSourceVersion(source);
		}

		i.keepVersionConsistency();

	}

	private HBEAbstractFile createFile(String fileType, String name,
			String contents, String rootPath, String versionID, HHasExternalReferences i, String srcType) {
		if (fileType.equals(HBESourceCSharpClassDefinition.getType())) {
			return new HBESourceCSharpClassDefinition(name, contents, rootPath,
					versionID,i, srcType);
		} else if (fileType.equals(HBESourceCSharpMainDefinition.getType())) {
			return new HBESourceCSharpMainDefinition(name, contents, rootPath,
					versionID,i, srcType);
		} else
			return null;

	}

	private HAction buildAction(ActionType xP, HCombinatorAction i,
			HInterface ii, Map<String, HSemaphore> semTable, HProtocol p) {

		HAction a = null;

		String label = xP.getLabel();

		if (xP instanceof ActionCombinatorType) {
			ActionCombinatorType xA = null;
			HCombinatorAction ac = null;
			if (xP instanceof ActionCombinatorAltType) {
				xA = (ActionCombinatorAltType) xP;
				ac = new HAltAction(label, i);
			} else if (xP instanceof ActionCombinatorParType) {
				xA = (ActionCombinatorParType) xP;
				ac = new HParAction(label, i);
			} else if (xP instanceof ActionCombinatorSeqType) {
				xA = (ActionCombinatorSeqType) xP;
				ac = new HSeqAction(label, i);
			}

			a = ac;

			for (ActionType iXA : xA.getAction()) {
				HAction ia = buildAction(iXA, ac, ii, semTable, p);
				// ac.addAction(ia);
			}

		}

		else if (xP instanceof ActionActivateType) {

			ActionActivateType xA = (ActionActivateType) xP;
			HDoAction ac = null;

			String sliceRef = xA.getSliceRef();

			HInterfaceSlice slice = ii.fetchSlice(sliceRef/* .split(".") */);

			ac = new HDoAction(label, i, slice);
			a = ac;

		} else if (xP instanceof ActionSkipType) {

			ActionSkipType xA = (ActionSkipType) xP;
			HSkipAction ac = null;

			ac = new HSkipAction(label, i);
			a = ac;

		} else if (xP instanceof ActionSignalType) {

			ActionSignalType xA = (ActionSignalType) xP;
			HSignalAction ac = null;

			HSemaphore semaphore = getSemaphore(xA.getSemaphore(), semTable, p);

			ac = new HSignalAction(semaphore, label);
			a = ac;

		} else if (xP instanceof ActionWaitType) {

			ActionWaitType xA = (ActionWaitType) xP;
			HWaitAction ac = null;

			HSemaphore semaphore = getSemaphore(xA.getSemaphore(), semTable, p);

			ac = new HWaitAction(semaphore, label);
			a = ac;

		}

		int x = (int) xP.getVisualDescription().getX();
		int y = (int) xP.getVisualDescription().getY();
		int w = (int) xP.getVisualDescription().getW();
		int h = (int) xP.getVisualDescription().getH();

		a.setBounds(new Rectangle(x, y, w, h));

		return a;
	}

	private HComponent createComponent(SupportedKinds kind, String name, URI uri)
			throws HPEUnknownKindException {

		HComponent c = null;

		HPackageLocation location = null;

		if (kind.getName().equals(HComputationComponent.KIND)) {
			c = new HComputationComponent(name, location, uri);
		} else if (kind.getName().equals(HApplicationComponent.KIND)) {
			c = new HApplicationComponent(name, location, uri);
		} else if (kind.getName().equals(HSynchronizationComponent.KIND)) {
			c = new HSynchronizationComponent(name, location, uri);
		} else if (kind.getName().equals(HArchitectureComponent.KIND)) {
			c = new HArchitectureComponent(name, location, uri);
		} else if (kind.getName().equals(HDataComponent.KIND)) {
			c = new HDataComponent(name, location, uri);
		} else if (kind.getName().equals(HEnvironmentComponent.KIND)) {
			c = new HEnvironmentComponent(name, location, uri);
		} else if (kind.getName().equals(HQualifierComponent.KIND)) {
			c = new HQualifierComponent(name, location, uri);
		} else if (kind.getName().equals(HEnumeratorComponent.KIND)) {
			c = new HEnumeratorComponent(name, location, uri);
		} else if (kind.getName().equals(HFacetComponent.KIND)) {
			c = new HFacetComponent(name, location, uri);
		} else if (kind.getName().equals(HDomainComponent.KIND)) {
			c = new HDomainComponent(name, location, uri);
		} else if (kind.getName().equals(HServiceComponent.KIND)) {
			c = new HServiceComponent(name, location, uri);
		} else {
			throw new HPEUnknownKindException("Component Kind Not Supported !");
		}

		return c;

	}

	private HSemaphore getSemaphore(String semRef,
			Map<String, HSemaphore> semTable, HProtocol p) {

		return (semTable.containsKey(semRef)) ? semTable.get(semRef)
				: new HSemaphore(semRef, p);

	}


}
