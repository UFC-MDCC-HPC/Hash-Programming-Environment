package hPE.frontend;

import hPE.HPEProperties;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.dialogs.AddReferencesDialog;
import hPE.frontend.base.dialogs.AddReferencesDialog.Reference;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.ui.preferences.PreferenceConstants;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HPEInvalidComponentResourceException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.nant.release._0._86.beta1.nant.DocumentRoot;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksIfNotTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksMkDirTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTasksPropertyTask;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSet;
import net.sf.nant.release._0._86.beta1.nant.NAntCoreTypesFileSetInclude;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTasksCscTask;
import net.sf.nant.release._0._86.beta1.nant.NAntDotNetTypesAssemblyFileSet;
import net.sf.nant.release._0._86.beta1.nant.NantFactory;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.ProjectType;
import net.sf.nant.release._0._86.beta1.nant.Target;
import net.sf.nant.release._0._86.beta1.nant.util.NantResourceFactoryImpl;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

//Refatorado para o novo HPEProperties.
public class NAntBuilder implements Runnable {

	private static NantFactory factory = NantFactory.eINSTANCE;

	public static NAntBuilder instance = new NAntBuilder();

	private HComponent component;
	private IProgressMonitor monitor;

	public static void createBuildFile(String path, boolean relativePath)
			throws HPEInvalidComponentResourceException {

		URI uri = URI.createURI(path);
		HComponent c = HComponentFactoryImpl.eInstance.loadComponent(uri, true,
				false, false, false, relativePath);
		createBuildFile(c);

	}

	public static void createBuildFile(HComponent c)
			throws HPEInvalidComponentResourceException {

		NAntBuilder builder = NAntBuilder.instance;
		builder.setComponent(c);
		builder.run();

	}

