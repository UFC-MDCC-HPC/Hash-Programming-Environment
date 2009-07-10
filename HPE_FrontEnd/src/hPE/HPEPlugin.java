package hPE;

import hPE.util.CommandLine;

import org.eclipse.ui.plugin.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class HPEPlugin extends AbstractUIPlugin {

	//The shared instance.
	private static HPEPlugin plugin;
	
	/**
	 * The constructor.
	 */
	public HPEPlugin() {
		plugin = this;
	}

	   public class MyResourceChangeReporter implements IResourceChangeListener {
		      public void resourceChanged(IResourceChangeEvent event) {
	               try {
				         IResource res = event.getResource();
				         switch (event.getType()) {
				            case IResourceChangeEvent.POST_BUILD:
				               System.out.println("Build complete.");
				               event.getDelta().accept(new DeltaPrinter());
				               break;
/*				            case IResourceChangeEvent.POST_CHANGE:
					           System.out.println("Resources have changed.");
					           event.getDelta().accept(new DeltaPrinter());
					           break; */
				         }
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		      }
	   }

	   class DeltaPrinter implements IResourceDeltaVisitor {
		      public boolean visit(IResourceDelta delta) {
		         IResource res = delta.getResource();
		         
                 IPath fileName = res.getLocation();
                 String ext = fileName.getFileExtension(); 
                 String gacutil_path = HPEProperties.getInstance().getValue("gacutil_path");
		         switch (delta.getKind()) {
		            case IResourceDelta.ADDED:
		               if (ext != null && fileName.getFileExtension().equals("dll"))
		                  CommandLine.runCommand(new String[] {gacutil_path, "-i", fileName.toString()}, new String[] {}, null);		               
		               break;
		            case IResourceDelta.REMOVED:
		               if (ext != null && fileName.getFileExtension().equals("dll"))
		                  CommandLine.runCommand(new String[] {gacutil_path, "-u", fileName.removeFileExtension().lastSegment()}, new String[] {}, null);
		               
		               break;
		            case IResourceDelta.CHANGED:
		               if (ext != null && ext.equals("dll")) {
		                  CommandLine.runCommand(new String[] {gacutil_path, "-i", fileName.toString()}, new String[] {},  null);
		               }
		               break;
		         }
		         return true; // visit the children
		      }
		   }
	   /**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		   IResourceChangeListener listener = new MyResourceChangeReporter();
		   ResourcesPlugin.getWorkspace().addResourceChangeListener(listener,
                IResourceChangeEvent.POST_BUILD
		      | IResourceChangeEvent.POST_CHANGE);
		
	}

	/**
	 * This method is called when the plug-in is stopped
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Returns the shared instance.
	 */
	public static HPEPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("HPE", path);
	}
}
