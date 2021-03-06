package hPE.frontend.base.policies;

import javax.swing.JOptionPane;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.data.model.HDataUnit;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class BuildInterfaceEditPolicy extends ComponentEditPolicy {

	public BuildInterfaceEditPolicy() {
		super();
		
	}
	
private static final String
	CREATE_INTERFACE_REQUEST = "Create Interface";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	IHUnit the_unit = (IHUnit) ((UnitEditPart) getHost()).getModel();
	
	if (CREATE_INTERFACE_REQUEST.equals(request.getType()))
		return new BuildInterfaceCommand(the_unit);
	return 
	    super.getCommand(request);
	
}


static class BuildInterfaceCommand 
      extends org.eclipse.gef.commands.Command{

IHUnit the_unit;
	
public BuildInterfaceCommand(IHUnit unit){

this.the_unit = unit;

}

public void execute(){
	
	Rectangle unit_bounds = the_unit.getBounds();
	Point where = unit_bounds.getLocation().getCopy().getTranslated(0, - 2*unit_bounds.height);
	try {
    	the_unit.createInterface(where);
	} catch (HPEAbortException e) {
		String msg = e.getMessage();
		JOptionPane.showMessageDialog(null, msg,"Aborting Operation !", JOptionPane.ERROR_MESSAGE);		
	}
	
}

public void undo(){
    // TO DO !
}

public void redo(){
	execute();
}
}

}
