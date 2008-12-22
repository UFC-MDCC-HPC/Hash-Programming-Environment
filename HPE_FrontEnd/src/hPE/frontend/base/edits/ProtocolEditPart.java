package hPE.frontend.base.edits;

import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.ArrayList;
import org.eclipse.draw2d.*;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;

import hPE.frontend.base.figures.ProtocolFigure;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;
import hPE.frontend.kinds.activate.policies.EditProtocolEditPolicy;

import java.beans.PropertyChangeListener;

public class ProtocolEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {

	public ProtocolEditPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected IFigure createFigure() {

		ProtocolFigure pf = new ProtocolFigure();
		HProtocol p = (HProtocol) getModel();
		FrameBorder border = new FrameBorder("Protocol for Interface ".concat(p.getInterface().getName2())); 
		border.setFont(new Font(null,"Arial",10,SWT.BOLD));
		pf.setBorder(border);

		return pf;
	}

	protected void createEditPolicies() {
		
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
 	    this.installEditPolicy("Edit Protocol", new EditProtocolEditPolicy());
		
	}
	
	public List getModelChildren() {
		
	    HProtocol protocol = ((HProtocol) getModel());
		
		List c = new ArrayList();
		
		if (protocol.getAction() != null) c.add(protocol.getAction());
		
		return c;
	}

	
	protected void refreshVisuals() {
	    
		HProtocol a = (HProtocol) this.getModel();
		
  	    Rectangle parent_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
		
		this.getFigure().setBounds(a.getBounds().getTranslated(parent_bounds.getLocation()));
	}
	
	public void activate() {
        if (!isActive()) 
        	((HProtocol) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HProtocol) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(HProtocol.PROPERTY_BOUNDS)) this.refreshVisuals();
		if (ev.getPropertyName().equals(HProtocol.PROPERTY_ACTION)) { 
			refresh();			
		}
			
	}
	
}
