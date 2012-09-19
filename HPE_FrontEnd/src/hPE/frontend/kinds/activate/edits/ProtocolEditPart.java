package hPE.frontend.kinds.activate.edits;

import hPE.frontend.base.edits.NameUpdatingCellEditLocator;
import hPE.frontend.base.edits.NameUpdatingEditManager;
import hPE.frontend.base.figures.ConfigurationNodeFigure;
import hPE.frontend.base.model.IPropertyChangeListener;
import hPE.frontend.base.policies.HashGraphicalNodeEditPolicy;
import hPE.frontend.base.policies.NameDirectEditPolicy;
import hPE.frontend.base.policies.UnitFlowLayoutEditPolicy;
import hPE.frontend.kinds.activate.actions.ChangeOrderSEQProtocolAction;
import hPE.frontend.kinds.activate.actions.NewProtocolBoxAction;
import hPE.frontend.kinds.activate.actions.RemoveActionProtocolAction;
import hPE.frontend.kinds.activate.actions.SetProtocolTypeAction;
import hPE.frontend.kinds.activate.actions.ToggleLoopProtocolAction;
import hPE.frontend.kinds.activate.figures.ActionFigure;
import hPE.frontend.kinds.activate.figures.NullProtocolFigure;
import hPE.frontend.kinds.activate.figures.ProtocolFigure;
import hPE.frontend.kinds.activate.model.protocol.HActionEntry;
import hPE.frontend.kinds.activate.model.protocol.HActionExit;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.activate.model.protocol.HProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.HProtocolPerform;
import hPE.frontend.kinds.activate.model.protocol.IProtocol;
import hPE.frontend.kinds.activate.model.protocol.IProtocolCombinator;
import hPE.frontend.kinds.activate.model.protocol.IProtocolPerform;
import hPE.frontend.kinds.activate.policies.ChangeOrderSEQProtocolEditPolicy;
import hPE.frontend.kinds.activate.policies.NewProtocolBoxEditPolicy;
import hPE.frontend.kinds.activate.policies.RemoveActionProtocolEditPolicy;
import hPE.frontend.kinds.activate.policies.SetProtocolTypeEditPolicy;
import hPE.frontend.kinds.activate.policies.ToggleLoopProtocolEditPolicy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.graphics.Color;

