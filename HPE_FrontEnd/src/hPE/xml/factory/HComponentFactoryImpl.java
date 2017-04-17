package hPE.xml.factory;

import hPE.HPEProperties;
import hPE.core.library.HPEComponentFileNotFound;
import hPE.core.library.HPELocationEntry;
import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpClassDefinition;
import hPE.frontend.base.codegen.c_sharp.HBESourceCSharpMainDefinition;
import hPE.frontend.base.commands.BindingCreateCommand;
import hPE.frontend.base.commands.SupersedeCommand;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HPackageLocation;
import hPE.frontend.base.model.HPort;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IHVisualElement;
import hPE.frontend.base.model.IHasColor;
import hPE.frontend.base.settings.HPlatformSettingsFile;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.HProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.HProtocolPerform;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.binding.model.HBindingComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.frontend.kinds.topology.model.HTopologyComponent;
import hPE.ui.preferences.PreferenceConstants;
import hPE.util.CommandLine;
import hPE.util.Pair;
import hPE.util.Triple;
import hPE.xml.component.ActionType;
import hPE.xml.component.BaseTypeType;
import hPE.xml.component.CRefsIndexedType;
import hPE.xml.component.ColorComplexType;
import hPE.xml.component.ComponentBodyType;
import hPE.xml.component.ComponentFactory;
import hPE.xml.component.ComponentHeaderType;
import hPE.xml.component.ComponentInUseType;
import hPE.xml.component.ComponentPackage;
import hPE.xml.component.ComponentType;
import hPE.xml.component.ConditionType;
import hPE.xml.component.DocumentRoot;
import hPE.xml.component.EnumeratorType;
import hPE.xml.component.ExtensionTypeType;
import hPE.xml.component.ExternalLibraryType;
import hPE.xml.component.FacetConfigurationType;
import hPE.xml.component.FacetMultiplicityType;
import hPE.xml.component.FusionType;
import hPE.xml.component.GuardType;
import hPE.xml.component.InnerComponentType;
import hPE.xml.component.InnerRenamingType;
import hPE.xml.component.InterfaceParameterType;
import hPE.xml.component.InterfacePortType;
import hPE.xml.component.InterfaceRefType;
import hPE.xml.component.InterfaceSliceType;
import hPE.xml.component.InterfaceType;
import hPE.xml.component.ParameterRenaming;
import hPE.xml.component.ParameterSupplyType;
import hPE.xml.component.ParameterType;
import hPE.xml.component.PortSliceType;
import hPE.xml.component.ProtocolChoiceType;
import hPE.xml.component.ProtocolCombinatorVisualType;
import hPE.xml.component.ProtocolPerformVisualType;
import hPE.xml.component.RecursiveEntryType;
import hPE.xml.component.SourceFileType;
import hPE.xml.component.SourceType;
import hPE.xml.component.SupportedKinds;
import hPE.xml.component.UnitActionType;
import hPE.xml.component.UnitBoundsType;
import hPE.xml.component.UnitConditionType;
import hPE.xml.component.UnitRefType;
import hPE.xml.component.UnitSliceType;
import hPE.xml.component.UnitType;
import hPE.xml.component.VarianceType;
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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
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
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.graphics.Color;

public final class HComponentFactoryImpl implements HComponentFactory 
{
	private Map<Integer,Integer> facet_cardinality = new HashMap<Integer,Integer>();
	
	public HComponentFactoryImpl(Map<Integer,Integer> facet_cardinality)
	{
		 if (facet_cardinality != null) 
			 this.facet_cardinality = facet_cardinality;
	}

	public static class DuplicatedSliceNamesException extends Exception {

		private static final long serialVersionUID = 7585695943859883441L;

		public DuplicatedSliceNamesException(HUnitSlice slice) {
			super("Invalide duplicate slice name " + slice.getName()
					+ " in the unit "
					+ slice.getUnit().getTopUnit(null).getName2() + ".");
		}

		public DuplicatedSliceNamesException(HInterfaceSlice slice) {
			super("Invalid duplicate slice name " + slice.getName()
					+ " in the interface " + slice.getInterfaceSig().getName()
					+ ".");
		}

	}

	public static class DuplicatedRefInnerException extends Exception {

		private static final long serialVersionUID = -8792075302351667897L;

		public DuplicatedRefInnerException(String ref) {
			super("Duplicated ID " + ref + " for inner components.");
		}

	}

	public static class UndefinedRefInnerException extends Exception {

		public UndefinedRefInnerException(HComponent ic) {
			super("Undefined ID for an inner component of type "
					+ ic.getComponentName());
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
			resourceSet
					.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
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

	public void saveComponent(HComponent c, java.io.File file,
			IProgressMonitor monitor) throws UndefinedRefInnerException,
			DuplicatedRefInnerException, DuplicatedSliceNamesException {

		this.component = c;
		ComponentType cX = marshallComponent(c);
		this.saveComponent(cX, file, monitor);

	}

	// Loads a ComponentType object from XML in a HComponent object
	public List<HComponent> loadComponent(URI uri, boolean isTop,
			boolean isExtending, boolean isImplementing, boolean cached,
			boolean relativePath) throws HPEInvalidComponentResourceException {
		return loadComponent(uri, isTop,isExtending,isImplementing,cached,relativePath,0, new ArrayList<Integer>());
	}

	public List<HComponent> loadComponent(URI uri, boolean isTop,
			boolean isExtending, boolean isImplementing, boolean cached,
			boolean relativePath, int level, List<Integer> multiple_facets_revoked) throws HPEInvalidComponentResourceException {
		ComponentType component = loadComponentX(uri, cached, relativePath);
		return buildComponent(component, uri, isTop, isExtending, isImplementing, level, multiple_facets_revoked);
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
	public ComponentType loadComponentX(URI uri, boolean cache,
			boolean relativePath) throws HPEInvalidComponentResourceException {
		try {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet
					.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new ComponentResourceFactoryImpl());
			resourceSet.getPackageRegistry().put(ComponentPackage.eNS_URI,
					ComponentPackage.eINSTANCE);

			Resource resource = null;
			/*
			 * if (this.workspace != null || cache) { resource =
			 * resourceSet.getResource(uri, true); } else
			 */if (relativePath) {
				URI uriFull = URI.createFileURI(this.getWorkspacePath()
						+ Path.SEPARATOR + uri.toString());
				resource = resourceSet.getResource(uriFull, true);
			} else {
				URI uriFull = uri; // URI.createFileURI(uri.toString());
				resource = resourceSet.getResource(uriFull, true);
			}

			ComponentResourceImpl cResource = (ComponentResourceImpl) resource;
			EList rs = cResource.getContents();

			if (rs.size() != 1)
				throw new HPEInvalidComponentResourceException();

			ComponentType component = ((DocumentRootImpl) rs.get(0))
					.getComponent();

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

		// IPath wpath = new Path(getWorkspacePath());
		// IPath rrr = wpath.append(path);
		// return rrr;
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
//	private Map<String, UnitType> mU1 = null;
//	private Map<UnitType, HUnit> mU2 = null;
	private Map<String, HUnit> mU3 = null;
	private Map<String, EnumeratorType> mR1 = null;
	// private Map<EnumeratorType, HReplicator> mR2 = null;

	private HComponent component = null;

	private void loadSuperTypeComponent(ComponentHeaderType xCheader, int level)
			throws HPEInvalidComponentResourceException,
			HPEComponentFileNotFound {
		BaseTypeType xBaseType = xCheader.getBaseType();
		if (xBaseType != null) {
			ExtensionTypeType extType = xBaseType.getExtensionType();
			ComponentInUseType baseComponent = xBaseType.getComponent();

			String package_ = baseComponent.getPackage();
			String name = baseComponent.getName();
			URI locationUri = URI.createURI(package_ + "." + name + Path.SEPARATOR + name + ".hpe");
			VisualElementAttributes v = baseComponent.getVisualDescription();
			Rectangle bounds = new Rectangle((int) v.getX(), (int) v.getY(), (int) v.getW(), (int) v.getH());
			// String version = baseComponent.getVersion();

			java.io.File fileCache = getCachePath(package_, name);
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
					java.io.File file = HPELocationEntry.getComponent(package_.replace(".", ":").split(":"), name, null, locationUri);
					innerUri = URI.createFileURI(file.getAbsolutePath());
					retrieveLibraries = true;
				}
			} else {
				if (locationUri.scheme() == null
						|| !locationUri.scheme().equals("http")) {
					// COMPARE DATES OF THE PROJECT FILE AND CACHED FILE.
					IPath pathC = new Path(locationUri.toString());
					// IPath path =
					// ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation();
					IPath path = HComponentFactoryImpl.buildWPath(pathC);
					long lastDataCache = fileCache.lastModified();
					java.io.File fileProject = new File(path.toString());
					long lastDateProject = fileProject.lastModified();
					// CHECK COMPILED SOURCES STATUS
					java.io.File parentFileCache = new File(fileCache
							.getParentFile().getAbsolutePath()
							+ Path.SEPARATOR
							+ "bin" + Path.SEPARATOR + "1.0.0.0");
					java.io.File parentFileProject = new File(fileProject
							.getParentFile().getAbsolutePath()
							+ Path.SEPARATOR
							+ "bin" + Path.SEPARATOR + "1.0.0.0");
					FilenameFilter filter = new FilenameFilter() {
						@Override
						public boolean accept(File dir, String name) {
							return name.endsWith(".dll");
						}
					};
					java.io.File[] fsCache = parentFileCache.listFiles(filter);
					java.io.File[] fsProject = parentFileProject
							.listFiles(filter);

					if ((fsCache != null && fsProject != null)
							&& (lastDateProject > lastDataCache
									|| fsProject.length > fsCache.length || (fsProject != null && fsCache == null))) {
						IPath pathC1 = new Path(locationUri.toString());
						IPath path1 = HComponentFactoryImpl.buildWPath(pathC1);
						innerUri = URI.createFileURI(path1.toString()
								.replaceAll("%20", " "));
						copyToCache = true;
					} else
						innerUri = URI.createFileURI(fileCache.getAbsolutePath());
				} else {
					innerUri = URI.createFileURI(fileCache.getAbsolutePath());
				}
			}

			this.isSubType = extType.isSetExtends() && extType.isExtends();
			this.isConcrete = extType.isSetImplements() && extType.isImplements();

			List<Integer> multiple_facets_revoked = baseComponent.getRevokeMultipleFacet();
			
			HComponent superType = (new HComponentFactoryImpl()).loadComponent(
					innerUri, false, this.isSubType, this.isConcrete,
					!copyToCache, false, level+1, multiple_facets_revoked).get(0);

			if (copyToCache)
				copyProjectToCache(superType, locationUri);

			if (retrieveLibraries)
				retrieveLibraries(superType, locationUri);

			mC1.put(baseComponent.getLocalRef(), baseComponent);
			mC2.put(baseComponent, superType);

			component.loadComponent(superType, bounds.getLocation());
			this.basetype = superType;

			superType.setBounds(bounds);
			superType.setName(baseComponent.getLocalRef());

			loadParameterRenamings(baseComponent, superType);
			loadPorts(baseComponent, this.component, superType);
			loadUnitBounds(baseComponent, superType);

		}

	}

	private HComponent basetype = null;
	private boolean isConcrete = false;
	private boolean isSubType = false;

	private void loadInnerComponents(ComponentBodyType xCinfo, boolean isTop, int level) 
	{
		for (InnerComponentType xInnerC : xCinfo.getInnerComponent())
			if (!xInnerC.getLocalRef().startsWith("C###") && !xInnerC.getLocalRef().startsWith("T###")) 
			{
				try {

					mC1.put(xInnerC.getLocalRef(), xInnerC);

					String name = xInnerC.getName();
					String package_ = xInnerC.getPackage();
					String location = package_ + "." + name + Path.SEPARATOR + name + ".hpe";
					URI locationUri = location /* xInnerC.getLocation() */!= null ? URI.createURI(location) : URI.createURI(HPEProperties.get(PreferenceConstants.LOCAL_LOCATION));
					String ref = xInnerC.getLocalRef();
					// String version = xInnerC.getVersion();
					boolean isExposed = xInnerC.isExposed();
					boolean isMultiple = xInnerC.isSetMultiple() ? xInnerC.isMultiple() : false;
					java.io.File fileCache = getCachePath(package_, name);
					URI innerUri = null;

					boolean copyToCache = false;
					boolean retrieveLibraries = false;
					if (!fileCache.exists()) {
						if (locationUri.scheme() == null || !locationUri.scheme().equals("http")) {
							IPath pathC = new Path(locationUri.toString());
							IPath path = HComponentFactoryImpl.buildWPath(pathC);
							innerUri = URI.createFileURI(path.toString().replaceAll("%20", " "));
							copyToCache = true;
						} else {
							java.io.File file = HPELocationEntry.getComponent(package_.replace(".", ":").split(":"), name, null, locationUri);
							innerUri = URI.createFileURI(file.getAbsolutePath());
							retrieveLibraries = true;
						}
					} else {
						if (locationUri.scheme() == null || !locationUri.scheme().equals("http")) {
							// COMPARE DATES OF THE PROJECT FILE AND CACHED
							// FILE.
							IPath pathC = new Path(locationUri.toString());
							// IPath path =
							// ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation();
							IPath path = HComponentFactoryImpl.buildWPath(pathC);
							long lastDataCache = fileCache.lastModified();
							java.io.File fileProject = new File(path.toString());
							long lastDateProject = fileProject.lastModified();
							// COMPARE BINARY FOLDERS
							java.io.File parentFileCache = new File(fileCache.getParentFile().getAbsolutePath() + Path.SEPARATOR + "bin" + Path.SEPARATOR + "1.0.0.0");
							java.io.File parentFileProject = new File(fileProject.getParentFile().getAbsolutePath() + Path.SEPARATOR + "bin" + Path.SEPARATOR + "1.0.0.0");
							FilenameFilter filter = new FilenameFilter() {
								@Override
								public boolean accept(File dir, String name) {
									return name.endsWith(".dll");
								}
							};
							java.io.File[] fsCache = parentFileCache.listFiles(filter);
							java.io.File[] fsProject = parentFileProject.listFiles(filter);

							if ((fsCache != null && fsProject != null)	&& (lastDateProject > lastDataCache	|| fsProject.length > fsCache.length || (fsProject != null && fsCache == null))) {
								IPath pathC1 = new Path(locationUri.toString());
								IPath path1 = HComponentFactoryImpl.buildWPath(pathC1);
								innerUri = URI.createFileURI(path1.toString().replaceAll("%20", " "));
								copyToCache = true;
							} else
								innerUri = URI.createFileURI(fileCache.getAbsolutePath());
						} else 
							innerUri = URI.createFileURI(fileCache.getAbsolutePath());
					}

			        List<Integer> multiple_facets_revoked = xInnerC.getRevokeMultipleFacet();
					
					Map<Integer,Integer> inner_facet_cardinality = alignFacetMultiplicity(facet_cardinality, xInnerC.getUnitBounds());
					
					List<HComponent> innerC_list = (new HComponentFactoryImpl(inner_facet_cardinality)).loadComponent(innerUri, false, false, false, !copyToCache, false, level+1, multiple_facets_revoked);

					for (HComponent innerC : innerC_list)
					{
						if (locationUri.scheme() != null && locationUri.scheme().equals("http")) 
							innerC.setRemoteURI(locationUri);
	
						if (copyToCache)
							copyProjectToCache(innerC, locationUri);
	
						if (retrieveLibraries)
							retrieveLibraries(innerC, locationUri);
	
						mC2.put(xInnerC, innerC);
	
						int x, y, w, h, r, g, b;
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
							x = 0;
							y = 0;
							w = 100;
							h = 100;
							color = ColorConstants.white;
						}
	
						Point where = new Point(x, y);
						component.loadComponent(innerC, where);
						
						innerC.setBounds(new Rectangle(x, y, w, h));
						innerC.setColor(color);
						innerC.setName(ref);
						innerC.setExposed(isExposed);
						innerC.setMultiple(isMultiple);
						// innerC.setPackagePath(new Path(package_));
	
						loadParameterRenamings(xInnerC, innerC);
						loadPorts(xInnerC, this.component, innerC);					
						
						loadUnitBounds(xInnerC, innerC);
					}

				} catch (HPEInvalidComponentResourceException e) {
					String message = "ERROR loading component " + xInnerC.getPackage() + "." + xInnerC.getName() + "! (inner component " + xInnerC.getLocalRef() + ").";
					System.err.println(message);
					JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
				} catch (HPEComponentFileNotFound e) {
					String message = "Component " + xInnerC.getPackage() + "." + xInnerC.getName() + " NOT fuound in " + xInnerC.getLocalRef() + ").";
					System.err.println(message);
					JOptionPane.showMessageDialog(null, message, "Loading Component Error",	JOptionPane.ERROR_MESSAGE);
				}
			}
		// catch (IOException e) {

		// }

	}

