package hPE.frontend.base.edits;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.BendpointConnectionRouter;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;

import hPE.frontend.base.commands.NewComponentCommand;
import hPE.frontend.base.commands.NewReplicatorCommand;
import hPE.frontend.base.commands.NewUnitCommand;
import hPE.frontend.base.commands.ResizeCommand;
import hPE.frontend.base.figures.ConfigurationFigure;
import hPE.frontend.base.figures.INameEditableFigure;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.*;
import hPE.frontend.base.policies.BrowseEditPolicy;
import hPE.frontend.base.policies.ChangeColorEditPolicy;
import hPE.frontend.base.policies.ChangeVariableNameEditPolicy;
import hPE.frontend.base.policies.DeployEditPolicy;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.ImplementsEditPolicy;
import hPE.frontend.base.policies.NewVersionEditPolicy;
import hPE.frontend.base.policies.RegisterComponentEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;
import hPE.frontend.kinds.data.model.HDataUnit;

import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;



import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import org.eclipse.draw2d.geometry.Rectangle;


import java.beans.PropertyChangeListener;
import org.eclipse.core.resources.IResource;

import org.eclipse.core.resources.IFile;

public class ConfigurationEditPart<ModelType extends HComponent,
                                   FigureType extends ConfigurationFigure>
             extends AbstractGraphicalEditPart implements PropertyChangeListener{

	
	public ConfigurationEditPart() {
		super();
	}

	protected IFigure createFigure() {
		
		return new ConfigurationFigure();
		
	}

	protected void createEditPolicies() {
		
		// Create the static router for the connection layer
   	    ConnectionLayer connLayer = (ConnectionLayer)getLayer(LayerConstants.CONNECTION_LAYER);
		connLayer.setConnectionRouter(new BendpointConnectionRouter());

		this.installEditPolicy("Change Color", new ChangeColorEditPolicy());
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		// this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		// disallows the removal of this edit part from its parent
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		// handles constraint changes (e.g. moving and/or resizing) of model elements
		// and creation of new model elements
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,  new ElementsXYLayoutEditPolicy());
	    this.installEditPolicy("Change Variable Name", new ChangeVariableNameEditPolicy());
	    //this.installEditPolicy("Deploy", new DeployEditPolicy());
	    this.installEditPolicy("New Version", new NewVersionEditPolicy());
	    this.installEditPolicy("Browse", new BrowseEditPolicy());
	    this.installEditPolicy("Register Component", new RegisterComponentEditPolicy());

	}

	public List getModelChildren() {
		
		List children = new ArrayList();
		
		children.addAll((List) ((ModelType) getModel()).getUnits());
		
		for (HComponent c : ((ModelType) getModel()).getComponents()) 
			if (!children.contains(c) && !c.isHiddenInnerComponent()) 
				children.add(c);
		
		for (HComponent c : ((ModelType) getModel()).getExposedComponents()) 
			if (!children.contains(c) && !c.isHiddenInnerComponent()) 
				children.add(c);

		for (HInterface an_interface : ((ModelType) getModel()).getInterfaces()) {
			if (!(an_interface.getHidden())) { 
				children.add(an_interface);
			} 
		}
		
		for (HReplicator a_replicator : ((ModelType) getModel()).gettReplicators()) {
			if (!(a_replicator.getHidden()) && !(a_replicator.isJoined()) &&  !a_replicator.isUnitaryAndNotShow()) { 
				children.add(a_replicator);
			} 
		}
		
	    return children;		
	}
	
	public void refreshChildren() {
		super.refreshChildren();
	}
	
	/**
	 * EditPolicy for the Figure used by this edit part.
	 * Children of XYLayoutEditPolicy can be used in Figures with XYLayout.
	 * @author Elias Volanakis
	 */
	private static class ElementsXYLayoutEditPolicy extends XYLayoutEditPolicy {
		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	protected Command createAddCommand(EditPart child, Object constraint) {
		// not used in this example
		return null;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.requests.ChangeBoundsRequest, org.eclipse.gef.EditPart, java.lang.Object)
	 */
	protected Command createChangeConstraintCommand(ChangeBoundsRequest request,
			EditPart child, Object constraint) {
		
		if (child.getModel() instanceof HVisualElement && constraint instanceof Rectangle) {
			
	      	 Rectangle s = new Rectangle();
	       	 Rectangle r = ((IHVisualElement) child.getModel()).getBounds();
	       	 
	       	 s = ((ChangeBoundsRequest) request).getTransformedRectangle(r);        	 
	       	 return new ResizeCommand((IHVisualElement) child.getModel(),s);
	       	 
		}
		
		
		return super.createChangeConstraintCommand(request, child, constraint);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		// not used in this example
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(org.eclipse.gef.requests.CreateRequest)
	 */
	protected Command getCreateCommand(CreateRequest request) {
		Object childClass = request.getNewObjectType();
		if (childClass == HDataUnit.class || childClass == HUnit.class) {
			return new NewUnitCommand("unit", (HComponent) this.getHost().getModel(),request.getLocation());
		}
		if (childClass == HReplicator.class) {
			return new NewReplicatorCommand((HComponent) this.getHost().getModel(),request.getLocation());
		}
		if (childClass == HComponent.class) {
			return new NewComponentCommand((HComponent) this.getHost().getModel(), (String[]) request.getNewObject(), request.getLocation());
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
	 */
	protected Command getDeleteDependantCommand(Request request) {
		return null;
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
	
	protected void refreshVisuals() {
		
			
		ModelType config = (ModelType) getModel();
		
		//config.cleanReplicators();
		
		FigureType config_figure = (FigureType) getFigure();
		String name = config.isAbstractConfiguration() ? "Abstract ": "" ; 
        name = name + config.kindString() + " " + config.getNameWithParameters(true, true, true);
        if (!config.isAbstractConfiguration()) {
            name = name + " implements " + (config.getWhoItImplements() != null ? config.getWhoItImplements().getNameWithParameters(false, true, true) : "?");
        }
        else if (config.getSuperType() != null) {        
            name = name + " extends " + config.getSuperType().getNameWithParameters(false, true, true);
        }
		
        String name_ = breakLines(" " + name + " ");
        
		Label ff = new Label(" " + name_ + " ");
		Font font = new Font(null, "Arial", 10, SWT.BOLD);
		ff.setFont(font); 

		config_figure.setName(name);
        config_figure.setColor(config.getColor());
		config_figure.setToolTip(ff);
		
		super.refreshVisuals();
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

	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(ModelType.UPDATE_NAME)) this.refresh();
		if (ev.getPropertyName().equals(ModelType.UPDATE_COLOR)) this.refresh();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_INHERITS)) this.refresh();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_CONCRETE_CONFIGURATION)) this.refresh();
		if (ev.getPropertyName().equals(ModelType.NEW_UNIT)) this.refreshChildren();
		if (ev.getPropertyName().equals(ModelType.NEW_REPLICATOR)) this.refreshChildren();
		if (ev.getPropertyName().equals(ModelType.NEW_INTERFACE)) this.refreshChildren();
		if (ev.getPropertyName().equals(ModelType.NEW_COMPONENT)) this.refreshChildren();
		if (ev.getPropertyName().equals(ModelType.UPDATE_CONNECTIONS)) this.refresh();
		if (ev.getPropertyName().equals(ModelType.SUPPLY_PARAMETER)) this.refresh();
		if (ev.getPropertyName().equals(ModelType.PROPERTY_IS_PARAMETER)) this.refresh();
		if (ev.getPropertyName().equalsIgnoreCase("labelContents")) this.refreshVisuals();//$NON-NLS-1$
	}
	
	private DirectEditManager manager;
	
	private void performDirectEdit(){
		if(manager == null)
			manager = new NameUpdatingEditManager(
					this, new NameUpdatingCellEditLocator((INameEditableFigure)getFigure()));
		manager.show();
	}

	public void performRequest(Request request){
        super.performRequest(request);
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT)
			performDirectEdit();
		return;
	}	
	
	
}