public class ProtocolEditPart extends AbstractGraphicalEditPart 
		implements PropertyChangeListener, NodeEditPart {

	private boolean undefined = false;
	
	public ProtocolEditPart(boolean undefined) 
	{
		super();
		this.undefined = undefined;
	}

	public ProtocolEditPart() 
	{
		super();
		
	}
	
	protected IFigure createFigure() 
	{
		Figure pf;
		
		if (!undefined) {
			IProtocol p = (IProtocol) getModel();
			
			if (!p.isAction()) 
			{
				pf = new ProtocolFigure(); 
				
			} 
			else
			{
				pf = new ActionFigure();
				
			}
		} 
		else
		{
		   HProtocolChoice protocol_choice = (HProtocolChoice) this.getModel();
		   pf = new NullProtocolFigure();
		   protocol_choice.setBoundsNoUpdate(pf.getBounds().getCopy());		   
		}

		pf.requestFocus();
		return pf;
	}

	protected void createEditPolicies() {
		
	  
	  this.installEditPolicy(EditPolicy.LAYOUT_ROLE,new UnitFlowLayoutEditPolicy());
	  
	  this.installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HashGraphicalNodeEditPolicy());
//	  this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new RemoveElementEditPolicy());
	  this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new NameDirectEditPolicy());
 	 // this.installEditPolicy("Edit Protocol", new EditProtocolEditPolicy());
 	  this.installEditPolicy(NewProtocolBoxAction.NEW_PROTOCOL, new NewProtocolBoxEditPolicy());
 	  this.installEditPolicy(SetProtocolTypeAction.SET_PROTOCOL_TYPE_ALT, new SetProtocolTypeEditPolicy(IProtocolCombinator.ALT_COMBINATOR));
 	  this.installEditPolicy(ToggleLoopProtocolEditPolicy.TOGGLE_LOOP_REQUEST, new ToggleLoopProtocolEditPolicy());
 	  this.installEditPolicy(RemoveActionProtocolEditPolicy.REMOVE_ACTION_REQUEST, new RemoveActionProtocolEditPolicy());
 	 this.installEditPolicy(ChangeOrderSEQProtocolEditPolicy.CHANGE_ORDER_REQUEST, new ChangeOrderSEQProtocolEditPolicy());
 	 
	}
	
	private HActionEntry entry = null;
	private HActionExit exit = null;
	
	public List getModelChildren() {
		
		List c = new ArrayList();
		if (!undefined)
		{
		    IProtocol protocol = ((IProtocol) getModel());
		    
		    if (protocol instanceof IProtocolCombinator)
		    {
		    	
		    	IProtocolCombinator protocol_combinator = (IProtocolCombinator) protocol;
		    	c.addAll(protocol_combinator.getActions());
		    	if (entry == null)
		    		entry = new HActionEntry(protocol_combinator);
		    	if (exit == null)
		    		exit = new HActionExit(protocol_combinator);
		    	protocol_combinator.setEntryExit(entry, exit);
		    	c.add(entry);
		    	c.add(exit);
		    }
		}
		
		return c;
	}

	public List getModelSourceConnections() {

		List r = new ArrayList();
		
		if (!undefined)
		{
			IProtocol p = (IProtocol) getModel();
			if (!p.isAction())
			{
				String id = null;
				IProtocolCombinator parent_protocol = (IProtocolCombinator) this.getParent().getModel();
				if (parent_protocol.getCombinator() == IProtocolCombinator.SEQ_COMBINATOR)
				{
					int i = p.getOrder();
				
					List<IProtocol> actions = parent_protocol.getActions();
					if (i < actions.size()-1)
					{
						
						IProtocol next_protocol= actions.get(i+1);
						Integer order = i+1; //next_protocol.getOrder();
						
						//Integer key = next_protocol.hashCode();
						Integer key = parent_protocol.hashCode();
			            id = key.toString()  + "_" + order.toString();
					} 
					else
					{
						Integer key = parent_protocol.hashCode();
			            id = key.toString() + "_exit";
					}
				}
				else
				{
					Integer key = p.hashCode();
		            id = key.toString() + "_exit";
				}
				r.add("protocol." + id);
			}
		}
		
		return r;
	}
	
	public List getModelTargetConnections() {
		List r = new ArrayList();
		
		if (!undefined)
		{
			IProtocol p = (IProtocol) getModel();
			if (!p.isAction())
			{
				String id = null;
				IProtocolCombinator parent_protocol = (IProtocolCombinator) this.getParent().getModel();
				if (parent_protocol.getCombinator() == IProtocolCombinator.SEQ_COMBINATOR)
				{
					Integer order = p.getOrder();
					Integer key = parent_protocol.hashCode();
			        id = key.toString() + "_" + order;
				}
				else
				{
					Integer key = p.hashCode();
		            id = key.toString() + "_entry";
				}
				r.add("protocol." + id);
			}
		} 
		
		return r;
	}
	
	protected void refreshVisuals() 
	{
		Figure f = (Figure) getFigure();
		
		if (!undefined)
		{
			IProtocol a = (IProtocol) this.getModel();
			
			if (a.isAction())
			   refreshVisuals_action(a);
			else 
			   refreshVisuals_protocol(a);
			
			f.setBounds(a.getBounds());			
		    if (entry != null)
				entry.setLocation(f.getBounds().getTop().translate(+20, +20));
			if (exit != null)
				exit.setLocation(f.getBounds().getBottom().translate(-50, -50));
		} 
		else 
		{
			HProtocolChoice a = (HProtocolChoice) this.getModel();
			f.setBounds(a.getBounds());
			NullProtocolFigure figure = (NullProtocolFigure) f;
	  	    figure.setLabelText("action " + (a.getActionName() != null ? a.getActionName() : "") + ": right-click to configure a protocol !");
		}
	}
	

	private Color getProtocolColor(IProtocol a) 
	{
		if (a instanceof HProtocolCombinator)
		{
			HProtocolCombinator ac = (HProtocolCombinator) a;
			switch (ac.getCombinator())
			{
				case HProtocolCombinator.PAR_COMBINATOR: return ColorConstants.lightGreen;
				case HProtocolCombinator.ALT_COMBINATOR: return ColorConstants.cyan;
				case HProtocolCombinator.SEQ_COMBINATOR: return ColorConstants.red;
			}
		} 
		else if (a instanceof HProtocolPerform)
		{
			
			return ColorConstants.yellow;
		}
		return null;
	}

	private String protocolLabel(IProtocol a) {
		
		String label = null;
		
		if (a instanceof HProtocolCombinator)
		{
			HProtocolCombinator ac = (HProtocolCombinator) a;
			switch (ac.getCombinator())
			{
				case HProtocolCombinator.PAR_COMBINATOR: label = (a.isRepeat() ? "REPEAT " : "") + "PAR"; break;
				case HProtocolCombinator.ALT_COMBINATOR: label = (a.isRepeat() ? "REPEAT " : "") + "ALT"; break;
				case HProtocolCombinator.SEQ_COMBINATOR: label = (a.isRepeat() ? "REPEAT " : "") + "SEQ"; break;
			}
		} 
		else if (a instanceof HProtocolPerform)
		{
			HProtocolPerform ap = (HProtocolPerform) a;
			label = (a.isRepeat() ? "REPEAT " : "") + "PERFORM " /*+ (ap.getSliceId() != null ? ap.getSliceId() : "self") + "." + ap.getId()*/;
		}
		
		
		
		return label;
	}

	private void refreshVisuals_action(IProtocol a) 
	{
		ActionFigure figure = (ActionFigure) this.getFigure();
  	    figure.setLabelText((a.getName2() != null ? a.getName2() + ": " : "") + protocolLabel(a));
		figure.setBackgroundColor(getProtocolColor(a));
	}
	
	private void refreshVisuals_protocol(IProtocol a) 
	{
		ProtocolFigure figure = (ProtocolFigure) this.getFigure();
  	    figure.setLabelText((a.getName2() != null ? a.getName2() + ": " : "") + protocolLabel(a));
		figure.setBackgroundColor(getProtocolColor(a));
	}

	public void activate() {
	       if (!isActive()) 
	        	((IPropertyChangeListener) getModel()).addPropertyChangeListener(this);
        super.activate();        
        
	}
	
	public void deactivate() {
		((IPropertyChangeListener) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}
	
	public void propertyChange(PropertyChangeEvent ev) {
		{
			if (ev.getPropertyName().equals(HProtocolCombinator.PROPERTY_BOUNDS)) 
				this.refreshVisuals();
			else if (ev.getPropertyName().equals(HProtocolCombinator.PROPERTY_UPDATE_CHILDREN)) 
				this.refresh();
			else if (ev.getPropertyName().equals(HProtocolCombinator.PROPERTY_UPDATE_CONNECTIONS)) 
				this.refresh();
		}
			
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		IFigure f = this.getFigure();
		if (f instanceof ActionFigure)
		{
			return ((ActionFigure) f).getConnectionAnchor() ;
		} 
		else if (f instanceof ProtocolFigure) 
		{
			return ((ProtocolFigure) f).getConnectionAnchor() ;
		}
		else
		    return null;
		
	}

	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		IFigure f = this.getFigure();
		if (f instanceof ActionFigure)
		{
			return ((ActionFigure) f).getConnectionAnchor() ;
		} 
		else if (f instanceof ProtocolFigure) 
		{
			return ((ProtocolFigure) f).getConnectionAnchor() ;
		} 
		else
		    return null;
	}

	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		IFigure f = this.getFigure();
		if (f instanceof ActionFigure)
		{
			return ((ActionFigure) f).getConnectionAnchor() ;
		} 
		else if (f instanceof ProtocolFigure) 
		{
			return ((ProtocolFigure) f).getConnectionAnchor() ;
		}
		else
		    return null;
	}

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		IFigure f = this.getFigure();
		if (f instanceof ActionFigure)
		{
			return ((ActionFigure) f).getConnectionAnchor() ;
		} 
		else if (f instanceof ProtocolFigure) 
		{
			return ((ProtocolFigure) f).getConnectionAnchor() ;
		}
		else
		    return null;
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
}
