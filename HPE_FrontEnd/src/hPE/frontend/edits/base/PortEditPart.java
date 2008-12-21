package hPE.frontend.edits.base;

import hPE.frontend.edits.policies.base.SetSliceNameEditPolicy;
import hPE.frontend.edits.policies.base.ShowInterfaceEditPolicy;
import hPE.frontend.edits.policies.base.UnitFlowLayoutEditPolicy;
import hPE.frontend.figures.base.PortFigure;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HPort;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;


public abstract class PortEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {

	protected void createEditPolicies() {
		
		HInterface model = (HInterface) getParent().getModel();
		HPort port = (HPort) getModel();
		
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new ShowInterfaceEditPolicy());
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
/*		if (!(model instanceof HApplicationInterface)) {
		    this.installEditPolicy("Set Port In", new SetPortInEditPolicy());
		    this.installEditPolicy("Set Port Out", new SetPortOutEditPolicy());
			this.installEditPolicy("Private Port",new PrivatePortEditPolicy());			
		} else {
			port.setPrivate(true);
		}*/
		this.installEditPolicy("Set Slice Name", new SetSliceNameEditPolicy());

	}
	
	public List getModelTargetConnections() {
		
		List r = new ArrayList();
		
	/*	IHProvidesPort port = (IHProvidesPort) getModel();
		String o = port.getSlice().toString();
		
		for (HInterfaceSlice a : port.getPortOwners()) {
		   r.add("PortOwnership.".concat(a.toString()).concat(o));
		}  	 	
		
		*/
		
		HPort p = (HPort) getModel();
		for (HInterfaceSlice s : p.getOwners()) {
  		   r.add("PortOwnership.".concat(s.toString()).concat(p.toString()));
		}
		
		
		return r;
	}
	
	protected void refreshVisuals() {
	    
		HInterface i = (HInterface) this.getParent().getModel();
		HPort rp = (HPort) this.getModel();
				
  	    PortFigure rpf = (PortFigure) this.getFigure();
  	    
  	    Rectangle bounds = rp.getBounds().getCopy().setSize(15,15);
  	    bounds.setLocation(i.getBounds().getTranslated(rp.getBounds().getLocation()).getLocation());
  	    
  	    rpf.setPrivate(rp.isPrivate());
  	//    rpf.setIn(rp.getPortIn());
     //   rpf.setOut(rp.getPortOut());  	    
		rpf.setBounds(bounds);
		rpf.setBackgroundColor(((HInterface)rp.getPortType()).getColor());
		rpf.setForegroundColor(ColorConstants.black /* ((HInterface)rp.getPortType()).getColor() */);
	}
		
	
	public void activate() {
        if (!isActive()) 
        	((HPort) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HPort) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		
	//	if (ev.getPropertyName().equals(IHProvidesPort.PROPERTY_LOCATION)) this.refreshVisuals();
	//	if (ev.getPropertyName().equals(IHProvidesPort.PROPERTY_DIRECTION)) this.refreshVisuals();
		if (ev.getPropertyName().equals(HPort.PROPERTY_BOUNDS)) this.refreshVisuals();
	//	if (ev.getPropertyName().equals(IHProvidesPort.PROPERTY_COLOR)) this.refreshVisuals();

			
	}



}
