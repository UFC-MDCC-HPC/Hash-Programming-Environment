package hPE.frontend.base.edits;

import hPE.frontend.base.figures.NodeFigure;
import hPE.frontend.base.model.IPropertyChangeListener;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.ShowInterfaceEditPolicy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;



public class BindingEndsEditPart extends AbstractGraphicalEditPart implements
		PropertyChangeListener , NodeEditPart   {

	public BindingEndsEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {
		// TODO Auto-generated method stub
		return null;
	}

	protected void createEditPolicies() {
		
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new ShowInterfaceEditPolicy());
		
		// allow the creation of connections and and the reconnection of connections between Shape instances
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());


	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((NodeFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((NodeFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((NodeFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((NodeFigure) this.getFigure()).getConnectionAnchor() ;
	} 

	public void activate() {
        if (!isActive()) 
        	((IPropertyChangeListener) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((IPropertyChangeListener) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
	}
}

	

