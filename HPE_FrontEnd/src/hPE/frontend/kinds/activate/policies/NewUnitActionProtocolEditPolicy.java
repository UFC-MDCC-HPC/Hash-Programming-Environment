package hPE.frontend.kinds.activate.policies;

import java.util.Map;
import java.util.Set;

import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class NewUnitActionProtocolEditPolicy extends ComponentEditPolicy {

	public NewUnitActionProtocolEditPolicy() 
	{
		super();		
	}
	
public static final String
      NEW_UNIT_ACTION_REQUEST = "New Unit Action";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object i = getHost().getModel();
	
	HActivateInterface activate_interface =  (i instanceof HActivateInterface) ? (HActivateInterface) i : null;	
	
	
	if (NEW_UNIT_ACTION_REQUEST.equals(request.getType()) && activate_interface != null)
		return new NewUnitActionCommand(activate_interface);
	else 
		return super.getCommand(request);
	
}


static class NewUnitActionCommand extends Command {

	private HActivateInterface activate_interface = null;

	
	public NewUnitActionCommand(HActivateInterface protocol) 
	{
		super();
		
		this.activate_interface = protocol;
		
	}

	
	public void execute() 
	{
		Map<String, HProtocolChoice> actions = activate_interface.getActions();
		Set<String> names = actions.keySet();
		String fresh_action_name = null;
		Integer k = 0;		
		while (names.contains(fresh_action_name = "action_" + k)) k++;
		activate_interface.newAction(fresh_action_name, new HProtocolChoice(fresh_action_name));
	}
	
	public void undo () 
	{
      execute();
	}
	
	public void redo () 
	{
	    execute();	
	}
	
}



}
