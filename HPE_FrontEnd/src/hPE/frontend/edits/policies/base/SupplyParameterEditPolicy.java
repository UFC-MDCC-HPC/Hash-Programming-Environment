package hPE.frontend.edits.policies.base;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.jface.dialogs.InputDialog;

import hPE.model.base.HComponent;
import hPE.model.interfaces.IComponent;
import hPE.model.interfaces.IUnit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.lang.Long;

import javax.swing.JOptionPane;

import org.eclipse.draw2d.geometry.Point;

public class SupplyParameterEditPolicy extends ComponentEditPolicy {

	public SupplyParameterEditPolicy() {
		super();
		
	}
	
private static final String
	SUPPLY_PARAMETER_REQUEST = "Supply Parameter";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	HComponent model = (HComponent) ((AbstractEditPart) getHost()).getModel();
	
	if (SUPPLY_PARAMETER_REQUEST.equals(request.getType()))
		return new SupplyParameterCommand(model);
	return 
	    super.getCommand(request);
	
}

public static class SupplyParameterCommand 
extends org.eclipse.gef.commands.Command{

HComponent model;

public SupplyParameterCommand(HComponent model){

  this.model = model;

}

InputDialog dialog = null;

public void setDialog(InputDialog dialog) {
	this.dialog = dialog;
}

List unlift_info;

private String varName = null;
private boolean cancel = false;

public void execute(){

	   List componentsToSupply = new ArrayList();
	
	   dialog.open();
	   int r = dialog.getReturnCode();
	   
	   if (r == 0) {
          varName = dialog.getValue();
          
          HComponent topModel = (HComponent) model.getTopConfiguration();
	      topModel.supplyParameter(varName,model);          
          
	   } else {
		   cancel = true;
	   }
   

	   
}

/*
private void changeVarNames(List<HConfiguration> componentsToSupply, String newVarName) {
	
	
	Iterator<HConfiguration> cs = componentsToSupply.iterator();
	while (cs.hasNext()) {
	 	HConfiguration c = cs.next();
		c.changeVarName("@@@".concat(newVarName));
		
	}
}
*/

private IComponent getModelCopy() {

		  IComponent modelCopy = null;
		  
		  try {
     		    ByteArrayOutputStream os = new ByteArrayOutputStream();
     			ObjectOutputStream oos = new ObjectOutputStream(os);
     		
	  		    oos.writeObject(model);
	  		    oos.close();
	  		    os.close();
	  		    ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
	  			is.close();
	  			ObjectInputStream ois = new ObjectInputStream(is);
	  			modelCopy = (IComponent) ois.readObject();
  			
   		   } catch (IOException ioe) {
  			  ioe.printStackTrace();
  		   } catch (ClassNotFoundException ioe) {
  			     ioe.printStackTrace();
  		   }
  		   
  		   return modelCopy;
	
}

public void undo(){
	
	   
}

public void redo(){
   execute();}
}




}
