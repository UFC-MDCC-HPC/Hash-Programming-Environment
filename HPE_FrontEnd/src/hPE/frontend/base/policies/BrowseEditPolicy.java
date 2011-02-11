package hPE.frontend.base.policies;

import hPE.frontend.base.dialogs.BrowseAndRunBackEndDialog;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.model.HComponent;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;


public class BrowseEditPolicy extends ComponentEditPolicy {

public BrowseEditPolicy() {
	super();
}
	
private static final String
	BROWSE_REQUEST = "Browse/Deploy/Run...";  //$NON-NLS-1$

public Command getCommand(Request request) {
		
	if (BROWSE_REQUEST.equals(request.getType()))
		return new DeployCommand((ConfigurationEditPart)this.getHost());
	return 
	    super.getCommand(request);
	
	
	
}

static class DeployCommand 
extends org.eclipse.gef.commands.Command{

private HComponent c = null;
public DeployCommand(ConfigurationEditPart part){

  c = (HComponent) part.getModel();

      
}

public void execute(){
	
	BrowseAndRunBackEndDialog dialog = BrowseAndRunBackEndDialog.getInstance();
	
	IProgressMonitor monitor = null;
	BrowseAndRunBackEndDialog.getCurrentEditor().doSave(monitor);
	
	dialog.setAlwaysOnTop(true);
	dialog.setVisible(true);
		
}


public void undo(){

}

public void redo(){
   execute();
}

public boolean canExecute() {
/*	if (i.isUnamed()) {
		JOptionPane.showMessageDialog(null, "Unamed Interface !","Edit Source Code Error", JOptionPane.ERROR_MESSAGE);
		return false;
	} else
		return true; */
	return true;
}

}





}
