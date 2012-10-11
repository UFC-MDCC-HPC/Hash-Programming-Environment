package hPE.frontend.kinds.activate.actions;

import hPE.HPEPlugin;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;
import hPE.frontend.kinds.activate.policies.ChangeOrderSEQProtocolEditPolicy;
import hPE.frontend.kinds.activate.policies.ChangeOrderSEQProtocolEditPolicy.ChangeOrderSEQCommand;
import hPE.xml.component.ProtocolType;

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

public class ChangeOrderSEQProtocolAction extends SelectionAction {

	private static final String
		CHANGE_ORDER_SEQ_REQUEST = "Change Order";  //$NON-NLS-1$
	
	public static final String
        CHANGE_ORDER_SEQ = "Change Order";   //$NON-NLS-1$
	
	Request request;
	
	
	public ChangeOrderSEQProtocolAction(IWorkbenchPart part) {
		super(part);
			request = new Request(CHANGE_ORDER_SEQ_REQUEST);
			setText(CHANGE_ORDER_SEQ);
			setId(CHANGE_ORDER_SEQ);
			setToolTipText(CHANGE_ORDER_SEQ);
			setImageDescriptor(
			ImageDescriptor.createFromFile(HPEPlugin.class,"util/icons/rectangle24.gif")); //$NON-NLS-1$
			setHoverImageDescriptor(getImageDescriptor());
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		if (parts.size() != 2) return false;
		Object o0 = ((EditPart)parts.get(0)).getModel();
		Object o1 = ((EditPart)parts.get(1)).getModel();
		if (o0 instanceof IProtocol && o1 instanceof IProtocol)
		{
			IProtocol p0 = (IProtocol) o0;
			IProtocol p1 = (IProtocol) o1;
			if (p1.getParentCombinator() != p0.getParentCombinator()) return false;
			if (p1.getParentCombinator().getCombinator() != IProtocolCombinator.SEQ_COMBINATOR) return false;
		}
		else 
			return false;
		
		return true;
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Change Order Action !");//$NON-NLS-1$
		EditPart part0 = (EditPart)editparts.get(0);
		EditPart part1 = (EditPart)editparts.get(1);
		ChangeOrderSEQProtocolEditPolicy.ChangeOrderSEQCommand command = (ChangeOrderSEQProtocolEditPolicy.ChangeOrderSEQCommand) part0.getCommand(request);
		command.setOther(part1.getModel());
		cc.add(command);
		
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
