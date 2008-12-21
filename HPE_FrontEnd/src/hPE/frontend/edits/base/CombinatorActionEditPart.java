package hPE.frontend.edits.base;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.edits.policies.kinds.activate.LiftActionEditPolicy;
import hPE.frontend.edits.policies.kinds.activate.UnnestActionEditPolicy;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HActionEntry;
import hPE.model.protocol.kinds.activate.HActionExit;
import hPE.model.protocol.kinds.activate.HCombinatorAction;

import org.eclipse.gef.EditPart;


public abstract class CombinatorActionEditPart extends ActionEditPart {

	public CombinatorActionEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	abstract protected IFigure createFigure();
	
	protected void createEditPolicies() {
   	    super.createEditPolicies();
	    this.installEditPolicy("Lift Action", new LiftActionEditPolicy());		
	    this.installEditPolicy("Unnest Action", new UnnestActionEditPolicy());		
	}
	
	public List getModelChildren() {
		
		List c = new ArrayList();
		
	    HCombinatorAction action = ((HCombinatorAction) getModel());
	    
	    c.add(action.getCombinatorEntry());
	    c.addAll(action.getActions());
	    c.add(action.getCombinatorExit());
	    
	    
	    return c;
		
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		
		super.propertyChange(ev);
		
		if (ev.getPropertyName().equals(HAction.PROPERTY_BOUNDS)) { 
			this.recursivelyRefreshChildren(this);
		}
		
		if (ev.getPropertyName().equals(HCombinatorAction.UPDATE_ACTIONS)) { 
			this.refresh();
			recursivelyRefreshChildren(this);
		} else
		if (ev.getPropertyName().equals(HCombinatorAction.UNFOLD_ACTION)) { 
			this.refresh();
			recursivelyRefreshChildren(this);
			
		} else
		if (ev.getPropertyName().equals(HCombinatorAction.LIFT_ACTION)) { 
			this.refresh();
			recursivelyRefreshChildren(this);
		}
	}

	private void recursivelyRefreshChildren(EditPart part) {

		for (Object ee : part.getChildren()) {
			EditPart e = (EditPart) ee;
			e.refresh();
			recursivelyRefreshChildren(e);
		}  
		
		
	}
	
}
