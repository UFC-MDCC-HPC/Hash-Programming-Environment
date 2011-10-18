package hPE.frontend.base.policies;

import hPE.frontend.base.dialogs.SetParameterDialog;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;

public class SetParameterEditPolicy extends ComponentEditPolicy {

	private static final String SET_PARAMETER_REQUEST = "Set Parameter";

	private static final String UNSET_PARAMETER_REQUEST = "Unset Parameter";

	public SetParameterEditPolicy() {
		super();
	}

	public Command getCommand(Request request) {

		HComponent model = (HComponent) ((AbstractEditPart) getHost())
				.getModel();

		if (SET_PARAMETER_REQUEST.equals(request.getType()))
			return new SetParameterCommand(model);
		else if (UNSET_PARAMETER_REQUEST.equals(request.getType()))
			return new UnsetParameterCommand(model);
		return super.getCommand(request);

	}

	public static class SetParameterCommand extends
			org.eclipse.gef.commands.Command {

		private HComponent model;

		private SetParameterDialog dialog = null;

		private String varName = null;

		private boolean cancel = false;

		public SetParameterCommand(HComponent model) {
			this.model = model;
		}

		public void execute() {

			dialog = SetParameterDialog.getInstance();
			dialog.setModel(model);
			dialog.setVisible(true);

			// BEGIN TODO: EXISTENTIAL TYPE
			// boolean isExistential = this.dialog.isExistential();
			// boolean isUniversal = this.dialog.isUniversal();
			// END TODO: EXISTENTIAL TYPE
		}

		public void undo() {
			if (!cancel) {
				model.setNonAbstract(varName);
				((HComponent) model.getTopConfiguration())
						.invalidateInterfaceNames();
			}
		}

		public void redo() {
			execute();
		}
	}

	public static class UnsetParameterCommand extends
			org.eclipse.gef.commands.Command {

		HComponent model;

		private String varName = null;

		public UnsetParameterCommand(HComponent model) {

			this.model = model;

		}

		public void execute() {

			varName = model.getParameterIdentifier((IComponent) model
					.getTopConfiguration());
			model.setNonAbstract(varName);
			((HComponent) model.getTopConfiguration())
					.invalidateInterfaceNames();

		}

		public void undo() {
			model.setParameter(varName);
			((HComponent) model.getTopConfiguration())
					.invalidateInterfaceNames();
		}

		public void redo() {
			execute();
		}
	}
}
