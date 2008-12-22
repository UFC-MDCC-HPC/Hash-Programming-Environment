package hPE.frontend.base.commands;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitStub;
import hPE.frontend.base.model.IBindingTarget;
import hPE.frontend.base.model.IHUnit;


public class LiftUnitCommand extends Command {

	private IHUnit unit;
	
	
	
	public LiftUnitCommand(IHUnit unit) {
		super();
		this.unit = unit;				
	}

	
	public void execute() {

		HComponent c = (HComponent)unit.getConfiguration(); 
		IBindingTarget the_target = (HUnitStub) c.newStubFor((HUnit)unit, false, false, (HComponent)c.getTopConfiguration());
				
		new HBinding(c,the_target,unit);		//TOIDO: setBinding ... antes era new HBinding(c,unit,the_target)

		return;
	}
	
	public void undo () {

	}
	
	public void redo () {

	}
	
	public boolean canExecute() {
		JOptionPane.showMessageDialog(null, "Lifting Unavailable. I am in doubt if it is really necessary ..." ,"Lift Unit !", JOptionPane.INFORMATION_MESSAGE);
		return false;
	}

}
