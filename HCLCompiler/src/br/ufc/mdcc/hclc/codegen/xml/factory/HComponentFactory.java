package br.ufc.mdcc.hclc.codegen.xml.factory;

import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentType;
import br.ufc.mdcc.hclc.symboltable.Component;



public interface HComponentFactory {

	
	public static HComponentFactory eInstance = new HComponentFactoryImpl();
	
	public void saveComponent(Component c, String path, IProgressMonitor monitor);
	
	public void saveComponent(ComponentType cX, String path, IProgressMonitor monitor);
	
	public ComponentType marshallComponent(Component c);
	
}
