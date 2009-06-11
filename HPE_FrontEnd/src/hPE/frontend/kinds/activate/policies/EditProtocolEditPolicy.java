package hPE.frontend.kinds.activate.policies;

import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;



public class EditProtocolEditPolicy extends ComponentEditPolicy {

	public EditProtocolEditPolicy() {
		super();
		
	}
	
private static final String
      SHOW_PROTOCOL_REQUEST = "Show Protocol",  //$NON-NLS-1$
      HIDE_PROTOCOL_REQUEST = "Hide Protocol";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	Object o = getHost().getModel();
	
	HActivateInterface i;
	
	if (o instanceof HActivateInterface) 	
	   i = (HActivateInterface) getHost().getModel();
	else 
       i = (HActivateInterface) ((HProtocol) getHost().getModel()).getInterface();
	
	
	if (SHOW_PROTOCOL_REQUEST.equals(request.getType()))
		return new ShowProtocolCommand(i);
	else if (HIDE_PROTOCOL_REQUEST.equals(request.getType()))
		return new HideProtocolCommand(i);
	return 
	    super.getCommand(request);
	
}


static class ShowProtocolCommand extends Command {

	HActivateInterface the_interface;
	
	public ShowProtocolCommand(HActivateInterface the_interface) {
		super();
		this.the_interface = the_interface;
	}

	public void execute() {
		
/*		HProtocol protocol = new HProtocol(the_interface);
		HSeqAction action = new HSeqAction(null,protocol);
/*		HAltAction action_1 = new HAltAction(null,action);
		HParAction action_2 = new HParAction(null,action);
		HDoAction  action_3 = new HDoAction(null,action);
		HDoAction  action_4 = new HDoAction(null,action);
		HAction   action_11 = new HAction(null,action_1);
		HAction   action_12 = new HAction(null,action_1);
		HDoAction action_13 = new HDoAction(null,action_1);
		HAction   action_21 = new HAction(null,action_2);
		HAction   action_22 = new HAction(null,action_2);
		HDoAction action_23 = new HDoAction(null,action_2); */

		
		/* protocol.getBounds().setSize(200,500);		
		action.getBounds().setSize(120,450);
/*		action_1.getBounds().translate(10,10);
		action_1.getBounds().setSize(100,120);
		action_2.getBounds().translate(10,180);
		action_2.getBounds().setSize(100,120);
		action_3.getBounds().translate(10,350);
		action_3.getBounds().setSize(30,30);
		action_4.getBounds().translate(10,400);
		action_4.getBounds().setSize(30,30); 
		
		
		
		action_11.getBounds().translate(20,50);
		action_12.getBounds().translate(50,50);
		action_13.getBounds().translate(80,50);
		
		action_21.getBounds().translate(20,220);
		action_22.getBounds().translate(50,220);
		action_23.getBounds().translate(80,220);
		
		action_1.setRepeat(true);
		action_4.setRepeat(true);
		
		*/
			
		the_interface.showProtocol();
	}
	
	public void undo () {
        the_interface.hideProtocol();
	}
	
	public void redo () {
	    execute();	
	}
	
}

static class HideProtocolCommand extends Command {

	HActivateInterface the_interface;
	
	public HideProtocolCommand(HActivateInterface the_interface) {
		super();
		this.the_interface = the_interface;
	}

	public void execute() {
		the_interface.hideProtocol();
		
		
	}
	
	public void undo () {
        the_interface.showProtocol();
	}
	
	public void redo () {
	    execute();	
	}

}


}
