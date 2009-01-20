package hPE.frontend;

import java.io.IOException;

import net.sf.nant.release._0._86.beta1.nant.DocumentRoot;
import net.sf.nant.release._0._86.beta1.nant.NantFactory;
import net.sf.nant.release._0._86.beta1.nant.NantPackage;
import net.sf.nant.release._0._86.beta1.nant.ProjectType;
import net.sf.nant.release._0._86.beta1.nant.util.NantResourceFactoryImpl;
import hPE.frontend.base.model.HComponent;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
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
	        
			IFolder file = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(c.getLocation()));		
			
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
			
			return resource;
		} catch (IOException e) {
			return null;
		}

		
	}

	private static ProjectType makeBuilder(HComponent c) {
		ProjectType project = factory.createProjectType();
		
		
		return project;
	}

}
