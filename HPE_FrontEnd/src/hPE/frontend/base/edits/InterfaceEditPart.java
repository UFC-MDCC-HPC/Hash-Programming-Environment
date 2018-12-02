package hPE.frontend.base.edits;

import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.figures.InterfaceFigure;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.policies.AddReferencesEditPolicy;
import hPE.frontend.base.policies.ChangeColorEditPolicy;
import hPE.frontend.base.policies.CleanSourcesEditPolicy;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.NameDirectEditPolicy;
import hPE.frontend.base.policies.OpenSourceEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.model.HActivateInterface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;


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
		   this.installEditPolicy(AddReferencesEditPolicy.ADD_REFERENCES, new AddReferencesEditPolicy());
		} 
		
 	    if (((ModelType) this.getModel()).getIsEditableSource())
 	    {
	       this.installEditPolicy("OpenSourceEditPolicy", new OpenSourceEditPolicy());
	       this.installEditPolicy("CleanSourcesEditPolicy", new CleanSourcesEditPolicy());
 	    }
 	    
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		// allow the creation of connections and and the reconnection of connections between Shape instances
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
	
	}
	
	protected void refreshVisuals() {

		ModelType the_interface = (ModelType) getModel();
		InterfaceFigure interface_figure = (InterfaceFigure) getFigure();
        
		String name = null;
		try {
		   name = the_interface.getName(true,true);
		}
		catch (Exception e) {
		   name = "ERROR Refreshing Visuals (InterfaceEditPart)"; 
		}
        String name_ = HComponent.breakLines(" " + name + " ");

        Label ff = new Label(name_);
		Font font = new Font(null, "Courier New", 8, SWT.BOLD);
		ff.setFont(font); 

		interface_figure.setBounds(the_interface.getBounds());
        interface_figure.setName(the_interface.getPrimName());
        interface_figure.setBackgroundColor(the_interface.getColor());
        interface_figure.setEditable(the_interface.isEditable());
        interface_figure.setToolTip(ff); interface_figure.getToolTip(); 
				
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
			   {
			       this.installEditPolicy("OpenSourceEditPolicy", new OpenSourceEditPolicy());
			       this.installEditPolicy("CleanSoucesEditPolicy", new CleanSourcesEditPolicy());
			   }
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
		
	    List<HInterfaceSlice> slices = ((ModelType) i).getSlices();
	    for (HInterfaceSlice s : slices) {
	    	if (!((HUnitSlice) s.getCompliantUnitSlices().get(0)).getHiddenSlice())
			   l.add(s);
	    }
		   
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
	