	private Map<Integer,Integer> alignFacetMultiplicity(Map<Integer, Integer> facet_cardinality, 
														EList<UnitBoundsType> unitBoundsSet) 
	{
		Map<Integer,Integer> facet_count_dict = new HashMap<Integer,Integer>();
		
		for (UnitBoundsType unitBounds : unitBoundsSet)
		{
			int facet_instance_enclosing = unitBounds.getFacetInstanceEnclosing();
			int facet_instance_enclosing_count = facet_cardinality.containsKey(facet_instance_enclosing) ? facet_cardinality.get(facet_instance_enclosing) : 1;

			int facet = unitBounds.getFacet();
			
			facet_count_dict.put(facet, facet_instance_enclosing_count + (facet_count_dict.containsKey(facet) ? facet_count_dict.get(facet) : 0));
		}	
			
		return facet_count_dict;	
		
//		for (UnitBoundsType unitBounds : unitBoundsSet)
//		{
//			int facet_instance_enclosing = unitBounds.getFacetInstanceEnclosing();
//			int facet_instance_enclosing_count = facet_cardinality.containsKey(facet_instance_enclosing) ? facet_cardinality.get(facet_instance_enclosing) : 1;
//			int facet = unitBounds.getFacet();
//			int facet_count = facet_multiplicity_load.containsKey(facet) ? facet_multiplicity_load.get(facet) : 1;
//			
//			int new_facet_count = facet_count + facet_instance_enclosing_count - 1;
//			
//			if (new_facet_count > 1)
//				facet_multiplicity_load.put(facet, new_facet_count);
//		}
		
	}

	private void retrieveLibraries(HComponent innerC, URI locationUri) {

		// List<Integer[]> versions = innerC.getVersions();

		for (HInterface i : innerC.getInterfaces())
			if (i.getConfiguration() == innerC) {
				// for (Integer[] version : versions) {
				String versionID = null; // HInterface.toStringVersion(version);
				HBESourceVersion sv = i.getSourceVersion(versionID == null ? "1.0.0.0" : versionID);
				for (HBEAbstractSourceCodeFile file : sv.getFiles()) {
					String packageName = innerC.getPackagePath().toString();
					String componentName = innerC.getComponentName();
					HPELocationEntry.getBinaryFile(packageName, componentName,
							versionID, file, locationUri);
				}
				// }
			}

	}

	public static void copyProjectToCache(HComponent innerC, URI locationURI) {
		copyProjectToCache(innerC, "1.0.0.0", locationURI);
	}

