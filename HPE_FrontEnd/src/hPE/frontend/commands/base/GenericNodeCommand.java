	package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;

import hPE.frontend.commands.base.*;
import hPE.model.base.*;

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
		} else if (source instanceof IHUnit && target instanceof HReplicator) {
			SetReplicatorCommand cmd = new SetReplicatorCommand((IHUnit) source);
			cmd.setTarget((HReplicator) target);
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
		} 
        else if (source instanceof IHUnit && target instanceof HReplicator) {
			if (((IHUnit) source).isEntry()) {
				SetReplicatorCommand cmd = new SetReplicatorCommand((IHUnit) source);
				cmd.setTarget((HReplicator) target);
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
        else if (source instanceof HComponent && target instanceof HReplicator) {
			SetReplicatorCommand cmd = new SetReplicatorCommand((HComponent) source);
			cmd.setTarget((HReplicator) target);
  		    actual_command = cmd;
        }
        else if (source instanceof HUnitSlice && target instanceof HReplicator) {
			SetReplicatorCommand cmd = new SetReplicatorCommand((HUnitSlice) source);
			cmd.setTarget((HReplicator) target);
  		    actual_command = cmd;
        } else if (source != target && source instanceof HComponent && target instanceof HComponent) {
        	System.out.println(target.hashCode() + "-" + source.hashCode());
        	SupersedeCommand cmd = new SupersedeCommand((HComponent)source, (HComponent)target);
        	actual_command = cmd;
        }
		
	}
	
	public boolean canComplete() {
		
		
		return ((source instanceof IHUnit && target instanceof HInterface) || 
		        (source instanceof IHUnit && target instanceof HReplicator && !((IHUnit) source).isEntry()) || 
		        (source instanceof IHUnit && target instanceof IHUnit && ((IHUnit) source).isEntry()) || 
                /* (source instanceof IHUnit && target instanceof HReplicator && ((IHUnit) source).isEntry()) || */
                (source instanceof HComponent && target instanceof HReplicator) ||
                (source instanceof HUnitSlice && target instanceof HReplicator) ||
                (source != target && source instanceof HComponent && target instanceof HComponent)/* ||
                (source instanceof IHUnit && target instanceof HComponent && ((IHUnit) source).isEntry())) */ ); 
        
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
