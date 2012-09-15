
package hPE.frontend.base.commands;


import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.IBindingTarget;
import hPE.frontend.base.model.IHUnit;

import javax.swing.JOptionPane;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

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
            boolean fail = false;
			HComponent configuration = (HComponent) the_unit.getConfiguration();
			if (the_source.getBinding() != null && the_source.getBinding().isVisible()) 
			{
				SplitEntryCommand c = new SplitEntryCommand((HUnit) the_source);
				if (c.canExecute()) 
				{
				  c.execute();
				  the_source = c.getReplica();
				} 
				else 
				{
					fail = true;
				}
			}
			if (!fail)
		      setBindingTarget(configuration.createBinding(the_source,the_unit,where));
			
					
		} catch (HPEAbortException e) {
			String msg = e.getMessage();
			JOptionPane.showMessageDialog(null, msg,"Aborting Operation !", JOptionPane.ERROR_MESSAGE);
		}
	}
		   

	
	
	
	
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
		   if (the_source.getBinding() != null && the_source.getBinding().isVisible() && !the_source.isMultiple()) {
			   JOptionPane.showMessageDialog(null, "The singleton unit is connected !","Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
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
