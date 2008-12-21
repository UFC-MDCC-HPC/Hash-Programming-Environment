package hPE.frontend.commands.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IFileEditorInput;

import hPE.model.base.HComponent;
import hPE.model.interfaces.IComponent;
import hPE.model.kinds.data.HDataComponent;
import hPE.hPEEditor;


import org.eclipse.core.resources.IFile;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class NewComponentCommand extends Command {

	private HComponent the_configuration;
	private List<HComponent> components = null;
	private List<String> locations = null;
	
	private IResource[] files;
	private Point location;
	
	public NewComponentCommand(HComponent the_configuration, IResource[] files, Point location) {
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
				if (files[i] instanceof IFile) {
     			   IFile file = (IFile) files[i];
     			   innerComponent = hPEEditor.getConfiguration(file);
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
