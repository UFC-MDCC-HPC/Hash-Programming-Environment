package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IInterfaceSlice;

import java.util.Iterator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;

public abstract class HPrimUnitStub extends HVisualElement implements IBindingTarget, IHPrimUnit {

	static final long serialVersionUID = -6020767535702051013L;

	private IHPrimUnit unit;	
	
    public IHPrimUnit getActualUnit() {
    	return unit;
    }
	
	
	public void setPrimUnit(IHPrimUnit unit) {
		this.unit = unit;
		listeners.firePropertyChange(PROPERTY_BOUNDS, null, getBounds()); //$NON-NLS-2$//$NON-NLS-1$
	}
	
	private PropertyChangeSupport listeners;
	
	HComponent configuration = null;
	
	
	public HPrimUnitStub(IHPrimUnit unit) {
		super();
		listeners = new PropertyChangeSupport(this);
        this.unit = unit;
        this.originalName = unit.getName2();
        
        /* this.setConfiguration(configuration); */
	}
	
	public void setConfiguration(HComponent c) {
		
		if (this.getConfiguration() != null) {
			HComponent old_c = (HComponent) this.getConfiguration();
			old_c.unlinkUnit((IHUnit)this);
		}
		
		this.configuration = c;
		configuration.newUnit((IHUnit)this);	
		
	}
	
	public Rectangle getBounds() {
		if (super.getBounds() == null) {
			super.setBounds(new Rectangle(HPrimUnit.default_position,HPrimUnit.default_dimension));
		}
		return super.getBounds();
	}
	
	public String getName2() {
		return unit.getName2();
	}
	
	private String originalName = null;
	
	public String getOriginalName() {
		if (originalName == null) originalName = getName2();
		return this.originalName;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);

	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);

	}

	public void setName(String name) {
		unit.setName(name);
		listeners.firePropertyChange("labelContents", null, name); //$NON-NLS-2$//$NON-NLS-1$
	}

	public void remove() {
	    ((HComponent)this.getConfiguration()).unlinkUnit((IHUnit)this);
	}

	public IConfiguration getConfiguration() {
		
		return configuration;
	}





	public boolean getObservable() {
		return unit.getObservable();
	}

	public void setObservable(boolean observable) {
		unit.setObservable(observable);
	}

	public void notifyColorChange() {
		unit.notifyColorChange();
		listeners.firePropertyChange(PROPERTY_COLOR,null,getName2());

	}

	public HInterfaceSlice getMappedToSlice() {
		return unit.getMappedToSlice();
	}

	public void setMappedToSlice(HInterfaceSlice mapped_to_slice) {
		unit.setMappedToSlice(mapped_to_slice);
	}

	public void adviceChangingPorts() {
		unit.adviceChangingPorts();
		listeners.firePropertyChange(CHANGING_PORTS, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  

	}

	public boolean isRepetitive() {
		return unit.isRepetitive();
	}


	public PropertyChangeSupport getListeners() {
	    return listeners;	
	}
	
	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}


	public IComponent getComponent() {
		return unit.getComponent();
	}

	public IHUnit getAncestor() {
		return unit.getAncestor();
	}

	public void setAncestor(IHUnit unit) {
        unit.setAncestor(unit);

	}

	public boolean isEntry() {
		return unit.isEntry();
	}

	public void attachToInterface(HInterface i) {
		unit.attachToInterface(i);
		  listeners.firePropertyChange(PROPERTY_BOUNDS,null,this.getBounds());

	}

	public void detachFromInterface() {
		unit.detachFromInterface();
		getListeners().firePropertyChange(PROPERTY_BOUNDS,null,this.getBounds());

	}

	public boolean matchForAttachment(HHasExternalReferences i) {
		return unit.matchForAttachment(i);
	}

	public HLinkToInterface getLinkToInterface() {
		return unit.getLinkToInterface();
	}

	public void setLinkToInterface(HLinkToInterface linkToInterface) {
		unit.setLinkToInterface(linkToInterface);

	}

	public IInterface getInterface() {
		return unit.getInterface();
	}

	public boolean visibleInterface() {
		return unit.visibleInterface();
	}

	public void showInterface() {
        unit.showInterface();
		listeners.firePropertyChange(INTERFACE_SHOW, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  
	}

	public void hideInterface() {
		unit.hideInterface(); 
		listeners.firePropertyChange(INTERFACE_HIDE, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  
	}

	public void setInterface(HInterface which_interface) {
		unit.setInterface(which_interface);

	}

	public List<IHPrimUnit> getClones() {
		List<IHPrimUnit> ucs = new ArrayList<IHPrimUnit>();
			// return unit.getClones();
		ucs.add(this);
		
		return ucs; 
	}
	
	
	public HPrimUnit createReplica(int i) {
		return unit.createReplica(i);
	}


	public void setHiddenSlices(boolean h) {
		unit.setHiddenSlices(h);
		listeners.firePropertyChange(PROPERTY_HIDDEN_SLICES, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  

	}

	public boolean getHiddenSlices() {
		return unit.getHiddenSlices();
	}
	
	public void removeStub()
	{
		for (HBinding b : this.getBindings()) {
     	    b.getEntry().unsetBinding();
		}
		
	    this.configuration.unlinkUnit((IHUnit)this);	    
	}
	
	public HBinding getBinding() {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		if (this.internalBinding) return this.bindings.get(0);
		else return unit.getBinding();
	}

	public List<HBinding> getBindings() {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		if (this.internalBinding) return this.bindings;
		else return unit.getBindings();
	}
	
	public void setBinding(HBinding binding) {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		if (this.internalBinding) { 
			this.bindings.clear();
			this.bindings.add(binding) ; 
		}
		else unit.setBinding(binding);
	    this.getListeners().firePropertyChange(BINDING_CREATE_SOURCE, null, binding); //$NON-NLS-2$//$NON-NLS-1$	
	}

	public void addBinding(HBinding binding) {
		if (bindings == null) this.bindings = new ArrayList<HBinding>();
		if (this.internalBinding) this.bindings.add(binding) ; 
		else unit.addBinding(binding);
	    this.getListeners().firePropertyChange(BINDING_CREATE_SOURCE, null, binding); //$NON-NLS-2$//$NON-NLS-1$	
	}
	
	public void unsetBinding() {
		if (this.internalBinding) this.bindings = new ArrayList<HBinding>(); 
		else unit.unsetBinding();
		this.getListeners().firePropertyChange(BINDING_CREATE_SOURCE, null, "unbind"); //$NON-NLS-2$//$NON-NLS-1$	

	}
	
	List<HBinding> bindings = null;
	boolean internalBinding = false;

	public void setInternalBinding(boolean internalBinding) {
		this.internalBinding = internalBinding;
	}
	
	public HPrimUnit getTopUnit(Map<HPrimUnit,Integer> path) {

		return this.unit.getTopUnit(null);
	}
	
	public boolean isNewNameValid(String name) {
		return this.unit.isNewNameValid(null);
	}

	
    
}
