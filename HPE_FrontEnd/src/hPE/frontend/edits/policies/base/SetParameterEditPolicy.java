package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;

import org.eclipse.jface.dialogs.InputDialog;

import hPE.frontend.dialogs.base.DialogChangeVarName;
import hPE.frontend.dialogs.base.SetParameterDialog;

import java.util.List;

import org.eclipse.swt.SWT;

import hPE.model.base.HComponent;
import hPE.model.interfaces.IComponent;
import hPE.util.Triple;

public class SetParameterEditPolicy extends ComponentEditPolicy {

	public SetParameterEditPolicy() {
		super();
		
	}
	
private static final String
	SET_PARAMETER_REQUEST = "Set Parameter",  //$NON-NLS-1$
    UNSET_PARAMETER_REQUEST = "Unset Parameter";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HComponent model = (HComponent) ((AbstractEditPart) getHost()).getModel();
	
	if (SET_PARAMETER_REQUEST.equals(request.getType()))
		return new SetParameterCommand(model);
	else if (UNSET_PARAMETER_REQUEST.equals(request.getType()))
		return new UnsetParameterCommand(model);
	return 
	    super.getCommand(request);
	
}

public static class SetParameterCommand 
extends org.eclipse.gef.commands.Command{

private HComponent model;

public SetParameterCommand(HComponent model){

  this.model = model;

}

private SetParameterDialog dialog = null;

//public void setDialog(InputDialog dialog) {
//	this.dialog = dialog;
//}

private String varName = null;
private boolean cancel = false;

public void execute(){

  // dialog.open();
  // int r = dialog.getReturnCode();
   
   this.dialog = new SetParameterDialog();

   dialog.setModal(true);
   dialog.pack();
   dialog.setVisible(true);
   
	// BEGIN TODO: EXISTENTIAL TYPE
   //boolean isExistential = this.dialog.isExistential();
   //boolean isUniversal   = this.dialog.isUniversal();
	// END TODO: EXISTENTIAL TYPE

   String  parId         = this.dialog.getParId();
   
    if (dialog.getButtonPressed() == SetParameterDialog.BUTTON_OK) {
        varName = parId;        
        model.setParameter(varName);
		// TODO: EXISTENTIAL TYPE
        // model.setExistentialType(isExistential);
       ((HComponent)model.getTopConfiguration()).invalidateInterfaceNames();       
   } else {
	   cancel = true;
   }

}


public void undo(){
	if (!cancel) { 
       model.setNonAbstract(varName);
       ((HComponent)model.getTopConfiguration()).invalidateInterfaceNames();
	}       
}

public void redo(){
   execute();
}
}


public static class UnsetParameterCommand 
extends org.eclipse.gef.commands.Command{

HComponent model;

private String varName = null;

public UnsetParameterCommand(HComponent model){

  this.model = model;

}

public void execute(){

   varName = model.getParameterIdentifier((IComponent)model.getTopConfiguration());	
   model.setNonAbstract(varName);
   ((HComponent)model.getTopConfiguration()).invalidateInterfaceNames();

}


public void undo(){
   model.setParameter(varName);
   ((HComponent)model.getTopConfiguration()).invalidateInterfaceNames();
}

public void redo(){
   execute();
}

}


}
