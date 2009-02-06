package hPE.frontend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.nant.release._0._86.beta1.nant.DocumentRoot;
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
import hPE.HPEProperties;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class NAntBuilder {
	
	private static NantFactory factory = NantFactory.eINSTANCE;

	public static Resource save(HComponent c, IProgressMonitor monitor) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();
			
			// Register the appropriate resource factory to handle all file extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
				(Resource.Factory.Registry.DEFAULT_EXTENSION, 
				 new NantResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put
				(NantPackage.eNS_URI, 
				 NantPackage.eINSTANCE);
	        
			IFolder file = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(c.getLocalLocation()));		
			
			IPath systemPath = file.getLocation().removeLastSegments(1).append("build.xml");
			
	        // If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createFileURI(systemPath.toOSString());
			Resource resource = resourceSet.createResource(uri);
			
			DocumentRoot dX = factory.createDocumentRoot();
			
			ProjectType cX = makeBuilder(c);
			dX.setProject(cX);
		
			resource.getContents().add(dX);
			resource.save(null); 

			try {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return resource;
		} catch (IOException e) {
			return null;
		}

		
	}

	private static ProjectType makeBuilder(HComponent c) {
		ProjectType project = factory.createProjectType();
		project.setName(c.getComponentName());
		project.setBasedir(HPEProperties.getInstance().getValue("cache_root"));
		project.setDefault("all");
		
		List<NAntCoreTasksPropertyTask> properties = project.getProperty();
		List<Target> targets = project.getTarget();
		
		NAntCoreTasksPropertyTask propMono = factory.createNAntCoreTasksPropertyTask();
		propMono.setName("nant.settings.currentframework");	
		propMono.setValue("mono-2.0");
		properties.add(propMono);

		NAntCoreTasksPropertyTask propBin = factory.createNAntCoreTasksPropertyTask();
		propBin.setName("build"); 
		propBin.setValue("bin");
		properties.add(propBin);

		NAntCoreTasksPropertyTask propSrc = factory.createNAntCoreTasksPropertyTask();
		propSrc.setName("src"); 
		propSrc.setValue("src");
		properties.add(propSrc);
		
		List<String> targetNames = new ArrayList<String>();
		
		List<Integer[]> versions = c.getVersions();
		for (Integer[] version : versions) {
			if (c.versionSupplied(HInterface.toStringVersion(version))) {
			
				Target target = factory.createTarget();
				
				String targetName = c.getComponentName()+ "-" + HInterface.toStringVersion(version);
				targetNames.add(targetName);
				
				target.setName(targetName);
				
				List<NAntDotNetTasksCscTask> csc = target.getCsc();
				
				for (HInterface i : c.getInterfaces()) if (i.getConfiguration() == c) {
					
					HBESourceVersion<HBEAbstractFile> v = i.getSourceVersion(HInterface.toStringVersion(version));
										
					if (v != null) 
						for (HBEAbstractFile src : v.getFiles()) {
						
							NAntDotNetTasksCscTask compile = factory.createNAntDotNetTasksCscTask();
			
							compile.setDebug("true");
							compile.setOptimize("true");
							IPath path_output = ResourcesPlugin.getWorkspace().getRoot().getFile(src.getBinaryPath()).getLocation(); 
							
							boolean folderOutputExists = ResourcesPlugin.getWorkspace().getRoot().exists(src.getBinaryPath().removeLastSegments(1));
							if (!folderOutputExists) {
								try {
									IFolder folderOutput = ResourcesPlugin.getWorkspace().getRoot().getFolder(src.getBinaryPath().removeLastSegments(1));
									folderOutput.create(true, true, null);
								} catch (CoreException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							
							
							compile.setOutput(path_output);
							compile.setTarget(src.getFileType());
						    String u = c.getRelativeLocation();
							IPath path_snk = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(c.getRelativeLocation())).getLocation();
							compile.setKeyfile(path_snk.removeFileExtension().addFileExtension("snk"));
							
							// Sources
							List<NAntCoreTypesFileSet> sources = compile.getSources();
							NAntCoreTypesFileSet source = factory.createNAntCoreTypesFileSet();
							sources.add(source);
							
							// Sources / Includes
							List<NAntCoreTypesFileSetInclude> includesSrcs = source.getInclude();
							NAntCoreTypesFileSetInclude includeSrc = factory.createNAntCoreTypesFileSetInclude();
							includeSrc.setName(ResourcesPlugin.getWorkspace().getRoot().getFile(src.getSourcePath()).getLocation());
							includesSrcs.add(includeSrc);					
							
							// References
							List<NAntDotNetTypesAssemblyFileSet> refs = compile.getReferences();
							NAntDotNetTypesAssemblyFileSet ref = factory.createNAntDotNetTypesAssemblyFileSet();
							refs.add(ref);
							
							// References / Includes
							List<NAntCoreTypesFileSetInclude> includeRefs = ref.getInclude();
							if (src.getDependencies() != null)
								for (String dep : src.getDependencies())
								{
									//List<HBEAbstractFile> filesRef = dep.getSourceVersion("1.0.0.0").getFiles();
									//for (HBEAbstractFile file : filesRef) {
										NAntCoreTypesFileSetInclude includeRef = factory.createNAntCoreTypesFileSetInclude();
										includeRef.setName(dep/*file.getBinaryPath().makeRelative()*/);
										includeRefs.add(includeRef);
									//}
						    	}
							NAntCoreTypesFileSetInclude includeRef = factory.createNAntCoreTypesFileSetInclude();
							includeRef.setName(HPEProperties.getInstance().getValue("dgac_path"));
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

}
