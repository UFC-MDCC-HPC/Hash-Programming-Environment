package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IComponentEntry;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IReplicator;
import hPE.frontend.base.interfaces.IUnitSlice;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public abstract class HUnitSlice extends hPE.frontend.base.model.HVisualElement 
                        implements IBindingTarget,
                                   Serializable, 
                                   IPropertyChangeListener, 
                                   INode, 
                                   IHasInterface, 
                                   IReplicatedElement, 
                                   IUnitSlice {
	
	/* A INTERFACE SLICE ABSTRACTION ASSOCIADA A UNIT SLICE ABSTRACTION DEVE TER A MESMA INTERFACE DA 
	 * INTERFACE DA UNIS SLICE ABSTRACTION (comutatividade no diagrama UML !!)	 * 
	 * */

	static final long serialVersionUID = 1;

	/**
	 * @uml.property   name="slice_abstraction"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="hUnitSliceAbstraction:hPE.model.HSliceAbstraction"
	 */
	private HInterfaceSlice slice_abstraction = null;

	/** 
	 * Getter of the property <tt>slice_abstraction</tt>
	 * @return  Returns the slice_abstraction.
	 * @uml.property  name="slice_abstraction"
	 */
	public HInterfaceSlice getInterfaceSlice() {
		return slice_abstraction;
	}
	
	public static int raio = 5;
	public static int diameter = raio*2;
	
	
	
	
	private void configureUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException{
		
		listeners = new PropertyChangeSupport(this);
		
		try {
			
			Rectangle r = new Rectangle(); // unit.getBounds().getCopy();
			r.setSize(diameter,diameter);
			if (where != null) {
			    r.setLocation(where);			    
			} else {
				this.setHiddenSlice(true);
			}
			this.setBounds(r);
			
			unit.addUnitSlice(this);
			if (!unit.isClone()) {
				HInterface i = (HInterface) unit.getInterface();
				if (i!=null) {
					i.addInterfaceSlice(this,unitEntry.getName2());			
				}
				
				List<HReplicator> allRs = new ArrayList<HReplicator>();
				allRs.addAll(unitEntry.getReplicators());
				allRs.addAll(((HComponent) unitEntry.getConfiguration()).getReplicators());
							
				for (HReplicator replicator : allRs) {
					if (!this.isReplicatedBy(replicator) && !this.getUnit().isReplicatedBy(replicator)) {
		                try {					
							this.setReplicator(replicator,true);
			    		} catch (HPEUnmatchingEnumeratorsException e) {
			    			System.err.println("Unexpected Exception !" + e.getMessage());
			    		}
					}
				} 
			}
			
		} catch (HPEAbortException e) {
			unit.removeUnitSlice(this);
			throw e;
		}
		
	}
	
	

	
	/**
	 */
	public HUnitSlice(IHUnit unit, IHUnit unitEntry, Point where) throws HPEAbortException {
		
		super();
		this.unit = unit;
		
		this.setInterface((HInterface)unitEntry.getInterface());
		try {
		  configureUnitSlice(unit,unitEntry,where);
		} catch (HPEAbortException e) {
			// this.setInterface(null);
			throw e;
		}
		
		
		
	}
	
	/**
	 * @uml.property   name="binding"
	 * @uml.associationEnd   inverse="port:hPE.base.model.HBinding"
	 */
	private HBinding binding;

	/**
	 * Getter of the property <tt>binding</tt>
	 * @return  Returns the binding.
	 * @uml.property  name="binding"
	 */
	public HBinding getBinding() {
		return binding;
	}

	/**
	 * Setter of the property <tt>binding</tt>
	 * @param binding  The binding to set.
	 * @uml.property  name="binding"
	 */
	public void setBinding(HBinding binding) {
		this.binding = binding;
		listeners.firePropertyChange(BINDING_CREATE_TARGET, null, binding); //$NON-NLS-2$//$NON-NLS-1$	
	}

	public void unsetBinding() {
		this.binding = null;
		listeners.firePropertyChange(BINDING_CREATE_TARGET, null, "unbind"); //$NON-NLS-2$//$NON-NLS-1$	
	}
	
	public final static String PROPERTY_BOUNDS = "unit_slice_bounds";
	public final static String BINDING_CREATE_TARGET = "binding_create_target";
	
	private PropertyChangeSupport listeners;
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}

	/**
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}
	
	public void remove() {
		
		// NOTHING TO DO ... yet ....
		return;
        		
	}

	/**
	 * Setter of the property <tt>slice_abstraction</tt>
	 * @param slice_abstraction  The slice_abstraction to set.
	 * @uml.property  name="slice_abstraction"
	 */
	public void setInterfaceSlice(HInterfaceSlice slice_abstraction) {
		this.slice_abstraction = slice_abstraction;
		HInterface i = (HInterface) slice_abstraction.getInterface();
		if (this.getInterface() != i) {
			this.setInterface(i);
		}
	}

	public void unsetSlice_abstraction() {
		if (this.slice_abstraction != null) {
		   this.slice_abstraction.getLinkToInterface().removeMe();
  		   this.slice_abstraction.removeCompliantUnitSlice(this);
		   this.slice_abstraction = null;
	    } else {
        	System.err.println("Null Slice Abstraction in Unit Slice is Not Expected - Continuing ... (unsetSlice_abstraction, HUnitSlice)");
			
		}
		
	}
	
	/**
	 * @uml.property   name="linkToInterface"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="IHUnitSliceAbstraction:hPE.base.model.HLinkToInterface"
	 */
	private HLinkToInterface linkToInterface = null;

	/** 
	 * Getter of the property <tt>linkToInterface</tt>
	 * @return  Returns the linkToInterface.
	 * @uml.property  name="linkToInterface"
	 */
	public HLinkToInterface getLinkToInterface() {
		return linkToInterface;
	}

	/** 
	 * Setter of the property <tt>linkToInterface</tt>
	 * @param linkToInterface  The linkToInterface to set.
	 * @uml.property  name="linkToInterface"
	 */
	public void setLinkToInterface(HLinkToInterface linkToInterface) {
		this.linkToInterface = linkToInterface;
	}
	
	public void setInterface(HInterface which_interface) {
		
		if (this.getLinkToInterface() != null)
			this.getLinkToInterface().removeMe();
		
		HLinkToInterface li = new HLinkToInterface(this);
		li.setWhich_interface(which_interface);
		this.setLinkToInterface(li);
		if (listeners!=null) listeners.firePropertyChange(PROPERTY_COLOR,null,getBounds());
	}
	
	public final static String PROPERTY_COLOR = "Change Color";
	
	public void notifyColorChange() {
		listeners.firePropertyChange(PROPERTY_COLOR,null,getBounds());
    }
	
	public IInterface getInterface() {
		
		return this.getLinkToInterface().getWhich_interface();
	}
	
	public boolean visibleInterface() {
		return this.getLinkToInterface().visibleInterface();
	}
	
	public final static String INTERFACE_SHOW = "show_interface";
	public final static String INTERFACE_HIDE = "hide_interface";
	
	public void showInterface()
	{
		this.getLinkToInterface().show_interface();
		listeners.firePropertyChange(INTERFACE_SHOW,false,true);
	}
	
	public void hideInterface()	
	{
		this.getLinkToInterface().hide_interface();
		listeners.firePropertyChange(INTERFACE_HIDE,false,true);
	}

	/**
	 * @uml.property   name="linkToReplicator"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="IHUnitSliceAbstraction:hPE.base.model.HLinkToReplicator"
	 */
	private Collection<HLinkToReplicator> linkToReplicator = new ArrayList();

	/** 
	 * Getter of the property <tt>linkToReplicator</tt>
	 * @return  Returns the linkToReplicator.
	 * @uml.property  name="linkToReplicator"
	 */
	public List<HLinkToReplicator> getLinksToVisibleReplicators() {
		List<HLinkToReplicator> visibleLinks = new ArrayList<HLinkToReplicator>();
		for (HLinkToReplicator l : this.linkToReplicator) {
			HReplicator r = l.getReplicator();
			if (!r.getHidden() && !r.isUnitaryAndNotShow()) 
				visibleLinks.add(l);
		}
		
		return visibleLinks;
	}

	public List<HLinkToReplicator> getLinksToReplicators() {
		List<HLinkToReplicator> theLinks = new ArrayList<HLinkToReplicator>();
		Iterator<HLinkToReplicator> links = linkToReplicator.iterator(); 
		while (links.hasNext()) {
			HLinkToReplicator l = links.next();
			theLinks.add(l);
		}
		
		return theLinks;
	}

	public boolean isReplicatedBy(IReplicator which_replicator) {
		return (findLink((HReplicator)which_replicator) != null);
	}

	public boolean isReplicatedByVarId(String varId) {
		Iterator<HReplicator> rs = this.getReplicators().iterator();
		while (rs.hasNext()) {
			HReplicator r = rs.next();
			if (r.getVarId().equals(varId)) return true;
		}
		return false;
	}
	
	/**
	 */
	public List<HReplicator> getReplicators() {
		List replicators = new ArrayList();
		if (this.getLinksToReplicators().size() > 0) {
			Iterator rs = this.getLinksToReplicators().iterator();
		    while (rs.hasNext()) {
		    	HReplicator r = ((HLinkToReplicator) rs.next()).getReplicator();
		    	replicators.add(r);
		    }
		}			
		return replicators;
	}

	public final static String REPLICATED = "replicated";

	/**
	 */
	public void setReplicator(HReplicator the_replicator) throws HPEUnmatchingEnumeratorsException{

		if (!this.isReplicatedBy(the_replicator)) {
			HLinkToReplicator linkToReplicator = new HLinkToReplicator(this,the_replicator);
			this.linkToReplicator.add(linkToReplicator);
			
	//		 PROPAGATE TO COMPONENTS ! ...
	/*		try {
				propagateReplicator(the_replicator);
			} catch (HPEUnmatchingEnumeratorsException e) {
				this.linkToReplicator.remove(linkToReplicator); // ROLL BACK !
				throw new HPEUnmatchingEnumeratorsException();
			} */
			listeners.firePropertyChange(REPLICATED,null,this.getBounds());
		}

	}
	
	private void propagateReplicator(HReplicator the_replicator) throws HPEUnmatchingEnumeratorsException{
	   
		if (this.getBinding() != null) {
			IHUnit u = this.getBinding().getEntry();
			
			HReplicator r = u.getReplicatorByVarId(the_replicator.getVarId());
			if (r==null) {
				HComponent c = (HComponent) u.getConfiguration();
				HReplicator rc = c.getReplicatorByVarId(the_replicator.getVarId());
				if (rc==null) {
					//if (c.someUnitIsReplicatedByVarIdOf(the_replicator))
					//	throw new HPEUnmatchingEnumeratorsException();
					//else 
						c.setReplicator(the_replicator,true);
				} else {
					if (!c.isReplicatedBy(the_replicator)) 
						c.setReplicator(the_replicator,true);
				}
			} else {
				u.setReplicator(the_replicator,true);
			}
			
			/* if (!u.isReplicatedBy(the_replicator)) {
				HComponent c = (HComponent) u.getConfiguration();
				if (!c.isReplicatedBy(the_replicator) && !c.someUnitIsReplicatedBy(the_replicator)) 
					   c.setReplicator(the_replicator,true);
			} */
		}
	}

	public HReplicator getReplicatorByVarId(String v) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linkToReplicator).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator().getName2().equals(v)) return link.getReplicator();   		
		}
		return null;
	}

	public void setReplicator (HReplicator the_replicator, boolean permanent) throws HPEUnmatchingEnumeratorsException {
		setReplicator(the_replicator);
		for (HReplicator r : the_replicator.getMyJoined()) {
			setReplicator(r,permanent);
		}
		this.findLink(the_replicator).setPermanent(true);
	}
	
	private HLinkToReplicator findLink(HReplicator which_replicator) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linkToReplicator).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator() == which_replicator.getTopJoined()) return link;   		
		}
		return null;
	}
	
	public void unSetReplicator(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
    	link.unlinkFromReplicator();
    	this.linkToReplicator.remove(link);
    	List<HReplicator> rs = which_replicator.getMyJoined();    	
    	if (!rs.isEmpty())
			for (HReplicator s : rs) 
			    if (this.isReplicatedBy(s)) 
			    	this.unSetReplicator(s);
		listeners.firePropertyChange(REPLICATED,null,getBounds());
	}
	
	public void addLinkToReplicator(HLinkToReplicator linkToReplicator) {
		this.linkToReplicator.add(linkToReplicator);
		
	}

	@Override
	public void removeLinkToReplicator(HLinkToReplicator linkToReplicator) {
		this.linkToReplicator.remove(linkToReplicator);
	}

	/**
	 */
		public boolean isReplicated() {
			return this.getLinksToReplicators().size() > 0;
		}

	/**
	 */
	public List getMyReplicas() {
		// TODO: model (getMyReplicas)
		return null;
	}
   
	/**
	 */
	public boolean isReplicatorFactorDetermined(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
		if (link != null) 
			return link.isReplicatorFactorDetermined();
		else
			return false; // RAISES EXCEPTION !!!! ERROR !!!
	}

	/**
	 */
	public int getReplicationFactor(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
		if (link != null) 
		        return which_replicator.getFactor();
		else
			return -1; // RAISES EXCEPTION !!!! ERROR !!!
	}


	/** 
	 * Setter of the property <tt>linkToReplicator</tt>
	 * @param linkToReplicator  The linkToReplicator to set.
	 * @uml.property  name="linkToReplicator"
	 */
	public void setLinkToReplicator(Collection linkToReplicator) {
		this.linkToReplicator = linkToReplicator;
	}
	
	private int nestingFactor = 0;
	
	public final static String NESTING_FACTOR_PROPERTY = "nesting_factor_property";
	
	public int getNestingFactor() {
		return nestingFactor;
	}
	
	public void setNestingFactor(int nestingFactor) {
		this.nestingFactor = nestingFactor;
		listeners.firePropertyChange(NESTING_FACTOR_PROPERTY,null,getBounds());
	}


	public IComponentEntry getComponentEntry() {
		
		
		return binding != null ? (IComponentEntry) binding.getEntry() : null;
	} 


	/**
	 * @uml.property   name="unit"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="unit_slice_abstractions:hPE.base.model.IHUnit"
	 */
	private IHUnit unit = null;

	/** 
	 * Getter of the property <tt>unit</tt>
	 * @return  Returns the unit.
	 * @uml.property  name="unit"
	 */
	public IHUnit getUnit() {
		return unit;
	}


	/** 
	 * Setter of the property <tt>unit</tt>
	 * @param unit  The unit to set.
	 * @uml.property  name="unit"
	 */
	public void setUnit(IHUnit unit) {
		this.unit = unit;
	}
	
	public IConfiguration getConfiguration () {
		return this.getComponentEntry() != null ? this.getComponentEntry().getConfiguration() : null;
	}
	
	private boolean hiddenSlice = false;
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setHiddenSlices(boolean)
	 */
	public void setHiddenSlice(boolean h) {
		hiddenSlice = h;
	//	listeners.firePropertyChange(PROPERTY_HIDDEN_SLICES, null, getName()); //$NON-NLS-2$//$NON-NLS-1$  
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getHiddenSlices()
	 */
	public boolean getHiddenSlice() {
		return hiddenSlice;
	}
	
	public boolean matchesTo(HInterfaceSlice islice) {
		return this.getInterface().getName2().equals(islice.getInterface().getName2()) && this.getNestingFactor() == islice.getNestingFactor();
	}
	
	public abstract HInterfaceSlice newInterfaceSlice(String name, HInterfaceSig s); 


    private String name = null;

    public void setName(String name) {
    	this.name = name;
    }
    
	public String getName() {		
		return this.getInterfaceSlice() == null || this.name == null ? 
				this.getBinding().getEntry().getName2() : this.getInterfaceSlice().getName();
					
	}




	

}
