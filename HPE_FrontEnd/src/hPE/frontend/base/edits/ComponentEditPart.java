 
package hPE.frontend.base.edits;

import hPE.frontend.ConfigurationEditPartFactory;
import hPE.frontend.base.figures.ComponentFigure;
import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.model.HComponent;
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
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
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
	
	protected void refreshVisuals() 
	{		
		ModelType component_ = (ModelType) getModel();
		HComponent component = (HComponent) (component_.getSupplier() == null ? component_ : component_.getSupplier()); 
		FigureType component_figure = (FigureType) getFigure();
		String name = ""; // component.getName2() + ": ";
						
		boolean showBounds = true; //component.isDirectSonOfTheTopConfiguration();
		boolean showParId  = true; //component.isDirectSonOfTheTopConfiguration();
		
        if (component.isParameter() && component.getSupplier()==null) 
        {
        	/* CHECK NEW BOUND AT TOP CONFIGURATION */
    	    HComponent topC = (HComponent) component.getTopConfiguration();
    	   // HComponent ownerC = component.getParentConfiguration();
    	    String varName = component.getVariableName(topC);
    	    Map<String, HComponent> ccc = topC.getParametersByDefinedVarNames();
        	component = (HComponent) (ccc.containsKey(varName) ? ccc.get(varName) : component);
        	
    	    component_figure.setAbstract();
    	    showBounds = showBounds && ((!topC.getVars().contains(varName)) || component.isTopConfiguration());
    	    if (varName.equals("?")) {
    	        name += (showParId ? component.getParameterIdentifier((IComponent)component.getConfiguration()) : "") + (showBounds ? " = " + component.getVariableName(topC) +  ": " + component.getNameWithParameters(false, showBounds, showParId) : "");
    	    }
    	    else {
    	    	name += varName + (showBounds ?  ": " + component.getNameWithParameters(false, showBounds, showParId) : "");
    	    }
        }
        else {
        	component_figure.setNonAbstract();
            name += component.getNameWithParameters(false, showBounds, showParId);
        }

        String name_ =  HComponent.breakLines(" " + component.getPackagePath() + "." + name + " ");
        
		Label ff = new Label(" " + name_ + " ");
		Font font = new Font(null, "Courier New", 8, SWT.BOLD);
		ff.setFont(font);
		
		component_figure.setPort(!component_.isDirectSonOfTheTopConfiguration());
        component_figure.setBounds(calculateBounds(component_));
        
        component_figure.setName(component_.getRef() + (component.hasFreeVariables() ? " [?]" : "") /*+ "+++" + originRef*/);
		component_figure.setToolTip(ff);
        component_figure.setRecursive(component_.isRecursive());
        component_figure.setBackgroundColor(component_.getColor());
        component_figure.setIsSuperType(component_.isSuperType());
        component_figure.setExposed(component_.isPublic());
        
        boolean isMultiple = component_.isMultiple() || 
                              (!component_.isDirectSonOfTheTopConfiguration() && component_.getTopParentConfigurations().get(0).isMultiple());
        
        component_figure.setMultiple(isMultiple);
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
		if (ev.getPropertyName().equals(ModelType.CHANGE_MULTIPLE)) this.refreshVisuals();
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
				
		
		ModelType c = (ModelType) this.getModel();
		HComponent cTop = (HComponent) c.getTopConfiguration();
		if (c.isDirectSonOfTheTopConfiguration()) 
		{
			for (HComponent x_ : c.getExposedComponents()) 
			{
				List<HComponent> fusion_components = cTop.getFusionComponents(x_.getRef());
				HComponent x = fusion_components == null || !fusion_components.contains(x_) ? x_ : fusion_components.get(0);
				
				List<HComponent> cParents = x_.getTopParentConfigurations();
				if (cParents.contains(c)) 
				{
				   // Nesse caso, o componente x é aninhado público de um componente que está no topo da configuração, portanto pode estar ligado a ele.
				   r.add(c.hashCode() + ".exposed_link." + x.hashCode());
				}
				else 
				{
					// Caso contrário, o componente pai de x deve ter suprido algum parametro de c, no qual x agora deve ser ligado. 
					// Isso acontece pq o pai de x possui mais componentes aninhados do que o componente aninhado de c que é seu supertipo e que 
					// supre na configuração.
					for (HComponent c_ : cParents) 
					{					   
					   if (/*c_.isHiddenInnerComponent() && */check_if_the_first_has_been_passed_as_parameter_to_the_second(c_,c)) 
					   {
					      r.add(c_.hashCode() + ".exposed_link." + x.hashCode());
					      break;
					   }
					}
				}
		    }
		}
		
		return r;
	}
	
	// Verifica se o componente c_ foi passado como parametro (supplyParameter) a algum parametro de c.
	private boolean check_if_the_first_has_been_passed_as_parameter_to_the_second(HComponent c_, ModelType c) {
		
		String varName = c_.getVariableName();
		if (varName != null) {
			for (Entry<String, List<HComponent>>  par : c.getParameters().entrySet()) 
			{
			   HComponent cVar = par.getValue().get(0);
			   if (cVar.getVariableName().equals(varName)) 
				   return true;
			}
		}
		
		return false;
	}

	public List getModelTargetConnections() {
		
		List l = new ArrayList();
		
		ModelType c = (ModelType) this.getModel();
		HComponent cTop = (HComponent) c.getTopConfiguration();
		
		List<HComponent> cList = cTop.getFusionComponents(c.getRef());
		if (cList == null || !cList.contains(c) || cList.get(0) == c)
		{
			if (!c.isDirectSonOfTheTopConfiguration()) 
			{			
				List<HComponent> csParent= new ArrayList<HComponent>();
				if (cList != null) 
				{
					for (HComponent c_prime : cList)
					{
					   csParent.addAll(c_prime.getTopParentConfigurations());
					}
				}
				else {
				   csParent.addAll(c.getTopParentConfigurations());
				}
				
				for (HComponent x : csParent) 
				{
				   l.add(x.hashCode() + ".exposed_link." + c.hashCode());
				}
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
