package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.eclipse.draw2d.IFigure;

import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HActionEntry;
import hPE.frontend.kinds.activate.model.protocol.HActionExit;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.policies.LiftActionEditPolicy;
import hPE.frontend.kinds.activate.policies.UnnestActionEditPolicy;

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
