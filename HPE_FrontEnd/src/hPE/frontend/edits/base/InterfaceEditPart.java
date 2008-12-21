package hPE.frontend.edits.base;

import hPE.frontend.edits.policies.base.ChangeColorEditPolicy;
import hPE.frontend.edits.policies.base.HashGraphicalNodeEditPolicy;
import hPE.frontend.edits.policies.base.NameDirectEditPolicy;
import hPE.frontend.edits.policies.base.OpenSourceEditPolicy;
import hPE.frontend.edits.policies.base.UnitFlowLayoutEditPolicy;
import hPE.frontend.figures.base.ConfigurationNodeFigure;
import hPE.frontend.figures.base.InterfaceFigure;
import hPE.model.base.HInterface;
import hPE.model.base.HLinkToInterface;
import hPE.model.kinds.activate.HActivateInterface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;


public class InterfaceEditPart<ModelType extends HInterface, FigureType extends InterfaceFigure> extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart {

	public InterfaceEditPart() {
		super();
		
	}

	protected IFigure createFigure() {
		
		
		return new InterfaceFigure();
		
	}

	protected void createEditPolicies() {
		
		if (((ModelType) getModel()).isEditable()) {
		   this.installEditPolicy("Change Color", new ChangeColorEditPolicy());
		   this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		} 
 	    if (((ModelType) this.getModel()).getIsEditableSource())
	       this.installEditPolicy("OpenSourceEditPolicy", new OpenSourceEditPolicy());
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		// allow the creation of connections and and the reconnection of connections between Shape instances
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
	
	}
	
	protected void refreshVisuals() {

		ModelType the_interface = (ModelType) getModel();
		InterfaceFigure interface_figure = (InterfaceFigure) getFigure();
        
	    interface_figure.setBounds(the_interface.getBounds());
        interface_figure.setName(the_interface.getName(true,true));
        interface_figure.setBackgroundColor(the_interface.getColor());
        interface_figure.setEditable(the_interface.isEditable());
				
	}
	
	public void activate() {
        if (!isActive()) 
        	((ModelType) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((ModelType) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(ModelType.PROPERTY_BOUNDS)) this.refreshVisuals();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_COLOR)) { 
			this.refresh();
			Iterator ls = ((ModelType) getModel()).getLinksToTheInterface().iterator();
			while (ls.hasNext()) {
				HLinkToInterface l = (HLinkToInterface) ls.next();
				l.notify_new_color();
				l.getLinked().notifyColorChange();
			}
			
		}
		if (ev.getPropertyName().equals(ModelType.REMOVE_INTERFACE))   ((ConfigurationEditPart)this.getParent()).refresh();
		if (ev.getPropertyName().equalsIgnoreCase("labelContents")) this.refreshVisuals();//$NON-NLS-1$ 
		if (ev.getPropertyName().equals(ModelType.INTERFACE_SHOW)) { 
			try {
				((ConfigurationEditPart)this.getParent()).refresh();
			    this.refreshTargetConnections(); 
			} catch (Exception e) {
				System.out.print("ee");
			}
			
		}
		if (ev.getPropertyName().equals(ModelType.INTERFACE_HIDE)) { 
			((ConfigurationEditPart)this.getParent()).refresh();
			this.refreshTargetConnections();
		}
		if (ev.getPropertyName().equals(HActivateInterface.SHOW_PROTOCOL)) {			
			((ConfigurationEditPart)this.getParent()).refreshChildren();			
			this.refreshTargetConnections();
		}
		if (ev.getPropertyName().equals(ModelType.PROPERTY_SIGNATURE)) {
			this.refreshChildren();
			this.refresh();
		}
		if (ev.getPropertyName().equals(ModelType.EDITABLE_PROPERTY)) {
		   this.refresh();
		   this.installEditPolicy("Change Color", new ChangeColorEditPolicy());
		   this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		}
		
		if (ev.getPropertyName().equals(ModelType.PROPERTY_EDITABLE_SOURCE)) {
			   this.refresh();
			   if (((ModelType) this.getModel()).getIsEditableSource())
			       this.installEditPolicy("OpenSourceEditPolicy", new OpenSourceEditPolicy());
			}
	}
	
	private DirectEditManager manager;
	
	private void performDirectEdit(){
		if(manager == null)
			manager = new NameUpdatingEditManager(
					this, new NameUpdatingCellEditLocator((ConfigurationNodeFigure)getFigure()));
		manager.show();
	}

	public void performRequest(Request request){
        super.performRequest(request);
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT)
			performDirectEdit();
		return;
	}
	
	public List getModelTargetConnections() {

		List r = new ArrayList();

		ModelType i = (ModelType) getModel();
		
		Iterator b = i.getLinksToTheInterface().iterator();
		
		while (b.hasNext()) {
			HLinkToInterface link = (HLinkToInterface) b.next();
			if (link.visibleInterface()) r.add(link);			
		}

		
		return r;
	}
	
	public List getModelSourceConnections() {

		return new ArrayList();
	}
	
	public List getModelChildren() {
	
		List l = new ArrayList();		
		
		ModelType i = (ModelType) getModel();
		
	    List slices = ((ModelType) i).getSlices();
		l.addAll(slices);
		   
	    return l;
			
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((InterfaceFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((InterfaceFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((InterfaceFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((InterfaceFigure) this.getFigure()).getConnectionAnchor() ;
	}

	

    
}
	
