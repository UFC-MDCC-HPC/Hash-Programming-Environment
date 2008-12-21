package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.jface.dialogs.InputDialog;

import org.eclipse.swt.widgets.Shell;

import hPE.frontend.edits.base.InterfaceSliceEditPart;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.INamed;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;


public class SetSliceNameEditPolicy extends ComponentEditPolicy {

	public SetSliceNameEditPolicy() {
		super();
		
	}
	
private static final String
	SET_SLICE_NAME_REQUEST = "Set Slice Name";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	AbstractEditPart e = ((AbstractEditPart) getHost());
	
	   INamed model = (INamed) e.getModel();
  	   if (SET_SLICE_NAME_REQUEST.equals(request.getType()))
		  return new SetSliceNameCommand(model);
	   return 
		  super.getCommand(request);
		
	
	
}

public static class SetSliceNameCommand 
extends org.eclipse.gef.commands.Command{

private INamed model = null;

public SetSliceNameCommand(INamed model) {
	this.model = model;
}

/*
public SetSliceNameCommand(HInterfaceSlice model){

  this.modelSlice = model;

}



public SetSliceNameCommand(HPort port){
	
	  this.modelPort = port.getParentPort();

}

*/

private Shell shell;
private InputDialog dialog = null;

public void setShell(Shell shell) {
	this.shell = shell;
}


private String sliceName = null;
private boolean cancel = false;
private String oldName = null;

public void execute(){
	
       oldName = model.getName();
	   dialog = new InputDialog(shell,"Set Slice Name","Slice Name",oldName,null);
	   dialog.open();
	   int r = dialog.getReturnCode();
	   
	   if (r == 0) {
          sliceName = dialog.getValue();
          model.setName(sliceName);	          
	   } else {
		   cancel = true;
	   }	   
   

}

public void undo(){	   
	   model.setName(oldName);
}

public void redo(){
   execute();}
}




}
