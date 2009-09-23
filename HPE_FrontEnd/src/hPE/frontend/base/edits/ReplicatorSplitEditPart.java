package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import hPE.frontend.base.figures.ReplicatorSplitFigure;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicatorSplit;
import hPE.frontend.base.model.IPointsToReplicator;
import hPE.frontend.base.policies.SetPermutationEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;

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
		this.installEditPolicy("Set Permutation", new SetPermutationEditPolicy());
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(HReplicatorSplit.PROPERTY_BOUNDS)) { 
			this.refreshVisuals();
		}		
		else if (evt.getPropertyName().equals(HReplicatorSplit.SET_PERMUTATION)) { 
			this.refreshVisuals();
		}
		else if (evt.getPropertyName().equals(HReplicatorSplit.NEW_REPLICATOR)) { 
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
		
        if (model.getPermutation() != null) {
			figure.setBackgroundColor(model.getPermutation().getColor() != ColorConstants.white ? model.getPermutation().getColor() : ColorConstants.gray);
    		Label ff = new Label(" permutation " + model.getPermutation().getNameWithParameters(true, true, true) + " assigned ");
		    Font font = new Font(null, "Arial", 8, SWT.ITALIC);
		    ff.setFont(font); 
		    figure.setToolTip(ff);
        } else {
			figure.setBackgroundColor(ColorConstants.gray);
        	Label ff = new Label(" no permutation assigned ");
        	Font font = new Font(null, "Arial", 8, SWT.NORMAL);
        	ff.setFont(font); 
        	figure.setToolTip(ff);
        }
        	
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
