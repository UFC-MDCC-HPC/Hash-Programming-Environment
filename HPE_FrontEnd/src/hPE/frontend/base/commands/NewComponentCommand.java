package hPE.frontend.base.commands;

import hPE.hPEEditor;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.commands.Command;


public class NewComponentCommand extends Command {

	private HComponent the_configuration;
	private List<HComponent> components = null;
	private List<String> locations = null;
	
	private String[] files;
	private Point location;
	
	public NewComponentCommand(HComponent the_configuration, String[] files, Point location) {
		super();
		
		this.the_configuration = the_configuration;
		this.files = files;
		this.location = location;
				
	}


	private void openComponents() {	
		
		if (components == null) {
			
			HComponent innerComponent;
			components = new ArrayList<HComponent>();
			locations = new ArrayList<String>();
			String remoteURI = null;
			for (int i = 1; i < files.length; i += 2) {
				if (files[i] instanceof String) {
				   remoteURI = files[i-1];
				   String file = (String) files[i];
     			   URI uri = URI.createFileURI(file); 
     			   innerComponent = hPEEditor.getConfiguration(uri);
     			   innerComponent.setRemoteURI(URI.createURI(remoteURI));
     			   components.add(innerComponent);
			       locations.add(innerComponent.getLocalLocation());
   				}
			}
			
		}
		
	}
	
	public void execute() {
		
		
		for (HComponent c : components) {
		    this.the_configuration.loadComponent(c, this.location);
		}
		
		return;
	}
	
	private void handleLoadException(Exception e) {
		
		System.err.println("** Loading component failed");
		e.printStackTrace();
		
	}
	
	public void undo() {
		
	}
	
	public void redo() {
		
	}
	
	public boolean canExecute() {
		openComponents();
		for (IComponent c : components) {
			if (!c.isAbstract() || !the_configuration.accepts(c)) return false;
		}
		return true;
		
	}

}
