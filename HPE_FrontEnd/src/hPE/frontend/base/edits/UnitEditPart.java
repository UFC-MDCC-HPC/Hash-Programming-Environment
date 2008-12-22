package hPE.frontend.base.edits;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;


import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.*;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchEncoding;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.editors.text.*;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.part.MultiPageEditorPart;

import hPE.HPEVersionEditor;

import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.figures.UnitFigure;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HPrimUnitStub;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IReplicatedElement;
import hPE.frontend.base.policies.BuildInterfaceEditPolicy;
import hPE.frontend.base.policies.DetachInterfaceEditPolicy;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.NameDirectEditPolicy;
import hPE.frontend.base.policies.RemoveElementEditPolicy;
import hPE.frontend.base.policies.ShowInterfaceEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.policies.SetPrivateUnitEditPolicy;

import org.eclipse.gef.NodeEditPart;


public class UnitEditPart<ModelType extends IHUnit, FigureType extends UnitFigure> extends AbstractGraphicalEditPart implements PropertyChangeListener, NodeEditPart {

	public UnitEditPart() {
		super();
		
	}

	protected IFigure createFigure() {
		return new UnitFigure();
		
	}

	protected void createEditPolicies() {
		
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new RemoveElementEditPolicy());
		this.installEditPolicy("BuildInterfaceFromSlicesEditPolicy", new BuildInterfaceEditPolicy());
		this.installEditPolicy("DetachInterfaceEditPolicy", new DetachInterfaceEditPolicy());
		this.installEditPolicy("ShowInterfaceEditPolicy", new ShowInterfaceEditPolicy());
		this.installEditPolicy("SetPrivateUnitEditPolicy", new SetPrivateUnitEditPolicy());
		// allow the creation of connections and and the reconnection of connections between Shape instances
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
	
	}
	
	protected void refreshVisuals() {

		ModelType unit = (ModelType) getModel();
		FigureType unit_figure = (FigureType) getFigure();
        
	    unit_figure.setBounds(unit.getBounds());
        
	    System.err.println(unit.getMyClones());
	    
	    
	    String name = unit.getName2();
	    
	    List<String> names = new ArrayList<String>(); 
	    Iterator<HReplicator> rs = ((HUnit)unit).getReplicators().iterator();
	    if (rs.hasNext()) {
		    name = name.concat("[");
		    boolean f = false;
            while (rs.hasNext()) {
                HReplicator r = rs.next();
                if (r.getFactor() != 1 && !names.contains(r.getName2())) {
                	if (f) name = name.concat(",");
                	name = name.concat(r.getName2().equals("*") ? "" : r.getName2());
	            	names.add(r.getName2());
	            	f = true;
            	}
            }		    
		    name = name.concat("]");
	    }
	    
	    if (names.size() == 0) name = unit.getName2();
	    
	    unit_figure.setName(name);
        
        if (unit.getInterface() != null)
           unit_figure.setBackgroundColor(((HInterface)unit.getInterface()).getColor());
        else 
           unit_figure.setBackgroundColor(HUnit.default_color);
        
        unit_figure.setHidden(unit.getHidden());
        
        	
        
				
	}
	
	public List getModelChildren() {
		
		List children = new ArrayList();
		
		ModelType u = (ModelType) getModel();
		
		for (HUnitSlice s : u.getSlices()) {
			if (!s.getHiddenSlice()) 
				children.add(s);
		}
		
		return children;
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
			this.refreshVisuals();
		}
		if (ev.getPropertyName().equals(ModelType.REMOVE_UNIT))   ((ConfigurationEditPart)this.getParent()).refresh(); 
		if (ev.getPropertyName().equalsIgnoreCase("labelContents")) this.refreshVisuals(); //$NON-NLS-1$ 
		if (ev.getPropertyName().equals(ModelType.ADD_UNIT_ITEM)) this.refreshChildren();
		if (ev.getPropertyName().equals(ModelType.INTERFACE_SHOW)) {
			  ((ConfigurationEditPart) getParent()).refresh();
			  this.refreshSourceConnections();
		} 
		
		if (ev.getPropertyName().equals(ModelType.INTERFACE_HIDE)) {
		  ((ConfigurationEditPart) getParent()).refresh();
		  this.refreshSourceConnections();
		} 
		
		if (ev.getPropertyName().equals(ModelType.REPLICATED)) {
			  ((ConfigurationEditPart) getParent()).refresh();
			  this.refreshSourceConnections();
		} 
		
		if (ev.getPropertyName().equals(ModelType.CHANGING_PORTS)) {
			this.refresh();
		} 
		
		if (ev.getPropertyName().equals(ModelType.HIDDEN_PROPERTY)) {
			this.refresh();
		}
		
		if (ev.getPropertyName().equals(ModelType.PROPERTY_HIDDEN_SLICES)) {
			this.refresh();
		} 		
		if (ev.getPropertyName().equals(ModelType.BINDING_CREATE_SOURCE)) {
			this.refresh();
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
	
	public List getModelSourceConnections() {
		
		List r = new ArrayList();	
		
		HLinkToInterface i = ((ModelType) getModel()).getLinkToInterface();
		if (i!=null) if (i.visibleInterface() && !i.getWhich_interface().getHidden()) r.add(i);
		
		Collection j = ((IReplicatedElement) getModel()).getLinksToVisibleReplicators();
		if (j!=null) r.addAll(j);
		
		return r;
	}
	
	public List getModelTargetConnections() {
		
		List r = new ArrayList();
		
		HBinding b = ((ModelType)getModel()).getBinding();
		if (b!= null && b.isVisible()) r.add(b);
		
		return r;
	}

	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((UnitFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((UnitFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((UnitFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((UnitFigure) this.getFigure()).getConnectionAnchor() ;
	} 


	
}
	
