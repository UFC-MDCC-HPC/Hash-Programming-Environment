package hPE.frontend.edits.base;


import hPE.frontend.figures.base.ProvidesPortFigure;
import hPE.model.base.HPort;

import java.beans.PropertyChangeEvent;
import java.util.Iterator;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;



public class ProvidesPortEditPart extends PortEditPart {

	public ProvidesPortEditPart() {
		super();
		
	}
	
	protected void createEditPolicies() {
		super.createEditPolicies();
 		
	}	

	protected IFigure createFigure() {

		ProvidesPortFigure pf = new ProvidesPortFigure();

		return pf;
	}
	
	protected void refreshVisuals() {
	   super.refreshVisuals();	
	   //IHProvidesPort pp = (IHProvidesPort) getModel();
	   HPort pp = (HPort)getModel();
	   ProvidesPortFigure ppf = (ProvidesPortFigure) getFigure();
	   if (pp.isPrivate()) 
		   ppf.setBackgroundColor(ColorConstants.gray);
	}

	public void propertyChange(PropertyChangeEvent ev) {
		super.propertyChange(ev);
		
/*		if (ev.getPropertyName().equals(IHProvidesPort.PROPERTY_BINDING)) {
			this.refresh();
			EditPart parent = this.getParent();
			parent.refresh();
			Iterator<EditPart> es = parent.getChildren().iterator();
			while (es.hasNext()) {
				EditPart e = es.next();
				e.refresh();
			}
			
		}
		
		if (ev.getPropertyName().equals(IHProvidesPort.PROPERTY_UNBINDING)) {
			this.refresh();
		}
		
		if (ev.getPropertyName().equals(IHProvidesPort.PROPERTY_PRIVATE)) {
            this.refreshVisuals();
		}
	*/	
	}
		
}
