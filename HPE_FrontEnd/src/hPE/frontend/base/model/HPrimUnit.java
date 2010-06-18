package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IComponentEntry;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IInterfaceSlice;
import hPE.frontend.base.interfaces.IReplicator;
import hPE.frontend.base.interfaces.IUnit;
import hPE.frontend.base.interfaces.IUnitSlice;
import hPE.util.Pair;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;


public abstract class HPrimUnit extends HVisualElement 
                   implements IHPrimUnit {

	static final long serialVersionUID = 1;
	
	public final static Color default_color = ColorConstants.lightGray;
	
	private PropertyChangeSupport listeners;

	/**
	 * @uml.property  name="default_position"
	 */
	public static Point default_position = new Point(100,100) ;
	/**
	 * @uml.property  name="default_dimension"
	 */
	public static Dimension default_dimension = new Dimension (80,40);

	/**
	 * @uml.property   name="name"
	 */
	private String name = "";

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getName()
	 */
	public String getName2() {
		if (name == null)
			return "<unamed>";
		return name;
	}
	
	public HPrimUnit(String name, HComponent configuration, HInterface which_interface) {
		super();
		this.setInterface(which_interface);
		
        listeners = new PropertyChangeSupport(this);
		
		this.setName(name);
		
		this.setConfiguration(configuration);
		
		int i = configuration.getAllUnits().size();
		
		Rectangle r = new Rectangle(HPrimUnit.default_position,HPrimUnit.default_dimension);
		r.translate(0,(i-1)*50);
		this.setBounds(r);
		
		
	}

	public Rectangle getBounds() {
		if (super.getBounds() == null) {
			super.setBounds(new Rectangle(HPrimUnit.default_position,HPrimUnit.default_dimension));
		}
		return super.getBounds();
	}
	
	
	public HPrimUnit(String name, HComponent configuration /*, Point where */) {
		super();
		listeners = new PropertyChangeSupport(this);
		this.setName(name);
		this.setConfiguration(configuration);
        this.setBounds(new Rectangle(HPrimUnit.default_position,HPrimUnit.default_dimension));
		// configuration.newUnit((IHUnit)this);
		
	}
	
	public void setLocation(Point where) {
		
		Rectangle r = new Rectangle(HPrimUnit.default_position,HPrimUnit.default_dimension);
		r.setLocation(where);
		this.setBounds(r);
		
	}
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
		listeners.firePropertyChange("labelContents", null, name); //$NON-NLS-2$//$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#remove()
	 */
	public void remove()
	{
	    this.configuration.unlinkUnit((IHUnit)this);
	    
	}
	
	public void killMe() {		
		this.unsetAllReplicators();
		if (this.getInterface() != null) this.detachFromInterface();
		//this.remove();
	}
	

	/**
	 * @uml.property   name="configuration"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="units:hPE.base.model.HComponent"
	 */
	private HComponent configuration = null;

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getConfiguration()
	 */
	public IConfiguration getConfiguration() {
		return configuration;
    }
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getReplicators()
	 */
	public List<HReplicator> getReplicators() {
		List<HReplicator> replicators = new ArrayList<HReplicator>();
		if (this.getLinksToReplicators().size() > 0) {
			for (HLinkToReplicator l : this.getLinksToReplicators()) {
		    	HReplicator r = l.getReplicator();
		    	replicators.add(r);
		    }
		}			
		return replicators;
	}

	private boolean isLinkedTo(HReplicator r) 
	{
		for (HLinkToReplicator l : this.getLinksToReplicators()) {
			if (l.getTheReplicator().equals(r)) 
				return true;
		}
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setReplicator(hPE.model.HReplicator)
	 */
	public void setReplicator(HReplicator the_replicator) throws HPEUnmatchingEnumeratorsException{
		
		if (!(this.isReplicatedBy(the_replicator) || (this.isLinkedTo(the_replicator.getTopJoined()) && this.isLinkedTo(the_replicator)))) {
			
			HUnitSlice s = this.someSliceIsReplicatedByVarIdOf(the_replicator);
			if (s != null) {
			    for (HLinkToReplicator l : s.getLinksToReplicators()) { 
			    	if (l.getReplicator().getVarId().equals(the_replicator.getVarId()))
			    	   l.liftReplicator();
			    }
			}
			
			HLinkToReplicator linkToReplicator = new HLinkToReplicator(this,the_replicator);
			this.linkToReplicator.add(linkToReplicator);
			
			// PROPAGATE TO COMPONENTS ... only propagates
	/*		try {
				propagateReplicator(the_replicator);
			} catch (HPEUnmatchingEnumeratorsException e) {
				this.unSetReplicator(the_replicator);
				throw new HPEUnmatchingEnumeratorsException();
			}
	*/	
			for (HReplicator r : the_replicator.getMyJoined()) {
				setReplicator(r);
			}
			
			listeners.firePropertyChange(REPLICATED,null,name);
		}
	}
	
    public abstract HUnitSlice someSliceIsReplicatedByVarIdOf(HReplicator r); 

    public abstract HUnitSlice someSliceIsReplicatedBy(HReplicator r);
    
    protected abstract void propagateReplicator(HReplicator the_replicator) throws HPEUnmatchingEnumeratorsException ;

	public void setReplicator (HReplicator the_replicator, boolean permanent) throws HPEUnmatchingEnumeratorsException{
		setReplicator(the_replicator);
		this.findLink(the_replicator).setPermanent(true);
	}
	
    public void addLinkToReplicator(HLinkToReplicator l) {
    	this.linkToReplicator.add(l);
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

	public HLinkToReplicator findLink(HReplicator which_replicator) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linkToReplicator).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator() == which_replicator.getTopJoined()) return link;   		
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#unSetReplicator(hPE.model.HReplicator)
	 */
	public void unSetReplicator(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
    	link.unlinkFromReplicator();
    	this.linkToReplicator.remove(link);
    	
    	List<HReplicator> rs = which_replicator.getMyJoined();    	
    	if (!rs.isEmpty())
			for (HReplicator s : rs) 
			    if (this.isReplicatedBy(s)) 
			    	this.unSetReplicator(s);
    	
		listeners.firePropertyChange(REPLICATED,null,name);
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#unsetAllReplicators()
	 */
	public void unsetAllReplicators() {
		
		
		for (HLinkToReplicator r : (List<HLinkToReplicator>)((ArrayList<HLinkToReplicator>)this.getLinksToVisibleReplicators()).clone()) {
			if (this.getLinksToReplicators().contains(r)) 
				this.unSetReplicator(r.getReplicator());
		}
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#isReplicated()
	 */
	public boolean isReplicated() {
		return this.getLinksToReplicators().size() > 0;
	}

  
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#isReplicatorFactorDetermined(hPE.model.HReplicator)
	 */
	public boolean isReplicatorFactorDetermined(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
		if (link != null) 
			return link.isReplicatorFactorDetermined();
		else
			return false; // RAISES EXCEPTION !!!! ERROR !!!
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getReplicationFactor(hPE.model.HReplicator)
	 */
	public int getReplicationFactor(HReplicator which_replicator) {
		HLinkToReplicator link = findLink(which_replicator);
		if (link != null) 
		        return which_replicator.getFactor();
		else
			return -1; // RAISES EXCEPTION !!!! ERROR !!!
	}

	/**
	 * @uml.property   name="linkToReplicator"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="hUnit:hPE.base.model.HLinkToReplicator"
	 */
	private Collection<HLinkToReplicator> linkToReplicator = new ArrayList<HLinkToReplicator>();


	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getLinksToReplicators()
	 */
	public List<HLinkToReplicator> getLinksToVisibleReplicators() {
		Map<HReplicator, HLinkToReplicator> rs = new HashMap<HReplicator,HLinkToReplicator>();
		List<HLinkToReplicator> visibleLinks = new ArrayList<HLinkToReplicator>();
		for (HLinkToReplicator l : linkToReplicator) {
			HReplicator r = l.getReplicator();
			boolean check = true;
	/*		if (rs.containsKey(r)) {
			    HReplicator r_ = l.getTheReplicator();
			    if (!r_.isJoined()) {
			       visibleLinks.remove(rs.get(r));
			    } else {
			    	check = false;
			    }
			} */ 			
			if (check && !r.getHidden()  && !r.isUnitaryAndNotShow()) { 
				visibleLinks.add(l);
				rs.put(r,l);
			}
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

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setLinkToReplicator(java.util.Collection)
	 */
	public void setLinkToReplicator(Collection linkToReplicator) {
		this.linkToReplicator = linkToReplicator;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#isReplicatedBy(hPE.model.interfaces.IReplicator)
	 */
	public boolean isReplicatedBy(IReplicator which_replicator) {
		return (findLink((HReplicator)which_replicator) != null);
	}

	public boolean isReplicatedByVar(String varId) {
		
		for (HLinkToReplicator rlink : this.getLinksToReplicators()) {
			if (rlink.getReplicator().getVarId().equals(varId)) {
				return true;
			}
		}
		
		return false;
		
	}

	/**
	 * @uml.property  name="observable"
	 */
	private boolean observable;

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getObservable()
	 */
	public boolean getObservable() {
		return observable;
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setObservable(boolean)
	 */
	public void setObservable(boolean observable) {
		this.observable = observable;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#notifyColorChange()
	 */
	public void notifyColorChange() {
		listeners.firePropertyChange(PROPERTY_COLOR,null,name);
    }


	/**
	 * @uml.property  name="mapped_to_slice"
	 * @uml.associationEnd  inverse="hUnit:hPE.model.HSliceAbstraction"
	 */
	private HInterfaceSlice mapped_to_slice;

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getMappedToSlice()
	 */
	public HInterfaceSlice getMappedToSlice() {
		return mapped_to_slice;
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setMapped_to_slice(hPE.model.HInterfaceSlice)
	 */
	public void setMappedToSlice(HInterfaceSlice mapped_to_slice) {
		this.mapped_to_slice = mapped_to_slice;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#adviceChangingPorts()
	 */
	public void adviceChangingPorts() {			
		if (listeners!=null) listeners.firePropertyChange(CHANGING_PORTS, null, name); //$NON-NLS-2$//$NON-NLS-1$  
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#isRepetitive()
	 */
	public boolean isRepetitive() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getPorts()
	 */
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getListeners()
	 */
	public PropertyChangeSupport getListeners() {
	    return listeners;	
	}

	
	// BINDINGS !!!!
	
	/**
	 * @uml.property   name="binding"
	 * @uml.associationEnd   inverse="entry:hPE.base.model.HBinding"
	 */
	private List<HBinding> bindings;

//	private HBinding binding;
	
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getBinding()
	 */
	public HBinding getBinding() {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		return bindings.isEmpty() ? null : bindings.get(bindings.size()-1);
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setBinding(hPE.model.HBinding)
	 */
	
	public List<HBinding> getBindings() {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		return bindings;
	}
	
	public void setBinding(HBinding binding) {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		this.bindings.clear();
		this.bindings.add(binding);
	    this.getListeners().firePropertyChange(BINDING_CREATE_SOURCE, null, binding); //$NON-NLS-2$//$NON-NLS-1$	
	}

	public void addBinding(HBinding binding) {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		this.bindings.add(binding);
	    this.getListeners().firePropertyChange(BINDING_CREATE_SOURCE, null, binding); //$NON-NLS-2$//$NON-NLS-1$	
	}
	
	public void removeBinding(HBinding b) {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		this.bindings.remove(b);
	}

	public void align(HPrimUnit u) {
		
		this.cloneOf = u.cloneOf;
		int k = u.cloneOf.getIndexOfClone(u);
		u.cloneOf.getMyClones().remove(k-1);
		u.cloneOf.getMyClones().add(k-1, this);
		
	}
	
	public void setConfiguration(HComponent c) {
		
		if (this.getConfiguration() != null) {
			HComponent old_c = (HComponent) this.getConfiguration();
			old_c.unlinkUnit((IHUnit)this);
		}
		
		this.configuration = c;
		configuration.newUnit((IHUnit)this);
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#unsetBinding()
	 */
	public void unsetBinding() {
		this.bindings = new ArrayList<HBinding>();;
		this.getListeners().firePropertyChange(BINDING_CREATE_SOURCE, null, "unbind"); //$NON-NLS-2$//$NON-NLS-1$	
	}
	
	
	
	// INTERFACE SLICE: Unit as slice
	
	public static int raio = 5;
	public static int diameter = raio*2;
			
	
	
	
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getComponent()
	 */
	public IComponent getComponent() {
		return (IComponent) this.getConfiguration();
	}
	
	// Ancestor
	
	private IHUnit ancestorEntry;
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getAncestor()
	 */
	public IHUnit getAncestor() {
		return this.ancestorEntry;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setAncestor(hPE.model.HUnit)
	 */
	public void setAncestor(IHUnit unit) {			
		this.ancestorEntry = unit;
	}
	
	void adjustAncestorEntryBounds(Rectangle bounds) {
		if (this.ancestorEntry != null) {
			Rectangle r = ancestorEntry.getBounds();
			int x, y, height, width;
			if (bounds.y < 2) {
				y = r.y + bounds.y;
			    height = r.height - bounds.y;
			    bounds.y = 2;
			} else {
				y = r.y;
				height = r.height;
			}
			
			if (bounds.x < 2) {
				x = r.x + bounds.x;
			    width = r.width - bounds.x;
			    bounds.x = 2;
			} else {
				x = r.x;
				width = r.width;
			}
			
			height = bounds.y + bounds.height + 2 > height ? bounds.y + bounds.height + 2 : height;
			width  = bounds.x + bounds.width  + 2 > width  ? bounds.x + bounds.width  + 2 : width ;
			
			ancestorEntry.setBounds(new Rectangle(x,y,width,height));
		}
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#isEntry()
	 */
	public boolean isEntry() {
		return ((IComponent)this.getConfiguration()).isDirectSonOfTheTopConfiguration();			
	}
	
	void adjustComponentBounds(Rectangle bounds) {

		if (isEntry()) { 
		
		    HComponent c = (HComponent)this.getConfiguration();
			Rectangle r = c.getBounds();
			
			int x, y, height, width;
			if (bounds.y < 2) {
				y = r.y + bounds.y;
			    height = r.height - bounds.y;
			    bounds.y = 2;
			} else {
				y = r.y;
				height = r.height;
			}
			
			if (bounds.x < 2) {
				x = r.x + bounds.x;
			    width = r.width - bounds.x;
			    bounds.x = 2;
			} else {
				x = r.x;
				width = r.width;
			}
			
			height = bounds.y + bounds.height + 2 > height ? bounds.y + bounds.height + 2 : height;
			width  = bounds.x + bounds.width  + 2 > width  ? bounds.x + bounds.width  + 2 : width ;
			
			c.setBounds(new Rectangle(x,y,width,height));
		}	
	}
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setBounds(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		
		adjustAncestorEntryBounds(bounds);		
		adjustComponentBounds(bounds);
		
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#attachToInterface(hPE.model.HInterface)
	 */
	public void attachToInterface(HInterface which_interface) {
		
	      HLinkToInterface li = new HLinkToInterface(this);
	      li.setWhich_interface(which_interface);
	      this.setLinkToInterface(li);
		
		  this.showInterface();
		  listeners.firePropertyChange(PROPERTY_BOUNDS,null,this.getBounds());
		
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#matchForAttachment(hPE.model.HInterface)
	 */
	public abstract boolean matchForAttachment(HHasExternalReferences which_interface);
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#detachFromInterface()
	 */
	public void detachFromInterface() {		
		
		this.hideInterface();		
		((HPrimInterface)this.getInterface()).removeCompliantUnit(this);
		
		this.getLinkToInterface().removeMe();
		
		this.setLinkToInterface(null);

		getListeners().firePropertyChange(PROPERTY_BOUNDS,null,this.getBounds());
		
	}
	
	/**
	 * @uml.property   name="linkToInterface"
	 * @uml.associationEnd   inverse="hUnit:hPE.base.model.HLinkToInterface"
	 */
	private HLinkToInterface linkToInterface;

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getLinkToInterface()
	 */
	public HLinkToInterface getLinkToInterface() {
		return linkToInterface;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setLinkToInterface(hPE.model.HLinkToInterface)
	 */
	public void setLinkToInterface(HLinkToInterface linkToInterface) {
		this.linkToInterface = linkToInterface;
	}

	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#createInterface(org.eclipse.draw2d.geometry.Point)
	 */
	public abstract HHasExternalReferences createInterface(Point location) throws HPEAbortException;
	
	protected void complyToInterface(HInterface which_interface) {
	      HLinkToInterface li = new HLinkToInterface(this);
	      li.setWhich_interface(which_interface);
	      this.setLinkToInterface(li);
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getInterface()
	 */
	public IInterface getInterface() {
		if (this.getLinkToInterface() == null) return null;
		    else return this.getLinkToInterface().getWhich_interface();
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#visibleInterface()
	 */
	public boolean visibleInterface() {
		if (this.getLinkToInterface() != null) 
		    return this.getLinkToInterface().visibleInterface();
		else 
			return false;
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#showInterface()
	 */
	public void showInterface()
	{
		if (this.getLinkToInterface() != null) 
		   this.getLinkToInterface().show_interface();
		
		listeners.firePropertyChange(INTERFACE_SHOW, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#hideInterface()
	 */
	public void hideInterface()	
	{
		if (this.getLinkToInterface() != null) 
   		   this.getLinkToInterface().hide_interface();

		listeners.firePropertyChange(INTERFACE_HIDE, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  

	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setInterface(hPE.model.HInterface)
	 */
	public void setInterface(HInterface which_interface) {
		
		if (this.getInterface() == null) {
        	   attachToInterface(which_interface);
		}
			
		
		
	}
	/*
	public String toString() {
		return this.getConfiguration().toString().concat(".u.").concat(this.getName());
	} */
	
	private IHPrimUnit cloneOf = null;
	private List<IHPrimUnit> myClones = new ArrayList<IHPrimUnit>();
	private HReplicatorSplit cloneBySplit = null;

	public HReplicatorSplit splitBy(HReplicatorSplit split) {
		int i = 0;
		HReplicatorSplit theSplit = split;
		
		if (!this.isCloned()) {
			List<HBinding> bindings = new ArrayList<HBinding>(this.getBindings());
			for (HBinding b : bindings) {
				if (b.getCloneId() == -1) {
					HUnitSlice s = (HUnitSlice) b.getPort();
					IHPrimUnit u_ =  s.getUnit();
					theSplit = u_.splitBy(split);
				}
			}
		
			this.setCloneBySplit(theSplit);
			for (HLinkToReplicator l : theSplit.getLinksToReplicators()) {
				HReplicator r = l.getReplicator();
				IHPrimUnit u = (IHUnit) this.createReplica(i++);
				try {
					u.setReplicator(r);
			    } catch (HPEUnmatchingEnumeratorsException e) {
				        System.err.println("Unexpected Exception !" + e.getMessage());
			    }			
			}
		//} else 
			//return this.getCloneBySplit();
			//if (this.getCloneBySplit() != split) { 
		       // System.err.println("Unexpected Error (splitBy in HPrimUnit) !");
		//} else {
			// ok ! Top cloned unit reached !!!
		} else {
			theSplit = this.getCloneBySplit();
		}

		return theSplit;
	}
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getClones()
	 */
	public List<IHPrimUnit> getClones() {
		List<IHPrimUnit> ucs = new ArrayList<IHPrimUnit>();
		if (isCloned()) {
			for (IHPrimUnit u_ : this.myClones) {
		        ucs.addAll(u_.getClones());
			}
		}
		else {
			ucs.add(this);
		}   
		return ucs;
	}
	
	public void setCloneBySplit(HReplicatorSplit cloneBySplit) {
		this.cloneBySplit = cloneBySplit;
	}

	public HReplicatorSplit getCloneBySplit() {
		return cloneBySplit;
	}

	public List<IHPrimUnit> getMyClones() {		   
		return myClones;
	}
	
	public List<IHPrimUnit> getMyClonesSorted() {
		
		List<IHPrimUnit> clonesSorted = new ArrayList<IHPrimUnit>();
		
		if (this.getCloneBySplit() != null) {			
			List<Pair<String,IHPrimUnit>> ps = new ArrayList<Pair<String,IHPrimUnit>>();
			List<HReplicator> rs = this.getCloneBySplit().getReplicators();
			for (IHPrimUnit u : this.getMyClones()) {
				List<String> vars = new ArrayList<String>();
				for (HReplicator r : u.getReplicators()) {
					if (!vars.contains(r.getVarId())) {
						vars.add(r.getVarId());
						for (HReplicator r_ : rs) {
							if (r == r_) {
								ps.add(new Pair<String,IHPrimUnit>(r.getVarId(),u));
							}
						}
					}
				}
			}
		
			ps = sortClones(ps);
			
			for (Pair<String,IHPrimUnit> p : ps) {
				if (!clonesSorted.contains(p.snd())) 
					clonesSorted.add(p.snd());
			}
		
		} else {
            clonesSorted.add(this);			
		}
		
		return clonesSorted;
		
	}
	
	
	private List<Pair<String, IHPrimUnit>> sortClones(List<Pair<String, IHPrimUnit>> ps) {
		if (ps.size()>1) {
			Pair<String,IHPrimUnit> pivot = ps.get(0);
			ps.remove(0);
			List<Pair<String,IHPrimUnit>> ps_l = new ArrayList<Pair<String,IHPrimUnit>>();
			List<Pair<String,IHPrimUnit>> ps_r = new ArrayList<Pair<String,IHPrimUnit>>();
			for (Pair<String,IHPrimUnit> p : ps) {
				String varId = p.fst();
				if (varId.compareTo(pivot.fst())<0) {
					ps_l.add(p);
				} else {
					ps_r.add(p);
				}			 
			}
			List<Pair<String, IHPrimUnit>> ps_l_ = sortClones(ps_l);
			List<Pair<String, IHPrimUnit>> ps_r_ = sortClones(ps_r);
			ps_l_.add(pivot);
			ps_l_.addAll(ps_r_);
			return ps_l;
		}
		else 
			return ps;
		
	}

	public boolean isCloned() {
		return this.myClones != null && this.myClones.size() > 0;
	}

	public IHPrimUnit getClone(int i) {
		//if (myClones.size() < i)
		//	return null;
		return myClones.get(i-1);
	}
	
	public int getIndexOfClone(IHPrimUnit u) {
		if (u == this) return 0;
		else return this.myClones.indexOf(u)+1;
	}

	private void addClone(IHPrimUnit unit,int shift) {
		myClones.add(shift,unit);
	}
	
	private void setClone(IHPrimUnit cloneOf) {
		this.cloneOf = cloneOf;
	}
	
	public IHPrimUnit cloneOf() {
		return this.cloneOf;
	}
	

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getReplica()
	 */
	public HPrimUnit createReplica(int shift) {
		try {
			HPrimUnit cloneOfThis = (HPrimUnit) this.clone();
			cloneOfThis.myClones = null;
	    	cloneOfThis.cloneBySplit = null;
			cloneOfThis.isClone = true;
			cloneOfThis.setClone(this);
			this.addClone(cloneOfThis,shift);
			cloneOfThis.setBounds(this.getBounds().getCopy().translate((this.getBounds().width+2)*(shift+1),0));
			cloneOfThis.linkToReplicator = new ArrayList<HLinkToReplicator>();
			cloneOfThis.linkToInterface = this.linkToInterface != null ? this.linkToInterface.replicateMe(cloneOfThis) : null;
			cloneOfThis.myClones = new ArrayList<IHPrimUnit>();
			cloneOfThis.bindings = new ArrayList<HBinding>();
			
			/* The clone is not returned by getUnits */
			//((HComponent)this.getConfiguration()).newUnit((IHUnit)cloneOfThis);
			return cloneOfThis;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	private boolean isClone = false;
	
	public boolean isClone() {
		return this.isClone;
	}
	

	
	private boolean hiddenSlices = false;
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#setHiddenSlices(boolean)
	 */
	public void setHiddenSlices(boolean h) {
		hiddenSlices = h;
		listeners.firePropertyChange(PROPERTY_HIDDEN_SLICES, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getHiddenSlices()
	 */
	public boolean getHiddenSlices() {
		return hiddenSlices;
	}

    boolean hidden = false;
    
    
    public void setHidden (boolean hidden) {
    	this.hidden = hidden;
		getListeners().firePropertyChange(HIDDEN_PROPERTY,null,getBounds());
    }
    
    public boolean getHidden() {
    	return this.hidden;
    }
    
    boolean hiddenBlocked = false;
    
    public void setHiddenBlocked (boolean hiddenBlocked) {
    	this.hiddenBlocked = hiddenBlocked;
    }
    
    public boolean getHiddenBlocked() {
    	return this.hiddenBlocked;
    }
    
    public void setInterfaceEditable (boolean freezeInterface) {
    	if (this.getInterface() != null) ((HInterface)this.getInterface()).setEditable(freezeInterface);
    }
    
    public boolean isInterfaceEditable() {
    	if (this.getInterface() == null) return false;
    	return (((HInterface)this.getInterface()).isEditable());
    }
    
    public HPrimUnit getTopUnit(Map<HPrimUnit,Integer> path) {
    	
       if (path != null) {
    	  if (path.containsKey(this)) {
    		  int k = path.get(this); 
    		  IHPrimUnit u = this.getClone(k);
    		  if (u==null) {
    			  System.err.println("getTopUnit: null when looking for clone.");
    		  }
    		  return u.getTopUnit(path);
    	  } 
       }

	   if (getBinding() != null) {
			if (getBinding().getPort() instanceof HUnitSlice) {			
    	       HUnitSlice us = (HUnitSlice) getBinding().getPort();   
    	       
    	       IHPrimUnit u = (IHPrimUnit) us.getUnit();
    	       
			   return u.getTopUnit(path);
			} else {
				IHPrimUnit u = (IHPrimUnit) getBinding().getPort();
				return (HPrimUnit) u.getActualUnit();
			}
		} else {
			return this;
		}
		
	}

    public List<HPrimUnit> getTopUnits(Map<HPrimUnit,Integer> path) {
    	
        if (path != null) {
     	  if (path.containsKey(this)) {
     		  int k = path.get(this); 
     		  IHPrimUnit u = this.getClone(k);
     		  if (u==null) {
     			  System.err.println("getTopUnit: null when looking for clone.");
     		  }
     		  return u.getTopUnits(path);
     	  } 
        }

        List<HPrimUnit> us = new ArrayList<HPrimUnit>();
        
        List<HBinding> bs = new ArrayList<HBinding>(this.getBindings());
        List<HBinding> bsR = new ArrayList<HBinding>();
        boolean hasClones = false;
        for (HBinding b : bs) {
        	if (b.getCloneId() >= 0) { 
        		hasClones = true;
        	} else {
        		bsR.add(b);
        	}
        }
        if (hasClones) 
        	bs.removeAll(bsR);
       
        if (!bs.isEmpty()) {
	        for (HBinding b : bs) {
	 			if (b.getPort() instanceof HUnitSlice) {			
	     	       HUnitSlice uSlice = (HUnitSlice) b.getPort();   
	     	       
	     	       IHPrimUnit u = (IHPrimUnit) uSlice.getUnit();
	     	       
	     	       // avoid repetitions ...
	     	       for (HPrimUnit u_ : u.getTopUnits(path))
	     	          if (!us.contains(u_)) 
	     	        	  us.add(u_);
	     	       
	 			} else {
	 				IHPrimUnit u = (IHPrimUnit) b.getPort();
	 				us.add((HPrimUnit)u.getActualUnit());
	 			}
	       }
       } else {
 			us.add(this);
 	   }
 		
        return us;
 	}
   

    public IHPrimUnit getActualUnit() {
    	return this;
    }
 
    public boolean isNewNameValid(String name) {
    	return true;
    }
    
    private String supersededName = null;
    
    public String getSupersededName() {
    	if (this.supersededName == null) {
    		return this.getName2();
    	} else {
    		return this.supersededName;
    	}
    }
    
    public void setSupersededName(String name) {
    	this.supersededName = name;
    }

    @Override
    public void removeLinkToReplicator(HLinkToReplicator linkToReplicator) {
    	this.linkToReplicator.remove(linkToReplicator);
    }
}
