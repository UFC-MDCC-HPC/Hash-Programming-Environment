package hPE.frontend.edits.base;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import hPE.frontend.edits.policies.base.UnitFlowLayoutEditPolicy;
import hPE.frontend.figures.base.ReplicatorSplitFigure;
import hPE.model.base.HReplicatorSplit;
import hPE.model.base.IPointsToReplicator;

public class ReplicatorSplitEditPart extends AbstractGraphicalEditPart
		implements PropertyChangeListener, NodeEditPart {

	public ReplicatorSplitEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		return new ReplicatorSplitFigure();
	}

	protected void createEditPolicies() {
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(HReplicatorSplit.PROPERTY_BOUNDS)) { 
			this.refreshVisuals();
		}
		
		if (evt.getPropertyName().equals(HReplicatorSplit.NEW_REPLICATOR)) { 
			this.refreshSourceConnections();
		}
		
			
	}
	
	public List getModelSourceConnections() {
		
		List r = new ArrayList();
				
		Collection j = ((IPointsToReplicator) getModel()).getLinksToVisibleReplicators();
		if (j!=null) r.addAll(j);
		
		return r;
	}
	
	
	public List getModelTargetConnections() {
		List r = new ArrayList();
		
		return r;
		
	}
	
	protected void refreshVisuals() {
		
		ReplicatorSplitFigure figure = (ReplicatorSplitFigure) getFigure();
		HReplicatorSplit model = (HReplicatorSplit) getModel();
		
		Rectangle parentBounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();		 
        figure.setBounds(model.getBounds().getTranslated(parentBounds.getLocation()));
		
		
	}

	public void activate() {
        if (!isActive()) 
        	((HReplicatorSplit) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HReplicatorSplit) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((ReplicatorSplitFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((ReplicatorSplitFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((ReplicatorSplitFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((ReplicatorSplitFigure) this.getFigure()).getConnectionAnchor() ;
	} 

}
