
package hPE.frontend.base.commands;


import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HPrimUnit;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IBindingTarget;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.computation.model.HComputationUnit;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;
import hPE.frontend.kinds.data.model.HDataUnit;
import hPE.frontend.kinds.data.model.HDataUnitSlice;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class BindingCreateCommand extends Command {
	
	private IHUnit the_source;
	private IHUnit the_unit;
	private Point where;
	private IBindingTarget bt;
	
	public BindingCreateCommand(IHUnit source) {
		super();
		
		if (source == null) {
			throw new IllegalArgumentException();
		}
		setLabel("connection creation");
		this.the_source = source;
	}
	
	public void execute() {
		
	   
		try {

			HComponent configuration = (HComponent) the_unit.getConfiguration();
			setBindingTarget(configuration.createBinding(the_source,the_unit,where));
					
		} catch (HPEAbortException e) {
			String msg = e.getMessage();
			JOptionPane.showMessageDialog(null, msg,"Aborting Operation !", JOptionPane.ERROR_MESSAGE);
		}
	}
		   
/*
  	   if (the_unit.getInterface() != null && !the_unit.isInterfaceEditable()) {
		   JOptionPane.showMessageDialog(null, "Non Editable Interface !","Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
	   } else {
			try {
				
				HComponent configuration = null;
				
				if (the_target == null) {			
					configuration = (HComponent) the_unit.getConfiguration();
					the_target = the_source.newSlice(the_unit,where);
					HInterface i = (HInterface) the_source.getInterface();
					i.setEditable(false);
				} else {
					// ERROR !!!!
				 }
				
				new HBinding(configuration,the_target,the_source);
				
			} catch (HPEAbortException e) {
				String msg = e.getMessage();
				JOptionPane.showMessageDialog(null, msg,"Aborting Operation !", JOptionPane.ERROR_MESSAGE);
			}
	}

 */
	
	
	
	
	public boolean canUndo() {
		return false;
	}
	
	public void redo() {
	    execute();	
	}
		
	public void setUnit(IHUnit u) {
		the_unit = u;
	}
	
	public void setWhere(Point w) {
		
		where = w;
	}
	
	public boolean canExecute() {
		
		if (the_source != null) {
		   if (the_source.getBinding() != null && the_source.getBinding().isVisible()) {
			   JOptionPane.showMessageDialog(null, "The unit is connected !","Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
			   return false;
		   }
		   HComponent c = (HComponent) the_source.getConfiguration();
		 /*  if (c.hasFreeVariables()) {
			   JOptionPane.showMessageDialog(null, "The inner component has free type variables. You must supply them before to lift units.","Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
			   return false;
		   }
		   */
		   
		}
				
		return true;
	}

	public void setBindingTarget(IBindingTarget bt) {
		this.bt = bt;
	}

	public IBindingTarget getBindingTarget() {
		return bt;
	}



}
