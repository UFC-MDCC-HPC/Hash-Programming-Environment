package hPE.model.base.factory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import hPE.model.base.HComponent;
import hPE.xml.component.ComponentType;


public interface HComponentFactory {

	HComponent loadComponent(URI uri) throws HPEInvalidComponentResourceException ;
	ComponentType loadComponentX(URI uri) throws HPEInvalidComponentResourceException;
	
	public static HComponentFactory eInstance = new HComponentFactoryImpl();
	
	public void saveComponent(HComponent c, IFile file, IProgressMonitor monitor);
	
	public HComponent buildComponent(ComponentType xC, URI uri);
}
