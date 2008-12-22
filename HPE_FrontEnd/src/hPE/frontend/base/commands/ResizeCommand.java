	package hPE.frontend.base.commands;

import org.eclipse.gef.commands.Command;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.base.model.IHVisualElement;

public class ResizeCommand extends Command {

	Rectangle new_boundbox  = null;
	Point new_location = null;
	
	Rectangle old_boundbox  = null;
	Point old_location = null;
	
	IHVisualElement component;
	
	public ResizeCommand(Point location) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResizeCommand(IHVisualElement c, Rectangle boundbox) {
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
