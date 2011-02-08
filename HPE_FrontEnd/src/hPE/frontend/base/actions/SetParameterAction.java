package hPE.frontend.base.actions;

import hPE.HPEPlugin;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;


public class SetParameterAction extends SelectionAction {

	private static final String
	SET_PARAMETER_REQUEST = "Set Parameter",
	UNSET_PARAMETER_REQUEST = "Unset Parameter";  //$NON-NLS-1$

	public static final String
	SET_PARAMETER = "Set Parameter",
	UNSET_PARAMETER = "Unset Parameter";  //$NON-NLS-1$

	Request request;
	boolean set;

	public SetParameterAction(IWorkbenchPart part, boolean set) {
		super(part);
		if (set) {
			request = new Request(SET_PARAMETER_REQUEST);
			setText("Set Parameter");
			setId("Set Parameter");
			setToolTipText("Set Parameter");
			setImageDescriptor(
					ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
			setHoverImageDescriptor(getImageDescriptor());
		} else {
			request = new Request(UNSET_PARAMETER_REQUEST);
			setText("Unset Parameter");
			setId("Unset Parameter");
			setToolTipText("Unset Parameter");
			setImageDescriptor(
					ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
			setHoverImageDescriptor(getImageDescriptor());
		}

		this.set = set;
	}

	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		for (int i=0; i<parts.size(); i++){
			Object o = parts.get(i);
			if (!(o instanceof EditPart)) return false;
			EditPart part = (EditPart)o;
			if (!(part.getModel() instanceof HComponent)) return false;
			HComponent x = (HComponent) part.getModel();
			if (x.isSuperType()) return false;
			if (x.isTopConfiguration()) return false;
			HComponent topConfig = (HComponent) x.getTopConfiguration();
			//if (topConfig instanceof HApplicationComponent) return false;
			if (set && x.isParameter() /*&& x.getSupplied()==null*/) return false;
			else if (!set && !(x.isParameter() && x.getSupplier()==null)) return false;

			if (!x.isDirectSonOfTheTopConfiguration()) return false;

			if (topConfig.getWhoItImplements() == x) return false;

			if (!topConfig.isAbstractConfiguration() && topConfig.getWhoItImplements() == null) return false;

			Iterator<HInterface> is = x.getInterfaces().iterator();
			//            while (is.hasNext()) if (!is.next().noSources()) return false;


		}
		return true;
	}

	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Set/Unset Parameter");//$NON-NLS-1$
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			Command c =  part.getCommand(request);
			cc.add(c);
		}
		return cc;
	}

	@Override
	public void run() {
		execute(getCommand());
	}


}
