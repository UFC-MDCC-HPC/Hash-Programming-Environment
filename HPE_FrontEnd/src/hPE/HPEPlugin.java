package hPE;

import hPE.frontend.NAntBuilder;
import hPE.ui.preferences.HPEPreferenceStore;
import hPE.xml.factory.HPEInvalidComponentResourceException;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class HPEPlugin extends AbstractUIPlugin {

	// The shared instance.
	private static HPEPlugin plugin;

	protected HPEPreferenceStore hpePreferenceStore;

	/**
	 * The constructor.
	 */
	public HPEPlugin() {
		plugin = this;
	}

	private List<IPropertyChangeListener> myListeners = new ArrayList<IPropertyChangeListener>();

	// A public method that allows listener registration
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		if (!myListeners.contains(listener))
			myListeners.add(listener);
	}

	// A public method that allows listener registration
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		myListeners.remove(listener);
	}

	public void notifyListeners(String property) {
		for (IPropertyChangeListener listener : myListeners) {
			listener.propertyChange(new MyPropertyChangeEvent(this, property,
					null, null));
		}
	}

	class MyPropertyChangeEvent extends PropertyChangeEvent {

		/**
		 * 
		 */
		private static final long serialVersionUID = 4671328683246397820L;

		public MyPropertyChangeEvent(Object arg0, String arg1, Object arg2,
				Object arg3) {
			super(arg0, arg1, arg2, arg3);
		}

	}

	public class MyResourceChangeReporter implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {
			try {
				Object source = null;
				IResource res = event.getResource();
				switch (event.getType()) {
				case IResourceChangeEvent.POST_BUILD:
					source = event.getSource();
					event.getDelta().accept(new DeltaPrinter());
					break;
				case IResourceChangeEvent.PRE_BUILD:
					System.out.println("Starting build.");
					source = event.getSource();
					if (source instanceof IProject) {
						IProject project = (IProject) source;
						IPath path = project.getFullPath().makeRelative();
						String pathStr = path.toString();
						String[] pathStrArr = pathStr.replace(".", "#").split(
								"#");
						String cName = pathStrArr[pathStrArr.length - 1];
						IPath path2 = path.append(cName + ".hpe");

						NAntBuilder.createBuildFile(path2.toString(), true);

						project.refreshLocal(IResource.DEPTH_INFINITE, null);
						System.out.println("generated build.xml for " + path2);
					}

					event.getDelta().accept(new DeltaPrinter());
					break;
				}
			} catch (CoreException e) {
				e.printStackTrace();
			} catch (HPEInvalidComponentResourceException e) {
				e.printStackTrace();
			}
		}
	}

	class DeltaPrinter implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) {
			/*
			 * IResource res = delta.getResource();
			 * 
			 * IPath fileName = res.getLocation(); String ext =
			 * fileName.getFileExtension(); String gacutil_path =
			 * HPEProperties.getInstance().getValue("gacutil_path"); switch
			 * (delta.getKind()) { case IResourceDelta.ADDED: if (ext != null &&
			 * fileName.getFileExtension().equals("dll"))
			 * CommandLine.runCommand(new String[] {gacutil_path, "-i",
			 * fileName.toString()},null); break; case IResourceDelta.REMOVED:
			 * if (ext != null && fileName.getFileExtension().equals("dll")) {
			 * CommandLine.runCommand(new String[] {gacutil_path, "-u",
			 * fileName.removeFileExtension().lastSegment()},null); }
			 * 
			 * break; case IResourceDelta.CHANGED: if (ext != null &&
			 * ext.equals("dll")) { CommandLine.runCommand(new String[]
			 * {gacutil_path, "-i", fileName.toString()},null); } break; }
			 */
			return true; // visit the children
		}
	}

	/**
	 * This method is called upon plug-in activation
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		IResourceChangeListener listener = new MyResourceChangeReporter();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(
				listener,
				IResourceChangeEvent.POST_BUILD
						| IResourceChangeEvent.POST_CHANGE
						| IResourceChangeEvent.PRE_BUILD);

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
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin("HPE", path);
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		if (hpePreferenceStore == null) {
			hpePreferenceStore = new HPEPreferenceStore(
					new InstanceScope(), getBundle().getSymbolicName());
		}
		return hpePreferenceStore;
	}
}
