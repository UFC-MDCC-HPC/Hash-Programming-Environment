package hPE.frontend.base.commands;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.model.HComponent;

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

			
	    HComponent.supersede3(target, source, false);
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
	
	public boolean canExecute() 
	{
		
		HComponent source = (HComponent) (this.source.getSupplier() == null ? this.source : this.source.getSupplier());
		HComponent target  = (HComponent) (this.target.getSupplier() == null ? this.target : this.target.getSupplier());
		
        HComponent topC = (HComponent) target.getTopConfiguration();
    	String varSource = source.getVariableName(topC);
    	String varTarget = target.getVariableName(topC);
    	varSource = !varSource.contains("@") ? varSource : varSource.substring(0,varSource.indexOf('@')); 
    	varTarget = !varTarget.contains("@") ? varTarget : varTarget.substring(0,varTarget.indexOf('@'));

        boolean cond1 = source.isSubTypeOf(target) && this.source.isPublic() == this.target.isPublic() && topC.isAbstractConfiguration(); 
        boolean cond2 = cond1 && this.source.getName2().equals(this.target.getName2());
        boolean cond3 = cond2 && !(source.isParameter() && target.isParameter() && !varSource.equals(varTarget));
        boolean cond4 = cond3 && HComponent.checkConsistencyOfUnitsInSuperseding(this.target, this.source) && HComponent.checkConsistencyOfCardinalityInSuperseding(target,source); 
        
        if (!cond2) {
        	
       	  //JOptionPane.showMessageDialog(null,
    		//	  "The fused inner components have different names ("+source.getName2() + " e " +target.getName2()+ "). " +
    	//		  "\nRename the inner components to make possible this operation.", 
    		//	  "Fusion Error", 
    		//	  JOptionPane.ERROR_MESSAGE);
        } else if (!cond3) {
        	String message = null;
        	if (source.getSupplier() == null && target.getSupplier() == null) {
        		message = "\nIt is still possible to rename one of these variables to make possible this operation.";
        	} else {
        		message = "\nHowever, since one of such context variables has been supplied before, the variables cannot be renamed. " + 
        		          "\nBy consequence, it is not possible to complete this operation.";
        	}
            JOptionPane.showMessageDialog(null,
        			  "The fused inner components are parameters bounded by different context variables ("+varSource+ " e " +varTarget+ "). " +
        			  message, 
        			  "Fusion Error", 
        			  JOptionPane.ERROR_MESSAGE);
        }
                
		return cond1 && cond2 && cond3 && cond4;

		       //&& (((HComponent)target.getTopConfiguration()).getWhoItImplements() == target.getTopParentConfigurations().get(0))
		       //&& (((HComponent)source.getTopConfiguration()).getWhoItImplements() == source.getTopParentConfigurations().get(0));
	}

}
