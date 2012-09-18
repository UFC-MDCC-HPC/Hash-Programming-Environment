package hPE.frontend.kinds.activate.model;

import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
import hPE.frontend.base.interfaces.IComputationInterface;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterfaceSig;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHPrimUnit;
import hPE.frontend.connector.xml.component.ComponentFactory;
import hPE.frontend.connector.xml.component.GuardType;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.frontend.kinds.base.model.HHasPortsInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;



public abstract class HActivateInterface extends HHasPortsInterface implements
		IComputationInterface{

	static final long serialVersionUID = 1;
	
	public HActivateInterface(HComponent configuration,
			HInterfaceSig signature,IHPrimUnit u, Point where) throws HPEAbortException {
		super(configuration, signature,u, where);
		
	}

	
	public String getId() {
		return getName2();
	}
	
	// LIST OF ACTIONS
	
	private Map<String, HProtocolChoice> actions = null;
	
	public void newAction(String action_id, HProtocolChoice action)
	{
	    if (actions == null) actions = new HashMap<String, HProtocolChoice>();
	    actions.put(action_id, action);
	    HComponent c = (HComponent) this.getConfiguration();
	    c.refresh();
	}
	
	public Map<String, HProtocolChoice> getActions()
	{
	    if (actions == null) actions = new HashMap<String, HProtocolChoice>();
	    if (actions.isEmpty()) 
	    {
	    	newAction("main", new HProtocolChoice("main"));
	    }
		return actions;
	}
	
	// LIST OF CONDITIONS
	
	private Map<String, GuardType> conditions = null;
	
	public void addCondition(String cond_id, GuardType guard)
	{
		if (conditions == null) conditions = new HashMap<String,GuardType>();
		conditions.put(cond_id, guard);
	}
	
	public Map<String,GuardType> getConditions() 
	{
		if (conditions == null) conditions = new HashMap<String,GuardType>();
		return conditions;
	}
	
	
	
//	private ProtocolChoiceType protocol;

//	public ProtocolChoiceType getProtocol() {
//		if (protocol == null) 
//		{
//			
//		}
			
//		return protocol;
//	}


//	public void setProtocol(ProtocolChoiceType protocol) {
//		this.protocol = protocol;
//	}
	
//	public void unsetProtocol() {
//		this.protocol = null;
//	}
	
/*	
	public void buildDefaultProtocol() {

		ProtocolChoiceType protocol = new ProtocolChoiceType(this);
		HParAction top_action = new HParAction(null,protocol);
		
		Rectangle b = top_action.getBounds(); 
		
		boolean hasActivateSlice = false;
		
		int x      = 10;
		int y      = 50;
		int width  = 10;
		int height = 0;		
		
		Iterator ias = this.getSlices().iterator();
		while (ias.hasNext()) {
			
		    HInterfaceSlice ia = (HInterfaceSlice) ias.next();
		    HHasExternalReferences i = (HHasExternalReferences) ia.getInterface();
		    
		    if (i instanceof HActivateInterface) {
		    	hasActivateSlice = true;
		    	
		    	HDoAction inner_action = new HDoAction(null,top_action,ia);
			    inner_action.setRepeat(ia.getNestingFactor());
		        inner_action.getBounds().setLocation(x,y);
		        
		        ProtocolChoiceType iP = (ProtocolChoiceType)((HActivateInterface)i).getProtocol();
		        
		        if (iP != null) {
				    HAction encapsulated_inner_action = ((HAction)iP.getAction()).getCopy(top_action);
					encapsulated_inner_action.setRepeat(ia.getNestingFactor());
				    encapsulated_inner_action.getBounds().setLocation(x,y);
				    inner_action.setEncapsulatedAction(encapsulated_inner_action);
				    encapsulated_inner_action.setEncapsulatingDoAction(inner_action);
		        } else {
		        	
		        	
		        }
		        	
			    
				x += inner_action.getBounds().width + 10;
	            width += inner_action.getBounds().width + 10;
	            height = height > inner_action.getBounds().height ? height : inner_action.getBounds().height ;
		    } 
		    
		    
			
		}
		
		if (!hasActivateSlice) {
			this.unsetProtocol();
		}
		
		top_action.setBounds(new Rectangle(b.x,b.y,width,height+100));
		protocol.getBounds().setSize(top_action.getBounds().width + (top_action.getBounds().x)*2,
				                     top_action.getBounds().height + (top_action.getBounds().y)*2);
		
		// if (((HParAction) protocol.getAction()).getActions().size()==0) this.protocol = null;
		
	}
*/	
	public final static String SHOW_PROTOCOL = "SHOW_PROTOCOL";
	
	boolean show_protocol = false;
	
	public void showProtocol() {
		if (!this.show_protocol) {
		   show_protocol = true;
		   getListeners().firePropertyChange(SHOW_PROTOCOL,null,getName2());
		}
	}
	
	public void hideProtocol() {
		if (this.show_protocol) {
			show_protocol = false;
			getListeners().firePropertyChange(SHOW_PROTOCOL,null,getName2());
		}
	}
	
	public boolean protocolIsVisible() {
		return show_protocol;
	}
	
	
	public HInterfaceSlice addInterfaceSlice(HUnitSlice uSlice, String name) throws HPENotFusableSlicesException{
		
			
			HInterfaceSlice s = super.addInterfaceSlice(uSlice,name);
			
			int x      = 10  ;
			int y      = 50 ;
			
			//ProtocolChoiceType protocol = (ProtocolChoiceType) this.getProtocol();
			
			HInterfaceSlice ia = (HInterfaceSlice)uSlice.getInterfaceSlice();
	        HHasExternalReferences i = (HHasExternalReferences) ia.getInterface();	        
	        /*
			if (protocol != null && i instanceof HActivateInterface) {
				
				HAction oldTopAction = (HAction) protocol.getAction();
				HParAction newTopAction = new HParAction(null,protocol);
				Rectangle b = newTopAction.getBounds(); 
				oldTopAction.setCombinatorAction(newTopAction);
		        
		    	HDoAction inner_action = new HDoAction(null,newTopAction,ia);
		    	inner_action.getBounds().setLocation(x,y);
			    inner_action.setRepeat(ia.getNestingFactor());
				
				oldTopAction.getBounds().setLocation(x+inner_action.getBounds().width+x, 
						                             y);
				
		        ProtocolChoiceType iP = (ProtocolChoiceType)((HActivateInterface)i).getProtocol();
		        
		        if (iP != null) {
				    HAction encapsulated_inner_action = ((HAction)iP.getAction()).getCopy(newTopAction);
					encapsulated_inner_action.setRepeat(ia.getNestingFactor());
			    	encapsulated_inner_action.getBounds().setLocation(x,y);
				    inner_action.setEncapsulatedAction(encapsulated_inner_action);
				    encapsulated_inner_action.setEncapsulatingDoAction(inner_action);
		        }			
			
		        newTopAction.setBounds(new Rectangle(b.x,
		        		                             b.y,
		        		                             inner_action.getBounds().width + 3*x + oldTopAction.getBounds().width,
		        		                             oldTopAction.getBounds().height + 2*y
		        		                            )
		        		              );	        
		        
			}*/

		
		
		return s;
		
	}	
	
	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {
		List<HBEAbstractSynthesizer> l = super.getSupportedSynthesizers();
//		l.add(new HBESynthesizerForC());
//		l.add(new HBESynthesizerCSharp());
		return l;
	}
	
	

	
	

	
	public abstract String getActivateMethodName();



}
