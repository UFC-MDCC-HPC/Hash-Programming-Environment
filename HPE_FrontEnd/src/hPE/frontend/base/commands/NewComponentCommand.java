package hPE.frontend.base.commands;

import hPE.hPEEditor;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

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
			for (int i = 0; i < files.length; i++) {
				if (files[i] instanceof String) {
				  // remoteURI = files[i-1];
				   String file = (String) files[i];
     			   URI uri = URI.createFileURI(file); 
     			   innerComponent = hPEEditor.getConfiguration(uri);
     			   //innerComponent.setRemoteURI(URI.createURI(remoteURI));
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
		for (HComponent c : components) {
			if (!c.isAbstract()) return false;
			if (!the_configuration.accepts(c)) {
				String message = "A " + the_configuration.kindString() + " cannot have an inner component of kind " + c.kindString() + "."; 
				JOptionPane.showMessageDialog(null, message , "Error adding an inner component", JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		return true;
		
	}

}
