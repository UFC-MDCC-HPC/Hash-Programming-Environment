package hPE.frontend.edits.policies.base;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import hPE.frontend.commands.base.NameUpdatingCommand;
import hPE.frontend.figures.base.INameEditableFigure;
import hPE.model.base.HNamed;

public class NameDirectEditPolicy extends DirectEditPolicy {

	public NameDirectEditPolicy() {
		super();
	}

	protected Command getDirectEditCommand(DirectEditRequest edit) {
		String labelText = (String)edit.getCellEditor().getValue();
		HNamed named = (HNamed)getHost().getModel();
		NameUpdatingCommand command = new NameUpdatingCommand(named,labelText);
		return command;
	}

	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String)request.getCellEditor().getValue();
		((INameEditableFigure)getHostFigure()).setName(value);
		//hack to prevent async layout from placing the cell editor twice.
		getHostFigure().getUpdateManager().performUpdate();

	}

}
