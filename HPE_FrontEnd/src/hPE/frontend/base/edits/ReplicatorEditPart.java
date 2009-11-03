package hPE.frontend.base.edits;


import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.figures.ReplicatorFigure;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HReplicatorSplit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.base.model.IPointsToReplicator;
import hPE.frontend.base.policies.FuseReplicatorEditPolicy;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.NameDirectEditPolicy;
import hPE.frontend.base.policies.RemoveElementEditPolicy;
import hPE.frontend.base.policies.SetReplicatorFactorEditPolicy;
import hPE.frontend.base.policies.UnfuseReplicatorEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

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

public class ReplicatorEditPart extends AbstractGraphicalEditPart 
                                implements PropertyChangeListener, NodeEditPart 
{

	public ReplicatorEditPart() {
		super();
	}

	protected IFigure createFigure() {
		return new ReplicatorFigure();
	}
	
	protected void createEditPolicies() {
			
		this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
		this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
		this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new RemoveElementEditPolicy());
		// allow the creation of connections and and the reconnection of connections between Shape instances
		this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
		this.installEditPolicy("Fuse Replicator", new FuseReplicatorEditPolicy());
		this.installEditPolicy("Unfuse Replicator", new UnfuseReplicatorEditPolicy());
		this.installEditPolicy("Make Unitary", new SetReplicatorFactorEditPolicy());
	}
	
	
	protected void refreshVisuals() {

  	    HReplicator replicator = (HReplicator) getModel();
  	    ReplicatorFigure replicator_figure = (ReplicatorFigure) getFigure();
  	    
  	    Rectangle u_bounds = ((AbstractGraphicalEditPart) getParent()).getFigure().getBounds();
  	    
  	    boolean flag = false;
  	    if (flag) {
  	        HComponent cccc = (HComponent)replicator.getConfiguration().getTopConfiguration();
  	        cccc.newReplicator(replicator);
  	    }
  	    
        replicator_figure.setBounds(replicator.getBounds().getTranslated(u_bounds.getLocation()));
        
        if (replicator.isDetermined()) {
        	int r = replicator.getFactor(); 
            if (r > 1) 
            	replicator_figure.setName(replicator.getVarId().concat("=").concat((new Integer(r)).toString()));
            else 
            	replicator_figure.setName("");
        } else {
            replicator_figure.setName(replicator.getVarId());
        }
        replicator_figure.setBackgroundColor(replicator.getColor());
        replicator_figure.setFactor(replicator.getFactor());
        
        // Take all joined replicators.
        HComponent topC = (HComponent) replicator.getConfiguration().getTopConfiguration();        
        List<HReplicator> rJoined = replicator.getFusionsClosureInContext(topC);
                
        replicator_figure.clean();
        for (HReplicator r : rJoined) {
        	replicator_figure.addFusedReplicator(r.getColor());
        }
        replicator_figure.addFusedReplicator(replicator.getColor());
        
        String name = replicator.getVarId().equals("*") ? " unamed replicator " : " replicator " + replicator.getVarId() + " "; 
        
		Label ff = new Label(name);
		Font font = new Font(null, "Arial", 10, SWT.ITALIC);
		ff.setFont(font); 
        	
		figure.setToolTip(ff);
	}
	
/*	
	public List getModelSourceConnections() {

		List r = new ArrayList();
		
		HBinding b = ((HComponentEntry) getModel()).getBinding();
		if (b != null) r.add(b); 

		
		HLinkToInterface i = ((HComponentEntry) getModel()).getLinkToInterface();
		if (i.visibleInterface() && !i.getWhich_interface().getHidden()) r.add(i);
		
		return r;
	} */ 

	public List getModelTargetConnections() {
		
		List r = new ArrayList();

		HComponent topConfiguration = (HComponent) this.getParent().getModel();

		for (HLinkToReplicator l : ((HReplicator) this.getModel()).getLinksToMe()) {
		
			IPointsToReplicator p = l.getReplicated(); 

			if (p instanceof IHUnit) {
				IHUnit p_ = (IHUnit) p;
				if (!p_.isCloned()) {
					if (p_.isEntry()) {
						if (p_.getComponent().isDirectSonOfTheTopConfiguration()) {
					       r.add(l);
						}
					} else if (p_.getConfiguration() == topConfiguration){
					   r.add(l);
					} 
				} else {
					// System.err.println("cloned ...");
				}
			} else if (p instanceof HComponent) {
				HComponent c = (HComponent) p;
				if (!c.isHiddenInnerComponent() && ((c.isDirectSonOfTheTopConfiguration()) || topConfiguration.getExposedComponents().contains(c))) {
					 r.add(l);
				}
			} else if (p instanceof HReplicatorSplit) {
				HReplicatorSplit rs = (HReplicatorSplit) p;
				if (!(rs.getOwnerReplicator().getHidden() || rs.getOwnerReplicator().isJoined())) {
   				   r.add(l);
				}
			} else if (p instanceof HUnitSlice) {
				HBinding binding = ((HUnitSlice) p).getBinding();
				if (binding != null) {
					IHUnit entry = binding.getEntry();
	                HComponent c = (HComponent) entry.getConfiguration();
	                if (c.isDirectSonOfTheTopConfiguration()) {
	                	r.add(l);
	                }
				}
			}
		}
		
		return r;
	} 
	
	
	public void activate() {
        if (!isActive()) 
        	((HReplicator) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((HReplicator) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		if (ev.getPropertyName().equals(HReplicator.PROPERTY_BOUNDS)) this.refresh();
		if (ev.getPropertyName().equals(HReplicator.SPLIT)) {
			this.refresh();
		}
		if (ev.getPropertyName().equals(HReplicator.CHANGE_LINK)) 
			 this.refreshTargetConnections();
		if (ev.getPropertyName().equals(HReplicator.EDIT_VARID)) {
			this.refreshVisuals();
			this.refreshSourceConnections();
			this.refreshTargetConnections();
			//HReplicator r = (HReplicator) this.getModel();
			//HComponent c = r.getConfiguration();
			//c.fireRefreshChildren();
			
		}
		if (ev.getPropertyName().equals(HReplicator.PROPERTY_JOINED)) {
			ConfigurationEditPart c = (ConfigurationEditPart) this.getParent();
			c.refresh();
			this.refresh();
		}
	}
		
	

	
	
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return ((ReplicatorFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return ((ReplicatorFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return ((ReplicatorFigure) this.getFigure()).getConnectionAnchor() ;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return ((ReplicatorFigure) this.getFigure()).getConnectionAnchor() ;
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
		
	public List getModelChildren() {
	
		List rs = new ArrayList();
		HReplicator model = (HReplicator) getModel();
		
		rs.addAll(model.getSplits());
		
		if (model.isJoined())
			for (HReplicator r : model.getMyJoined()) {
				rs.addAll(r.getSplits());
			}
		
		return rs;
		
	}
	
}
