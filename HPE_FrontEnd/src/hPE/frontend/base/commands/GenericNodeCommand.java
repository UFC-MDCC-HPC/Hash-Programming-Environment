	package hPE.frontend.base.commands;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IHVisualElement;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public class GenericNodeCommand extends Command {

	Object source = null;
	Object target = null;
	Command actual_command = null;
	Point where = null;
		
	IHVisualElement component;
	
	public GenericNodeCommand() {
		super();
	}

	
	public void setTarget(Object t, Point w) {
		this.target = t;
		this.where = w;
		setActualCommand();
	}
	
	private void setActualCommand() {
		
		if (source instanceof IHUnit && target instanceof HInterface) {
			AttachInterfaceCommand cmd = new AttachInterfaceCommand((IHUnit) source);
  		    cmd.setTarget((HInterface) target);
  		    actual_command = cmd;
		} else if (source instanceof IHUnit && target instanceof IHUnit) {
			if (((IHUnit) source).isEntry()) {
				int d = HUnitSlice.raio;
				BindingCreateCommand cmd = new BindingCreateCommand((IHUnit) source);					
				cmd.setUnit((IHUnit)target);
				Point loc = where.getCopy();
				Point unit_loc = ((IHUnit) target).getBounds().getLocation().getCopy();
				loc.translate(-unit_loc.x - d,-unit_loc.y - d);
	 		    cmd.setWhere(loc);
	  		    actual_command = cmd;
			}
		}  /* else if (source instanceof IHUnit && target instanceof HComponent) {
        	if (((IHUnit) source).isEntry()) {
        		BindingCreateCommand cmd = new BindingCreateCommand((IHUnit) source);
				Point loc = where.getCopy();
	 		    cmd.setWhere(loc);
	  		    actual_command = cmd;
        	} 
        } */
        /* else if (source != target && source instanceof HComponent && target instanceof HComponent) {
        	System.out.println(target.hashCode() + "-" + source.hashCode());
        	SupersedeCommand cmd = new SupersedeCommand((HComponent)source, (HComponent)target);
        	actual_command = cmd;
        } */
		
	}
	
	public boolean canComplete() {
		
		
		return ((source instanceof IHUnit && target instanceof HInterface) ||
		        (source instanceof IHUnit && target instanceof IHUnit && ((IHUnit) source).isEntry()) || 
                (source != target && source instanceof HComponent && target instanceof HComponent)); 
        
	}
	
	public void setSource(Object s) {
		this.source = s;
	}
	
	public void execute() {
		actual_command.execute();
		
	}
	
	public void redo() {
       actual_command.redo();		
	}
	
	public void undo() {
		actual_command.undo();
	}
	
	public boolean canExecute() {
		if (target != null)	
		   return actual_command.canExecute();
		else
		   return false;
	}

	
}
