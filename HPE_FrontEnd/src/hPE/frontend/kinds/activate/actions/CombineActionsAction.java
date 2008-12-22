package hPE.frontend.kinds.activate.actions;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

import hPE.frontend.kinds.activate.commands.CombineActionsCommand;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;
import hPE.HPEPlugin;
;

public class CombineActionsAction extends SelectionAction {

	public static final String
		SEQ_ACTIONS_REQUEST = "Seq Actions",
		PAR_ACTIONS_REQUEST = "Par Actions";  //$NON-NLS-1$
	
	public static final String
	    SEQ_ACTIONS = "Seq Actions",
	    PAR_ACTIONS = "Par Actions";  //$NON-NLS-1$
	
	Request request;
	
	public CombineActionsAction(IWorkbenchPart part, String combinator) {
		super(part);
 	    request = new Request(combinator);
	    setText(combinator);
	    setId(combinator);
	    setToolTipText(combinator);
	    setImageDescriptor(
	    ImageDescriptor.createFromFile(HPEPlugin.class,"icons/rectangle24.gif")); //$NON-NLS-1$
	    setHoverImageDescriptor(getImageDescriptor());
	}
	
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty()) return false;
		List parts = getSelectedObjects();
		if (parts.size() > 0) {
		   Object o1 = parts.get(0);
		   if (!(o1 instanceof EditPart)) return false;
		   EditPart part1 = (EditPart) o1;
  		   for (int i=1; i<parts.size(); i++){
				Object o2 = parts.get(i);
				if (!(o2 instanceof EditPart)) return false;
				EditPart part2 = (EditPart)o2;
				if (!((part1.getParent().getModel() instanceof HParAction && 
					   part2.getParent().getModel() instanceof HParAction && 
					   part1.getParent() == part2.getParent()) || 
					   (part1.getParent().getModel() instanceof HSeqAction && 
					    part2.getParent().getModel() instanceof HSeqAction && 
						part1.getParent() == part2.getParent() && request.getType().equals(SEQ_ACTIONS_REQUEST)
						))) return false;
				o1 = o2;
				part1 = part2;
		   }
  		   
  		   if (!(part1.getParent().getModel() instanceof HCombinatorAction)) return false; 
  		   
  		   HCombinatorAction parent_action = (HCombinatorAction) part1.getParent().getModel();
  		   if (parent_action instanceof HSeqAction) {
  			   ArrayList actions = (ArrayList)((ArrayList) parent_action.getActions()).clone();
  			   List indexes = new ArrayList();
  			   EditPart part = (EditPart) parts.get(0);
  			   HAction a = (HAction) part.getModel();
  			   indexes.add(new Integer(actions.indexOf(a)));
  			   int min = actions.indexOf(a);
  			   int max = actions.indexOf(a);
  	  		   for (int i=1; i<parts.size(); i++){
  	  			   part = (EditPart) parts.get(i);
  	  			   a = (HAction) part.getModel();
  	  			   indexes.add(new Integer(actions.indexOf(a)));
  	  			   min = actions.indexOf(a) < min ? actions.indexOf(a) : min;
  	  			   max = actions.indexOf(a) > max ? actions.indexOf(a) : max;
  	  		   }
  	  		   
  	  		   // check if the numbers in indexes are a sequence ... 
  	  		   for (int i=min;i<=max;i++) {
  	  			   if (!indexes.contains(new Integer(i))) return false;
  	  		   }
  		   }
		} else {
			return false;
		}
		
	return true;	
	}
	
	private Command getCommand() {
		List editparts = getSelectedObjects();
		CompoundCommand cc = new CompoundCommand();
		cc.setDebugLabel("Par/Seq actions");//$NON-NLS-1$
		
		HCombinatorAction parent_action = (HCombinatorAction) ((EditPart)editparts.get(0)).getParent().getModel();
		HCombinatorAction action_combinator = null;
		if (request.getType().equals(SEQ_ACTIONS_REQUEST)) 
			action_combinator = new HSeqAction(null,parent_action);
		else if (request.getType().equals(PAR_ACTIONS_REQUEST)) 
			action_combinator = new HParAction(null,parent_action);
		
		for (int i=0; i < editparts.size(); i++) {
			EditPart part = (EditPart)editparts.get(i);
			CombineActionsCommand c = (CombineActionsCommand) part.getCommand(request);
			c.setCombinator(action_combinator);
			cc.add(c);
		}
		return cc;
	}
	
	public void run() {
		execute(getCommand());
	}

	
}
