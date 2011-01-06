package hPE.xml.factory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import hPE.frontend.base.model.HComponent;
import hPE.xml.component.ComponentType;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;


public interface HComponentFactory {

	HComponent loadComponent(URI uri, boolean isTop, boolean isExtending, boolean isImplementing, boolean cached, boolean relativePath) throws HPEInvalidComponentResourceException ;
	ComponentType loadComponentX(URI uri, boolean cache, boolean relativePath) throws HPEInvalidComponentResourceException;
	
	public static HComponentFactory eInstance = new HComponentFactoryImpl();
	
	public void saveComponent(HComponent c, java.io.File file, IProgressMonitor monitor) throws UndefinedRefInnerException, DuplicatedRefInnerException, DuplicatedSliceNamesException;
	
	public void saveComponent(ComponentType cX, java.io.File file, IProgressMonitor monitor);
	
	public ComponentType marshallComponent(HComponent c) throws UndefinedRefInnerException, DuplicatedRefInnerException, DuplicatedSliceNamesException;
	
	public HComponent buildComponent(ComponentType xC, URI uri, boolean isTop, boolean isExtending, boolean isImplementing);
}
