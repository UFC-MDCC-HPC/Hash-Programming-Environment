package hPE.frontend.edits.base;

import org.eclipse.gef.NodeEditPart;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import hPE.frontend.commands.base.BindingCreateCommand;
import hPE.frontend.commands.base.SetReplicatorCommand;
import hPE.frontend.edits.policies.base.HashGraphicalNodeEditPolicy;
import hPE.frontend.edits.policies.base.ShowInterfaceEditPolicy;
import hPE.frontend.figures.base.NodeFigure;
import hPE.model.base.HComponent;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IPropertyChangeListener;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;



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

	

