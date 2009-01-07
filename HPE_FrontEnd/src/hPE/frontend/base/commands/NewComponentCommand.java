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
			for (int i = 0; i < files.length; i ++) {
				if (files[i] instanceof String) {
     			   String file = (String) files[i];
     			   URI uri = URI.createFileURI(file); //
     			   innerComponent = hPEEditor.getConfiguration(uri);
     			   components.add(innerComponent);
			       locations.add(innerComponent.toString());
     			   
     			   /* InputStream is = file.getContents();
		    	   ObjectInputStream in = new ObjectInputStream(is); 
			       nested_component = (HComponent) in.readObject();
			       components.add(nested_component);
			       locations.add(nested_component.toString());
			       in.close(); */
				}
			}
			
		}
		
	}
	
	public void execute() {
		
		
		Iterator ls = locations.iterator();
		for (HComponent c : components) {
			String l = (String) ls.next();
            c.setLocation(l);
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
		Iterator cs = components.iterator();
		while (cs.hasNext()) {
			IComponent c = (IComponent) cs.next();
			if (!the_configuration.accepts(c)) return false;
		}
/*		if (the_configuration instanceof HDataConfiguration) {
			Iterator cs = components.iterator();
			while (cs.hasNext()) {
				HConfiguration c = (HConfiguration) cs.next();
				if (!(c instanceof HDataConfiguration)) {
					return false;
				}
			}
			
		} */
		return true;
		
	}

}
