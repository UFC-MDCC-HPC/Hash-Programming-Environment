package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IComponentEntry;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
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
//			if (!unit.isClone()) {
				HInterface i = (HInterface) unit.getInterface();
				if (i!=null) {
					i.addInterfaceSlice(this,unitEntry.getName2());			
				}
				
//			}
			
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
