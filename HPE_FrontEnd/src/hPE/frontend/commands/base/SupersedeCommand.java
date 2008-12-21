package hPE.frontend.commands.base;

import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.base.HComponent;

import javax.swing.JOptionPane;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

public class SupersedeCommand extends Command {

	private HComponent source, target;
	
	public SupersedeCommand(HComponent source, HComponent target) {
		super();
		this.source = source;
		this.target = target;
	}

	
	public void execute() {

			
	    HComponent.supersede2(target, source);
	    try {
			source.updatePorts();
		} catch (HPEAbortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return;
	}
	
	public void undo () {

	}
	
	public void redo () {
		execute();
	}
	
	public boolean canExecute() {
        HComponent topC = (HComponent) target.getTopConfiguration();

        boolean cond1 = source.isSubTypeOf(target) && source.getExposed() == target.getExposed() && topC.isAbstractConfiguration(); 
        boolean cond2 = cond1 && source.getName2().equals(target.getName2());
        //boolean cond3 = ((source.isParameter() && target.isParameter() && source.getSupplied() == null && target.getSupplied() == null && 
        //		source.getVariableName().equals(target.getVariableName())) || (!source.isParameter() && !target.isParameter()));
        boolean cond3 = cond2 && !(source.isParameter() && target.isParameter() && !source.getVariableName().equals(target.getVariableName()));
        boolean cond4 = cond3 && HComponent.checkConsistencyOfUnitsInSuperseding(target, source) && HComponent.checkConsistencyOfCardinalityInSuperseding(target,source); 
        

     //   if (c.isParameter() && c_.isParameter() && c.getSupplied() == null && c_.getSupplied() == null && 
      //  		!c.getVariableName().equals(c_.getVariableName()))  return false;
        
		return cond1 && cond2 && cond3 && cond4;

		       //&& (((HComponent)target.getTopConfiguration()).getWhoItImplements() == target.getTopParentConfigurations().get(0))
		       //&& (((HComponent)source.getTopConfiguration()).getWhoItImplements() == source.getTopParentConfigurations().get(0));
	}

}
