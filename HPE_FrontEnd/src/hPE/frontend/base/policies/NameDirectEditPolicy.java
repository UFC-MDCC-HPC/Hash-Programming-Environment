package hPE.frontend.base.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import hPE.frontend.base.commands.NameUpdatingCommand;
import hPE.frontend.base.figures.INameEditableFigure;
import hPE.frontend.base.model.HNamed;

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