	private static void copyProjectToCache(HComponent innerC, String version,
			URI locationURI) {

		IPath pathC = new Path(innerC.getLocalLocation());
		if (pathC.segment(0).equals("file:")) {
			pathC = pathC.removeFirstSegments(1).makeAbsolute();
		}

		// IPath path =
		// ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation().removeLastSegments(1);
		IPath path = HComponentFactoryImpl.buildWPath(pathC.setDevice(null))
				.removeLastSegments(1);

		String cachePath = addSegment(
				HPEProperties.get(PreferenceConstants.CACHE_PATH), (new Path(
						locationURI.toString())).removeLastSegments(1)
						.toString());

		try {
			copyDirectory(new File(path.toString()), new File(cachePath));
			String gacutil_path = HPEProperties
					.get(PreferenceConstants.GACUTIL_PATH);
			List<String> l = innerC.getModuleNames(version);
			for (String fileName : l) {
				CommandLine.runCommand(new String[] { gacutil_path, "-i",
						".." + fileName }, path.toFile());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void copyDirectory(File srcPath, File dstPath)
			throws IOException {

		if (srcPath.isDirectory()) {

			if (!dstPath.exists()) {
				dstPath.mkdirs();
			}

			String files[] = srcPath.list();

			for (int i = 0; i < files.length; i++) {
				copyDirectory(new File(srcPath, files[i]), new File(dstPath,
						files[i]));
			}
		} else {
			if (!srcPath.exists()) {
				System.out.println("File or directory does not exist.");

				// System.exit(0);
			} else {
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

		String cachePath = HPEProperties.get(PreferenceConstants.CACHE_PATH);

		java.io.File cacheFilePath = new java.io.File(cachePath);
		if (!cacheFilePath.exists())
			cacheFilePath.mkdir();

		String fileName = addSegment(cachePath, locationUri.toString());

		java.io.File configFilePath = new java.io.File(fileName);
		configFilePath = new java.io.File(configFilePath.getParent());
		if (!configFilePath.exists())
			configFilePath.mkdir();

		java.io.File binFilePath = new java.io.File(addSegment(
				configFilePath.getAbsolutePath(), "bin"));
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

	public static File getCachePath(String pk, String componentName) {
		return getCachePath(pk, componentName, "1.0.0.0");
	}

	private static File getCachePath(String pk, String componentName,
			String version) {

		URI locationURI = HComponent.getStandardLocationPath(pk, componentName,
				version);

		return getCachePath(locationURI);
	}

	// private Map<HComponent, Map<String, Integer>> unitSplits = new
	// HashMap<HComponent, Map<String, Integer>>();

	// Key: f("<cref>.<uref>.<index>") = "<unit_index>"
	private Map<String, Integer> unitSliceIndexMapping = null;

	private void loadUnitBounds(ComponentInUseType xInnerC, HComponent innerC) 
	{
		String cRef = xInnerC.getLocalRef();
		
		// Configure unit bounds
		Map<String, Map<Integer, Integer>> unitCounts = new HashMap<String, Map<Integer, Integer>>();
		Map<String, Map<Integer, Boolean>> checkParallel = new HashMap<String, Map<Integer, Boolean>>();
		unitSliceIndexMapping = new HashMap<String, Integer>();
		
		Map<String,Map<Integer,Integer>> facet_instance_to_index_mapping = new HashMap<String,Map<Integer,Integer>>();

		if (xInnerC.getUnitBounds().isEmpty()) 
			loadDefaultSliceIndexMapping(innerC);

		for (UnitBoundsType uBound : xInnerC.getUnitBounds()) 
		{
			String uRef = uBound.getURef();
			int index = (int) (!uBound.isSetReplica() ? uBound.getSliceReplica() : uBound.getReplica());
			boolean is_parallel = uBound.isParallel();
			int index_slice = uBound.isSetUnitReplica() ? uBound.getUnitReplica() : index;
			int facet_instance = uBound.getFacetInstance();
			unitBounds.add(new Pair<HComponent, UnitBoundsType>(innerC, uBound));
			int count = 1;
			Map<Integer, Integer> unitCountsReplica;
			
			if (unitCounts.containsKey(uRef)) 
			{
				unitCountsReplica = unitCounts.get(uRef);
				if (unitCountsReplica.containsKey(index_slice)) 
				{
					count = unitCountsReplica.get(index_slice) + 1;
					unitCountsReplica.remove(index_slice);
				}
				unitCountsReplica.put(index_slice, count);
			} else 
			{
				unitCountsReplica = new HashMap<Integer, Integer>();
				unitCountsReplica.put(index_slice, count);
				unitCounts.put(uRef, unitCountsReplica);

				Map<Integer, Boolean> ispar_mapping = new HashMap<Integer, Boolean>();
				checkParallel.put(uRef, ispar_mapping);
			}

			unitSliceIndexMapping.put(mkUnitSliceRef(cRef, uRef, index), index_slice);
			
			if (!facet_instance_to_index_mapping.containsKey(uRef))
			{
				Map<Integer, Integer> m = new HashMap<Integer,Integer>();
				facet_instance_to_index_mapping.put(uRef, m);
			}
			facet_instance_to_index_mapping.get(uRef).put(index, facet_instance);				

			checkParallel.get(uRef).put((int) index, is_parallel);
		}

		for (Entry<String, Map<Integer, Integer>> u : unitCounts.entrySet()) 
		{
			int u_count = 0;
			for (Entry<Integer, Integer> u_replica : u.getValue().entrySet()) 
			{
				u_count += u_replica.getValue();
			}
			
			for (Entry<Integer, Integer> u_replica : u.getValue().entrySet()) 
			{
				String uRef = u.getKey();
				IHUnit cloned_unit = innerC.fetchUnit(uRef, u_replica.getKey());
				IHUnit top_unit = cloned_unit;
				while (top_unit.cloneOf() != null)
					top_unit = (IHUnit) top_unit.cloneOf();

				if (cloned_unit != null) /*
										 * TODO: BUG HERE: returning null in
										 * some cases ...
										 */
					cloned_unit.setMultiple(checkParallel.get(uRef).get(0));
				
				Integer count = u_count - top_unit.getClones().size() + 1;
				if (count > 1)
					for (int i = 0; i < count-1; i++) 
					{
						int index = top_unit.getClones().size() - 1;
						IHUnit unit_replica = (IHUnit) top_unit.createReplica(cloned_unit, index);
						unit_replica.setMultiple(checkParallel.get(uRef).get(i + 1));
						unit_replica.setFacetInstance(facet_instance_to_index_mapping.get(uRef).get(index+1));
					}
			}
		}

		// unitSplits.put(innerC, unitCounts);

	}

	private void loadDefaultSliceIndexMapping(HComponent innerC) {
		String cRef = innerC.getRef();
		for (IHUnit unit : innerC.getUnits()) {
			String uRef = unit.getName2();
			int index_slice = unit.getUnitReplicaIndex();
			int index = unit.getSliceReplicaIndex();
			this.unitSliceIndexMapping.put(
					this.mkUnitSliceRef(cRef, uRef, index_slice), index);
		}

	}

	private String mkUnitSliceRef(String cRef, String uRef, int index_slice) {
		return cRef + "." + uRef + "[" + index_slice + "]";
	}

	private void loadParameterRenamings(ComponentInUseType xInnerC,
			HComponent innerC) {
		// Apply Parameter Renaming
		for (ParameterRenaming p : xInnerC.getParameter()) {
			String formFieldId = p.getFormFieldId();
			String varName = p.getVarName();
			if (!formFieldId.equals("type ?") && !varName.startsWith("X###"))
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

	private void loadPorts(ComponentInUseType xInnerC, HComponent context, HComponent innerC) 
	{
		// Load Ports
		for (InnerComponentType port : xInnerC.getPort()) 
		{
			String pRef = port.getLocalRef();
			boolean pIsExposed = port.isExposed();
			HComponent p = innerC.getExposedComponentByName(pRef, port.getIndexReplica());
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
				p.setExposed(pIsExposed, context);
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
			HComponent port = c.getExposedComponentByName(pRef,portX.getIndexReplica());
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
			if (uBound.isSetSliceReplica() || uBound.isSetReplica()) {
				int slice_replica = (int) (!uBound.isSetReplica() ? uBound
						.getSliceReplica() : uBound.getReplica());
				u = innerC.fetchUnit(uBound.getURef(), slice_replica);
				if (u == null)
					System.err.println("Replicated unit " + uBound.getURef()
							+ " not found when loading inner component "
							+ innerC.getRef());
				// throw new HPEInvalidComponentResourceException(
				// "Replicated unit not found in load inner components !");
			} else {
				u = innerC.fetchUnit(uBound.getURef());
				if (u == null)
					System.err.println("Unit " + uBound.getURef()
							+ " not found when loading inner component "
							+ innerC.getRef());
				// throw new HPEInvalidComponentResourceException(
				// "Unit not found in load inner components !");
			}
			if (u != null) {
				u.setBounds(bounds);
			}
		}

	}

	/*
	 * private void loadSplits(ComponentBodyType xCinfo) throws
	 * HPEInvalidComponentResourceException {
	 * 
	 * // Splits. for (SplitType xSplit : xCinfo.getSplit()) { String eRef =
	 * xSplit.getERef(); int n = xSplit.getN();
	 * 
	 * List<String> oRef = xSplit.getOriginRef(); HComponent c = !oRef.isEmpty()
	 * ? this.mC2.get(mC1.get(oRef.get(0))) : this.component; HReplicator
	 * enumerator = c.lookForReplicator(eRef, oRef);
	 * 
	 * String cRefPermutation = xSplit.getCRefPermutation();
	 * HEnumeratorComponent cPermutation = (HEnumeratorComponent)
	 * (cRefPermutation != null ? this.mC2 .get(mC1.get(cRefPermutation)) :
	 * null);
	 * 
	 * EList<SplitLinkType> splitLinks = xSplit.getSplitLink(); EList<String>
	 * splitEnums = xSplit.getSplitEnumerator();
	 * 
	 * List<HLinkToReplicator> sLinks = new ArrayList<HLinkToReplicator>();
	 * 
	 * for (SplitLinkType sl : splitLinks) { String cRef = sl.getCRef(); String
	 * uRef = sl.getURef();
	 * 
	 * HComponent ic = mC2.get(mC1.get(cRef)); HLinkToReplicator l =
	 * enumerator.getLinkForItem(ic .fetchUnit(uRef)); if (l != null) {
	 * sLinks.add(l); } else throw new HPEInvalidComponentResourceException(
	 * "Link to Replicator not found");
	 * 
	 * }
	 * 
	 * HReplicatorSplit split = enumerator.split(n, "", sLinks, component,
	 * null); if (cPermutation != null) { split.setPermutation(cPermutation); //
	 * component.hideInnerComponent(cPermutation); } if (splitEnums.size() !=
	 * split.getReplicators().size()) throw new
	 * HPEInvalidComponentResourceException(); Iterator<String> ses =
	 * splitEnums.iterator(); Iterator<HReplicator> eSplits =
	 * split.getReplicators().iterator(); while (ses.hasNext() &&
	 * eSplits.hasNext()) { String eRefSplit = ses.next(); HReplicator eSplit =
	 * eSplits.next(); eSplit.setRef(eRefSplit); if
	 * (this.delayedSplits.containsKey(eRefSplit)) {
	 * this.configureReplicator(eSplit, this.delayedSplits .get(eRefSplit)); } }
	 * 
	 * }
	 * 
	 * }
	 */
	private void setupParameters(ComponentBodyType xCinfo) {

		EList<ParameterType> parametersX = xCinfo.getParameter();

		for (ParameterType param : parametersX) {
			String par_id = param.getFormFieldId();
			String sBaseC = param.getComponentRef();
			int order = param.getOrder();
			HComponent baseC = mC2.get(mC1.get(sBaseC));
			baseC.setParameter(par_id);
			if (param.isSetOrder())
				component.setParameterOrder(par_id, order);
			component
					.setParameterVariance(
							par_id,
							component.getParameterVariance(par_id,
									param.getVariance()));
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

		for (ParameterSupplyType xSupply : xCinfo.getSupplyParameter())
			if (xSupply.isDirect()) {
				String varName = xSupply.getVarName();
				if (!varName.startsWith("X###")) {
					String cRef = xSupply.getCRef();
					ComponentInUseType c1 = mC1.get(cRef);
					if (c1 != null) {
						HComponent cSupply = mC2.get(mC1.get(cRef));
						if (cSupply != null)
							component.supplyParameter(varName, cSupply);
					} else {
						System.err
								.print(cRef
										+ " not found in suppyParameters (HComponentFactoryImpl)");
					}
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

		//mU1 = new HashMap<String, UnitType>();
		//mU2 = new HashMap<UnitType, HUnit>();
		mU3 = new HashMap<String, HUnit>();

		for (UnitType xU : xCinfo.getUnit()) {
			buildUnit(xU, component);
		}

	}

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
	public List<HComponent> buildComponent(ComponentType xC, URI uri, boolean isTop, boolean isExtending, boolean isImplementing, int level, List<Integer> multiple_facets_revoked) 
	{
		List<HComponent> component_list = new ArrayList<HComponent>();
		
		try {
			ComponentHeaderType xCheader = xC.getHeader();
			ComponentBodyType xCinfo = xC.getComponentInfo();

			int copies = level > 1 ? checkFacetCardinality(xCheader, multiple_facets_revoked) : 1;
			if (copies == 2)
				System.out.print(true);
			
			String name = xCheader.getName();
			SupportedKinds kind = xCheader.getKind();
			String packagePath = xCheader.getPackagePath();
			String hash_component_UID = xCheader.getHashComponentUID();
			String locationURI = xCheader.getLocationURI();
			boolean isAbstract = xCheader.isIsAbstract();

			this.isConcrete = false;
			this.isSubType = false;

			
			for (int facet_instance = 0; facet_instance < copies; facet_instance++)
			{			
				component = this.createComponent(kind, name, uri);
				component_list.add(component);
				
				component.setPackagePath(new Path(packagePath));
				component.setHashComponentUID(hash_component_UID);
				component.setIndexReplica(facet_instance);
				setFacetConfiguration(xCheader);
					
				VisualElementAttributes v = xCheader.getVisualAttributes();
				if (v != null) 
				{
					Color color;
					if (v.getColor() != null) 
					{
						int r = v.getColor().getR();
						int g = v.getColor().getG();
						int b = v.getColor().getB();
						color = new Color(null, r, g, b);
					} 
					else 
					{
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
			    
				
				loadSuperTypeComponent(xCheader, level);
				loadVersions(xCheader.getVersions());
	
				if (xCinfo != null) 
				{
					loadInnerComponents(xCinfo, isTop, level);				
	
					setupVariableNamesOfTopLevelInners(xCinfo);
					laterFetchPorts();
	
					if (this.isConcrete)
						component.setImplements(this.basetype);
					if (this.isSubType)
						component.setExtends(this.basetype);
	
					loadExternalLibraries(xCinfo);
					readInterfaces(xCinfo); //
					loadUnits(xCinfo);//
					setupParameters(xCinfo);
					supplyParameters(xCinfo);
					applyRenaming(xCinfo);
					setRecursive(xCinfo);
					loadInterfaces(xCinfo, isTop, isImplementing);
					loadUnitBounds();
	
					applyFusions(xCinfo);
	
					loadInterfacePorts();
				}
			}

			return component_list;

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	private int checkFacetCardinality(ComponentHeaderType xCheader, List<Integer> multiple_facets_revoked) throws Exception 
	{
		int copies = 1;
		EList<FacetConfigurationType> facet_config_list = xCheader.getFacetConfiguration();
	    
	    for (FacetConfigurationType facet_config : facet_config_list)
	    {
	       int facet = facet_config.getFacet();
	       boolean facet_multiple = facet_config.isMultiple() && !multiple_facets_revoked.contains(facet);
	       if (facet_cardinality.containsKey(facet) && facet_cardinality.get(facet) > 1 && facet_multiple==false)
	       {
	    	   if (facet_config_list.size() > 1)
	    		  // The component has several facets; trying to multiply facet "facet" but it cannot be multiplied.
	    	      throw new Exception ("Ill formed configuration ! Cannot multiply facet " + facet + " of " + component.getComponentName());
	    	   else 
	    	   {
	    		   // The component has only one facet; so, the component at all may be multiplied.
	    		  copies = this.facet_cardinality.get(facet);
	    		  this.facet_cardinality.remove(facet);
	    	   }
	    	   
	       }
	    }
		return copies;
	}

	private void setFacetConfiguration(ComponentHeaderType xCheader) throws Exception 
	{
		EList<FacetConfigurationType> facet_config_list = xCheader.getFacetConfiguration();
	    
	    for (FacetConfigurationType facet_config : facet_config_list)
	    {
	       int facet = facet_config.getFacet();
	       boolean facet_multiple = facet_config.isMultiple();
	       component.addFacet(facet, facet_multiple);
	    }
	}


	private void loadExternalLibraries(ComponentBodyType xCinfo) {
		for (ExternalLibraryType ext_library : xCinfo.getExternalLibrary()) {
			String name = ext_library.getName();
			String[] external_dependency = (String[]) ext_library
					.getExternalDependency().toArray();
			this.component.addExternalLibrary(name, external_dependency);
		}

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

			for (HPort port : i.getPorts()) {
				try {
					HComponent c = (HComponent) port.getConfiguration();
					c.updatePorts();
				} catch (HPEAbortException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			i.signalUpdateVisual();

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

	private void loadInterfaces(ComponentBodyType xCinfo, boolean isTop,
			boolean isImplementing)
			throws HPEInvalidComponentResourceException, HPEAbortException {

		for (UnitType xU : xCinfo.getUnit()) 
		{
			String uName = xU.getURef();
			int facet_instance_cardinality = facet_cardinality.get(xU.getFacet()) == null ? 1 : facet_cardinality.get(xU.getFacet());
			for (int facet_instance=0; facet_instance < facet_instance_cardinality; facet_instance++)
			{
				HUnit u = mU3.get(uName + facet_instance);
				loadInterface(xU, u, isTop, isImplementing);
			}
		}

	}

	private void applyRenaming(ComponentBodyType xI) {

		for (InnerRenamingType ir : xI.getInnerRenaming()) {
			String cRef = ir.getCRef();
			String oldName = ir.getCOldName();
			String newName = ir.getCNewName();
			int index_replica = ir.getIndexReplica();

			if (cRef != null) {
				if (mC1.containsKey(cRef)) {
					HComponent cc = mC2.get(mC1.get(cRef)).getExposedComponentByName(oldName, index_replica);
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
		for (FusionType f : fs) 
		{
			toFuse.clear();		
		
		//	if (f.getCRefsIndexed().isEmpty())
		//	{
				EList<String> cs = f.getCRefs();
				String pRef = f.getPRef();
				for (String cRef : cs) {
					ComponentInUseType y = mC1.get(cRef);
					if (y != null) {
						HComponent c = mC2.get(y).getExposedComponentByName(pRef);
						if (c != null && !toFuse.contains(c))
							toFuse.add(c);
					}
				}
		/*	}
			else
			{
			   EList<CRefsIndexedType> cs_ix = f.getCRefsIndexed();	
				String pRef = f.getPRef();
				for (CRefsIndexedType cRef_ix : cs_ix) {
					ComponentInUseType y = mC1.get(cRef_ix.getCRef());
					if (y != null) {
						HComponent c = mC2.get(y).getExposedComponentByName(pRef, cRef_ix.getIndexReplica());
						if (c != null && !toFuse.contains(c))
							toFuse.add(c);
					}
				}
			}
		*/	
			HComponent aux = null;
			if (toFuse.size() > 1) {
				HComponent source = toFuse.get(0);
				for (HComponent target : toFuse) {
					if (source != target) {
						if (target.isSubTypeOf(source)	&& !source.isSubTypeOf(target)) {
							aux = source;
							source = target;
							target = aux;
						}
						SupersedeCommand c = new SupersedeCommand((HComponent) source, (HComponent) target);
						if (c.canExecute()) {
							// c.execute();
							HComponent.supersede3(source,target,false);
						} else {
							aux = source;
							source = target;
							target = aux;
							SupersedeCommand c_ = new SupersedeCommand((HComponent) source, (HComponent) target);
							if (c_.canExecute())
								//c_.execute();
								HComponent.supersede3(source, target, false);
							else {
								String message = "CANNOT FUSE INNER COMPONENTS ! source = "
										+ source.getRef()
										+ " ("
										+ source.getComponentName()
										+ ") target = "
										+ target.getRef()
										+ " ("
										+ target.getComponentName()
										+ ")";
								System.err.println(message);
								JOptionPane.showMessageDialog(null, message,
										"Loading Component Error",
										JOptionPane.ERROR_MESSAGE);
								// throw new
								// HPEInvalidComponentResourceException();
							}
						}
					}
				}
			}

		}

	}

	private ComponentFactory factory = ComponentFactory.eINSTANCE;

	// Saves a HComponent object in a ComponentType object
	public ComponentType marshallComponent(HComponent c)
			throws UndefinedRefInnerException, DuplicatedRefInnerException,
			DuplicatedSliceNamesException {

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
		HComponent sC = c.isAbstractConfiguration() ? c.getSuperType() : c.getWhoItImplements();
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
		saveVisualDescription(c, v);
		xH.setVisualAttributes(v);

		saveVersions(c, xH.getVersions());
		saveFacetConfiguration(c,xH.getFacetConfiguration());

	}

	private void saveFacetConfiguration(HComponent c, EList<FacetConfigurationType> facetConfiguration) 
	{
		
		// If the component does not have a facet configuration, they will be configured automatically from the facet attribute of units.
		if (c.getFacetConfiguration().isEmpty())
		{	
			Map<Integer,Integer> facet_list = new HashMap<Integer,Integer>();
			for (IHUnit u_ : c.getUnits())
			{
				HUnit u = (HUnit) u_;
				int facet = u.getFacet();
				facet_list.put(facet,facet);
			}
			
			for (int facet : facet_list.keySet())
				c.addFacet(facet, false);
		}
		
	    for (Entry<Integer,Boolean> facet_configuration : c.getFacetConfiguration().entrySet())
	    {
	    	FacetConfigurationType facet_configuration_x = this.factory.createFacetConfigurationType();
	    	facet_configuration_x.setFacet(facet_configuration.getKey());
	    	facet_configuration_x.setMultiple(facet_configuration.getValue());
	        facetConfiguration.add(facet_configuration_x);   
	    }		
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
		String location = baseType.getRemoteLocation() == null ? baseType
				.getRelativeLocation() : baseType.getRemoteLocation();
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
		saveUnitBounds(baseType.getUnits(), unitBounds);
	}

	private void saveInfo(HComponent c, ComponentBodyType xI)
			throws UndefinedRefInnerException, DuplicatedRefInnerException,
			DuplicatedSliceNamesException {

		supply_parameter_memory.clear();

		hidden_supplies.clear();

		saveParameters(c, xI.getParameter()); // OK !
		saveInnerComponents(c, xI.getInnerComponent()); // OK !
		saveSupplyParameters(c, xI.getSupplyParameter()); // OK !
		//saveFacetMultiplicity(c, xI.getFacetMultiplicity());

		for (Pair<InnerComponentType, ParameterSupplyType> pc : hidden_supplies) {
			xI.getInnerComponent().add(pc.fst());
			saveSupplyParameter(xI.getSupplyParameter(),pc.snd());			
		}

		hidden_supplies.clear();

		saveInnerRenamings(c, xI.getInnerRenaming());
		saveFusions(c, xI.getFusion());
		saveInterfaces(c, xI.getInterface());
		saveUnits(c, xI.getUnit());
		saveRecursiveEntries(c, xI.getRecursiveEntry());
		saveExternalLibraries(c.getExternalLibrarySet(), xI.getExternalLibrary());
	}


	private Map<String, ParameterSupplyType> supply_parameter_memory = new HashMap<String,ParameterSupplyType>();
	
	private void saveSupplyParameter(EList<ParameterSupplyType> supplyParameter, ParameterSupplyType sp) 
	{		
		if (!supply_parameter_memory.containsKey(sp.getCRef()))
		{
		    supplyParameter.add(sp);
		    supply_parameter_memory.put(sp.getCRef(), sp);
		}
	}

	private void saveExternalLibraries(
			Map<String, String[]> externalLibrarySet,
			EList<ExternalLibraryType> externalLibrary) {
		for (Entry<String, String[]> e : externalLibrarySet.entrySet()) {
			String library_name = e.getKey();
			ExternalLibraryType elt = factory.createExternalLibraryType();
			externalLibrary.add(elt);
			elt.setName(library_name);
			String source_code = null;
			source_code = this.getCurrentContents(library_name);

			elt.setContents(source_code);

			EList<String> l = elt.getExternalDependency();
			for (String external_dependency : e.getValue())
				l.add(external_dependency);
		}

	}

	private void saveInnerRenamings(HComponent c, EList<InnerRenamingType> xRs) {

		Map<HComponent, List<HComponent>> vcs = new HashMap<HComponent, List<HComponent>>();

		for (HComponent vc : c.getComponents()) {
			if (!vc.isHiddenInnerComponent()) {
				for (HComponent vc_ : vc.getExposedComponents()) {
					if (!vcs.containsKey(vc_)) {
						List<HComponent> l = new ArrayList<HComponent>();
						l.add(vc);
						vcs.put(vc_, l);
					} else {
						List<HComponent> l = vcs.get(vc_);
						l.add(vc);
					}
				}
			}
		}

		for (Entry<HComponent, List<HComponent>> vc : vcs.entrySet()) {
			List<HComponent> d1s = vc.getValue();
			HComponent d2 = vc.getKey();
			for (HComponent d1 : d1s) {
				String cRef = d1.getRef();
				String oldName = d2.getSavedName().get(d1);
				String newName = d2.getRef();
				int index_replica = d2.getIndexReplica();
				if (oldName != null && !oldName.equals(newName)) {
					InnerRenamingType ir = factory.createInnerRenamingType();
					ir.setCRef(cRef);
					ir.setCOldName(oldName);
					ir.setCNewName(newName);
					ir.setIndexReplica(index_replica);
					xRs.add(ir);
				}
			}
		}
	}

	private void saveFusions(HComponent c, EList<FusionType> xFs) 
	{
		for (Entry<String, List<HComponent>> fusion : c.getFusions().entrySet()) 
		{
			String cRef = fusion.getKey();
			List<HComponent> cList = fusion.getValue();
			FusionType f = factory.createFusionType();
			xFs.add(f);
			f.setPRef(cRef);
			EList<String> ps = f.getCRefs();
		
			for (HComponent c_ : cList) {
				for (HComponent c__ : c_.getTopParentConfigurations()) {
					ps.add(c__.getName2());
				}
			}
/*			EList<CRefsIndexedType> ps = f.getCRefsIndexed();
			
			for (HComponent c_ : cList) {
				for (HComponent c__ : c_.getTopParentConfigurations()) 
				{
					CRefsIndexedType cref_ix = factory.createCRefsIndexedType();
					cref_ix.setCRef(c__.getName2());
					cref_ix.setIndexReplica(c_.getIndexReplica());
					ps.add(cref_ix);
				}
			}
*/		}

	}

	private void saveFusionsOld(HComponent c, EList<FusionType> xFs) {

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

	private Map<String, String> cparameters = new HashMap<String, String>();

	private void saveParameters(HComponent c, EList<ParameterType> xI) {

		List<HComponent> cs = new ArrayList<HComponent>();

		cs.addAll(c.getComponents());
		for (Pair<String, HComponent> p : c.getSupplierComponents())
			cs.add(p.snd());

		int max_order = 0;

		List<Pair<String, ParameterType>> unordered_parameters = new ArrayList<Pair<String, ParameterType>>();
		for (HComponent ic : cs) {

			if (ic.isParameter() && ic.getSupplier() == null) {
				String par_id = null;
				String cRef = null;
				String varName = null;

				// SETUP VARIABLES

				par_id = ic.getParameterIdentifier(c);
				cRef = ic.getRef();
				varName = ic.getVariableName(c);

				// ---------------

				ParameterType p = factory.createParameterType();
				p.setFormFieldId(par_id);
				p.setComponentRef(cRef);
				p.setVarName(varName);
				p.setVariance(component.getParameterVariance(par_id));

				cparameters.put(varName, cRef);

				// parameters must be saved with an order.
				int order = component.getParameterOrder(par_id);
				if (order < 0)
					unordered_parameters.add(new Pair<String, ParameterType>(
							par_id, p));
				else {
					p.setOrder(order);
					max_order = order > max_order ? order : max_order;
				}

				xI.add(p);
			}
		}

		// if ordered parameters are 0,1,2,..., N, the unordered are N+1,N+2,
		// and so on.
		for (Pair<String, ParameterType> p : unordered_parameters) {
			int order = max_order++;
			component.setParameterOrder(p.fst(), order);
			p.snd().setOrder(order);
		}

	}

	private void saveInnerComponents(HComponent c, EList<InnerComponentType> xI)
			throws UndefinedRefInnerException, DuplicatedRefInnerException {

		List<HComponent> cs = new ArrayList<HComponent>();
		int i = 0;

		List<String> cRefs = new ArrayList<String>();
		List<String> cRefsSupply = new ArrayList<String>();
		Map<HComponent, String> newRefMap = new HashMap<HComponent, String>();

		for (HComponent cInner : c.getComponents()) {
			cs.add(cInner);
			newRefMap.put(cInner, cInner.getRef());
			String cRef = cInner.getRef();
			if (cRefs.contains(cRef)) {
				throw new DuplicatedRefInnerException(cRef);
			} else {
				cRefs.add(cRef);
			}
		}

		for (Pair<String, HComponent> p : c.getSupplierComponents())
		/* if (!c.isTransitiveSupplier(p.getKey())) */
		{
			String cRef = p.snd().getRef();
			cRef = c.isTransitiveSupplier(p.fst()) ? "T###" + cRef + p.snd().hashCode() : cRef;
			if (!(cRefsSupply.contains(cRef) && cRef.startsWith("T###"))) 
			{
				if (cRefsSupply.contains(cRef)) 
				{
					throw new DuplicatedRefInnerException(cRef);
				} 
				else 
				{
					if (!cRefs.contains(cRef)) 
					{
						cs.add(i++, p.snd());
						newRefMap.put(p.snd(), cRef);
						cRefs.add(cRef);
						cRefsSupply.add(cRef);
					}
				}
			}
		}

		/*
		 * if (c.isAbstract()) { for (HReplicator r : c.gettReplicators()) { for
		 * (HReplicatorSplit lr : r.getSplits()) { HEnumeratorComponent ec =
		 * lr.getPermutation(); if (ec != null && !cs.contains(ec)) { cs.add(0,
		 * ec); String cRef = ec.getRef(); if (cRefs.contains(cRef)) { throw new
		 * DuplicatedRefInnerException(cRef); } else { cRefs.add(cRef); } } } }
		 * }
		 */
		for (HComponent ic : cs) 
		{
			if (!ic.isDerivedFromPermutation() && ic != c.getSuperType() && ic != c.getWhoItImplements()) 
			{
				InnerComponentType d = factory.createInnerComponentType();

				String oldRef = ic.getRef();
				String newRef = newRefMap.get(ic);
				ic.setName(newRef);
				saveInnerComponent(ic, d);
				ic.setName(oldRef);

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

	private void saveInnerComponent(HComponent ic, InnerComponentType d)
			throws UndefinedRefInnerException {

		VisualElementAttributes v = factory.createVisualElementAttributes();
		String name = ic.getComponentName();
		String localRef = ic.getRef();

		String location = ic.getRemoteLocation() == null ? ic.getRelativeLocation() : ic.getRemoteLocation();
		String package_ = ic.getPackagePath().toString();
		boolean exposed = ic.isPublic();
		boolean isMultiple = ic.isMultiple();
		// String hash_component_UID = ic.getHashComponentUID();

		String parameterId = ic.getParameterIdentifier(this.component);

		if (localRef.equals(HComponent.UNDEFINED_NAME)) {
			throw new UndefinedRefInnerException(ic);
		}

		d.setLocalRef(localRef);
		d.setLocation(location);
		d.setPackage(package_);
		d.setName(name);
		// d.setVersion(version);
		d.setExposed(exposed);
		d.setMultiple(isMultiple);
		// d.setHashComponentUID(hash_component_UID);
		d.setVisualDescription(v);
		if (!parameterId.equals("type ?"))
			d.setParameterId(parameterId);

		EList<ParameterRenaming> parameterRenaming = d.getParameter();
		EList<UnitBoundsType> unitBounds = d.getUnitBounds();
		// EList<PortType> ports = d.getPort();
		EList<InnerComponentType> ports = d.getPort();

		saveParameterRenamings(ic, parameterRenaming); // OK !
		savePorts(ic, ports);
		saveUnitBounds(ic.getUnits(), unitBounds);
		saveVisualDescription(ic, v);

	}

	private void savePorts(HComponent ic, EList<InnerComponentType> ports)
			throws UndefinedRefInnerException {

		for (HComponent c : ic.getExposedComponents()) {
			InnerComponentType port = factory.createInnerComponentType();
			HComponent c_ = c.getSupplier() != null ? c.getSupplier() : c;
			c_.setExposed(c.isPublic());

			saveInnerComponent(c_, port);

			String pRef = c.getSavedName().get(ic);
			port.setLocalRef(pRef != null ? pRef : c.getRef());
			port.setIndexReplica(c.getIndexReplica());

			ports.add(port);
		}

	}

	private void saveUnitBounds(List<IHUnit> units,	EList<UnitBoundsType> unitBounds) {

		for (IHUnit u_ : units) 
		{
			for (IHPrimUnit u : u_.getClones()) 
			// if (((IHUnit) u).getFacetInstance() == 0)
			{				
				Integer slice_replica = null;

				if (u.isClone()) {
					slice_replica = u.cloneOf().getIndexOfClone(u);
				} else if (u.isCloned()) {
					slice_replica = 0;
				}

				UnitBoundsType b = factory.createUnitBoundsType();
				VisualElementAttributes v = factory.createVisualElementAttributes();

				b.setURef(u instanceof HUnitStub ? ((HUnitStub) u).getOriginalName() : u.getName2());
				b.setParallel(((IHUnit) u).isMultiple());
				b.setFacet(u.getFacet());
				b.setFacetInstance(u.getFacetInstance());				
				if (u.getBinding() != null)
					if (u.getBinding().getPort() instanceof HUnitSlice)
						b.setFacetInstanceEnclosing(((HUnitSlice)u.getBinding().getPort()).getUnit().getFacet());
					else
						b.setFacetInstanceEnclosing(((IHUnit)u.getBinding().getPort()).getFacet());
				
				if (slice_replica != null) {
					int unit_replica = u.getUnitReplicaIndex();
					b.setSliceReplica(slice_replica);
					b.setUnitReplica(unit_replica);
				}

				b.setVisualDescription(v);
				saveVisualDescription(u, v);

				unitBounds.add(b);
			}
		}

	}

	private void saveRecursiveEntries(HComponent component,
			EList<RecursiveEntryType> xI) {

		for (HComponent c : component.getComponents()) {
			if (c.isRecursive()) {
				RecursiveEntryType r = factory.createRecursiveEntryType();
				r.setCRef(c.getName2());
				xI.add(r);
			}
		}
	}

	private List<Pair<InnerComponentType, ParameterSupplyType>> hidden_supplies = new ArrayList<Pair<InnerComponentType, ParameterSupplyType>>();

	private void saveParameterRenamings(HComponent c,
			EList<ParameterRenaming> parameterRenamings)
			throws UndefinedRefInnerException 
	{
		for (Entry<String, List<HComponent>> param : c.getParameters().entrySet()) 
		{
			String formField = param.getKey();
			String varName = null;

			// SETUP VARIABLES: look for the current variable name of the
			// parameter in the configuration

			HComponent cc = param.getValue().get(0);
			// if (cc.getSupplier() == null && cc.getWhoISupply().isEmpty())
			{
				varName = cc.getVariableName(component);
				
				if (varName.equals("?")) 
				{
					InnerComponentType par_port = factory.createInnerComponentType();
					String cRefSave = cc.getRef();
					String cRefNew = "C###" + par_port.hashCode();
					cc.setName(cRefNew);
					saveInnerComponent(cc, par_port);
					cc.setName(cRefSave);
					varName = varName.equals("?") ? "X###" + par_port.hashCode() : varName;

					ParameterSupplyType s = factory.createParameterSupplyType();
					s.setCRef(cRefNew);
					s.setVarName(varName);

					hidden_supplies.add(new Pair<InnerComponentType, ParameterSupplyType>(par_port, s));
				}
				// varName =
				// cc.getVariableName(c.getTopParentConfigurations().get(0));

				if (varName.indexOf('@') >= 0)
					varName = varName.substring(0, varName.indexOf('@'));
				formField = cc.getParameterIdentifier(c).equals("type ?") ? cc.getParameterIdentifier(cc) : cc.getParameterIdentifier(c);

				// ---------------

				if (!formField.equals("type ?")) 
				{
					
					ParameterRenaming r = factory.createParameterRenaming();

					r.setFormFieldId(formField);
					r.setVarName(varName);

					parameterRenamings.add(r);
				}
			}
		}

	}

	private void saveInterfaces(HComponent c, EList<InterfaceType> xI)
			throws DuplicatedSliceNamesException {

		for (HInterface i : c.getInterfaces())
			if (i.getConfiguration() == c) { // Only interfaces of the top
				// configuration

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
					// if (ia.getProtocol() != null) {
					// a = saveAction((HAction) ia.getProtocol().getAction());
					// }
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
				if (i instanceof HActivateInterface) {
					HActivateInterface ia = (HActivateInterface) i;
					saveActions(ia.getActions(), iX.getAction());
					saveConditions(ia.getConditions(), iX.getCondition());
				}

				saveVisualDescription(i, v);

				List<String> externalRefs = iX.getExternalReferences();
				for (String eRef : i.getExternalReferences()) {
					externalRefs.add(eRef);
				}

				xI.add(iX);
			}

	}

	private void saveConditions(
			Map<String, hPE.frontend.connector.xml.component.GuardType> conditions,
			EList<UnitConditionType> condition_list_X) {
		for (Entry<String, hPE.frontend.connector.xml.component.GuardType> condition : conditions
				.entrySet()) {
			UnitConditionType conditionX = factory.createUnitConditionType();
			conditionX.setId(condition.getKey());
			conditionX.setGuard(saveGuard(condition.getValue()));
			condition_list_X.add(conditionX);
		}

	}

	private void saveActions(Map<String, HProtocolChoice> actions,
			EList<UnitActionType> action_list) {
		for (Entry<String, HProtocolChoice> action : actions.entrySet()) {

			hPE.frontend.connector.xml.component.ProtocolChoiceType protocol_choice = action
					.getValue();
			ProtocolChoiceType protocol_choice_X = factory
					.createProtocolChoiceType();

			saveProtocolChoice(protocol_choice, protocol_choice_X);

			UnitActionType actionX = factory.createUnitActionType();
			actionX.setId(action.getKey());
			actionX.setProtocol(protocol_choice_X);

			action_list.add(actionX);
		}

	}

	private void saveProtocolChoice(
			hPE.frontend.connector.xml.component.ProtocolChoiceType protocol_choice,
			ProtocolChoiceType protocol_choice_X) {
		if (protocol_choice.getPar() != null) {
			hPE.frontend.connector.xml.component.ProtocolCombinatorType protocol_combinator = protocol_choice.getPar();
			protocol_choice_X.setPar(saveProtocolCombinator(protocol_combinator));
		} else if (protocol_choice.getSeq() != null) {
			hPE.frontend.connector.xml.component.ProtocolCombinatorType protocol_combinator = protocol_choice.getSeq();
			protocol_choice_X.setSeq(saveProtocolCombinator(protocol_combinator));
		} else if (protocol_choice.getAlt() != null) {
			hPE.frontend.connector.xml.component.ProtocolCombinatorType protocol_combinator = protocol_choice.getAlt();
			protocol_choice_X.setAlt(saveProtocolCombinator(protocol_combinator));
		} else if (protocol_choice.getPerform() != null) {
			hPE.frontend.connector.xml.component.ProtocolPerformType protocol_perform = protocol_choice.getPerform();
			protocol_choice_X.setPerform(saveProtocolPerform(protocol_perform));
		}

	}

	private ProtocolPerformVisualType saveProtocolPerform(
			hPE.frontend.connector.xml.component.ProtocolPerformType protocol_perform) {

		ProtocolPerformVisualType protocol_perform_x = factory
				.createProtocolPerformVisualType();
		protocol_perform_x.setRepeat(protocol_perform.isRepeat());
		protocol_perform_x.setSliceId(protocol_perform.getSliceId());
		protocol_perform_x.setId(protocol_perform.getId());
		protocol_perform_x.setActionId(protocol_perform.getActionId());
		if (protocol_perform.getGuard() != null)
			protocol_perform_x.setGuard(saveGuard(protocol_perform.getGuard()));

		VisualElementAttributes v = factory.createVisualElementAttributes();
		saveVisualDescription(protocol_perform, v);
		protocol_perform_x.setVisualDescription(v);

		return protocol_perform_x;
	}

	private GuardType saveGuard(
			hPE.frontend.connector.xml.component.GuardType guard) {
		GuardType guardX = factory.createGuardType();
		guardX.setNot(guard.isSetNot() ? guard.isNot() : false);
		saveGuardAnd(guardX.getAnd(), guard.getAnd());
		saveGuardOr(guardX.getOr(), guard.getOr());

		EList<ConditionType> condition_list_X = guardX.getCondition();
		EList<hPE.frontend.connector.xml.component.ConditionType> condition_list = guard
				.getCondition();
		saveGuardCondition(condition_list_X, condition_list);

		return guardX;
	}

	private void saveGuardCondition(
			EList<ConditionType> condition_list_X,
			EList<hPE.frontend.connector.xml.component.ConditionType> condition_list) {

		for (hPE.frontend.connector.xml.component.ConditionType condition : condition_list) {
			ConditionType conditionX = factory.createConditionType();
			conditionX.setCondId(condition.getCondId());
			conditionX.setSliceId(condition.getSliceId());
			condition_list_X.add(conditionX);
		}

	}

	private void saveGuardOr(EList<GuardType> or_guard_list_X,
			EList<hPE.frontend.connector.xml.component.GuardType> or_guard_list) {
		for (hPE.frontend.connector.xml.component.GuardType or_guard : or_guard_list) {
			GuardType or_guard_X = factory.createGuardType();
			or_guard_X.setNot(or_guard.isSetNot() ? or_guard.isNot() : false);
			saveGuardAnd(or_guard_X.getAnd(), or_guard.getAnd());
			saveGuardOr(or_guard_X.getOr(), or_guard.getOr());
			or_guard_list_X.add(or_guard_X);
		}

	}

	private void saveGuardAnd(EList<GuardType> and_guard_list_X,
			EList<hPE.frontend.connector.xml.component.GuardType> and_guard_list) {
		for (hPE.frontend.connector.xml.component.GuardType and_guard : and_guard_list) {
			GuardType and_guard_X = factory.createGuardType();
			and_guard_X
					.setNot(and_guard.isSetNot() ? and_guard.isNot() : false);
			saveGuardAnd(and_guard_X.getAnd(), and_guard.getAnd());
			saveGuardOr(and_guard_X.getOr(), and_guard.getOr());
			and_guard_list_X.add(and_guard_X);
		}

	}

	private ProtocolCombinatorVisualType saveProtocolCombinator(
			hPE.frontend.connector.xml.component.ProtocolCombinatorType protocol_combinator) {
		ProtocolCombinatorVisualType protocol_combinator_x = factory
				.createProtocolCombinatorVisualType();
		protocol_combinator_x.setId(protocol_combinator.getId());
		protocol_combinator_x.setRepeat(protocol_combinator.isRepeat());
		if (protocol_combinator.getGuard() != null)
			protocol_combinator_x.setGuard(saveGuard(protocol_combinator
					.getGuard()));

		List<hPE.frontend.connector.xml.component.ProtocolChoiceType> protocol_list = protocol_combinator
				.getAction();
		hPE.frontend.connector.xml.component.ProtocolChoiceType[] protocols = new hPE.frontend.connector.xml.component.ProtocolChoiceType[protocol_list
				.size()];
		for (hPE.frontend.connector.xml.component.ProtocolChoiceType action_protocol_choice : protocol_list) {
			HProtocolChoice action_protocol_choice_ = (HProtocolChoice) action_protocol_choice;
			IProtocol action_protocol = action_protocol_choice_.getProtocol();
			protocols[action_protocol.getOrder()] = action_protocol_choice;
		}

		for (int i = 0; i < protocols.length; i++) {
			hPE.frontend.connector.xml.component.ProtocolChoiceType protocol_choice = protocols[i];
			ProtocolChoiceType protocol_choice_X = factory
					.createProtocolChoiceType();
			saveProtocolChoice(protocol_choice, protocol_choice_X);
			protocol_combinator_x.getAction().add(protocol_choice_X);
		}

		VisualElementAttributes v = factory.createVisualElementAttributes();
		saveVisualDescription(protocol_combinator, v);
		protocol_combinator_x.setVisualDescription(v);

		return protocol_combinator_x;

	}

	private void saveParameters(
			List<Triple<String, HInterface, String>> parameters,
			EList<InterfaceParameterType> parametersX) 
	{
		Map<String, Integer> m = new HashMap<String, Integer>();

		Map<Integer, InterfaceParameterType> parameter_order = new HashMap<Integer, InterfaceParameterType>();
		int max_order = 0;

		for (Triple<String, HInterface, String> parameter : parameters) 
		{
			String par_id = parameter.trd();
			VarianceType variance_type = this.component.getParameterVariance(par_id);
			if (!m.containsKey(par_id) && (this.component.isAbstract() || variance_type.equals(VarianceType.CONTRAVARIANT))) 
			{
				InterfaceParameterType parX = factory.createInterfaceParameterType();
				parX.setParid(par_id);
				parX.setVarid(parameter.fst());
				parX.setIname(parameter.snd().getPrimName());
				parX.setUname(parameter.snd().getCompliantUnits().get(0).getName2());

				int order = component.getParameterOrder(par_id);
				if (order >= 0) {
					parameter_order.put(order, parX); // record parameter global orders
					max_order = order > max_order ? order : max_order;
				}
				// else
				// Assert.isTrue(order >= 0);
				parametersX.add(parX);
				m.put(parX.getParid(), parX.getOrder());
			}
		}

		// Calculate parameter order in interface.

		int size = max_order + 1;
		InterfaceParameterType[] pars = new InterfaceParameterType[size];
		for (Entry<Integer, InterfaceParameterType> p_order : parameter_order.entrySet())
			pars[p_order.getKey()] = p_order.getValue();

		int count = 0;
		for (int i = 0; i < size; i++) {
			if (pars[i] != null)
				pars[i].setOrder(count++);
		}
	}

	private void saveInterfacePorts(List<HPort> ports,
			EList<InterfacePortType> portsX) {

		for (HPort p : ports) {
			InterfacePortType portX = factory.createInterfacePortType();
			VisualElementAttributes v = factory.createVisualElementAttributes();
			List<PortSliceType> portSliceL = portX.getSlice();

			int count = 0;
			for (HInterfaceSlice sOwner : p.getOwners())
				if (!sOwner.isInherited()) {
					count++;
					String sRef = sOwner.getName();
					String pRef = p.getDefaultNameOf(sOwner);

					PortSliceType pst = factory.createPortSliceType();
					pst.setPRef(pRef);
					pst.setSRef(sRef);
					portSliceL.add(pst);
				}

			if (count > 0) {
				String pname = p.getName();
				portX.setName(pname);
				portX.setVisualDescription(v);
				saveVisualDescription(p, v);
				portsX.add(portX);
			}
		}

	}

	/*
	 * private ActionType saveAction(HAction action) {
	 * 
	 * ActionType actionX = null; /* TODO (action): if (action instanceof
	 * HCombinatorAction) {
	 * 
	 * if (action instanceof HParAction) { actionX =
	 * factory.createActionCombinatorParType();
	 * 
	 * } else if (action instanceof HSeqAction) { actionX =
	 * factory.createActionCombinatorSeqType();
	 * 
	 * } else if (action instanceof HAltAction) { actionX =
	 * factory.createActionCombinatorAltType(); }
	 * 
	 * EList<ActionType> innerActionsX = ((ActionCombinatorType) actionX)
	 * .getAction();
	 * 
	 * HCombinatorAction combinatorAction = (HCombinatorAction) action;
	 * 
	 * for (HAction a : combinatorAction.getActions()) {
	 * innerActionsX.add(saveAction(a)); }
	 * 
	 * } else if (action instanceof HPrimitiveAction) { if (action instanceof
	 * HDoAction) { actionX = factory.createActionActivateType();
	 * ActionActivateType actionXX = (ActionActivateType) actionX;
	 * IInterfaceSlice s = ((HDoAction) action).getSliceAbstraction(); if (s !=
	 * null) actionXX.setSliceRef(s.getName()); } else if (action instanceof
	 * HWaitAction) { actionX = factory.createActionWaitType(); ActionWaitType
	 * actionXX = (ActionWaitType) actionX; actionXX.setSemaphore(((HWaitAction)
	 * action).getSemaphore() .getName()); } else if (action instanceof
	 * HSignalAction) { actionX = factory.createActionSignalType();
	 * ActionSignalType actionXX = (ActionSignalType) actionX;
	 * actionXX.setSemaphore(((HSignalAction) action).getSemaphore()
	 * .getName()); } else if (action instanceof HSkipAction) { actionX =
	 * factory.createActionSkipType(); ActionSkipType actionXX =
	 * (ActionSkipType) actionX; } }
	 * 
	 * VisualElementAttributes vX = factory.createVisualElementAttributes();
	 * saveVisualDescription(action, vX);
	 * 
	 * return actionX; }
	 */

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

	public String getCurrentContents(String libraryName) {
		String return_contents = null;

		IPath rootPath = new Path(this.component.getRelativeLocation());
		IPath path = rootPath.removeLastSegments(1).append("src")
				.append(libraryName);

		java.io.File file = HComponentFactoryImpl.getFileInWorkspace(path);

		StringBuffer s = new StringBuffer();

		try {
			FileInputStream contents = new FileInputStream(file);
			if (contents != null) {
				Reader reader = new InputStreamReader(contents);
				char[] readBuffer = new char[2048];
				int n = reader.read(readBuffer);
				while (n > 0) {
					s.append(readBuffer, 0, n);
					n = reader.read(readBuffer);
				}

				return_contents = s.toString();

			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Error Reading File Contents - ".concat(e.getMessage()),
					"Error", JOptionPane.ERROR_MESSAGE);
		}

		return return_contents;

	}

	private void saveSources(Collection<HBESourceVersion> sources, EList<SourceType> sourcesX) 
	{
		for (HBESourceVersion src : sources) 
		{
			SourceType s = factory.createSourceType();

			List<SourceFileType> fsX = s.getFile();

			for (HBEAbstractSourceCodeFile f : src.getFiles()) 
			{
				SourceFileType fX = factory.createSourceFileType();
				String uri = f.getBinaryPath().toString();
				String versionIdF = f.getVersionID();
				String srcType = f.getSrcType();
				fX.setUri(uri);
				fX.setName(f.getFileName());
				fX.setContents(f.getCurrentContents());
				fX.setVersionId(versionIdF != null && checkVersion(versionIdF) ? versionIdF : "1.0.0.0");
				if (srcType != null)
					fX.setSrcType(srcType);
				List<String> deps = fX.getDependency();
				deps.addAll(f.getDependencies());
				List<String> edeps = fX.getExternalDependency();
				edeps.addAll(f.getExternalReferences());
				fsX.add(fX);
			}

			String version = src.getVersionID();
			String srcType = src.getFileType();

			s.setSourceType(srcType);
			s.setVersionId(version != null && checkVersion(version) ? version : "1.0.0.0");

			if (!s.getFile().isEmpty())
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
			EList<InterfaceSliceType> slicesX)
			throws DuplicatedSliceNamesException {

		Map<String, HInterfaceSlice> savedSlices = new HashMap<String, HInterfaceSlice>();

		for (HInterfaceSlice slice : slices)
			if (!savedSlices.containsKey(slice.getName())) {
				if (!slice.isInherited()) {

					savedSlices.put(slice.getName(), slice);

					InterfaceSliceType sliceX = factory
							.createInterfaceSliceType();
					VisualElementAttributes v = factory
							.createVisualElementAttributes();

					String sRef = null;
					String cORef = null;
					String iORef = null;

					// SETUP VARIABLES

					cORef = slice.getInterface().getConfiguration().getRef();
					sRef = cORef; // slice.getName();
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
			} else
				throw new DuplicatedSliceNamesException(slice);
	}

	private void saveUnits(HComponent c, EList<UnitType> xI) throws DuplicatedSliceNamesException {

		Map<String, List<HUnitSlice>> slice_replica = new HashMap<String, List<HUnitSlice>>();

		for (IHUnit u_ : c.getUnits()) 
		{
			String uRef = null;
			String iRef = null;
			boolean isPrivate = false;
			boolean isMultiple = false;
			boolean isSubUnit = false;
			boolean visibleInterface = true;
			int index;
			int facet;
			String[] cRefSuper = null;
			String[] uRefSuper = null;
			Integer replica = null;

			for (IHPrimUnit u__ : u_.getClones()) 
			{
				UnitType uX = factory.createUnitType();
				VisualElementAttributes v = factory.createVisualElementAttributes();

				HUnit u = (HUnit) u__;

				isSubUnit = u.hasStubs();
				isPrivate = u.getHidden();
				isMultiple = u.isMultiple();
				index = u.getSliceReplicaIndex();
				facet = u.getFacet();
				visibleInterface = u.visibleInterface();
				uRef = u.getName2();
				HInterface i = (HInterface) u.getInterface();

				iRef = i != null ? i.getPrimName() : null;
				if (isSubUnit) 
				{
					List<HUnitStub> stubU_list = u.getMostRecentStub();
					cRefSuper = new String[stubU_list.size()];
					uRefSuper = new String[stubU_list.size()];
					int j = 0;
					for (HUnitStub stubU : stubU_list)
					{	
					  cRefSuper[j] = ((HComponent) stubU.getConfiguration()).getRef();
					  uRefSuper[j] = stubU.getOriginalName();
					  j++;
					}
				}

				// ---------------

				uX.setURef(uRef);
				uX.setIRef(iRef);
				uX.setPrivate(isPrivate);
				uX.setMultiple(isMultiple);
				uX.setVisibleInterface(visibleInterface);
				uX.setVisualDescription(v);
				uX.setReplica(index);
				uX.setFacet(facet);

				if (isSubUnit) 
				{
					EList<UnitRefType> superUnit_list = uX.getSuper();
					int j=0;
					for (j=0; j<cRefSuper.length; j++)
					{
						UnitRefType superUnit = factory.createUnitRefType();
						superUnit.setCRef(cRefSuper[j]);
						superUnit.setURef(uRefSuper[j]);
						if (replica != null)  // essa comparação não leva a nada.
							superUnit.setSliceReplica(replica);						
						superUnit_list.add(superUnit);
					}
				}
				saveVisualDescription(u, v);

				EList<UnitSliceType> slicesX = uX.getSlices();
				List<HUnitSlice> transitiveSlices = new ArrayList<HUnitSlice>();
				List<HUnitSlice> directSlices = new ArrayList<HUnitSlice>();
				List<List<HUnitSlice>> ports_list = u.getPorts();
				List<HUnitSlice> slices = u.getSlices();
				for (List<HUnitSlice> ports : ports_list)
					transitiveSlices.addAll(ports);
				for (HUnitSlice usx : slices) 
				{
					if (!transitiveSlices.contains(usx))
						transitiveSlices.add(usx);
				}
				directSlices.addAll(slices);
				saveUnitSlices(directSlices, transitiveSlices, slicesX,	slice_replica);

				xI.add(uX);
			}

		}

	}

	private void saveUnitSlices(List<HUnitSlice> directSlices,
			List<HUnitSlice> transitiveSlices, EList<UnitSliceType> slicesX,
			Map<String, List<HUnitSlice>> slice_replica)
			throws DuplicatedSliceNamesException {

		Map<String, HUnitSlice> savedSlices = new HashMap<String, HUnitSlice>();

		Map<String, String> portNames = new HashMap<String, String>();
		for (HUnitSlice slice : transitiveSlices) 
		{
			if (slice.getBinding().getConfiguration() == this.component) 
			{
				HUnit uSource = (HUnit) slice.getComponentEntry();
				List<List<HUnitSlice>> usPorts_list = uSource.getPorts();
				for (List<HUnitSlice> usPorts : usPorts_list)
				{
					for (HUnitSlice usPort : usPorts) 
					{
						HUnit usPortSource = (HUnit) usPort.getComponentEntry();
						String usPortName = usPort.getConfiguration().getRef();
						portNames.put(usPortName, usPortName);
					}
				}
			}
		}

		for (HUnitSlice slice : transitiveSlices)
			if (slice.getBinding().getConfiguration() == this.component	|| (portNames.containsKey(slice.getName()))) 
			{
				if (savedSlices.containsKey(slice.getName())) {
					// throw new DuplicatedSliceNamesException(slice);
				}

				// if (!savedSlices.containsKey(slice.getName())) {
				savedSlices.put(slice.getName(), slice);

				// if (!slice.getHiddenSlice()) {
				/*
				 * Essa linha foi acrescentada devido a problema com fatias de
				 * unidades herdadas de subtyping ...
				 */

				IHUnit e = slice.getBinding().getEntry();

				UnitSliceType sliceX = factory.createUnitSliceType();
				VisualElementAttributes v = factory.createVisualElementAttributes();
				List<String> portsX = sliceX.getPort();

				String cRef = null;
				String uRef = null;
				int replica = 0;
				String sName = null;

				HUnit uSource = (HUnit) slice.getComponentEntry();

				cRef = uSource.getConfiguration().getRef();
				uRef = uSource.getName2();
				replica = uSource.getSliceReplicaIndex();

				sName = slice.getName();

				sliceX.setSliceReplica(replica);

				// ---------------

				sliceX.setCRef(cRef);
				sliceX.setURef(uRef);
				sliceX.setSliceName(sName);
				sliceX.setVisualDescription(v);
				sliceX.setTransitive(!directSlices.contains(slice));

				int inner_replica = fetch_inner_replica(sliceX, slice, slice_replica);
				sliceX.setInnerReplica(inner_replica);

				List<List<HUnitSlice>> usPorts_list = uSource.getPorts();
				for (List<HUnitSlice> usPorts : usPorts_list)
				{
					for (HUnitSlice usPort : usPorts) {
						String usPortName = usPort.getConfiguration().getRef();
						portsX.add(usPortName);
					}
				}

				saveVisualDescription(slice, v);

				slicesX.add(sliceX);
			}
	}

	private int fetch_inner_replica(UnitSliceType sliceX, HUnitSlice slice,
			Map<String, List<HUnitSlice>> slice_info) {
		String cRef = sliceX.getCRef();
		String uRef = sliceX.getURef();
		int slice_replica = sliceX.getSliceReplica();

		String key = cRef + "." + uRef + "[" + slice_replica + "]";

		List<HUnitSlice> unit_slice_list = null;
		if (slice_info.containsKey(key)) {
			unit_slice_list = slice_info.get(key);
		} else {
			unit_slice_list = new ArrayList<HUnitSlice>();
			slice_info.put(key, unit_slice_list);
		}

		unit_slice_list.add(slice);

		return unit_slice_list.size() - 1;
	}

	private void saveSupplyParameters(HComponent c, EList<ParameterSupplyType> xI) 
	{
		for (Pair<String, HComponent> pair : c.getSupplierComponents()) 
		{
			ParameterSupplyType s = factory.createParameterSupplyType();
			String cRef = null;
			String varName = null;

			// SETUP VARIABLES

			HComponent supplier = pair.snd();

			varName = pair.fst();
			cRef = supplier.getRef();

			// ---------------

			cRef = c.isTransitiveSupplier(pair.fst()) ? "T###" + cRef + supplier.hashCode() : cRef;
			s.setCRef(cRef);
			s.setVarName(varName);
			s.setDirect(!c.isTransitiveSupplier(pair.fst()));

			saveSupplyParameter(xI,s);
		}

	}

	private HUnit lookForSuperUnit(UnitRefType xUsuper) throws HPEInvalidComponentResourceException 
	{
		HUnit u = null;
		String cNameSuper = xUsuper.getCRef();
		String uNameSuper = xUsuper.getURef();
		HComponent cSuper = component.getSuperType(); // mC2.get(mC1.get(cNameSuper));
		if (cSuper == null) 
		{
			String message = "IHUnit " + uNameSuper + " not found in " + cNameSuper;
			System.err.println(message);
			JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
		} 
		else 
		{
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
		HComponent cSuper = component.getWhoItImplements();
		if (cSuper == null) 
		{
			String message = "IHUnit " + uNameSuper + " not found in "	+ cNameSuper;
			System.err.println(message);
			JOptionPane.showMessageDialog(null, message, "Loading Component Error", JOptionPane.ERROR_MESSAGE);
		} 
		else 
		{
			IHUnit u_ = cSuper.fetchUnit(uNameSuper);
			u = (HUnit) u_.getTopUnit(null);
		}
		return u;
	}

	private void loadSlices(UnitType xU, HUnit u)
			throws HPEInvalidComponentResourceException {

		Map<String, String> check = new HashMap<String, String>();

		for (HUnitSlice us : u.getSlices()) {
			// if (!(us instanceof HEnumeratorUnitSlice)) {
			HComponent cSlice = (HComponent) us.getConfiguration();
			HUnit uSlice = (HUnit) us.getComponentEntry();
			String key = uSlice.getName2() + cSlice.getRef();
			check.put(key, key);
			// }
		}
		for (UnitSliceType uSliceX : xU.getSlices()) {
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
						// if (!(c1 instanceof HEnumeratorComponent)) {
						IHUnit u1 = null;
						// if (uSliceX.isSetSliceReplica() &&
						// uSliceX.getSliceReplica() > 0) {
						// Integer replica = uSliceX.getSliceReplica();
						// int iReplica = replica.intValue();
						// u1 = c1.fetchUnit(uRef, iReplica);
						// } else {
						// u1 = c1.fetchUnit(uRef);
						// }
						if (uSliceX.isSetSliceReplica()) {
							Integer slice_replica_index = !uSliceX
									.isSetReplica() ? uSliceX.getSliceReplica()
									: uSliceX.getReplica();
							// String unit_slice_ref = this.mkUnitSliceRef(cRef,
							// uRef, slice_replica_index);
							// int unit_replica_index =
							// this.unitSliceIndexMapping.containsKey(unit_slice_ref)
							// ? this.unitSliceIndexMapping.get(unit_slice_ref)
							// : slice_replica_index;
							u1 = c1.fetchUnit(uRef, slice_replica_index);
						} else {
							u1 = c1.fetchUnit(uRef);
						}

						if (u1 == null) {
							System.err
									.println("HComponentFactoryImpl.loadSlices(): IHUnit "
											+ uRef + " not found in " + cRef);
							JOptionPane.showMessageDialog(null,
									"HComponentFactoryImpl.loadSlices(): IHUnit "
											+ uRef + " not found in " + cRef,
									"Loading Component Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							// try {
							BindingCreateCommand comm = new BindingCreateCommand(
									u1);
							comm.setUnit(u);
							comm.setWhere(new Point(x, y));
							comm.execute();
							HUnitSlice uSlice = (HUnitSlice) comm
									.getBindingTarget();
							// HUnitSlice uSlice = (HUnitSlice)
							// component.createBinding(u1, u, new Point(x,y));
							uSlice.setBounds(new Rectangle(x, y, w, h));
							// if (sName != null)
							// uSlice.setName(sName);
							/*
							 * } catch (HPEAbortException e) { System.err
							 * .println(
							 * "HComponentFactoryImpl.loadSlices(): Error creating binding (source = "
							 * + u1.getName2() + " target = " + u.getName2());
							 * JOptionPane.showMessageDialog(null,
							 * "HComponentFactoryImpl.loadSlices(): Error creating binding (source = "
							 * + u1.getName2() + " target = " + u.getName2(),
							 * "Loading Component Error",
							 * JOptionPane.ERROR_MESSAGE); }
							 */
						}
						// }
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

	private void loadInterface(UnitType xU, HUnit u, boolean isTop,	boolean isImplementing)	throws HPEInvalidComponentResourceException, HPEAbortException 
	{
		String iName = xU.getIRef();
		InterfaceType xI = mI1.get(iName);
		HInterface i = null;
		EList<UnitRefType> xUsuper_list = xU.getSuper();

		if (xI != null) 
		{
			if (xUsuper_list.size()!=1) // The interface is not inherited from the super unit 
			{ 
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

				for (UnitActionType unit_action : xI.getAction()) {
					HProtocolChoice protocol_choice = loadProtocolChoice(
							unit_action.getProtocol(), ia, unit_action.getId(),
							null, -1);
					ia.newAction(unit_action.getId(), protocol_choice);
				}

				for (UnitConditionType unit_condition : xI.getCondition()) {
					hPE.frontend.connector.xml.component.GuardType guard = loadGuard(unit_condition
							.getGuard());
					ia.addCondition(unit_condition.getId(), guard);
				}

			}
			
			if (xU.isVisibleInterface())
				u.showInterface();
			else
				u.hideInterface();

		}

	}

	private HProtocolChoice loadProtocolChoice(
			ProtocolChoiceType protocol_choice_source, HActivateInterface i,
			String actionName, IProtocolCombinator parent_combinator, int order) {
		HProtocolChoice protocol_choice_target = new HProtocolChoice();

		if (protocol_choice_source.getPar() != null) {
			HProtocolCombinator protocol_combinator_target = loadProtocolCombinator(protocol_choice_source
					.getPar());
			protocol_combinator_target.setActionName(actionName);
			protocol_combinator_target.setInterface(i);
			protocol_combinator_target
					.setProtocolChoice(protocol_choice_target);
			protocol_combinator_target.setParentCombinator(parent_combinator);
			protocol_combinator_target.setOrder(order);
			protocol_combinator_target
					.setCombinator(IProtocolCombinator.PAR_COMBINATOR);
			protocol_choice_target.setPar(protocol_combinator_target);
		} else if (protocol_choice_source.getSeq() != null) {
			HProtocolCombinator protocol_combinator_target = loadProtocolCombinator(protocol_choice_source
					.getSeq());
			protocol_combinator_target.setActionName(actionName);
			protocol_combinator_target.setInterface(i);
			protocol_combinator_target
					.setProtocolChoice(protocol_choice_target);
			protocol_combinator_target.setParentCombinator(parent_combinator);
			protocol_combinator_target.setOrder(order);
			protocol_combinator_target
					.setCombinator(IProtocolCombinator.SEQ_COMBINATOR);
			protocol_choice_target.setSeq(protocol_combinator_target);
		} else if (protocol_choice_source.getAlt() != null) {
			HProtocolCombinator protocol_combinator_target = loadProtocolCombinator(protocol_choice_source
					.getAlt());
			protocol_combinator_target.setActionName(actionName);
			protocol_combinator_target.setInterface(i);
			protocol_combinator_target
					.setProtocolChoice(protocol_choice_target);
			protocol_combinator_target.setParentCombinator(parent_combinator);
			protocol_combinator_target.setOrder(order);
			protocol_combinator_target
					.setCombinator(IProtocolCombinator.ALT_COMBINATOR);
			protocol_choice_target.setAlt(protocol_combinator_target);
		} else if (protocol_choice_source.getPerform() != null) {
			HProtocolPerform protocol_perform_target = loadProtocolPerform(protocol_choice_source
					.getPerform());
			protocol_perform_target.setActionName(actionName);
			protocol_perform_target.setInterface(i);
			protocol_perform_target.setProtocolChoice(protocol_choice_target);
			protocol_perform_target.setParentCombinator(parent_combinator);
			protocol_perform_target.setOrder(order);
			protocol_choice_target.setPerform(protocol_perform_target);
		}

		if (i != null)
			protocol_choice_target.setInterface(i);
		if (actionName != null)
			protocol_choice_target.setActionName(actionName);

		return protocol_choice_target;
	}

	private HProtocolCombinator loadProtocolCombinator(
			ProtocolCombinatorVisualType protocol_combinator_source) {
		HProtocolCombinator protocol_combinator_target = new HProtocolCombinator();

		protocol_combinator_target.setId(protocol_combinator_source.getId());
		GuardType guard = protocol_combinator_source.getGuard();
		if (guard != null)
			protocol_combinator_target.setGuard(loadGuard(guard));
		protocol_combinator_target.setRepeat(protocol_combinator_source
				.isRepeat());

		int order = 0;
		for (ProtocolChoiceType protocol_choice_source : protocol_combinator_source
				.getAction()) {
			HProtocolChoice protocol_choice_target = loadProtocolChoice(
					protocol_choice_source, null, null,
					protocol_combinator_target, order++);
			protocol_combinator_target.getAction().add(protocol_choice_target);
		}

		int x = (int) protocol_combinator_source.getVisualDescription().getX();
		int y = (int) protocol_combinator_source.getVisualDescription().getY();
		int w = (int) protocol_combinator_source.getVisualDescription().getW();
		int h = (int) protocol_combinator_source.getVisualDescription().getH();
		Rectangle r = new Rectangle(x, y, w, h);
		protocol_combinator_target.setBounds(r);

		return protocol_combinator_target;
	}

	private HProtocolPerform loadProtocolPerform(
			ProtocolPerformVisualType protocol_perform_source) {

		HProtocolPerform protocol_perform_target = new HProtocolPerform();
		protocol_perform_target.setId(protocol_perform_source.getId());
		GuardType guard = protocol_perform_source.getGuard();
		if (guard != null)
			protocol_perform_target.setGuard(loadGuard(guard));
		protocol_perform_target
				.setSliceId(protocol_perform_source.getSliceId());
		protocol_perform_target.setActionId(protocol_perform_source
				.getActionId());
		protocol_perform_target.setRepeat(protocol_perform_source.isRepeat());

		int x = (int) protocol_perform_source.getVisualDescription().getX();
		int y = (int) protocol_perform_source.getVisualDescription().getY();
		int w = (int) protocol_perform_source.getVisualDescription().getW();
		int h = (int) protocol_perform_source.getVisualDescription().getH();
		Rectangle r = new Rectangle(x, y, w, h);
		protocol_perform_target.setBounds(r);

		return protocol_perform_target;
	}

	private hPE.frontend.connector.xml.component.GuardType loadGuard(
			GuardType guard) {
		hPE.frontend.connector.xml.component.GuardType newguard = hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE
				.createGuardType();

		for (hPE.xml.component.ConditionType guard_cond : guard.getCondition()) {
			hPE.frontend.connector.xml.component.ConditionType newcond = hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE
					.createConditionType();
			newcond.setCondId(guard_cond.getCondId());
			newcond.setSliceId(guard_cond.getSliceId());
			newguard.getCondition().add(newcond);
		}

		for (hPE.xml.component.GuardType guard_and : guard.getAnd()) {
			newguard.getAnd().add(loadGuard(guard_and));
		}

		for (hPE.xml.component.GuardType guard_or : guard.getOr()) {
			newguard.getOr().add(loadGuard(guard_or));
		}

		return newguard;
	}

	private void buildUnit(UnitType xU, HComponent c)	throws HPEInvalidComponentResourceException, HPEAbortException 
	{
		int facet = xU.getFacet();
		int unit_facet_cardinality = this.facet_cardinality.containsKey(facet) ? this.facet_cardinality.get(facet) : 1;

		List<HUnit> u_list = new ArrayList<HUnit>();  
		
		String uName = xU.getURef();
		int x = (int) xU.getVisualDescription().getX();
		int y = (int) xU.getVisualDescription().getY();
		int w = (int) xU.getVisualDescription().getW();
		int h = (int) xU.getVisualDescription().getH();

		HUnit first_u = null;
		
		for (int facet_instance=0; facet_instance<unit_facet_cardinality; facet_instance++)
		{	
			int index = facet_instance; //xU.getReplica();

			EList<UnitRefType> xUsuper_list = xU.getSuper();

			HUnit u;	
			
			if (component.getSuperType() != null && !xUsuper_list.isEmpty())
			{
				List<IHUnit> us = new ArrayList<IHUnit>();
				for (UnitRefType xUsuper : xUsuper_list)
				{
					HUnit u_ = lookForSuperUnit(xUsuper);
					us.add(u_);
				}
				if (xUsuper_list.size() == 1)
					u = (HUnit) us.get(0);
				else
				{
				   u = c.createUnit();
				   u.colocateUnits(us); 
				   for (IHUnit u_super : us)
					   for (HUnitSlice u_super_slice : u_super.getSlices())
					   {   
						   u_super_slice.setUnit(u);
						   u.addUnitSlice(u_super_slice);
					   }
				}
			}
			else if (!component.isAbstractConfiguration() && !xUsuper_list.isEmpty())
			{
				List<IHUnit> us = new ArrayList<IHUnit>();
				for (UnitRefType xUsuper : xUsuper_list)
				{
					HUnit u_ = lookForImplementingUnit(xUsuper);
					us.add(u_);
				}
				if (xUsuper_list.size() == 1)
					u = (HUnit) us.get(0);
				else
				{
				   u = c.createUnit();
				   u.colocateUnits(us); // TODO: ?
				}
			}
			else if (index == 0) 
			    u = first_u = c.createUnit();
			else 
			{
			//	IHPrimUnit u_ = c.getUnitByName(uName, 0);
				u = (HUnit) first_u.createReplica(first_u, index-1);
			}		
	
			mU3.put(uName + index, u);
			u_list.add(u);
			
			u.setFacetInstance(facet_instance);	
		}
		
		for (HUnit u : u_list)
		{
			u.setName(uName);
			u.setBounds(new Rectangle(x, y, w, h));
			u.setHidden(xU.isPrivate());
			u.setMultiple(xU.isSetMultiple() ? xU.isMultiple() : u.isMultiple());
			u.setFacet(facet);
			//u.setIndexSlice(facet_instance);
	
			if (xU.getIRef() != null)
				u.setInterfaceName(xU.getIRef());
	
			if (this.component.isAbstractConfiguration())
				loadSlices(xU, u);
		}
		
	}

	private HInterface buildInterface(HUnit u, InterfaceType xI, boolean isTop,
			boolean isImplementing) throws HPEAbortException,
			HPEInvalidComponentResourceException {

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

	private void updateSlices(HInterface i, InterfaceType xI, boolean isTop,
			boolean isImplementing) throws HPEInvalidComponentResourceException {

		for (InterfaceSliceType sX : xI.getSlice()) {
			String sRef = sX.getIsRef();
			VisualElementAttributes ve = sX.getVisualDescription();
			InterfaceRefType rtX = sX.getOriginRef();
			String cRef = rtX.getCRef();
			String iRef = rtX.getIRef();
			HInterfaceSlice s = i.fetchSlice(cRef, iRef);
			if (s != null) {
				// if (!(s instanceof HEnumeratorInterfaceSlice)) {
				if (!isImplementing && !isTop) {
					List<HPort> ps = s.getPorts();
					for (HPort p_ : ps) {
						for (HInterfaceSlice s_ : p_.getInterfaceSlices()) {
							s_.resetDefaultName();
							s_.resetOriginalName();
						}
					}
				}
				// if (s == null)
				// throw new HPEInvalidComponentResourceException();
				Rectangle bounds = new Rectangle((int) ve.getX(),
						(int) ve.getY(), (int) ve.getW(), (int) ve.getH());
				s.setName(sRef);
				//s.setBounds(bounds);
				// }
			}
		}
	}

	private void loadSourceVersions(HInterface i, InterfaceType xI) {

		for (SourceType s : xI.getSources()) {
			String versionId = s.getVersionId();
			versionId = versionId != null && checkVersion(versionId) ? versionId : "1.0.0.0";
			String sourceType = s.getSourceType();
			HBESourceVersion source = i.createSourceVersion(sourceType);
			source.setVersionID(versionId);

			for (SourceFileType f : s.getFile()) {
				String fileType = f.getFileType() != null ? f.getFileType()	: "library";
				String locallocation = this.component.getRelativeLocation();
				URI uriRootPath = URI.createURI(locallocation);
				String rootPath = uriRootPath.toString();
				rootPath = rootPath.replaceAll("%20", " ");

				String versionIdF = f.getVersionId();
				versionIdF = versionIdF != null && checkVersion(versionIdF) ? versionIdF : "1.0.0.0";
				String name = f.getName();
				String contents = f.getContents();

				String srcType = f.getSrcType();

				HBEAbstractSourceCodeFile ff = createFile(fileType, name, contents, rootPath, versionIdF, i, srcType);
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

	private HBEAbstractSourceCodeFile createFile(String fileType, String name,
			String contents, String rootPath, String versionID,
			HHasExternalReferences i, String srcType) {
		if (fileType.equals(HBESourceCSharpClassDefinition.getType())) {
			return new HBESourceCSharpClassDefinition(name, contents, rootPath,
					versionID, i, srcType);
		} else if (fileType.equals(HBESourceCSharpMainDefinition.getType())) {
			return new HBESourceCSharpMainDefinition(name, contents, rootPath,
					versionID, i, srcType);
		} else if (fileType.equals(HPlatformSettingsFile.getType())) {
			return new HPlatformSettingsFile(name, contents, rootPath,
					versionID, i, srcType);
		} else
			return null;

	}

	/*
	 * private HAction buildAction(ActionType xP, HCombinatorAction i,
	 * HInterface ii, Map<String, HSemaphore> semTable, HProtocol p) {
	 * 
	 * HAction a = null;
	 * 
	 * String label = null; // TODO (action): xP.getLabel();
	 * 
	 * if (xP instanceof ActionCombinatorType) { ActionCombinatorType xA = null;
	 * HCombinatorAction ac = null; if (xP instanceof ActionCombinatorAltType) {
	 * xA = (ActionCombinatorAltType) xP; ac = new HAltAction(label, i); } else
	 * if (xP instanceof ActionCombinatorParType) { xA =
	 * (ActionCombinatorParType) xP; ac = new HParAction(label, i); } else if
	 * (xP instanceof ActionCombinatorSeqType) { xA = (ActionCombinatorSeqType)
	 * xP; ac = new HSeqAction(label, i); }
	 * 
	 * a = ac;
	 * 
	 * for (ActionType iXA : xA.getAction()) { HAction ia = buildAction(iXA, ac,
	 * ii, semTable, p); // ac.addAction(ia); }
	 * 
	 * }
	 * 
	 * else if (xP instanceof ActionActivateType) {
	 * 
	 * ActionActivateType xA = (ActionActivateType) xP; HDoAction ac = null;
	 * 
	 * String sliceRef = xA.getSliceRef();
	 * 
	 * HInterfaceSlice slice = ii.fetchSlice(sliceRef);
	 * 
	 * ac = new HDoAction(label, i, slice); a = ac;
	 * 
	 * } else if (xP instanceof ActionSkipType) {
	 * 
	 * ActionSkipType xA = (ActionSkipType) xP; HSkipAction ac = null;
	 * 
	 * ac = new HSkipAction(label, i); a = ac;
	 * 
	 * } else if (xP instanceof ActionSignalType) {
	 * 
	 * ActionSignalType xA = (ActionSignalType) xP; HSignalAction ac = null;
	 * 
	 * HSemaphore semaphore = getSemaphore(xA.getSemaphore(), semTable, p);
	 * 
	 * ac = new HSignalAction(semaphore, label); a = ac;
	 * 
	 * } else if (xP instanceof ActionWaitType) {
	 * 
	 * ActionWaitType xA = (ActionWaitType) xP; HWaitAction ac = null;
	 * 
	 * HSemaphore semaphore = getSemaphore(xA.getSemaphore(), semTable, p);
	 * 
	 * ac = new HWaitAction(semaphore, label); a = ac;
	 * 
	 * }
	 * 
	 * 
	 * return a; }
	 */

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
		} else if (kind.getName().equals(HPlatformComponent.KIND)) {
			c = new HPlatformComponent(name, location, uri);
		} else if (kind.getName().equals(HDataComponent.KIND)) {
			c = new HDataComponent(name, location, uri);
		} else if (kind.getName().equals(HEnvironmentComponent.KIND)) {
			c = new HEnvironmentComponent(name, location, uri);
		} else if (kind.getName().equals(HQualifierComponent.KIND)) {
			c = new HQualifierComponent(name, location, uri);
			// } else if (kind.getName().equals(HEnumeratorComponent.KIND)) {
			// c = new HEnumeratorComponent(name, location, uri);
		} else if (kind.getName().equals(HFacetComponent.KIND)) {
			c = new HFacetComponent(name, location, uri);
		} else if (kind.getName().equals(HBindingComponent.KIND)) {
			c = new HBindingComponent(name, location, uri);
		} else if (kind.getName().equals(HTopologyComponent.KIND)) {
			c = new HTopologyComponent(name, location, uri);
		} else {
			throw new HPEUnknownKindException("Component Kind Not Supported !");
		}

		return c;

	}

}
