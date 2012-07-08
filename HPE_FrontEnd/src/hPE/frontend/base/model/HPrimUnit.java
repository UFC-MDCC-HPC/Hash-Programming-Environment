package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IComponentEntry;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IInterfaceSlice;
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
	
	public static int raio = 10;
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

	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#getClones()
	 */
	public List<IHPrimUnit> getClones() {
		List<IHPrimUnit> ucs = new ArrayList<IHPrimUnit>();
//		if (isCloned()) {
//			for (IHPrimUnit u_ : this.myClones) {
//		        ucs.addAll(u_.getClones());
//			}
//		}
//		else 
		{
			ucs.add(this);
		}   
		return ucs;
	}
	

	public List<IHPrimUnit> getMyClones() {		   
		return myClones;
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
//	    	cloneOfThis.cloneBySplit = null;
			cloneOfThis.isClone = true;
			cloneOfThis.setClone(this);
			this.addClone(cloneOfThis,shift);
			cloneOfThis.setBounds(this.getBounds().getCopy().translate((this.getBounds().width+2)*(shift+1),0));
//			cloneOfThis.linkToReplicator = new ArrayList<HLinkToReplicator>();
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

}
