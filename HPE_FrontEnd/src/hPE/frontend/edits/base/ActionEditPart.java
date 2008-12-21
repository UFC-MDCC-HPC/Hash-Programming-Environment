package hPE.frontend.edits.base;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import hPE.frontend.edits.policies.base.CutBranchEditPolicy;
import hPE.frontend.edits.policies.base.UnitFlowLayoutEditPolicy;
import hPE.frontend.edits.policies.kinds.activate.AltAbsorptionEditPolicy;
import hPE.frontend.edits.policies.kinds.activate.CombineActionsEditPolicy;
import hPE.frontend.edits.policies.kinds.activate.InterleaveActionsEditPolicy;
import hPE.frontend.edits.policies.kinds.activate.RepeatFusionEditPolicy;
import hPE.frontend.edits.policies.kinds.activate.UnfoldActionEditPolicy;
import hPE.frontend.figures.base.ActionFigure;
import hPE.frontend.figures.base.NodeFigure;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;

import org.eclipse.gef.NodeEditPart;

public class ActionEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart  {

	public ActionEditPart() {
		super();
	}

	protected IFigure createFigure() {
		ActionFigure f = new ActionFigure();
		f.setRepeat(((HAction) getModel()).getRepeatDepth());
		return f;
	}

	protected void createEditPolicies() {
		
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
 	    this.installEditPolicy("Unfold Action", new UnfoldActionEditPolicy());
 	    this.installEditPolicy("Seq/Par Actions", new CombineActionsEditPolicy());
 	    this.installEditPolicy("Interleave Actions", new InterleaveActionsEditPolicy());
 	    this.installEditPolicy("Cut Branch", new CutBranchEditPolicy());
 	    this.installEditPolicy("Alt Absorption", new AltAbsorptionEditPolicy());
 	    this.installEditPolicy("Repeat Fusion", new RepeatFusionEditPolicy());

	}
	
	
	public List getModelSourceConnections() {

		HAction model = (HAction) this.getModel();
		HCombinatorAction ancestor_action = model.getActionCombinator();
		List c = new ArrayList();
		
		if (ancestor_action != null) { 
			Object l = ancestor_action.getInnerActionSourceConnectionID(model);
			if (l!=null) c.add(l);
		}  
		
		if (model.isRepeat()) {
			for (int i=0;i<model.getRepeatDepth();i++) {
			     c.add("REPEAT.".concat((new Integer(i)).toString()).concat(".").concat(model.getLabel()));
			}
		}
		
		return c;
	}
	
	public List getModelTargetConnections() {

		HAction model = (HAction) this.getModel();
		HCombinatorAction ancestor_action = model.getActionCombinator();
		List c = new ArrayList();
		
		if (ancestor_action != null) { 
			Object l = ancestor_action.getInnerActionTargetConnectionID(model);
			if (l!=null) c.add(l);
		}  

		if (model.isRepeat()) {
			for (int i=0;i<model.getRepeatDepth();i++) {
			     c.add("REPEAT.".concat((new Integer(i)).toString()).concat(".").concat(model.getLabel()));
			}
		}
		
		return c;
	}
	
	protected void refreshVisuals() {
    
		HAction a = (HAction) this.getModel();
		ActionFigure f = (ActionFigure) this.getFigure();
		
  	    Rectangle parent_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
  	    
		f.setBounds(a.getBounds().getTranslated(parent_bounds.getLocation()));
		
		
	}
	
	public void activate() {
        if (!isActive()) 
        	((HAction) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HAction) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		
		if (ev.getPropertyName().equals(HAction.PROPERTY_BOUNDS)) { 
			this.refreshVisuals();
			this.refreshChildren();
		}
			
		if (ev.getPropertyName().equals(HAction.PROPERTY_PROTOCOL)) { 
			this.refresh();
		}
		
		if (ev.getPropertyName().equals(HAction.PROPERTY_REPEAT)) { 
			this.refreshVisuals();
		}
		
		
		
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
	    
		Object conn_model = connection.getModel();
		if (conn_model instanceof String) {
			if (((String)conn_model).startsWith("REPEAT")) {
				String s = ((String)conn_model);				
				String n1 = s.substring(s.indexOf(".")+1);
				Integer n2 = new Integer(n1.substring(0,n1.indexOf(".")));
				
				return ((ActionFigure) this.getFigure()).getConnectionAnchorRepeatExit(n2.intValue());
			}
		}
		
		return ((ActionFigure) this.getFigure()).getConnectionAnchorStart() ;
		
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		
		Object conn_model = connection.getModel();
		if (conn_model instanceof String) {
			if (((String)conn_model).startsWith("REPEAT")) {
				String s = ((String)conn_model);				
				String n1 = s.substring(s.indexOf(".")+1);
				Integer n2 = new Integer(n1.substring(0,n1.indexOf(".")));
				return ((ActionFigure) this.getFigure()).getConnectionAnchorRepeatEnter(n2.intValue());
			}
		}
		
		return  ((ActionFigure) this.getFigure()).getConnectionAnchorEnd();
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return null ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return null ;
	}
	
}
