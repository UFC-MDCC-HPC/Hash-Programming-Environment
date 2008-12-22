package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import hPE.frontend.base.figures.LinkToInterfaceFigure;
import hPE.frontend.base.model.HLinkToInterface;

import java.beans.PropertyChangeListener;


public class LinkToInterfaceEditPart extends AbstractConnectionEditPart implements PropertyChangeListener {

	protected void createEditPolicies() {
		
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		

	}
	
	protected IFigure createFigure() {
		
		return new LinkToInterfaceFigure();
		
	}
	
	public void activate() {
        if (!isActive()) 
        	((HLinkToInterface) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HLinkToInterface) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
//     	if (ev.getPropertyName().equals(HLinkToInterface.SHOW_INTERFACE)) this.refreshSourceConnections();
//	    if (ev.getPropertyName().equals(HLinkToInterface.HIDE_INTERFACE)) this.refreshSourceConnections();
		if (ev.getPropertyName().equals(HLinkToInterface.PROPERTY_COLOR)) {
			this.refresh();
			this.refreshSourceConnections();
			this.refreshTargetConnections();
		}
	}
	
	public void refreshVisuals() {
        HLinkToInterface link_mod = (HLinkToInterface) getModel();
        LinkToInterfaceFigure link_fig = (LinkToInterfaceFigure) getFigure();
        
        link_fig.setForegroundColor(link_mod.getWhich_interface().getColor());
        
	}

}
