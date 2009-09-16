package hPE.frontend.base.edits;


import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;


public class PortBindingConnectionEditPart extends AbstractConnectionEditPart {

	protected void createEditPolicies() {
		
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
				
        return;

        
        
	}
	
	protected IFigure createFigure() {
		
		PolylineConnection link = new PolylineConnection();
		
        Label ff = new Label(" is public inner component of ");
		Font font = new Font(null, "Arial", 10, SWT.ITALIC);
		ff.setFont(font);
		link.setToolTip(ff);
		return link;
		
		
	}

	

}
