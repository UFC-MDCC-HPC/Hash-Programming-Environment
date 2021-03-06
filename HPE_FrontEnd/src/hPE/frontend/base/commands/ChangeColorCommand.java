package hPE.frontend.base.commands;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.IHasColor;

import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public class ChangeColorCommand extends Command {

	IHasColor the;
	Color old_color, new_color;
	
	public ChangeColorCommand(IHasColor the) {
		super();
		this.the = the;
		old_color = the.getColor();
	}


	private ColorDialog colorDialog;
	
	public void setDialog(ColorDialog colorDialog) {
		this.colorDialog = colorDialog;
	}
	
	public void execute() {
		RGB color = colorDialog.open();
	    this.new_color = new Color(null,color); 
		the.setColor(new_color);
		
		return;
	}
	
	public void undo () {
		the.setColor(old_color);
	}
	
	public void redo () {
		the.setColor(new_color);		
	}
	
	public boolean canExecute() {
		if (the instanceof HInterface) {
		   	if (!((HInterface) the).isEditable()) return false;
		}
		return true;
	}

}
