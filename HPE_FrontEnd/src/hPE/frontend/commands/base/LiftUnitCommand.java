package hPE.frontend.commands.base;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HBinding;
import hPE.model.base.HComponent;
import hPE.model.base.HUnit;
import hPE.model.base.HUnitStub;
import hPE.model.base.IBindingTarget;
import hPE.model.base.IHUnit;


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
