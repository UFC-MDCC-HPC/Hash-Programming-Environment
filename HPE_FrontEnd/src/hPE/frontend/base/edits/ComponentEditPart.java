 
package hPE.frontend.base.edits;

import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.figures.ComponentFigure;
import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.IReplicatedElement;
import hPE.frontend.base.policies.ChangeVariableNameEditPolicy;
import hPE.frontend.base.policies.ExposedEditPolicy;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.ImplementsEditPolicy;
import hPE.frontend.base.policies.InheritsFromEditPolicy;
import hPE.frontend.base.policies.NameDirectEditPolicy;
import hPE.frontend.base.policies.RemoveElementEditPolicy;
import hPE.frontend.base.policies.SetParameterEditPolicy;
import hPE.frontend.base.policies.SupplyParameterEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;


public class ComponentEditPart<ModelType extends HComponent,
                               FigureType extends ComponentFigure> extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart {

	public ComponentEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new ComponentFigure();
	}

	protected void createEditPolicies() {
		
		// this.installEditPolicy("Change Color", new ChangeColorEditPolicy());
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		// allow the creation of connections and and the reconnection of connections between Shape instances
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new RemoveElementEditPolicy());
	    this.installEditPolicy("Set Parameter", new SetParameterEditPolicy());
	    this.installEditPolicy("Supply Parameter", new SupplyParameterEditPolicy());
	    this.installEditPolicy("Change Variable Name", new ChangeVariableNameEditPolicy());
	    this.installEditPolicy("Inherits From", new InheritsFromEditPolicy());
	    this.installEditPolicy("Implements", new ImplementsEditPolicy());
	    this.installEditPolicy("Exposed Yes/No", new ExposedEditPolicy());
	  //  this.installEditPolicy("Fuse Components", new FuseComponentsEditPolicy());

	}
	
	protected void refreshVisuals() {
		
		ModelType component = (ModelType) getModel();
		FigureType component_figure = (FigureType) getFigure();
		String name = ""; // component.getName2() + ": ";
				
		boolean showBounds = component.isDirectSonOfTheTopConfiguration();
		boolean showParId  = true; //component.isDirectSonOfTheTopConfiguration();
		
        if (component.isParameter() && component.getSupplied()==null) { 
    	    component_figure.setAbstract();
    	    HComponent topC = (HComponent) component.getTopConfiguration();
    	    String varName = component.getVariableName(topC);
    	    showBounds = showBounds && ((!topC.getVars().contains(varName)) || component.isTopConfiguration());
    	    if (varName.equals("?")) {
    	        name += (showParId ? component.getParameterIdentifier((IComponent)component.getConfiguration()) : "") + (showBounds ? " = " + component.getVariableName(topC) +  ": " + component.getNameWithParameters(false, showBounds, showParId) : "");
    	    }
    	    else {
    	    	name += component.getVariableName(topC) + (showBounds ?  ": " + component.getNameWithParameters(false, showBounds, showParId) : "");
    	    }
        }
        else if (component.isParameter() && component.getSupplied()!=null) { 
        	component_figure.setNonAbstract();
            name /*+ component.getParameterIdentifier((IComponent)component.getConfiguration()) + " is " */ += component.getNameWithParameters(false, showBounds, showParId);
        } else {
        	component_figure.setNonAbstract();
            name += component.getNameWithParameters(false, showBounds, showParId);
        }

        String name_ = breakLines(" " + name + " ");
        
		Label ff = new Label(" " + name_ + " ");
		Font font = new Font(null, "Arial", 10, SWT.BOLD);
		ff.setFont(font); 

		component_figure.setPort(!component.isDirectSonOfTheTopConfiguration());
        component_figure.setBounds(calculateBounds(component));
        component_figure.setName(component.getRef() + (component.hasFreeVariables() ? " [?]" : ""));
		component_figure.setToolTip(ff);
        component_figure.setRecursive(component.isRecursive());
        component_figure.setBackgroundColor(component.getColor());
        component_figure.setIsSuperType(component.isSuperType());
        component_figure.setExposed(component.getExposed());
				
	}
	
	private String breakLines(String name) {

		String name_="";
		
		int level = 0;
		int lastindex=0;		
        for (int i=0; i<name.length();i++)  {
        	if (name.charAt(i) == '<') { 
        		if (level == 0) {
            		name_ += name.substring(lastindex, i+1) + "\n\t";        		
            		lastindex = i+1;        		
        		}
        		level ++;
        	}
        	else if (name.charAt(i) == '>')  {
        		if (level==1) {
        		}
        		level --;
        	}
        	else if (name.charAt(i) == ',' && level == 1) { 
        		name_ += name.substring(lastindex, i+1) + " \n\t";        		
        		lastindex = i+1;        		
        	}
        }
        		
		name_ += name.substring(lastindex, name.length());

		return name_;
	}

	private Rectangle calculateBounds(ModelType component) {
		Rectangle bounds = component.getBounds();
		//if (component.isDirectSonOfTheTopConfiguration()) {
			return bounds;
	//	} else {
		//	int dx=80;
			//int dy=40;
		//	Dimension d = new Dimension(dx,dy);
		//	Rectangle bounds_ = new Rectangle(bounds.getLocation(),d);
		//	return bounds_;
		//}
	}

	public List getModelChildren() {
		
	    ModelType c = (ModelType)this.getModel();
		
	    if (c.isDirectSonOfTheTopConfiguration()) {	    
			List children = (List) c.getObservableEntries();
			return children;
	    } else {
	    	return new ArrayList();
	    }
		
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
		if (ev.getPropertyName().equals(ModelType.NEW_UNIT)) 
			this.refreshChildren();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_BOUNDS)) {
			this.refresh();
		}
		if (ev.getPropertyName().equals(ModelType.PROPERTY_COLOR)) {
			this.refresh();
		}
		if (ev.getPropertyName().equals(ModelType.REPLICATED)) {
			  ((ConfigurationEditPart) getParent()).refresh();
			  this.refreshSourceConnections();
		}
		if (ev.getPropertyName().equals(ModelType.PROPERTY_IS_PARAMETER)) {
    	    ((ConfigurationEditPart) getParent()).refresh();
			refresh();
		}
		if (ev.getPropertyName().equals(ModelType.PROPERTY_RECURSIVE)) {
    	    ((ConfigurationEditPart) getParent()).refresh();
			refresh();
		}
		if (ev.getPropertyName().equals(ModelType.PROPERTY_IS_SUPERTYPE)) {    	    
			refresh();
		}
		if (ev.getPropertyName().equals(ModelType.UPDATE_CONNECTIONS)) {    	    
			this.refresh();
		}

		if (ev.getPropertyName().equals(ModelType.PROPERTY_HIDDEN_UNIT)) {    	    
			refreshChildren();
		}
		if (ev.getPropertyName().equalsIgnoreCase(ModelType.UPDATE_NAME)) this.refreshVisuals();//$NON-NLS-1$ 
	}
	
	
	/*

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
	}
	
	*/
	
	public List<Object> getModelSourceConnections() {
		
		List<Object> r = new ArrayList<Object>();
				
		List<HLinkToReplicator> j = ((IReplicatedElement) getModel()).getLinksToVisibleReplicators();
		if (j!=null) r.addAll(j);
		
		ModelType c = (ModelType) this.getModel();
		if (c.isDirectSonOfTheTopConfiguration()) {
			for (HComponent x : c.getExposedComponents()) {
				r.add(c.hashCode() + ".exposed_link." + x.hashCode());
		    }
		}
		
		return r;
	}
	
	public List getModelTargetConnections() {
		
		List l = new ArrayList();
		
		ModelType c = (ModelType) this.getModel();
		if (!c.isDirectSonOfTheTopConfiguration()) {			
			for (HComponent x : c.getTopParentConfigurations()) {
			   l.add(x.hashCode() + ".exposed_link." + c.hashCode());
			}
		}

		return l;
		
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
		ModelType c = (ModelType) this.getModel();
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT)
			performDirectEdit();
		return;
	}
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((FigureType) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((FigureType) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((FigureType) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((FigureType) this.getFigure()).getConnectionAnchor() ;
	} 
}
