package hPE.frontend.kinds.activate.commands;

import org.eclipse.gef.commands.Command;

import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;

import org.eclipse.draw2d.geometry.Rectangle;

public class CombineActionsCommand extends Command {

	HCombinatorAction parent_action, combinator_action;
	HAction action;
	
	public CombineActionsCommand(HCombinatorAction parent_action, 
			                     HAction action) {
		super();
		this.parent_action = parent_action;
		this.action = action;
	}

	public void setCombinator(HCombinatorAction combinator_action) {
		this.combinator_action = combinator_action;
	}
	
	int index_of_action;
	Rectangle bounds_of_action;
	
	public void execute() {

		if (!parent_action.getActions().contains(combinator_action)) {
			parent_action.addAction(combinator_action);
		}
		
		index_of_action = parent_action.getActions().indexOf(action);
		bounds_of_action = action.getBounds().getCopy();
		parent_action.removeAction(action);
		//combinator_action.addAction(action);
		action.setCombinatorAction(combinator_action);
		combinator_action.adjustBoundsToNewChild(action);
		parent_action.sinalizeRefresh();
		
		return;
	}
	
	public void undo () {

		
		parent_action.addAction(index_of_action,action);
		action.setCombinatorAction(parent_action);
		action.setBounds(bounds_of_action);
		combinator_action.removeAction(action);
		// parent_action.sinalizeRefresh();
		if (combinator_action.getActions().isEmpty()) {
			parent_action.removeAction(combinator_action);
		}
		
	}
	
	public void redo () {
		execute();
	}
	
	public boolean canExecute() {
		return true;
	}

}
