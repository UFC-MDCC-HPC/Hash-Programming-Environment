package hPE.frontend.base.edits;

import hPE.frontend.base.figures.PortFigure;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HPort;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.policies.SetSliceNameEditPolicy;
import hPE.frontend.base.policies.ShowInterfaceEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;


public abstract class PortEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {

	protected void createEditPolicies() {
		
		HHasExternalReferences model = (HHasExternalReferences) getParent().getModel();
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
  	    
  	    String visibility = rp.isPrivate() ? "private" : "public";
  	    
  	    
        String uRef;
        String cRef;
        try {
            IHUnit u = (IHUnit) ((HUnitSlice)rp.getInterfaceSlices().get(0).getCompliantUnitSlices().get(0)).getComponentEntry();
            uRef = u.getName2();
            cRef = u.getConfiguration().getRef();
        } catch (NullPointerException e) {
            uRef = "?";
            cRef = "?";
        }
  	    
		Label ff = new Label(" " + visibility + " slice " + rp.getName()+ " : " + cRef + "." + uRef + " ");
		
		Font font = new Font(null, "Arial", 10, SWT.ITALIC);
		ff.setFont(font);
		
		rpf.setToolTip(ff);

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
