	package hPE.frontend.commands.base;

import hPE.model.base.HPort;

import org.eclipse.gef.commands.Command;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;

public class ResizePortCommand extends Command {

	Rectangle new_boundbox  = null;
	Point new_location = null;
	
	Rectangle old_boundbox  = null;
	Point old_location = null;
	
	private HPort component;
	
	public ResizePortCommand(Point location) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResizePortCommand(HPort c, Rectangle boundbox) {
		super();
		// TODO Auto-generated constructor stub
		this.new_boundbox = boundbox;
		this.old_boundbox = c.getBounds();
		this.component = c;
	}
	
	public void execute() {
		this.component.setBounds(this.new_boundbox);
		
	}
	
	public void redo() {
       execute();		
	}
	
	public void undo() {
		this.component.setBounds(this.old_boundbox);
	}
	
	public boolean canExecute() {
		return true;
	}

}