	public Resource save(HComponent c, IProgressMonitor monitor) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register the appropriate resource factory to handle all file
			// extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new NantResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put(NantPackage.eNS_URI,
					NantPackage.eINSTANCE);

			// IFolder file =
			// ResourcesPlugin.getWorkspace().getRoot().getFolder(new
			// Path(c.getLocalLocation()));

			// IPath systemPath =
			// file.getLocation().removeLastSegments(1).append("build.xml");

			IPath systemPath = new Path(c.getLocalLocation());
			systemPath = systemPath.removeLastSegments(1).append("build.xml");

			java.io.File file = HComponentFactoryImpl
					.getFileInWorkspace(systemPath);

			// If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createFileURI(file.toString());
			Resource resource = resourceSet.createResource(uri);

			DocumentRoot dX = factory.createDocumentRoot();

			ProjectType cX = makeBuilder(c);
			dX.setProject(cX);

			resource.getContents().add(dX);
			resource.save(null);

			try {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (IllegalStateException e) {

			} catch (Exception e) {
				e.printStackTrace();
			}

			return resource;
		} catch (IOException e) {
			return null;
		}

	}

	private static Map<String, Reference> externalRefs = null;

	public static void clearExternalRefs() {
		externalRefs = null;
	}

	private static ProjectType makeBuilder(HComponent c) {
		ProjectType project = factory.createProjectType();
		project.setName(c.getComponentName());
		project.setBasedir(HPEProperties.get(PreferenceConstants.CACHE_PATH));
		project.setDefault("all");

		List<NAntCoreTasksPropertyTask> properties = project.getProperty();
		List<Target> targets = project.getTarget();

		NAntCoreTasksPropertyTask propMono = factory
				.createNAntCoreTasksPropertyTask();
		propMono.setName("nant.settings.currentframework");
		// TODO resolver essa quest‹o de vers‹o!
		propMono.setValue("mono-2.0");
		properties.add(propMono);

		NAntCoreTasksPropertyTask propBin = factory
				.createNAntCoreTasksPropertyTask();
		propBin.setName("build");
		propBin.setValue("bin");
		properties.add(propBin);

		NAntCoreTasksPropertyTask propSrc = factory
				.createNAntCoreTasksPropertyTask();
		propSrc.setName("src");
		propSrc.setValue("src");
		properties.add(propSrc);

		List<String> targetNames = new ArrayList<String>();

		boolean firstPass = true;

		List<Integer[]> versions = c.getVersions();
		for (Integer[] version : versions) {
			if (c.versionSupplied(HInterface.toStringVersion(version))) {

				Target target = factory.createTarget();

				String targetName = c.getComponentName() + "-"
						+ HInterface.toStringVersion(version);
				targetNames.add(targetName);

				target.setName(targetName);

				List<NAntDotNetTasksCscTask> csc = target.getCsc();

				for (HInterface i : c.getInterfaces())
					if (i.getConfiguration() == c) {

						HBESourceVersion<HBEAbstractFile> v = i
								.getSourceVersion(HInterface
										.toStringVersion(version));

						if (v != null)
							for (HBEAbstractFile src : v.getFiles()) {

								NAntDotNetTasksCscTask compile = factory
										.createNAntDotNetTasksCscTask();

								compile
										.setDebug(HPEProperties
												.get(
														PreferenceConstants.COMPILER_FLAG_DEBUG)
												.equals("true"));
								compile
										.setOptimize(HPEProperties
												.get(
														PreferenceConstants.COMPILER_FLAG_OPTIMIZE)
												.equals("true"));
								compile
										.setUnsafe(HPEProperties
												.get(
														PreferenceConstants.COMPILER_FLAG_UNSAFE)
												.equals("true"));
								java.io.File binPath = HComponentFactoryImpl
										.getFileInWorkspace(src.getBinaryPath());
								IPath path_output = Path
										.fromPortableString(binPath.toString()); // ResourcesPlugin.getWorkspace().getRoot().getFile(src.getBinaryPath()).getLocation();

								// IPath path_output_folder =
								// src.getBinaryPath().removeLastSegments(1);

								java.io.File folderOutput = binPath
										.getParentFile();
								// IFolder folderOutput =
								// ResourcesPlugin.getWorkspace().getRoot().getFolder(path_output_folder);

								String path_output_folder_string = folderOutput
										.toString(); // folderOutput.getLocation().toString();

								// boolean folderOutputExists =
								// ResourcesPlugin.getWorkspace().getRoot().exists(path_output_folder);
								// boolean folderOutputExists =
								// HComponentFactoryImpl.existsInWorkspace(path_output_folder);
								if (!folderOutput.exists()) {
									try {
										NAntBuilder.prepareFolder(folderOutput);
									} catch (CoreException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}

								if (firstPass) {
									NAntCoreTasksIfNotTask ifNotTask = factory
											.createNAntCoreTasksIfNotTask();
									target.getIfnot().add(ifNotTask);
									ifNotTask
											.setTargetexists(path_output_folder_string);
									List<NAntCoreTasksMkDirTask> mkdirList = ifNotTask
											.getMkdir();
									NAntCoreTasksMkDirTask mkdirTask = factory
											.createNAntCoreTasksMkDirTask();
									mkdirList.add(mkdirTask);
									mkdirTask.setDir(path_output_folder_string);
									firstPass = false;
								}

								compile.setOutput(path_output);
								compile.setTarget(src.getFileType());
								IPath path_snk = new Path(HComponentFactoryImpl
										.getFileInWorkspace(
												new Path(c.getLocalLocation()))
										.toString());

								// IPath path_snk =
								// ResourcesPlugin.getWorkspace().getRoot().getFile(new
								// Path(c.getRelativeLocation())).getLocation();
								compile.setKeyfile(path_snk
										.removeFileExtension()
										.addFileExtension("snk"));

								// Sources
								List<NAntCoreTypesFileSet> sources = compile
										.getSources();
								NAntCoreTypesFileSet source = factory
										.createNAntCoreTypesFileSet();
								sources.add(source);

								// Sources / Includes
								List<NAntCoreTypesFileSetInclude> includesSrcs = source
										.getInclude();
								NAntCoreTypesFileSetInclude includeSrc = factory
										.createNAntCoreTypesFileSetInclude();
								includeSrc
										.setName(HComponentFactoryImpl
												.getFileInWorkspace(src
														.getSourcePath())/*
																		 * ResourcesPlugin.
																		 * getWorkspace
																		 * (
																		 * ).getRoot
																		 * (
																		 * ).getFile
																		 * (src.
																		 * getSourcePath
																		 * ()).
																		 * getLocation
																		 * ()
																		 */);
								includesSrcs.add(includeSrc);

								// References
								List<NAntDotNetTypesAssemblyFileSet> refs = compile
										.getReferences();
								NAntDotNetTypesAssemblyFileSet ref = factory
										.createNAntDotNetTypesAssemblyFileSet();
								refs.add(ref);

								// References / Includes
								List<NAntCoreTypesFileSetInclude> includeRefs = ref
										.getInclude();
								if (src.getDependencies() != null) {
									for (String dep_ : src.getDependencies()) {
										char path_separator = IPath.SEPARATOR;
										String dep = dep_.replace('/',
												path_separator);
										NAntCoreTypesFileSetInclude includeRef = factory
												.createNAntCoreTypesFileSetInclude();
										if (dep.startsWith("%WORKSPACE")) {
											// IFile fPathD =
											// ResourcesPlugin.getWorkspace().getRoot().getFile(new
											// Path(dep.substring("%WORKSPACE".length())));
											File fpathD = HComponentFactoryImpl
													.getFileInWorkspace(new Path(
															dep
																	.substring("%WORKSPACE"
																			.length())));
											dep = fpathD.toString();
										}
										includeRef.setName(dep);
										includeRefs.add(includeRef);
									}
								}
								if (src.getExternalReferences() != null) {
									for (String dep : src
											.getExternalReferences()) {
										if (externalRefs == null) {
											externalRefs = new HashMap<String, Reference>();
											AddReferencesDialog
													.loadExternalReferences(externalRefs);
										}
										Reference externalRef = externalRefs
												.get(dep);
										NAntCoreTypesFileSetInclude includeRef = factory
												.createNAntCoreTypesFileSetInclude();
										if (externalRef != null) {
											includeRef.setName(externalRef
													.getPath().toString()
													+ Path.SEPARATOR
													+ externalRef.getName()
													+ ".dll");
											includeRefs.add(includeRef);
										}
									}
								}
								NAntCoreTypesFileSetInclude includeRef = factory
										.createNAntCoreTypesFileSetInclude();
								includeRef
										.setName(HPEProperties
												.get(PreferenceConstants.LIB_PATH
														+ System
																.getProperty("file.separator")
														+ "DGAC.dll"));
								includeRefs.add(includeRef);

								csc.add(compile);
							}
					}
				targets.add(target);
			}
		}

		Target targetAll = factory.createTarget();
		targetAll.setName("all");
		String dependencies = "";
		for (String tn : targetNames) {
			dependencies += "," + tn;
		}
		if (targetNames.size() > 0)
			dependencies = dependencies.substring(1);

		targetAll.setDepends(dependencies);
		targets.add(targetAll);

		return project;
	}

	public static void prepareFolder(File folderOutput) throws CoreException,
			IOException {
		File parent = folderOutput.getParentFile();
		if (parent.isDirectory()) {
			if (!parent.exists())
				prepareFolder(parent);
		}
		if (!folderOutput.exists()) {
			folderOutput.createNewFile();
		}
		/*
		 * IContainer parent = folderOutput.getParent(); if (parent instanceof
		 * IFolder) { IFolder parentFolder = (IFolder) parent; if
		 * (!parentFolder.exists()) prepareFolder(parentFolder); } if
		 * (!folderOutput.exists()) { folderOutput.create(true,true,null); }
		 */

	}

	@Override
	public void run() {
		save(this.component, this.monitor);

	}

	public void setComponent(HComponent component) {
		this.component = component;
	}

	public HComponent getComponent() {
		return component;
	}

	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	public IProgressMonitor getMonitor() {
		return monitor;
	}

}
