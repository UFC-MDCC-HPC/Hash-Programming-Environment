package hPE.frontend.edits.base;


import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;


public class PortBindingConnectionEditPart extends AbstractConnectionEditPart {

	protected void createEditPolicies() {
		
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
				
        return;

        
        
	}
	
	protected IFigure createFigure() {
		
		PolylineConnection link = new PolylineConnection();
			
		return link;
		
	}

	

}
