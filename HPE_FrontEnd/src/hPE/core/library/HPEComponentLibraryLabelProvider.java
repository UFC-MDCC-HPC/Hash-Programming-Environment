package hPE.core.library;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import hPE.HPEPlugin;
import hPE.core.library.model.interfaces.*;


public class HPEComponentLibraryLabelProvider extends LabelProvider {
	private Map imageCache = new HashMap(11);
	
	/*
	 * @see ILabelProvider#getImage(Object)
	 */
	public Image getImage(Object element) {
		ImageDescriptor descriptor = null;
		if (element instanceof IHPEComponentLibrary) {
			descriptor = ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/rectangle16.gif");
		} else if (element instanceof ILPackage) {
			descriptor = ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/package_obj.gif");
		} else if (element instanceof ILComponentView) {
			ILComponentView e = (ILComponentView) element;
			if (e.isOK()) {
			   descriptor = ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/component.gif");
			} else {
			   descriptor = ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/rectangle16.gif");
			}
		} else if (element instanceof ILInterfaceCompositeView) {
			descriptor = ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/unit.gif");
		} else if (element instanceof ILVersion) {
			descriptor = ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/rectangle16.gif");
		} else {
			throw unknownElement(element);
		}

		//obtain the cached image corresponding to the descriptor
		Image image = (Image)imageCache.get(descriptor);
		if (image == null) {
			image = descriptor.createImage();
			imageCache.put(descriptor, image);
		}
		return image;
	}

	/*
	 * @see ILabelProvider#getText(Object)
	 */
	public String getText(Object element) {
        if (element instanceof IHPEComponentLibraryItem) {
			return ((IHPEComponentLibraryItem) element).getTitle();
		} else {
			throw unknownElement(element);
		}
	}

	
	public void dispose() {
		for (Iterator i = imageCache.values().iterator(); i.hasNext();) {
			((Image) i.next()).dispose();
		}
		imageCache.clear();
	}

	protected RuntimeException unknownElement(Object element) {
		return new RuntimeException("Unknown type of element in tree of type " + element.getClass().getName());
	}

}
