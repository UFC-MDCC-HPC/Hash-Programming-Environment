package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import hPE.frontend.base.figures.LinkToReplicatorFigure;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.policies.JoinReplicatorEditPolicy;
import hPE.frontend.base.policies.LiftReplicatorEditPolicy;
import hPE.frontend.base.policies.SplitReplicatorEditPolicy;
import hPE.frontend.base.policies.UnsetReplicatorEditPolicy;

import org.eclipse.draw2d.ColorConstants;
public class LinkToReplicatorEditPart extends AbstractConnectionEditPart implements PropertyChangeListener {

	protected void createEditPolicies() {
		
		// Selection handle edit policy. 
		// Makes the connection show a feedback, when selected by the user.
		this.installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		this.installEditPolicy("UnsetReplicatorEditPolicy", new UnsetReplicatorEditPolicy());
		this.installEditPolicy("SplitReplicatorEditPolicy", new SplitReplicatorEditPolicy());
		this.installEditPolicy("JoinReplicatorEditPolicy", new JoinReplicatorEditPolicy());
		this.installEditPolicy("LiftReplicatorEditPolicy", new LiftReplicatorEditPolicy());

	}
	
	protected IFigure createFigure() {
		
		return new LinkToReplicatorFigure();
		
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(HLinkToReplicator.PROPERTY_INVISIBLE)) this.refreshVisuals();
	}
	
	public void refreshVisuals() {
        HLinkToReplicator link_mod = (HLinkToReplicator) getModel();
        LinkToReplicatorFigure link_fig = (LinkToReplicatorFigure) getFigure();
        
        link_fig.setForegroundColor(ColorConstants.lightGray/* link_mod.getWhich_replicator().getColor() */);
        link_fig.setVisible(!link_mod.isInvisible());
        
	}

	public void activate() {
        if (!isActive()) 
        	((HLinkToReplicator) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HLinkToReplicator) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
}
